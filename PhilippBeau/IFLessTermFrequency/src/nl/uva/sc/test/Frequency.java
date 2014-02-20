package nl.uva.sc.test;

public class Frequency implements Comparable<Frequency> {

    public int mFrequency;

    public Frequency() {
        mFrequency = 0;
    }

    public Frequency(final int frequency) {
        mFrequency = frequency;
    }

    public void addFrequency() {
        mFrequency++;
    }

    @Override
    public int compareTo(final Frequency o) {
        return mFrequency - o.mFrequency;
    }

    @Override
    public String toString() {
        return mFrequency + "";
    }
}
