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

public enum WorkletType {

    Thought,          // something in your mind, worth mentioning...
                      // may be interesting
    Wish,             // something someone would like
    Concern,           // something which affects someone, is of
                      // more important than a wish, but still
                      // importance to someone
                      // not a request
    Question,         // (hmm, zu allgemein?)
    Requirement,      // Sonderfälle: UseCase, UserStory
    Bug,
    Complaint,
    Issue,
    Request,
    Todo,

    Agreement,
    Disagreement,
    Rating,
    Objection,        // Einwand
    Suggestion,       // Anregung
    Proposition,      // Vorschlag
    Comment,          // on subject; not "Comment On Text Of Author"
    Note,             // a piece of information
    Decision         


           // (das dann nich mehr, oder?
           //     (was doclet)
           //        Specification    how it shall be implemented                                   "reference of intent"
           //                         (ok: doclets are not project management, therefore
           //                          no requirements here (well then, why not?)...)
           // )
 
           // (RoughSketch,Umsetzungsentwurf,Outline aus target.tgt
           //  wird dann DocletDescription, Audience Developer, Maturity Draft oder sowas)
}
