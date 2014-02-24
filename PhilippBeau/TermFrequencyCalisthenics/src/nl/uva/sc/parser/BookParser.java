package nl.uva.sc.parser;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import nl.uva.sc.datatypes.Line;
import nl.uva.sc.datatypes.Word;
import nl.uva.sc.parser.subscriber.BookParserSubscriber;
import nl.uva.sc.parser.subscriber.ParserSubscribers;

public class BookParser {

    private final ParserSubscribers mSubscribers = new ParserSubscribers();

    public void parse(final Path bookFilePath, final Charset encoding) throws IOException {
        byte[] b = Files.readAllBytes(bookFilePath);
        ByteBuffer bb = ByteBuffer.wrap(b);
        CharBuffer cb = encoding.decode(bb);

        String line = cb.toString();
        Line currentLine = new Line(line);
        for (Word word : currentLine.getWords()) {
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