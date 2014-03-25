package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.ITypeVisitor;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.UndefinedType;

import javax.swing.*;

/**
 * @author Ivan
 */
public class TypeToWidget implements ITypeVisitor<JComponent> {
    private final AbstractWidgetContainer container;

    private TypeToWidget(AbstractWidgetContainer container) {
        this.container = container;
    }

    public static JComponent makeWidget(Type type, AbstractWidgetContainer container) {
        TypeToWidget converter = new TypeToWidget(container);
        return type.accept(converter);
    }

    @Override
    public JComponent visit(BooleanType booleanType) {
        return new BoolWidget(container);
    }

    @Override
    public JComponent visit(IntegerType integerType) {
        return new IntWidget(container);
    }

    @Override
    public JComponent visit(StringType stringType) {
        return new StrWidget(container);
    }

    @Override
    public JComponent visit(UndefinedType undefinedType) {
        assert false : "UndefinedType is only defined for type checking and will" +
                "never be the type of a form question.";
        return null;
    }
}
