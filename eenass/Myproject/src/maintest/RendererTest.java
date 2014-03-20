package maintest;

import gui.render.Renderer;
import gui.render.State;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import typecheck.ErrorList;
import typecheck.SymbolTable;
import typecheck.TypeChecker;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.statement.Form;

public class RendererTest extends JFrame {

	private static final long serialVersionUID = 1L;

	public RendererTest() throws FileNotFoundException, IOException{
		Renderer r = new Renderer(new State());
		Form form = get_inputForm();
		JComponent jc = r.render(form);
		add(jc);
		pack();
		setTitle(form.getId().getIdentName());
		setSize(450, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
	}
	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			 @Override
			 public void run() {
				 RendererTest r;
				try {
					r = new RendererTest();
					 r.setVisible(true);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			 }
		 });
	 }
	 
	 public static Form get_inputForm() throws FileNotFoundException, IOException{
		 File in = new File("C:\\Users\\E. Butrus\\Dropbox\\MASTER\\SoftwareCon\\poly-ql\\eenass\\Myproject\\src\\maintest\\test.txt");
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(in));
			QLangLexer lexer = new QLangLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			QLangParser parser = new QLangParser(tokens);
			ASTNode tree = parser.form().result;
					
			SymbolTable symb = new SymbolTable();
			ErrorList errors= new ErrorList();
			TypeChecker checker = new TypeChecker(symb, errors);
			boolean result = checker.check_symb(tree, symb, errors);
			System.out.println("result is " + result);
			if(result) return (Form) tree;
			else System.out.println(checker.get_errorList());
			return null;
		 
	 }
}
