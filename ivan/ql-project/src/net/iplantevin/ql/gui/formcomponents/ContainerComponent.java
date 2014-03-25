package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.UndefinedVal;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A form component with vertical box layout settings. Main purpose is to provide
 * the ability to change the active state of itself and the other components
 * added to it. This is for example necessary for Block statements.
 *
 * @author Ivan
 */
public class ContainerComponent extends AbstractFormComponent {
    private final List<AbstractFormComponent> components;

    /**
     * Constructs a new ContainerComponent for the given FormFrame.
     */
    public ContainerComponent(FormFrame formFrame) {
        super(formFrame);
        components = new ArrayList<AbstractFormComponent>();
        initUI();
    }

    /**
     * Applies vertical box layout.
     */
    public void initUI() {
        setAlignmentY(TOP_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Adds given AbstractFormComponent both as a JPanel to itself and as an
     * AbstractFormComponent to the components list.
     *
     * @param component component to add.
     */
    public void addOne(AbstractFormComponent component) {
        components.add(component);
        add(component);
    }

    /**
     * ContainerComponents don't have interactive elements and don' subscribe to
     * events, therefore not needed.
     */
    @Override
    public void reEvaluate() {
    }

    /**
     * ContainerComponents don't have an associated value.
     */
    @Override
    public void initValue() {
    }

    /**
     * Sets its own activity and that of all its AbstractFormComponents.
     *
     * @param active whether this component and its contained components should
     *               be active or not.
     */
    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        for (AbstractFormComponent component : components) {
            component.setActive(active);
        }
    }

    @Override
    public Value getValue() {
        return new UndefinedVal();
    }
}
