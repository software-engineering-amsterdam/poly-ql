package edu.uva.softwarecons.main;

import edu.uva.softwarecons.grammar.QuestionnaireBaseListener;
import edu.uva.softwarecons.grammar.QuestionnaireParser;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class Evaluator extends QuestionnaireBaseListener{


    @Override
    public void enterInteger(@NotNull QuestionnaireParser.IntegerContext ctx) {
        super.enterInteger(ctx);

        String value  = ctx.getText();
        System.out.println("Value at enterInteger: "+value);
    }


    @Override
    public void enterIf(@NotNull QuestionnaireParser.IfContext ctx) {
        super.enterIf(ctx);
//        System.out.println("Value at enterIf: "+ctx.getText());
    }

    @Override
    public void enterQuest(@NotNull QuestionnaireParser.QuestContext ctx) {
        super.enterQuest(ctx);
        System.out.println("Value at enterQuest: "+ctx.getText());
    }

    @Override
    public void enterMulDiv(@NotNull QuestionnaireParser.MulDivContext ctx) {
        super.enterMulDiv(ctx);
        System.out.println("Value at enterMulDiv: "+ctx.getText());
    }

    @Override
    public void enterMoney(@NotNull QuestionnaireParser.MoneyContext ctx) {
        super.enterMoney(ctx);
        System.out.println("Value at enterMoney: "+ctx.getText());
    }

    @Override
    public void enterCompare(@NotNull QuestionnaireParser.CompareContext ctx) {
        super.enterCompare(ctx);
        System.out.println("Value at enterCompare: "+ctx.getText());
    }
}
