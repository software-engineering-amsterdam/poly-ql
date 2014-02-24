import org.antlr.v4.runtime.misc.NotNull;

/**
 * Visit a ParseTree and built AST
 */
public class ASTVisitor extends TestBaseVisitor<Object> {
	/* Default constructor */
	public ASTVisitor() { }
	
	@Override public Object visitLt(@NotNull TestParser.LtContext ctx) { return visitChildren(ctx); }

	@Override public Object visitLtEq(@NotNull TestParser.LtEqContext ctx) { return visitChildren(ctx); }

	@Override public Object visitQid(@NotNull TestParser.QidContext ctx) { return visitChildren(ctx); }

	@Override public Object visitBlock(@NotNull TestParser.BlockContext ctx) { return visitChildren(ctx); }

	@Override public Object visitQtype(@NotNull TestParser.QtypeContext ctx) { return visitChildren(ctx); }

	@Override public Object visitParens(@NotNull TestParser.ParensContext ctx) { return visitChildren(ctx); }

	@Override public Object visitGt(@NotNull TestParser.GtContext ctx) { return visitChildren(ctx); }

	@Override public Object visitEq(@NotNull TestParser.EqContext ctx) { return visitChildren(ctx); }

	@Override public Object visitGtEq(@NotNull TestParser.GtEqContext ctx) { return visitChildren(ctx); }

	@Override public Object visitIfblock(@NotNull TestParser.IfblockContext ctx) { return visitChildren(ctx); }

	@Override public Object visitMul(@NotNull TestParser.MulContext ctx) { return visitChildren(ctx); }

	@Override public Object visitTitle(@NotNull TestParser.TitleContext ctx) { return visitChildren(ctx); }

	@Override public Object visitQuestionnare(@NotNull TestParser.QuestionnareContext ctx) { return visitChildren(ctx); }

	@Override public Object visitNeg(@NotNull TestParser.NegContext ctx) { return visitChildren(ctx); }

	@Override public Object visitAdd(@NotNull TestParser.AddContext ctx) { return visitChildren(ctx); }

	@Override public Object visitSub(@NotNull TestParser.SubContext ctx) { return visitChildren(ctx); }

	@Override public Object visitQuestion(@NotNull TestParser.QuestionContext ctx) { return visitChildren(ctx); }

	@Override public Object visitQcontent(@NotNull TestParser.QcontentContext ctx) { return visitChildren(ctx); }

	@Override public Object visitQuestionID(@NotNull TestParser.QuestionIDContext ctx) { return visitChildren(ctx); }

	@Override public Object visitInt(@NotNull TestParser.IntContext ctx) { return visitChildren(ctx); }

	@Override public Object visitNeq(@NotNull TestParser.NeqContext ctx) { return visitChildren(ctx); }

	@Override public Object visitDiv(@NotNull TestParser.DivContext ctx) { return visitChildren(ctx); }
}
