package org.uva.sea.ql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Error;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.CyclicStmtChecker;
import org.uva.sea.ql.checker.StmtChecker;
import org.uva.sea.ql.checker.SymbolCollector;

public class QL {
	
	public static void main(String[] args){
		String src = getSrc();
		System.out.println(src);
		Compiler compiler = new Compiler();
		Form form = compiler.compile(src);
		if(compiler.hasErrors()){
			for (String e : compiler.getAllErrors()){
				System.err.println(e);
			}
		}else{
			System.out.println("no errors");
			//Check Semantic
			List<Error> errors = new ArrayList<Error>();
			HashMap<String, Type> symbolTable = getSymbolTable(form);
			
			//Type check conditions and variables
			errors.addAll(getTypeErrors(form, symbolTable));
			
			//Check for Cyclic Dependencies
			errors.addAll(getCyclicDependencies(form));
			
			//Interpret
			if(errors.isEmpty()){
				System.out.println("INTERPRET");
			}else{
				//Output errors
				for(Error err : errors){
					System.err.println(err);
				}
			}
		}
	}
	
	private static HashMap<String, Type> getSymbolTable(Form form){
		SymbolCollector sc = new SymbolCollector();
		HashMap<String, Type> symbolTable = sc.populateTable(form);
		return symbolTable;
	}
	
	private static List<Error> getTypeErrors(Form form, HashMap<String, Type> symbolTable){
		StmtChecker stmtChecker = new StmtChecker(symbolTable);
		stmtChecker.typeCheck(form);
		return stmtChecker.getErrors();
	}
	
	private static List<Error> getCyclicDependencies(Form form){
		CyclicStmtChecker csc = new CyclicStmtChecker();
		csc.cyclicCheck(form);
		return csc.getErrors();
	}

	private static String getSrc(){
		String src = "form Box1HouseOwning { \n";
		src += "\thasSoldHouse:\"Did you sell a house in 2010?\" boolean \n";
		src += "\thasBoughtHouse: \"Did you buy a house in 2010?\" boolean \n";
		src += "\thasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n";
		src += "\tif (hasSoldHouse) {\n";
		src += "\t\tsellingPrice: \"Price the house was sold for:\" integer \n";
		src += "\t\tprivateDebt: \"Private debts for the sold house:\" integer \n";
		src += "\t\tvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) \n";
		src += "\t}\n ";
		src += "\tif (hasBoughtHouse) {\n";
		src += "\t\tsellingPrice: \"Price the house was sold for:\" integer \n";
		src += "\t\tprivateDebt: \"Private debts for the sold house:\" integer \n";
		src += "\t\tvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) \n";
		src += "\t}\n ";
		src += "}";
		return src;
	}
}
