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

package com.tle.core.usermanagement.standard.service;

import com.tle.beans.user.TLEUser;
import com.tle.core.remoting.RemoteTLEUserService;
import java.util.Collection;
import java.util.List;

public interface TLEUserService extends RemoteTLEUserService {
  boolean checkPasswordMatch(TLEUser user, String password);

  void validatePassword(String password, boolean passwordNotHashed);

  List<TLEUser> getInformationForUsers(Collection<String> ids);

  String edit(
      String uuid, String username, String password, String first, String last, String email);

  String editSelf(TLEUser user, boolean passwordNotHashed);

  void validate(TLEUser user, boolean passwordNotHashed);

  String prepareQuery(String query);
}
