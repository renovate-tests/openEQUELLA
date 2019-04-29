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

package com.tle.common;

/** @author Nicholas Read */
public class NameValue extends Pair<String, String> {
  private static final long serialVersionUID = 1;

  public NameValue() {
    super();
  }

  public NameValue(String name, String value) {
    super(name, value);
  }

  public String getName() {
    return getFirst();
  }

  public void setName(String name) {
    setFirst(name);
  }

  public String getLabel() {
    return getName();
  }

  public void setLabel(String label) {
    setName(label);
  }

  public String getValue() {
    return getSecond();
  }

  public void setValue(String value) {
    setSecond(value);
  }

  @Override
  public boolean checkFields(Pair<String, String> rhs) {
    // Only check the value of this object type
    return Check.bothNullOrEqual(rhs.getSecond(), getSecond());
  }
}
