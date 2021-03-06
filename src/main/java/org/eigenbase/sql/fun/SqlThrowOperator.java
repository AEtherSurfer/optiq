/*
// Licensed to Julian Hyde under one or more contributor license
// agreements. See the NOTICE file distributed with this work for
// additional information regarding copyright ownership.
//
// Julian Hyde licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
*/
package org.eigenbase.sql.fun;

import org.eigenbase.sql.*;
import org.eigenbase.sql.type.*;


/**
 * An internal operator that throws an exception.<br>
 * The exception is thrown with a (localized) error message which is the only
 * input paramter to the operator.<br>
 * The return type is defined as a <code>BOOLEAN</code> to facilitate the use of
 * it in constructs like the following:
 *
 * <p><code>CASE<br>
 * WHEN &lt;conditionn&gt; THEN true<br>
 * ELSE throw("what's wrong with you man?")<br>
 * END
 *
 * @author Wael Chatila
 * @version $Id$
 * @since Mar 29, 2005
 */
public class SqlThrowOperator
    extends SqlInternalOperator
{
    //~ Constructors -----------------------------------------------------------

    public SqlThrowOperator()
    {
        super(
            "$throw",
            SqlKind.OTHER,
            2,
            true,
            SqlTypeStrategies.rtiBoolean,
            null,
            SqlTypeStrategies.otcCharString);
    }

    //~ Methods ----------------------------------------------------------------

    public void unparse(
        SqlWriter writer,
        SqlNode [] operands,
        int leftPrec,
        int rightPrec)
    {
        final SqlWriter.Frame frame = writer.startFunCall(getName());
        operands[0].unparse(writer, 0, 0);
        writer.endFunCall(frame);
    }
}

// End SqlThrowOperator.java
