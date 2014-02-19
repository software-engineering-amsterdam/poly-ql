package edu.uva.softwarecons.grammar;// Generated from Questionnaire.g4 by ANTLR 4.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, MUL=15, DIV=16, ADD=17, SUB=18, 
		NOT=19, AND=20, OR=21, LT=22, LEq=23, GT=24, GEq=25, Eq=26, NEq=27, ID=28, 
		INT=29, STRING=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'('", "':'", "'money'", "'if'", "'decimal'", 
		"'currency'", "'{'", "'integer'", "'string'", "'boolean'", "'}'", "'date'", 
		"'*'", "'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'<'", "'<='", "'>'", 
		"'>='", "'=='", "'!='", "ID", "INT", "STRING", "WS"
	};
	public static final int
		RULE_questionnaire = 0, RULE_question = 1, RULE_type = 2, RULE_expr = 3;
	public static final String[] ruleNames = {
		"questionnaire", "question", "type", "expr"
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
			setState(8); match(1);
			setState(9); match(ID);
			setState(10); match(9);
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11); question();
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==ID );
			setState(16); match(13);
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
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QuestionnaireParser.STRING, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		int _la;
		try {
			setState(37);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(18); match(ID);
				setState(19); match(4);
				setState(20); match(STRING);
				setState(21); type();
				setState(23);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(22); expr(0);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(6);
				setState(26); match(3);
				setState(27); expr(0);
				setState(28); match(2);
				setState(29); match(9);
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(30); question();
					}
					}
					setState(33); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==ID );
				setState(35); match(13);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 7) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public Token op;
		public TerminalNode INT() { return getToken(QuestionnaireParser.INT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(42); match(NOT);
				setState(43); expr(6);
				}
				break;
			case ID:
				{
				setState(44); match(ID);
				}
				break;
			case INT:
				{
				setState(45); match(INT);
				}
				break;
			case 3:
				{
				setState(46); match(3);
				setState(47); expr(0);
				setState(48); match(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(52);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(53);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(54); expr(10);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(56);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(57); expr(9);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(59);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LEq) | (1L << GT) | (1L << GEq) | (1L << Eq) | (1L << NEq))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(60); expr(8);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(62); match(AND);
						}
						setState(63); expr(6);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(65); match(OR);
						}
						setState(66); expr(5);
						}
						break;
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		case 3: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!K\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\6\2\17\n\2\r\2\16\2\20\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\"\n\3\r\3\16\3#"+
		"\3\3\3\3\5\3(\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\65\n"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5F\n"+
		"\5\f\5\16\5I\13\5\3\5\2\3\b\6\2\4\6\b\2\6\6\2\7\7\t\n\f\16\20\20\3\2\21"+
		"\22\3\2\23\24\3\2\30\35R\2\n\3\2\2\2\4\'\3\2\2\2\6)\3\2\2\2\b\64\3\2\2"+
		"\2\n\13\7\3\2\2\13\f\7\36\2\2\f\16\7\13\2\2\r\17\5\4\3\2\16\r\3\2\2\2"+
		"\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\22\3\2\2\2\22\23\7\17\2"+
		"\2\23\3\3\2\2\2\24\25\7\36\2\2\25\26\7\6\2\2\26\27\7 \2\2\27\31\5\6\4"+
		"\2\30\32\5\b\5\2\31\30\3\2\2\2\31\32\3\2\2\2\32(\3\2\2\2\33\34\7\b\2\2"+
		"\34\35\7\5\2\2\35\36\5\b\5\2\36\37\7\4\2\2\37!\7\13\2\2 \"\5\4\3\2! \3"+
		"\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\17\2\2&(\3\2\2\2\'"+
		"\24\3\2\2\2\'\33\3\2\2\2(\5\3\2\2\2)*\t\2\2\2*\7\3\2\2\2+,\b\5\1\2,-\7"+
		"\25\2\2-\65\5\b\5\b.\65\7\36\2\2/\65\7\37\2\2\60\61\7\5\2\2\61\62\5\b"+
		"\5\2\62\63\7\4\2\2\63\65\3\2\2\2\64+\3\2\2\2\64.\3\2\2\2\64/\3\2\2\2\64"+
		"\60\3\2\2\2\65G\3\2\2\2\66\67\f\13\2\2\678\t\3\2\28F\5\b\5\f9:\f\n\2\2"+
		":;\t\4\2\2;F\5\b\5\13<=\f\t\2\2=>\t\5\2\2>F\5\b\5\n?@\f\7\2\2@A\7\26\2"+
		"\2AF\5\b\5\bBC\f\6\2\2CD\7\27\2\2DF\5\b\5\7E\66\3\2\2\2E9\3\2\2\2E<\3"+
		"\2\2\2E?\3\2\2\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\t\3\2\2\2IG"+
		"\3\2\2\2\t\20\31#\'\64EG";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}