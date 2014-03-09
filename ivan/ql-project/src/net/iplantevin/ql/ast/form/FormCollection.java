package net.iplantevin.ql.ast.form;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Root of a Questionnaire Language AST (QLAST). Contains a list of Form objects.
 *
 * @author Ivan
 */
public class FormCollection extends ASTNode {
    private List<Form> forms;

    /**
     * Create new FormCollection with given list of Form objects.
     *
     * @param forms list of Form objects.
     */
    public FormCollection(List<Form> forms, LineInfo lineInfo) {
        // TODO: error handling.
        super(lineInfo);
        this.forms = forms;
    }

    /**
     * Create new FormCollection with given form.
     *
     * @param form a Form.
     */
    public FormCollection(Form form, LineInfo lineInfo) {
        super(lineInfo);
        forms = new ArrayList<Form>();
        forms.add(form);
    }

    /**
     * Get all forms in this collection.
     *
     * @return list of Form objects.
     */
    public List<Form> getForms() {
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
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
