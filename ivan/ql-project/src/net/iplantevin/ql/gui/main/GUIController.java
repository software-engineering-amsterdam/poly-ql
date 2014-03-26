package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.antlr.QLLexer;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.astbuilder.ASTBuilder;
import net.iplantevin.ql.ast.astbuilder.ASTBuilderVisitor;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.typechecking.ErrorManager;
import net.iplantevin.ql.ast.typechecking.TypeCheckerVisitor;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        ASTBuilder builder = new ASTBuilder(inputFile);
        return builder.buildForms();
    }

    public boolean typeCheck() {
        Boolean typeSafe = true;
        for (Form form : forms.getForms()) {
            if (!formIsValid(form)) {
                typeSafe = false;
            }
        }
        return typeSafe;
    }

    private boolean formIsValid(Form form) {
        TypeEnvironment idTypeStore = new TypeEnvironment();
        ErrorManager errorManager = new ErrorManager();
        TypeCheckerVisitor.checkForm(form, idTypeStore, errorManager);
        errorManager.printAllMessages();

        if (errorManager.hasErrors()) {
            return false;
        }
        return true;
    }

    public void runForms() {
        if (!typeCheck()) {
            showNotice("The forms are not type safe! Check your console output.");
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

    private void showNotice(String notice) {
        JFrame noticeFrame = new JFrame("Notice");
        noticeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel noticeLabel = new JLabel(notice);
        noticeLabel.setBorder(new EmptyBorder(15,15,15,15));
        noticeFrame.add(noticeLabel);
        noticeFrame.pack();
        noticeFrame.setLocationRelativeTo(null);
        noticeFrame.setVisible(true);
    }
}
