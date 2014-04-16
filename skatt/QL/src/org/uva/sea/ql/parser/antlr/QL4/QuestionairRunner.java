package org.uva.sea.ql.parser.antlr.QL4;

/**
 * Creates a questionair object and runs it
 * @author Sammie Katt
 */
public class QuestionairRunner {

	public static void main(String[] args) {
		System.out.print("Running questionair... ");
		
		new Questionair();
		//new Questionair("test/conditionTest");
		System.out.println("Done!");
	}
}