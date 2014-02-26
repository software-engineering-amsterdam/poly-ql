package net.iplantevin.ast.astbuilder;

import net.iplantevin.antlr.QLLexer;
import net.iplantevin.antlr.QLParser;
import net.iplantevin.ast.form.Form;
import net.iplantevin.ast.form.FormCollection;
import net.iplantevin.ast.visitors.typechecker.TypeCheckerVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ivan
 */
public class QLASTBuilder {
    public static void main(String[] args) throws IOException {
        String inputFile = "/Users/Ivan/Documents/Master SE/Software " +
                "Construction/poly-ql/ivan/ql-project/src/net.iplantevin.ql.questionnaires/";
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
        //System.out.println(tree.toStringTree(parser));

        QLASTBuilderVisitor builder = new QLASTBuilderVisitor();
        FormCollection formCollection;
        formCollection = builder.visitForms((QLParser.FormsContext) tree);
        System.out.println(formCollection);

        // Type Checking:
        for (Form form : formCollection.getForms()) {
            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
            typeChecker.visit(form);
            typeChecker.getExceptionCollection().printAllExceptions();
        }
    }
}
