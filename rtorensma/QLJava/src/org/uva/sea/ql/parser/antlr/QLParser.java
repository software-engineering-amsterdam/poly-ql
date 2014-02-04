// $ANTLR 3.4 src/org/uva/sea/ql/parser/antlr/QL.g 2014-02-04 16:40:15

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.form.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int Str=8;
    public static final int WS=9;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[41+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // src/org/uva/sea/ql/parser/antlr/QL.g:17:1: form returns [Form result] : 'form' Ident block ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        Block block2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:18:3: ( 'form' Ident block )
            // src/org/uva/sea/ql/parser/antlr/QL.g:18:5: 'form' Ident block
            {
            match(input,27,FOLLOW_27_in_form46); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form48); if (state.failed) return result;

            pushFollow(FOLLOW_block_in_form50);
            block2=block();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), block2); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "block"
    // src/org/uva/sea/ql/parser/antlr/QL.g:21:1: block returns [Block result] : '{' ( stat )* '}' ;
    public final Block block() throws RecognitionException {
        Block result = null;

        int block_StartIndex = input.index();

        Stat stat3 =null;


         List<Stat> statements = new ArrayList<Stat>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:23:3: ( '{' ( stat )* '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:23:5: '{' ( stat )* '}'
            {
            match(input,31,FOLLOW_31_in_block74); if (state.failed) return result;

            // src/org/uva/sea/ql/parser/antlr/QL.g:23:9: ( stat )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==28||LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:23:11: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_block78);
            	    stat3=stat();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { statements.add(stat3); }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,33,FOLLOW_33_in_block85); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Block(statements); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, block_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "block"



    // $ANTLR start "stat"
    // src/org/uva/sea/ql/parser/antlr/QL.g:26:1: stat returns [Stat result] : ( computed | question | ifThenElse | ifThen | block );
    public final Stat stat() throws RecognitionException {
        Stat result = null;

        int stat_StartIndex = input.index();

        Computed computed4 =null;

        Question question5 =null;

        IfThenElse ifThenElse6 =null;

        IfThen ifThen7 =null;

        Block block8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:27:3: ( computed | question | ifThenElse | ifThen | block )
            int alt2=5;
            switch ( input.LA(1) ) {
            case Ident:
                {
                int LA2_1 = input.LA(2);

                if ( (synpred2_QL()) ) {
                    alt2=1;
                }
                else if ( (synpred3_QL()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
                }
                break;
            case 28:
                {
                int LA2_2 = input.LA(2);

                if ( (synpred4_QL()) ) {
                    alt2=3;
                }
                else if ( (synpred5_QL()) ) {
                    alt2=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
                }
                break;
            case 31:
                {
                alt2=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:27:5: computed
                    {
                    pushFollow(FOLLOW_computed_in_stat104);
                    computed4=computed();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = computed4; }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:28:5: question
                    {
                    pushFollow(FOLLOW_question_in_stat112);
                    question5=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question5; }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ifThenElse
                    {
                    pushFollow(FOLLOW_ifThenElse_in_stat120);
                    ifThenElse6=ifThenElse();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ifThenElse6; }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:30:5: ifThen
                    {
                    pushFollow(FOLLOW_ifThen_in_stat128);
                    ifThen7=ifThen();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ifThen7; }

                    }
                    break;
                case 5 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:31:5: block
                    {
                    pushFollow(FOLLOW_block_in_stat136);
                    block8=block();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = block8; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, stat_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "stat"



    // $ANTLR start "computed"
    // src/org/uva/sea/ql/parser/antlr/QL.g:34:1: computed returns [Computed result] : Ident ':' Str type '(' orExpr ')' ;
    public final Computed computed() throws RecognitionException {
        Computed result = null;

        int computed_StartIndex = input.index();

        Token Ident9=null;
        Token Str10=null;
        org.uva.sea.ql.ast.types.Type type11 =null;

        Expr orExpr12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:35:3: ( Ident ':' Str type '(' orExpr ')' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:35:5: Ident ':' Str type '(' orExpr ')'
            {
            Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_computed155); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_computed157); if (state.failed) return result;

            Str10=(Token)match(input,Str,FOLLOW_Str_in_computed159); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computed161);
            type11=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,13,FOLLOW_13_in_computed163); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computed165);
            orExpr12=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computed167); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Computed((Ident9!=null?Ident9.getText():null), (Str10!=null?Str10.getText():null), type11, orExpr12); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, computed_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computed"



    // $ANTLR start "question"
    // src/org/uva/sea/ql/parser/antlr/QL.g:38:1: question returns [Question result] : Ident ':' Str type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident13=null;
        Token Str14=null;
        org.uva.sea.ql.ast.types.Type type15 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:39:3: ( Ident ':' Str type )
            // src/org/uva/sea/ql/parser/antlr/QL.g:39:5: Ident ':' Str type
            {
            Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_question186); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question188); if (state.failed) return result;

            Str14=(Token)match(input,Str,FOLLOW_Str_in_question190); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question192);
            type15=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question((Ident13!=null?Ident13.getText():null), (Str14!=null?Str14.getText():null), type15); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // src/org/uva/sea/ql/parser/antlr/QL.g:42:1: type returns [org.uva.sea.ql.ast.types.Type result] : ( 'integer' | 'string' | 'boolean' );
    public final org.uva.sea.ql.ast.types.Type type() throws RecognitionException {
        org.uva.sea.ql.ast.types.Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( 'integer' | 'string' | 'boolean' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt3=1;
                }
                break;
            case 30:
                {
                alt3=2;
                }
                break;
            case 25:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:43:5: 'integer'
                    {
                    match(input,29,FOLLOW_29_in_type211); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int(); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:44:5: 'string'
                    {
                    match(input,30,FOLLOW_30_in_type219); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str(); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:45:5: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_type227); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool(); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "ifThenElse"
    // src/org/uva/sea/ql/parser/antlr/QL.g:48:1: ifThenElse returns [IfThenElse result] : 'if' '(' orExpr ')' i= stat 'else' e= stat ;
    public final IfThenElse ifThenElse() throws RecognitionException {
        IfThenElse result = null;

        int ifThenElse_StartIndex = input.index();

        Stat i =null;

        Stat e =null;

        Expr orExpr16 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:49:3: ( 'if' '(' orExpr ')' i= stat 'else' e= stat )
            // src/org/uva/sea/ql/parser/antlr/QL.g:49:5: 'if' '(' orExpr ')' i= stat 'else' e= stat
            {
            match(input,28,FOLLOW_28_in_ifThenElse246); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifThenElse248); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifThenElse250);
            orExpr16=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifThenElse252); if (state.failed) return result;

            pushFollow(FOLLOW_stat_in_ifThenElse256);
            i=stat();

            state._fsp--;
            if (state.failed) return result;

            match(input,26,FOLLOW_26_in_ifThenElse258); if (state.failed) return result;

            pushFollow(FOLLOW_stat_in_ifThenElse262);
            e=stat();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfThenElse(orExpr16, i, e); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, ifThenElse_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifThenElse"



    // $ANTLR start "ifThen"
    // src/org/uva/sea/ql/parser/antlr/QL.g:52:1: ifThen returns [IfThen result] : 'if' '(' orExpr ')' stat ;
    public final IfThen ifThen() throws RecognitionException {
        IfThen result = null;

        int ifThen_StartIndex = input.index();

        Expr orExpr17 =null;

        Stat stat18 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:53:3: ( 'if' '(' orExpr ')' stat )
            // src/org/uva/sea/ql/parser/antlr/QL.g:53:5: 'if' '(' orExpr ')' stat
            {
            match(input,28,FOLLOW_28_in_ifThen281); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifThen283); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifThen285);
            orExpr17=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifThen287); if (state.failed) return result;

            pushFollow(FOLLOW_stat_in_ifThen289);
            stat18=stat();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfThen(orExpr17, stat18); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, ifThen_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifThen"



    // $ANTLR start "primary"
    // src/org/uva/sea/ql/parser/antlr/QL.g:56:1: primary returns [Expr result] : ( Int | Bool | Ident | Str | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int19=null;
        Token Bool20=null;
        Token Ident21=null;
        Token Str22=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:57:3: ( Int | Bool | Ident | Str | '(' x= orExpr ')' )
            int alt4=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt4=1;
                }
                break;
            case Bool:
                {
                alt4=2;
                }
                break;
            case Ident:
                {
                alt4=3;
                }
                break;
            case Str:
                {
                alt4=4;
                }
                break;
            case 13:
                {
                alt4=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:57:5: Int
                    {
                    Int19=(Token)match(input,Int,FOLLOW_Int_in_primary308); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int19!=null?Int19.getText():null))); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:58:5: Bool
                    {
                    Bool20=(Token)match(input,Bool,FOLLOW_Bool_in_primary318); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool20!=null?Bool20.getText():null))); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:59:5: Ident
                    {
                    Ident21=(Token)match(input,Ident,FOLLOW_Ident_in_primary327); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident21!=null?Ident21.getText():null)); }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:60:5: Str
                    {
                    Str22=(Token)match(input,Str,FOLLOW_Str_in_primary335); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Str((Str22!=null?Str22.getText():null)); }

                    }
                    break;
                case 5 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:61:5: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary345); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary349);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary351); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:64:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:65:3: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 10:
                {
                alt5=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Str:
            case 13:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:65:6: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr370); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr374);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:66:6: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr383); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr387);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:67:6: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr396); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr400);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:68:6: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr411);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:71:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:72:3: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:72:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr437);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:72:43: (op= ( '*' | '/' ) rhs= unExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15||LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:72:45: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==15||input.LA(1)==18 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr457);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	        if ((op!=null?op.getText():null).equals("*")) {
            	          result = new Mul(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals("/")) {
            	          result = new Div(result, rhs);
            	        }
            	      }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:83:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:84:3: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:84:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr485);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:84:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= 16 && LA7_0 <= 17)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:84:46: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr503);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	        if ((op!=null?op.getText():null).equals("+")) {
            	          result = new Add(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals("-")) {
            	          result = new Sub(result, rhs);
            	        }
            	      }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:95:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:96:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:96:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr530);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:96:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==11||(LA8_0 >= 20 && LA8_0 <= 24)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:96:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr554);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	        if ((op!=null?op.getText():null).equals("<")) {
            	          result = new LT(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals("<=")) {
            	          result = new LEq(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals(">")) {
            	          result = new GT(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals(">=")) {
            	          result = new GEq(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals("==")) {
            	          result = new Eq(result, rhs);
            	        }
            	        if ((op!=null?op.getText():null).equals("!=")) {
            	          result = new NEq(result, rhs);
            	        }
            	      }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:119:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:120:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:120:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr582);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:120:44: ( '&&' rhs= relExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==12) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:120:46: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr588); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr592);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:123:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:124:3: (lhs= andExpr ( '||' rhs= andExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:124:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr618);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:124:46: ( '||' rhs= andExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:124:48: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr624); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr628);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred2_QL
    public final void synpred2_QL_fragment() throws RecognitionException {
        // src/org/uva/sea/ql/parser/antlr/QL.g:27:5: ( computed )
        // src/org/uva/sea/ql/parser/antlr/QL.g:27:5: computed
        {
        pushFollow(FOLLOW_computed_in_synpred2_QL104);
        computed();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_QL

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        // src/org/uva/sea/ql/parser/antlr/QL.g:28:5: ( question )
        // src/org/uva/sea/ql/parser/antlr/QL.g:28:5: question
        {
        pushFollow(FOLLOW_question_in_synpred3_QL112);
        question();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        // src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ( ifThenElse )
        // src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ifThenElse
        {
        pushFollow(FOLLOW_ifThenElse_in_synpred4_QL120);
        ifThenElse();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // $ANTLR start synpred5_QL
    public final void synpred5_QL_fragment() throws RecognitionException {
        // src/org/uva/sea/ql/parser/antlr/QL.g:30:5: ( ifThen )
        // src/org/uva/sea/ql/parser/antlr/QL.g:30:5: ifThen
        {
        pushFollow(FOLLOW_ifThen_in_synpred5_QL128);
        ifThen();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_QL

    // Delegated rules

    public final boolean synpred5_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_27_in_form46 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form48 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_block_in_form50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_block74 = new BitSet(new long[]{0x0000000290000040L});
    public static final BitSet FOLLOW_stat_in_block78 = new BitSet(new long[]{0x0000000290000040L});
    public static final BitSet FOLLOW_33_in_block85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computed_in_stat104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_stat112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThenElse_in_stat120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThen_in_stat128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_stat136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computed155 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_computed157 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Str_in_computed159 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_type_in_computed161 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_computed163 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_computed165 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computed167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question186 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question188 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Str_in_question190 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_type_in_question192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_type211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_type227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifThenElse246 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifThenElse248 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifThenElse250 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifThenElse252 = new BitSet(new long[]{0x0000000090000040L});
    public static final BitSet FOLLOW_stat_in_ifThenElse256 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ifThenElse258 = new BitSet(new long[]{0x0000000090000040L});
    public static final BitSet FOLLOW_stat_in_ifThenElse262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifThen281 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifThen283 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifThen285 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifThen287 = new BitSet(new long[]{0x0000000090000040L});
    public static final BitSet FOLLOW_stat_in_ifThen289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary345 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary349 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr370 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr383 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr396 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr437 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr445 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr457 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr485 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr493 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr503 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr530 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr538 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr554 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr582 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr588 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr592 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr618 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr624 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr628 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_computed_in_synpred2_QL104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_synpred3_QL112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThenElse_in_synpred4_QL120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThen_in_synpred5_QL128 = new BitSet(new long[]{0x0000000000000002L});

}