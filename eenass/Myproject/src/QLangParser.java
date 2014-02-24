// Generated from QLang.g4 by ANTLR 4.1

import ast.expr.Expr;
import ast.expr.binExpr.*;
import ast.expr.unExpression.*;
import ast.expr.literal.*;
import ast.expr.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLangParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, WS=16, COMMENT=17, 
		NewLine=18, Ident=19, Int=20, Str=21, Bool=22;
	public static final String[] tokenNames = {
		"<INVALID>", "'||'", "'>'", "')'", "'+'", "'-'", "'*'", "'('", "'/'", 
		"'<'", "'=='", "'>='", "'!='", "'!'", "'<='", "'&&'", "WS", "COMMENT", 
		"NewLine", "Ident", "Int", "Str", "Bool"
	};
	public static final int
		RULE_unExpr = 0, RULE_mulExpr = 1, RULE_addExpr = 2, RULE_relExpr = 3, 
		RULE_andExpr = 4, RULE_orExpr = 5, RULE_primary = 6;
	public static final String[] ruleNames = {
		"unExpr", "mulExpr", "addExpr", "relExpr", "andExpr", "orExpr", "primary"
	};

	@Override
	public String getGrammarFileName() { return "QLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UnExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext x;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnExprContext unExpr() {
			return getRuleContext(UnExprContext.class,0);
		}
		public UnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterUnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitUnExpr(this);
		}
	}

	public final UnExprContext unExpr() throws RecognitionException {
		UnExprContext _localctx = new UnExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_unExpr);
		try {
			setState(29);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(14); match(4);
				setState(15); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(18); match(5);
				setState(19); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 3);
				{
				setState(22); match(13);
				setState(23); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Not(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 7:
			case Ident:
			case Int:
			case Str:
			case Bool:
				enterOuterAlt(_localctx, 4);
				{
				setState(26); ((UnExprContext)_localctx).x = primary();
				 ((UnExprContext)_localctx).result =  ((UnExprContext)_localctx).x.result; 
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

	public static class MulExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext lhs;
		public Token op;
		public UnExprContext rhs;
		public UnExprContext unExpr(int i) {
			return getRuleContext(UnExprContext.class,i);
		}
		public List<UnExprContext> unExpr() {
			return getRuleContexts(UnExprContext.class);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitMulExpr(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); ((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==8) {
				{
				{
				setState(33);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==6 || _la==8) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(34); ((MulExprContext)_localctx).rhs = unExpr();
				 
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
				        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("/")) {
				        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(41);
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

	public static class AddExprContext extends ParserRuleContext {
		public Expr result;
		public MulExprContext lhs;
		public Token op;
		public MulExprContext rhs;
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); ((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==5) {
				{
				{
				setState(44);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==4 || _la==5) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(45); ((AddExprContext)_localctx).rhs = mulExpr();
				 
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
				        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
				        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(52);
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

	public static class RelExprContext extends ParserRuleContext {
		public Expr result;
		public AddExprContext lhs;
		public Token op;
		public AddExprContext rhs;
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitRelExpr(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); ((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14))) != 0)) {
				{
				{
				setState(55);
				((RelExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14))) != 0)) ) {
					((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(56); ((RelExprContext)_localctx).rhs = addExpr();
				 
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<")) {
				        ((RelExprContext)_localctx).result =  new LT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<=")) {
				        ((RelExprContext)_localctx).result =  new LEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);      
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">")) {
				        ((RelExprContext)_localctx).result =  new GT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">=")) {
				        ((RelExprContext)_localctx).result =  new GEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);      
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("==")) {
				        ((RelExprContext)_localctx).result =  new Eq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("!=")) {
				        ((RelExprContext)_localctx).result =  new NEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				    
				}
				}
				setState(63);
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

	public static class AndExprContext extends ParserRuleContext {
		public Expr result;
		public RelExprContext lhs;
		public RelExprContext rhs;
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitAndExpr(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); ((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==15) {
				{
				{
				setState(66); match(15);
				setState(67); ((AndExprContext)_localctx).rhs = relExpr();
				 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result); 
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

	public static class OrExprContext extends ParserRuleContext {
		public Expr result;
		public AndExprContext lhs;
		public AndExprContext rhs;
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitOrExpr(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); ((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(77); match(1);
				setState(78); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
				}
				}
				setState(85);
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

	public static class PrimaryContext extends ParserRuleContext {
		public Expr result;
		public Token Bool;
		public Token Int;
		public Token Ident;
		public Token Str;
		public OrExprContext x;
		public TerminalNode Ident() { return getToken(QLangParser.Ident, 0); }
		public TerminalNode Bool() { return getToken(QLangParser.Bool, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLangParser.Str, 0); }
		public TerminalNode Int() { return getToken(QLangParser.Int, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primary);
		try {
			setState(99);
			switch (_input.LA(1)) {
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(86); ((PrimaryContext)_localctx).Bool = match(Bool);
				 ((PrimaryContext)_localctx).result =  new BoolLiteral(Boolean.parseBoolean((((PrimaryContext)_localctx).Bool!=null?((PrimaryContext)_localctx).Bool.getText():null)));
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); ((PrimaryContext)_localctx).Int = match(Int);
				((PrimaryContext)_localctx).result =  new IntLiteral(Integer.parseInt((((PrimaryContext)_localctx).Int!=null?((PrimaryContext)_localctx).Int.getText():null)));
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 3);
				{
				setState(90); ((PrimaryContext)_localctx).Ident = match(Ident);
				((PrimaryContext)_localctx).result =  new IdentLiteral((((PrimaryContext)_localctx).Ident!=null?((PrimaryContext)_localctx).Ident.getText():null));
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 4);
				{
				setState(92); ((PrimaryContext)_localctx).Str = match(Str);
				((PrimaryContext)_localctx).result =  new StrLiteral((((PrimaryContext)_localctx).Str!=null?((PrimaryContext)_localctx).Str.getText():null));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 5);
				{
				setState(94); match(7);
				setState(95); ((PrimaryContext)_localctx).x = orExpr();
				setState(96); match(3);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).x.result; 
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\30h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63\n\4\f\4\16\4\66\13"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6I\n\6\f\6\16\6L\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7T\n\7\f\7\16\7"+
		"W\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bf\n\b\3"+
		"\b\2\t\2\4\6\b\n\f\16\2\5\4\2\b\b\n\n\3\2\6\7\5\2\4\4\13\16\20\20l\2\37"+
		"\3\2\2\2\4!\3\2\2\2\6,\3\2\2\2\b\67\3\2\2\2\nB\3\2\2\2\fM\3\2\2\2\16e"+
		"\3\2\2\2\20\21\7\6\2\2\21\22\5\2\2\2\22\23\b\2\1\2\23 \3\2\2\2\24\25\7"+
		"\7\2\2\25\26\5\2\2\2\26\27\b\2\1\2\27 \3\2\2\2\30\31\7\17\2\2\31\32\5"+
		"\2\2\2\32\33\b\2\1\2\33 \3\2\2\2\34\35\5\16\b\2\35\36\b\2\1\2\36 \3\2"+
		"\2\2\37\20\3\2\2\2\37\24\3\2\2\2\37\30\3\2\2\2\37\34\3\2\2\2 \3\3\2\2"+
		"\2!\"\5\2\2\2\")\b\3\1\2#$\t\2\2\2$%\5\2\2\2%&\b\3\1\2&(\3\2\2\2\'#\3"+
		"\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2,-\5\4\3\2-"+
		"\64\b\4\1\2./\t\3\2\2/\60\5\4\3\2\60\61\b\4\1\2\61\63\3\2\2\2\62.\3\2"+
		"\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\7\3\2\2\2\66\64\3\2"+
		"\2\2\678\5\6\4\28?\b\5\1\29:\t\4\2\2:;\5\6\4\2;<\b\5\1\2<>\3\2\2\2=9\3"+
		"\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\t\3\2\2\2A?\3\2\2\2BC\5\b\5\2CJ"+
		"\b\6\1\2DE\7\21\2\2EF\5\b\5\2FG\b\6\1\2GI\3\2\2\2HD\3\2\2\2IL\3\2\2\2"+
		"JH\3\2\2\2JK\3\2\2\2K\13\3\2\2\2LJ\3\2\2\2MN\5\n\6\2NU\b\7\1\2OP\7\3\2"+
		"\2PQ\5\n\6\2QR\b\7\1\2RT\3\2\2\2SO\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2V\r\3\2\2\2WU\3\2\2\2XY\7\30\2\2Yf\b\b\1\2Z[\7\26\2\2[f\b\b\1\2\\]\7"+
		"\25\2\2]f\b\b\1\2^_\7\27\2\2_f\b\b\1\2`a\7\t\2\2ab\5\f\7\2bc\7\5\2\2c"+
		"d\b\b\1\2df\3\2\2\2eX\3\2\2\2eZ\3\2\2\2e\\\3\2\2\2e^\3\2\2\2e`\3\2\2\2"+
		"f\17\3\2\2\2\t\37)\64?JUe";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}