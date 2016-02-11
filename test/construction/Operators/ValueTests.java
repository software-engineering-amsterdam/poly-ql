package construction.Operators;

import construction.ErrorTypes.TypeError;
import construction.Types.BoolLiteral;
import construction.Types.IntLiteral;
import construction.Types.IntType;
import construction.Values.BoolValue;
import construction.Values.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ValueTests {

    @Test
    public void BoolValueTest() {
        /*
         Map<String, Value> memory = new HashMap();
        
        BoolValue testbool = new BoolValue(true);
        
        
        Plus p = new Plus(new IntLiteral(1, 0), new IntLiteral(1, 0), 15);
       
        List<TypeError> typeErrors = new ArrayList();
        assertThat(p.getType(memory), instanceOf(IntType.class));
        assertThat(p.checkType(memory, typeErrors), is(true));
        assertThat(p.getLine(), is(15));
        */

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
