package net.iplantevin.ql.ast.astbuilder;

import net.iplantevin.ql.antlr.QLLexer;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.typechecking.ErrorManager;
import net.iplantevin.ql.ast.typechecking.TypeCheckerVisitor;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ivan
 */
public class ASTBuilder {
    public static void main(String[] args) throws IOException {
        String inputFile = "/Users/Ivan/Documents/Master SE/Software " +
                "Construction/poly-ql/ivan/ql-project/src/net/iplantevin/ql/questionnaires/";
//        inputFile += "form1.txt";
//        inputFile += "form2.txt";
        inputFile += "typeForm1.txt";

        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);

        ParseTree tree = parser.forms(); // parse

        ASTBuilderVisitor builder = new ASTBuilderVisitor();
        FormCollection formCollection;
        formCollection = builder.visitForms((QLParser.FormsContext) tree);

        // Type Checking:
        for (Form form : formCollection.getForms()) {
            TypeEnvironment idTypeStore = new TypeEnvironment();
            ErrorManager errorManager = new ErrorManager();
            TypeCheckerVisitor.checkForm(form, idTypeStore, errorManager);
            errorManager.printAllMessages();
        }
    }
}
