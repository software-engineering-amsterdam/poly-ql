package org.uva.sea.ql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.CheckCyclicDepency;
import org.uva.sea.ql.checker.CheckDuplicateQuestion;
import org.uva.sea.ql.checker.CheckExpressions;
import org.uva.sea.ql.checker.CheckUndefinedQuestion;
import org.uva.sea.ql.checker.CheckUndefinedVariable;
import org.uva.sea.ql.checker.SymbolCollector;

public class QL {

	public static void main(String[] args) {
		String src = getSrc();
		System.out.println(src);
		Compiler compiler = new Compiler();
		Form form = compiler.compile(src);
		if (compiler.hasErrors()) {
			for (String e : compiler.getAllErrors()) {
				System.err.println(e);
			}
		} else {
			// Check Semantic
			List<String> errors = new ArrayList<String>();

			SymbolCollector sc = new SymbolCollector();
			Map<String, List<Type>> duplicatesSymbolTable = sc.getSymbolTable(form);

			Map<String, Type> symbolTable = new HashMap<String, Type>();
			CheckDuplicateQuestion dqdt = new CheckDuplicateQuestion(duplicatesSymbolTable);
			if (dqdt.hasErrors()) {
				errors.addAll(dqdt.getErrors());
			} else {
				symbolTable = sc.getSingleTypeSymbolsTable(duplicatesSymbolTable);
			}

			CheckUndefinedQuestion cuq = new CheckUndefinedQuestion(form, symbolTable);
			errors.addAll(cuq.getUndefinedQuestions());

			CheckUndefinedVariable cuv = new CheckUndefinedVariable(form,symbolTable);
			errors.addAll(cuv.getUndefinedVariables());
			
			CheckExpressions ce = new CheckExpressions(form, symbolTable);
			errors.addAll(ce.getTypeErrors());
			
			CheckCyclicDepency ccd = new CheckCyclicDepency(form);
			errors.addAll(ccd.getCyclicDependencies());
			
			for (String msg : errors) {
				System.err.println(msg);
			}
		}
	}

	private static String getSrc() {
		String src = "form Box1HouseOwning { \n";
		src += "\thasSoldHouse:\"Did you sell a house in 2010?\" boolean \n";
		src += "\thasBoughtHouse: \"Did you buy a house in 2010?\" boolean \n";
		src += "\thasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n";
		src += "\tif (hasSoldHous) {\n";
		src += "\t\tsellingPrice: \"Price the house was sold for:\" integer \n";
		src += "\t\tprivateDebt: \"Private debts for the sold house:\" integer \n";
		src += "\t\tvalueResidue: \"Value residue:\" money(sellingPrice1 - privateDebt) \n";
		src += "\t}\n ";
		src += "\tif (sellinPrice > privateDebt) {\n";
		src += "\t\tsellingPrice: \"Price the house was sold for:\" integer \n";
		src += "\t\tprivateDebt: \"Private debts for the sold house:\" integer \n";
		src += "\t\tvalueResidue: \"Value residue:\" money(valueResidue - privateDebt) \n";
		src += "\t}\n ";
		src += "}";
		return src;
	}
}
