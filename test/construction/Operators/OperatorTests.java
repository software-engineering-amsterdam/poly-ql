package construction.Operators;

import construction.ErrorTypes.TypeError;
import construction.Types.BoolLiteral;
import construction.Types.BoolType;
import construction.Types.IType;
import construction.Types.IntLiteral;
import construction.Types.IntType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class OperatorTests {

    @Test
    public void testOperatorsTypeCheck() {
        Plus p = new Plus(new IntLiteral(1, 0), new IntLiteral(1, 0), 15);
        Map<String, IType> memory = new HashMap();
        List<TypeError> typeErrors = new ArrayList();
        assertThat("Should be a Int",p.getType(memory), instanceOf(IntType.class));
        assertThat(p.checkType(memory, typeErrors), is(true));
        assertThat(p.getLine(), is(15));

        Expression lefthand = new IntLiteral(1, 0);
        Expression righthand = new BoolLiteral(false, 0);
/*
        p = new Plus(lefthand, righthand, 15);
        assertThat(p.getType(memory), instanceOf(IntType.class));
        assertThat(p.checkType(memory, typeErrors), is(false));
        assertThat(p.getleftHandExpression(), is(lefthand));
        assertThat(p.getRightHandExpression(), is(righthand));
        assertThat(p.getleftHandExpression(), is(not((righthand))));
*/
    }

}
