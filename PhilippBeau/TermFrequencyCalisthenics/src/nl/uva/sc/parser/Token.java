package nl.uva.sc.parser;

import nl.uva.sc.datatypes.Frequency;
import nl.uva.sc.datatypes.Word;

public class Token implements Comparable<Token> {

    private final Word mWord;

    private final Frequency mFrequency;

    public Token(final Word word, final Frequency frequency) {
        mWord = word;
        mFrequency = frequency;
    }

    public void addFrequency() {
        mFrequency.addFrequency();
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Token) {
            Frequency frequency = ((Token) o).mFrequency;
            boolean a = (mFrequency.compareTo(frequency) == 0);
            Word word = ((Token) o).mWord;
            boolean b = mWord.equals(word);
            return (a && b);
        }

        return this.equals(o);
    }

    @Override
    public int hashCode() {
        return mWord.hashCode();
    }

    @Override
    public int compareTo(final Token o) {
        Frequency frequency = o.mFrequency;
        return mFrequency.compareTo(frequency);
    }

    @Override
    public String toString() {
        return mWord + " - " + mFrequency;
    }
}