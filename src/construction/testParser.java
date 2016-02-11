// Generated from C:\Users\svene_000\Documents\NetBeansProjects\Construction\src\construction\test.g by ANTLR 4.2

package construction;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import construction.Operators.*;
import construction.Types.*;
import construction.QuestionElements.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__25=1, T__24=2, T__23=3, T__22=4, T__21=5, T__20=6, T__19=7, T__18=8, 
		T__17=9, T__16=10, T__15=11, T__14=12, T__13=13, T__12=14, T__11=15, T__10=16, 
		T__9=17, T__8=18, T__7=19, T__6=20, T__5=21, T__4=22, T__3=23, T__2=24, 
		T__1=25, T__0=26, BOOL=27, INT=28, IDENTIFIER=29, STRING=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'*'", "'-'", "'or'", "'not'", "':'", "'('", "'if'", 
		"'<'", "'<='", "'~='", "'{'", "'and'", "'else'", "'}'", "'boolean'", "'%'", 
		"'^'", "')'", "'+'", "'money'", "'>'", "'string'", "'=='", "'/'", "'>='", 
		"BOOL", "INT", "IDENTIFIER", "STRING", "WS"
	};
	public static final int
		RULE_questionaire = 0, RULE_item = 1, RULE_questionentry = 2, RULE_conditional = 3, 
		RULE_computed = 4, RULE_type = 5, RULE_exp = 6;
	public static final String[] ruleNames = {
		"questionaire", "item", "questionentry", "conditional", "computed", "type", 
		"exp"
	};

	@Override
	public String getGrammarFileName() { return "test.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	/** Map variable name to Integer object holding value */
	Map<String,IType> memory = new HashMap<String,IType>();

	public testParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QuestionaireContext extends ParserRuleContext {
		public QuestionForm form;
		public Token IDENTIFIER;
		public ItemContext item;
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public QuestionaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterQuestionaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitQuestionaire(this);
		}
	}

	public final QuestionaireContext questionaire() throws RecognitionException {
		QuestionaireContext _localctx = new QuestionaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionaire);
		((QuestionaireContext)_localctx).form =  new QuestionForm();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); match(1);
			setState(15); ((QuestionaireContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			_localctx.form.setName(((((QuestionaireContext)_localctx).IDENTIFIER!=null?((QuestionaireContext)_localctx).IDENTIFIER.getText():null)));
			setState(17); match(12);
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18); ((QuestionaireContext)_localctx).item = item();
				_localctx.form.add(((QuestionaireContext)_localctx).item.question);
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==8 || _la==IDENTIFIER );
			setState(25); match(15);
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
		public GeneralQuestion question;
		public ConditionalContext conditional;
		public ComputedContext computed;
		public QuestionentryContext questionentry;
		public QuestionentryContext questionentry() {
			return getRuleContext(QuestionentryContext.class,0);
		}
		public ComputedContext computed() {
			return getRuleContext(ComputedContext.class,0);
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
			if ( listener instanceof testListener ) ((testListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_item);
		try {
			setState(36);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); ((ItemContext)_localctx).conditional = conditional();
				((ItemContext)_localctx).question =  ((ItemContext)_localctx).conditional.cq;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30); ((ItemContext)_localctx).computed = computed();
				((ItemContext)_localctx).question =  ((ItemContext)_localctx).computed.question;
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33); ((ItemContext)_localctx).questionentry = questionentry();
				((ItemContext)_localctx).question =  ((ItemContext)_localctx).questionentry.question;
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

	public static class QuestionentryContext extends ParserRuleContext {
		public Question question;
		public Token IDENTIFIER;
		public Token STRING;
		public TypeContext type;
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(testParser.STRING, 0); }
		public QuestionentryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionentry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterQuestionentry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitQuestionentry(this);
		}
	}

	public final QuestionentryContext questionentry() throws RecognitionException {
		QuestionentryContext _localctx = new QuestionentryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionentry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); ((QuestionentryContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(39); match(6);
			setState(40); ((QuestionentryContext)_localctx).STRING = match(STRING);
			setState(41); ((QuestionentryContext)_localctx).type = type();
			((QuestionentryContext)_localctx).question =  new Question((((QuestionentryContext)_localctx).IDENTIFIER!=null?((QuestionentryContext)_localctx).IDENTIFIER.getText():null),(((QuestionentryContext)_localctx).STRING!=null?((QuestionentryContext)_localctx).STRING.getText():null).substring(1, (((QuestionentryContext)_localctx).STRING!=null?((QuestionentryContext)_localctx).STRING.getText():null).length() - 1),((QuestionentryContext)_localctx).type.t,(((QuestionentryContext)_localctx).IDENTIFIER!=null?((QuestionentryContext)_localctx).IDENTIFIER.getLine():0));
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
		public ConditionalQuestion cq;
		public ExpContext exp;
		public ItemContext item;
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_conditional);
		List<GeneralQuestion> gql = new ArrayList();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(8);
			setState(45); match(7);
			setState(46); ((ConditionalContext)_localctx).exp = exp(0);
			((ConditionalContext)_localctx).cq =  new ConditionalQuestion(((ConditionalContext)_localctx).exp.ex,((((ConditionalContext)_localctx).exp!=null?(((ConditionalContext)_localctx).exp.start):null)).getLine());
			setState(48); match(19);
			setState(49); match(12);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==8 || _la==IDENTIFIER) {
				{
				{
				setState(50); ((ConditionalContext)_localctx).item = item();
				_localctx.cq.addTrueConditionQuestion(((ConditionalContext)_localctx).item.question);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); match(15);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==14) {
				{
				{
				setState(59); match(14);
				setState(60); match(12);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==8 || _la==IDENTIFIER) {
					{
					{
					setState(61); ((ConditionalContext)_localctx).item = item();
					_localctx.cq.addFalseConditionQuestion(((ConditionalContext)_localctx).item.question);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69); match(15);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ComputedContext extends ParserRuleContext {
		public ComputedQuestion question;
		public Token IDENTIFIER;
		public Token STRING;
		public TypeContext type;
		public ExpContext exp;
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(testParser.STRING, 0); }
		public ComputedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterComputed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitComputed(this);
		}
	}

	public final ComputedContext computed() throws RecognitionException {
		ComputedContext _localctx = new ComputedContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_computed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); ((ComputedContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(76); match(6);
			setState(77); ((ComputedContext)_localctx).STRING = match(STRING);
			setState(78); ((ComputedContext)_localctx).type = type();
			setState(79); match(7);
			setState(80); ((ComputedContext)_localctx).exp = exp(0);
			setState(81); match(19);
			((ComputedContext)_localctx).question =  new ComputedQuestion((((ComputedContext)_localctx).IDENTIFIER!=null?((ComputedContext)_localctx).IDENTIFIER.getText():null),(((ComputedContext)_localctx).STRING!=null?((ComputedContext)_localctx).STRING.getText():null).substring(1, (((ComputedContext)_localctx).STRING!=null?((ComputedContext)_localctx).STRING.getText():null).length() - 1),((ComputedContext)_localctx).type.t,((ComputedContext)_localctx).exp.ex,(((ComputedContext)_localctx).IDENTIFIER!=null?((ComputedContext)_localctx).IDENTIFIER.getLine():0));
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
		public IType t;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(92);
			switch (_input.LA(1)) {
			case 16:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); match(16);
				((TypeContext)_localctx).t =  new BoolType();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); match(23);
				 ((TypeContext)_localctx).t =  new StringType();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 3);
				{
				setState(88); match(21);
				((TypeContext)_localctx).t =  new IntType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(90); ((TypeContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((TypeContext)_localctx).t =  new ErrorType((((TypeContext)_localctx).IDENTIFIER!=null?((TypeContext)_localctx).IDENTIFIER.getLine():0));
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

	public static class ExpContext extends ParserRuleContext {
		public Expression ex;
		public ExpContext l;
		public Token INT;
		public Token BOOL;
		public Token STRING;
		public Token IDENTIFIER;
		public ExpContext e;
		public ExpContext r;
		public TerminalNode BOOL() { return getToken(testParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(testParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(testParser.IDENTIFIER, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode STRING() { return getToken(testParser.STRING, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof testListener ) ((testListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			switch (_input.LA(1)) {
			case 3:
				{
				setState(95); match(3);
				setState(96); exp(17);
				}
				break;
			case 5:
				{
				setState(97); match(5);
				setState(98); exp(16);
				}
				break;
			case INT:
				{
				setState(99); ((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).ex =  new IntLiteral(Integer.parseInt((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)),(((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getLine():0));
				}
				break;
			case BOOL:
				{
				setState(101); ((ExpContext)_localctx).BOOL = match(BOOL);
				 ((ExpContext)_localctx).ex =  new BoolLiteral(Boolean.parseBoolean((((ExpContext)_localctx).BOOL!=null?((ExpContext)_localctx).BOOL.getText():null)),(((ExpContext)_localctx).BOOL!=null?((ExpContext)_localctx).BOOL.getLine():0));
				}
				break;
			case STRING:
				{
				setState(103); ((ExpContext)_localctx).STRING = match(STRING);
				 ((ExpContext)_localctx).ex =  new StringLiteral((((ExpContext)_localctx).STRING!=null?((ExpContext)_localctx).STRING.getText():null),(((ExpContext)_localctx).STRING!=null?((ExpContext)_localctx).STRING.getLine():0));
				}
				break;
			case IDENTIFIER:
				{
				setState(105); ((ExpContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((ExpContext)_localctx).ex =  new Variable((((ExpContext)_localctx).IDENTIFIER!=null?((ExpContext)_localctx).IDENTIFIER.getText():null),(((ExpContext)_localctx).IDENTIFIER!=null?((ExpContext)_localctx).IDENTIFIER.getLine():0));
				}
				break;
			case 7:
				{
				setState(107); match(7);
				setState(108); ((ExpContext)_localctx).e = exp(0);
				setState(109); match(19);
				((ExpContext)_localctx).ex =  ((ExpContext)_localctx).e.ex;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(114);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(115); match(18);
						setState(116); exp(16);
						}
						break;

					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(117);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(118); match(17);
						setState(119); exp(15);
						}
						break;

					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(120);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(121); match(2);
						setState(122); ((ExpContext)_localctx).r = exp(14);
						((ExpContext)_localctx).ex =  new Multiplication(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(125);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(126); match(25);
						setState(127); ((ExpContext)_localctx).r = exp(13);
						((ExpContext)_localctx).ex =  new Division(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(130);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(131); match(3);
						setState(132); ((ExpContext)_localctx).r = exp(12);
						((ExpContext)_localctx).ex =  new Minus(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(135);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(136); match(20);
						setState(137); ((ExpContext)_localctx).r = exp(11);
						((ExpContext)_localctx).ex =  new Plus(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(140);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(141); match(9);
						setState(142); ((ExpContext)_localctx).r = exp(10);
						((ExpContext)_localctx).ex =  new SmallerThan(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(145);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(146); match(10);
						setState(147); ((ExpContext)_localctx).r = exp(9);
						((ExpContext)_localctx).ex =  new SmallerThanEquals(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(150);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(151); match(22);
						setState(152); ((ExpContext)_localctx).r = exp(8);
						((ExpContext)_localctx).ex =  new GreaterThan(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 10:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(155);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(156); match(26);
						setState(157); ((ExpContext)_localctx).r = exp(7);
						((ExpContext)_localctx).ex =  new GreaterThanEquals(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 11:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(160);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(161); match(24);
						setState(162); ((ExpContext)_localctx).r = exp(6);
						((ExpContext)_localctx).ex =  new Equals(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 12:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166); match(11);
						setState(167); exp(5);
						}
						break;

					case 13:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(168);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(169); match(13);
						setState(170); ((ExpContext)_localctx).r = exp(4);
						((ExpContext)_localctx).ex =  new And(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;

					case 14:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(173);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(174); match(4);
						setState(175); ((ExpContext)_localctx).r = exp(3);
						((ExpContext)_localctx).ex =  new Or(((ExpContext)_localctx).l.ex,((ExpContext)_localctx).r.ex,((((ExpContext)_localctx).l!=null?(((ExpContext)_localctx).l.start):null)).getLine());
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		case 6: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 15);

		case 1: return precpred(_ctx, 14);

		case 2: return precpred(_ctx, 13);

		case 3: return precpred(_ctx, 12);

		case 4: return precpred(_ctx, 11);

		case 5: return precpred(_ctx, 10);

		case 6: return precpred(_ctx, 9);

		case 7: return precpred(_ctx, 8);

		case 8: return precpred(_ctx, 7);

		case 9: return precpred(_ctx, 6);

		case 10: return precpred(_ctx, 5);

		case 11: return precpred(_ctx, 4);

		case 12: return precpred(_ctx, 3);

		case 13: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u00ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\6\2\30\n\2\r\2\16\2\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\'\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5C\n\5\f\5\16\5F"+
		"\13\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b5\n\b\f\b\16\b\u00b8\13\b\3\b\2"+
		"\3\16\t\2\4\6\b\n\f\16\2\2\u00cf\2\20\3\2\2\2\4&\3\2\2\2\6(\3\2\2\2\b"+
		".\3\2\2\2\nM\3\2\2\2\f^\3\2\2\2\16r\3\2\2\2\20\21\7\3\2\2\21\22\7\37\2"+
		"\2\22\23\b\2\1\2\23\27\7\16\2\2\24\25\5\4\3\2\25\26\b\2\1\2\26\30\3\2"+
		"\2\2\27\24\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\33\3\2"+
		"\2\2\33\34\7\21\2\2\34\3\3\2\2\2\35\36\5\b\5\2\36\37\b\3\1\2\37\'\3\2"+
		"\2\2 !\5\n\6\2!\"\b\3\1\2\"\'\3\2\2\2#$\5\6\4\2$%\b\3\1\2%\'\3\2\2\2&"+
		"\35\3\2\2\2& \3\2\2\2&#\3\2\2\2\'\5\3\2\2\2()\7\37\2\2)*\7\b\2\2*+\7 "+
		"\2\2+,\5\f\7\2,-\b\4\1\2-\7\3\2\2\2./\7\n\2\2/\60\7\t\2\2\60\61\5\16\b"+
		"\2\61\62\b\5\1\2\62\63\7\25\2\2\639\7\16\2\2\64\65\5\4\3\2\65\66\b\5\1"+
		"\2\668\3\2\2\2\67\64\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2"+
		";9\3\2\2\2<J\7\21\2\2=>\7\20\2\2>D\7\16\2\2?@\5\4\3\2@A\b\5\1\2AC\3\2"+
		"\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GI\7\21"+
		"\2\2H=\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\t\3\2\2\2LJ\3\2\2\2MN\7"+
		"\37\2\2NO\7\b\2\2OP\7 \2\2PQ\5\f\7\2QR\7\t\2\2RS\5\16\b\2ST\7\25\2\2T"+
		"U\b\6\1\2U\13\3\2\2\2VW\7\22\2\2W_\b\7\1\2XY\7\31\2\2Y_\b\7\1\2Z[\7\27"+
		"\2\2[_\b\7\1\2\\]\7\37\2\2]_\b\7\1\2^V\3\2\2\2^X\3\2\2\2^Z\3\2\2\2^\\"+
		"\3\2\2\2_\r\3\2\2\2`a\b\b\1\2ab\7\5\2\2bs\5\16\b\23cd\7\7\2\2ds\5\16\b"+
		"\22ef\7\36\2\2fs\b\b\1\2gh\7\35\2\2hs\b\b\1\2ij\7 \2\2js\b\b\1\2kl\7\37"+
		"\2\2ls\b\b\1\2mn\7\t\2\2no\5\16\b\2op\7\25\2\2pq\b\b\1\2qs\3\2\2\2r`\3"+
		"\2\2\2rc\3\2\2\2re\3\2\2\2rg\3\2\2\2ri\3\2\2\2rk\3\2\2\2rm\3\2\2\2s\u00b6"+
		"\3\2\2\2tu\f\21\2\2uv\7\24\2\2v\u00b5\5\16\b\22wx\f\20\2\2xy\7\23\2\2"+
		"y\u00b5\5\16\b\21z{\f\17\2\2{|\7\4\2\2|}\5\16\b\20}~\b\b\1\2~\u00b5\3"+
		"\2\2\2\177\u0080\f\16\2\2\u0080\u0081\7\33\2\2\u0081\u0082\5\16\b\17\u0082"+
		"\u0083\b\b\1\2\u0083\u00b5\3\2\2\2\u0084\u0085\f\r\2\2\u0085\u0086\7\5"+
		"\2\2\u0086\u0087\5\16\b\16\u0087\u0088\b\b\1\2\u0088\u00b5\3\2\2\2\u0089"+
		"\u008a\f\f\2\2\u008a\u008b\7\26\2\2\u008b\u008c\5\16\b\r\u008c\u008d\b"+
		"\b\1\2\u008d\u00b5\3\2\2\2\u008e\u008f\f\13\2\2\u008f\u0090\7\13\2\2\u0090"+
		"\u0091\5\16\b\f\u0091\u0092\b\b\1\2\u0092\u00b5\3\2\2\2\u0093\u0094\f"+
		"\n\2\2\u0094\u0095\7\f\2\2\u0095\u0096\5\16\b\13\u0096\u0097\b\b\1\2\u0097"+
		"\u00b5\3\2\2\2\u0098\u0099\f\t\2\2\u0099\u009a\7\30\2\2\u009a\u009b\5"+
		"\16\b\n\u009b\u009c\b\b\1\2\u009c\u00b5\3\2\2\2\u009d\u009e\f\b\2\2\u009e"+
		"\u009f\7\34\2\2\u009f\u00a0\5\16\b\t\u00a0\u00a1\b\b\1\2\u00a1\u00b5\3"+
		"\2\2\2\u00a2\u00a3\f\7\2\2\u00a3\u00a4\7\32\2\2\u00a4\u00a5\5\16\b\b\u00a5"+
		"\u00a6\b\b\1\2\u00a6\u00b5\3\2\2\2\u00a7\u00a8\f\6\2\2\u00a8\u00a9\7\r"+
		"\2\2\u00a9\u00b5\5\16\b\7\u00aa\u00ab\f\5\2\2\u00ab\u00ac\7\17\2\2\u00ac"+
		"\u00ad\5\16\b\6\u00ad\u00ae\b\b\1\2\u00ae\u00b5\3\2\2\2\u00af\u00b0\f"+
		"\4\2\2\u00b0\u00b1\7\6\2\2\u00b1\u00b2\5\16\b\5\u00b2\u00b3\b\b\1\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4t\3\2\2\2\u00b4w\3\2\2\2\u00b4z\3\2\2\2\u00b4\177"+
		"\3\2\2\2\u00b4\u0084\3\2\2\2\u00b4\u0089\3\2\2\2\u00b4\u008e\3\2\2\2\u00b4"+
		"\u0093\3\2\2\2\u00b4\u0098\3\2\2\2\u00b4\u009d\3\2\2\2\u00b4\u00a2\3\2"+
		"\2\2\u00b4\u00a7\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00af\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\17\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\13\31&9DJ^r\u00b4\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}