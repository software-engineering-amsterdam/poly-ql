package ql.ast.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ql.ast.ID;
import ql.ast.Questionnaire;
import ql.ast.expr.ParensExpr;
import ql.ast.literal.BOOLLiteral;
import ql.ast.literal.NUMLiteral;
import ql.ast.literal.STRINGLiteral;
import ql.ast.op.binary.BinaryOp;
import ql.ast.op.binary.arithmetic.ADD;
import ql.ast.op.binary.arithmetic.DIV;
import ql.ast.op.binary.arithmetic.MUL;
import ql.ast.op.binary.arithmetic.REM;
import ql.ast.op.binary.arithmetic.SUB;
import ql.ast.op.binary.conditional.LA;
import ql.ast.op.binary.conditional.LO;
import ql.ast.op.binary.equality.EQ;
import ql.ast.op.binary.equality.NEQ;
import ql.ast.op.binary.relational.GT;
import ql.ast.op.binary.relational.GTQ;
import ql.ast.op.binary.relational.LT;
import ql.ast.op.binary.relational.LTQ;
import ql.ast.op.unary.NOT;
import ql.ast.op.unary.UM;
import ql.ast.op.unary.UP;
import ql.ast.op.unary.UnaryOp;
import ql.ast.stat.Assign;
import ql.ast.stat.ComputAssign;
import ql.ast.stat.IAssign;
import ql.ast.stat.IStat;
import ql.ast.stat.IfStat;
import ql.ast.type.NULLType;
import ql.ast.type.NUMType;
import ql.ast.visitor.IElementVisitor;
import ql.exc.ErrorExc;
import ql.exc.IExc;

/**
 * Type Checker Visitor
 * @author orosu
 */
public class TypeCheckerVisitor implements IElementVisitor
{
    /**
     * List of Checked Questionnaires
     */
    private final List<Questionnaire> _checkedQuestionnaires;

    /**
     * Set of Exceptions
     */
    private final Set<IExc> _excs;

    /**
     * AST Assigns Map (ID: IAssign)
     */
    private final Map<String, IAssign> _assigns;

    /**
     * Constructor
     */
    public TypeCheckerVisitor()
    {
        this._assigns = new HashMap<String, IAssign>();
        this._excs = new HashSet<IExc>();
        this._checkedQuestionnaires = new ArrayList<Questionnaire>();
    }

    /**
     * Constructor with questionnaires
     */
    public TypeCheckerVisitor(List<Questionnaire> checkedQuestionnaires)
    {
        this._assigns = new HashMap<String, IAssign>();
        this._excs = new HashSet<IExc>();
        this._checkedQuestionnaires = checkedQuestionnaires;
    }

    /**
     * Get All Exceptions
     * @return the _excs
     */
    public Set<IExc> getExcs()
    {
        return _excs;
    }

    /**
     * Add Exception
     * @param exc
     */
    public void addExc(IExc exc)
    {
        this._excs.add(exc);
    }

    /**
     * Get All Assigns
     * @return the _assigns
     */
    public Map<String, IAssign> getAssigns()
    {
        return this._assigns;
    }

    /**
     * Get Assign By ID
     * @param id
     * @return
     */
    public IAssign getAssignById(String id)
    {
        return this._assigns.get(id);
    }

    /**
     * Get Checked Questionnaires
     * @return the _checkedQuestionnaires
     */
    public List<Questionnaire> getCheckedQuestionnaires()
    {
        return _checkedQuestionnaires;
    }

    @Override
    public void visit(Questionnaire questionnaire)
    {
        // Check if the ID of this questionnaire is unique
        QuestionnaireListChecker checker =
            new QuestionnaireListChecker(this, questionnaire);
        checker.checkIdForDuplicates();
    }

    @Override
    public void visit(Assign assign)
    {
        this._assignCheck(assign);

        this._assigns.put(assign.getId(), assign);
    }

    @Override
    public void visit(ComputAssign computAssign)
    {
        this._assignCheck(computAssign);

        // Visit Expression
        computAssign.getExpr().accept(this);

        // Check if the statement type is compatible with the expression type
        ExprChecker exprChecker = new ExprChecker(this, computAssign.getExpr());
        exprChecker.checkStatTypeCompatibility(computAssign.getStatType());

        this._assigns.put(computAssign.getId(), computAssign);
    }

    @Override
    public void visit(IfStat ifStat)
    {
        // Visit Expression
        ifStat.getExpr().accept(this);

        // Check if the statement type is compatible with the expression type
        ExprChecker checker = new ExprChecker(this, ifStat.getExpr());
        checker.checkStatTypeCompatibility(ifStat.getStatType());

        // Visit if statements
        for (IStat stat: ifStat.getIfStats()) {
            stat.accept(this);
        }

        // Visit else statements
        for (IStat stat: ifStat.getElseStats()) {
            stat.accept(this);
        }
    }

    @Override
    public void visit(ID id)
    {
        // If its type is NULL, get the type of the assignment with this ID
        if (!(id.getType() instanceof NULLType)) {
            return;
        }

        IAssign assign = this.getAssignById(id.getValue());
        if (assign != null) {
            // Get the type of the assignment with this ID
            id.setType(assign.getStatType().getType());
            return;
        }

        //ERROR The assignment with this ID is undefined
        this.addExc(
            new ErrorExc("The Assignment with ID '" + id.getValue() + "' is undefined!")
        );
    }

    @Override
    public void visit(ADD add)
    {
        this._binaryOpCheck(add);
    }

    @Override
    public void visit(DIV div)
    {
        this._binaryOpCheck(div);
    }

    @Override
    public void visit(MUL mul)
    {
        this._binaryOpCheck(mul);
    }

    @Override
    public void visit(REM rem)
    {
        this._binaryOpCheck(rem);
    }

    @Override
    public void visit(SUB sub)
    {
        this._binaryOpCheck(sub);
    }

    @Override
    public void visit(LA la)
    {
        this._binaryOpCheck(la);
    }

    @Override
    public void visit(LO lo)
    {
        this._binaryOpCheck(lo);
    }

    @Override
    public void visit(EQ eq)
    {
        this._binaryOpCheck(eq);
    }

    @Override
    public void visit(NEQ neq)
    {
        this._binaryOpCheck(neq);
    }

    @Override
    public void visit(GT gt)
    {
        this._binaryOpRelCheck(gt);
    }

    @Override
    public void visit(GTQ gtq)
    {
        this._binaryOpRelCheck(gtq);
    }

    @Override
    public void visit(LT lt)
    {
        this._binaryOpRelCheck(lt);
    }

    @Override
    public void visit(LTQ ltq)
    {
        this._binaryOpRelCheck(ltq);
    }

    @Override
    public void visit(NOT not)
    {
        this._unaryOpCheck(not);
    }

    @Override
    public void visit(UM um)
    {
        this._unaryOpCheck(um);
    }

    @Override
    public void visit(UP up)
    {
        this._unaryOpCheck(up);
    }

    @Override
    public void visit(BOOLLiteral boolLiteral)
    {
        // Do nothing!
    }

    @Override
    public void visit(NUMLiteral numLiteral)
    {
        // Do nothing!
    }

    @Override
    public void visit(STRINGLiteral stringLiteral)
    {
        // Do nothing!
    }

    @Override
    public void visit(ParensExpr parensExpr)
    {
        // Do nothing!
    }

    /**
     * Assignment Check
     * @param assign
     */
    private void _assignCheck(IAssign assign)
    {
        // Check if the ID or the label of this assignment is unique
        AssignChecker checker = new AssignChecker(this, assign);
        checker.checkIdForDuplicates();
        checker.checkLabelForDuplicates();
    }

    /**
     * Binary Operation Check
     * @param binaryOp
     */
    private void _binaryOpCheck(BinaryOp binaryOp)
    {
        // Visit Left and Right Expressions
        binaryOp.getLeftExpr().accept(this);
        binaryOp.getRightExpr().accept(this);

        // Check if the left subexpression type is compatible with the expression type
        ExprChecker leftChecker = new ExprChecker(this, binaryOp.getLeftExpr());
        leftChecker.checkTypeCompatibility(binaryOp.getType());

        // Check if the left subexpression type is compatible with the expression type
        ExprChecker rightChecker = new ExprChecker(this, binaryOp.getRightExpr());
        rightChecker.checkTypeCompatibility(binaryOp.getType());
    }

    /**
     * Binary Operation Relational Check
     * @param binaryOp
     */
    private void _binaryOpRelCheck(BinaryOp binaryOpRel)
    {
        // Visit Left and Right Expressions
        binaryOpRel.getLeftExpr().accept(this);
        binaryOpRel.getRightExpr().accept(this);

        // Check if the left subexpression type is compatible with the expression type
        ExprChecker leftChecker = new ExprChecker(this, binaryOpRel.getLeftExpr());
        leftChecker.checkTypeCompatibility(new NUMType());

        // Check if the left subexpression type is compatible with the expression type
        ExprChecker rightChecker = new ExprChecker(this, binaryOpRel.getRightExpr());
        rightChecker.checkTypeCompatibility(new NUMType());
    }

    /**
     * Unary Operation Check
     * @param binaryOp
     */
    private void _unaryOpCheck(UnaryOp unaryOp)
    {
        // Visit Expressions
        unaryOp.getExpr().accept(this);

        // Check if the expression type is compatible with the expression type
        ExprChecker checker = new ExprChecker(this, unaryOp.getExpr());
        checker.checkTypeCompatibility(unaryOp.getType());
    }
}
