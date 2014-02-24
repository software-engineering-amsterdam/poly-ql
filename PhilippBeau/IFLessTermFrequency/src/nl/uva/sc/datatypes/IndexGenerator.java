package nl.uva.sc.datatypes;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IndexGenerator implements RecursiveIndexGenerator {

    @Override
    public void generateIndex(final List<RecursiveIndexGenerator> r,
            final Iterator<String> wordIterator, final String currentWord,
            final List<String> allWords, final Map<String, Integer> index) {

        index.put(currentWord, Collections.frequency(allWords, currentWord));
        r.remove(0).generateIndex(r, wordIterator, wordIterator.next(), allWords, index);
    }
}
