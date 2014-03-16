package nl.uva.polyql.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import nl.uva.polyql.ast.IfStatement;
import nl.uva.polyql.ast.Rule;

public class IfStatementView implements IfStatement.SatisfactionListener {

    private final JPanel mPanel;

    /**
     * Constructs a new view for the if statement and adds all its children to it.
     * 
     * @param ifStatement
     *            The if-statement to create a view for
     */
    public IfStatementView(final IfStatement ifStatement) {
        mPanel = new JPanel();
        mPanel.setLayout(new GridBagLayout());

        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.gridx = 0;

        for (final Rule rule : ifStatement.getRules()) {
            mPanel.add(rule.getView(), constraints);
        }

    }

    public JComponent getComponent() {
        return mPanel;
    }

    @Override
    public void onSatisfactionUpdate(final IfStatement ifStatement) {
        mPanel.setVisible(ifStatement.isSatisfied());
    }

}