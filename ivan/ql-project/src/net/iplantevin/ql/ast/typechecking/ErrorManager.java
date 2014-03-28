package net.iplantevin.ql.ast.typechecking;

import net.iplantevin.ql.errors.ASTError;
import net.iplantevin.ql.errors.ASTWarning;

import java.util.ArrayList;
import java.util.List;

public class ErrorManager {
    private final List<ASTError> errors;
    private final List<ASTWarning> warnings;

    public ErrorManager() {
        errors = new ArrayList<ASTError>();
        warnings = new ArrayList<ASTWarning>();
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void addError(ASTError error) {
        errors.add(error);
    }

    public void addWarning(ASTWarning warning) {
        warnings.add(warning);
    }

    public void printWarnings() {
        if (!warnings.isEmpty()) {
            System.out.println("###############\n## Warnings  ##\n###############");

            for (ASTWarning warning : warnings) {
                System.out.println(warning);
            }
        }
    }

    public void printErrors() {
        if (!errors.isEmpty()) {
            System.out.println("###############\n## Errors    ##\n###############");

            for (ASTError error : errors) {
                System.out.println(error);
            }
        }
    }

    public void printAllMessages() {
        printWarnings();
        printErrors();
    }
}