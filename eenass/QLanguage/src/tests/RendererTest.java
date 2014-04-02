package tests;

import gui.TypeCheckedForm;
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
import typecheck.StatementTypeChecker;
import typecheck.SymbolTable;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.statement.Form;

public class RendererTest extends JFrame {

	private static final long serialVersionUID = 1L;

	public RendererTest() throws Exception{
		Renderer r = new Renderer(new State());
		TypeCheckedForm checkedForm = getInputForm();
		try{
			JComponent jc = r.render(checkedForm.getForm());
			add(jc);
			pack();
			setTitle(checkedForm.getForm().getId().getIdentName());
			setSize(500, 600);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE); 
		}
		catch(Exception e){
			throw new Exception("Type checker found errors in the form \n"+ checkedForm.getErrors());
		}
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeLater(new Runnable() {
			RendererTest r = new RendererTest();
				@Override
				public void run() {
					r.setVisible(true);					
				}			
			});
		} catch (Exception e) {
			e.printStackTrace();
		}	
	 }
	 
	public static TypeCheckedForm getInputForm() throws FileNotFoundException, IOException{
		ASTNode tree = getParseTree();
		SymbolTable symbolTable = new SymbolTable();
		ErrorList errors= new ErrorList();
		StatementTypeChecker checker = new StatementTypeChecker(symbolTable, errors);
		boolean result = ((Form) tree).accept(checker);
		return new TypeCheckedForm((Form) tree, result, checker.get_errorList());
	}
	
	public static ASTNode getParseTree() throws FileNotFoundException, IOException{
		File in = new File("..\\QLanguage\\src\\tests\\test.txt");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(in));
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.init().result;
		return tree;
	}
	
}
