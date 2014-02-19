// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;

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
		T__3=1, T__2=2, T__1=3, T__0=4, IDENTIFIER=5, STRING=6, LETTER=7, DIGIT=8, 
		WS=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "':'", "'}'", "IDENTIFIER", "STRING", "LETTER", 
		"DIGIT", "WS"
	};
	public static final int
		RULE_form = 0, RULE_question = 1;
	public static final String[] ruleNames = {
		"form", "question"
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
		public QuestionContext question;
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(SinansGrammerParser.IDENTIFIER, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
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
			setState(4); match(1);
			setState(5); match(IDENTIFIER);
			setState(6); match(2);
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7); ((FormContext)_localctx).question = question();
				 System.out.println(((FormContext)_localctx).question.qe.toString()); _localctx.fo.addQuestion(((FormContext)_localctx).question.qe);
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(14); match(4);
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
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SinansGrammerParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SinansGrammerParser.IDENTIFIER); }
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
		enterRule(_localctx, 2, RULE_question);
		((QuestionContext)_localctx).qe =  new Question();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.qe.setQuestionName((((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null)); 
			setState(18); match(3);
			setState(19); ((QuestionContext)_localctx).STRING = match(STRING);
			 _localctx.qe.setQuestionContent((((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null)); 
			setState(21); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.qe.setQuestionType((((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null));
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\33\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\6\2\r\n\2\r\2\16\2\16\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\2\2\4\2\4\2\2\31\2\6\3\2\2\2\4\22\3\2\2\2\6\7"+
		"\7\3\2\2\7\b\7\7\2\2\b\f\7\4\2\2\t\n\5\4\3\2\n\13\b\2\1\2\13\r\3\2\2\2"+
		"\f\t\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\20\3\2\2\2\20"+
		"\21\7\6\2\2\21\3\3\2\2\2\22\23\7\7\2\2\23\24\b\3\1\2\24\25\7\5\2\2\25"+
		"\26\7\b\2\2\26\27\b\3\1\2\27\30\7\7\2\2\30\31\b\3\1\2\31\5\3\2\2\2\3\16";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}