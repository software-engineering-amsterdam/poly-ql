package net.iplantevin.ql.ast.types;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.errors.ErrorCollection;
import net.iplantevin.ql.errors.TypeError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan
 *         Type environment. Has a map of name->IDInfo and convenience methods.
 */
public class TypeEnvironment {
    private final Map<String, IDInfo> idTypeStore;
    private final ErrorCollection errors;

    public TypeEnvironment(ErrorCollection errors) {
        idTypeStore = new HashMap<String, IDInfo>();
        this.errors = errors;
    }

    public boolean isDeclared(ID identifier) {
        return idTypeStore.containsKey(identifier.getName());
    }

    private IDInfo getIdentifier(ID identifier) {
        if (!isDeclared(identifier)) {
            return new IDInfo(null, new UndefinedType());
        }
        return idTypeStore.get(identifier.getName());
    }

    public Type getDeclaredType(ID identifier) {
        return getIdentifier(identifier).getDeclaredType();
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
                errors.addException(typeException);
            }
        } else {
            idTypeStore.put(identifier.getName(),
                    new IDInfo(identifier.getLineInfo(), type));
        }
    }
}

/**
 * Tuple-like helper class.
 */
class IDInfo {
    private final LineInfo declaredLineInfo;
    private final Type declaredType;

    public IDInfo(LineInfo lineInfo, Type type) {
        declaredLineInfo = lineInfo;
        declaredType = type;
    }

    public LineInfo getDeclaredLineInfo() {
        return declaredLineInfo;
    }

    public Type getDeclaredType() {
        return declaredType;
    }
}