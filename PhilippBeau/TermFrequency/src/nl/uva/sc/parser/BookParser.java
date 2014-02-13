package nl.uva.sc.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.parser.subscriber.BookParserSubscriber;

public class BookParser {

    private final File mBookFile;

    private final List<BookParserSubscriber> mSubscriber = new ArrayList<>();

    public BookParser(final File bookFile) {
        mBookFile = bookFile;
    }

    public void parse() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                mBookFile), "UTF-8"));

        String line = null;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z\\s]", " ");
            line = line.replaceAll("\\s+", " ");

            String[] words = line.split(" ");

            for (String word : words) {
                if (word.isEmpty() || word.length() == 1) continue;

                notifyListener(word.toLowerCase());
            }
        }

        reader.close();
    }

    private void notifyListener(final String word) {
        for (BookParserSubscriber subscriber : mSubscriber) {
            subscriber.nextWord(word);
        }
    }

    public boolean subscribe(final BookParserSubscriber subscriber) {
        return mSubscriber.add(subscriber);
    }

    public boolean unsubscribe(final BookParserSubscriber subscriber) {
        return mSubscriber.remove(subscriber);
    }

}