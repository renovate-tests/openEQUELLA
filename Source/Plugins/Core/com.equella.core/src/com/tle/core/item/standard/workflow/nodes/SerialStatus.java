/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * The Apereo Foundation licenses this file to you under the Apache License,
 * Version 2.0, (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tle.core.item.standard.workflow.nodes;

import com.tle.common.workflow.WorkflowNodeStatus;
import com.tle.common.workflow.node.WorkflowNode;
import com.tle.common.workflow.node.WorkflowTreeNode;
import com.tle.core.item.NodeStatus;
import com.tle.core.item.standard.operations.workflow.TaskOperation;

public class SerialStatus extends AbstractNodeStatus {
  public SerialStatus(WorkflowNodeStatus bean, TaskOperation op) {
    super(bean, op);
  }

  @Override
  public boolean update() {
    WorkflowTreeNode treenode = (WorkflowTreeNode) node;
    int num = treenode.numberOfChildren();
    for (int i = 0; i < num; i++) {
      WorkflowNode child = treenode.getChild(i);
      NodeStatus childStatus = op.getNodeStatus(child.getUuid());
      if (childStatus == null) {
        op.enter(child);
        return false;
      }

      if (childStatus.getStatus() == WorkflowNodeStatus.INCOMPLETE) {
        return false;
      }
    }
    return finished();
  }

  @Override
  public void enter() {
    bean.setStatus(WorkflowNodeStatus.INCOMPLETE);
    update();
  }
}
