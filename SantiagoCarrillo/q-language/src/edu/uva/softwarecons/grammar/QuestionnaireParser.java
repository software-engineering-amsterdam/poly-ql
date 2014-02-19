// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, MUL=16, DIV=17, 
		ADD=18, SUB=19, NOT=20, AND=21, OR=22, LT=23, LEq=24, GT=25, GEq=26, Eq=27, 
		NEq=28, ID=29, INT=30, STRING=31, WS=32;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "':'", "'('", "'if'", "'decimal'", "'{'", "'else'", 
		"'}'", "'boolean'", "'date'", "')'", "'money'", "'currency'", "'integer'", 
		"'string'", "'*'", "'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'!='", "ID", "INT", "STRING", "WS"
	};
	public static final int
		RULE_questionnaire = 0, RULE_question = 1, RULE_elsestat = 2, RULE_type = 3, 
		RULE_expr = 4;
	public static final String[] ruleNames = {
		"questionnaire", "question", "elsestat", "type", "expr"
	};

	@Override
	public String getGrammarFileName() { return "Questionnaire.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionnaireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QuestionnaireContext extends ParserRuleContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestionnaire(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); match(1);
			setState(11); match(ID);
			setState(12); match(6);
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(13); question();
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 || _la==ID );
			setState(18); match(8);
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
	public static class IfContext extends QuestionContext {
		public ElsestatContext elsestat() {
			return getRuleContext(ElsestatContext.class,0);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public IfContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitIf(this);
		}
	}
	public static class QuestContext extends QuestionContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QuestionnaireParser.STRING, 0); }
		public QuestContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuest(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		int _la;
		try {
			setState(41);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new QuestContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20); match(ID);
				setState(21); match(2);
				setState(22); match(STRING);
				setState(23); type();
				setState(25);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(24); expr(0);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27); match(4);
				setState(28); match(3);
				setState(29); expr(0);
				setState(30); match(11);
				setState(31); match(6);
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(32); question();
					}
					}
					setState(35); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==4 || _la==ID );
				setState(37); match(8);
				setState(39);
				_la = _input.LA(1);
				if (_la==7) {
					{
					setState(38); elsestat();
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

	public static class ElsestatContext extends ParserRuleContext {
		public ElsestatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestat; }
	 
		public ElsestatContext() { }
		public void copyFrom(ElsestatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfElseContext extends ElsestatContext {
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public IfElseContext(ElsestatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitIfElse(this);
		}
	}

	public final ElsestatContext elsestat() throws RecognitionException {
		ElsestatContext _localctx = new ElsestatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_elsestat);
		int _la;
		try {
			_localctx = new IfElseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(7);
			setState(44); match(6);
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45); question();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 || _la==ID );
			setState(50); match(8);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerContext extends TypeContext {
		public IntegerContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitInteger(this);
		}
	}
	public static class StringContext extends TypeContext {
		public StringContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitString(this);
		}
	}
	public static class MoneyContext extends TypeContext {
		public MoneyContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterMoney(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitMoney(this);
		}
	}
	public static class BoolContext extends TypeContext {
		public BoolContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitBool(this);
		}
	}
	public static class DateContext extends TypeContext {
		public DateContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitDate(this);
		}
	}
	public static class DecimalContext extends TypeContext {
		public DecimalContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitDecimal(this);
		}
	}
	public static class CurrencyContext extends TypeContext {
		public CurrencyContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterCurrency(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitCurrency(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(59);
			switch (_input.LA(1)) {
			case 9:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52); match(9);
				}
				break;
			case 15:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53); match(15);
				}
				break;
			case 14:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54); match(14);
				}
				break;
			case 10:
				_localctx = new DateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55); match(10);
				}
				break;
			case 5:
				_localctx = new DecimalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(56); match(5);
				}
				break;
			case 12:
				_localctx = new MoneyContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(57); match(12);
				}
				break;
			case 13:
				_localctx = new CurrencyContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(58); match(13);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitNot(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitId(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(QuestionnaireParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitInt(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOr(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitAddSub(this);
		}
	}
	public static class CompareContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompareContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitCompare(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitParens(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitMulDiv(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitAnd(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(62); match(NOT);
				setState(63); expr(6);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64); match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); match(INT);
				}
				break;
			case 3:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66); match(3);
				setState(67); expr(0);
				setState(68); match(11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(87);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(73);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(74); expr(10);
						}
						break;

					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(76);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(77); expr(9);
						}
						break;

					case 3:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(79);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LEq) | (1L << GT) | (1L << GEq) | (1L << Eq) | (1L << NEq))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(80); expr(8);
						}
						break;

					case 4:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(82); match(AND);
						}
						setState(83); expr(6);
						}
						break;

					case 5:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(85); match(OR);
						}
						setState(86); expr(5);
						}
						break;
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 9);

		case 1: return precpred(_ctx, 8);

		case 2: return precpred(_ctx, 7);

		case 3: return precpred(_ctx, 5);

		case 4: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"_\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3$\n\3\r"+
		"\3\16\3%\3\3\3\3\5\3*\n\3\5\3,\n\3\3\4\3\4\3\4\6\4\61\n\4\r\4\16\4\62"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6I\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\6\2\3\n\7\2\4\6\b\n\2\5\3\2\22"+
		"\23\3\2\24\25\3\2\31\36m\2\f\3\2\2\2\4+\3\2\2\2\6-\3\2\2\2\b=\3\2\2\2"+
		"\nH\3\2\2\2\f\r\7\3\2\2\r\16\7\37\2\2\16\20\7\b\2\2\17\21\5\4\3\2\20\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25"+
		"\7\n\2\2\25\3\3\2\2\2\26\27\7\37\2\2\27\30\7\4\2\2\30\31\7!\2\2\31\33"+
		"\5\b\5\2\32\34\5\n\6\2\33\32\3\2\2\2\33\34\3\2\2\2\34,\3\2\2\2\35\36\7"+
		"\6\2\2\36\37\7\5\2\2\37 \5\n\6\2 !\7\r\2\2!#\7\b\2\2\"$\5\4\3\2#\"\3\2"+
		"\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\')\7\n\2\2(*\5\6\4\2)(\3"+
		"\2\2\2)*\3\2\2\2*,\3\2\2\2+\26\3\2\2\2+\35\3\2\2\2,\5\3\2\2\2-.\7\t\2"+
		"\2.\60\7\b\2\2/\61\5\4\3\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\63\64\3\2\2\2\64\65\7\n\2\2\65\7\3\2\2\2\66>\7\13\2\2\67>"+
		"\7\21\2\28>\7\20\2\29>\7\f\2\2:>\7\7\2\2;>\7\16\2\2<>\7\17\2\2=\66\3\2"+
		"\2\2=\67\3\2\2\2=8\3\2\2\2=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\t"+
		"\3\2\2\2?@\b\6\1\2@A\7\26\2\2AI\5\n\6\bBI\7\37\2\2CI\7 \2\2DE\7\5\2\2"+
		"EF\5\n\6\2FG\7\r\2\2GI\3\2\2\2H?\3\2\2\2HB\3\2\2\2HC\3\2\2\2HD\3\2\2\2"+
		"I[\3\2\2\2JK\f\13\2\2KL\t\2\2\2LZ\5\n\6\fMN\f\n\2\2NO\t\3\2\2OZ\5\n\6"+
		"\13PQ\f\t\2\2QR\t\4\2\2RZ\5\n\6\nST\f\7\2\2TU\7\27\2\2UZ\5\n\6\bVW\f\6"+
		"\2\2WX\7\30\2\2XZ\5\n\6\7YJ\3\2\2\2YM\3\2\2\2YP\3\2\2\2YS\3\2\2\2YV\3"+
		"\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\13\3\2\2\2][\3\2\2\2\f\22\33%"+
		")+\62=HY[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}