package org.uva.sea.ql;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.uva.sea.ql.typechecker.TypeChecker;

public class Main {
	
	public static void main(String [] args) throws FileNotFoundException
	{
		runDSL();
	}
	
	public static void runDSL() throws FileNotFoundException{
		Scanner input =  new Scanner(new File(""
				+ "C:\\Users\\Cindy\\Documents\\Github\\poly-ql\\"
				+ "cindyberg\\QLJava\\src\\org\\uva\\sea\\ql\\DSLForm.txt"));
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