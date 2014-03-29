package ql.main;

import java.io.File;

import org.antlr.v4.runtime.tree.ParseTree;

import ql.ast.AstBuilderVisitor;
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
            ParseTree parseTree = parser.forms();

            AstBuilderVisitor astBuilderVisitor = new AstBuilderVisitor();
            QuestionnaireList questionnaireList = (QuestionnaireList) astBuilderVisitor.visit(parseTree);

            new TypeChecker(questionnaireList).check();
            new GuiRenderer(questionnaireList).render();
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    }
}
