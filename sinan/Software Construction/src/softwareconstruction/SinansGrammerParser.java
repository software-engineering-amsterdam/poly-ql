// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import softwareconstruction.operators.*;
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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		BOOL=10, TYPE=11, INT=12, IDENTIFIER=13, STRING=14, LETTER=15, DIGIT=16, 
		OPERATOR=17, WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "')'", "'+'", "':'", "'('", "'if'", "'}'", 
		"'!'", "BOOL", "TYPE", "INT", "IDENTIFIER", "STRING", "LETTER", "DIGIT", 
		"OPERATOR", "WS"
	};
	public static final int
		RULE_form = 0, RULE_item = 1, RULE_question = 2, RULE_conditional = 3, 
		RULE_expression = 4, RULE_leftnode = 5, RULE_rightnode = 6;
	public static final String[] ruleNames = {
		"form", "item", "question", "conditional", "expression", "leftnode", "rightnode"
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
			setState(14); match(1);
			setState(15); ((FormContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			_localctx.fo.setFormName((((FormContext)_localctx).IDENTIFIER!=null?((FormContext)_localctx).IDENTIFIER.getText():null));
			setState(17); match(2);
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18); ((FormContext)_localctx).item = item();
				 _localctx.fo.addQuestion(((FormContext)_localctx).item.object);
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==7 || _la==IDENTIFIER );
			setState(25); match(8);
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
			setState(33);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); ((ItemContext)_localctx).conditional = conditional();
				((ItemContext)_localctx).object =  ((ItemContext)_localctx).conditional.cqe;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(30); ((ItemContext)_localctx).question = question();
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
			setState(35); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.qe.setQuestionName((((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null)); 
			setState(37); match(5);
			setState(38); ((QuestionContext)_localctx).STRING = match(STRING);
			 _localctx.qe.setQuestionContent((((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null)); 
			setState(40); ((QuestionContext)_localctx).TYPE = match(TYPE);
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
			setState(43); match(7);
			setState(44); match(6);
			setState(45); ((ConditionalContext)_localctx).expression = expression();
			_localctx.cqe.addExpression((((ConditionalContext)_localctx).expression!=null?_input.getText(((ConditionalContext)_localctx).expression.start,((ConditionalContext)_localctx).expression.stop):null));
			setState(47); match(3);
			setState(48); match(2);
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49); ((ConditionalContext)_localctx).item = item();
				 _localctx.cqe.addQuestion(((ConditionalContext)_localctx).item.object); 
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==7 || _la==IDENTIFIER );
			setState(56); match(8);
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
		public RightnodeContext rightnode() {
			return getRuleContext(RightnodeContext.class,0);
		}
		public LeftnodeContext leftnode() {
			return getRuleContext(LeftnodeContext.class,0);
		}
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
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(64);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 9:
			case BOOL:
			case INT:
			case IDENTIFIER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); leftnode();
				setState(60); match(4);
				setState(61); rightnode();
				  System.out.println("Plus Operator found! -> +");
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

	public static class LeftnodeContext extends ParserRuleContext {
		public LeftNode ln;
		public Token INT;
		public Token BOOL;
		public Token STRING;
		public TerminalNode BOOL() { return getToken(SinansGrammerParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(SinansGrammerParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(SinansGrammerParser.STRING, 0); }
		public LeftnodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftnode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterLeftnode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitLeftnode(this);
		}
	}

	public final LeftnodeContext leftnode() throws RecognitionException {
		LeftnodeContext _localctx = new LeftnodeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_leftnode);
		int _la;
		try {
			setState(76);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(66); ((LeftnodeContext)_localctx).INT = match(INT);
				System.out.println("Integer Literal found! -> "+ (((LeftnodeContext)_localctx).INT!=null?((LeftnodeContext)_localctx).INT.getText():null)); ((LeftnodeContext)_localctx).ln =  new LeftNode(Integer.parseInt((((LeftnodeContext)_localctx).INT!=null?((LeftnodeContext)_localctx).INT.getText():null)));
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); ((LeftnodeContext)_localctx).BOOL = match(BOOL);
				System.out.println("Boolean Literal found! -> "+(((LeftnodeContext)_localctx).BOOL!=null?((LeftnodeContext)_localctx).BOOL.getText():null)); ((LeftnodeContext)_localctx).ln =  new LeftNode(Boolean.parseBoolean((((LeftnodeContext)_localctx).BOOL!=null?((LeftnodeContext)_localctx).BOOL.getText():null)));
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(70); ((LeftnodeContext)_localctx).STRING = match(STRING);
				System.out.println("String Literal found! -> "+(((LeftnodeContext)_localctx).STRING!=null?((LeftnodeContext)_localctx).STRING.getText():null)); ((LeftnodeContext)_localctx).ln =  new LeftNode((((LeftnodeContext)_localctx).STRING!=null?((LeftnodeContext)_localctx).STRING.getText():null));
				}
				break;
			case 9:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(72); match(9);
					}
				}

				setState(75); match(IDENTIFIER);
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

	public static class RightnodeContext extends ParserRuleContext {
		public RightNode rn;
		public Token INT;
		public Token BOOL;
		public Token STRING;
		public TerminalNode BOOL() { return getToken(SinansGrammerParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(SinansGrammerParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SinansGrammerParser.STRING, 0); }
		public RightnodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightnode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).enterRightnode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SinansGrammerListener ) ((SinansGrammerListener)listener).exitRightnode(this);
		}
	}

	public final RightnodeContext rightnode() throws RecognitionException {
		RightnodeContext _localctx = new RightnodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rightnode);
		int _la;
		try {
			setState(89);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); ((RightnodeContext)_localctx).INT = match(INT);
				System.out.println("Integer Literal found! -> "+ (((RightnodeContext)_localctx).INT!=null?((RightnodeContext)_localctx).INT.getText():null)); ((RightnodeContext)_localctx).rn =  new RightNode(Integer.parseInt((((RightnodeContext)_localctx).INT!=null?((RightnodeContext)_localctx).INT.getText():null)));
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); ((RightnodeContext)_localctx).BOOL = match(BOOL);
				System.out.println("Boolean Literal found! -> "+(((RightnodeContext)_localctx).BOOL!=null?((RightnodeContext)_localctx).BOOL.getText():null)); ((RightnodeContext)_localctx).rn =  new RightNode(Boolean.parseBoolean((((RightnodeContext)_localctx).BOOL!=null?((RightnodeContext)_localctx).BOOL.getText():null)));
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82); ((RightnodeContext)_localctx).STRING = match(STRING);
				System.out.println("String Literal found! -> "+(((RightnodeContext)_localctx).STRING!=null?((RightnodeContext)_localctx).STRING.getText():null)); ((RightnodeContext)_localctx).rn =  new RightNode((((RightnodeContext)_localctx).STRING!=null?((RightnodeContext)_localctx).STRING.getText():null));
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(84); match(9);
					}
				}

				setState(87); match(IDENTIFIER);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88); expression();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\6\2\30\n\2\r\2\16\2\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\67"+
		"\n\5\r\5\16\58\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6C\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7L\n\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bX"+
		"\n\b\3\b\3\b\5\b\\\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2c\2\20\3\2\2\2\4#\3"+
		"\2\2\2\6%\3\2\2\2\b-\3\2\2\2\nB\3\2\2\2\fN\3\2\2\2\16[\3\2\2\2\20\21\7"+
		"\3\2\2\21\22\7\17\2\2\22\23\b\2\1\2\23\27\7\4\2\2\24\25\5\4\3\2\25\26"+
		"\b\2\1\2\26\30\3\2\2\2\27\24\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32"+
		"\3\2\2\2\32\33\3\2\2\2\33\34\7\n\2\2\34\3\3\2\2\2\35\36\5\b\5\2\36\37"+
		"\b\3\1\2\37$\3\2\2\2 !\5\6\4\2!\"\b\3\1\2\"$\3\2\2\2#\35\3\2\2\2# \3\2"+
		"\2\2$\5\3\2\2\2%&\7\17\2\2&\'\b\4\1\2\'(\7\7\2\2()\7\20\2\2)*\b\4\1\2"+
		"*+\7\r\2\2+,\b\4\1\2,\7\3\2\2\2-.\7\t\2\2./\7\b\2\2/\60\5\n\6\2\60\61"+
		"\b\5\1\2\61\62\7\5\2\2\62\66\7\4\2\2\63\64\5\4\3\2\64\65\b\5\1\2\65\67"+
		"\3\2\2\2\66\63\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\7"+
		"\n\2\2;\t\3\2\2\2<C\3\2\2\2=>\5\f\7\2>?\7\6\2\2?@\5\16\b\2@A\b\6\1\2A"+
		"C\3\2\2\2B<\3\2\2\2B=\3\2\2\2C\13\3\2\2\2DE\7\16\2\2EO\b\7\1\2FG\7\f\2"+
		"\2GO\b\7\1\2HI\7\20\2\2IO\b\7\1\2JL\7\13\2\2KJ\3\2\2\2KL\3\2\2\2LM\3\2"+
		"\2\2MO\7\17\2\2ND\3\2\2\2NF\3\2\2\2NH\3\2\2\2NK\3\2\2\2O\r\3\2\2\2PQ\7"+
		"\16\2\2Q\\\b\b\1\2RS\7\f\2\2S\\\b\b\1\2TU\7\20\2\2U\\\b\b\1\2VX\7\13\2"+
		"\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y\\\7\17\2\2Z\\\5\n\6\2[P\3\2\2\2[R\3"+
		"\2\2\2[T\3\2\2\2[W\3\2\2\2[Z\3\2\2\2\\\17\3\2\2\2\n\31#8BKNW[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}