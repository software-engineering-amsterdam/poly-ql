// Generated from grammar/Form2.g4 by ANTLR 4.2

	package Form2;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Form2Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, TYPE=20, IF=21, ELSEIF=22, ELSE=23, IDENTIFIER=24, 
		STRING=25, INT=26, WS=27;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'!='", 
		"';'", "'<='", "'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", 
		"'!'", "TYPE", "'if'", "'elseif'", "'else'", "IDENTIFIER", "STRING", "INT", 
		"WS"
	};
	public static final int
		RULE_form = 0, RULE_structure = 1, RULE_ifcondition = 2, RULE_elseifcondition = 3, 
		RULE_elsecondition = 4, RULE_question = 5, RULE_expression = 6, RULE_label = 7;
	public static final String[] ruleNames = {
		"form", "structure", "ifcondition", "elseifcondition", "elsecondition", 
		"question", "expression", "label"
	};

	@Override
	public String getGrammarFileName() { return "Form2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Form2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public StructureContext structure(int i) {
			return getRuleContext(StructureContext.class,i);
		}
		public List<StructureContext> structure() {
			return getRuleContexts(StructureContext.class);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); structure();
				}
				}
				setState(19); 
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
		public List<ElseconditionContext> elsecondition() {
			return getRuleContexts(ElseconditionContext.class);
		}
		public List<ElseifconditionContext> elseifcondition() {
			return getRuleContexts(ElseifconditionContext.class);
		}
		public StructureContext structure(int i) {
			return getRuleContext(StructureContext.class,i);
		}
		public ElseconditionContext elsecondition(int i) {
			return getRuleContext(ElseconditionContext.class,i);
		}
		public IfconditionContext ifcondition() {
			return getRuleContext(IfconditionContext.class,0);
		}
		public ElseifconditionContext elseifcondition(int i) {
			return getRuleContext(ElseifconditionContext.class,i);
		}
		public List<StructureContext> structure() {
			return getRuleContexts(StructureContext.class);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitStructure(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(21); question();
				}
				break;

			case 2:
				{
				setState(22); ifcondition();
				setState(23); match(13);
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(24); structure();
					}
					}
					setState(27); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==IDENTIFIER );
				setState(29); match(17);
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(30); elseifcondition();
					setState(31); match(13);
					setState(33); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(32); structure();
						}
						}
						setState(35); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==IF || _la==IDENTIFIER );
					setState(37); match(17);
					}
					}
					setState(41); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ELSEIF );
				setState(43); elsecondition();
				setState(44); match(13);
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(45); structure();
					}
					}
					setState(48); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==IDENTIFIER );
				setState(50); match(17);
				}
				break;

			case 3:
				{
				setState(52); ifcondition();
				setState(53); match(13);
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(54); structure();
					}
					}
					setState(57); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==IDENTIFIER );
				setState(59); match(17);
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(60); elseifcondition();
					setState(61); match(13);
					setState(63); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(62); structure();
						}
						}
						setState(65); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==IF || _la==IDENTIFIER );
					setState(67); match(17);
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ELSEIF );
				}
				break;

			case 4:
				{
				setState(73); ifcondition();
				setState(74); match(13);
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(75); structure();
					}
					}
					setState(78); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==IDENTIFIER );
				setState(80); match(17);
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(81); elsecondition();
					setState(82); match(13);
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(83); structure();
						}
						}
						setState(86); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==IF || _la==IDENTIFIER );
					setState(88); match(17);
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ELSE );
				}
				break;

			case 5:
				{
				setState(94); ifcondition();
				setState(95); match(13);
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(96); structure();
					}
					}
					setState(99); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==IDENTIFIER );
				setState(101); match(17);
				}
				break;
			}
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

	public static class IfconditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Form2Parser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterIfcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitIfcondition(this);
		}
	}

	public final IfconditionContext ifcondition() throws RecognitionException {
		IfconditionContext _localctx = new IfconditionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifcondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); match(IF);
			setState(106); expression(0);
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
		public TerminalNode ELSEIF() { return getToken(Form2Parser.ELSEIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseifconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterElseifcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitElseifcondition(this);
		}
	}

	public final ElseifconditionContext elseifcondition() throws RecognitionException {
		ElseifconditionContext _localctx = new ElseifconditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_elseifcondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(ELSEIF);
			setState(109); expression(0);
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
		public TerminalNode ELSE() { return getToken(Form2Parser.ELSE, 0); }
		public ElseconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsecondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterElsecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitElsecondition(this);
		}
	}

	public final ElseconditionContext elsecondition() throws RecognitionException {
		ElseconditionContext _localctx = new ElseconditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elsecondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(ELSE);
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
		public TerminalNode IDENTIFIER() { return getToken(Form2Parser.IDENTIFIER, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(Form2Parser.TYPE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113); match(IDENTIFIER);
				setState(114); match(6);
				setState(115); label();
				setState(116); match(6);
				setState(117); match(TYPE);
				setState(118); match(9);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); match(IDENTIFIER);
				setState(121); match(6);
				setState(122); label();
				setState(123); match(6);
				setState(124); match(TYPE);
				setState(125); match(5);
				setState(126); expression(0);
				setState(127); match(1);
				setState(128); match(9);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INT() { return getToken(Form2Parser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Form2Parser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitExpression(this);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			switch (_input.LA(1)) {
			case 19:
				{
				setState(133); match(19);
				setState(134); expression(5);
				}
				break;
			case 5:
				{
				setState(135); match(5);
				setState(136); expression(0);
				setState(137); match(1);
				}
				break;
			case INT:
				{
				setState(139); match(INT);
				}
				break;
			case IDENTIFIER:
				{
				setState(140); match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(155);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(143);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(144);
						_la = _input.LA(1);
						if ( !(_la==4 || _la==15) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(145); expression(8);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(146);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(147);
						_la = _input.LA(1);
						if ( !(_la==2 || _la==3) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(148); expression(7);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(150);
						_la = _input.LA(1);
						if ( !(_la==11 || _la==12) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(151); expression(5);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(153);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 8) | (1L << 10) | (1L << 14) | (1L << 16) | (1L << 18))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(154); expression(4);
						}
						break;
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Form2Parser.STRING, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Form2Listener ) ((Form2Listener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(STRING);
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
		case 6: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);

		case 1: return precpred(_ctx, 6);

		case 2: return precpred(_ctx, 4);

		case 3: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00a5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n"+
		"\2\r\2\16\2\25\3\3\3\3\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\3\3\3\3\3\3"+
		"\6\3$\n\3\r\3\16\3%\3\3\3\3\6\3*\n\3\r\3\16\3+\3\3\3\3\3\3\6\3\61\n\3"+
		"\r\3\16\3\62\3\3\3\3\3\3\3\3\3\3\6\3:\n\3\r\3\16\3;\3\3\3\3\3\3\3\3\6"+
		"\3B\n\3\r\3\16\3C\3\3\3\3\6\3H\n\3\r\3\16\3I\3\3\3\3\3\3\6\3O\n\3\r\3"+
		"\16\3P\3\3\3\3\3\3\3\3\6\3W\n\3\r\3\16\3X\3\3\3\3\6\3]\n\3\r\3\16\3^\3"+
		"\3\3\3\3\3\6\3d\n\3\r\3\16\3e\3\3\3\3\5\3j\n\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0085\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0090\n\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u009e\n\b\f\b\16"+
		"\b\u00a1\13\b\3\t\3\t\3\t\2\3\16\n\2\4\6\b\n\f\16\20\2\6\4\2\6\6\21\21"+
		"\3\2\4\5\3\2\r\16\7\2\t\n\f\f\20\20\22\22\24\24\u00b4\2\23\3\2\2\2\4i"+
		"\3\2\2\2\6k\3\2\2\2\bn\3\2\2\2\nq\3\2\2\2\f\u0084\3\2\2\2\16\u008f\3\2"+
		"\2\2\20\u00a2\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23"+
		"\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27j\5\f\7\2\30\31\5\6\4\2\31\33\7"+
		"\17\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36"+
		"\3\2\2\2\36\37\3\2\2\2\37)\7\23\2\2 !\5\b\5\2!#\7\17\2\2\"$\5\4\3\2#\""+
		"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\23\2\2(*\3\2\2"+
		"\2) \3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\5\n\6\2.\60\7\17"+
		"\2\2/\61\5\4\3\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\64\3\2\2\2\64\65\7\23\2\2\65j\3\2\2\2\66\67\5\6\4\2\679\7\17\2\28"+
		":\5\4\3\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=G\7\23\2\2"+
		">?\5\b\5\2?A\7\17\2\2@B\5\4\3\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2"+
		"\2DE\3\2\2\2EF\7\23\2\2FH\3\2\2\2G>\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2Jj\3\2\2\2KL\5\6\4\2LN\7\17\2\2MO\5\4\3\2NM\3\2\2\2OP\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2QR\3\2\2\2R\\\7\23\2\2ST\5\n\6\2TV\7\17\2\2UW\5\4\3\2"+
		"VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\23\2\2[]\3\2\2"+
		"\2\\S\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_j\3\2\2\2`a\5\6\4\2ac\7\17"+
		"\2\2bd\5\4\3\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\23"+
		"\2\2hj\3\2\2\2i\27\3\2\2\2i\30\3\2\2\2i\66\3\2\2\2iK\3\2\2\2i`\3\2\2\2"+
		"j\5\3\2\2\2kl\7\27\2\2lm\5\16\b\2m\7\3\2\2\2no\7\30\2\2op\5\16\b\2p\t"+
		"\3\2\2\2qr\7\31\2\2r\13\3\2\2\2st\7\32\2\2tu\7\b\2\2uv\5\20\t\2vw\7\b"+
		"\2\2wx\7\26\2\2xy\7\13\2\2y\u0085\3\2\2\2z{\7\32\2\2{|\7\b\2\2|}\5\20"+
		"\t\2}~\7\b\2\2~\177\7\26\2\2\177\u0080\7\7\2\2\u0080\u0081\5\16\b\2\u0081"+
		"\u0082\7\3\2\2\u0082\u0083\7\13\2\2\u0083\u0085\3\2\2\2\u0084s\3\2\2\2"+
		"\u0084z\3\2\2\2\u0085\r\3\2\2\2\u0086\u0087\b\b\1\2\u0087\u0088\7\25\2"+
		"\2\u0088\u0090\5\16\b\7\u0089\u008a\7\7\2\2\u008a\u008b\5\16\b\2\u008b"+
		"\u008c\7\3\2\2\u008c\u0090\3\2\2\2\u008d\u0090\7\34\2\2\u008e\u0090\7"+
		"\32\2\2\u008f\u0086\3\2\2\2\u008f\u0089\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u009f\3\2\2\2\u0091\u0092\f\t\2\2\u0092\u0093\t\2"+
		"\2\2\u0093\u009e\5\16\b\n\u0094\u0095\f\b\2\2\u0095\u0096\t\3\2\2\u0096"+
		"\u009e\5\16\b\t\u0097\u0098\f\6\2\2\u0098\u0099\t\4\2\2\u0099\u009e\5"+
		"\16\b\7\u009a\u009b\f\5\2\2\u009b\u009c\t\5\2\2\u009c\u009e\5\16\b\6\u009d"+
		"\u0091\3\2\2\2\u009d\u0094\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u009a\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\17\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\33\2\2\u00a3\21\3\2\2\2"+
		"\23\25\35%+\62;CIPX^ei\u0084\u008f\u009d\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}