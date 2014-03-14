package nl.uva.polyql.antlr4;

import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_andContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_atomContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_eqContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_numContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_orContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_prodContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_sumContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.FieldContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.IfstatementContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.QuestionContext;
import nl.uva.polyql.ast.LineInfo;

public class LineInfoListener extends QuestionnaireBaseListener {

    @Override
    public void exitField(final FieldContext ctx) {
        ctx.f.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitQuestion(final QuestionContext ctx) {
        ctx.q.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitIfstatement(final IfstatementContext ctx) {
        ctx.is.setLineInfo(new LineInfo(ctx));
        if (ctx.es != null) {
            ctx.es.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_and(final Expr_andContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitExpr_atom(final Expr_atomContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitExpr_eq(final Expr_eqContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitExpr_num(final Expr_numContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitExpr_or(final Expr_orContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitExpr_prod(final Expr_prodContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }

    @Override
    public void exitExpr_sum(final Expr_sumContext ctx) {
        ctx.e.setLineInfo(new LineInfo(ctx));
    }
}
