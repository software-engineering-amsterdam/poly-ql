// $ANTLR 3.4 C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2014-03-20 13:41:58

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.stmt.*;
import antlr.ANTLRException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Ident", "Int", "MLCOMMENT", "SLComment", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int T__34=34;
    public static final int Bool=4;
    public static final int Ident=5;
    public static final int Int=6;
    public static final int MLCOMMENT=7;
    public static final int SLComment=8;
    public static final int Str=9;
    public static final int WS=10;

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
    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }


    	private List<String> errors = new ArrayList <String> ();
    	 
    	public List<String> getAllErrors() {
    	  return new ArrayList<String>(errors);
    	}
    	
    	public boolean hasErrors() {
    	  return !errors.isEmpty();
    	}
    	 
    	public void reportError(RecognitionException e) {
    		if ( state.errorRecovery ) {
    		  return;
    		}
    		state.syntaxErrors++;
    		state.errorRecovery = true;
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
    		msg = null;
    		if ( e instanceof NoViableAltException ) {
    			NoViableAltException nvae = (NoViableAltException)e;
    			msg = " unexpected token: '"+e.token.getText()+"'";
    		} else {
    			msg = getErrorMessage(e, tokenNames);
    		}
        errors.add(hdr+msg);
    	}



    // $ANTLR start "primary"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:1: primary returns [Expr result] : ( Bool | Int | Str | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Bool1=null;
        Token Int2=null;
        Token Str3=null;
        Token Ident4=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:5: ( Bool | Int | Str | Ident | '(' x= orExpr ')' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt1=1;
                }
                break;
            case Int:
                {
                alt1=2;
                }
                break;
            case Str:
                {
                alt1=3;
                }
                break;
            case Ident:
                {
                alt1=4;
                }
                break;
            case 14:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:7: Bool
                    {
                    Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary64); 


                            if((Bool1!=null?Bool1.getText():null).equals("true")){
                              result = new BoolLiteral(true);
                            }else{
                              result = new BoolLiteral(false);
                            }
                          

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:7: Int
                    {
                    Int2=(Token)match(input,Int,FOLLOW_Int_in_primary74); 

                     result = new IntLiteral(Integer.parseInt((Int2!=null?Int2.getText():null))); 

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:7: Str
                    {
                    Str3=(Token)match(input,Str,FOLLOW_Str_in_primary84); 

                     result = new StrLiteral((Str3!=null?Str3.getText():null)); 

                    }
                    break;
                case 4 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:7: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary94); 

                     result = new Ident((Ident4!=null?Ident4.getText():null)); 

                    }
                    break;
                case 5 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:7: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary104); 

                    pushFollow(FOLLOW_orExpr_in_primary110);
                    x=orExpr();

                    state._fsp--;


                    match(input,15,FOLLOW_15_in_primary112); 

                     result = x; 

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
        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Str:
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:8: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr140); 

                    pushFollow(FOLLOW_unExpr_in_unExpr144);
                    x=unExpr();

                    state._fsp--;


                     result = new Pos(x); 

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:8: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr155); 

                    pushFollow(FOLLOW_unExpr_in_unExpr159);
                    x=unExpr();

                    state._fsp--;


                     result = new Neg(x); 

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:8: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr170); 

                    pushFollow(FOLLOW_unExpr_in_unExpr174);
                    x=unExpr();

                    state._fsp--;


                     result = new Not(x); 

                    }
                    break;
                case 4 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr187);
                    x=primary();

                    state._fsp--;


                     result = x; 

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
        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr225);
            lhs=unExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==16||input.LA(1)==19 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr245);
            	    rhs=unExpr();

            	    state._fsp--;


            	     
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);      
            	          }
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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
        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr283);
            lhs=mulExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr301);
            	    rhs=mulExpr();

            	    state._fsp--;


            	     
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);      
            	          }
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
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
        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr336);
            lhs=addExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12||(LA5_0 >= 21 && LA5_0 <= 25)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr360);
            	    rhs=addExpr();

            	    state._fsp--;


            	     
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
            	    break;

            	default :
            	    break loop5;
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
        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr398);
            lhs=relExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:48: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr404); 

            	    pushFollow(FOLLOW_relExpr_in_andExpr408);
            	    rhs=relExpr();

            	    state._fsp--;


            	     result = new And(result, rhs); 

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
        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr442);
            lhs=andExpr();

            state._fsp--;


             result = lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==33) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:50: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr448); 

            	    pushFollow(FOLLOW_andExpr_in_orExpr452);
            	    rhs=andExpr();

            	    state._fsp--;


            	     result = new Or(result, rhs); 

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
        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "type"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:1: type returns [Type result] : ( 'boolean' | 'string' | 'integer' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:127:5: ( 'boolean' | 'string' | 'integer' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt8=1;
                }
                break;
            case 31:
                {
                alt8=2;
                }
                break;
            case 30:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:127:7: 'boolean'
                    {
                    match(input,26,FOLLOW_26_in_type482); 

                    result = new Bool(); 

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:7: 'string'
                    {
                    match(input,31,FOLLOW_31_in_type492); 

                    result = new Str(); 

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:7: 'integer'
                    {
                    match(input,30,FOLLOW_30_in_type502); 

                    result = new Int(); 

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
        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "stmt"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:1: stmt returns [Stmt result] : ( question | conditionalQuestion );
    public final Stmt stmt() throws RecognitionException {
        Stmt result = null;

        int stmt_StartIndex = input.index();

        Stmt question5 =null;

        Stmt conditionalQuestion6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:5: ( question | conditionalQuestion )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Ident) ) {
                alt9=1;
            }
            else if ( (LA9_0==29) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:7: question
                    {
                    pushFollow(FOLLOW_question_in_stmt529);
                    question5=question();

                    state._fsp--;


                     result = question5; 

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:7: conditionalQuestion
                    {
                    pushFollow(FOLLOW_conditionalQuestion_in_stmt539);
                    conditionalQuestion6=conditionalQuestion();

                    state._fsp--;


                     result = conditionalQuestion6; 

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
        }
        return result;
    }
    // $ANTLR end "stmt"



    // $ANTLR start "ifThenStatement"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:1: ifThenStatement returns [Stmt result] : 'if' '(' condition= orExpr ')' '{' ifBlock= block '}' ;
    public final Stmt ifThenStatement() throws RecognitionException {
        Stmt result = null;

        int ifThenStatement_StartIndex = input.index();

        Expr condition =null;

        Block ifBlock =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:5: ( 'if' '(' condition= orExpr ')' '{' ifBlock= block '}' )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:7: 'if' '(' condition= orExpr ')' '{' ifBlock= block '}'
            {
            match(input,29,FOLLOW_29_in_ifThenStatement566); 

            match(input,14,FOLLOW_14_in_ifThenStatement568); 

            pushFollow(FOLLOW_orExpr_in_ifThenStatement572);
            condition=orExpr();

            state._fsp--;


            match(input,15,FOLLOW_15_in_ifThenStatement574); 

            match(input,32,FOLLOW_32_in_ifThenStatement576); 

            pushFollow(FOLLOW_block_in_ifThenStatement582);
            ifBlock=block();

            state._fsp--;


            match(input,34,FOLLOW_34_in_ifThenStatement584); 

             result = new IfThenStatement(condition, ifBlock); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "ifThenStatement"



    // $ANTLR start "conditionalQuestion"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:1: conditionalQuestion returns [Stmt result] : 'if' '(' condition= orExpr ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? ;
    public final Stmt conditionalQuestion() throws RecognitionException {
        Stmt result = null;

        int conditionalQuestion_StartIndex = input.index();

        Expr condition =null;

        Block ifBlock =null;

        Block elseBlock =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:5: ( 'if' '(' condition= orExpr ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )? )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:7: 'if' '(' condition= orExpr ')' '{' ifBlock= block '}' ( 'else' '{' elseBlock= block '}' )?
            {
            match(input,29,FOLLOW_29_in_conditionalQuestion611); 

            match(input,14,FOLLOW_14_in_conditionalQuestion613); 

            pushFollow(FOLLOW_orExpr_in_conditionalQuestion617);
            condition=orExpr();

            state._fsp--;


            match(input,15,FOLLOW_15_in_conditionalQuestion619); 

            match(input,32,FOLLOW_32_in_conditionalQuestion621); 

            pushFollow(FOLLOW_block_in_conditionalQuestion627);
            ifBlock=block();

            state._fsp--;


            match(input,34,FOLLOW_34_in_conditionalQuestion629); 

             result = new IfThenStatement(condition, ifBlock); 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:7: ( 'else' '{' elseBlock= block '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:8: 'else' '{' elseBlock= block '}'
                    {
                    match(input,27,FOLLOW_27_in_conditionalQuestion640); 

                    match(input,32,FOLLOW_32_in_conditionalQuestion642); 

                    pushFollow(FOLLOW_block_in_conditionalQuestion648);
                    elseBlock=block();

                    state._fsp--;


                    match(input,34,FOLLOW_34_in_conditionalQuestion650); 

                     result = new IfThenElseStatement(condition, ifBlock, elseBlock); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "conditionalQuestion"



    // $ANTLR start "question"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:1: question returns [Stmt result] : answerableQuestion ( '(' computation= orExpr ')' )? ;
    public final Stmt question() throws RecognitionException {
        Stmt result = null;

        int question_StartIndex = input.index();

        Expr computation =null;

        Question answerableQuestion7 =null;



              Question q = null;
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:5: ( answerableQuestion ( '(' computation= orExpr ')' )? )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: answerableQuestion ( '(' computation= orExpr ')' )?
            {
            pushFollow(FOLLOW_answerableQuestion_in_question692);
            answerableQuestion7=answerableQuestion();

            state._fsp--;


             result = q = answerableQuestion7; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:7: ( '(' computation= orExpr ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==14) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:8: '(' computation= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_question703); 

                    pushFollow(FOLLOW_orExpr_in_question709);
                    computation=orExpr();

                    state._fsp--;


                    match(input,15,FOLLOW_15_in_question711); 


                    				  result = new ComputedQuestion(q.getIdent(), q.getLabel(), q.getType(), computation); 
                    				

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "answerableQuestion"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:159:1: answerableQuestion returns [Question result] : Ident ':' label= Str type ;
    public final Question answerableQuestion() throws RecognitionException {
        Question result = null;

        int answerableQuestion_StartIndex = input.index();

        Token label=null;
        Token Ident8=null;
        Type type9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:5: ( Ident ':' label= Str type )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:7: Ident ':' label= Str type
            {
            Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_answerableQuestion752); 

            match(input,20,FOLLOW_20_in_answerableQuestion754); 

            label=(Token)match(input,Str,FOLLOW_Str_in_answerableQuestion760); 

            pushFollow(FOLLOW_type_in_answerableQuestion762);
            type9=type();

            state._fsp--;


             result = new AnswerableQuestion(new Ident((Ident8!=null?Ident8.getText():null)), (label!=null?label.getText():null), type9); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "answerableQuestion"



    // $ANTLR start "block"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:163:1: block returns [Block result] : ( stmt )* ;
    public final Block block() throws RecognitionException {
        Block result = null;

        int block_StartIndex = input.index();

        Stmt stmt10 =null;



              result = new Block();
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:5: ( ( stmt )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:7: ( stmt )*
            {
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:7: ( stmt )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Ident||LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:8: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block803);
            	    stmt10=stmt();

            	    state._fsp--;


            	     result.addStmt(stmt10); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
        }
        return result;
    }
    // $ANTLR end "block"



    // $ANTLR start "form"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:171:1: form returns [Form result] : 'form' Ident '{' block '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident11=null;
        Block block12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:172:5: ( 'form' Ident '{' block '}' )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:172:7: 'form' Ident '{' block '}'
            {
            match(input,28,FOLLOW_28_in_form832); 

            Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_form834); 

            match(input,32,FOLLOW_32_in_form836); 

            pushFollow(FOLLOW_block_in_form838);
            block12=block();

            state._fsp--;


            match(input,34,FOLLOW_34_in_form840); 

             result = new Form(new Ident((Ident11!=null?Ident11.getText():null)), block12); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "form"

    // Delegated rules


 

    public static final BitSet FOLLOW_Bool_in_primary64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary104 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_primary110 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr140 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_unExpr144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr155 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_unExpr159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr170 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_unExpr174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr225 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr233 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr245 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr283 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr291 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr301 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr336 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_set_in_relExpr344 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_addExpr_in_relExpr360 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr398 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr404 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_relExpr_in_andExpr408 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr442 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr448 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_andExpr_in_orExpr452 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_26_in_type482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_stmt529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalQuestion_in_stmt539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ifThenStatement566 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifThenStatement568 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_ifThenStatement572 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifThenStatement574 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifThenStatement576 = new BitSet(new long[]{0x0000000420000020L});
    public static final BitSet FOLLOW_block_in_ifThenStatement582 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ifThenStatement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_conditionalQuestion611 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionalQuestion613 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_conditionalQuestion617 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionalQuestion619 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_conditionalQuestion621 = new BitSet(new long[]{0x0000000420000020L});
    public static final BitSet FOLLOW_block_in_conditionalQuestion627 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_conditionalQuestion629 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_conditionalQuestion640 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_conditionalQuestion642 = new BitSet(new long[]{0x0000000420000020L});
    public static final BitSet FOLLOW_block_in_conditionalQuestion648 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_conditionalQuestion650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_answerableQuestion_in_question692 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_question703 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_question709 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_question711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_answerableQuestion752 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_answerableQuestion754 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Str_in_answerableQuestion760 = new BitSet(new long[]{0x00000000C4000000L});
    public static final BitSet FOLLOW_type_in_answerableQuestion762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_block803 = new BitSet(new long[]{0x0000000020000022L});
    public static final BitSet FOLLOW_28_in_form832 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Ident_in_form834 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_form836 = new BitSet(new long[]{0x0000000420000020L});
    public static final BitSet FOLLOW_block_in_form838 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form840 = new BitSet(new long[]{0x0000000000000002L});

}