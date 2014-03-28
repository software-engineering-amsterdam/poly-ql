package ql.type_checker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ql.ast.statement.IAssignment;
import ql.ast.type.Type;

/**
 * @author orosu
 */
public class TypeEnvironment
{
    /*
     * AST Assignments Map (id: assignment)
     *     We don't store only the types because we also need the labels
     *     for checkLabelForDuplicates
     */
    private final Map<String, IAssignment> _assignments;

    public TypeEnvironment()
    {
        this._assignments = new HashMap<String, IAssignment>();
    }

    public void addAssign(String id, IAssignment assignment)
    {
        this._assignments.put(id, assignment);
    }

    public Iterator<Entry<String, IAssignment>> getAssignmentsIterator()
    {
        return this._assignments.entrySet().iterator();
    }

    public boolean hasType(String id)
    {
        return this._assignments.containsKey(id);
    }

    public Type getType(String id)
    {
        if (!this.hasType(id)) {
            assert false: "Before calling getType, you should always call hasType";
        }

        return this._assignments.get(id).getType();
    }
}
