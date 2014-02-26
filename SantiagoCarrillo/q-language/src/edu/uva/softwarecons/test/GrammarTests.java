package edu.uva.softwarecons.test;

import edu.uva.softwarecons.main.ParserUtil;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/13/14
 */

public class GrammarTests {


    ParserUtil parserUtil;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        parserUtil = new ParserUtil();
    }

    @Test
    public void simpleFormTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) })");
    }

    @Test
    public void conditionalIfFormTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {if(a==b){hasSoldHouse: \"Did you sell a house in 2010?\" boolean}}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr a) == (expr b)) ) { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) }) })");
    }


    @Test
    public void booleansAndFormTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {if(a==b && a<b){hasSoldHouse: \"t\" date}}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr (expr a) == (expr b)) && (expr (expr a) < (expr b))) ) { (question hasSoldHouse : \"t\" (type date)) }) })");
    }


    @Test
    public void booleansAndOrFormTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {if(a==b && a<b){hasSoldHouse: \"t\" date}}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr (expr a) == (expr b)) && (expr (expr a) < (expr b))) ) { (question hasSoldHouse : \"t\" (type date)) }) })");
    }

    @Test
    public void conditionalIfElseFormTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {if(a==b){hasSoldHouse: \"text\" boolean} else { hasSoldHouse: \"text\" money }}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr a) == (expr b)) ) { (question hasSoldHouse : \"text\" (type boolean)) } (elsestat else { (question hasSoldHouse : \"text\" (type money)) })) })");
    }


    @Test
    public void comparisonFormTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {if(1<=2){hasSoldHouse: \"Did you sell a house in 2010?\" boolean}}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr 1) <= (expr 2)) ) { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) }) })");
    }

    @Test
    public void expressionOperationTest(){
        InputStream inputStream = new ByteArrayInputStream("form Box1HouseOwning {hasSoldHouse: \"text\" money(1+5*5)}".getBytes());
        ParseTree tree = parserUtil.buildParseTree(inputStream);
        assertEquals(tree.toStringTree(parserUtil.getParser()),
                "(questionnaire form Box1HouseOwning { (question hasSoldHouse : \"text\" (type money) (expr ( (expr (expr 1) + (expr (expr 5) * (expr 5))) ))) })");
    }
}
