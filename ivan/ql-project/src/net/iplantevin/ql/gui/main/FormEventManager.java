package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.formcomponents.AbstractFormComponent;
import net.iplantevin.ql.gui.formcomponents.AbstractWidgetContainer;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * A FormEventManager manages subscription of (Abstract)FormComponents to events
 * on variables (identifiers) in the form. It also manages the queue of re-evaluations
 * that have to be performed, in a sequential way. This class uses antlr4's
 * "OrderedHashSet", Set implementation that maintains the order in which
 * elements were added.
 *
 * @author Ivan
 */
public class FormEventManager {
    private final Map<String, Set<AbstractFormComponent>> subscriptions;
    private final Executor executor;
    private final EvaluationVisitor evaluator;

    /**
     * Constructor that stores a reference to the evaluator used by the creator.
     * (The evaluator is needed to store updated values.)
     *
     * @param evaluator the EvaluationVisitor object to use.
     */
    public FormEventManager(EvaluationVisitor evaluator) {
        subscriptions = new HashMap<String, Set<AbstractFormComponent>>();
        executor = Executors.newSingleThreadExecutor();
        this.evaluator = evaluator;
    }

    /**
     * Subscribes given AbstractFormComponent to all identifiers it wants to
     * receive updates from.
     *
     * @param formComponent the AbstractFormComponent to subscribe.
     * @param ids           the set of identifiers the given component wants to be
     *                      subscribed to.
     */
    public void subscribe(AbstractFormComponent formComponent, Set<String> ids) {
        for (String identifier : ids) {
            subscribeComponentToIdentifier(formComponent, identifier);
        }
    }

    /**
     * Subscribes given component to given identifier. If there are no subscriptions
     * yet for this identifier, an entry in the subscriptions map is created.
     *
     * @param formComponent the component to subscribe.
     * @param identifier    the identifier the given component should be
     *                      subscribed to.
     */
    private void subscribeComponentToIdentifier(AbstractFormComponent formComponent,
                                                String identifier) {
        if (hasSubscriptionsForIdentifier(identifier)) {
            subscriptions.get(identifier).add(formComponent);
        } else {
            HashSet<AbstractFormComponent> subscribedComponents =
                    new OrderedHashSet<AbstractFormComponent>();
            subscribedComponents.add(formComponent);
            subscriptions.put(identifier, subscribedComponents);
        }
    }

    /**
     * Adds a (re-)evalution to the queue of the Executor as a Runnable. The
     * Runnable will send the reEvaluate() message to all AbstractFormComponents
     * subscribed to the given identifier. The updated value is furthermore
     * only put in the EvaluationVisitor when the Runnable is executed.
     *
     * @param source
     * @param value  the new value for given identifier.
     */
    public void scheduleEvaluation(final AbstractWidgetContainer source, final Value value) {
        executor.execute(new Runnable() {
            public void run() {
                String identifier = source.getIdentifier();
                if (hasSubscriptionsForIdentifier(identifier)) {
                    evaluator.storeValue(identifier, value);

                    for (AbstractFormComponent component : subscriptions.get(identifier)) {
                        reEvaluateComponent(component, source);
                    }
                }
            }
        });
    }

    private void reEvaluateComponent(AbstractFormComponent component,
                                     AbstractWidgetContainer source) {
        // Source must not trigger re-evaluation on itself.
        if (component == source) {
            return;
        }
        component.reEvaluate();
    }

    private boolean hasSubscriptionsForIdentifier(String identifier) {
        return subscriptions.containsKey(identifier);
    }
}
