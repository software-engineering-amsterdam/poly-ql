// Generated from grammar/Calculator4.g4 by ANTLR 4.2

package Calculator4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Calculator4Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, STRING=11, ID=12, INT=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "','", "'+'", "'*'", "'-'", "'('", "'print'", "'/'", 
		"'='", "';'", "STRING", "ID", "INT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_assignment = 1, RULE_expression = 2, RULE_arg = 3;
	public static final String[] ruleNames = {
		"program", "assignment", "expression", "arg"
	};

	@Override
	public String getGrammarFileName() { return "Calculator4.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Calculator4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(8); assignment();
					}
					break;

				case 2:
					{
					setState(9); expression(0);
					}
					break;
				}
				setState(12); match(10);
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << STRING) | (1L << ID) | (1L << INT))) != 0) );
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Calculator4Parser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); match(ID);
			setState(19); match(9);
			setState(20); expression(0);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddOrSubtractContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AddOrSubtractContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterAddOrSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitAddOrSubtract(this);
		}
	}
	public static class MultOrDivContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultOrDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterMultOrDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitMultOrDiv(this);
		}
	}
	public static class IntegerContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(Calculator4Parser.INT, 0); }
		public IntegerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitInteger(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(Calculator4Parser.STRING, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitString(this);
		}
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitParenExpression(this);
		}
	}
	public static class IdentifierContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(Calculator4Parser.ID, 0); }
		public IdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitIdentifier(this);
		}
	}
	public static class PrintContext extends ExpressionContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public PrintContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitPrint(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			switch (_input.LA(1)) {
			case 6:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(23); match(6);
				setState(24); expression(0);
				setState(25); match(1);
				}
				break;
			case 7:
				{
				_localctx = new PrintContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27); match(7);
				setState(28); arg();
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(29); match(2);
						setState(30); arg();
						}
						} 
					}
					setState(35);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36); match(STRING);
				}
				break;
			case ID:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37); match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38); match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MultOrDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(41);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(42);
						_la = _input.LA(1);
						if ( !(_la==4 || _la==8) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(43); expression(7);
						}
						break;

					case 2:
						{
						_localctx = new AddOrSubtractContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(44);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(45);
						_la = _input.LA(1);
						if ( !(_la==3 || _la==5) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(46); expression(6);
						}
						break;
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Calculator4Parser.ID, 0); }
		public TerminalNode STRING() { return getToken(Calculator4Parser.STRING, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculator4Listener ) ((Calculator4Listener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		case 2: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 6);

		case 1: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\209\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\5\2\r\n\2\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\"\n\4\f\4\16\4"+
		"%\13\4\3\4\3\4\3\4\5\4*\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\62\n\4\f\4\16"+
		"\4\65\13\4\3\5\3\5\3\5\2\3\6\6\2\4\6\b\2\5\4\2\6\6\n\n\4\2\5\5\7\7\3\2"+
		"\r\16=\2\20\3\2\2\2\4\24\3\2\2\2\6)\3\2\2\2\b\66\3\2\2\2\n\r\5\4\3\2\13"+
		"\r\5\6\4\2\f\n\3\2\2\2\f\13\3\2\2\2\r\16\3\2\2\2\16\17\7\f\2\2\17\21\3"+
		"\2\2\2\20\f\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\3\3\2"+
		"\2\2\24\25\7\16\2\2\25\26\7\13\2\2\26\27\5\6\4\2\27\5\3\2\2\2\30\31\b"+
		"\4\1\2\31\32\7\b\2\2\32\33\5\6\4\2\33\34\7\3\2\2\34*\3\2\2\2\35\36\7\t"+
		"\2\2\36#\5\b\5\2\37 \7\4\2\2 \"\5\b\5\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2"+
		"\2#$\3\2\2\2$*\3\2\2\2%#\3\2\2\2&*\7\r\2\2\'*\7\16\2\2(*\7\17\2\2)\30"+
		"\3\2\2\2)\35\3\2\2\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\63\3\2\2\2+,\f\b"+
		"\2\2,-\t\2\2\2-\62\5\6\4\t./\f\7\2\2/\60\t\3\2\2\60\62\5\6\4\b\61+\3\2"+
		"\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\7\3\2\2"+
		"\2\65\63\3\2\2\2\66\67\t\4\2\2\67\t\3\2\2\2\b\f\22#)\61\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}