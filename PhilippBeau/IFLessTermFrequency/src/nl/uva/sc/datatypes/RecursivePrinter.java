package nl.uva.sc.datatypes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface RecursivePrinter {

    public void print(final List<RecursivePrinter> r,
            final Map.Entry<String, Integer> currentEntry,
            final Iterator<Map.Entry<String, Integer>> iterator);
}
