package nl.uva.sc.datatypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Stop implements Recursive {

    @Override
    public List<Map.Entry<String, Integer>> doSomeThing(final List<Recursive> r,
            final Iterator<String> wordIterator, final String currentWord,
            final List<String> allWords, final Map<String, Integer> index) {

        return sort(new ArrayList<>(index.entrySet()));
    }

    private List<Map.Entry<String, Integer>> sort(final ArrayList<Map.Entry<String, Integer>> toSort) {
        Collections.sort(toSort, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(final Entry<String, Integer> o1, final Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return toSort;
    }
}
