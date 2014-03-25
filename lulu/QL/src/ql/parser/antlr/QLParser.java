// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.form.stat.*;
import ql.ast.form.*;
import ql.ast.type.*;
import ql.ast.expr.exprType.*;
import ql.ast.expr.operation.*;
import ql.ast.expr.operation.add.*;
import ql.ast.expr.operation.andor.*;
import ql.ast.expr.operation.mul.*;
import ql.ast.expr.operation.rel.*;
import ql.ast.expr.operation.un.*;

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
		Str=25, WS=26, COMMENT=27, Int=28, Bool=29, Ident=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", 
		"'int'", "'<'", "'!='", "'<='", "'&&'", "'||'", "'{'", "'>'", "'string'", 
		"'else'", "'/'", "'=='", "'boolean'", "'}'", "'>='", "'!'", "Str", "WS", 
		"COMMENT", "Int", "Bool", "Ident"
	};
	public static final int
		RULE_form = 0, RULE_formItems = 1, RULE_question = 2, RULE_type = 3, RULE_stat = 4, 
		RULE_unExpr = 5, RULE_expr = 6, RULE_mulExpr = 7, RULE_addExpr = 8, RULE_relExpr = 9, 
		RULE_andExpr = 10, RULE_orExpr = 11;
	public static final String[] ruleNames = {
		"form", "formItems", "question", "type", "stat", "unExpr", "expr", "mulExpr", 
		"addExpr", "relExpr", "andExpr", "orExpr"
	};

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public Form result;
		public Token Ident;
		public FormItemsContext f;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public FormItemsContext formItems() {
			return getRuleContext(FormItemsContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(1);
			setState(25); ((FormContext)_localctx).Ident = match(Ident);
			setState(26); ((FormContext)_localctx).f = formItems();
			 ((FormContext)_localctx).result =  new Form(new Ident((((FormContext)_localctx).Ident!=null?((FormContext)_localctx).Ident.getText():null)), ((FormContext)_localctx).f.result); 
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

	public static class FormItemsContext extends ParserRuleContext {
		public List<FormItems> result;
		public QuestionContext q;
		public StatContext s;
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public FormItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterFormItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitFormItems(this);
		}
	}

	public final FormItemsContext formItems() throws RecognitionException {
		FormItemsContext _localctx = new FormItemsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formItems);
		 List<FormItems> formItems = new ArrayList(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(15);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==8 || _la==Ident) {
				{
				setState(36);
				switch (_input.LA(1)) {
				case Ident:
					{
					setState(30); ((FormItemsContext)_localctx).q = question();
					formItems.add(((FormItemsContext)_localctx).q.result);
					}
					break;
				case 8:
					{
					setState(33); ((FormItemsContext)_localctx).s = stat();
					formItems.add(((FormItemsContext)_localctx).s.result);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41); match(22);
			 ((FormItemsContext)_localctx).result =  formItems; 
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
		public Question result;
		public Token Ident;
		public Token Str;
		public TypeContext t;
		public OrExprContext x;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(45); match(7);
				setState(46); ((QuestionContext)_localctx).Str = match(Str);
				setState(47); ((QuestionContext)_localctx).t = type();
				 ((QuestionContext)_localctx).result =  new Question(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), (((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null), ((QuestionContext)_localctx).t.result); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(51); match(7);
				setState(52); ((QuestionContext)_localctx).Str = match(Str);
				setState(53); ((QuestionContext)_localctx).t = type();
				setState(54); match(6);
				setState(55); ((QuestionContext)_localctx).x = orExpr();
				setState(56); match(2);
				 ((QuestionContext)_localctx).result =  new ComputedQuestion(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), (((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null), ((QuestionContext)_localctx).t.result, ((QuestionContext)_localctx).x.result); 
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

	public static class TypeContext extends ParserRuleContext {
		public Type result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(67);
			switch (_input.LA(1)) {
			case 21:
				enterOuterAlt(_localctx, 1);
				{
				setState(61); match(21);
				 ((TypeContext)_localctx).result =  new BoolType();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 2);
				{
				setState(63); match(9);
				 ((TypeContext)_localctx).result =  new IntType();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(65); match(17);
				 ((TypeContext)_localctx).result =  new StrType();
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

	public static class StatContext extends ParserRuleContext {
		public Statement result;
		public OrExprContext or;
		public FormItemsContext ifBody;
		public FormItemsContext elseBody;
		public FormItemsContext formItems(int i) {
			return getRuleContext(FormItemsContext.class,i);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public List<FormItemsContext> formItems() {
			return getRuleContexts(FormItemsContext.class);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stat);
		try {
			setState(85);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); match(8);
				setState(70); match(6);
				setState(71); ((StatContext)_localctx).or = orExpr();
				setState(72); match(2);
				setState(73); ((StatContext)_localctx).ifBody = formItems();
				 ((StatContext)_localctx).result =  new IfStatement(((StatContext)_localctx).or.result, ((StatContext)_localctx).ifBody.result); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); match(8);
				setState(77); match(6);
				setState(78); ((StatContext)_localctx).or = orExpr();
				setState(79); match(2);
				setState(80); ((StatContext)_localctx).ifBody = formItems();
				setState(81); match(18);
				setState(82); ((StatContext)_localctx).elseBody = formItems();
				 ((StatContext)_localctx).result =  new IfElseStatement(((StatContext)_localctx).or.result, ((StatContext)_localctx).ifBody.result, ((StatContext)_localctx).elseBody.result); 
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

	public static class UnExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext x;
		public ExprContext r;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
	}

	public final UnExprContext unExpr() throws RecognitionException {
		UnExprContext _localctx = new UnExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unExpr);
		try {
			setState(102);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(87); match(3);
				setState(88); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); match(4);
				setState(92); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 3);
				{
				setState(95); match(24);
				setState(96); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Not(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 6:
			case Str:
			case Int:
			case Bool:
			case Ident:
				enterOuterAlt(_localctx, 4);
				{
				setState(99); ((UnExprContext)_localctx).r = expr();
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

	public static class ExprContext extends ParserRuleContext {
		public Expr result;
		public Token Int;
		public Token Bool;
		public Token Str;
		public Token Ident;
		public OrExprContext x;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public TerminalNode Bool() { return getToken(QLParser.Bool, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLParser.Str, 0); }
		public TerminalNode Int() { return getToken(QLParser.Int, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		try {
			setState(117);
			switch (_input.LA(1)) {
			case Int:
				enterOuterAlt(_localctx, 1);
				{
				setState(104); ((ExprContext)_localctx).Int = match(Int);
				 ((ExprContext)_localctx).result =  new IntExpr(Integer.parseInt((((ExprContext)_localctx).Int!=null?((ExprContext)_localctx).Int.getText():null)));
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(106); ((ExprContext)_localctx).Bool = match(Bool);
				 ((ExprContext)_localctx).result =  new BoolExpr(Boolean.parseBoolean((((ExprContext)_localctx).Bool!=null?((ExprContext)_localctx).Bool.getText():null)));
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 3);
				{
				setState(108); ((ExprContext)_localctx).Str = match(Str);
				 ((ExprContext)_localctx).result =  new StrExpr((((ExprContext)_localctx).Str!=null?((ExprContext)_localctx).Str.getText():null)); 
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 4);
				{
				setState(110); ((ExprContext)_localctx).Ident = match(Ident);
				 ((ExprContext)_localctx).result =  new Ident((((ExprContext)_localctx).Ident!=null?((ExprContext)_localctx).Ident.getText():null)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(112); match(6);
				setState(113); ((ExprContext)_localctx).x = orExpr();
				setState(114); match(2);
				 ((ExprContext)_localctx).result =  ((ExprContext)_localctx).x.result;
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
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); ((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==19) {
				{
				{
				setState(121);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==19) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(122); ((MulExprContext)_localctx).rhs = unExpr();
				 
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
				        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("/")) {
				        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(129);
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
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); ((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==4) {
				{
				{
				setState(132);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==3 || _la==4) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(133); ((AddExprContext)_localctx).rhs = mulExpr();
				 
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
				        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
				        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(140);
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
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); ((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 11) | (1L << 12) | (1L << 16) | (1L << 20) | (1L << 23))) != 0)) {
				{
				{
				setState(143);
				((RelExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 11) | (1L << 12) | (1L << 16) | (1L << 20) | (1L << 23))) != 0)) ) {
					((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(144); ((RelExprContext)_localctx).rhs = addExpr();
				 
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
				setState(151);
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
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); ((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13) {
				{
				{
				setState(154); match(13);
				setState(155); ((AndExprContext)_localctx).rhs = relExpr();
				 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result); 
				}
				}
				setState(162);
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
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); ((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==14) {
				{
				{
				setState(165); match(14);
				setState(166); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
				}
				}
				setState(173);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u00b1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5F\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6X\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7i\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bx\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\t\u0080\n\t\f\t\16\t\u0083\13\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\n\u008b\n\n\f\n\16\n\u008e\13\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u0096\n\13\f\13\16\13\u0099\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a1"+
		"\n\f\f\f\16\f\u00a4\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ac\n\r\f\r\16"+
		"\r\u00af\13\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\4\2\7\7\25"+
		"\25\3\2\5\6\6\2\f\16\22\22\26\26\31\31\u00b6\2\32\3\2\2\2\4\37\3\2\2\2"+
		"\6=\3\2\2\2\bE\3\2\2\2\nW\3\2\2\2\fh\3\2\2\2\16w\3\2\2\2\20y\3\2\2\2\22"+
		"\u0084\3\2\2\2\24\u008f\3\2\2\2\26\u009a\3\2\2\2\30\u00a5\3\2\2\2\32\33"+
		"\7\3\2\2\33\34\7 \2\2\34\35\5\4\3\2\35\36\b\2\1\2\36\3\3\2\2\2\37(\7\21"+
		"\2\2 !\5\6\4\2!\"\b\3\1\2\"\'\3\2\2\2#$\5\n\6\2$%\b\3\1\2%\'\3\2\2\2&"+
		" \3\2\2\2&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2"+
		"+,\7\30\2\2,-\b\3\1\2-\5\3\2\2\2./\7 \2\2/\60\7\t\2\2\60\61\7\33\2\2\61"+
		"\62\5\b\5\2\62\63\b\4\1\2\63>\3\2\2\2\64\65\7 \2\2\65\66\7\t\2\2\66\67"+
		"\7\33\2\2\678\5\b\5\289\7\b\2\29:\5\30\r\2:;\7\4\2\2;<\b\4\1\2<>\3\2\2"+
		"\2=.\3\2\2\2=\64\3\2\2\2>\7\3\2\2\2?@\7\27\2\2@F\b\5\1\2AB\7\13\2\2BF"+
		"\b\5\1\2CD\7\23\2\2DF\b\5\1\2E?\3\2\2\2EA\3\2\2\2EC\3\2\2\2F\t\3\2\2\2"+
		"GH\7\n\2\2HI\7\b\2\2IJ\5\30\r\2JK\7\4\2\2KL\5\4\3\2LM\b\6\1\2MX\3\2\2"+
		"\2NO\7\n\2\2OP\7\b\2\2PQ\5\30\r\2QR\7\4\2\2RS\5\4\3\2ST\7\24\2\2TU\5\4"+
		"\3\2UV\b\6\1\2VX\3\2\2\2WG\3\2\2\2WN\3\2\2\2X\13\3\2\2\2YZ\7\5\2\2Z[\5"+
		"\f\7\2[\\\b\7\1\2\\i\3\2\2\2]^\7\6\2\2^_\5\f\7\2_`\b\7\1\2`i\3\2\2\2a"+
		"b\7\32\2\2bc\5\f\7\2cd\b\7\1\2di\3\2\2\2ef\5\16\b\2fg\b\7\1\2gi\3\2\2"+
		"\2hY\3\2\2\2h]\3\2\2\2ha\3\2\2\2he\3\2\2\2i\r\3\2\2\2jk\7\36\2\2kx\b\b"+
		"\1\2lm\7\37\2\2mx\b\b\1\2no\7\33\2\2ox\b\b\1\2pq\7 \2\2qx\b\b\1\2rs\7"+
		"\b\2\2st\5\30\r\2tu\7\4\2\2uv\b\b\1\2vx\3\2\2\2wj\3\2\2\2wl\3\2\2\2wn"+
		"\3\2\2\2wp\3\2\2\2wr\3\2\2\2x\17\3\2\2\2yz\5\f\7\2z\u0081\b\t\1\2{|\t"+
		"\2\2\2|}\5\f\7\2}~\b\t\1\2~\u0080\3\2\2\2\177{\3\2\2\2\u0080\u0083\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\21\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\5\20\t\2\u0085\u008c\b\n\1\2\u0086\u0087\t\3\2\2"+
		"\u0087\u0088\5\20\t\2\u0088\u0089\b\n\1\2\u0089\u008b\3\2\2\2\u008a\u0086"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\23\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\5\22\n\2\u0090\u0097\b\13"+
		"\1\2\u0091\u0092\t\4\2\2\u0092\u0093\5\22\n\2\u0093\u0094\b\13\1\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0091\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\25\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b"+
		"\5\24\13\2\u009b\u00a2\b\f\1\2\u009c\u009d\7\17\2\2\u009d\u009e\5\24\13"+
		"\2\u009e\u009f\b\f\1\2\u009f\u00a1\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1\u00a4"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\27\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00ad\b\r\1\2\u00a7\u00a8\7"+
		"\20\2\2\u00a8\u00a9\5\26\f\2\u00a9\u00aa\b\r\1\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\31\3\2\2\2\u00af\u00ad\3\2\2\2\16&(=EWhw\u0081\u008c\u0097"+
		"\u00a2\u00ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}