package nl.uva.sc.datatypes;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Printer implements RecursivePrinter {

    @Override
    public void print(final List<RecursivePrinter> r,
            final Entry<String, Integer> currentEntry,
            final Iterator<Entry<String, Integer>> iterator) {

        System.out.println(currentEntry.getKey() + " - " + currentEntry.getValue());
        r.remove(0).print(r, iterator.next(), iterator);
    }
}
