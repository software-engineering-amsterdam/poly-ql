// Generated from Newql.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NewqlParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, FULLQUESTION=4, NAME=5, QUESTION=6, ID=7, TYPE=8, 
		MONEY=9, BOOL=10, INT=11, WS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "'}'", "FULLQUESTION", "NAME", "QUESTION", 
		"ID", "TYPE", "MONEY", "BOOL", "INT", "WS"
	};
	public static final int
		RULE_form = 0;
	public static final String[] ruleNames = {
		"form"
	};

	@Override
	public String getGrammarFileName() { return "Newql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public NewqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public TerminalNode FULLQUESTION(int i) {
			return getToken(NewqlParser.FULLQUESTION, i);
		}
		public TerminalNode NAME() { return getToken(NewqlParser.NAME, 0); }
		public List<TerminalNode> FULLQUESTION() { return getTokens(NewqlParser.FULLQUESTION); }
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NewqlListener ) ((NewqlListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NewqlListener ) ((NewqlListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2); match(1);
			setState(3); match(NAME);
			setState(4); match(2);
			setState(6); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(5); match(FULLQUESTION);
				}
				}
				setState(8); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FULLQUESTION );
			setState(10); match(3);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\16\17\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\6\2\t\n\2\r\2\16\2\n\3\2\3\2\3\2\2\3\2\2\2\16\2\4\3\2\2\2"+
		"\4\5\7\3\2\2\5\6\7\7\2\2\6\b\7\4\2\2\7\t\7\6\2\2\b\7\3\2\2\2\t\n\3\2\2"+
		"\2\n\b\3\2\2\2\n\13\3\2\2\2\13\f\3\2\2\2\f\r\7\5\2\2\r\3\3\2\2\2\3\n";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}