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
		T__2=17, T__1=18, T__0=19, COMMENT=20, TYPE=21, IF=22, ELSEIF=23, ELSE=24, 
		BOOLEAN=25, IDENTIFIER=26, STRING=27, DEC=28, INT=29, WS=30;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'!='", 
		"';'", "'<='", "'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", 
		"'!'", "COMMENT", "TYPE", "'if'", "'elseif'", "'else'", "BOOLEAN", "IDENTIFIER", 
		"STRING", "DEC", "INT", "WS"
	};
	public static final int
		RULE_form = 0, RULE_structures = 1, RULE_structure = 2, RULE_question = 3, 
		RULE_expression = 4, RULE_ifcondition = 5, RULE_elseifcondition = 6, RULE_elsecondition = 7, 
		RULE_label = 8;
	public static final String[] ruleNames = {
		"form", "structures", "structure", "question", "expression", "ifcondition", 
		"elseifcondition", "elsecondition", "label"
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
			setState(18); structures();
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
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); structure();
				}
				}
				setState(23); 
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
			setState(47);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new QuestionStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25); question();
				}
				break;
			case IF:
				_localctx = new WorkflowStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26); ifcondition();
				setState(27); match(13);
				setState(28); structures();
				setState(29); match(17);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(30); elseifcondition();
					setState(31); match(13);
					setState(32); structures();
					setState(33); match(17);
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(45);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(40); elsecondition();
					setState(41); match(13);
					setState(42); structures();
					setState(43); match(17);
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
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
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
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
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
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new RegQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49); match(IDENTIFIER);
				setState(50); match(6);
				setState(51); label();
				setState(52); match(6);
				setState(53); match(TYPE);
				setState(54); match(9);
				}
				break;

			case 2:
				_localctx = new CompQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(IDENTIFIER);
				setState(57); match(6);
				setState(58); label();
				setState(59); match(6);
				setState(60); match(TYPE);
				setState(61); match(5);
				setState(62); expression(0);
				setState(63); match(1);
				setState(64); match(9);
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
			setState(79);
			switch (_input.LA(1)) {
			case 19:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(69); match(19);
				setState(70); expression(13);
				}
				break;
			case 5:
				{
				_localctx = new WrapExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71); match(5);
				setState(72); expression(0);
				setState(73); match(1);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); match(BOOLEAN);
				}
				break;
			case DEC:
				{
				_localctx = new DecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76); match(DEC);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(INT);
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(117);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(82); match(4);
						setState(83); expression(18);
						}
						break;

					case 2:
						{
						_localctx = new DivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(85); match(15);
						setState(86); expression(17);
						}
						break;

					case 3:
						{
						_localctx = new PlusExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(88); match(2);
						setState(89); expression(16);
						}
						break;

					case 4:
						{
						_localctx = new MinExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(91); match(3);
						setState(92); expression(15);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(94); match(11);
						setState(95); expression(13);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(97); match(12);
						setState(98); expression(12);
						}
						break;

					case 7:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(100); match(16);
						setState(101); expression(11);
						}
						break;

					case 8:
						{
						_localctx = new GeqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(103); match(18);
						setState(104); expression(10);
						}
						break;

					case 9:
						{
						_localctx = new LeqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(106); match(10);
						setState(107); expression(9);
						}
						break;

					case 10:
						{
						_localctx = new GreExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(109); match(14);
						setState(110); expression(8);
						}
						break;

					case 11:
						{
						_localctx = new LesExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(112); match(7);
						setState(113); expression(7);
						}
						break;

					case 12:
						{
						_localctx = new NeqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(115); match(8);
						setState(116); expression(6);
						}
						break;
					}
					} 
				}
				setState(121);
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
			setState(122); match(IF);
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
			setState(125); match(ELSEIF);
			setState(126); expression(0);
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
			setState(128); match(ELSE);
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QL4Parser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QL4Listener ) ((QL4Listener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QL4Visitor ) return ((QL4Visitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(STRING);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u0087\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\6\3\30\n\3\r\3\16\3\31\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4&\n\4\f\4\16\4)\13\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\5\4\62\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5E\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6x\n\6"+
		"\f\6\16\6{\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\3\n\13\2"+
		"\4\6\b\n\f\16\20\22\2\2\u0093\2\24\3\2\2\2\4\27\3\2\2\2\6\61\3\2\2\2\b"+
		"D\3\2\2\2\nQ\3\2\2\2\f|\3\2\2\2\16\177\3\2\2\2\20\u0082\3\2\2\2\22\u0084"+
		"\3\2\2\2\24\25\5\4\3\2\25\3\3\2\2\2\26\30\5\6\4\2\27\26\3\2\2\2\30\31"+
		"\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\5\3\2\2\2\33\62\5\b\5\2\34\35"+
		"\5\f\7\2\35\36\7\17\2\2\36\37\5\4\3\2\37\'\7\23\2\2 !\5\16\b\2!\"\7\17"+
		"\2\2\"#\5\4\3\2#$\7\23\2\2$&\3\2\2\2% \3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'"+
		"(\3\2\2\2(/\3\2\2\2)\'\3\2\2\2*+\5\20\t\2+,\7\17\2\2,-\5\4\3\2-.\7\23"+
		"\2\2.\60\3\2\2\2/*\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61\33\3\2\2\2\61"+
		"\34\3\2\2\2\62\7\3\2\2\2\63\64\7\34\2\2\64\65\7\b\2\2\65\66\5\22\n\2\66"+
		"\67\7\b\2\2\678\7\27\2\289\7\13\2\29E\3\2\2\2:;\7\34\2\2;<\7\b\2\2<=\5"+
		"\22\n\2=>\7\b\2\2>?\7\27\2\2?@\7\7\2\2@A\5\n\6\2AB\7\3\2\2BC\7\13\2\2"+
		"CE\3\2\2\2D\63\3\2\2\2D:\3\2\2\2E\t\3\2\2\2FG\b\6\1\2GH\7\25\2\2HR\5\n"+
		"\6\17IJ\7\7\2\2JK\5\n\6\2KL\7\3\2\2LR\3\2\2\2MR\7\33\2\2NR\7\36\2\2OR"+
		"\7\37\2\2PR\7\34\2\2QF\3\2\2\2QI\3\2\2\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2"+
		"QP\3\2\2\2Ry\3\2\2\2ST\f\23\2\2TU\7\6\2\2Ux\5\n\6\24VW\f\22\2\2WX\7\21"+
		"\2\2Xx\5\n\6\23YZ\f\21\2\2Z[\7\4\2\2[x\5\n\6\22\\]\f\20\2\2]^\7\5\2\2"+
		"^x\5\n\6\21_`\f\16\2\2`a\7\r\2\2ax\5\n\6\17bc\f\r\2\2cd\7\16\2\2dx\5\n"+
		"\6\16ef\f\f\2\2fg\7\22\2\2gx\5\n\6\rhi\f\13\2\2ij\7\24\2\2jx\5\n\6\fk"+
		"l\f\n\2\2lm\7\f\2\2mx\5\n\6\13no\f\t\2\2op\7\20\2\2px\5\n\6\nqr\f\b\2"+
		"\2rs\7\t\2\2sx\5\n\6\ttu\f\7\2\2uv\7\n\2\2vx\5\n\6\bwS\3\2\2\2wV\3\2\2"+
		"\2wY\3\2\2\2w\\\3\2\2\2w_\3\2\2\2wb\3\2\2\2we\3\2\2\2wh\3\2\2\2wk\3\2"+
		"\2\2wn\3\2\2\2wq\3\2\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\13\3"+
		"\2\2\2{y\3\2\2\2|}\7\30\2\2}~\5\n\6\2~\r\3\2\2\2\177\u0080\7\31\2\2\u0080"+
		"\u0081\5\n\6\2\u0081\17\3\2\2\2\u0082\u0083\7\32\2\2\u0083\21\3\2\2\2"+
		"\u0084\u0085\7\35\2\2\u0085\23\3\2\2\2\n\31\'/\61DQwy";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}