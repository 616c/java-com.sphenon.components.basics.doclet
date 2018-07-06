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
import com.sphenon.basics.accessory.classes.*;

import com.sphenon.basics.doclet.*;

public class Class_Doclet extends Class_MonitorableCoreObject implements Doclet /* extends Class_DocletBase */ {

    protected String docbook;

    public String getDocBook (CallContext context) {
        return this.docbook;
    }

    public void setDocBook (CallContext context, String docbook) {
        this.docbook = docbook;
    }

    public Class_Doclet (CallContext context, String docbook) {
        // super(context);
        this.docbook = docbook;
    }

    protected String doclet_type;

    public String getDocletType(CallContext context) {
        return this.doclet_type;
    }

    public void setDocletType(CallContext context, String doclet_type) {
        this.doclet_type = doclet_type;
    }

    protected String security_class;

    public String getSecurityClass(CallContext context) {
        return this.security_class;
    }

    public void setSecurityClass(CallContext context, String security_class) {
        this.security_class = security_class;
    }

    protected String audience;

    public String getAudience(CallContext context) {
        return this.audience;
    }

    public void setAudience(CallContext context, String audience) {
        this.audience = audience;
    }

    protected String language;

    public String getLanguage (CallContext context) {
        return this.language;
    }

    public void setLanguage (CallContext context, String language) {
        this.language = language;
    }

    protected String intent;

    public String getIntent(CallContext context) {
        return this.intent;
    }

    public void setIntent(CallContext context, String intent) {
        this.intent = intent;
    }

    protected String extent;

    public String getExtent(CallContext context) {
        return this.extent;
    }

    public void setExtent(CallContext context, String extent) {
        this.extent = extent;
    }

    protected String coverage;

    public String getCoverage (CallContext context) {
        return this.coverage;
    }

    public void setCoverage (CallContext context, String coverage) {
        this.coverage = coverage;
    }

    protected String maturity;

    public String getMaturity(CallContext context) {
        return this.maturity;
    }

    public void setMaturity(CallContext context, String maturity) {
        this.maturity = maturity;
    }

    protected String form;

    public String getForm(CallContext context) {
        return this.form;
    }

    public void setForm(CallContext context, String form) {
        this.form = form;
    }

    protected String layout;

    public String getLayout(CallContext context) {
        return this.layout;
    }

    public void setLayout(CallContext context, String layout) {
        this.layout = layout;
    }

    protected Encoding encoding;

    public Encoding getEncoding(CallContext context) {
        return this.encoding;
    }

    public void setEncoding(CallContext context, Encoding encoding) {
        this.encoding = encoding;
    }

    protected String aspect;

    public String getAspect(CallContext context) {
        return this.aspect;
    }

    public void setAspect(CallContext context, String aspect) {
        this.aspect = aspect;
    }

    protected String entity;

    public String getEntity (CallContext context) {
        return this.entity;
    }

    public void setEntity (CallContext context, String entity) {
        this.entity = entity;
    }

    protected String entity_type;

    public String getEntityType (CallContext context) {
        return this.entity_type;
    }

    public void setEntityType (CallContext context, String entity_type) {
        this.entity_type = entity_type;
    }

    protected String entity_version;

    public String getEntityVersion (CallContext context) {
        return this.entity_version;
    }

    public void setEntityVersion (CallContext context, String entity_version) {
        this.entity_version = entity_version;
    }

    protected String doclet_version;

    public String getDocletVersion (CallContext context) {
        return this.doclet_version;
    }

    public void setDocletVersion (CallContext context, String doclet_version) {
        this.doclet_version = doclet_version;
    }
}

