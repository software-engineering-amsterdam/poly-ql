// Generated from grammar/QL4.g4 by ANTLR 4.2

  package QL4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QL4Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, LABEL=20, COMMENT=21, TYPE=22, IF=23, ELSEIF=24, 
		ELSE=25, BOOLEAN=26, IDENTIFIER=27, STRING=28, DEC=29, INT=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'!='", 
		"';'", "'<='", "'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", 
		"'!'", "LABEL", "COMMENT", "TYPE", "'if'", "'elseif'", "'else'", "BOOLEAN", 
		"IDENTIFIER", "STRING", "DEC", "INT", "WS"
	};
	public static final int
		RULE_form = 0, RULE_structures = 1, RULE_structure = 2, RULE_question = 3, 
		RULE_expression = 4, RULE_ifcondition = 5, RULE_elseifcondition = 6, RULE_elsecondition = 7;
	public static final String[] ruleNames = {
		"form", "structures", "structure", "question", "expression", "ifcondition", 
		"elseifcondition", "elsecondition"
	};

	@Override
	public String getGrammarFileName() { return "QL4.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QL4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public StructuresContext structures() {
			return getRuleContext(StructuresContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); structures();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructuresContext extends ParserRuleContext {
		public StructureContext structure(int i) {
			return getRuleContext(StructureContext.class,i);
		}
		public List<StructureContext> structure() {
			return getRuleContexts(StructureContext.class);
		}
		public StructuresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structures; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterStructures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitStructures(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitStructures(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructuresContext structures() throws RecognitionException {
		StructuresContext _localctx = new StructuresContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structures);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18); structure();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IF || _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructureContext extends ParserRuleContext {
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
	 
		public StructureContext() { }
		public void copyFrom(StructureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WorkflowStructContext extends StructureContext {
		public ElseconditionContext elsecondition() {
			return getRuleContext(ElseconditionContext.class,0);
		}
		public List<ElseifconditionContext> elseifcondition() {
			return getRuleContexts(ElseifconditionContext.class);
		}
		public IfconditionContext ifcondition() {
			return getRuleContext(IfconditionContext.class,0);
		}
		public ElseifconditionContext elseifcondition(int i) {
			return getRuleContext(ElseifconditionContext.class,i);
		}
		public StructuresContext structures(int i) {
			return getRuleContext(StructuresContext.class,i);
		}
		public List<StructuresContext> structures() {
			return getRuleContexts(StructuresContext.class);
		}
		public WorkflowStructContext(StructureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterWorkflowStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitWorkflowStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitWorkflowStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuestionStructContext extends StructureContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public QuestionStructContext(StructureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterQuestionStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitQuestionStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitQuestionStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structure);
		int _la;
		try {
			setState(45);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new QuestionStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23); question();
				}
				break;
			case IF:
				_localctx = new WorkflowStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24); ifcondition();
				setState(25); match(13);
				setState(26); structures();
				setState(27); match(17);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(28); elseifcondition();
					setState(29); match(13);
					setState(30); structures();
					setState(31); match(17);
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(43);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(38); elsecondition();
					setState(39); match(13);
					setState(40); structures();
					setState(41); match(17);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	 
		public QuestionContext() { }
		public void copyFrom(QuestionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompQuestionContext extends QuestionContext {
		public TerminalNode IDENTIFIER() { return getToken(QL4Parser.IDENTIFIER, 0); }
		public TerminalNode LABEL() { return getToken(QL4Parser.LABEL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(QL4Parser.TYPE, 0); }
		public CompQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterCompQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitCompQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitCompQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegQuestionContext extends QuestionContext {
		public TerminalNode IDENTIFIER() { return getToken(QL4Parser.IDENTIFIER, 0); }
		public TerminalNode LABEL() { return getToken(QL4Parser.LABEL, 0); }
		public TerminalNode TYPE() { return getToken(QL4Parser.TYPE, 0); }
		public RegQuestionContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterRegQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitRegQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitRegQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new RegQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47); match(IDENTIFIER);
				setState(48); match(6);
				setState(49); match(LABEL);
				setState(50); match(6);
				setState(51); match(TYPE);
				setState(52); match(9);
				}
				break;

			case 2:
				_localctx = new CompQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53); match(IDENTIFIER);
				setState(54); match(6);
				setState(55); match(LABEL);
				setState(56); match(6);
				setState(57); match(TYPE);
				setState(58); match(5);
				setState(59); expression(0);
				setState(60); match(1);
				setState(61); match(9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GreExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public GreExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterGreExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitGreExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitGreExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GeqExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public GeqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterGeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitGeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitGeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(QL4Parser.INT, 0); }
		public IntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public LesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterLesExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitLesExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitLesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PlusExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitPlusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WrapExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WrapExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterWrapExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitWrapExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitWrapExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecContext extends ExpressionContext {
		public TerminalNode DEC() { return getToken(QL4Parser.DEC, 0); }
		public DecContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MinExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterMinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitMinExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitMinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(QL4Parser.IDENTIFIER, 0); }
		public IdentContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeqExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public LeqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterLeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitLeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitLeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterNegExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitNegExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitNegExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NeqExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public NeqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterNeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitNeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitNeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(QL4Parser.BOOLEAN, 0); }
		public BoolContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public EqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public DivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			switch (_input.LA(1)) {
			case 19:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66); match(19);
				setState(67); expression(13);
				}
				break;
			case 5:
				{
				_localctx = new WrapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68); match(5);
				setState(69); expression(0);
				setState(70); match(1);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72); match(BOOLEAN);
				}
				break;
			case DEC:
				{
				_localctx = new DecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73); match(DEC);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74); match(INT);
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(78);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(79); match(4);
						setState(80); expression(18);
						}
						break;

					case 2:
						{
						_localctx = new DivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(82); match(15);
						setState(83); expression(17);
						}
						break;

					case 3:
						{
						_localctx = new PlusExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(85); match(2);
						setState(86); expression(16);
						}
						break;

					case 4:
						{
						_localctx = new MinExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(88); match(3);
						setState(89); expression(15);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(91); match(11);
						setState(92); expression(13);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(94); match(12);
						setState(95); expression(12);
						}
						break;

					case 7:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(97); match(16);
						setState(98); expression(11);
						}
						break;

					case 8:
						{
						_localctx = new GeqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(100); match(18);
						setState(101); expression(10);
						}
						break;

					case 9:
						{
						_localctx = new LeqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(103); match(10);
						setState(104); expression(9);
						}
						break;

					case 10:
						{
						_localctx = new GreExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(106); match(14);
						setState(107); expression(8);
						}
						break;

					case 11:
						{
						_localctx = new LesExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(109); match(7);
						setState(110); expression(7);
						}
						break;

					case 12:
						{
						_localctx = new NeqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(112); match(8);
						setState(113); expression(6);
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IfconditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(QL4Parser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterIfcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitIfcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitIfcondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfconditionContext ifcondition() throws RecognitionException {
		IfconditionContext _localctx = new IfconditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifcondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(IF);
			setState(120); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseifconditionContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(QL4Parser.ELSEIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseifconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterElseifcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitElseifcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitElseifcondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifconditionContext elseifcondition() throws RecognitionException {
		ElseifconditionContext _localctx = new ElseifconditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elseifcondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(ELSEIF);
			setState(123); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseconditionContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(QL4Parser.ELSE, 0); }
		public ElseconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsecondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterElsecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitElsecondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitElsecondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseconditionContext elsecondition() throws RecognitionException {
		ElseconditionContext _localctx = new ElseconditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elsecondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(ELSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 17);

		case 1: return precpred(_ctx, 16);

		case 2: return precpred(_ctx, 15);

		case 3: return precpred(_ctx, 14);

		case 4: return precpred(_ctx, 12);

		case 5: return precpred(_ctx, 11);

		case 6: return precpred(_ctx, 10);

		case 7: return precpred(_ctx, 9);

		case 8: return precpred(_ctx, 8);

		case 9: return precpred(_ctx, 7);

		case 10: return precpred(_ctx, 6);

		case 11: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0082\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\6\3"+
		"\26\n\3\r\3\16\3\27\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4$\n\4\f"+
		"\4\16\4\'\13\4\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\5\4\60\n\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6O\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6u\n\6\f\6\16\6x\13\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\2\3\n\n\2\4\6\b\n\f\16\20\2\2\u008f"+
		"\2\22\3\2\2\2\4\25\3\2\2\2\6/\3\2\2\2\bA\3\2\2\2\nN\3\2\2\2\fy\3\2\2\2"+
		"\16|\3\2\2\2\20\177\3\2\2\2\22\23\5\4\3\2\23\3\3\2\2\2\24\26\5\6\4\2\25"+
		"\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\5\3\2\2\2\31"+
		"\60\5\b\5\2\32\33\5\f\7\2\33\34\7\17\2\2\34\35\5\4\3\2\35%\7\23\2\2\36"+
		"\37\5\16\b\2\37 \7\17\2\2 !\5\4\3\2!\"\7\23\2\2\"$\3\2\2\2#\36\3\2\2\2"+
		"$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&-\3\2\2\2\'%\3\2\2\2()\5\20\t\2)*\7\17"+
		"\2\2*+\5\4\3\2+,\7\23\2\2,.\3\2\2\2-(\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/\31"+
		"\3\2\2\2/\32\3\2\2\2\60\7\3\2\2\2\61\62\7\35\2\2\62\63\7\b\2\2\63\64\7"+
		"\26\2\2\64\65\7\b\2\2\65\66\7\30\2\2\66B\7\13\2\2\678\7\35\2\289\7\b\2"+
		"\29:\7\26\2\2:;\7\b\2\2;<\7\30\2\2<=\7\7\2\2=>\5\n\6\2>?\7\3\2\2?@\7\13"+
		"\2\2@B\3\2\2\2A\61\3\2\2\2A\67\3\2\2\2B\t\3\2\2\2CD\b\6\1\2DE\7\25\2\2"+
		"EO\5\n\6\17FG\7\7\2\2GH\5\n\6\2HI\7\3\2\2IO\3\2\2\2JO\7\34\2\2KO\7\37"+
		"\2\2LO\7 \2\2MO\7\35\2\2NC\3\2\2\2NF\3\2\2\2NJ\3\2\2\2NK\3\2\2\2NL\3\2"+
		"\2\2NM\3\2\2\2Ov\3\2\2\2PQ\f\23\2\2QR\7\6\2\2Ru\5\n\6\24ST\f\22\2\2TU"+
		"\7\21\2\2Uu\5\n\6\23VW\f\21\2\2WX\7\4\2\2Xu\5\n\6\22YZ\f\20\2\2Z[\7\5"+
		"\2\2[u\5\n\6\21\\]\f\16\2\2]^\7\r\2\2^u\5\n\6\17_`\f\r\2\2`a\7\16\2\2"+
		"au\5\n\6\16bc\f\f\2\2cd\7\22\2\2du\5\n\6\ref\f\13\2\2fg\7\24\2\2gu\5\n"+
		"\6\fhi\f\n\2\2ij\7\f\2\2ju\5\n\6\13kl\f\t\2\2lm\7\20\2\2mu\5\n\6\nno\f"+
		"\b\2\2op\7\t\2\2pu\5\n\6\tqr\f\7\2\2rs\7\n\2\2su\5\n\6\btP\3\2\2\2tS\3"+
		"\2\2\2tV\3\2\2\2tY\3\2\2\2t\\\3\2\2\2t_\3\2\2\2tb\3\2\2\2te\3\2\2\2th"+
		"\3\2\2\2tk\3\2\2\2tn\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w"+
		"\13\3\2\2\2xv\3\2\2\2yz\7\31\2\2z{\5\n\6\2{\r\3\2\2\2|}\7\32\2\2}~\5\n"+
		"\6\2~\17\3\2\2\2\177\u0080\7\33\2\2\u0080\21\3\2\2\2\n\27%-/ANtv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}