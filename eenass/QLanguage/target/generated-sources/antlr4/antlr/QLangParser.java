// Generated from QLang.g4 by ANTLR 4.1
package antlr;

import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.binExpr.*;
import ast.expr.unExpression.*;
import ast.expr.literal.*;
import ast.expr.types.*;
import ast.statement.*;

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
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		WS=25, COMMENT=26, NewLine=27, Bool=28, Ident=29, Int=30, Str=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", 
		"'<'", "'!='", "'<='", "'&&'", "'||'", "'{'", "'>'", "'integer'", "'string'", 
		"'else'", "'/'", "'=='", "'boolean'", "'}'", "'>='", "'!'", "WS", "COMMENT", 
		"NewLine", "Bool", "Ident", "Int", "Str"
	};
	public static final int
		RULE_init = 0, RULE_form = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_question = 4, RULE_ifstatement = 5, RULE_ifelsestatement = 6, RULE_type = 7, 
		RULE_unExpr = 8, RULE_mulExpr = 9, RULE_addExpr = 10, RULE_relExpr = 11, 
		RULE_andExpr = 12, RULE_orExpr = 13, RULE_primary = 14;
	public static final String[] ruleNames = {
		"init", "form", "statements", "statement", "question", "ifstatement", 
		"ifelsestatement", "type", "unExpr", "mulExpr", "addExpr", "relExpr", 
		"andExpr", "orExpr", "primary"
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
	public static class InitContext extends ParserRuleContext {
		public Form result;
		public FormContext f;
		public FormContext form() {
			return getRuleContext(FormContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); ((InitContext)_localctx).f = form();
			((InitContext)_localctx).result = ((InitContext)_localctx).f.result;
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

	public static class FormContext extends ParserRuleContext {
		public Form result;
		public Token Ident;
		public StatementsContext s;
		public TerminalNode Ident() { return getToken(QLangParser.Ident, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(1);
			setState(34); ((FormContext)_localctx).Ident = match(Ident);
			setState(35); match(14);
			setState(36); ((FormContext)_localctx).s = statements(0);
			setState(37); match(22);
			((FormContext)_localctx).result =  new Form(new Identifier((((FormContext)_localctx).Ident!=null?((FormContext)_localctx).Ident.getText():null)), (StatementList)((FormContext)_localctx).s.result);
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

	public static class StatementsContext extends ParserRuleContext {
		public int _p;
		public StatementList result;
		public StatementsContext sts;
		public StatementContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementsContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState, _p);
		StatementsContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(41); ((StatementsContext)_localctx).s = statement();
			((StatementsContext)_localctx).result =  new StatementList();
								_localctx.result.addStatement(((StatementsContext)_localctx).s.result);
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState, _p);
					_localctx.sts = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(44);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(45); ((StatementsContext)_localctx).s = statement();
					((StatementsContext)_localctx).result =  ((StatementsContext)_localctx).sts.result; 	
					          									((StatementsContext)_localctx).sts.result.addStatement(((StatementsContext)_localctx).s.result);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public Statement result;
		public QuestionContext q;
		public IfstatementContext istate;
		public IfelsestatementContext iestate;
		public IfelsestatementContext ifelsestatement() {
			return getRuleContext(IfelsestatementContext.class,0);
		}
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); ((StatementContext)_localctx).q = question();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).q.result;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); ((StatementContext)_localctx).istate = ifstatement();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).istate.result;
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59); ((StatementContext)_localctx).iestate = ifelsestatement();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).iestate.result;
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

	public static class QuestionContext extends ParserRuleContext {
		public Statement result;
		public Token Ident;
		public Token Str;
		public TypeContext t;
		public OrExprContext expr;
		public TerminalNode Ident() { return getToken(QLangParser.Ident, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLangParser.Str, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(65); match(7);
				setState(66); ((QuestionContext)_localctx).Str = match(Str);
				setState(67); ((QuestionContext)_localctx).t = type();
				((QuestionContext)_localctx).result =  new Question(new Identifier((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), new StrLiteral((((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null)), ((QuestionContext)_localctx).t.result);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(71); match(7);
				setState(72); ((QuestionContext)_localctx).Str = match(Str);
				setState(73); ((QuestionContext)_localctx).t = type();
				setState(74); ((QuestionContext)_localctx).expr = orExpr();
				((QuestionContext)_localctx).result =  new ComputedQuestion(new Identifier((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), new StrLiteral((((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null)), ((QuestionContext)_localctx).t.result, ((QuestionContext)_localctx).expr.result);
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

	public static class IfstatementContext extends ParserRuleContext {
		public Statement result;
		public OrExprContext expr;
		public StatementsContext sts;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitIfstatement(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(8);
			setState(80); match(6);
			setState(81); ((IfstatementContext)_localctx).expr = orExpr();
			setState(82); match(2);
			setState(83); match(14);
			setState(84); ((IfstatementContext)_localctx).sts = statements(0);
			setState(85); match(22);
			((IfstatementContext)_localctx).result =  new IfStatement(((IfstatementContext)_localctx).sts.result, ((IfstatementContext)_localctx).expr.result);
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

	public static class IfelsestatementContext extends ParserRuleContext {
		public Statement result;
		public OrExprContext expr;
		public StatementsContext sts1;
		public StatementsContext sts2;
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public IfelsestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelsestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterIfelsestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitIfelsestatement(this);
		}
	}

	public final IfelsestatementContext ifelsestatement() throws RecognitionException {
		IfelsestatementContext _localctx = new IfelsestatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifelsestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(8);
			setState(89); match(6);
			setState(90); ((IfelsestatementContext)_localctx).expr = orExpr();
			setState(91); match(2);
			setState(92); match(14);
			setState(93); ((IfelsestatementContext)_localctx).sts1 = statements(0);
			setState(94); match(22);
			setState(95); match(18);
			setState(96); match(14);
			setState(97); ((IfelsestatementContext)_localctx).sts2 = statements(0);
			setState(98); match(22);
			((IfelsestatementContext)_localctx).result =  new IfelseStatement(((IfelsestatementContext)_localctx).sts1.result, ((IfelsestatementContext)_localctx).expr.result, ((IfelsestatementContext)_localctx).sts2.result);
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
		public Type result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(107);
			switch (_input.LA(1)) {
			case 21:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); match(21);
				((TypeContext)_localctx).result =  new BoolType();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 2);
				{
				setState(103); match(17);
				((TypeContext)_localctx).result =  new StrType();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 3);
				{
				setState(105); match(16);
				((TypeContext)_localctx).result =  new IntType();
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

	public static class UnExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext x;
		public PrimaryContext y;
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
		enterRule(_localctx, 16, RULE_unExpr);
		try {
			setState(124);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); match(3);
				setState(110); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 2);
				{
				setState(113); match(4);
				setState(114); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 3);
				{
				setState(117); match(24);
				setState(118); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Not(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 6:
			case Bool:
			case Ident:
			case Int:
			case Str:
				enterOuterAlt(_localctx, 4);
				{
				setState(121); ((UnExprContext)_localctx).y = primary();
				((UnExprContext)_localctx).result =  ((UnExprContext)_localctx).y.result;
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
		enterRule(_localctx, 18, RULE_mulExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126); ((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					((MulExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==5 || _la==19) ) {
						((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(129); ((MulExprContext)_localctx).rhs = unExpr();
					 
					      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
					        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
					      }
					      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("/")) {
					        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);      
					      }
					    
					}
					} 
				}
				setState(136);
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
		enterRule(_localctx, 20, RULE_addExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137); ((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(139);
					((AddExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==3 || _la==4) ) {
						((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(140); ((AddExprContext)_localctx).rhs = mulExpr();
					 
					      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
					        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
					      }
					      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
					        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);      
					      }
					    
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		enterRule(_localctx, 22, RULE_relExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148); ((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(150);
					((RelExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 10) | (1L << 11) | (1L << 15) | (1L << 20) | (1L << 23))) != 0)) ) {
						((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(151); ((RelExprContext)_localctx).rhs = addExpr();
					 
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
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 24, RULE_andExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159); ((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(161); match(12);
					setState(162); ((AndExprContext)_localctx).rhs = relExpr();
					 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result); 
					}
					} 
				}
				setState(169);
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
		enterRule(_localctx, 26, RULE_orExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170); ((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(172); match(13);
					setState(173); ((OrExprContext)_localctx).rhs = andExpr();
					 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 28, RULE_primary);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(181); ((PrimaryContext)_localctx).Bool = match(Bool);
				 ((PrimaryContext)_localctx).result =  new BoolLiteral(Boolean.parseBoolean((((PrimaryContext)_localctx).Bool!=null?((PrimaryContext)_localctx).Bool.getText():null)));
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(183); ((PrimaryContext)_localctx).Int = match(Int);
				((PrimaryContext)_localctx).result =  new IntLiteral(Integer.parseInt((((PrimaryContext)_localctx).Int!=null?((PrimaryContext)_localctx).Int.getText():null)));
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 3);
				{
				setState(185); ((PrimaryContext)_localctx).Ident = match(Ident);
				((PrimaryContext)_localctx).result =  new Identifier((((PrimaryContext)_localctx).Ident!=null?((PrimaryContext)_localctx).Ident.getText():null));
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 4);
				{
				setState(187); ((PrimaryContext)_localctx).Str = match(Str);
				((PrimaryContext)_localctx).result =  new StrLiteral((((PrimaryContext)_localctx).Str!=null?((PrimaryContext)_localctx).Str.getText():null));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(189); match(6);
				setState(190); ((PrimaryContext)_localctx).x = orExpr();
				setState(191); match(2);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: return statements_sempred((StatementsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3!\u00c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63\n\4\f\4\16"+
		"\4\66\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\177\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0087"+
		"\n\13\f\13\16\13\u008a\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0092\n\f\f\f"+
		"\16\f\u0095\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009d\n\r\f\r\16\r\u00a0"+
		"\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a8\n\16\f\16\16\16\u00ab\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00b3\n\17\f\17\16\17\u00b6\13"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00c5\n\20\3\20\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\5\4"+
		"\2\7\7\25\25\3\2\5\6\6\2\13\r\21\21\26\26\31\31\u00c9\2 \3\2\2\2\4#\3"+
		"\2\2\2\6*\3\2\2\2\b@\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16Z\3\2\2\2\20m\3\2"+
		"\2\2\22~\3\2\2\2\24\u0080\3\2\2\2\26\u008b\3\2\2\2\30\u0096\3\2\2\2\32"+
		"\u00a1\3\2\2\2\34\u00ac\3\2\2\2\36\u00c4\3\2\2\2 !\5\4\3\2!\"\b\2\1\2"+
		"\"\3\3\2\2\2#$\7\3\2\2$%\7\37\2\2%&\7\20\2\2&\'\5\6\4\2\'(\7\30\2\2()"+
		"\b\3\1\2)\5\3\2\2\2*+\b\4\1\2+,\5\b\5\2,-\b\4\1\2-\64\3\2\2\2./\6\4\2"+
		"\3/\60\5\b\5\2\60\61\b\4\1\2\61\63\3\2\2\2\62.\3\2\2\2\63\66\3\2\2\2\64"+
		"\62\3\2\2\2\64\65\3\2\2\2\65\7\3\2\2\2\66\64\3\2\2\2\678\5\n\6\289\b\5"+
		"\1\29A\3\2\2\2:;\5\f\7\2;<\b\5\1\2<A\3\2\2\2=>\5\16\b\2>?\b\5\1\2?A\3"+
		"\2\2\2@\67\3\2\2\2@:\3\2\2\2@=\3\2\2\2A\t\3\2\2\2BC\7\37\2\2CD\7\t\2\2"+
		"DE\7!\2\2EF\5\20\t\2FG\b\6\1\2GP\3\2\2\2HI\7\37\2\2IJ\7\t\2\2JK\7!\2\2"+
		"KL\5\20\t\2LM\5\34\17\2MN\b\6\1\2NP\3\2\2\2OB\3\2\2\2OH\3\2\2\2P\13\3"+
		"\2\2\2QR\7\n\2\2RS\7\b\2\2ST\5\34\17\2TU\7\4\2\2UV\7\20\2\2VW\5\6\4\2"+
		"WX\7\30\2\2XY\b\7\1\2Y\r\3\2\2\2Z[\7\n\2\2[\\\7\b\2\2\\]\5\34\17\2]^\7"+
		"\4\2\2^_\7\20\2\2_`\5\6\4\2`a\7\30\2\2ab\7\24\2\2bc\7\20\2\2cd\5\6\4\2"+
		"de\7\30\2\2ef\b\b\1\2f\17\3\2\2\2gh\7\27\2\2hn\b\t\1\2ij\7\23\2\2jn\b"+
		"\t\1\2kl\7\22\2\2ln\b\t\1\2mg\3\2\2\2mi\3\2\2\2mk\3\2\2\2n\21\3\2\2\2"+
		"op\7\5\2\2pq\5\22\n\2qr\b\n\1\2r\177\3\2\2\2st\7\6\2\2tu\5\22\n\2uv\b"+
		"\n\1\2v\177\3\2\2\2wx\7\32\2\2xy\5\22\n\2yz\b\n\1\2z\177\3\2\2\2{|\5\36"+
		"\20\2|}\b\n\1\2}\177\3\2\2\2~o\3\2\2\2~s\3\2\2\2~w\3\2\2\2~{\3\2\2\2\177"+
		"\23\3\2\2\2\u0080\u0081\5\22\n\2\u0081\u0088\b\13\1\2\u0082\u0083\t\2"+
		"\2\2\u0083\u0084\5\22\n\2\u0084\u0085\b\13\1\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0082\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\25\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\5\24\13\2\u008c"+
		"\u0093\b\f\1\2\u008d\u008e\t\3\2\2\u008e\u008f\5\24\13\2\u008f\u0090\b"+
		"\f\1\2\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0092\u0095\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\27\3\2\2\2\u0095\u0093\3\2\2"+
		"\2\u0096\u0097\5\26\f\2\u0097\u009e\b\r\1\2\u0098\u0099\t\4\2\2\u0099"+
		"\u009a\5\26\f\2\u009a\u009b\b\r\1\2\u009b\u009d\3\2\2\2\u009c\u0098\3"+
		"\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\31\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\5\30\r\2\u00a2\u00a9\b\16"+
		"\1\2\u00a3\u00a4\7\16\2\2\u00a4\u00a5\5\30\r\2\u00a5\u00a6\b\16\1\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\33\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad"+
		"\5\32\16\2\u00ad\u00b4\b\17\1\2\u00ae\u00af\7\17\2\2\u00af\u00b0\5\32"+
		"\16\2\u00b0\u00b1\b\17\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\35\3\2\2"+
		"\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7\36\2\2\u00b8\u00c5\b\20\1\2\u00b9"+
		"\u00ba\7 \2\2\u00ba\u00c5\b\20\1\2\u00bb\u00bc\7\37\2\2\u00bc\u00c5\b"+
		"\20\1\2\u00bd\u00be\7!\2\2\u00be\u00c5\b\20\1\2\u00bf\u00c0\7\b\2\2\u00c0"+
		"\u00c1\5\34\17\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\b\20\1\2\u00c3\u00c5"+
		"\3\2\2\2\u00c4\u00b7\3\2\2\2\u00c4\u00b9\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4"+
		"\u00bd\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c5\37\3\2\2\2\r\64@Om~\u0088\u0093"+
		"\u009e\u00a9\u00b4\u00c4";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}