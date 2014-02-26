// $ANTLR 3.5.1 C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g 2014-02-24 19:14:15

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
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
	public static final int BOOLEAN=4;
	public static final int COLONS=5;
	public static final int COMMENT=6;
	public static final int IDENT=7;
	public static final int INT=8;
	public static final int MONEY=9;
	public static final int WS=10;

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

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:7:7: ( '!' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:7:9: '!'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:8:7: ( '!=' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:8:9: '!='
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:9:7: ( '\"' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:9:9: '\"'
			{
			match('\"'); 
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:10:7: ( '&&' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:10:9: '&&'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:11:7: ( '(' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:11:9: '('
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:12:7: ( ')' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:12:9: ')'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:13:7: ( '*' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:13:9: '*'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:14:7: ( '+' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:14:9: '+'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:15:7: ( '-' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:15:9: '-'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:16:7: ( '/' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:16:9: '/'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:17:7: ( '<' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:17:9: '<'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:18:7: ( '<=' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:18:9: '<='
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:19:7: ( '==' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:19:9: '=='
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:20:7: ( '>' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:20:9: '>'
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:21:7: ( '>=' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:21:9: '>='
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:22:7: ( 'form' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:22:9: 'form'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:23:7: ( 'if' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:23:9: 'if'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:24:7: ( '{' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:24:9: '{'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:25:7: ( '||' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:25:9: '||'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:26:7: ( '}' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:26:9: '}'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:27:7: ( '“' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:27:9: '“'
			{
			match('\u201C'); 
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:28:7: ( '”' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:28:9: '”'
			{
			match('\u201D'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:108:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:108:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:111:14: ( '/*' ( . )* '*/' | '//' ( . )* '\\n' )
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
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:111:16: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:111:21: ( . )*
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
							// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:111:21: .
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
					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:112:16: '//' ( . )* '\\n'
					{
					match("//"); 

					// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:112:21: ( . )*
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
							// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:112:21: .
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

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:114:8: ( 'boolean' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:114:10: 'boolean'
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
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "MONEY"
	public final void mMONEY() throws RecognitionException {
		try {
			int _type = MONEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:115:6: ( 'money' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:115:8: 'money'
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
	// $ANTLR end "MONEY"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:116:4: ( ( '0' .. '9' )+ )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:116:6: ( '0' .. '9' )+
			{
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:116:6: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
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
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:117:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:117:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:117:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
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
					break loop5;
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
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:118:8: ( ':' )
			// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:118:10: ':'
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
		// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | COMMENT | BOOLEAN | MONEY | INT | IDENT | COLONS )
		int alt6=29;
		switch ( input.LA(1) ) {
		case '!':
			{
			int LA6_1 = input.LA(2);
			if ( (LA6_1=='=') ) {
				alt6=2;
			}

			else {
				alt6=1;
			}

			}
			break;
		case '\"':
			{
			alt6=3;
			}
			break;
		case '&':
			{
			alt6=4;
			}
			break;
		case '(':
			{
			alt6=5;
			}
			break;
		case ')':
			{
			alt6=6;
			}
			break;
		case '*':
			{
			alt6=7;
			}
			break;
		case '+':
			{
			alt6=8;
			}
			break;
		case '-':
			{
			alt6=9;
			}
			break;
		case '/':
			{
			int LA6_9 = input.LA(2);
			if ( (LA6_9=='*'||LA6_9=='/') ) {
				alt6=24;
			}

			else {
				alt6=10;
			}

			}
			break;
		case '<':
			{
			int LA6_10 = input.LA(2);
			if ( (LA6_10=='=') ) {
				alt6=12;
			}

			else {
				alt6=11;
			}

			}
			break;
		case '=':
			{
			alt6=13;
			}
			break;
		case '>':
			{
			int LA6_12 = input.LA(2);
			if ( (LA6_12=='=') ) {
				alt6=15;
			}

			else {
				alt6=14;
			}

			}
			break;
		case 'f':
			{
			int LA6_13 = input.LA(2);
			if ( (LA6_13=='o') ) {
				int LA6_34 = input.LA(3);
				if ( (LA6_34=='r') ) {
					int LA6_38 = input.LA(4);
					if ( (LA6_38=='m') ) {
						int LA6_42 = input.LA(5);
						if ( ((LA6_42 >= '0' && LA6_42 <= '9')||(LA6_42 >= 'A' && LA6_42 <= 'Z')||LA6_42=='_'||(LA6_42 >= 'a' && LA6_42 <= 'z')) ) {
							alt6=28;
						}

						else {
							alt6=16;
						}

					}

					else {
						alt6=28;
					}

				}

				else {
					alt6=28;
				}

			}

			else {
				alt6=28;
			}

			}
			break;
		case 'i':
			{
			int LA6_14 = input.LA(2);
			if ( (LA6_14=='f') ) {
				int LA6_35 = input.LA(3);
				if ( ((LA6_35 >= '0' && LA6_35 <= '9')||(LA6_35 >= 'A' && LA6_35 <= 'Z')||LA6_35=='_'||(LA6_35 >= 'a' && LA6_35 <= 'z')) ) {
					alt6=28;
				}

				else {
					alt6=17;
				}

			}

			else {
				alt6=28;
			}

			}
			break;
		case '{':
			{
			alt6=18;
			}
			break;
		case '|':
			{
			alt6=19;
			}
			break;
		case '}':
			{
			alt6=20;
			}
			break;
		case '\u201C':
			{
			alt6=21;
			}
			break;
		case '\u201D':
			{
			alt6=22;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt6=23;
			}
			break;
		case 'b':
			{
			int LA6_21 = input.LA(2);
			if ( (LA6_21=='o') ) {
				int LA6_36 = input.LA(3);
				if ( (LA6_36=='o') ) {
					int LA6_40 = input.LA(4);
					if ( (LA6_40=='l') ) {
						int LA6_43 = input.LA(5);
						if ( (LA6_43=='e') ) {
							int LA6_46 = input.LA(6);
							if ( (LA6_46=='a') ) {
								int LA6_48 = input.LA(7);
								if ( (LA6_48=='n') ) {
									int LA6_50 = input.LA(8);
									if ( ((LA6_50 >= '0' && LA6_50 <= '9')||(LA6_50 >= 'A' && LA6_50 <= 'Z')||LA6_50=='_'||(LA6_50 >= 'a' && LA6_50 <= 'z')) ) {
										alt6=28;
									}

									else {
										alt6=25;
									}

								}

								else {
									alt6=28;
								}

							}

							else {
								alt6=28;
							}

						}

						else {
							alt6=28;
						}

					}

					else {
						alt6=28;
					}

				}

				else {
					alt6=28;
				}

			}

			else {
				alt6=28;
			}

			}
			break;
		case 'm':
			{
			int LA6_22 = input.LA(2);
			if ( (LA6_22=='o') ) {
				int LA6_37 = input.LA(3);
				if ( (LA6_37=='n') ) {
					int LA6_41 = input.LA(4);
					if ( (LA6_41=='e') ) {
						int LA6_44 = input.LA(5);
						if ( (LA6_44=='y') ) {
							int LA6_47 = input.LA(6);
							if ( ((LA6_47 >= '0' && LA6_47 <= '9')||(LA6_47 >= 'A' && LA6_47 <= 'Z')||LA6_47=='_'||(LA6_47 >= 'a' && LA6_47 <= 'z')) ) {
								alt6=28;
							}

							else {
								alt6=26;
							}

						}

						else {
							alt6=28;
						}

					}

					else {
						alt6=28;
					}

				}

				else {
					alt6=28;
				}

			}

			else {
				alt6=28;
			}

			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=27;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'c':
		case 'd':
		case 'e':
		case 'g':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt6=28;
			}
			break;
		case ':':
			{
			alt6=29;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:10: T__11
				{
				mT__11(); 

				}
				break;
			case 2 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:16: T__12
				{
				mT__12(); 

				}
				break;
			case 3 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:22: T__13
				{
				mT__13(); 

				}
				break;
			case 4 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:28: T__14
				{
				mT__14(); 

				}
				break;
			case 5 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:34: T__15
				{
				mT__15(); 

				}
				break;
			case 6 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:40: T__16
				{
				mT__16(); 

				}
				break;
			case 7 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:46: T__17
				{
				mT__17(); 

				}
				break;
			case 8 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:52: T__18
				{
				mT__18(); 

				}
				break;
			case 9 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:58: T__19
				{
				mT__19(); 

				}
				break;
			case 10 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:64: T__20
				{
				mT__20(); 

				}
				break;
			case 11 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:70: T__21
				{
				mT__21(); 

				}
				break;
			case 12 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:76: T__22
				{
				mT__22(); 

				}
				break;
			case 13 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:82: T__23
				{
				mT__23(); 

				}
				break;
			case 14 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:88: T__24
				{
				mT__24(); 

				}
				break;
			case 15 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:94: T__25
				{
				mT__25(); 

				}
				break;
			case 16 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:100: T__26
				{
				mT__26(); 

				}
				break;
			case 17 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:106: T__27
				{
				mT__27(); 

				}
				break;
			case 18 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:112: T__28
				{
				mT__28(); 

				}
				break;
			case 19 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:118: T__29
				{
				mT__29(); 

				}
				break;
			case 20 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:124: T__30
				{
				mT__30(); 

				}
				break;
			case 21 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:130: T__31
				{
				mT__31(); 

				}
				break;
			case 22 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:136: T__32
				{
				mT__32(); 

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
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:153: BOOLEAN
				{
				mBOOLEAN(); 

				}
				break;
			case 26 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:161: MONEY
				{
				mMONEY(); 

				}
				break;
			case 27 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:167: INT
				{
				mINT(); 

				}
				break;
			case 28 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:171: IDENT
				{
				mIDENT(); 

				}
				break;
			case 29 :
				// C:\\Users\\George\\Desktop\\Software Construction\\poly-ql\\GeorgePachitariu\\ANTLR-First\\src\\parser\\QL.g:1:177: COLONS
				{
				mCOLONS(); 

				}
				break;

		}
	}



}
