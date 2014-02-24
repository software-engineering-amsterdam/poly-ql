package nl.uva.sc.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.datatypes.Frequency;
import nl.uva.sc.datatypes.Word;
import nl.uva.sc.parser.BookParser;
import nl.uva.sc.parser.Token;
import nl.uva.sc.parser.subscriber.TermFrequency;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTF {

    public static final String BOOK_FILENAME = "pride-and-prejudice.txt";

    public static final List<Token> mTrueIndex = new ArrayList<>();

    @BeforeClass
    public static void startUp() {
        mTrueIndex.add(new Token(new Word("mr"), new Frequency(786)));
        mTrueIndex.add(new Token(new Word("elizabeth"), new Frequency(635)));
        mTrueIndex.add(new Token(new Word("very"), new Frequency(488)));
        mTrueIndex.add(new Token(new Word("darcy"), new Frequency(418)));
        mTrueIndex.add(new Token(new Word("such"), new Frequency(395)));
        mTrueIndex.add(new Token(new Word("mrs"), new Frequency(343)));
        mTrueIndex.add(new Token(new Word("much"), new Frequency(329)));
        mTrueIndex.add(new Token(new Word("more"), new Frequency(327)));
        mTrueIndex.add(new Token(new Word("bennet"), new Frequency(323)));
        mTrueIndex.add(new Token(new Word("bingley"), new Frequency(306)));
        mTrueIndex.add(new Token(new Word("jane"), new Frequency(295)));
        mTrueIndex.add(new Token(new Word("miss"), new Frequency(283)));
        mTrueIndex.add(new Token(new Word("one"), new Frequency(275)));
        mTrueIndex.add(new Token(new Word("know"), new Frequency(239)));
        mTrueIndex.add(new Token(new Word("before"), new Frequency(229)));
        mTrueIndex.add(new Token(new Word("herself"), new Frequency(227)));
        mTrueIndex.add(new Token(new Word("though"), new Frequency(226)));
        mTrueIndex.add(new Token(new Word("well"), new Frequency(224)));
        mTrueIndex.add(new Token(new Word("never"), new Frequency(220)));
        mTrueIndex.add(new Token(new Word("sister"), new Frequency(218)));
        mTrueIndex.add(new Token(new Word("soon"), new Frequency(216)));
        mTrueIndex.add(new Token(new Word("think"), new Frequency(211)));
        mTrueIndex.add(new Token(new Word("now"), new Frequency(209)));
        mTrueIndex.add(new Token(new Word("time"), new Frequency(203)));
        mTrueIndex.add(new Token(new Word("good"), new Frequency(201)));
    }

    @Test
    public void test() {

        TermFrequency index = new TermFrequency();
        BookParser bParser = new BookParser();
        bParser.subscribe(index);

        try {
            bParser.parse(new File(BOOK_FILENAME).toPath(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            fail("The book parser could not parse the given file \"" + BOOK_FILENAME + "\"");
        }

        List<Token> sortedTokenList = index.getSortedTokens();
        for (int i = 1; i < 26; ++i) {
            Token current = sortedTokenList.get(sortedTokenList.size() - i);
            Token shouldBeSame = mTrueIndex.get(i - 1);

            System.out.println(current);

            assertTrue("Wrong Token at position " + i, current.equals(shouldBeSame));
        }
    }
}
