package net.iplantevin.ql.errors;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hashmap from exception types (Class objects) to exception objects.
 *
 * @author Ivan
 */
// TODO: rename exception > error.
public class ErrorCollection {
    private HashMap<Class<ASTError>, ArrayList<ASTError>> exceptionCollection;

    public ErrorCollection() {
        exceptionCollection = new HashMap<Class<ASTError>, ArrayList<ASTError>>();
    }

    public void addException(ASTError exception) {
        Class exceptionClass = exception.getClass();
        if (exceptionCollection.containsKey(exceptionClass)) {
            exceptionCollection.get(exceptionClass).add(exception);
        } else {
            ArrayList<ASTError> exceptionsList = new ArrayList<ASTError>();
            exceptionsList.add(exception);
            exceptionCollection.put(exceptionClass, exceptionsList);
        }
    }

    public void printAllExceptions() {
        for (Class exceptionClass : exceptionCollection.keySet()) {
            printExceptionClass(exceptionClass);
        }
    }

    private void printExceptionClass(Class exceptionClass) {
        if (!exceptionCollection.containsKey(exceptionClass)) {
            System.out.println("Notice: no errors of this type.");
            return;
        }
        System.out.println("###############################\n" +
                "EXCEPTIONS OF TYPE " + exceptionClass + ":\n");
        for (ASTError exception : exceptionCollection.get(exceptionClass)) {
            System.out.println(exception + "\n");
        }
    }
}
