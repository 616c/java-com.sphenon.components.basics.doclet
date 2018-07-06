package com.sphenon.basics.worklet.factories;

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

import com.sphenon.basics.worklet.*;
import com.sphenon.basics.worklet.classes.*;

public class Factory_Worklet {

    protected String docbook;

    public String getDocBook (CallContext context) {
        return this.docbook;
    }

    public void setDocBook (CallContext context, String docbook) {
        this.docbook = docbook;
    }

    public Worklet create(CallContext context) {
        Class_Worklet worklet = new Class_Worklet(context, this.docbook);

        worklet.setWorkletType(context, this.getWorkletType(context));
        worklet.setWorkletVersion(context, this.getWorkletVersion(context));

        return worklet;
    }

    protected String worklet_type;

    public String getWorkletType(CallContext context) {
        return this.worklet_type;
    }

    public String defaultWorkletType(CallContext context) {
        return null;
    }

    public void setWorkletType(CallContext context, String worklet_type) {
        this.worklet_type = worklet_type;
    }

    protected String worklet_version;

    public String getWorkletVersion (CallContext context) {
        return this.worklet_version;
    }

    public String defaultWorkletVersion (CallContext context) {
        return "";
    }

    public void setWorkletVersion (CallContext context, String worklet_version) {
        this.worklet_version = worklet_version;
    }
}
