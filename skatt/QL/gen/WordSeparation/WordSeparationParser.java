// Generated from grammar/WordSeparation.g4 by ANTLR 4.2

package WordSeparation;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WordSeparationParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WORD=2, WS=3;
	public static final String[] tokenNames = {
		"<INVALID>", "':'", "WORD", "WS"
	};
	public static final int
		RULE_program = 0, RULE_part = 1, RULE_end = 2;
	public static final String[] ruleNames = {
		"program", "part", "end"
	};

	@Override
	public String getGrammarFileName() { return "WordSeparation.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WordSeparationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WordSeparationListener ) ((WordSeparationListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WordSeparationListener ) ((WordSeparationListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(6); part();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(9); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(11); end();
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

	public static class PartContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(WordSeparationParser.WORD, 0); }
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WordSeparationListener ) ((WordSeparationListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WordSeparationListener ) ((WordSeparationListener)listener).exitPart(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_part);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); match(WORD);
			setState(14); match(1);
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

	public static class EndContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(WordSeparationParser.WORD, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WordSeparationListener ) ((WordSeparationListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WordSeparationListener ) ((WordSeparationListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); match(WORD);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\5\25\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\6\2\n\n\2\r\2\16\2\13\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\2\2\5\2\4\6\2\2\22\2\t\3\2\2\2\4\17\3\2\2\2\6\22\3\2\2\2\b\n\5\4\3\2"+
		"\t\b\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\r\3\2\2\2\r\16\5"+
		"\6\4\2\16\3\3\2\2\2\17\20\7\4\2\2\20\21\7\3\2\2\21\5\3\2\2\2\22\23\7\4"+
		"\2\2\23\7\3\2\2\2\3\13";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}