package net.iplantevin.ql.ast.visitors;

import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;

/**
 * General interface for visiting the AST. Abstract classes can of course not
 * be visited.
 *
 * @author Ivan
 */
public interface IASTVisitor<T> extends IStatementVisitor<T>, IExpressionVisitor<T> {
    public T visit(FormCollection formCollection);

    public T visit(Form form);
}
