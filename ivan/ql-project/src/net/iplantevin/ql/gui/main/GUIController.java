package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.antlr.QLLexer;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.astbuilder.ASTBuilderVisitor;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.typechecking.TypeCheckerVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses, type checks and runs gui for a given file.
 *
 * @author Ivan
 */
public class GUIController {
    private FormCollection forms;
    private final List<FormFrame> frames;

    public GUIController(String inputFile) throws IOException {
        forms = buildForms(inputFile);
        frames = new ArrayList<FormFrame>();
    }

    private FormCollection buildForms(String inputFile) throws IOException {
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);

        ParseTree tree = parser.forms(); // Parse.

        ASTBuilderVisitor builder = new ASTBuilderVisitor();
        return builder.visitForms((QLParser.FormsContext) tree);
    }

    public boolean typeCheck() {
        boolean typeSafe = true;
        for (Form form : forms.getForms()) {
            TypeCheckerVisitor typeChecker = TypeCheckerVisitor.checkForm(form);

            if (!typeChecker.isTypeSafe()) {
                typeSafe = false;
            }
            typeChecker.printAllMessages();
        }
        return typeSafe;
    }

    public void runForms() {
        if (!typeCheck()) {
            // Todo: e.g. a dialog with type unsafe message.
            return;
        }

        final GUIController controller = this;

        for (final Form form : forms.getForms()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    FormFrame frame = FormFrameBuilder.build(form, controller);
                    frames.add(frame);
                    frame.setVisible(true);
                }
            });
        }
    }

    public void closeForm(FormFrame frame) {
        frames.remove(frame);
        frame.dispose();
        if (frames.size() == 0) {
            System.exit(0);
        }
    }
}
