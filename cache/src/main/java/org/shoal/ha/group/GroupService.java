/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.shoal.ha.group;

import java.util.List;

import org.shoal.ha.cache.impl.util.MessageReceiver;

/**
 * The minimal methods that a GS must implement to be used by the replication service.
 *
 * @author Mahesh Kannan
 */
public interface GroupService {

    String getGroupName();

    String getMemberName();

    List<String> getCurrentCoreMembers();

    void registerGroupMemberEventListener(GroupMemberEventListener listener);

    void removeGroupMemberEventListener(GroupMemberEventListener listener);

    void close();

    void registerGroupMessageReceiver(String messageToken, MessageReceiver receiver);

    boolean sendMessage(String targetMemberName, String messageToken, byte[] data);

}
