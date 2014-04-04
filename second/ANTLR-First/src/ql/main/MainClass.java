package ql.main;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.runtime.RecognitionException;

import ql.ast.node.syntactic.Form;
import ql.questionaire.Parser;
import ql.questionaire.Questionaire;

public class MainClass {

	private static String readFile(String filePath) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(filePath));
			return Charset.defaultCharset().decode(ByteBuffer.wrap(encoded)).toString();
		} catch (IOException e) {
			System.out.println("Erors occured during the opening and the reading of the file");
		}
		return null;
	}

	public static void main(String[] args) {
		String s = readFile(args[0]);

		try {
			Form tree = Parser.parse(s);
			Questionaire.run(tree);	
		} catch (RecognitionException e) {
			ErrorWindow.displayMessage("Error during parsing");				
		} catch (ASTCheckerError e) {			
			ErrorWindow.displayMessage(e.getMessage());
		}	
	}
}
