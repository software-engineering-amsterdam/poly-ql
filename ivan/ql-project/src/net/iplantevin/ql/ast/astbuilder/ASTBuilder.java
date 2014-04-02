package net.iplantevin.ql.ast.astbuilder;

import net.iplantevin.ql.antlr.QLLexer;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.typechecking.ErrorManager;
import net.iplantevin.ql.ast.typechecking.TypeCheckerVisitor;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ivan
 */
public class ASTBuilder {
    private final QLParser parser;

    public ASTBuilder(String filePath) throws IOException {
        assert filePath != null: "filePath cannot be null!";
        InputStream stream = new FileInputStream(filePath);
        ANTLRInputStream input = new ANTLRInputStream(stream);
        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new QLParser(tokens);
    }

    public FormCollection buildForms() {
        ParseTree tree = parser.forms();
        return (FormCollection) buildNodeFromTree(tree);
    }

    public ASTNode buildNodeFromTree(ParseTree tree) {
        ASTBuilderVisitor builder = new ASTBuilderVisitor();
        return tree.accept(builder);
    }

    public QLParser getParser() {
        return parser;
    }
}
