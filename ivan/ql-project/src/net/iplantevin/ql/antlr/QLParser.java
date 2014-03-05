// Generated from QL.g4 by ANTLR 4.2
package net.iplantevin.ql.antlr;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__7 = 1, T__6 = 2, T__5 = 3, T__4 = 4, T__3 = 5, T__2 = 6, T__1 = 7, T__0 = 8, NOT = 9,
            ADD = 10, SUB = 11, MUL = 12, DIV = 13, LT = 14, GT = 15, LEQ = 16, GEQ = 17, EQ = 18, NEQ = 19,
            AND = 20, OR = 21, BOOLEAN = 22, INTEGER = 23, STRING = 24, TRUE = 25, FALSE = 26, ID = 27,
            INT = 28, COMMENT = 29, COMMENT2 = 30, WS = 31, STR = 32;
    public static final String[] tokenNames = {
            "<INVALID>", "'form'", "'{'", "')'", "'('", "':'", "'if'", "'else'", "'}'",
            "'!'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'<='", "'>='", "'=='",
            "'!='", "'&&'", "'||'", "'boolean'", "'integer'", "'string'", "'true'",
            "'false'", "ID", "INT", "COMMENT", "COMMENT2", "WS", "STR"
    };
    public static final int
            RULE_forms = 0, RULE_form = 1, RULE_block = 2, RULE_stat = 3, RULE_expr = 4,
            RULE_type = 5, RULE_bool = 6;
    public static final String[] ruleNames = {
            "forms", "form", "block", "stat", "expr", "type", "bool"
    };

    @Override
    public String getGrammarFileName() {
        return "QL.g4";
    }

    @Override
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public QLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class FormsContext extends ParserRuleContext {
        public List<FormContext> form() {
            return getRuleContexts(FormContext.class);
        }

        public FormContext form(int i) {
            return getRuleContext(FormContext.class, i);
        }

        public FormsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forms;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitForms(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FormsContext forms() throws RecognitionException {
        FormsContext _localctx = new FormsContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_forms);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(17);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == 1) {
                    {
                        {
                            setState(14);
                            form();
                        }
                    }
                    setState(19);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FormContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(QLParser.ID, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public FormContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_form;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitForm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FormContext form() throws RecognitionException {
        FormContext _localctx = new FormContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_form);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(20);
                match(1);
                setState(21);
                match(ID);
                setState(22);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BlockContext extends ParserRuleContext {
        public StatContext stat(int i) {
            return getRuleContext(StatContext.class, i);
        }

        public List<StatContext> stat() {
            return getRuleContexts(StatContext.class);
        }

        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(24);
                match(2);
                setState(28);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 6) | (1L << ID))) != 0)) {
                    {
                        {
                            setState(25);
                            stat();
                        }
                    }
                    setState(30);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(31);
                match(8);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatContext extends ParserRuleContext {
        public StatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stat;
        }

        public StatContext() {
        }

        public void copyFrom(StatContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class IfElseContext extends StatContext {
        public StatContext stat(int i) {
            return getRuleContext(StatContext.class, i);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public List<StatContext> stat() {
            return getRuleContexts(StatContext.class);
        }

        public IfElseContext(StatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitIfElse(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IfContext extends StatContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public StatContext stat() {
            return getRuleContext(StatContext.class, 0);
        }

        public IfContext(StatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitIf(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BlockStatContext extends StatContext {
        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public BlockStatContext(StatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitBlockStat(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ComputationContext extends StatContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(QLParser.ID, 0);
        }

        public TerminalNode STR() {
            return getToken(QLParser.STR, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public ComputationContext(StatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitComputation(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class QuestionContext extends StatContext {
        public TerminalNode ID() {
            return getToken(QLParser.ID, 0);
        }

        public TerminalNode STR() {
            return getToken(QLParser.STR, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public QuestionContext(StatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitQuestion(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatContext stat() throws RecognitionException {
        StatContext _localctx = new StatContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_stat);
        try {
            setState(60);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    _localctx = new IfElseContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(33);
                    match(6);
                    setState(34);
                    match(4);
                    setState(35);
                    expr(0);
                    setState(36);
                    match(3);
                    setState(37);
                    stat();
                    setState(38);
                    match(7);
                    setState(39);
                    stat();
                }
                break;

                case 2:
                    _localctx = new IfContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(41);
                    match(6);
                    setState(42);
                    match(4);
                    setState(43);
                    expr(0);
                    setState(44);
                    match(3);
                    setState(45);
                    stat();
                }
                break;

                case 3:
                    _localctx = new BlockStatContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(47);
                    block();
                }
                break;

                case 4:
                    _localctx = new ComputationContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(48);
                    match(ID);
                    setState(49);
                    match(5);
                    setState(50);
                    match(STR);
                    setState(51);
                    type();
                    setState(52);
                    match(4);
                    setState(53);
                    expr(0);
                    setState(54);
                    match(3);
                }
                break;

                case 5:
                    _localctx = new QuestionContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(56);
                    match(ID);
                    setState(57);
                    match(5);
                    setState(58);
                    match(STR);
                    setState(59);
                    type();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public ExprContext() {
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class UnaryContext extends ExprContext {
        public Token op;

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(QLParser.NOT, 0);
        }

        public TerminalNode SUB() {
            return getToken(QLParser.SUB, 0);
        }

        public TerminalNode ADD() {
            return getToken(QLParser.ADD, 0);
        }

        public UnaryContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitUnary(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EqualityContext extends ExprContext {
        public Token op;

        public TerminalNode NEQ() {
            return getToken(QLParser.NEQ, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode EQ() {
            return getToken(QLParser.EQ, 0);
        }

        public EqualityContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitEquality(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntegerContext extends ExprContext {
        public TerminalNode INT() {
            return getToken(QLParser.INT, 0);
        }

        public IntegerContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitInteger(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MultiplicationContext extends ExprContext {
        public Token op;

        public TerminalNode MUL() {
            return getToken(QLParser.MUL, 0);
        }

        public TerminalNode DIV() {
            return getToken(QLParser.DIV, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public MultiplicationContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitMultiplication(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StringContext extends ExprContext {
        public TerminalNode STR() {
            return getToken(QLParser.STR, 0);
        }

        public StringContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class RelationalContext extends ExprContext {
        public Token op;

        public TerminalNode GEQ() {
            return getToken(QLParser.GEQ, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public TerminalNode LT() {
            return getToken(QLParser.LT, 0);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LEQ() {
            return getToken(QLParser.LEQ, 0);
        }

        public TerminalNode GT() {
            return getToken(QLParser.GT, 0);
        }

        public RelationalContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitRelational(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LogicalOrContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public TerminalNode OR() {
            return getToken(QLParser.OR, 0);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public LogicalOrContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitLogicalOr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BooleanContext extends ExprContext {
        public BoolContext bool() {
            return getRuleContext(BoolContext.class, 0);
        }

        public BooleanContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitBoolean(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AdditionContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode SUB() {
            return getToken(QLParser.SUB, 0);
        }

        public TerminalNode ADD() {
            return getToken(QLParser.ADD, 0);
        }

        public AdditionContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitAddition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IdentifierContext extends ExprContext {
        public TerminalNode ID() {
            return getToken(QLParser.ID, 0);
        }

        public IdentifierContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitIdentifier(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParanthesesContext extends ExprContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public ParanthesesContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitParantheses(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LogicalAndContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public TerminalNode AND() {
            return getToken(QLParser.AND, 0);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public LogicalAndContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitLogicalAnd(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 8;
        enterRecursionRule(_localctx, 8, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(73);
                switch (_input.LA(1)) {
                    case NOT:
                    case ADD:
                    case SUB: {
                        _localctx = new UnaryContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(63);
                        ((UnaryContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB))) != 0))) {
                            ((UnaryContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        }
                        consume();
                        setState(64);
                        expr(12);
                    }
                    break;
                    case TRUE:
                    case FALSE: {
                        _localctx = new BooleanContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(65);
                        bool();
                    }
                    break;
                    case ID: {
                        _localctx = new IdentifierContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(66);
                        match(ID);
                    }
                    break;
                    case INT: {
                        _localctx = new IntegerContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(67);
                        match(INT);
                    }
                    break;
                    case STR: {
                        _localctx = new StringContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(68);
                        match(STR);
                    }
                    break;
                    case 4: {
                        _localctx = new ParanthesesContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(69);
                        match(4);
                        setState(70);
                        expr(0);
                        setState(71);
                        match(3);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(95);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                while (_alt != 2 && _alt != -1) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(93);
                            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                                case 1: {
                                    _localctx = new MultiplicationContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(75);
                                    if (!(precpred(_ctx, 11)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(76);
                                    ((MultiplicationContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == MUL || _la == DIV)) {
                                        ((MultiplicationContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    }
                                    consume();
                                    setState(77);
                                    expr(12);
                                }
                                break;

                                case 2: {
                                    _localctx = new AdditionContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(78);
                                    if (!(precpred(_ctx, 10)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                                    setState(79);
                                    ((AdditionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == ADD || _la == SUB)) {
                                        ((AdditionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    }
                                    consume();
                                    setState(80);
                                    expr(11);
                                }
                                break;

                                case 3: {
                                    _localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(81);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(82);
                                    ((RelationalContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LEQ) | (1L << GEQ))) != 0))) {
                                        ((RelationalContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    }
                                    consume();
                                    setState(83);
                                    expr(10);
                                }
                                break;

                                case 4: {
                                    _localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(84);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(85);
                                    ((EqualityContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == EQ || _la == NEQ)) {
                                        ((EqualityContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    }
                                    consume();
                                    setState(86);
                                    expr(9);
                                }
                                break;

                                case 5: {
                                    _localctx = new LogicalAndContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(87);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(88);
                                    match(AND);
                                    setState(89);
                                    expr(8);
                                }
                                break;

                                case 6: {
                                    _localctx = new LogicalOrContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(90);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(91);
                                    match(OR);
                                    setState(92);
                                    expr(7);
                                }
                                break;
                            }
                        }
                    }
                    setState(97);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        public TypeContext() {
        }

        public void copyFrom(TypeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class BoolTypeContext extends TypeContext {
        public TerminalNode BOOLEAN() {
            return getToken(QLParser.BOOLEAN, 0);
        }

        public BoolTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitBoolType(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntTypeContext extends TypeContext {
        public TerminalNode INTEGER() {
            return getToken(QLParser.INTEGER, 0);
        }

        public IntTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitIntType(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StrTypeContext extends TypeContext {
        public TerminalNode STRING() {
            return getToken(QLParser.STRING, 0);
        }

        public StrTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitStrType(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_type);
        try {
            setState(101);
            switch (_input.LA(1)) {
                case BOOLEAN:
                    _localctx = new BoolTypeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(98);
                    match(BOOLEAN);
                }
                break;
                case INTEGER:
                    _localctx = new IntTypeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(99);
                    match(INTEGER);
                }
                break;
                case STRING:
                    _localctx = new StrTypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(100);
                    match(STRING);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolContext extends ParserRuleContext {
        public BoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bool;
        }

        public BoolContext() {
        }

        public void copyFrom(BoolContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class TrueContext extends BoolContext {
        public TerminalNode TRUE() {
            return getToken(QLParser.TRUE, 0);
        }

        public TrueContext(BoolContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitTrue(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FalseContext extends BoolContext {
        public TerminalNode FALSE() {
            return getToken(QLParser.FALSE, 0);
        }

        public FalseContext(BoolContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof QLVisitor)
                return ((QLVisitor<? extends T>) visitor).visitFalse(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolContext bool() throws RecognitionException {
        BoolContext _localctx = new BoolContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_bool);
        try {
            setState(105);
            switch (_input.LA(1)) {
                case TRUE:
                    _localctx = new TrueContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(103);
                    match(TRUE);
                }
                break;
                case FALSE:
                    _localctx = new FalseContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(104);
                    match(FALSE);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 4:
                return expr_sempred((ExprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 11);

            case 1:
                return precpred(_ctx, 10);

            case 2:
                return precpred(_ctx, 9);

            case 3:
                return precpred(_ctx, 8);

            case 4:
                return precpred(_ctx, 7);

            case 5:
                return precpred(_ctx, 6);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"n\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16\2\25" +
                    "\13\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\4\3\4\3\5\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5" +
                    "\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6`\n\6\f\6\16\6c\13\6\3\7\3\7\3\7\5\7h" +
                    "\n\7\3\b\3\b\5\bl\n\b\3\b\2\3\n\t\2\4\6\b\n\f\16\2\7\3\2\13\r\3\2\16\17" +
                    "\3\2\f\r\3\2\20\23\3\2\24\25z\2\23\3\2\2\2\4\26\3\2\2\2\6\32\3\2\2\2\b" +
                    ">\3\2\2\2\nK\3\2\2\2\fg\3\2\2\2\16k\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2" +
                    "\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\23\3\2\2" +
                    "\2\26\27\7\3\2\2\27\30\7\35\2\2\30\31\5\6\4\2\31\5\3\2\2\2\32\36\7\4\2" +
                    "\2\33\35\5\b\5\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2" +
                    "\37!\3\2\2\2 \36\3\2\2\2!\"\7\n\2\2\"\7\3\2\2\2#$\7\b\2\2$%\7\6\2\2%&" +
                    "\5\n\6\2&\'\7\5\2\2\'(\5\b\5\2()\7\t\2\2)*\5\b\5\2*?\3\2\2\2+,\7\b\2\2" +
                    ",-\7\6\2\2-.\5\n\6\2./\7\5\2\2/\60\5\b\5\2\60?\3\2\2\2\61?\5\6\4\2\62" +
                    "\63\7\35\2\2\63\64\7\7\2\2\64\65\7\"\2\2\65\66\5\f\7\2\66\67\7\6\2\2\67" +
                    "8\5\n\6\289\7\5\2\29?\3\2\2\2:;\7\35\2\2;<\7\7\2\2<=\7\"\2\2=?\5\f\7\2" +
                    ">#\3\2\2\2>+\3\2\2\2>\61\3\2\2\2>\62\3\2\2\2>:\3\2\2\2?\t\3\2\2\2@A\b" +
                    "\6\1\2AB\t\2\2\2BL\5\n\6\16CL\5\16\b\2DL\7\35\2\2EL\7\36\2\2FL\7\"\2\2" +
                    "GH\7\6\2\2HI\5\n\6\2IJ\7\5\2\2JL\3\2\2\2K@\3\2\2\2KC\3\2\2\2KD\3\2\2\2" +
                    "KE\3\2\2\2KF\3\2\2\2KG\3\2\2\2La\3\2\2\2MN\f\r\2\2NO\t\3\2\2O`\5\n\6\16" +
                    "PQ\f\f\2\2QR\t\4\2\2R`\5\n\6\rST\f\13\2\2TU\t\5\2\2U`\5\n\6\fVW\f\n\2" +
                    "\2WX\t\6\2\2X`\5\n\6\13YZ\f\t\2\2Z[\7\26\2\2[`\5\n\6\n\\]\f\b\2\2]^\7" +
                    "\27\2\2^`\5\n\6\t_M\3\2\2\2_P\3\2\2\2_S\3\2\2\2_V\3\2\2\2_Y\3\2\2\2_\\" +
                    "\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\13\3\2\2\2ca\3\2\2\2dh\7\30\2" +
                    "\2eh\7\31\2\2fh\7\32\2\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2h\r\3\2\2\2il\7" +
                    "\33\2\2jl\7\34\2\2ki\3\2\2\2kj\3\2\2\2l\17\3\2\2\2\n\23\36>K_agk";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}