package org.uva.sea.ql;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.uva.sea.ql.typechecker.TypeChecker;
import org.uva.sea.ql.parser.jacc.ParseException;

public class Main {

	private static final String INPUTFILE = "C:\\Users\\Cindy\\Documents\\Github\\poly-ql\\cindyberg\\QLJava\\src\\org\\uva\\sea\\ql\\DSLForm.txt";


	public static void main(String [] args) throws FileNotFoundException, ParseException{
		runDSL();
	}

	public static void runDSL() throws FileNotFoundException, ParseException{
		Scanner input =  new Scanner(new File(INPUTFILE));
		String DSLFORM = "" ;
		while(input.hasNextLine()){

			String line = input.nextLine();
			DSLFORM = DSLFORM + '\n' + line;

		}
		input.close();

		TypeChecker checkDSL = new TypeChecker();
		checkDSL.checkDSL(DSLFORM);
	}

}