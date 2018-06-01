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

package org.shoal.test.command;

import org.shoal.ha.cache.api.DataStoreContext;
import org.shoal.ha.cache.api.DataStoreException;
import org.shoal.ha.cache.impl.command.Command;
import org.shoal.ha.cache.impl.util.ReplicationInputStream;
import org.shoal.ha.cache.impl.util.ReplicationOutputStream;

import java.io.IOException;

/**
 * @author Mahesh Kannan
 */
public class NoopCommand
    extends Command {

    public NoopCommand() {
        super((byte) 123);
        super.setKey("Noop" + System.identityHashCode(this));
    }

    protected boolean beforeTransmit() {
        return true;
    }

    @Override
    public void execute(String initiator) {
        System.out.println("***>> Executed Noop command");
    }
}
