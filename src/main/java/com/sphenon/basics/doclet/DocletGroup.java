package com.sphenon.basics.doclet;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.encoding.*;
import com.sphenon.basics.locating.*;

import java.util.Vector;

public interface DocletGroup extends DocletContainer, DocletItem {

    public Vector<Doclet> getDoclets(CallContext context);

    public Vector<Doclet> getDoclets(CallContext context, DocletFilter doclet_filter);

    public Vector<DocletGroup> getSubEntityDoclets(CallContext context);

    public String getEntity(CallContext context);

    public String getEntityType(CallContext context);

    public String getEntityVersion(CallContext context);

    /**
       Get security class of this doclet group. Specifies who is authorised to
       access this doclet in which way.

       @return List of vertical-slash-separated security class strings, usable
               in conjunction with an {@link Authority}
     */
    public String getSecurityClass(CallContext context);

    /**
       Describes who this doclet may concern, who is able to understand it's
       content, or who may be interested in it.

       @return List of vertical-slash-separated audience classifier names.
     */
    public String getAudience(CallContext context);

    /**
       Describes how this doclet group should be layouted.

       @return List of vertical-slash-separated form classifier names.
     */
    public String getLayout(CallContext context);
    // Parts|Single
    // whether in a single webpage or whether on multiple pages

    /**
       The Entity locator as an object

       @return The locator object
     */
    public Locator getEntityLocator(CallContext context);

    public Vector<String> getEntityLocatorPath(CallContext context);

    // returns last entry of EntityLocatorPath
    public String getId(CallContext context);
}
