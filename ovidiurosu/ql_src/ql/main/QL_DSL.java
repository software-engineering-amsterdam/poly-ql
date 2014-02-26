package ql.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.ast.typechecker.TypeCheckerVisitor;
import ql.ast.visitor.BuildASTVisitor;
import ql.exc.IExc;
import antlr4_ql.QLLexer;
import antlr4_ql.QLParser;


/**
 * QL DSL Main
 * @author orosu
 */
public class QL_DSL
{
    /**
     * Private default construct -> prevent initialization
     */
    private QL_DSL()
    {
    }

    /**
     * Number of Forms -> used for exit
     */
    public static int numForms = 0;

    /**
     * Build the parse tree, visit it and build GUI elements (forms)
     * @param args
     */
    public static void main(String[] args)
    {
        try {
            // Get sample file input stream
            File file = new File(System.getProperty("user.dir") + "/src/QL.expr");
            FileInputStream fis = new FileInputStream(file);

            // create a CharStream that reads from file input stream
            ANTLRInputStream input = new ANTLRInputStream(fis);

            // create a lexer that feeds off of input CharStream
            QLLexer lexer = new QLLexer(input);

            // create a buffer of tokens pulled from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // create a parser that feeds off the tokens buffer
            QLParser parser = new QLParser(tokens);

            ParseTree tree = parser.init(); // begin parsing at init rule

            // print LISP-style tree
            System.out.println(tree.toStringTree(parser));

            // Build AST (Abstract Syntax Tree) -> Class Hierarchy
            BuildASTVisitor buildASTVisitor = new BuildASTVisitor();
            QuestionnaireList questionnaires =
                (QuestionnaireList) buildASTVisitor.visit(tree);

            // Visit the AST for type checking
            TypeCheckerVisitor typeCheckerVisitor;
            List<Questionnaire> checkedQuestionnaires = new ArrayList<Questionnaire>();
            for (Questionnaire questionnaire: questionnaires.getQuestionnaires()) {
                typeCheckerVisitor = new TypeCheckerVisitor(checkedQuestionnaires);
                questionnaire.accept(typeCheckerVisitor);

                // Loop through exceptions
                for (IExc exc: typeCheckerVisitor.getExcs()) {
                    exc.printStackTrace(new PrintStream(System.err));
                }
                checkedQuestionnaires.add(questionnaire);
            }

            //TODO Visit AST to build and display forms

        } catch (Exception exc) {
            // Print exception message
            System.err.println(exc.getMessage());
            exc.printStackTrace(new PrintStream(System.err));
        }
    }
}
