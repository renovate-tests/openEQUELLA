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

package com.tle.core.harvester.oai.data;

/** */
public class ResumptionToken {
  private int completeListSize;
  private int cursor;
  private String token;

  public int getCompleteListSize() {
    return completeListSize;
  }

  public void setCompleteListSize(int completeListSize) {
    this.completeListSize = completeListSize;
  }

  public int getCursor() {
    return cursor;
  }

  public void setCursor(int cursor) {
    this.cursor = cursor;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
