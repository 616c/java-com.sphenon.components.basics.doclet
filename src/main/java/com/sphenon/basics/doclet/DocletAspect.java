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
import com.sphenon.sm.tsm.TSMEquipped;

import com.sphenon.ui.core.*;
import com.sphenon.ui.core.classes.*;

import java.util.Vector;
import java.util.Map;

/* this will be specifically amountful and difficult to "standardise",
   but also exceptionally important for processing
*/
public enum DocletAspect implements UIEquipped, TSMEquipped {

    // ----------------------------------------------------------------------------------------
    None,            // Unspecified
    Purpose,         //
    Features,        //
    Architecture,    //
    Model,           //
    Interface,       //
    Contract,        //
    Implementation,  //
    Format,          //
    Maintenance,     //
    Testing,         //
    Fact             //
    ;

    static protected Map<String,Vector<UIEquipment>> ui_equipment_map;

    protected Vector<UIEquipment> ui_equipments;

    public Vector<UIEquipment> getUIEquipments(CallContext context) {
        if (this.ui_equipments == null) {
            // if (ui_equipment_map == null) {
            //     ui_equipment_map = (Map<String,Vector<UIEquipment>>) com.sphenon.engines.aggregator.Aggregator.create(context, "com/sphenon/basics/doclet/DocletType_UIEquipments");
            // }
            // this.ui_equipments = (ui_equipment_map == null ? null : ui_equipment_map.get(toString()));
            this.ui_equipments = new Vector<UIEquipment>();
            this.ui_equipments.add(new Class_UIEquipment(context, UIEquipmentType.Name, toString()));
            this.ui_equipments.add(new Class_UIEquipment(context, UIEquipmentType.Text, toString()));
        }
        return this.ui_equipments;
    }

    // TSM mapping ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    static public String getPersistentTypeName (CallContext context) {
        return "String";
    }

    static public String convertToPersistentType (CallContext context, DocletAspect ad_instance) {
        return ad_instance == null ? null : ad_instance.name();
    }

    static public DocletAspect convertFromPersistentType (CallContext context, String sm_instance) {
        return sm_instance == null ? null : java.lang.Enum.<DocletAspect>valueOf(DocletAspect.class, sm_instance);
    }

    public Object _getState(CallContext context) {
        return name();
    }
}
