package net.iplantevin.ql.ast.astbuilder;

import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.typechecking.ErrorManager;
import net.iplantevin.ql.ast.typechecking.TypeCheckerVisitor;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;

import java.io.IOException;

/**
 * @author Ivan
 */
public class ASTBuilderDemo {

    public static void main(String[] args) throws IOException {
        String inputFile = "/Users/Ivan/Documents/Master SE/Software " +
                "Construction/poly-ql/ivan/ql-project/src/net/iplantevin/ql/questionnaires/";
//        inputFile += "form1.txt";
//        inputFile += "form2.txt";
        inputFile += "typeForm1.txt";

        ASTBuilder builder = new ASTBuilder(inputFile);
        FormCollection formCollection = builder.buildForms();

        // Type Checking:
        for (Form form : formCollection.getForms()) {
            TypeEnvironment idTypeStore = new TypeEnvironment();
            ErrorManager errorManager = new ErrorManager();
            TypeCheckerVisitor.checkForm(form, idTypeStore, errorManager);
            errorManager.printAllMessages();
        }
    }
}
