package net.iplantevin.exceptions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hashmap from exception types (Class objects) to exception objects.
 *
 * @author Ivan
 */
public class ExceptionCollection {
    private HashMap<Class<QLException>, ArrayList<QLException>> exceptionCollection;

    public ExceptionCollection() {
        exceptionCollection = new HashMap<Class<QLException>, ArrayList<QLException>>();
    }

    public void addException(QLException exception) {
        Class exceptionClass = exception.getClass();
        if (exceptionCollection.containsKey(exceptionClass)) {
            exceptionCollection.get(exceptionClass).add(exception);
        } else {
            ArrayList<QLException> exceptionsList = new ArrayList<QLException>();
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
            System.out.println("Notice: no exceptions of this type.");
            return;
        }
        System.out.println("###############################\n" +
                "EXCEPTIONS OF TYPE " + exceptionClass + ":\n");
        for (QLException exception : exceptionCollection.get(exceptionClass)) {
            System.out.println(exception + "\n");
        }
    }
}
