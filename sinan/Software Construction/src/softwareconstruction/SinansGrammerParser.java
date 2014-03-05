// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SinansGrammerParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, TYPE=20, IDENTIFIER=21, STRING=22, LETTER=23, 
		DIGIT=24, BOOL=25, OPERATOR=26, WS=27, INT=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", 
		"'<'", "'<='", "'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", 
		"'!'", "TYPE", "IDENTIFIER", "STRING", "LETTER", "DIGIT", "BOOL", "OPERATOR", 
		"WS", "INT"
	};
	public static final int
		RULE_form = 0, RULE_item = 1, RULE_question = 2, RULE_conditional = 3, 
		RULE_ifstatement = 4, RULE_expression = 5;
	public static final String[] ruleNames = {
		"form", "item", "question", "conditional", "ifstatement", "expression"
	};

	@Override
	public String getGrammarFileName() { return "SinansGrammer.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SinansGrammerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public Form fo;
		public Token IDENTIFIER;
		public ItemContext item;
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		((FormContext)_localctx).fo =  new Form();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); match(1);
			setState(13); ((FormContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			_localctx.fo.setFormName((((FormContext)_localctx).IDENTIFIER!=null?((FormContext)_localctx).IDENTIFIER.getText():null));
			setState(15); match(13);
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); ((FormContext)_localctx).item = item();
				 _localctx.fo.addQuestion(((FormContext)_localctx).item.object);
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==8 || _la==IDENTIFIER );
			setState(23); match(17);
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

	public static class ItemContext extends ParserRuleContext {
		public Object object;
		public ConditionalContext conditional;
		public QuestionContext question;
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_item);
		((ItemContext)_localctx).object =  new Object();
		try {
			setState(31);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(25); ((ItemContext)_localctx).conditional = conditional();
				((ItemContext)_localctx).object =  ((ItemContext)_localctx).conditional.cqe;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); ((ItemContext)_localctx).question = question();
				((ItemContext)_localctx).object =  ((ItemContext)_localctx).question.qe;
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
		public Question qe;
		public Token IDENTIFIER;
		public Token STRING;
		public Token TYPE;
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(SinansGrammerParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(SinansGrammerParser.TYPE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		((QuestionContext)_localctx).qe =  new Question();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.qe.setQuestionName((((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null)); 
			setState(35); match(7);
			setState(36); ((QuestionContext)_localctx).STRING = match(STRING);
			 _localctx.qe.setQuestionContent((((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null)); 
			setState(38); ((QuestionContext)_localctx).TYPE = match(TYPE);
			 _localctx.qe.setQuestionType((((QuestionContext)_localctx).TYPE!=null?((QuestionContext)_localctx).TYPE.getText():null));
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

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalQuestion cqe;
		public ItemContext item;
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_conditional);
		((ConditionalContext)_localctx).cqe =  new ConditionalQuestion();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); ifstatement();
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42); ((ConditionalContext)_localctx).item = item();
				 _localctx.cqe.add(((ConditionalContext)_localctx).item.object); 
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==8 || _la==IDENTIFIER );
			setState(49); match(17);
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

	public static class IfstatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitIfstatement(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(8);
			setState(52); match(6);
			setState(53); expression(0);
			setState(54); match(2);
			setState(55); match(13);
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
		public Expression exp;
		public Token BOOL;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOL() { return getToken(SinansGrammerParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(SinansGrammerParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode STRING() { return getToken(SinansGrammerParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitExpression(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(58); match(INT);
				}
				break;
			case BOOL:
				{
				setState(59); ((ExpressionContext)_localctx).BOOL = match(BOOL);
				((ExpressionContext)_localctx).exp =  new BoolLiteral(Boolean.parseBoolean((((ExpressionContext)_localctx).BOOL!=null?((ExpressionContext)_localctx).BOOL.getText():null)));
				}
				break;
			case STRING:
				{
				setState(61); match(STRING);
				}
				break;
			case 19:
			case IDENTIFIER:
				{
				setState(63);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(62); match(19);
					}
				}

				setState(65); match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(101);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(68);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(69); match(5);
						setState(70); expression(12);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(71);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(72); match(15);
						setState(73); expression(11);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(74);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(75); match(3);
						setState(76); expression(10);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(77);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(78); match(4);
						setState(79); expression(9);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(81); match(12);
						setState(82); expression(8);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(83);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(84); match(11);
						setState(85); expression(7);
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(87); match(16);
						setState(88); expression(6);
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(90); match(14);
						setState(91); expression(5);
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(93); match(9);
						setState(94); expression(4);
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(95);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(96); match(18);
						setState(97); expression(3);
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(99); match(10);
						setState(100); expression(2);
						}
						break;
					}
					} 
				}
				setState(105);
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
		case 5: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);

		case 1: return precpred(_ctx, 10);

		case 2: return precpred(_ctx, 9);

		case 3: return precpred(_ctx, 8);

		case 4: return precpred(_ctx, 7);

		case 5: return precpred(_ctx, 6);

		case 6: return precpred(_ctx, 5);

		case 7: return precpred(_ctx, 4);

		case 8: return precpred(_ctx, 3);

		case 9: return precpred(_ctx, 2);

		case 10: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36m\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7B\n\7\3\7\5\7E\n\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7h\n\7"+
		"\f\7\16\7k\13\7\3\7\2\3\f\b\2\4\6\b\n\f\2\2x\2\16\3\2\2\2\4!\3\2\2\2\6"+
		"#\3\2\2\2\b+\3\2\2\2\n\65\3\2\2\2\fD\3\2\2\2\16\17\7\3\2\2\17\20\7\27"+
		"\2\2\20\21\b\2\1\2\21\25\7\17\2\2\22\23\5\4\3\2\23\24\b\2\1\2\24\26\3"+
		"\2\2\2\25\22\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\31\3"+
		"\2\2\2\31\32\7\23\2\2\32\3\3\2\2\2\33\34\5\b\5\2\34\35\b\3\1\2\35\"\3"+
		"\2\2\2\36\37\5\6\4\2\37 \b\3\1\2 \"\3\2\2\2!\33\3\2\2\2!\36\3\2\2\2\""+
		"\5\3\2\2\2#$\7\27\2\2$%\b\4\1\2%&\7\t\2\2&\'\7\30\2\2\'(\b\4\1\2()\7\26"+
		"\2\2)*\b\4\1\2*\7\3\2\2\2+/\5\n\6\2,-\5\4\3\2-.\b\5\1\2.\60\3\2\2\2/,"+
		"\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7"+
		"\23\2\2\64\t\3\2\2\2\65\66\7\n\2\2\66\67\7\b\2\2\678\5\f\7\289\7\4\2\2"+
		"9:\7\17\2\2:\13\3\2\2\2;<\b\7\1\2<E\7\36\2\2=>\7\33\2\2>E\b\7\1\2?E\7"+
		"\30\2\2@B\7\25\2\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CE\7\27\2\2D;\3\2\2\2"+
		"D=\3\2\2\2D?\3\2\2\2DA\3\2\2\2Ei\3\2\2\2FG\f\r\2\2GH\7\7\2\2Hh\5\f\7\16"+
		"IJ\f\f\2\2JK\7\21\2\2Kh\5\f\7\rLM\f\13\2\2MN\7\5\2\2Nh\5\f\7\fOP\f\n\2"+
		"\2PQ\7\6\2\2Qh\5\f\7\13RS\f\t\2\2ST\7\16\2\2Th\5\f\7\nUV\f\b\2\2VW\7\r"+
		"\2\2Wh\5\f\7\tXY\f\7\2\2YZ\7\22\2\2Zh\5\f\7\b[\\\f\6\2\2\\]\7\20\2\2]"+
		"h\5\f\7\7^_\f\5\2\2_`\7\13\2\2`h\5\f\7\6ab\f\4\2\2bc\7\24\2\2ch\5\f\7"+
		"\5de\f\3\2\2ef\7\f\2\2fh\5\f\7\4gF\3\2\2\2gI\3\2\2\2gL\3\2\2\2gO\3\2\2"+
		"\2gR\3\2\2\2gU\3\2\2\2gX\3\2\2\2g[\3\2\2\2g^\3\2\2\2ga\3\2\2\2gd\3\2\2"+
		"\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\r\3\2\2\2ki\3\2\2\2\t\27!\61ADgi";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}