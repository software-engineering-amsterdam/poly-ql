package ql.type_checker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ql.ast.Questionnaire;
import ql.ast.statement.IAssignment;
import ql.ast.type.Type;
import ql.error.IError;

/**
 * @author orosu
 */
public class TypeEnvironment
{
    private final List<Questionnaire> _checkedQuestionnaires;
    private final Set<IError> _errors;

    /*
     * AST Assignments Map (id: assignment)
     *     We don't store only the types because we also need the labels
     *     for checkLabelForDuplicates
     */
    private final Map<String, IAssignment> _assignments;

    public TypeEnvironment(List<Questionnaire> checkedQuestionnaires)
    {
        this._checkedQuestionnaires = checkedQuestionnaires;
        this._assignments = new HashMap<String, IAssignment>();
        this._errors = new HashSet<IError>();
    }

    public List<Questionnaire> getCheckedQuestionnaires()
    {
        return _checkedQuestionnaires;
    }

    public void addAssign(String id, IAssignment assignment)
    {
        this._assignments.put(id, assignment);
    }

    public Map<String, IAssignment> getAssignments()
    {
        return this._assignments;
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

    public Set<IError> getErrors()
    {
        return _errors;
    }

    public void addError(IError error)
    {
        this._errors.add(error);
    }
}
