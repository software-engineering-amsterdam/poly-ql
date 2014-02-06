// Output created by jacc on Thu Feb 06 17:12:17 CET 2014

package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.booleans.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.*;

class QLParser implements QLTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private org.uva.sea.ql.ast.ASTNode[] yysv;
    private org.uva.sea.ql.ast.ASTNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new org.uva.sea.ql.ast.ASTNode[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 144;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 32;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    yyn = yys11();
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case '(':
                            yyn = 34;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    yyn = yys13();
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    yyn = yys14();
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    switch (yytok) {
                        case ':':
                            yyn = 33;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    switch (yytok) {
                        case '{':
                            yyn = 52;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    switch (yytok) {
                        case STRING:
                            yyn = 53;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 58;
                            continue;
                        case INTEGER:
                            yyn = 59;
                            continue;
                        case MONEY:
                            yyn = 60;
                            continue;
                        case STRING:
                            yyn = 61;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                        case '}':
                            yyn = 63;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    switch (yytok) {
                        case '{':
                            yyn = 65;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys64();
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                        case '}':
                            yyn = 67;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    switch (yytok) {
                        case ELSE:
                            yyn = 68;
                            continue;
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    switch (yytok) {
                        case '{':
                            yyn = 69;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    switch (yytok) {
                        case IF:
                            yyn = 12;
                            continue;
                        case IDENTIFIER:
                            yyn = 31;
                            continue;
                        case '}':
                            yyn = 71;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                        case IDENTIFIER:
                        case IF:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 144:
                    return true;
                case 145:
                    yyerror("stack overflow");
                case 146:
                    return false;
                case 147:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        org.uva.sea.ql.ast.ASTNode[] newyysv = new org.uva.sea.ql.ast.ASTNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys0() {
        switch (yytok) {
            case FORM:
                return 10;
            case IDENTIFIER:
                return 11;
            case IF:
                return 12;
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
        }
        return 147;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ENDINPUT:
                return yyr4();
        }
        return 147;
    }

    private int yys11() {
        switch (yytok) {
            case ':':
                return 33;
            case ENDINPUT:
            case '>':
            case OR:
            case '/':
            case '-':
            case NEQ:
            case GEQ:
            case '<':
            case '+':
            case '*':
            case LEQ:
            case EQ:
            case AND:
                return yyr35();
        }
        return 147;
    }

    private int yys13() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr34();
    }

    private int yys14() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys15() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys16() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys17() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys18() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys19() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys20() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys21() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys22() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys23() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys24() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys25() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys26() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys27() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys28() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys29() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys34() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
        }
        return 147;
    }

    private int yys35() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr21();
    }

    private int yys36() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr35();
    }

    private int yys37() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ')':
                return 55;
        }
        return 147;
    }

    private int yys38() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr19();
    }

    private int yys39() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr20();
    }

    private int yys40() {
        switch (yytok) {
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case '}':
            case IDENTIFIER:
            case OR:
            case ')':
            case IF:
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 147;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case IDENTIFIER:
            case OR:
            case NEQ:
            case GEQ:
            case ')':
            case '<':
            case LEQ:
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 147;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case IDENTIFIER:
            case OR:
            case NEQ:
            case GEQ:
            case ')':
            case '<':
            case LEQ:
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 147;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case IDENTIFIER:
            case OR:
            case NEQ:
            case GEQ:
            case ')':
            case '<':
            case LEQ:
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 147;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case IDENTIFIER:
            case OR:
            case NEQ:
            case GEQ:
            case ')':
            case '<':
            case LEQ:
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 147;
    }

    private int yys45() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case '}':
            case IDENTIFIER:
            case OR:
            case ')':
            case ENDINPUT:
            case IF:
                return yyr33();
        }
        return 147;
    }

    private int yys46() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr22();
    }

    private int yys47() {
        switch (yytok) {
            case UNOT:
            case error:
            case UMIN:
            case UPLUS:
            case STRING:
            case '!':
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case ELSE:
            case MONEY:
            case FORM:
            case '(':
                return 147;
            case '*':
                return 24;
            case '/':
                return 27;
        }
        return yyr24();
    }

    private int yys48() {
        switch (yytok) {
            case UNOT:
            case error:
            case UMIN:
            case UPLUS:
            case STRING:
            case '!':
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case ELSE:
            case MONEY:
            case FORM:
            case '(':
                return 147;
            case '*':
                return 24;
            case '/':
                return 27;
        }
        return yyr25();
    }

    private int yys49() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr23();
    }

    private int yys50() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case IDENTIFIER:
            case OR:
            case NEQ:
            case GEQ:
            case ')':
            case '<':
            case LEQ:
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr29();
        }
        return 147;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '}':
            case '>':
            case IDENTIFIER:
            case OR:
            case NEQ:
            case GEQ:
            case ')':
            case '<':
            case LEQ:
            case IF:
            case EQ:
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 147;
    }

    private int yys54() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ')':
                return 62;
        }
        return 147;
    }

    private int yys55() {
        switch (yytok) {
            case STRING:
            case UNOT:
            case UMIN:
            case ELSE:
            case '(':
            case UPLUS:
            case BOOLEAN:
            case INTEGER:
            case '{':
            case ':':
            case MONEY:
            case FORM:
            case '!':
            case error:
                return 147;
        }
        return yyr36();
    }

    private int yys57() {
        switch (yytok) {
            case INTEGER:
                return 13;
            case '!':
                return 14;
            case '(':
                return 15;
            case '+':
                return 16;
            case '-':
                return 17;
            case IDENTIFIER:
                return 36;
            case ENDINPUT:
            case '}':
            case IF:
                return yyr12();
        }
        return 147;
    }

    private int yys58() {
        switch (yytok) {
            case '}':
            case IDENTIFIER:
            case '-':
            case '+':
            case '(':
            case '!':
            case INTEGER:
            case ENDINPUT:
            case IF:
                return yyr17();
        }
        return 147;
    }

    private int yys59() {
        switch (yytok) {
            case '}':
            case IDENTIFIER:
            case '-':
            case '+':
            case '(':
            case '!':
            case INTEGER:
            case ENDINPUT:
            case IF:
                return yyr16();
        }
        return 147;
    }

    private int yys60() {
        switch (yytok) {
            case '}':
            case IDENTIFIER:
            case '-':
            case '+':
            case '(':
            case '!':
            case INTEGER:
            case ENDINPUT:
            case IF:
                return yyr18();
        }
        return 147;
    }

    private int yys61() {
        switch (yytok) {
            case '}':
            case IDENTIFIER:
            case '-':
            case '+':
            case '(':
            case '!':
            case INTEGER:
            case ENDINPUT:
            case IF:
                return yyr15();
        }
        return 147;
    }

    private int yys64() {
        switch (yytok) {
            case AND:
                return 18;
            case EQ:
                return 19;
            case GEQ:
                return 20;
            case LEQ:
                return 21;
            case NEQ:
                return 22;
            case OR:
                return 23;
            case '*':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '/':
                return 27;
            case '<':
                return 28;
            case '>':
                return 29;
            case ENDINPUT:
            case '}':
            case IDENTIFIER:
            case IF:
                return yyr11();
        }
        return 147;
    }

    private int yyr1() { // top : astnode
        {result = ((ASTNode)yysv[yysp-1]);}
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr19() { // expr : '+' expr
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr20() { // expr : '-' expr
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr21() { // expr : '!' expr
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypexpr();
    }

    private int yyr22() { // expr : expr '*' expr
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr23() { // expr : expr '/' expr
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr24() { // expr : expr '+' expr
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr25() { // expr : expr '-' expr
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr26() { // expr : expr EQ expr
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr27() { // expr : expr NEQ expr
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr28() { // expr : expr '>' expr
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr29() { // expr : expr '<' expr
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr30() { // expr : expr GEQ expr
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr31() { // expr : expr LEQ expr
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr32() { // expr : expr AND expr
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr33() { // expr : expr OR expr
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr34() { // expr : INTEGER
        { yyrv = ((IntLiteral)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr35() { // expr : IDENTIFIER
        { yyrv = ((Identifier)yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr36() { // expr : '(' expr ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 34: return 54;
            case 29: return 51;
            case 28: return 50;
            case 27: return 49;
            case 26: return 48;
            case 25: return 47;
            case 24: return 46;
            case 23: return 45;
            case 22: return 44;
            case 21: return 43;
            case 20: return 42;
            case 19: return 41;
            case 18: return 40;
            case 17: return 39;
            case 16: return 38;
            case 15: return 37;
            case 14: return 35;
            case 0: return 2;
            default: return 64;
        }
    }

    private int yyr5() { // form : FORM IDENTIFIER '{' statements '}'
        {yyrv = new Form(((Identifier)yysv[yysp-4]),yysv[yysp-2]);}
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr13() { // ifThen : IF '(' expr ')' '{' statements '}'
        {yyrv = new If(((Expression)yysv[yysp-5]),yysv[yysp-2]);}
        yysv[yysp-=7] = yyrv;
        return 4;
    }

    private int yyr14() { // ifThenElse : IF '(' expr ')' '{' statements '}' ELSE '{' statements '}'
        {yyrv = new IfElse(((Expression)yysv[yysp-9]),yysv[yysp-6],yysv[yysp-2]);}
        yysv[yysp-=11] = yyrv;
        return 5;
    }

    private int yyr11() { // question : IDENTIFIER ':' STRING type expr
        {yyrv = new ExprQuestion(((Identifier)yysv[yysp-5]),yysv[yysp-4],((StringLiteral)yysv[yysp-3]),((Type)yysv[yysp-2]));}
        yysv[yysp-=5] = yyrv;
        return 6;
    }

    private int yyr12() { // question : IDENTIFIER ':' STRING type
        {yyrv = new Question(((Identifier)yysv[yysp-4]),yysv[yysp-3],((StringLiteral)yysv[yysp-2]));}
        yysv[yysp-=4] = yyrv;
        return 6;
    }

    private int yyr8() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr9() { // statement : ifThen
        yysp -= 1;
        return yypstatement();
    }

    private int yyr10() { // statement : ifThenElse
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 69: return 7;
            case 65: return 7;
            case 52: return 7;
            case 0: return 7;
            default: return 30;
        }
    }

    private int yyr6() { // statements : statements statement
        {yyrv = new QuestionSet(yysv[yysp-2],yysv[yysp-1]);}
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr7() { // statements : statement
        {yyrv = new QuestionSet(yysv[yysp-1]);}
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 65: return 66;
            case 52: return 56;
            case 0: return 8;
            default: return 70;
        }
    }

    private int yyr2() { // astnode : form
        yysp -= 1;
        return 9;
    }

    private int yyr3() { // astnode : statements
        yysp -= 1;
        return 9;
    }

    private int yyr4() { // astnode : expr
        yysp -= 1;
        return 9;
    }

    private int yyr15() { // type : STRING
        { yyrv = new StringType(); }
        yysv[yysp-=1] = yyrv;
        return 57;
    }

    private int yyr16() { // type : INTEGER
        { yyrv = new IntType(); }
        yysv[yysp-=1] = yyrv;
        return 57;
    }

    private int yyr17() { // type : BOOLEAN
        { yyrv = new BoolType(); }
        yysv[yysp-=1] = yyrv;
        return 57;
    }

    private int yyr18() { // type : MONEY
        { yyrv = new MoneyType(); }
        yysv[yysp-=1] = yyrv;
        return 57;
    }

    protected String[] yyerrmsgs = {
    };

private QLLexer lexer; 

private ASTNode result;

public ASTNode getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
