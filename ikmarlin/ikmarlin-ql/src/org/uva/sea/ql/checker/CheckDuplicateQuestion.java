package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.exception.QLException;
import org.uva.sea.ql.checker.exception.error.DuplicateQuestion;
import org.uva.sea.ql.checker.exception.warning.DuplicateLabel;

public class CheckDuplicateQuestion {

	private Map<String, List<Type>> symbolTable;
	private List<QLException> errors;
	private List<QLException> warnings;

	public CheckDuplicateQuestion(Map<String, List<Type>> symbolTable) {
		this.symbolTable = symbolTable;
		errors = new ArrayList<QLException>();
		warnings = new ArrayList<QLException>();
	}

	public List<QLException> getDuplicates() {
		for (Map.Entry<String, List<Type>> entry : symbolTable.entrySet()) {
			String ident = entry.getKey();
			if (entry.getValue().size() > 1) {
				Set<String> uniqueTypes = new HashSet<String>();
				for (Type t : entry.getValue()) {
					uniqueTypes.add(t.toString());
				}
				if (uniqueTypes.size() > 1) {
					errors.add(new DuplicateQuestion(ident));
				} else {
					warnings.add(new DuplicateLabel(ident));
				}
			}
		}
		return errors;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<QLException> getErrors() {
		return errors;
	}

	public boolean hasWarnings() {
		return !warnings.isEmpty();
	}

	public List<QLException> getWarnings() {
		return warnings;
	}

}
