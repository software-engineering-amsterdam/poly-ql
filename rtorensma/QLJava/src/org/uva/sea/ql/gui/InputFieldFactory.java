package org.uva.sea.ql.gui;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.Undefined;

public class InputFieldFactory implements TypeVisitor<InputField, Boolean> {
	public static InputField inputFieldForType(Type type, boolean editable) {
		return type.accept(new InputFieldFactory(), editable);
	}
	
	@Override
	public InputField visit(Bool type, Boolean arg) {
		JCheckBox checkbox = new JCheckBox();
		checkbox.setEnabled(arg);
		return new InputField(checkbox);
	}

	@Override
	public InputField visit(Int type, Boolean arg) {
		JTextField textfield = new JTextField(20);
		textfield.setEnabled(arg);
		return new InputField(textfield);
	}

	@Override
	public InputField visit(Str type, Boolean arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputField visit(Undefined type, Boolean arg) {
		// TODO Auto-generated method stub
		return null;
	}
}
