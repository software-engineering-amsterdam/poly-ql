package org.uva.sea.ql.render;

import static org.uva.sea.ql.parser.antlr.FormParser.parse;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.parser.test.ParseError;

public class Main {

	public static void main(String[] args) throws ParseError {
		Form f = parse("form bla { \"Enter x\" x: int  \"Enter y\" y: int \"Sum = \" z: int (x + y) "
				+ " \"More? \" yes: bool " 
				+ " if (yes) { \"Enter name: \" name: str \"Enter age: \" age: int } "
				+ "}");
		//1. Create the frame.
		JFrame frame = new JFrame("FrameDemo");
		JPanel panel = Renderer.render(f, new HashMap<Ident,Value>());
		frame.getContentPane().add(panel);

		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();

		//5. Show it.
		frame.setVisible(true);

	}
	
}
