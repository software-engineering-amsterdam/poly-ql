package nl.uva.sc.datatypes;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class PrinterStop implements RecursivePrinter {

    @Override
    public void doSomeThing(final List<RecursivePrinter> r,
            final Entry<String, Integer> currentEntry,
            final Iterator<Entry<String, Integer>> iterator) {

    }
}
