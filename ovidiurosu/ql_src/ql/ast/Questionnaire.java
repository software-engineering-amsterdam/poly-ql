package ql.ast;

import java.util.List;

import ql.ast.stat.IStat;
import ql.ast.visitor.IElement;
import ql.ast.visitor.IElementVisitor;

/**
 * QL Questionnaire
 * @author orosu
 */
public class Questionnaire implements IElement
{
    /**
     * ID
     */
    private final String _id;

    /**
     * Statements
     */
    private final List<IStat> _stats;

    /**
     * Constructor
     */
    public Questionnaire(String id, List<IStat> stats)
    {
        this._id = id;
        this._stats = stats;
    }

    /**
     * @return the _id
     */
    public String getId()
    {
        return _id;
    }

    /**
     * @return the _stats
     */
    public List<IStat> getStats()
    {
        return _stats;
    }

    @Override
    public void accept(IElementVisitor visitor)
    {
        for(IElement stat: this._stats) {
            stat.accept(visitor);
        }

        visitor.visit(this);
    }
}
