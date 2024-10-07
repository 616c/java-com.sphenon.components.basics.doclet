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
import com.sphenon.ui.core.*;
import com.sphenon.ui.core.classes.*;
import com.sphenon.sm.tsm.TSMEquipped;

import java.util.Vector;
import java.util.Map;

/*
    Siehe noch evtl. Reste in doclet.docl
    Hier ist aber nun der Zieltopf!
 */
public enum DocletType implements UIEquipped, TSMEquipped {

    // ----------------------------------------------------------------------------------------
    Label,            //
    Classification,   // a unique denotation of a class of the described entity
                      // comprehension, different rendering
    Group,            // comprises similar doclets (with shared attributes)
    // ----------------------------------------------------------------------------------------
    Description,      // concise, objective information, possibly not complete    // -> Description, Coverage=Detailed
                      // helps building a working concept of topic
    Definition,       // a description of a term or alike
    // ----------------------------------------------------------------------------------------
    History,          //
    Outlook,          // maybe this is a worklet, i.e. overview on some desired target state
    Comparison,       //
    // ----------------------------------------------------------------------------------------
    Concept,          // become able to judge 
    Glossary,         // explanation of terms and phrases
    Specification,    // -> Reference, Coverage=Complete
                      // complete, possibly at the cost of easiness, readability
                      // get precise, full information
                      // -> QuickReference, Coverage=Summary
                      // for the experienced reader
                      // get details fast
    // ----------------------------------------------------------------------------------------
    FAQ,              // frequently asked questions
    Guidance,         // helpful, fast, for the unexperienced
                      // help to solve problems
    HowTo,            // helpful, detailed, task focused
                      // help to solve a specific problem
    Tutorial,         // some completeness, fair, objective, guided
                      // learning in general
    Manual,           // complete, autodidactic
                      // learning in general
    Example,          // for the respective topic (fine grained
                      // to illustrate, better understanding
                      // examples might be also modelled within
    Guideline,        // more a "should"; helpful in the respect not
                      // to misbehave
    Directive,        // to be done this way
    // ----------------------------------------------------------------------------------------
    References,       // a list of related information or further readings
                      // i.e. 'links'
    Attachment,       // additional, augmenting material
    // ----------------------------------------------------------------------------------------
    Motivation,       // Motives, reasons, which led to the ...
                      // better understanding of the solution and
                      // of - possibly implicit - requirements
    Rationale,        // Logical explanation of solution
                      // rationale = motivation + solution derivation path
    Opinion,          // an individual description from a certain,
                      // explicitly specified viewpoint


    Overview,         // become able to relate it, know where to dive deeper in case you need it          // -> Description, Coverage=Overview
    Summary,          // become able to decide further investigation                                      // -> Description, Coverage=Summary
                      // decide: interesting?
    Introduction,     // allows classifying the topic, typically less than outline                        // -> Description, Coverage=Introduction
    Outline,          // limited in amount of reading time                                                // -> Description, Coverage=Outline
                      // get the idea

    Discussion,       // contains a discussion of some topic, possibly for decision making,
                      // may contain the following sub-doclets:
        Agreement,    //
        Disagreement, //
        Rating,       //
        Objection,    // (Einwand)
        Suggestion,   // (Anregung)
        Proposition,  // (Vorschlag)
        Review,       // (Kritik)
        Decision,     //         

    Comment,          // general comment on the subject, or depending on the location
                      // on some aspect or on some text piece
    Note,             // general note to be taken into account by the addressed audience,
                      // not necessarily concerning the subject itself but e.g. moving
                      // of some content
    ;

    static protected Map<String,Vector<UIEquipment>> ui_equipment_map;

    protected Vector<UIEquipment> ui_equipments;

    public Vector<UIEquipment> getUIEquipments(CallContext context) {
        if (this.ui_equipments == null) {
            if (ui_equipment_map == null) {
                ui_equipment_map = (Map<String,Vector<UIEquipment>>) com.sphenon.engines.aggregator.Aggregator.create(context, "com/sphenon/basics/doclet/DocletType_UIEquipments");
            }
            this.ui_equipments = (ui_equipment_map == null ? null : ui_equipment_map.get(toString()));
        }
        return this.ui_equipments;
    }

    // TSM mapping ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    static public String getPersistentTypeName (CallContext context) {
        return "String";
    }

    static public String convertToPersistentType (CallContext context, DocletType ad_instance) {
        return ad_instance == null ? null : ad_instance.name();
    }

    static public DocletType convertFromPersistentType (CallContext context, String sm_instance) {
        return sm_instance == null ? null : java.lang.Enum.<DocletType>valueOf(DocletType.class, sm_instance);
    }

    public Object _getState(CallContext context) {
        return name();
    }
}

    // (worklet?)   Discussion       comprises doclets to discuss a topic
    // (worklet?)   DecisionMaking   comprises doclets to make a decision
    // (doclet?)    Decision

    /* ================================================================================================
        (hmm - bewertung, worklets? --- 12/2012: nein, das ist schlichtweg Dokumentation eines Zustands,
                                                 also nicht entity-doclet sondern entity-state-doclet,
                                                 wobei state ein Datum, eine Revision o.ä. sein kann)

    Review,           // a second opinion on the topic
       d.h. das wäre dann State-Opinion
    Report,           // description of status quo
       d.h. das wäre dann State-Description o.ä.
    Analysis          // decomposition into and ordering of various aspects
                      // detailed/better understanding as preparation
                      // for further work/judgement (similar to introduction,
       d.h. das wäre dann State-Analysis o.ä.
                                aber was ist Analysis hier? detailed description?
                                Analysis von was?
                                vielleicht ist Analysis ein detaillierter Baum
                                von Doclets am Ist-Zustand, am Soll-Zutand und von
                                möglichen Wegen....?

    =================================================================================================== */

    /* ================================================================================================
      worklets ? --- 12/2012: Yup! Es sind worklets
                                                                                                 but there's no authority yet)
                  Thought          something in your mind, worth mentioning...                   may be interesting
                  Wish             something someone would like
                  Concern          something which affects someone, is of                        more important than a wish, but still
                                   importance to someone                                         not a request
                  Question         (hmm, zu allgemein?)

                  Requirement
                     Sonderfälle (abgeleitet)
                        UseCase
                        UserStory
           (das dann nich mehr, oder?
               (was doclet)
                  Specification    how it shall be implemented                                   "reference of intent"
                                   (ok: doclets are not project management, therefore
                                    no requirements here (well then, why not?)...)
           )
                 (RoughSketch,Umsetzungsentwurf,Outline aus target.tgt
                    wird dann DocletDescription, Audience Developer, Maturity Draft oder sowas)

    =================================================================================================== */

    /* ================================================================================================

       Chatlets !!

          Following may typically be used within a discussion:

    =================================================================================================== */
