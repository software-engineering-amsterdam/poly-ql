package ql_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author orosu
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
ql_test.ast.BlockTest.class,
ql_test.ast.ExpressionTest.class,
ql_test.ast.FormsTest.class,
ql_test.ast.StatementTest.class,
ql_test.ast.TypeTest.class,

ql_test.parser.BlockTest.class,
ql_test.parser.ExpressionTest.class,
ql_test.parser.FormsTest.class,
ql_test.parser.StatementTest.class,
ql_test.parser.TypeTest.class,

ql_test.type_checker.TypeCheckerByBlockTest.class,
ql_test.type_checker.TypeCheckerByFormsTest.class,
})
public final class AllTestsSuite {}
