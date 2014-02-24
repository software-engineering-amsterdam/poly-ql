package nl.uva.sc.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

import nl.uva.sc.parser.BookParser;
import nl.uva.sc.parser.subscriber.TermFrequency;

import org.junit.Test;

public class TestTF {

    public static final String BOOK_FILENAME = "pride-and-prejudice.txt";

    public static final String DESIRED_OUTPUT = "mr - 786\nelizabeth - 635\nvery - 488\ndarcy - 418\nsuch - 395\nmrs - 343\nmuch - 329\nmore - 327\nbennet - 323\nbingley - 306\njane - 295\nmiss - 283\none - 275\nknow - 239\nbefore - 229\nherself - 227\nthough - 226\nwell - 224\nnever - 220\nsister - 218\nsoon - 216\nthink - 211\nnow - 209\ntime - 203\ngood - 201\n";

    @Test
    public void test() {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bOutput));

        TermFrequency index = new TermFrequency();
        BookParser bParser = new BookParser();
        bParser.subscribe(index);

        try {
            bParser.parse(new File(BOOK_FILENAME).toPath(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            fail("The book parser could not parse the given file \"" + BOOK_FILENAME + "\"");
        }

        index.printTop(25);
        assertTrue(bOutput.toString().equals(DESIRED_OUTPUT));
    }
}
