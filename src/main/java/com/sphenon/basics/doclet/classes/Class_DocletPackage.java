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
import com.sphenon.basics.quantities.*;
import com.sphenon.basics.accessory.classes.*;

import com.sphenon.basics.doclet.*;

import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class Class_DocletPackage extends Class_MonitorableCoreObject implements DocletPackage {

    public Class_DocletPackage(CallContext context) {
    }

    public Class_DocletPackage(CallContext context, String id, String index) {
        this.id = id;
        this.index = index;
    }

    protected String id;

    public String getId (CallContext context) {
        return this.id;
    }

    public void setId (CallContext context, String id) {
        this.id = id;
    }

    protected String index;

    public String getIndex (CallContext context) {
        return this.index;
    }

    public void setIndex (CallContext context, String index) {
        this.index = index;
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

    protected Vector<DocletContainer> entries;
    protected Map<DocletFilter, Vector<DocletContainer>> entries_filter_cache;
    protected boolean entries_modified;

    public Vector<DocletContainer> getEntries (CallContext context) {
        if (entries_modified) {
            java.util.Collections.sort(this.entries, new EntryComparator(context));
            entries_modified = false;
        }
        return this.entries;
    }

    public Vector<DocletContainer> getEntries(CallContext context, DocletFilter doclet_filter) {
        Vector<DocletContainer> result = null;
        if (this.entries_filter_cache == null) {
            this.entries_filter_cache = new HashMap<DocletFilter, Vector<DocletContainer>>();
        } else if (entries_modified == false) {
            result = this.entries_filter_cache.get(doclet_filter);
        }
        if (result == null) {
            result = doclet_filter.filterDocletContainers(context, this.getEntries(context));
            this.entries_filter_cache.put(doclet_filter, result);
        }
        return result;
    }

    public boolean isEmpty(CallContext context) {
        Vector<DocletContainer> entries = this.getEntries(context);
        for (DocletContainer entry : entries) {
            if (entry instanceof DocletPackage) {
                if (((DocletPackage)entry).isEmpty(context) == false) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(CallContext context, DocletFilter doclet_filter) {
        Vector<DocletContainer> entries = this.getEntries(context, doclet_filter);
        for (DocletContainer entry : entries) {
            if (entry instanceof DocletPackage) {
                if (((DocletPackage)entry).isEmpty(context, doclet_filter) == false) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    protected Vector<DocletGroup> groups;
    protected Map<DocletFilter, Vector<DocletGroup>> groups_filter_cache;
    protected Map<String,DocletGroup> groups_by_id;

    public Vector<DocletGroup> getGroups (CallContext context) {
        return this.groups;
    }

    public Vector<DocletGroup> getGroups(CallContext context, DocletFilter doclet_filter) {
        Vector<DocletGroup> result = null;
        if (this.groups_filter_cache == null) {
            this.groups_filter_cache = new HashMap<DocletFilter, Vector<DocletGroup>>();
        } else if (entries_modified == false) {
            result = this.groups_filter_cache.get(doclet_filter);
        }
        if (result == null) {
            result = doclet_filter.filterDocletGroups(context, this.getGroups(context));
            this.groups_filter_cache.put(doclet_filter, result);
        }
        return result;
    }

    protected Vector<DocletPackage> packages;
    protected Map<DocletFilter, Vector<DocletPackage>> packages_filter_cache;
    protected Map<String,DocletPackage> packages_by_id;

    public Vector<DocletPackage> getPackages (CallContext context) {
        return this.packages;
    }

    public Vector<DocletPackage> getPackages (CallContext context, DocletFilter doclet_filter) {
        return doclet_filter.filterDocletPackages(context, this.getPackages(context));
    }

    public DocletGroup getGroupById(CallContext context, String id) {
        return this.groups_by_id == null ? null : this.groups_by_id.get(id);
    }

    public DocletPackage getPackageById(CallContext context, String id) {
        return this.packages_by_id == null ? null : this.packages_by_id.get(id);
    }

    public void addEntry(CallContext context, DocletContainer entry) {
        if (this.entries == null) {
            this.entries = new Vector<DocletContainer>();
        }
        this.entries.add(entry);
        this.entries_modified = true;
    }

    public void addGroup(CallContext context, DocletGroup doclet_group) {
        if (this.groups == null) {
            this.groups = new Vector<DocletGroup>();
            this.groups_by_id = new HashMap<String,DocletGroup>();
        }
        this.groups.add(doclet_group);
        this.groups_by_id.put(doclet_group.getId(context), doclet_group);
        this.addEntry(context, doclet_group);
    }

    public void addPackage(CallContext context, DocletPackage doclet_package) {
        if (this.packages == null) {
            this.packages = new Vector<DocletPackage>();
            this.packages_by_id = new HashMap<String,DocletPackage>();
        }
        this.packages.add(doclet_package);
        this.packages_by_id.put(doclet_package.getId(context), doclet_package);
        this.addEntry(context, doclet_package);
    }

    protected class EntryComparator implements java.util.Comparator {
        protected CallContext context;
        public EntryComparator(CallContext context) {
            this.context = context;
        }
        public int compare(Object o1, Object o2) {
            DocletContainer dc1 = (DocletContainer) o1;
            DocletContainer dc2 = (DocletContainer) o2;
            String id1 = dc1.getIndex(context) + "-" + (dc1 instanceof DocletGroup ? "-G" : "-P");
            String id2 = dc2.getIndex(context) + "-" + (dc2 instanceof DocletGroup ? "-G" : "-P");
            return id1.compareTo(id2);
        }
    }
}
