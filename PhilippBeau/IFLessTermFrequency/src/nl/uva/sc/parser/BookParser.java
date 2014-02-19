package nl.uva.sc.parser;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.uva.sc.datatypes.Word;
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
        parse(Charset.forName("UTF-8"));
    }

    /**
     * Starts the parser
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed given the character encoding
     */
    public void parse(final Charset encoding) throws IOException {

        handleLine(generateWordList(
                new ArrayList<>(Arrays.asList(encoding
                        .decode(ByteBuffer.wrap(Files.readAllBytes(mBookFile.toPath()))).toString()
                        .toLowerCase().replaceAll("[^a-zA-Z\\s]", " ").replaceAll("\\s+", " ")
                        .split(" "))), 0));
    }

    /**
     * Generate a word list out of a line array
     * 
     * @param lineArray
     *            The line array to generate the word list of
     * @return A word list containing all words from the line array
     */
    private List<Word> generateWordList(final List<String> lineArray, final int pos) {

        lineArray
                .removeAll(Arrays
                        .asList("a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your"
                                .split(",")));

        List<Word> wordList = new ArrayList<Word>();
        for (String word : lineArray) {
            wordList.add(new Word(word));
        }

        return wordList;
    }

    /**
     * Parse a whole line
     * 
     * @param line
     *            The line to get parsed
     */
    private void handleLine(final List<Word> line) {
        for (Word word : line) {
            handleWord(word);
        }
    }

    /**
     * Parse a word
     * 
     * @param word
     *            The word to get parsed
     */
    private void handleWord(final Word word) {
        if (!word.isEmpty()) {
            notifyListener(word);
        }

    }

    /**
     * Notify all listeners about the last parsed word
     * 
     * @param word
     */
    private void notifyListener(final Word word) {
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
