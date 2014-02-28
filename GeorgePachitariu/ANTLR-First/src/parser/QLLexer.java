// $ANTLR 3.5.1 C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g 2014-02-28 13:21:15

  package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int BOOLEAN=4;
	public static final int COLONS=5;
	public static final int COMMENT=6;
	public static final int ELSE=7;
	public static final int IDENT=8;
	public static final int INT=9;
	public static final int STRING=10;
	public static final int WS=11;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public QLLexer() {} 
	public QLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public QLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g"; }

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:11:7: ( '!' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:11:9: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:12:7: ( '!=' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:12:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:13:7: ( '&&' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:13:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:14:7: ( '(' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:14:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:15:7: ( ')' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:15:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:16:7: ( '*' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:16:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:17:7: ( '+' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:17:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:18:7: ( '-' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:18:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:19:7: ( '/' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:19:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:20:7: ( '<' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:20:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:21:7: ( '<=' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:21:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:22:7: ( '==' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:22:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:23:7: ( '>' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:23:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:24:7: ( '>=' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:24:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:25:7: ( 'boolean' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:25:9: 'boolean'
			{
			match("boolean"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:26:7: ( 'form' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:26:9: 'form'
			{
			match("form"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:27:7: ( 'if' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:27:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:28:7: ( 'integer' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:28:9: 'integer'
			{
			match("integer"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:29:7: ( 'money' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:29:9: 'money'
			{
			match("money"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:30:7: ( '{' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:30:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:31:7: ( '||' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:31:9: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:32:7: ( '}' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:32:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:174:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:174:7: ( ' ' | '\\t' | '\\n' | '\\r' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:178:14: ( '/*' ( . )* '*/' | '//' ( . )* '\\n' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='/') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='*') ) {
					alt3=1;
				}
				else if ( (LA3_1=='/') ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:178:16: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:178:21: ( . )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0=='*') ) {
							int LA1_1 = input.LA(2);
							if ( (LA1_1=='/') ) {
								alt1=2;
							}
							else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
								alt1=1;
							}

						}
						else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:178:21: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop1;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:179:16: '//' ( . )* '\\n'
					{
					match("//"); 

					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:179:21: ( . )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0=='\n') ) {
							alt2=2;
						}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:179:21: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop2;
						}
					}

					match('\n'); 
					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:182:7: ( '\"' (~ '\"' )* '\"' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:182:9: '\"' (~ '\"' )* '\"'
			{
			match('\"'); 
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:182:13: (~ '\"' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:183:8: ( 'true' | 'false' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='t') ) {
				alt5=1;
			}
			else if ( (LA5_0=='f') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:183:10: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:183:19: 'false'
					{
					match("false"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:184:5: ( 'else' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:184:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:185:4: ( ( '0' .. '9' )+ )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:185:6: ( '0' .. '9' )+
			{
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:185:6: ( '0' .. '9' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:186:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:186:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:186:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "COLONS"
	public final void mCOLONS() throws RecognitionException {
		try {
			int _type = COLONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:187:8: ( ':' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:187:10: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLONS"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | WS | COMMENT | STRING | BOOLEAN | ELSE | INT | IDENT | COLONS )
		int alt8=30;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:10: T__12
				{
				mT__12(); 

				}
				break;
			case 2 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:16: T__13
				{
				mT__13(); 

				}
				break;
			case 3 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:22: T__14
				{
				mT__14(); 

				}
				break;
			case 4 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:28: T__15
				{
				mT__15(); 

				}
				break;
			case 5 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:34: T__16
				{
				mT__16(); 

				}
				break;
			case 6 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:40: T__17
				{
				mT__17(); 

				}
				break;
			case 7 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:46: T__18
				{
				mT__18(); 

				}
				break;
			case 8 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:52: T__19
				{
				mT__19(); 

				}
				break;
			case 9 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:58: T__20
				{
				mT__20(); 

				}
				break;
			case 10 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:64: T__21
				{
				mT__21(); 

				}
				break;
			case 11 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:70: T__22
				{
				mT__22(); 

				}
				break;
			case 12 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:76: T__23
				{
				mT__23(); 

				}
				break;
			case 13 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:82: T__24
				{
				mT__24(); 

				}
				break;
			case 14 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:88: T__25
				{
				mT__25(); 

				}
				break;
			case 15 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:94: T__26
				{
				mT__26(); 

				}
				break;
			case 16 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:100: T__27
				{
				mT__27(); 

				}
				break;
			case 17 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:106: T__28
				{
				mT__28(); 

				}
				break;
			case 18 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:112: T__29
				{
				mT__29(); 

				}
				break;
			case 19 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:118: T__30
				{
				mT__30(); 

				}
				break;
			case 20 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:124: T__31
				{
				mT__31(); 

				}
				break;
			case 21 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:130: T__32
				{
				mT__32(); 

				}
				break;
			case 22 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:136: T__33
				{
				mT__33(); 

				}
				break;
			case 23 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:142: WS
				{
				mWS(); 

				}
				break;
			case 24 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:145: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 25 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:153: STRING
				{
				mSTRING(); 

				}
				break;
			case 26 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:160: BOOLEAN
				{
				mBOOLEAN(); 

				}
				break;
			case 27 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:168: ELSE
				{
				mELSE(); 

				}
				break;
			case 28 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:173: INT
				{
				mINT(); 

				}
				break;
			case 29 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:177: IDENT
				{
				mIDENT(); 

				}
				break;
			case 30 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:183: COLONS
				{
				mCOLONS(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\33\6\uffff\1\35\1\37\1\uffff\1\41\4\30\5\uffff\2\30\13\uffff"+
		"\3\30\1\55\7\30\1\uffff\5\30\1\72\3\30\1\76\1\77\1\30\1\uffff\1\76\1\30"+
		"\1\102\2\uffff\2\30\1\uffff\1\105\1\106\2\uffff";
	static final String DFA8_eofS =
		"\107\uffff";
	static final String DFA8_minS =
		"\1\11\1\75\6\uffff\1\52\1\75\1\uffff\1\75\1\157\1\141\1\146\1\157\5\uffff"+
		"\1\162\1\154\13\uffff\1\157\1\162\1\154\1\60\1\164\1\156\1\165\1\163\1"+
		"\154\1\155\1\163\1\uffff\5\145\1\60\1\145\1\147\1\171\2\60\1\141\1\uffff"+
		"\1\60\1\145\1\60\2\uffff\1\156\1\162\1\uffff\2\60\2\uffff";
	static final String DFA8_maxS =
		"\1\175\1\75\6\uffff\1\57\1\75\1\uffff\1\75\2\157\1\156\1\157\5\uffff\1"+
		"\162\1\154\13\uffff\1\157\1\162\1\154\1\172\1\164\1\156\1\165\1\163\1"+
		"\154\1\155\1\163\1\uffff\5\145\1\172\1\145\1\147\1\171\2\172\1\141\1\uffff"+
		"\1\172\1\145\1\172\2\uffff\1\156\1\162\1\uffff\2\172\2\uffff";
	static final String DFA8_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\14\5\uffff\1\24\1\25\1\26"+
		"\1\27\1\31\2\uffff\1\34\1\35\1\36\1\2\1\1\1\30\1\11\1\13\1\12\1\16\1\15"+
		"\13\uffff\1\21\14\uffff\1\20\3\uffff\1\32\1\33\2\uffff\1\23\2\uffff\1"+
		"\17\1\22";
	static final String DFA8_specialS =
		"\107\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\23\2\uffff\1\23\22\uffff\1\23\1\1\1\24\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\27\1\31\1\uffff\1\11\1\12\1\13\2"+
			"\uffff\32\30\6\uffff\1\30\1\14\2\30\1\26\1\15\2\30\1\16\3\30\1\17\6\30"+
			"\1\25\6\30\1\20\1\21\1\22",
			"\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\34\4\uffff\1\34",
			"\1\36",
			"",
			"\1\40",
			"\1\42",
			"\1\44\15\uffff\1\43",
			"\1\45\7\uffff\1\46",
			"\1\47",
			"",
			"",
			"",
			"",
			"",
			"\1\50",
			"\1\51",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\52",
			"\1\53",
			"\1\54",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\73",
			"\1\74",
			"\1\75",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\100",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\101",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"\1\103",
			"\1\104",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | WS | COMMENT | STRING | BOOLEAN | ELSE | INT | IDENT | COLONS );";
		}
	}

}
