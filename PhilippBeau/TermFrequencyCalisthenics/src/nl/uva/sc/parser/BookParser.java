package nl.uva.sc.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import nl.uva.sc.parser.subscriber.BookParserSubscriber;
import nl.uva.sc.parser.subscriber.ParserSubscribers;

public class BookParser {

    private final File mBookFile;

    private final ParserSubscribers mSubscribers = new ParserSubscribers();

    /**
     * Create a book parser
     * 
     * @param bookFile
     *            The book to parse
     */
    public BookParser(final File bookFile) {
        mBookFile = bookFile;
    }

    /**
     * Starts the parser with standard UTF-8 encoding
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed with UTF-8 encoding
     */
    public void parse() throws IOException {
        parse("UTF-8");
    }

    /**
     * Starts the parser
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed given the character encoding
     */
    public void parse(final String encoding) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(mBookFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, encoding);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = null;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z\\s]", " ");
            line = line.replaceAll("\\s+", " ");

            String[] lineArray = line.split(" ");
            handleLine(lineArray);
        }

        reader.close();
    }

    /**
     * Parse a whole line
     * 
     * @param line
     *            The line to get parsed
     */
    private void handleLine(final String[] line) {
        for (String word : line) {
            handleWord(word);
        }
    }

    /**
     * Parse a word
     * 
     * @param word
     *            The word to get parsed
     */
    private void handleWord(final String word) {
        if (word.isEmpty() || word.length() == 1) {
            return;
        }

        notifyListener(word.toLowerCase());
    }

    /**
     * Notify all listeners about the last parsed word
     * 
     * @param word
     */
    private void notifyListener(final String word) {
        mSubscribers.notifyListener(word);
    }

    /**
     * Subscribe to the word listener list
     * 
     * @param subscriber
     * @return True if successful subscribed
     */
    public boolean subscribe(final BookParserSubscriber subscriber) {
        return mSubscribers.subscribe(subscriber);
    }

    /**
     * Unsubscribe the given subscriber from the listener list
     * 
     * @param subscriber
     * @return True if successful unsubscribed
     */
    public boolean unsubscribe(final BookParserSubscriber subscriber) {
        return mSubscribers.unsubscribe(subscriber);
    }

}
