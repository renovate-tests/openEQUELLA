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

package com.tle.web.viewitem.summary.sidebar.actions;

import com.tle.beans.item.ItemStatus;
import com.tle.beans.workflow.WorkflowStatus;
import com.tle.core.guice.Bind;
import com.tle.core.item.standard.ItemOperationFactory;
import com.tle.web.sections.SectionInfo;
import com.tle.web.sections.equella.annotation.PlugKey;
import com.tle.web.sections.render.Label;
import com.tle.web.viewurl.ItemSectionInfo;
import javax.inject.Inject;

@SuppressWarnings("nls")
@Bind
public class MakeLiveSection extends GenericMinorActionSection {
  @PlugKey("summary.sidebar.actions.makelive.title")
  private static Label LINK_LABEL;

  @PlugKey("summary.sidebar.actions.makelive.receipt")
  private static Label RECEIPT_LABEL;

  @Inject private ItemOperationFactory workflowFactory;

  @Override
  protected Label getLinkLabel() {
    return LINK_LABEL;
  }

  @Override
  protected boolean canView(SectionInfo info, ItemSectionInfo itemInfo, WorkflowStatus status) {
    return itemInfo.hasPrivilege("ARCHIVE_ITEM")
        && status.getStatusName().equals(ItemStatus.ARCHIVED);
  }

  @Override
  protected void execute(SectionInfo info) {
    getItemInfo(info).modify(workflowFactory.reactivate());
    setReceipt(RECEIPT_LABEL);
  }

  @Override
  public String getLinkText() {
    return LINK_LABEL.getText();
  }
}
