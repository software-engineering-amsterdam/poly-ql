package nl.uva.sc.test;


public class Token implements Comparable<Token> {

    private final Word mWord;

    private final Frequency mFrequency;

    public Token(final Word word) {
        mWord = word;
        mFrequency = new Frequency();
    }

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
            return ((mFrequency.compareTo(((Token) o).mFrequency) == 0) && mWord
                    .equals(((Token) o).mWord));
        }

        return this.equals(o);
    }

    @Override
    public int hashCode() {
        return mWord.hashCode();
    }

    @Override
    public int compareTo(final Token o) {
        return mFrequency.compareTo(o.mFrequency);
    }

    @Override
    public String toString() {
        return mWord + " - " + mFrequency;
    }

}
