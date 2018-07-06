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
import com.sphenon.basics.accessory.*;

/********************************************************************************/
/* [ToDo] Consolidate Redundancies!                                             */
/* TagletDoclet.java, TagleMeta.java, Doclet.java, doclet.dtd, doclet.docl      */
/* also: Filing, and ee/workable                                                */
/********************************************************************************/

/* [to be consolidated]

   Documentation of valid values -> mostly in doclet.docl

   Doclets contain information intended for humans; this does neither imply "imprecision",
   nor does it exclude automatic processing into full fledged Documentation artefacts,
   but that the content cannot be grasped completely by a machine and therefore cannot
   be processed comprehensively.
   
   E.g.,
   - a "Thought" is a Doclet, with no automated consequences; it consists only
   of "Text", to be read by a human
   - an "Issue" is not a Doclet, but an item of work coordination, there are
   machine readable Attributes (e.g. urgency 0-100), and should be automatically
   addressed sometime to someone (to be discussed...)
   - "Bugs" and "Requests" are primarily not Doclets
   in short, there is no obligation to processes Doclets (regularly), they
   serve just as information storage (passive in nature)
   but of course Doclets can be PART of Issues, Bugs or Requests

   Issue, Request, Bugs, ToDo are worklets.

   Update 2/2012

   Alternatively, more sharp:

   - Doclets are pure, passive, Information without intended work obligations

   - Worklets are active Information which shall imply specific changes

   - Worklets exist only for a period of time, afterward they shall
     be "done" (or "canceled") and there lifecycle terminates

   - i.e., a "Thought" would be an idea, that something could be different,
   but there's no solution yet, i.e. they would be Worklets (?)
*/

/**
   {@EntitySecurityClass User}

   @doclet {@Category Overview} {@SecurityClass User} {@Maturity Draft}

   Doclets are snippets of documentation, tagged with well defined meta data.

   Doclets comprise all kinds of documentation, i.e. human readable text. Like
   source code comments, which are e.g. attached to classes or members,
   Doclets are associated with all kinds of artefacts of a software system:
   with bundles, models, ocps, templates, and source code.
 */
public interface Doclet extends MonitorableCoreObject, DocletItem {
    /**
       Get raw UTF-8 encoded XML
    */
    public String getDocBook (CallContext context);

    /**
       General categorisation of this Doclet.
     */
    public String getDocletType(CallContext context);

    /**
       Get security class of this doclet. Specifies who is authorised to
       access this doclet in which way.

       @return List of vertical-slash-separated security class strings, usable
               in conjunction with an {@link Authority}
     */
    public String getSecurityClass(CallContext context);
    // SphenonOnly|SphenonPartner|SphenonCustomer|Public
    // InternalUseOnly|BusinessPartner|Customer|Public

    /**
       Describes who this doclet may concern, who is able to understand it's
       content, or who may be interested in it.

       @return List of vertical-slash-separated audience classifier names.
     */
    public String getAudience(CallContext context);

    /**
       The human language this doclet is written in.

       @return An ISO 639 language identifier.
     */
    public String getLanguage(CallContext context);

    /**
       Describes the intent of the author.

       @return List of vertical-slash-separated intent classifier names.
     */
    public String getIntent(CallContext context);

    /**
       Describes the (probably just intended) amount of material found in this
       doclet.

       @return A classifier name of an extent of material.
     */
    public String getExtent(CallContext context);

    /**
       In relation to the topic at hand, describes to which degree the
       information is complete.

       @return A classifier name of the degree of completeness of the material.
     */
    public String getCoverage(CallContext context);

    /**
       Describes the maturity of this piece of documentation.

       @return A classifier name of the maturity of a text piece.
     */
    public String getMaturity(CallContext context);

    /**
       Describes the target medium that this doclet was designed for.

       @return A target medium classifier name.
     */
    public String getForm(CallContext context);

    /**
       Describes how this doclet should be layouted.

       @return List of vertical-slash-separated form classifier names.
     */
    public String getLayout(CallContext context);

    /**
       Describes the encoding of this doclet. The default is DocBook.

       @return {@link Encoding} of this doclet.
     */
    public Encoding getEncoding(CallContext context);
    // DocBook(default)|Wiki

    /**
       Describes which aspect of a documented item is described in this
       doclet.

       @return An aspect name.
     */
    public String getAspect(CallContext context);

    /**
       A locator that identifies the entity described by this doclet.

       @return A locator.
     */
    public String getEntity(CallContext context);

    /**
       The type of the entity described by this doclet.

       @return A type name.
     */
    public String getEntityType(CallContext context);

    /**
       The version of the entity described by this doclet.

       @return A version number.
     */
    public String getEntityVersion(CallContext context);

    /**
       The version of the doclet format.

       @return A version number.
     */
    public String getDocletVersion(CallContext context);
}
