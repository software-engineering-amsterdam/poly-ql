package nl.uva.polyql.model;

public interface VisibilityListener {

    /**
     * Called when a rule's visibility changed.
     * 
     * @param visible
     *            True iff the rule is now visible
     */
    public void onParentVisibilityUpdate(final boolean visible);
}
