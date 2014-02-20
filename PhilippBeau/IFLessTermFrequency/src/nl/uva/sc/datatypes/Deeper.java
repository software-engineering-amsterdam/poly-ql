package nl.uva.sc.datatypes;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Deeper implements Recursive {

    @Override
    public List<Map.Entry<String, Integer>> doSomeThing(final List<Recursive> r,
            final Iterator<String> wordIterator, final String currentWord,
            final List<String> allWords, final Map<String, Integer> index) {

        if (currentWord.length() > 1)
            index.put(currentWord, Collections.frequency(allWords, currentWord));
        return r.remove(0).doSomeThing(r, wordIterator, wordIterator.next(), allWords, index);
    }
}
