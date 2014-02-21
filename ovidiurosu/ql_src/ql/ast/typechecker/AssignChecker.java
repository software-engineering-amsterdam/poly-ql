package ql.ast.typechecker;

import java.util.Map.Entry;

import ql.ast.stat.IAssign;
import ql.exc.ErrorExc;
import ql.exc.WarningExc;

/**
 * Assign Checker
 * @author orosu
 */
public class AssignChecker implements IChecker
{
    /**
     * AST Type Checker Visitor
     */
    private final TypeCheckerVisitor _visitor;

    /**
     * Assign
     */
    private final IAssign _assign;

    /**
     * Constructor
     */
    public AssignChecker(TypeCheckerVisitor visitor, IAssign assign)
    {
        this._visitor = visitor;
        this._assign = assign;
    }

    /**
     * Check if there are duplicate assignments (same ID) with different types
     */
    public void checkIdForDuplicates()
    {
        IAssign assign = this._visitor.getAssignById(this._assign.getId());
        if (assign == null ||
            assign.getStatType().toStr().equals(this._assign.getStatType().toStr())
        ) {
            return;
        }

        //ERROR This ID is already used by another assignment of different type
        this._visitor.addExc(
            new ErrorExc("This Assignment with ID '" + this._assign.getId() +
                "' and statement type '" + this._assign.getStatType().toStr() +
                "' is already used by another assignment of a different " +
                "statement type ('" + assign.getStatType().toStr() + "')!")
        );
    }

    /**
     * Check if there are duplicate labels
     */
    public void checkLabelForDuplicates()
    {
        for (Entry<String, IAssign> assign: this._visitor.getAssigns().entrySet()) {
            if (!assign.getValue().getLabel().equals(this._assign.getLabel())) {
                continue;
            }

            //WARNING This label is already used by another assignment
            this._visitor.addExc(
                new WarningExc("The label '" + this._assign.getLabel() +
                    "' is already used by assignment with ID '" +
                    assign.getKey() + "'!")
            );
        }
    }
}
