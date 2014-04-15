package test;

import expr.Ident;
import gui.render.Renderer;
import gui.render.State;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import typecheck.Typecheck;
import antlr4.QLLexer;
import antlr4.QLParser;
import ast.ASTNode;
import ast.errormsg.Error;
import ast.form.Form;
import ast.form.Question;
import ast.form.StatementList;

public class TestRenderer extends JFrame {

	private static final long serialVersionUID = 1L;
	StatementList statement;
	Renderer renderer;
	JComponent jcomp = null;

	public TestRenderer() throws FileNotFoundException, IOException {

		Form form = getinput();
		renderer = new Renderer(new State(), form);
		statement = form.getStatements();

		for (int i = 0; i < statement.getList().size(); i++) {
			if (statement.getList().get(i).getClass() == Question.class) {
	
				Question node = (Question) statement.getList().get(i);
				jcomp = renderer.visit(node);
				setLayout(new GridBagLayout () );
				GridBagConstraints c= new GridBagConstraints();
				c.gridx=0;
				c.gridy=1;
				add(jcomp,c);
			}
			
			
		}

		setTitle("Housing");
		setSize(1000, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				TestRenderer r;
				try {
					r = new TestRenderer();
					r.setVisible(true);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});
	}

	private Form getinput() throws FileNotFoundException, IOException {

		File infile = new File(
				"C:\\Users\\nisha\\workspace\\Nisha\\src\\test1.ql");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(
				infile));
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ASTNode tree = parser.forms().result;
		Map<Ident, ast.type.Type> mapvalue = new HashMap<Ident, ast.type.Type>();
		Error errors= new Error();
		Typecheck t = new Typecheck(mapvalue, errors);
		boolean result = t.checkId(tree, mapvalue, errors);
		System.out.println("result is " + result);
		if (result)
			return (Form) tree;
		else
			System.out.println(t.get_errorList());
		return null;

	}

}