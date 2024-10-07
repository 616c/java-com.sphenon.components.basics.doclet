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
import com.sphenon.basics.quantities.*;
import com.sphenon.basics.variatives.classes.*;

import java.util.Vector;

public class DocletFilter {

    static protected boolean debug = false;

    public DocletFilter (CallContext context) {
        this.parent_filter = null;
    }

    protected DocletFilter parent_filter;

    public DocletFilter (CallContext context, DocletFilter parent_filter) {
        this.parent_filter = parent_filter;
    }

    protected String entity_include_regexp;

    public String getEntityIncludeRegExp (CallContext context) {
        return this.entity_include_regexp;
    }

    public String defaultEntityIncludeRegExp (CallContext context) {
        return null;
    }

    public void setEntityIncludeRegExp (CallContext context, String entity_include_regexp) {
        this.entity_include_regexp = entity_include_regexp;
    }

    protected String entity_exclude_regexp;

    public String getEntityExcludeRegExp (CallContext context) {
        return this.entity_exclude_regexp;
    }

    public String defaultEntityExcludeRegExp (CallContext context) {
        return null;
    }

    public void setEntityExcludeRegExp (CallContext context, String entity_exclude_regexp) {
        this.entity_exclude_regexp = entity_exclude_regexp;
    }

    protected String doclet_type_include_regexp;

    public String getDocletTypeIncludeRegExp (CallContext context) {
        return this.doclet_type_include_regexp;
    }

    public String defaultDocletTypeIncludeRegExp (CallContext context) {
        return null;
    }

    public void setDocletTypeIncludeRegExp (CallContext context, String doclet_type_include_regexp) {
        this.doclet_type_include_regexp = doclet_type_include_regexp;
    }

    protected String doclet_type_exclude_regexp;

    public String getDocletTypeExcludeRegExp (CallContext context) {
        return this.doclet_type_exclude_regexp;
    }

    public String defaultDocletTypeExcludeRegExp (CallContext context) {
        return null;
    }

    public void setDocletTypeExcludeRegExp (CallContext context, String doclet_type_exclude_regexp) {
        this.doclet_type_exclude_regexp = doclet_type_exclude_regexp;
    }

    protected String aspect_include_regexp;

    public String getAspectIncludeRegExp (CallContext context) {
        return this.aspect_include_regexp;
    }

    public String defaultAspectIncludeRegExp (CallContext context) {
        return null;
    }

    public void setAspectIncludeRegExp (CallContext context, String aspect_include_regexp) {
        this.aspect_include_regexp = aspect_include_regexp;
    }

    protected String aspect_exclude_regexp;

    public String getAspectExcludeRegExp (CallContext context) {
        return this.aspect_exclude_regexp;
    }

    public String defaultAspectExcludeRegExp (CallContext context) {
        return null;
    }

    public void setAspectExcludeRegExp (CallContext context, String aspect_exclude_regexp) {
        this.aspect_exclude_regexp = aspect_exclude_regexp;
    }

    protected String language_selector;

    public String getLanguageSelector (CallContext context) {
        return this.language_selector;
    }

    public String defaultLanguageSelector (CallContext context) {
        return null;
    }

    public void setLanguageSelector (CallContext context, String language_selector) {
        this.language_selector = language_selector;
    }

    protected String language_include_regexp;

    public String getLanguageIncludeRegExp (CallContext context) {
        return this.language_include_regexp;
    }

    public String defaultLanguageIncludeRegExp (CallContext context) {
        return null;
    }

    public void setLanguageIncludeRegExp (CallContext context, String language_include_regexp) {
        this.language_include_regexp = language_include_regexp;
    }

    protected String language_exclude_regexp;

    public String getLanguageExcludeRegExp (CallContext context) {
        return this.language_exclude_regexp;
    }

    public String defaultLanguageExcludeRegExp (CallContext context) {
        return null;
    }

    public void setLanguageExcludeRegExp (CallContext context, String language_exclude_regexp) {
        this.language_exclude_regexp = language_exclude_regexp;
    }

    protected String security_class_include_regexp;

    public String getSecurityClassIncludeRegExp (CallContext context) {
        return this.security_class_include_regexp;
    }

    public String defaultSecurityClassIncludeRegExp (CallContext context) {
        return null;
    }

    public void setSecurityClassIncludeRegExp (CallContext context, String security_class_include_regexp) {
        this.security_class_include_regexp = security_class_include_regexp;
    }

    protected String security_class_exclude_regexp;

    public String getSecurityClassExcludeRegExp (CallContext context) {
        return this.security_class_exclude_regexp;
    }

    public String defaultSecurityClassExcludeRegExp (CallContext context) {
        return null;
    }

    public void setSecurityClassExcludeRegExp (CallContext context, String security_class_exclude_regexp) {
        this.security_class_exclude_regexp = security_class_exclude_regexp;
    }

    protected String audience_include_regexp;

    public String getAudienceIncludeRegExp (CallContext context) {
        return this.audience_include_regexp;
    }

    public String defaultAudienceIncludeRegExp (CallContext context) {
        return null;
    }

    public void setAudienceIncludeRegExp (CallContext context, String audience_include_regexp) {
        this.audience_include_regexp = audience_include_regexp;
    }

    protected String audience_exclude_regexp;

    public String getAudienceExcludeRegExp (CallContext context) {
        return this.audience_exclude_regexp;
    }

    public String defaultAudienceExcludeRegExp (CallContext context) {
        return null;
    }

    public void setAudienceExcludeRegExp (CallContext context, String audience_exclude_regexp) {
        this.audience_exclude_regexp = audience_exclude_regexp;
    }

    protected String intent_include_regexp;

    public String getIntentIncludeRegExp (CallContext context) {
        return this.intent_include_regexp;
    }

    public String defaultIntentIncludeRegExp (CallContext context) {
        return null;
    }

    public void setIntentIncludeRegExp (CallContext context, String intent_include_regexp) {
        this.intent_include_regexp = intent_include_regexp;
    }

    protected String intent_exclude_regexp;

    public String getIntentExcludeRegExp (CallContext context) {
        return this.intent_exclude_regexp;
    }

    public String defaultIntentExcludeRegExp (CallContext context) {
        return null;
    }

    public void setIntentExcludeRegExp (CallContext context, String intent_exclude_regexp) {
        this.intent_exclude_regexp = intent_exclude_regexp;
    }

    protected String extent_include_regexp;

    public String getExtentIncludeRegExp (CallContext context) {
        return this.extent_include_regexp;
    }

    public String defaultExtentIncludeRegExp (CallContext context) {
        return null;
    }

    public void setExtentIncludeRegExp (CallContext context, String extent_include_regexp) {
        this.extent_include_regexp = extent_include_regexp;
    }

    protected String extent_exclude_regexp;

    public String getExtentExcludeRegExp (CallContext context) {
        return this.extent_exclude_regexp;
    }

    public String defaultExtentExcludeRegExp (CallContext context) {
        return null;
    }

    public void setExtentExcludeRegExp (CallContext context, String extent_exclude_regexp) {
        this.extent_exclude_regexp = extent_exclude_regexp;
    }

    protected String coverage_include_regexp;

    public String getCoverageIncludeRegExp (CallContext context) {
        return this.coverage_include_regexp;
    }

    public String defaultCoverageIncludeRegExp (CallContext context) {
        return null;
    }

    public void setCoverageIncludeRegExp (CallContext context, String coverage_include_regexp) {
        this.coverage_include_regexp = coverage_include_regexp;
    }

    protected String coverage_exclude_regexp;

    public String getCoverageExcludeRegExp (CallContext context) {
        return this.coverage_exclude_regexp;
    }

    public String defaultCoverageExcludeRegExp (CallContext context) {
        return null;
    }

    public void setCoverageExcludeRegExp (CallContext context, String coverage_exclude_regexp) {
        this.coverage_exclude_regexp = coverage_exclude_regexp;
    }

    protected String maturity_include_regexp;

    public String getMaturityIncludeRegExp (CallContext context) {
        return this.maturity_include_regexp;
    }

    public String defaultMaturityIncludeRegExp (CallContext context) {
        return null;
    }

    public void setMaturityIncludeRegExp (CallContext context, String maturity_include_regexp) {
        this.maturity_include_regexp = maturity_include_regexp;
    }

    protected String maturity_exclude_regexp;

    public String getMaturityExcludeRegExp (CallContext context) {
        return this.maturity_exclude_regexp;
    }

    public String defaultMaturityExcludeRegExp (CallContext context) {
        return null;
    }

    public void setMaturityExcludeRegExp (CallContext context, String maturity_exclude_regexp) {
        this.maturity_exclude_regexp = maturity_exclude_regexp;
    }

    protected String form_include_regexp;

    public String getFormIncludeRegExp (CallContext context) {
        return this.form_include_regexp;
    }

    public String defaultFormIncludeRegExp (CallContext context) {
        return null;
    }

    public void setFormIncludeRegExp (CallContext context, String form_include_regexp) {
        this.form_include_regexp = form_include_regexp;
    }

    protected String form_exclude_regexp;

    public String getFormExcludeRegExp (CallContext context) {
        return this.form_exclude_regexp;
    }

    public String defaultFormExcludeRegExp (CallContext context) {
        return null;
    }

    public void setFormExcludeRegExp (CallContext context, String form_exclude_regexp) {
        this.form_exclude_regexp = form_exclude_regexp;
    }

    protected String encoding_include_regexp;

    public String getEncodingIncludeRegExp (CallContext context) {
        return this.encoding_include_regexp;
    }

    public String defaultEncodingIncludeRegExp (CallContext context) {
        return null;
    }

    public void setEncodingIncludeRegExp (CallContext context, String encoding_include_regexp) {
        this.encoding_include_regexp = encoding_include_regexp;
    }

    protected String encoding_exclude_regexp;

    public String getEncodingExcludeRegExp (CallContext context) {
        return this.encoding_exclude_regexp;
    }

    public String defaultEncodingExcludeRegExp (CallContext context) {
        return null;
    }

    public void setEncodingExcludeRegExp (CallContext context, String encoding_exclude_regexp) {
        this.encoding_exclude_regexp = encoding_exclude_regexp;
    }

    protected String entity_version_minimum;

    public String getEntityVersionMinimum (CallContext context) {
        return this.entity_version_minimum;
    }

    public String defaultEntityVersionMinimum (CallContext context) {
        return null;
    }

    public void setEntityVersionMinimum (CallContext context, String entity_version_minimum) {
        this.entity_version_minimum = entity_version_minimum;
    }

    protected String entity_version_maximum;

    public String getEntityVersionMaximum (CallContext context) {
        return this.entity_version_maximum;
    }

    public String defaultEntityVersionMaximum (CallContext context) {
        return null;
    }

    public void setEntityVersionMaximum (CallContext context, String entity_version_maximum) {
        this.entity_version_maximum = entity_version_maximum;
    }

    protected String doclet_version_minimum;

    public String getDocletVersionMinimum (CallContext context) {
        return this.doclet_version_minimum;
    }

    public String defaultDocletVersionMinimum (CallContext context) {
        return null;
    }

    public void setDocletVersionMinimum (CallContext context, String doclet_version_minimum) {
        this.doclet_version_minimum = doclet_version_minimum;
    }

    protected String doclet_version_maximum;

    public String getDocletVersionMaximum (CallContext context) {
        return this.doclet_version_maximum;
    }

    public String defaultDocletVersionMaximum (CallContext context) {
        return null;
    }

    public void setDocletVersionMaximum (CallContext context, String doclet_version_maximum) {
        this.doclet_version_maximum = doclet_version_maximum;
    }

    protected String entity_type_include_regexp;

    public String getEntityTypeIncludeRegExp (CallContext context) {
        return this.entity_type_include_regexp;
    }

    public String defaultEntityTypeIncludeRegExp (CallContext context) {
        return null;
    }

    public void setEntityTypeIncludeRegExp (CallContext context, String entity_type_include_regexp) {
        this.entity_type_include_regexp = entity_type_include_regexp;
    }

    protected String entity_type_exclude_regexp;

    public String getEntityTypeExcludeRegExp (CallContext context) {
        return this.entity_type_exclude_regexp;
    }

    public String defaultEntityTypeExcludeRegExp (CallContext context) {
        return null;
    }

    public void setEntityTypeExcludeRegExp (CallContext context, String entity_type_exclude_regexp) {
        this.entity_type_exclude_regexp = entity_type_exclude_regexp;
    }

    protected boolean hide_empty_folders;

    public boolean getHideEmptyFolders (CallContext context) {
        return this.hide_empty_folders;
    }

    public boolean defaultHideEmptyFolders (CallContext context) {
        return false;
    }

    public void setHideEmptyFolders (CallContext context, boolean hide_empty_folders) {
        this.hide_empty_folders = hide_empty_folders;
    }

    public boolean matches (CallContext context, Doclet doclet) {
        if (debug) { System.err.println("Checking Doclet " + com.sphenon.basics.tracking.classes.Class_OriginAware.dumpOrigin(context, doclet) + " ..."); }
        if (this.parent_filter != null) {
            if (debug) { System.err.println("checking with parent filter..."); }
            if (this.parent_filter.matches(context, doclet) == false) {
                return false;
            }
            if (debug) { System.err.println("parent filter ok"); }
        }
        {
            String entity = doclet.getEntity(context) == null ? null : doclet.getEntity(context).toString();
            if (entity == null) { entity = ""; }
            if (entity_include_regexp != null) {
                if (entity.matches(entity_include_regexp) == false) { if (debug) { System.err.println("no match: Entity include"); } return false; }
            }
            if (entity_exclude_regexp != null) {
                if (entity.matches(entity_exclude_regexp) == true) { if (debug) { System.err.println("no match: Entity exclude"); } return false; }
            }
        }
        {
            String doclet_type = doclet.getDocletType(context);
            if (doclet_type == null) { doclet_type = ""; }
            if (doclet_type_include_regexp != null) {
                if (doclet_type.matches(doclet_type_include_regexp) == false) { if (debug) { System.err.println("no match: DocletType include"); } return false; }
            }
            if (doclet_type_exclude_regexp != null) {
                if (doclet_type.matches(doclet_type_exclude_regexp) == true) { if (debug) { System.err.println("no match: DocletType exclude"); } return false; }
            }
        }
        {
            String aspect = doclet.getAspect(context);
            if (aspect == null) { aspect = ""; }
            if (aspect_include_regexp != null) {
                if (aspect.matches(aspect_include_regexp) == false) { if (debug) { System.err.println("no match: Aspect include"); } return false; }
            }
            if (aspect_exclude_regexp != null) {
                if (aspect.matches(aspect_exclude_regexp) == true) { if (debug) { System.err.println("no match: Aspect exclude"); } return false; }
            }
        }
        {
            String language = doclet.getLanguage(context);
            if (language == null) { language = ""; }
            if (language_include_regexp != null) {
                if (language.matches(language_include_regexp) == false) { if (debug) { System.err.println("no match: Language include"); } return false; }
            }
            if (language_exclude_regexp != null) {
                if (language.matches(language_exclude_regexp) == true) { if (debug) { System.err.println("no match: Language exclude"); } return false; }
            }
            if (    language_selector != null && language_selector.isEmpty() == false
                 && language != null && language.isEmpty() == false
               ) {
                if (HumanLanguageVariantFinder.matches(context, language, language_selector) == false) { if (debug) { System.err.println("no match: Language selector"); } return false; }
            }
        }
        {
            String security_class_list = doclet.getSecurityClass(context);
            if (security_class_list == null) { security_class_list = "Default"; }
            boolean one_imatch = false;
            boolean one_ematch = false;
            for (String security_class : security_class_list.split("\\|")) {
                if (security_class_include_regexp != null) {
                    if (security_class.matches(security_class_include_regexp)) { one_imatch = true; }
                }
                if (security_class_exclude_regexp != null) {
                    if (security_class.matches(security_class_exclude_regexp)) { one_ematch = true; }
                }
            }
            if (one_imatch == false || one_ematch == true) { if (debug) { System.err.println("no match: SecurityClass " + security_class_list + " " + security_class_include_regexp + " " + security_class_exclude_regexp); } return false; }
        }
        {
            String audience_list = doclet.getAudience(context);
            if (audience_list == null) { audience_list = ""; }
            boolean one_imatch = (audience_include_regexp == null);
            boolean one_ematch = false;
            for (String audience : audience_list.split("\\|")) {
                if (audience_include_regexp != null) {
                    if (audience.matches(audience_include_regexp)) { one_imatch = true; }
                }
                if (audience_exclude_regexp != null) {
                    if (audience.matches(audience_exclude_regexp)) { one_ematch = true; }
                }
            }
            if (one_imatch == false || one_ematch == true) { if (debug) { System.err.println("no match: Audience"); } return false; }
        }
        {
            String intent_list = doclet.getIntent(context);
            if (intent_list == null) { intent_list = ""; }
            boolean one_imatch = (intent_include_regexp == null);
            boolean one_ematch = false;
            for (String intent : intent_list.split("\\|")) {
                if (intent_include_regexp != null) {
                    if (intent.matches(intent_include_regexp)) { one_imatch = true; }
                }
                if (intent_exclude_regexp != null) {
                    if (intent.matches(intent_exclude_regexp)) { one_ematch = true; }
                }
            }
            if (one_imatch == false || one_ematch == true) { if (debug) { System.err.println("no match: Intent"); } return false; }
        }
        {
            String extent = doclet.getExtent(context);
            if (extent == null) { extent = ""; }
            if (extent_include_regexp != null) {
                if (extent.matches(extent_include_regexp) == false) { if (debug) { System.err.println("no match: Extent include"); } return false; }
            }
            if (extent_exclude_regexp != null) {
                if (extent.matches(extent_exclude_regexp) == true) { if (debug) { System.err.println("no match: Extent exclude"); } return false; }
            }
        }
        {
            String coverage = doclet.getCoverage(context);
            if (coverage == null) { coverage = ""; }
            if (coverage_include_regexp != null) {
                if (coverage.matches(coverage_include_regexp) == false) { if (debug) { System.err.println("no match: Coverage include"); } return false; }
            }
            if (coverage_exclude_regexp != null) {
                if (coverage.matches(coverage_exclude_regexp) == true) { if (debug) { System.err.println("no match: Coverage exclude"); } return false; }
            }
        }
        {
            String maturity = doclet.getMaturity(context);
            if (maturity == null) { maturity = ""; }
            if (maturity_include_regexp != null) {
                if (maturity.matches(maturity_include_regexp) == false) { if (debug) { System.err.println("no match: Maturity include " + maturity + " does not match " + maturity_include_regexp+ " -- " + doclet.getDocletType(context)); } return false; }
            }
            if (maturity_exclude_regexp != null) {
                if (maturity.matches(maturity_exclude_regexp) == true) { if (debug) { System.err.println("no match: Maturity exclude"); } return false; }
            }
        }
        {
            String form_list = doclet.getForm(context);
            if (form_list == null) { form_list = ""; }
            boolean one_imatch = (form_include_regexp == null);
            boolean one_ematch = false;
            for (String form : form_list.split("\\|")) {
                if (form_include_regexp != null) {
                    if (form.matches(form_include_regexp)) { one_imatch = true; }
                }
                if (form_exclude_regexp != null) {
                    if (form.matches(form_exclude_regexp)) { one_ematch = true; }
                }
            }
            if (one_imatch == false || one_ematch == true) { if (debug) { System.err.println("no match: Form"); } return false; }
        }
        {
            String encoding = doclet.getEncoding(context) == null ? null : doclet.getEncoding(context).toString();
            if (encoding == null) { encoding = ""; }
            if (encoding_include_regexp != null) {
                if (encoding.matches(encoding_include_regexp) == false) { if (debug) { System.err.println("no match: Encoding include"); } return false; }
            }
            if (encoding_exclude_regexp != null) {
                if (encoding.matches(encoding_exclude_regexp) == true) { if (debug) { System.err.println("no match: Encoding exclude"); } return false; }
            }
        }
        {
            String entity_version = doclet.getEntityVersion(context);
            if (entity_version != null && entity_version.length() != 0) {
                VersionNumber vn = new VersionNumber(context, entity_version);
                if (entity_version_minimum != null) {
                    if (vn.compareTo(context, new VersionNumber(context, entity_version_minimum)) == 1) { if (debug) { System.err.println("no match: EntityVersion minimum"); } return false; }
                }
                if (entity_version_maximum != null) {
                    if (vn.compareTo(context, new VersionNumber(context, entity_version_maximum)) == -1) { if (debug) { System.err.println("no match: EntityVersion maximum"); } return false; }
                }
            }
        }
        {
            String doclet_version = doclet.getDocletVersion(context);
            if (doclet_version != null && doclet_version.length() != 0) {
                VersionNumber vn = new VersionNumber(context, doclet_version);
                if (doclet_version_minimum != null) {
                    if (vn.compareTo(context, new VersionNumber(context, doclet_version_minimum)) == 1) { if (debug) { System.err.println("no match: DocletVersion minimum"); } return false; }
                }
                if (doclet_version_maximum != null) {
                    if (vn.compareTo(context, new VersionNumber(context, doclet_version_maximum)) == -1) { if (debug) { System.err.println("no match: DocletVersion maximum"); } return false; }
                }
            }
        }
        {
            String entity_type = doclet.getEntityType(context);
            if (entity_type == null) { entity_type = ""; }
            if (entity_type_include_regexp != null) {
                if (entity_type.matches(entity_type_include_regexp) == false) { if (debug) { System.err.println("no match: EntityType include"); } return false; }
            }
            if (entity_type_exclude_regexp != null) {
                if (entity_type.matches(entity_type_exclude_regexp) == true) { if (debug) { System.err.println("no match: EntityType exclude"); } return false; }
            }
        }
        return true;
    }

    public Vector<Doclet> filterDoclets(CallContext context, Vector<Doclet> doclets) {
        Vector<Doclet> result  = new Vector<Doclet>();
        if (doclets != null) {
            for (Doclet doclet : doclets) {
                if (this.matches(context, doclet)) {
                    result.add(doclet);
                }
            }
        }
        return result;
    }

    public boolean matches (CallContext context, DocletGroup doclet_group) {
        {
            String security_class_list = doclet_group.getSecurityClass(context);
            if (security_class_list == null) { security_class_list = "Default"; }
            boolean one_imatch = false;
            boolean one_ematch = false;
            for (String security_class : security_class_list.split("\\|")) {
                if (security_class_include_regexp != null) {
                    if (security_class.matches(security_class_include_regexp)) { one_imatch = true; }
                }
                if (security_class_exclude_regexp != null) {
                    if (security_class.matches(security_class_exclude_regexp)) { one_ematch = true; }
                }
            }
            if (one_imatch == false || one_ematch == true) { return false; }
        }
        {
            String audience_list = doclet_group.getAudience(context);
            if (audience_list == null) { audience_list = ""; }
            boolean one_imatch = (audience_include_regexp == null);
            boolean one_ematch = false;
            for (String audience : audience_list.split("\\|")) {
                if (audience_include_regexp != null) {
                    if (audience.matches(audience_include_regexp)) { one_imatch = true; }
                }
                if (audience_exclude_regexp != null) {
                    if (audience.matches(audience_exclude_regexp)) { one_ematch = true; }
                }
            }
            if (one_imatch == false || one_ematch == true) { return false; }
        }
        {
            String entity_version = doclet_group.getEntityVersion(context);
            if (entity_version != null && entity_version.length() != 0) {
                VersionNumber vn = new VersionNumber(context, entity_version);
                if (entity_version_minimum != null) {
                    if (vn.compareTo(context, new VersionNumber(context, entity_version_minimum)) == 1) { return false; }
                }
                if (entity_version_maximum != null) {
                    if (vn.compareTo(context, new VersionNumber(context, entity_version_maximum)) == -1) { return false; }
                }
            }
        }
        {
            String entity_type = doclet_group.getEntityType(context);
            if (entity_type == null) { entity_type = ""; }
            if (entity_type_include_regexp != null) {
                if (entity_type.matches(entity_type_include_regexp) == false) { return false; }
            }
            if (entity_type_exclude_regexp != null) {
                if (entity_type.matches(entity_type_exclude_regexp) == true) { return false; }
            }
        }
        return true;
    }

    public Vector<DocletGroup> filterDocletGroups(CallContext context, Vector<DocletGroup> doclet_groups) {
        Vector<DocletGroup> result  = new Vector<DocletGroup>();
        if (doclet_groups != null) {
            for (DocletGroup doclet_group : doclet_groups) {
                if (this.matches(context, doclet_group)) {
                    result.add(doclet_group);
                }
            }
        }
        return result;
    }

    public boolean matches (CallContext context, DocletPackage doclet_package) {
        return hide_empty_folders == false || doclet_package.isEmpty(context, this) == false;
    }

    public Vector<DocletPackage> filterDocletPackages(CallContext context, Vector<DocletPackage> doclet_packages) {
        Vector<DocletPackage> result  = new Vector<DocletPackage>();
        if (doclet_packages != null) {
            for (DocletPackage doclet_package : doclet_packages) {
                if (this.matches(context, doclet_package)) {
                    result.add(doclet_package);
                }
            }
        }
        return result;
    }

    public Vector<DocletContainer> filterDocletContainers(CallContext context, Vector<DocletContainer> doclet_containers) {
        Vector<DocletContainer> result  = new Vector<DocletContainer>();
        if (doclet_containers != null) {
            for (DocletContainer doclet_container : doclet_containers) {
                if (doclet_container instanceof DocletGroup) {
                    if (this.matches(context, (DocletGroup) doclet_container)) {
                        result.add((DocletGroup) doclet_container);
                    }
                } else {
                    if (this.matches(context, (DocletPackage) doclet_container)) {
                        result.add((DocletPackage) doclet_container);
                    }
                }
            }
        }
        return result;
    }
}
