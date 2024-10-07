package com.sphenon.basics.doclet;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

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

import com.sphenon.ui.annotations.*;

import java.util.Vector;

@UIName       ("js:instance.getId(context)+' - '+instance.getName(context)")
@UIClassifier ("DocletPackage")
@UIParts      ( { "js:instance.getGroups(context)",
                  "js:instance.getPackages(context)"
                } )
public interface DocletPackage extends DocletContainer, DocletItem {

    public String                getId(CallContext context);

    public String                getName(CallContext context);

    public String                getDescription(CallContext context);

    public Vector<DocletGroup>   getGroups(CallContext context);

    public Vector<DocletGroup>   getGroups(CallContext context, DocletFilter doclet_filter);

    public Vector<DocletPackage> getPackages(CallContext context);

    public Vector<DocletPackage> getPackages(CallContext context, DocletFilter doclet_filter);

    public Vector<DocletContainer> getEntries(CallContext context);

    public Vector<DocletContainer> getEntries(CallContext context, DocletFilter doclet_filter);

    public DocletGroup           getGroupById(CallContext context, String id);

    public DocletPackage         getPackageById(CallContext context, String id);

    public void                  addGroup(CallContext context, DocletGroup doclet_group);

    public void                  addPackage(CallContext context, DocletPackage doclet_package);

    public boolean               isEmpty(CallContext context);

    public boolean               isEmpty(CallContext context, DocletFilter doclet_filter);
}
