package ql.gui;

import java.io.IOException;

public class Main {
	public static void main(String [ ] args) throws IOException {
		FormGUI formBuilder = new FormGUI();
		formBuilder.showMenu();
//		formBuilder.showForm("form Box1HouseOwning {\n" +
//				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
//				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
//				"	hasBoughtHouse: \"Did you by a house in 2010?\" boolean(hasSoldHouse)\n" +
//				"	hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n" +
//				"	// this is a comment\n" +
//				"	if (hasSoldHouse) {\n" +
//				"		sellingPrice: \"Price the house was sold for:\" int\n" +
//				"		privateDebt: \"Private debts for the sold house:\" int\n" +
//				"		valueResidue: \"Value residue:\" int(privateDebt+1)\n" +
//				"	}\n" +
//				"	else {\n" +
//				"		soldWilling: \"When do you want to sell your house?\" string\n" +
//				"	}\n" +
//				"}\n");
		
//		formBuilder.showForm("form Box1HouseOwning {\n" +
//				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
//				"	hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n" +
//				"	hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n" +
//
//				"		sellingPrice: \"Price the house was sold for:\" int\n" +
//				"		privateDebt: \"Private debts for the sold house:\" int\n" +
//				"		valueResidue: \"Value residue:\" int(sellingPrice-privateDebt)\n" +
//				"	}\n" +
//				"}\n");
	}
}
