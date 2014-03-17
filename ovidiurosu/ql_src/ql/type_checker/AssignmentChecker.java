package ql.type_checker;

import java.util.Map.Entry;
import java.util.Set;

import ql.ast.expression.ExpressionIdsVisitor;
import ql.ast.expression.IExpression;
import ql.ast.expression.Id;
import ql.ast.statement.IAssignment;
import ql.error.TypeError;
import ql.error.Warning;

/**
 * @author orosu
 */
public class AssignmentChecker extends Checker
{
    private final IAssignment _assignment;

    public AssignmentChecker(TypeEnvironment typeEnvironment, IAssignment assignment)
    {
        this._typeEnvironment = typeEnvironment;
        this._assignment = assignment;
    }

    /**
     * Check if there are duplicate assignments (same Id) with different types
     */
    public void checkIdForDuplicates()
    {
        if (!this._typeEnvironment.hasType(this._assignment.getId()) ||
            this._typeEnvironment.getType(this._assignment.getId()).equals(this._assignment.getType())
        ) {
            // If the assignment is not found in the type environment -> skip
            // If the assignments have the same type -> skip
            return;
        }

        //ERROR This Id is already used by another assignment of a different type
        this._typeEnvironment.addError(
            new TypeError("The ID '" + this._assignment.getId() +
                "' is already used by another assignment of type '" +
                this._typeEnvironment.getType(this._assignment.getId()).toString() + "'!")
        );
    }

    /**
     * Check if there are duplicate labels
     */
    public void checkLabelForDuplicates()
    {
        for (Entry<String, IAssignment> assign: this._typeEnvironment.getAssignments().entrySet()) {
            if (!assign.getValue().getLabel().equals(this._assignment.getLabel()) ||
                assign.getValue().getId().equals(this._assignment.getId()))
            {
                // If the assignments have different labels -> skip
                // If the assignments have the same id -> skip
                continue;
            }

            //WARNING This label is already used by another assignment
            this._typeEnvironment.addError(
                new Warning("The label '" + this._assignment.getLabel() +
                    "' is already used by assignment with ID '" +
                    assign.getKey() + "'!")
            );
        }
    }

    /**
     * Check Cyclic dependencies e.g.
     *     x: "X?" boolean
     *     x: "X second?" boolean(x)
     */
    public void checkCyclicDependencies(IExpression expression)
    {
        Set<Id> ids = expression.accept(new ExpressionIdsVisitor());
        for (Id id: ids) {
            if (!id.getValue().equals(this._assignment.getId())) {
                continue;
            }

            //ERROR This id is also used in it's expression
            this._typeEnvironment.addError(
                new TypeError("The id of this assignment ('" + this._assignment.getId() +
                    "') is also used in it's expression! Cyclic Dependencies!")
            );
        }
    }

    //TODO Check Cyclic Dependencies like if (x) { y: "Y?" boolean } \n if (y) { x: "X?" boolean }
}
