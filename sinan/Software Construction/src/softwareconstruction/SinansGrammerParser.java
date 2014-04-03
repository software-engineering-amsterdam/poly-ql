// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import softwareconstruction.operators.*;
    import softwareconstruction.types.*;
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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, BOOL=12, INT=13, IDENTIFIER=14, STRING=15, LETTER=16, 
		DIGIT=17, OPERATOR=18, WS=19;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "')'", "'+'", "':'", "'('", "'string'", 
		"'if'", "'int'", "'}'", "'boolean'", "BOOL", "INT", "IDENTIFIER", "STRING", 
		"LETTER", "DIGIT", "OPERATOR", "WS"
	};
	public static final int
		RULE_form = 0, RULE_item = 1, RULE_question = 2, RULE_conditional = 3, 
		RULE_expression = 4, RULE_type = 5;
	public static final String[] ruleNames = {
		"form", "item", "question", "conditional", "expression", "type"
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
			setState(15); match(2);
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); ((FormContext)_localctx).item = item();
				 _localctx.fo.addQuestion(((FormContext)_localctx).item.gq);
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==8 || _la==IDENTIFIER );
			setState(23); match(10);
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
		public QuestionInterface gq;
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
		try {
			setState(31);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(25); ((ItemContext)_localctx).conditional = conditional();
				((ItemContext)_localctx).gq =  ((ItemContext)_localctx).conditional.cqe;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); ((ItemContext)_localctx).question = question();
				((ItemContext)_localctx).gq =  ((ItemContext)_localctx).question.qe;
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
		public TypeContext type;
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SinansGrammerParser.STRING, 0); }
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
			setState(35); match(5);
			setState(36); ((QuestionContext)_localctx).STRING = match(STRING);
			 _localctx.qe.setQuestionContent((((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null)); 
			setState(38); ((QuestionContext)_localctx).type = type();
			 _localctx.qe.setQuestionType(((QuestionContext)_localctx).type.stype);
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
		public ExpressionContext expression;
		public ItemContext item;
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(41); match(8);
			setState(42); match(6);
			setState(43); ((ConditionalContext)_localctx).expression = expression(0);
			_localctx.cqe.addExpression(((ConditionalContext)_localctx).expression.exp);
			setState(45); match(3);
			setState(46); match(2);
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47); ((ConditionalContext)_localctx).item = item();
				 _localctx.cqe.addQuestion(((ConditionalContext)_localctx).item.gq); 
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==8 || _la==IDENTIFIER );
			setState(54); match(10);
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
		public ExpressionContext l;
		public Token INT;
		public Token BOOL;
		public Token STRING;
		public Token IDENTIFIER;
		public ExpressionContext r;
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(57); ((ExpressionContext)_localctx).INT = match(INT);
				System.out.println("Integer Literal found! -> "+ (((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)); ((ExpressionContext)_localctx).exp =  new IntLiteral(Integer.parseInt((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)));
				}
				break;
			case BOOL:
				{
				setState(59); ((ExpressionContext)_localctx).BOOL = match(BOOL);
				System.out.println("Boolean Literal found! -> "+(((ExpressionContext)_localctx).BOOL!=null?((ExpressionContext)_localctx).BOOL.getText():null)); ((ExpressionContext)_localctx).exp =  new BoolLiteral(Boolean.parseBoolean((((ExpressionContext)_localctx).BOOL!=null?((ExpressionContext)_localctx).BOOL.getText():null)));
				}
				break;
			case STRING:
				{
				setState(61); ((ExpressionContext)_localctx).STRING = match(STRING);
				System.out.println("String Literal found! -> "+(((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null)); ((ExpressionContext)_localctx).exp =  new StringLiteral((((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null));
				}
				break;
			case IDENTIFIER:
				{
				setState(63); ((ExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				((ExpressionContext)_localctx).exp =  new Variable((((ExpressionContext)_localctx).IDENTIFIER!=null?((ExpressionContext)_localctx).IDENTIFIER.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					_localctx.l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(67);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(68); match(4);
					setState(69); ((ExpressionContext)_localctx).r = expression(2);
					 System.out.println((((ExpressionContext)_localctx).l!=null?_input.getText(((ExpressionContext)_localctx).l.start,((ExpressionContext)_localctx).l.stop):null)); System.out.println((((ExpressionContext)_localctx).r!=null?_input.getText(((ExpressionContext)_localctx).r.start,((ExpressionContext)_localctx).r.stop):null)); ((ExpressionContext)_localctx).exp =  new Plus(((ExpressionContext)_localctx).l.exp, ((ExpressionContext)_localctx).r.exp); 
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class TypeContext extends ParserRuleContext {
		public SuperType stype;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(83);
			switch (_input.LA(1)) {
			case 11:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); match(11);
				((TypeContext)_localctx).stype =  new BoolType();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 2);
				{
				setState(79); match(9);
				((TypeContext)_localctx).stype =  new IntType();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 3);
				{
				setState(81); match(7);
				((TypeContext)_localctx).stype =  new StringType();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\65\n\5\r"+
		"\5\16\5\66\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6D\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7V\n"+
		"\7\3\7\2\3\n\b\2\4\6\b\n\f\2\2Z\2\16\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b+"+
		"\3\2\2\2\nC\3\2\2\2\fU\3\2\2\2\16\17\7\3\2\2\17\20\7\20\2\2\20\21\b\2"+
		"\1\2\21\25\7\4\2\2\22\23\5\4\3\2\23\24\b\2\1\2\24\26\3\2\2\2\25\22\3\2"+
		"\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\7\f"+
		"\2\2\32\3\3\2\2\2\33\34\5\b\5\2\34\35\b\3\1\2\35\"\3\2\2\2\36\37\5\6\4"+
		"\2\37 \b\3\1\2 \"\3\2\2\2!\33\3\2\2\2!\36\3\2\2\2\"\5\3\2\2\2#$\7\20\2"+
		"\2$%\b\4\1\2%&\7\7\2\2&\'\7\21\2\2\'(\b\4\1\2()\5\f\7\2)*\b\4\1\2*\7\3"+
		"\2\2\2+,\7\n\2\2,-\7\b\2\2-.\5\n\6\2./\b\5\1\2/\60\7\5\2\2\60\64\7\4\2"+
		"\2\61\62\5\4\3\2\62\63\b\5\1\2\63\65\3\2\2\2\64\61\3\2\2\2\65\66\3\2\2"+
		"\2\66\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\f\2\29\t\3\2\2\2:;\b\6"+
		"\1\2;<\7\17\2\2<D\b\6\1\2=>\7\16\2\2>D\b\6\1\2?@\7\21\2\2@D\b\6\1\2AB"+
		"\7\20\2\2BD\b\6\1\2C:\3\2\2\2C=\3\2\2\2C?\3\2\2\2CA\3\2\2\2DL\3\2\2\2"+
		"EF\f\3\2\2FG\7\6\2\2GH\5\n\6\4HI\b\6\1\2IK\3\2\2\2JE\3\2\2\2KN\3\2\2\2"+
		"LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NL\3\2\2\2OP\7\r\2\2PV\b\7\1\2QR\7\13"+
		"\2\2RV\b\7\1\2ST\7\t\2\2TV\b\7\1\2UO\3\2\2\2UQ\3\2\2\2US\3\2\2\2V\r\3"+
		"\2\2\2\b\27!\66CLU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}