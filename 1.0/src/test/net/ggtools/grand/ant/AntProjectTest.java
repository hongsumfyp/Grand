// $Id$
/* ====================================================================
 * Copyright (c) 2002-2003, Christophe Labouisse
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above
 *    copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.ggtools.grand.ant;

import net.ggtools.grand.utils.AbstractAntTester;

/**
 * 
 * 
 * @author Christophe Labouisse
 */
public class AntProjectTest extends AbstractAntTester {

    /**
     * Constructor for AntProjectTest.
     * @param arg0
     */
    public AntProjectTest(String arg0) {
        super(arg0);
    }

    /* (non-Javadoc)
     * @see net.ggtools.grand.utils.AbstractAntTester#getTestBuildFileName()
     */
    protected String getTestBuildFileName() {
        return TESTCASES_DIR + "ant-project-test.xml";
    }

    /**
     * Run a graph on a file including an antcall whose target is based on a property.
     * 
     * @throws IOException
     */
    public void testAntCallWithUndefinedProperty() {
        expectLogContaining("ant-call-with-property", "Outputing to ");
        assertLogContaining("Target antcall-props-1 has dependency to non existent target ${antcall.target}, creating a dummy node");
        assertLogContaining("Target antcall-props-2 has dependency to non existent target do-${antcall.target}, creating a dummy node");
    }
    
    /**
     * Run a graph on a file including an undefined task.
     * 
     * @throws IOException
     */
    public void testAntCallWithUndefinedTask() {
        //TODO Check if this test is useful.
        expectLogContaining("undefined-task", "Outputing to ");
    }

}