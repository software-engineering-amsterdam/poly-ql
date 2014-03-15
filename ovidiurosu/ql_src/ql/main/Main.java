package ql.main;

import java.io.File;
import java.io.PrintStream;

import org.antlr.v4.runtime.tree.ParseTree;

import ql.ast.BuildASTVisitor;
import ql.ast.QuestionnaireList;
import ql.gui.renderer.GuiRenderer;
import ql.type_checker.TypeChecker;

/**
 * @author orosu
 */
public class Main
{
    /*
     * Private default construct -> prevent initialization
     */
    private Main()
    {
    }

    /*
     * Build the parse tree, visit it and build GUI elements (forms)
     */
    public static void main(String[] args)
    {
        try {
            Parser parser = new Parser();
            parser.buildQLParser(new File(System.getProperty("user.dir") +
                File.separator + "src" + File.separator + "QL.expr"));
            ParseTree parseTree = parser.buildParseTree();

            BuildASTVisitor buildASTVisitor = new BuildASTVisitor();
            QuestionnaireList questionnaires = (QuestionnaireList) buildASTVisitor.visit(parseTree);

            new TypeChecker(questionnaires).check();
            new GuiRenderer(questionnaires.getQuestionnaires()).render();
        } catch (Exception exc) {
            System.err.println(exc.getMessage());

            //TODO Remove print stack trace (only for development)
            exc.printStackTrace(new PrintStream(System.err));
        }
    }
}
