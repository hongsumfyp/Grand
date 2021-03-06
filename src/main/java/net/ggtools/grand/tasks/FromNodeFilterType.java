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

package net.ggtools.grand.tasks;

import net.ggtools.grand.filters.FromNodeFilter;
import net.ggtools.grand.filters.GraphFilter;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 * Ant frontend to {@link net.ggtools.grand.filters.FromNodeFilter}.
 *
 * @author Christophe Labouisse
 */
public class FromNodeFilterType implements GraphFilterType {

    /**
     * Field nodeName.
     */
    private String nodeName;
    /**
     * Field project.
     */
    private final Project project;

    /**
     * Creates a new filter.
     *
     * @param antProject owner's project.
     */
    public FromNodeFilterType(final Project antProject) {
        project = antProject;
    }

    /**
     * Method checkParameters.
     * @see net.ggtools.grand.tasks.GraphFilterType#checkParameters()
     */
    public final void checkParameters() {
        if (nodeName == null) {
            final String message = "required attribute missing";
            project.log(message, Project.MSG_ERR);
            throw new BuildException(message);
        }
    }

    /**
     * Method getFilter.
     * @return GraphFilter
     * @see net.ggtools.grand.tasks.GraphFilterType#getFilter()
     */
    public final GraphFilter getFilter() {
        return new FromNodeFilter(nodeName);
    }

    /**
     * Method setNodeName.
     * @param name String
     * @see net.ggtools.grand.tasks.GraphFilterType#setNodeName(java.lang.String)
     */
    public final void setNodeName(final String name) {
        nodeName = name;
    }

}
