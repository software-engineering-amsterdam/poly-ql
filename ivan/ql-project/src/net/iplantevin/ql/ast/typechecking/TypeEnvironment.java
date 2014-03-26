package net.iplantevin.ql.ast.typechecking;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.UndefinedType;
import net.iplantevin.ql.errors.TypeError;

import java.util.HashMap;
import java.util.Map;

/**
 * Type environment. Has a map of name->IDInfo and convenience methods.
 *
 * @author Ivan
 */
public class TypeEnvironment {
    private final Map<String, IDInfo> idTypeStore;

    public TypeEnvironment() {
        idTypeStore = new HashMap<String, IDInfo>();
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

    public TypeError declareIdentifier(ID identifier, Type type) {
        if (isDeclared(identifier)) {
            if (!getDeclaredType(identifier).equals(type)) {
                String message = "type mismatch on already declared identifier '" +
                        identifier.getName() + "' (declared at " +
                        getIdentifier(identifier).getDeclaredLineInfo() + ") !";
                TypeError typeError = new TypeError(
                        message,
                        identifier,
                        getDeclaredType(identifier),
                        type
                );
                return typeError;
            }
        } else {
            idTypeStore.put(identifier.getName(),
                    new IDInfo(identifier.getLineInfo(), type));
        }
        return null; // No exception.
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