package org.uva.sea.ql.checker;

import java.util.List;

import org.uva.sea.ql.checker.exception.QLException;

public abstract class ExceptionGUI {
	
	protected List<QLException> exceptions;
	
	public ExceptionGUI(List<QLException> exceptions){
		this.exceptions = exceptions;
	}

	public abstract void show();

}