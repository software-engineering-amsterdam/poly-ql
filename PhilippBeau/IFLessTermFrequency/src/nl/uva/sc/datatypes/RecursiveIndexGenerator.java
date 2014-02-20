package nl.uva.sc.datatypes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface RecursiveIndexGenerator {

    public void doSomeThing(List<RecursiveIndexGenerator> r, Iterator<String> wordIterator,
            final String currentWord, List<String> allWords, Map<String, Integer> index);
}
