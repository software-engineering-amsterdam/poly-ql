package org.uva.sea.ql.render;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Visitor;
import org.uva.sea.ql.check.Error;
import org.uva.sea.ql.eval.Undefined;
import org.uva.sea.ql.eval.Value;

public class TypeToWidget implements Visitor<Widget, Boolean> {
	
	public static Widget typeToWidget(org.uva.sea.ql.ast.types.Type type, boolean editable) {
		Visitor<Widget, Boolean> v = new TypeToWidget();
		return type.accept(v, editable);
	}
	
	private TypeToWidget() {
	}

	@Override
	public Widget visit(Bool type, Boolean editable) {
		final JCheckBox cb = new JCheckBox();
		cb.setEnabled(editable);
		return new Widget(cb) {
			public void setValue(org.uva.sea.ql.eval.Value value) {
				cb.setSelected(((org.uva.sea.ql.eval.Bool)value).getValue());
			}
			
			@Override
			public Value getValue() {
				return new org.uva.sea.ql.eval.Bool(cb.isSelected());
			}

			@Override
			public void setHandler(final Handler handler) {
				cb.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						handler.handleEvent();
					}
				});
			}
		};
	}

	
	abstract class TextFieldWidget extends Widget {
		public TextFieldWidget(JTextField component) {
			super(component);
		}
		
		@Override
		public void setValue(org.uva.sea.ql.eval.Value value) {
			textField().setText(value.toString());
		}

		@Override
		public void setHandler(final Handler handler) {
			textField().addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					handler.handleEvent();
				}
				
				@Override
				public void focusGained(FocusEvent e) {
				}
			});
		}

		protected JTextField textField() {
			return (JTextField)getComponent();
		}
	}
	
	
//	private Widget textField(Boolean editable) {
//		final JTextField tf = new JTextField(20);
//		tf.setEditable(editable);
//		return new Widget(tf) {
//			public void setValue(org.uva.sea.ql.eval.Value value) {
//				tf.setText(((org.uva.sea.ql.eval.Value)value).getValue().toString());
//			}
//			
//			@Override
//			public Value getValue() {
//				return new org.uva.sea.ql.eval.Str(tf.getText());
//			}
//			
//	}
	
	@Override
	public Widget visit(Int type, Boolean editable) {
		final JTextField tf = new JTextField(20);
		tf.setEditable(editable);
		return new TextFieldWidget(tf) {
			@Override
			public Value getValue() {
				String txt = textField().getText();
				try {
					int n = Integer.parseInt(txt);
					return new org.uva.sea.ql.eval.Int(n);
				}
				catch (NumberFormatException e) {
					return Undefined.UNDEF;
				}
			}
		};
	}

	@Override
	public Widget visit(Money type, Boolean editable) {
		throw new UnsupportedOperationException("money is currenlty not implemented");
	}

	@Override
	public Widget visit(Str type, Boolean editable) {
		final JTextField tf = new JTextField(20);
		tf.setEditable(editable);
		return new TextFieldWidget(tf) {
			@Override
			public Value getValue() {
				return new org.uva.sea.ql.eval.Str(textField().getText());
			}
		};
	}

	@Override
	public Widget visit(Numeric type, Boolean editable) {
		throw new UnsupportedOperationException("no widgets for inferred generic types");
	}

	@Override
	public Widget visit(Error type, Boolean editable) {
		throw new UnsupportedOperationException("no widgets for error types");
	}

}
