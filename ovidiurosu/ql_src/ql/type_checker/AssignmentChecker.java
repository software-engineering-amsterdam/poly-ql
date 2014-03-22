package ql.type_checker;

import java.util.Iterator;
import java.util.Map.Entry;

import ql.ast.expression.IExpression;
import ql.ast.expression.Id;
import ql.ast.expression.IdSet;
import ql.ast.expression_evaluator.ExpressionIdSetBuilderVisitor;
import ql.ast.statement.IAssignment;
import ql.error.ErrorList;
import ql.error.TypeError;
import ql.error.Warning;

/**
 * @author orosu
 */
public class AssignmentChecker extends Checker
{
    private final IAssignment _assignment;

    public AssignmentChecker(TypeEnvironment typeEnvironment, ErrorList errorList,
        IAssignment assignment)
    {
        super(typeEnvironment, errorList);
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
        this._errorList.add(
            new TypeError("The ID '" + this._assignment.getId() +
                "' is already used by another assignment with a different type " +
                this._typeEnvironment.getType(this._assignment.getId()).toString() + "!")
        );
    }

    /**
     * Check if there are duplicate labels
     */
    public void checkLabelForDuplicates()
    {
        Iterator<Entry<String, IAssignment>> iterator = this._typeEnvironment.getAssignmentsIterator();
        while (iterator.hasNext()) {
            Entry<String, IAssignment> assignment = iterator.next();
            if (!assignment.getValue().getLabel().equals(this._assignment.getLabel()) ||
                assignment.getValue().getId().equals(this._assignment.getId()))
            {
                // If the assignments have different labels -> skip
                // If the assignments have the same id -> skip
                continue;
            }

            //WARNING This label is already used by another assignment
            this._errorList.add(
                new Warning("The label '" + this._assignment.getLabel() +
                    "' is already used by assignment with ID '" +
                    assignment.getKey() + "'!")
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
        IdSet idSet = expression.accept(new ExpressionIdSetBuilderVisitor());
        Iterator<Id> iterator = idSet.iterator();
        while(iterator.hasNext()) {
            if (!iterator.next().getValue().equals(this._assignment.getId())) {
                continue;
            }

            //ERROR This id is also used in it's expression
            this._errorList.add(
                new TypeError("The id of this assignment ('" + this._assignment.getId() +
                    "') is also used in it's expression! Cyclic Dependencies!")
            );
        }
    }

    //TODO maybe Check Cyclic Dependencies like if (x) { y: "Y?" boolean } \n if (y) { x: "X?" boolean }
}
