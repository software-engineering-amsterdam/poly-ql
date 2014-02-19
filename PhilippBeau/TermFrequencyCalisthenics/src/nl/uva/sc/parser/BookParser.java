package nl.uva.sc.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import nl.uva.sc.datatypes.Line;
import nl.uva.sc.datatypes.Word;
import nl.uva.sc.parser.subscriber.BookParserSubscriber;
import nl.uva.sc.parser.subscriber.ParserSubscribers;

public class BookParser {

    private final File mBookFile;

    private final ParserSubscribers mSubscribers = new ParserSubscribers();

    public BookParser(final File bookFile) {
        mBookFile = bookFile;
    }

    public void parse() throws IOException {
        parse(Charset.forName("UTF-8"));
    }

    public void parse(final Charset encoding) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(mBookFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, encoding);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = null;
        while ((line = reader.readLine()) != null) {
            Line currentLine = new Line(line);
            handleLine(currentLine.getWords());
        }

        reader.close();
    }

    private void handleLine(final List<Word> line) {
        for (Word word : line) {
            handleWord(word);
        }
    }

    private void handleWord(final Word word) {
        if (!word.isEmpty()) {
            mSubscribers.notifyListener(word);
        }

    }

    public boolean subscribe(final BookParserSubscriber subscriber) {
        return mSubscribers.subscribe(subscriber);
    }

    public boolean unsubscribe(final BookParserSubscriber subscriber) {
        return mSubscribers.unsubscribe(subscriber);
    }

}
