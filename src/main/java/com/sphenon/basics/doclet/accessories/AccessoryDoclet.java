package com.sphenon.basics.doclet.accessories;

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
import com.sphenon.basics.accessory.*;

import com.sphenon.basics.doclet.*;

public class AccessoryDoclet implements Accessory {

    protected Doclet             doclet;
    // protected DataSource_Doclet_ data_source_doclet;

    public Doclet getDoclet (CallContext context) {
        return this.doclet;
        // return (this.doclet != null ? this.doclet : this.data_source_doclet != null ? this.data_source_doclet.get(context) : null);
    }

    public void setDoclet (CallContext context, Doclet doclet) {
        this.doclet             = doclet;
        // this.data_source_doclet = null;
    }

//     public void setDataSourceDoclet (CallContext context, DataSource_Doclet_ data_source_doclet) {
//         this.doclet             = null;
//         this.data_source_doclet = data_source_doclet;
//     }

    public AccessoryDoclet (CallContext context, Doclet doclet) {
        this.doclet             = doclet;
        // this.data_source_doclet = null;
    }

//     public AccessoryDoclet (CallContext context, DataSource_Doclet_ data_source_doclet) {
//         this.doclet             = null;
//         this.data_source_doclet = data_source_doclet;
//     }
}
