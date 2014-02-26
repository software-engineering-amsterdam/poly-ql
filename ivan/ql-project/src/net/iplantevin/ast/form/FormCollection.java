package net.iplantevin.ast.form;

import net.iplantevin.ast.QLASTNode;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 19-02-14
 * Root of a Questionnaire Language AST (QLAST). Contains a list of Form objects.
 */
public class FormCollection extends QLASTNode {
    private ArrayList<Form> forms;

    /**
     * Create new FormCollection with given list of Form objects.
     *
     * @param forms list of Form objects.
     */
    public FormCollection(ArrayList<Form> forms, ParserRuleContext ctx) {
        // TODO: error handling.
        super(ctx);
        this.forms = forms;
    }

    /**
     * Create new FormCollection with given form.
     *
     * @param form a Form.
     */
    public FormCollection(Form form, ParserRuleContext ctx) {
        super(ctx);
        forms = new ArrayList<Form>();
        forms.add(form);
    }

    /**
     * Get all forms in this collection.
     *
     * @return list of Form objects.
     */
    public ArrayList<Form> getForms() {
        return forms;
    }

    /**
     * Get a specific form.
     *
     * @param index index of form to retrieve.
     * @return a form.
     */
    public Form getFormAtIndex(int index) {
        // TODO: catch index error.
        return forms.get(index);
    }

    @Override
    public String toString() {
        String formCollection = "";
        for (Form form : forms) {
            formCollection += form.toString() + "\n";
        }
        return formCollection;
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
