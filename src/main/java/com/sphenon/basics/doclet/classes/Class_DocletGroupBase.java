package com.sphenon.basics.doclet.classes;

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
import com.sphenon.basics.accessory.*;
import com.sphenon.basics.accessory.classes.*;
import com.sphenon.basics.locating.*;
import com.sphenon.basics.locating.factories.*;
import com.sphenon.basics.locating.returncodes.*;
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.validation.*;
import com.sphenon.basics.validation.returncodes.*;

import com.sphenon.basics.doclet.*;

import java.util.Vector;

abstract public class Class_DocletGroupBase extends Class_MonitorableCoreObject implements DocletGroup {

    public Class_DocletGroupBase (CallContext context) {
    }

    abstract public Vector<DocletGroup> getSubEntityDoclets(CallContext context);

    abstract public Vector<Doclet> getDoclets(CallContext context);

    public Vector<Doclet> getDoclets(CallContext context, DocletFilter doclet_filter) {
        return doclet_filter.filterDoclets(context, this.getDoclets(context));
    }

    protected Locator entity_locator;

    public Locator getEntityLocator(CallContext context) {
        if (this.entity_locator == null) {
            if (this.getEntity(context) == null) {
                this.addProblemStatus(context, ProblemState.ERROR, CustomaryContext.create((Context)context).createPreConditionViolation(context, "No Entity locator defined"));
                return null;
            }
            try {
                this.entity_locator = Factory_Locator.construct(context, this.getEntity(context), true);
            } catch (ValidationFailure vf) {
                this.addProblemStatus(context, ProblemState.ERROR, CustomaryContext.create((Context)context).createPreConditionViolation(context, vf, "Entity locator '%(locator)' is invalid", "locator", this.getEntity(context)));
                return null;
            }
        }
        return this.entity_locator;
    }

    protected Vector<String> entity_locator_path;

    public Vector<String> getEntityLocatorPath(CallContext context) {
        if (this.entity_locator_path == null) {
            if (this.getEntityLocator(context) == null) {
                return null;
            }
            try {
                this.entity_locator_path = this.getEntityLocator(context).getPathParts(context);
            } catch (InvalidLocator il) {
                this.addProblemStatus(context, ProblemState.ERROR, CustomaryContext.create((Context)context).createPreConditionViolation(context, il, "Entity locator '%(locator)' is invalid", "locator", this.getEntity(context)));
                return null;
            }
        }
        return this.entity_locator_path;
    }

    public String getId(CallContext context) {
        Vector<String> elp = this.getEntityLocatorPath(context);
        return elp == null || elp.size() == 0 ? null : (elp.get(elp.size()-1));
    }

    public String getIndex(CallContext context) {
        return "";
    }
}

