package org.uva.sea.ql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.ast.expr.ExprTest;
import org.uva.sea.ql.ast.form.FormTest;
import org.uva.sea.ql.checker.ExprCheckerTest;

@RunWith(Suite.class)
@SuiteClasses({	ExprTest.class,
				FormTest.class,
				ExprCheckerTest.class})

public class AllTests {

}
