package edu.uva.softwarecons.test;

import edu.uva.softwarecons.util.ParserBuilder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class QuestionnaireParserTest {
    //TODO Low priority do not check
    private ParserBuilder parserBuilder;

    @Before
    public void setUp() {
        parserBuilder = new ParserBuilder();
    }

    @Test
    public void basicQuestionTest() {
        String input = "form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) })");
    }


    @Test
    public void conditionalIfFormTest() {
        String input = "form Box1HouseOwning {if(a==b){hasSoldHouse: \"Did you sell a house in 2010?\" boolean}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr a) == (expr b)) ) { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) }) })");
    }


    @Test
    public void conditionalIfElseFormTest() {
        String input = "form Box1HouseOwning {if(a==b){hasSoldHouse: \"text\" boolean} else { hasSoldHouse: \"text\" money }}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr a) == (expr b)) ) { (question hasSoldHouse : \"text\" (type boolean)) } (elsestat else { (question hasSoldHouse : \"text\" (type money)) })) })");
    }


    @Test
    public void booleansAndFormTest() {
        String input = "form Box1HouseOwning {if(a==b && a<b){hasSoldHouse: \"t\" date}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr (expr a) == (expr b)) && (expr (expr a) < (expr b))) ) { (question hasSoldHouse : \"t\" (type date)) }) })");
    }


    @Test
    public void booleansOrFormTest() {
        String input = "form Box1HouseOwning {if(a==b || a<b){hasSoldHouse: \"t\" date}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr (expr a) == (expr b)) || (expr (expr a) < (expr b))) ) { (question hasSoldHouse : \"t\" (type date)) }) })");
    }


    @Test
    public void expressionComputedQuestionTest() {
        String input = "form Box1HouseOwning { h: \"text\" money(1+5*5)}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question h : \"text\" (type money) ( (expr (expr 1) + (expr (expr 5) * (expr 5))) )) })");
    }

    @Test
    public void booleanTypeQuestionTest() {
        String input = "form testForm {testQuestion: \"label\" boolean}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type boolean)) })");
    }


    @Test
    public void dateTypeQuestionTest() {
        String input = "form testForm {testQuestion: \"label\" date}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type date)) })");
    }

    @Test
    public void decimalTypeQuestionTest() {
        String input = "form testForm {testQuestion: \"label\" decimal}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type decimal)) })");
    }

    @Test
    public void integerTypeQuestionTest() {
        String input = "form testForm {testQuestion: \"label\" integer}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type integer)) })");
    }

    @Test
    public void moneyTypeQuestionTest() {
        String input = "form testForm {testQuestion: \"label\" money}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type money)) })");
    }

    @Test
    public void stringTypeQuestionTest() {
        String input = "form testForm {testQuestion: \"label\" string}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type string)) })");
    }

    @Test
    public void arithmeticAddExpressionTest() {
        String input = "form testForm {testQuestion: \"label\" money(a+b)}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type money) ( (expr (expr a) + (expr b)) )) })");
    }

    @Test
    public void arithmeticSubExpressionTest() {
        String input = "form testForm {testQuestion: \"label\" money(a-b)}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type money) ( (expr (expr a) - (expr b)) )) })");
    }

    @Test
    public void arithmeticMulExpressionTest() {
        String input = "form testForm {testQuestion: \"label\" money(a*b)}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type money) ( (expr (expr a) * (expr b)) )) })");
    }

    @Test
    public void arithmeticDivExpressionTest() {
        String input = "form testForm {testQuestion: \"label\" money(a/b)}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form testForm { (question testQuestion : \"label\" (type money) ( (expr (expr a) / (expr b)) )) })");
    }

    @Test
    public void comparisonFormTest() {
        String input = "form Box1HouseOwning {if(1<=2){hasSoldHouse: \"Did you sell a house in 2010?\" boolean}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr 1) <= (expr 2)) ) { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) }) })");
    }


}
