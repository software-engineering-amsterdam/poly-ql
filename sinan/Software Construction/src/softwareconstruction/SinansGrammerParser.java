// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TYPE=8, IDENTIFIER=9, 
		STRING=10, LETTER=11, DIGIT=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "')'", "':'", "'('", "'if'", "'}'", "TYPE", 
		"IDENTIFIER", "STRING", "LETTER", "DIGIT", "WS"
	};
	public static final int
		RULE_form = 0, RULE_item = 1, RULE_question = 2, RULE_conditional = 3;
	public static final String[] ruleNames = {
		"form", "item", "question", "conditional"
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
			setState(8); match(1);
			setState(9); ((FormContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			_localctx.fo.setFormName((((FormContext)_localctx).IDENTIFIER!=null?((FormContext)_localctx).IDENTIFIER.getText():null));
			setState(11); match(2);
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); ((FormContext)_localctx).item = item();
				 _localctx.fo.addQuestion(((FormContext)_localctx).item.object);
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==IDENTIFIER );
			setState(19); match(7);
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
			setState(27);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(21); ((ItemContext)_localctx).conditional = conditional();
				((ItemContext)_localctx).object =  ((ItemContext)_localctx).conditional.cqe;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(24); ((ItemContext)_localctx).question = question();
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
			setState(29); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.qe.setQuestionName((((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null)); 
			setState(31); match(4);
			setState(32); ((QuestionContext)_localctx).STRING = match(STRING);
			 _localctx.qe.setQuestionContent((((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null)); 
			setState(34); ((QuestionContext)_localctx).TYPE = match(TYPE);
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
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
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
			setState(37); match(6);
			setState(38); match(5);
			setState(39); match(IDENTIFIER);
			setState(40); match(3);
			setState(41); match(2);
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
			} while ( _la==6 || _la==IDENTIFIER );
			setState(49); match(7);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3\5\3\5"+
		"\3\5\2\2\6\2\4\6\b\2\2\64\2\n\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b\'\3"+
		"\2\2\2\n\13\7\3\2\2\13\f\7\13\2\2\f\r\b\2\1\2\r\21\7\4\2\2\16\17\5\4\3"+
		"\2\17\20\b\2\1\2\20\22\3\2\2\2\21\16\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2"+
		"\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\7\t\2\2\26\3\3\2\2\2\27\30\5\b\5"+
		"\2\30\31\b\3\1\2\31\36\3\2\2\2\32\33\5\6\4\2\33\34\b\3\1\2\34\36\3\2\2"+
		"\2\35\27\3\2\2\2\35\32\3\2\2\2\36\5\3\2\2\2\37 \7\13\2\2 !\b\4\1\2!\""+
		"\7\6\2\2\"#\7\f\2\2#$\b\4\1\2$%\7\n\2\2%&\b\4\1\2&\7\3\2\2\2\'(\7\b\2"+
		"\2()\7\7\2\2)*\7\13\2\2*+\7\5\2\2+/\7\4\2\2,-\5\4\3\2-.\b\5\1\2.\60\3"+
		"\2\2\2/,\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2"+
		"\63\64\7\t\2\2\64\t\3\2\2\2\5\23\35\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}