// Generated from QL.g4 by ANTLR 4.1

	package antlr4;
	import ast.form.*;
	import ast.type.*;
	import ast.literals.*;
	import expr.conditional.*;
	import expr.operation.*;
	import expr.relational.*;
	import expr.unary.*;
	import expr.Expr;
	import expr.Ident;
	
	

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		WS=25, COMMENT=26, Bool=27, Ident=28, Int=29, Str=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'+'", "'*'", "'-'", "'('", "':'", "'if'", 
		"'<'", "'!='", "'<='", "'&&'", "'||'", "'{'", "'>'", "'integer'", "'string'", 
		"'else'", "'/'", "'=='", "'}'", "'>='", "'boolean'", "'!'", "WS", "COMMENT", 
		"Bool", "Ident", "Int", "Str"
	};
	public static final int
		RULE_forms = 0, RULE_statements = 1, RULE_statement = 2, RULE_question = 3, 
		RULE_ifstatement = 4, RULE_ifelsestate = 5, RULE_unExpr = 6, RULE_mulExpr = 7, 
		RULE_addExpr = 8, RULE_relExpr = 9, RULE_andExpr = 10, RULE_orExpr = 11, 
		RULE_primary = 12, RULE_valuetype = 13;
	public static final String[] ruleNames = {
		"forms", "statements", "statement", "question", "ifstatement", "ifelsestate", 
		"unExpr", "mulExpr", "addExpr", "relExpr", "andExpr", "orExpr", "primary", 
		"valuetype"
	};

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormsContext extends ParserRuleContext {
		public Form result;
		public Token Ident;
		public StatementsContext s;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FormsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitForms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormsContext forms() throws RecognitionException {
		FormsContext _localctx = new FormsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_forms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); match(1);
			setState(29); ((FormsContext)_localctx).Ident = match(Ident);
			setState(30); match(14);
			setState(31); ((FormsContext)_localctx).s = statements(0);
			setState(32); match(21);
			((FormsContext)_localctx).result =  new Form(new Ident((((FormsContext)_localctx).Ident!=null?((FormsContext)_localctx).Ident.getText():null)), (StatementList)((FormsContext)_localctx).s.result);
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
		public StatementsContext ss;
		public StatementContext s1;
		public StatementContext s2;
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState, _p);
		StatementsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(36); ((StatementsContext)_localctx).s1 = statement();
			((StatementsContext)_localctx).result =  new StatementList();
				      _localctx.result.addStatementtoList(((StatementsContext)_localctx).s1.result);
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState, _p);
					_localctx.ss = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(39);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(40); ((StatementsContext)_localctx).s2 = statement();
					((StatementsContext)_localctx).result =  ((StatementsContext)_localctx).ss.result;
					          		  ((StatementsContext)_localctx).ss.result.addStatementtoList(((StatementsContext)_localctx).s2.result);
					          	
					}
					} 
				}
				setState(47);
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
		public IfstatementContext x;
		public IfelsestateContext y;
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public IfelsestateContext ifelsestate() {
			return getRuleContext(IfelsestateContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); ((StatementContext)_localctx).q = question();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).q.result;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); ((StatementContext)_localctx).x = ifstatement();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).x.result;
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54); ((StatementContext)_localctx).y = ifelsestate();
				((StatementContext)_localctx).result =  ((StatementContext)_localctx).y.result;
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
		public ValuetypeContext v1;
		public ValuetypeContext v2;
		public OrExprContext e1;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public ValuetypeContext valuetype() {
			return getRuleContext(ValuetypeContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLParser.Str, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(60); match(7);
				setState(61); ((QuestionContext)_localctx).Str = match(Str);
				setState(62); ((QuestionContext)_localctx).v1 = valuetype();
				((QuestionContext)_localctx).result =  new Question(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), new StrLiteral((((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null)), ((QuestionContext)_localctx).v1.result);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(66); match(7);
				setState(67); ((QuestionContext)_localctx).Str = match(Str);
				setState(68); ((QuestionContext)_localctx).v2 = valuetype();
				setState(69); match(6);
				setState(70); ((QuestionContext)_localctx).e1 = orExpr();
				setState(71); match(2);
				((QuestionContext)_localctx).result =  new Computedquest (new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), new StrLiteral((((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null)), ((QuestionContext)_localctx).v2.result, ((QuestionContext)_localctx).e1.result);
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
		public StatementsContext s;
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(8);
			setState(77); match(6);
			setState(78); ((IfstatementContext)_localctx).expr = orExpr();
			setState(79); match(2);
			setState(80); match(14);
			setState(81); ((IfstatementContext)_localctx).s = statements(0);
			setState(82); match(21);
			((IfstatementContext)_localctx).result =  new Ifstate(((IfstatementContext)_localctx).s.result, ((IfstatementContext)_localctx).expr.result);
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

	public static class IfelsestateContext extends ParserRuleContext {
		public Statement result;
		public OrExprContext expr;
		public StatementsContext s1;
		public StatementsContext s2;
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public IfelsestateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelsestate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfelsestate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfelsestate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitIfelsestate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfelsestateContext ifelsestate() throws RecognitionException {
		IfelsestateContext _localctx = new IfelsestateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifelsestate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); match(8);
			setState(86); match(6);
			setState(87); ((IfelsestateContext)_localctx).expr = orExpr();
			setState(88); match(2);
			setState(89); match(14);
			setState(90); ((IfelsestateContext)_localctx).s1 = statements(0);
			setState(91); match(21);
			setState(92); match(18);
			setState(93); match(14);
			setState(94); ((IfelsestateContext)_localctx).s2 = statements(0);
			setState(95); match(21);
			((IfelsestateContext)_localctx).result =  new IfElse(((IfelsestateContext)_localctx).s1.result, ((IfelsestateContext)_localctx).expr.result, ((IfelsestateContext)_localctx).s2.result);
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
		public PrimaryContext r;
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterUnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitUnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitUnExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnExprContext unExpr() throws RecognitionException {
		UnExprContext _localctx = new UnExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unExpr);
		try {
			setState(113);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(98); match(3);
				setState(99); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); match(5);
				setState(103); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 3);
				{
				setState(106); match(24);
				setState(107); ((UnExprContext)_localctx).x = unExpr();
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
				setState(110); ((UnExprContext)_localctx).r = primary();
				 ((UnExprContext)_localctx).result =  ((UnExprContext)_localctx).r.result; 
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); ((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==19) {
				{
				{
				setState(117);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==4 || _la==19) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(118); ((MulExprContext)_localctx).rhs = unExpr();
				 
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
				        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("/")) {
				        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(125);
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); ((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==5) {
				{
				{
				setState(128);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==3 || _la==5) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(129); ((AddExprContext)_localctx).rhs = mulExpr();
				 
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
				        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
				        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(136);
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitRelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); ((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 10) | (1L << 11) | (1L << 15) | (1L << 20) | (1L << 22))) != 0)) {
				{
				{
				setState(139);
				((RelExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 10) | (1L << 11) | (1L << 15) | (1L << 20) | (1L << 22))) != 0)) ) {
					((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(140); ((RelExprContext)_localctx).rhs = addExpr();
				 
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
				setState(147);
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); ((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==12) {
				{
				{
				setState(150); match(12);
				setState(151); ((AndExprContext)_localctx).rhs = relExpr();
				 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result); 
				}
				}
				setState(158);
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
			if ( listener instanceof QLListener ) ((QLListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); ((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13) {
				{
				{
				setState(161); match(13);
				setState(162); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
				}
				}
				setState(169);
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
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public TerminalNode Bool() { return getToken(QLParser.Bool, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLParser.Str, 0); }
		public TerminalNode Int() { return getToken(QLParser.Int, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primary);
		try {
			setState(183);
			switch (_input.LA(1)) {
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(170); ((PrimaryContext)_localctx).Bool = match(Bool);
				 ((PrimaryContext)_localctx).result =  new BoolLiteral(Boolean.parseBoolean((((PrimaryContext)_localctx).Bool!=null?((PrimaryContext)_localctx).Bool.getText():null)));
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(172); ((PrimaryContext)_localctx).Int = match(Int);
				 ((PrimaryContext)_localctx).result =  new IntLiteral(Integer.parseInt((((PrimaryContext)_localctx).Int!=null?((PrimaryContext)_localctx).Int.getText():null))); 
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 3);
				{
				setState(174); ((PrimaryContext)_localctx).Ident = match(Ident);
				 ((PrimaryContext)_localctx).result =  new Ident((((PrimaryContext)_localctx).Ident!=null?((PrimaryContext)_localctx).Ident.getText():null)); 
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 4);
				{
				setState(176); ((PrimaryContext)_localctx).Str = match(Str);
				((PrimaryContext)_localctx).result =  new StrLiteral((((PrimaryContext)_localctx).Str!=null?((PrimaryContext)_localctx).Str.getText():null));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(178); match(6);
				setState(179); ((PrimaryContext)_localctx).x = orExpr();
				setState(180); match(2);
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

	public static class ValuetypeContext extends ParserRuleContext {
		public Type result;
		public ValuetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterValuetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitValuetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitValuetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuetypeContext valuetype() throws RecognitionException {
		ValuetypeContext _localctx = new ValuetypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_valuetype);
		try {
			setState(191);
			switch (_input.LA(1)) {
			case 23:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); match(23);
				((ValuetypeContext)_localctx).result =  new Booltype();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); match(16);
				((ValuetypeContext)_localctx).result =  new Inttype(); 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(189); match(17);
				((ValuetypeContext)_localctx).result =  new Strtype();
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
		case 1: return statements_sempred((StatementsContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3 \u00c4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bt\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\t|\n\t\f\t\16\t\177\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0087\n\n"+
		"\f\n\16\n\u008a\13\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0092\n\13\f\13"+
		"\16\13\u0095\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009d\n\f\f\f\16\f\u00a0"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a8\n\r\f\r\16\r\u00ab\13\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ba"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c2\n\17\3\17\2\20\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\2\5\4\2\6\6\25\25\4\2\5\5\7\7\6\2\13\r\21"+
		"\21\26\26\30\30\u00c7\2\36\3\2\2\2\4%\3\2\2\2\6;\3\2\2\2\bL\3\2\2\2\n"+
		"N\3\2\2\2\fW\3\2\2\2\16s\3\2\2\2\20u\3\2\2\2\22\u0080\3\2\2\2\24\u008b"+
		"\3\2\2\2\26\u0096\3\2\2\2\30\u00a1\3\2\2\2\32\u00b9\3\2\2\2\34\u00c1\3"+
		"\2\2\2\36\37\7\3\2\2\37 \7\36\2\2 !\7\20\2\2!\"\5\4\3\2\"#\7\27\2\2#$"+
		"\b\2\1\2$\3\3\2\2\2%&\b\3\1\2&\'\5\6\4\2\'(\b\3\1\2(/\3\2\2\2)*\6\3\2"+
		"\3*+\5\6\4\2+,\b\3\1\2,.\3\2\2\2-)\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3"+
		"\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\5\b\5\2\63\64\b\4\1\2\64<\3\2\2"+
		"\2\65\66\5\n\6\2\66\67\b\4\1\2\67<\3\2\2\289\5\f\7\29:\b\4\1\2:<\3\2\2"+
		"\2;\62\3\2\2\2;\65\3\2\2\2;8\3\2\2\2<\7\3\2\2\2=>\7\36\2\2>?\7\t\2\2?"+
		"@\7 \2\2@A\5\34\17\2AB\b\5\1\2BM\3\2\2\2CD\7\36\2\2DE\7\t\2\2EF\7 \2\2"+
		"FG\5\34\17\2GH\7\b\2\2HI\5\30\r\2IJ\7\4\2\2JK\b\5\1\2KM\3\2\2\2L=\3\2"+
		"\2\2LC\3\2\2\2M\t\3\2\2\2NO\7\n\2\2OP\7\b\2\2PQ\5\30\r\2QR\7\4\2\2RS\7"+
		"\20\2\2ST\5\4\3\2TU\7\27\2\2UV\b\6\1\2V\13\3\2\2\2WX\7\n\2\2XY\7\b\2\2"+
		"YZ\5\30\r\2Z[\7\4\2\2[\\\7\20\2\2\\]\5\4\3\2]^\7\27\2\2^_\7\24\2\2_`\7"+
		"\20\2\2`a\5\4\3\2ab\7\27\2\2bc\b\7\1\2c\r\3\2\2\2de\7\5\2\2ef\5\16\b\2"+
		"fg\b\b\1\2gt\3\2\2\2hi\7\7\2\2ij\5\16\b\2jk\b\b\1\2kt\3\2\2\2lm\7\32\2"+
		"\2mn\5\16\b\2no\b\b\1\2ot\3\2\2\2pq\5\32\16\2qr\b\b\1\2rt\3\2\2\2sd\3"+
		"\2\2\2sh\3\2\2\2sl\3\2\2\2sp\3\2\2\2t\17\3\2\2\2uv\5\16\b\2v}\b\t\1\2"+
		"wx\t\2\2\2xy\5\16\b\2yz\b\t\1\2z|\3\2\2\2{w\3\2\2\2|\177\3\2\2\2}{\3\2"+
		"\2\2}~\3\2\2\2~\21\3\2\2\2\177}\3\2\2\2\u0080\u0081\5\20\t\2\u0081\u0088"+
		"\b\n\1\2\u0082\u0083\t\3\2\2\u0083\u0084\5\20\t\2\u0084\u0085\b\n\1\2"+
		"\u0085\u0087\3\2\2\2\u0086\u0082\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\23\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008c\5\22\n\2\u008c\u0093\b\13\1\2\u008d\u008e\t\4\2\2\u008e\u008f\5"+
		"\22\n\2\u008f\u0090\b\13\1\2\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\25\3\2\2"+
		"\2\u0095\u0093\3\2\2\2\u0096\u0097\5\24\13\2\u0097\u009e\b\f\1\2\u0098"+
		"\u0099\7\16\2\2\u0099\u009a\5\24\13\2\u009a\u009b\b\f\1\2\u009b\u009d"+
		"\3\2\2\2\u009c\u0098\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\5\26\f"+
		"\2\u00a2\u00a9\b\r\1\2\u00a3\u00a4\7\17\2\2\u00a4\u00a5\5\26\f\2\u00a5"+
		"\u00a6\b\r\1\2\u00a6\u00a8\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a8\u00ab\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\31\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\7\35\2\2\u00ad\u00ba\b\16\1\2\u00ae\u00af\7\37\2"+
		"\2\u00af\u00ba\b\16\1\2\u00b0\u00b1\7\36\2\2\u00b1\u00ba\b\16\1\2\u00b2"+
		"\u00b3\7 \2\2\u00b3\u00ba\b\16\1\2\u00b4\u00b5\7\b\2\2\u00b5\u00b6\5\30"+
		"\r\2\u00b6\u00b7\7\4\2\2\u00b7\u00b8\b\16\1\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00ac\3\2\2\2\u00b9\u00ae\3\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00b2\3\2"+
		"\2\2\u00b9\u00b4\3\2\2\2\u00ba\33\3\2\2\2\u00bb\u00bc\7\31\2\2\u00bc\u00c2"+
		"\b\17\1\2\u00bd\u00be\7\22\2\2\u00be\u00c2\b\17\1\2\u00bf\u00c0\7\23\2"+
		"\2\u00c0\u00c2\b\17\1\2\u00c1\u00bb\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\35\3\2\2\2\r/;Ls}\u0088\u0093\u009e\u00a9\u00b9\u00c1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}