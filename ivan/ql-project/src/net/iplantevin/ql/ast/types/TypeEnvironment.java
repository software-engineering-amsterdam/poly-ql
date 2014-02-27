package net.iplantevin.ql.ast.types;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.errors.ErrorCollection;
import net.iplantevin.ql.errors.TypeError;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 20-02-14
 * Type environment. Has a map of ID->IDTuple and convenience methods.
 */
public class TypeEnvironment {
    // TODO: change map from ID to Type.
    private final HashMap<String, IDTuple> idTypeEnv;
    private final ErrorCollection errorCollection;

    public TypeEnvironment(ErrorCollection errorCollection) {
        idTypeEnv = new HashMap<String, IDTuple>();
        this.errorCollection = errorCollection;
    }

    public boolean isDeclared(ID identifier) {
        return idTypeEnv.containsKey(identifier.getName());
    }

    private IDTuple getIdentifier(ID identifier) {
        if (!isDeclared(identifier)) {
            return new IDTuple(null, new UndefinedType());
        }
        return idTypeEnv.get(identifier.getName());
    }

    public Type getDeclaredType(ID identifier) {
        return getIdentifier(identifier).type;
    }

    public void addIdentifier(ID identifier, Type type) {
        if (isDeclared(identifier)) {
            if (!getDeclaredType(identifier).equals(type)) {
                String message = "type mismatch on already declared identifier '" +
                        identifier.getName() + "' (declared at " +
                        getIdentifier(identifier).getDeclaredLineInfo() + ") !";
                TypeError typeException = new TypeError(
                        message,
                        identifier,
                        getDeclaredType(identifier),
                        type
                );
                errorCollection.addException(typeException);
            }
        } else {
            idTypeEnv.put(identifier.getName(), new IDTuple(identifier, type));
        }
    }
}

/**
 * Tuple-like helper class.
 */
class IDTuple {
    public final ID id;
    public final Type type;

    public IDTuple(ID id, Type type) {
        this.id = id;
        this.type = type;
    }

    public LineInfo getDeclaredLineInfo() {
        return id.getLineInfo();
    }
}