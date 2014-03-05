package ql.ast;

import ql.ast.statement.StatementAssignmentInterface;

/**
 * Check assignments for validity.
 */
public class ValidityAssignment implements ValidityInterface {
	private TypeVisitor visitor;
	private StatementAssignmentInterface assignment;
	
	/* Constructor */
	public ValidityAssignment(TypeVisitor visitor, StatementAssignmentInterface assignment) { 
		this.visitor    = visitor;
		this.assignment = assignment;
	}
	
	/* Check if there are any duplicate question titles */
	public void checkDuplicateTitles() {
		StatementAssignmentInterface assignment = 
			this.visitor.getQuestionAssignmentByTitle(this.assignment.getID());

		/* Not found? Not a duplicate. */
		if(assignment == null) {
			return;
		}
		
		/* Equal type? Fine. */
		if(assignment.getType().toStr().equals(this.assignment.getType().toStr())) { 
			return;
		}
		
		// TODO: Add error to exception list.
	}	
	
	/* Check if there are any duplicate question contents */
	public void checkDuplicateContents() {
		// ....
	}
}