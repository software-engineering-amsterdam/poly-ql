// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import java.util.HashMap;

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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, IDENTIFIER=7, WS=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "':'", "'}'", "'\"'", "'?'", "IDENTIFIER", 
		"WS"
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
		public Token IDENTIFIER;
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4); match(1);
			setState(5); ((FormContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(6); match(2);
			setState(8); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7); question();
				}
				}
				setState(10); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(12); match(4);
			System.out.println("Form name:"+(((FormContext)_localctx).IDENTIFIER!=null?((FormContext)_localctx).IDENTIFIER.getText():null));
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
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SinansGrammerParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SinansGrammerParser.IDENTIFIER); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("Question name: "+(((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null));
			setState(17); match(3);
			setState(18); match(5);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			System.out.println("Question content: "+(((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null));
			setState(25); match(6);
			setState(26); match(5);
			setState(27); ((QuestionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("Question type: "+(((QuestionContext)_localctx).IDENTIFIER!=null?((QuestionContext)_localctx).IDENTIFIER.getText():null) + "\n---------------------");
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n!\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\6\3\27\n\3\r\3\16\3\30\3\3\3\3\3\3\3\3\3\3\3\3\3\3\2\2\4\2\4\2\2 \2"+
		"\6\3\2\2\2\4\21\3\2\2\2\6\7\7\3\2\2\7\b\7\t\2\2\b\n\7\4\2\2\t\13\5\4\3"+
		"\2\n\t\3\2\2\2\13\f\3\2\2\2\f\n\3\2\2\2\f\r\3\2\2\2\r\16\3\2\2\2\16\17"+
		"\7\6\2\2\17\20\b\2\1\2\20\3\3\2\2\2\21\22\7\t\2\2\22\23\b\3\1\2\23\24"+
		"\7\5\2\2\24\26\7\7\2\2\25\27\7\t\2\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26"+
		"\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\33\b\3\1\2\33\34\7\b\2\2\34\35"+
		"\7\7\2\2\35\36\7\t\2\2\36\37\b\3\1\2\37\5\3\2\2\2\4\f\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}