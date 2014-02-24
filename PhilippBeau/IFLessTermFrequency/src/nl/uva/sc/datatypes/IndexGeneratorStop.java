package nl.uva.sc.datatypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class IndexGeneratorStop implements RecursiveIndexGenerator {

    @Override
    public void generateIndex(final List<RecursiveIndexGenerator> r,
            final Iterator<String> wordIterator, final String currentWord,
            final List<String> allWords, final Map<String, Integer> index) {

        sort(new ArrayList<>(index.entrySet()));
    }

    private void sort(final ArrayList<Map.Entry<String, Integer>> toSort) {
        Collections.sort(toSort, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(final Entry<String, Integer> o1, final Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Print the result
        further(new ArrayList<RecursivePrinter>(Collections.nCopies(25, new Printer())),
                toSort.iterator());
    }

    private void further(final List<RecursivePrinter> recList,
            final Iterator<Map.Entry<String, Integer>> iterator) {

        recList.add(new PrinterStop());
        recList.remove(0).print(recList, iterator.next(), iterator);
    }
}
