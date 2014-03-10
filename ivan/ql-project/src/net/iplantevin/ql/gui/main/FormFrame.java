package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
import net.iplantevin.ql.ast.expressions.operators.Div;
import net.iplantevin.ql.ast.expressions.operators.EQ;
import net.iplantevin.ql.ast.expressions.operators.GEQ;
import net.iplantevin.ql.ast.expressions.operators.GT;
import net.iplantevin.ql.ast.expressions.operators.LEQ;
import net.iplantevin.ql.ast.expressions.operators.LT;
import net.iplantevin.ql.ast.expressions.operators.Mul;
import net.iplantevin.ql.ast.expressions.operators.NEQ;
import net.iplantevin.ql.ast.expressions.operators.Neg;
import net.iplantevin.ql.ast.expressions.operators.Not;
import net.iplantevin.ql.ast.expressions.operators.Or;
import net.iplantevin.ql.ast.expressions.operators.Pos;
import net.iplantevin.ql.ast.expressions.operators.Sub;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.statements.Statement;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.visitors.IASTVisitor;
import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.evaluation.ValueStore;
import net.iplantevin.ql.gui.widgets.AbstractFormComponent;
import net.iplantevin.ql.gui.widgets.AbstractFormComponentDelegate;
import net.iplantevin.ql.gui.widgets.WidgetContainer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * A window for a single form. Builds itself by visiting a given Form.
 *
 * @author Ivan
 */
public class FormFrame extends JFrame implements IASTVisitor<AbstractFormComponent>,
        AbstractFormComponentDelegate {
    private final ValueStore values;
    private final EvaluationVisitor evaluator;
    private final JPanel formPanel;

    /**
     * Constructs a JFrame for a given Form.
     */
    public FormFrame(Form form) {
        values = new ValueStore();
        evaluator = new EvaluationVisitor(values);
        formPanel = new JPanel();

        initUI(form);
    }

    /**
     * Creates necessary panels and sets various settings on them and on the
     * FormFrame itself. Also disables horizontal scrolling.
     */
    private void initUI(Form form) {
        // JFrame settings.
        setTitle(form.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);

        // This disables horizontal scrolling (and sets a width of 850px).
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                setSize(new Dimension(850, getHeight()));
                super.componentResized(e);
            }

        });

        // Settings for panel that will hold all form questions.
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // Scrolling pane settings
        JScrollPane formScrollPane = new JScrollPane();
        formScrollPane.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
        formScrollPane.getViewport().add(formPanel);
        add(formScrollPane);

        // Starts the creation of questions
        form.accept(this);
        pack();
    }

    public Value evaluate(Expression expression) {
        return evaluator.evaluate(expression);
    }

    @Override
    public void subscribe(String identifier, AbstractFormComponent formComponent) {
        // Todo: implement.
    }

    @Override
    public void registerValueChange(String identifier, Value value) {
        // Todo: implement.
    }

    ////////////////////////////////////////////////////////////////////////////
    // Visitor methods.
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public AbstractFormComponent visit(FormCollection formCollection) {
        // Should not be needed.
        return null;
    }

    @Override
    public AbstractFormComponent visit(Form form) {
        form.getBody().accept(this);
        return null;
    }

    @Override
    public AbstractFormComponent visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public AbstractFormComponent visit(Computation computation) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(If ifStat) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(IfElse ifElse) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Question question) {
        WidgetContainer widget = new WidgetContainer(question, this);
        formPanel.add(widget);
        return null;
    }

    @Override
    public AbstractFormComponent visit(Par par) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Add add) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(And and) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Div div) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(EQ eq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(GEQ geq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(GT gt) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(LEQ leq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(LT lt) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Mul mul) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Neg neg) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(NEQ neq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Not not) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Or or) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Pos pos) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Sub sub) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Bool bool) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(ID id) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Int integer) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Str str) {
        return null;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                LineInfo lineInfo = new LineInfo(0, 0);
                List<Statement> statements = new ArrayList<Statement>();

                ID id1 = new ID("currentAge", lineInfo);
                Str label1 = new Str("What is your age?", lineInfo);
                Question question1 = new Question(id1, label1, new IntegerType(), lineInfo);
                statements.add(question1);

                ID id2 = new ID("lastName", lineInfo);
                Str label2 = new Str("What is your last name?", lineInfo);
                Question question2 = new Question(id2, label2, new StringType(), lineInfo);
                statements.add(question2);

                ID id3 = new ID("married", lineInfo);
                Str label3 = new Str("Are you married?", lineInfo);
                Question question3 = new Question(id3, label3, new BooleanType(), lineInfo);
                statements.add(question3);

                Block body = new Block(statements, lineInfo);

                FormFrame frame = new FormFrame(new Form("Test form", body, lineInfo));
                frame.setVisible(true);
            }
        });
    }
}
