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

import com.sphenon.ui.core.*;
import com.sphenon.ui.core.classes.*;

import java.util.Vector;
import java.util.Map;

/**
   intended amount (maybe it's incomplete)
*/
public enum DocletExtent implements UIEquipped {

    /* KEEP IN MIND: JPA DEPENDS ON ORDERING HERE ! */

    // ----------------------------------------------------------------------------------------
    None,           //
    Word,           // word
    Phrase,         // 3 words
    Headline,       // 7 words
    Sentence,       // words, written out
    Enumeration,    // list (e.g. for slides)
    Paragraph,      // para
    Section,        // half page
    Page,           // page
    Listing,        // long list (3-7 pages)
    Article,        // 3-7 pages (standalone)
    Chapter,        // 12-30 pages (part of book)
    Book            // book
    ;
    // hmm?

    // images:
    // Icon
    // Preview
    // HorizontalBanner
    // VerticalBanner
    // Image

    // speech:
    // 1min
    // 5min
    // 15min
    // 30min
    // 45min
    // 60min
    // 90min

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
}
