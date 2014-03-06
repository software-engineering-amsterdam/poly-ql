package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

/**
 * Visits the custom AST created by AntlrVisitor and check whether undefined 
 * questions are referred to
 * 
 * @author Sammie Katt
 *
 */
public class UndefinedCheck implements QLVisitor {
}
