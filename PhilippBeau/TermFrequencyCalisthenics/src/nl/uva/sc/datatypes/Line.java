package nl.uva.sc.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final String[] mLineArray;

    public Line(final String line) {
        String tmpLine = line.replaceAll("[^a-zA-Z\\s]", " ");
        tmpLine = tmpLine.replaceAll("\\s+", " ");
        tmpLine = tmpLine.toLowerCase();
        mLineArray = tmpLine.split(" ");
    }

    public List<Word> getWords() {
        List<Word> wordList = new ArrayList<Word>();
        for (String word : mLineArray) {
            wordList.add(new Word(word));
        }

        return wordList;
    }

}
