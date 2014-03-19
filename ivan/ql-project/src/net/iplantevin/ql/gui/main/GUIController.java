package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.antlr.QLLexer;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.astbuilder.ASTBuilderVisitor;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.visitors.TypeCheckerVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Parses, type checks and runs gui for a given file.
 *
 * @author Ivan
 */
public class GUIController {
    private FormCollection forms;

    public GUIController(String inputFile) throws IOException {
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);

        ParseTree tree = parser.forms(); // Parse.

        ASTBuilderVisitor builder = new ASTBuilderVisitor();
        forms = builder.visitForms((QLParser.FormsContext) tree);
    }

    public boolean typeCheck() {
        boolean typeSafe = true;
        for (Form form : forms.getForms()) {
            TypeCheckerVisitor typeChecker = TypeCheckerVisitor.checkForm(form);
            typeChecker.printAllErrors();
            if (!typeChecker.isTypeSafe()) {
                typeSafe = false;
            }
        }
        return typeSafe;
    }

    public void runForms() {
        if (!typeCheck()) {
            // Todo: e.g. a dialog with type unsafe message.
            return;
        }

        for (final Form form : forms.getForms()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    FormFrame frame = FormFrameBuilder.build(form);
                    frame.setVisible(true);
                }
            });
        }
    }
}
