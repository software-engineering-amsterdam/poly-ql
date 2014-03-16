package nl.uva.polyql.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import nl.uva.polyql.ast.IfStatement;
import nl.uva.polyql.ast.Rule;
import nl.uva.polyql.ast.VisibilityListener;

public class IfStatementView implements VisibilityListener {

    private final JPanel mPanel;

    public IfStatementView(final IfStatement ifStatement) {
        mPanel = new JPanel();
        mPanel.setLayout(new GridBagLayout());

        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.gridx = 0;

        for (final Rule rule : ifStatement.getChildRules()) {
            mPanel.add(rule.getView(), constraints);
        }

    }

    public Component getComponent() {
        return mPanel;
    }

    @Override
    public void onParentVisibilityUpdate(final boolean visible) {
        mPanel.setVisible(visible);
    }

}