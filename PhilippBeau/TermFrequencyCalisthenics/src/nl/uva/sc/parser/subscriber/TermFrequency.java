package nl.uva.sc.parser.subscriber;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import nl.uva.sc.datatypes.Frequency;
import nl.uva.sc.datatypes.StopWord;
import nl.uva.sc.datatypes.Word;
import nl.uva.sc.parser.Token;

public class TermFrequency implements BookParserSubscriber {

    HashMap<Word, Token> mIndex = new HashMap<>();

    @Override
    public void nextWord(final Word word) {
        if (StopWord.isStopWord(word)) {
            return;
        }
        Token token = mIndex.get(word);

        if (token == null) {
            token = new Token(word, new Frequency());
            mIndex.put(word, token);
        }

        token.addFrequency();
    }

    public List<Token> getSortedTokens() {
        List<Token> tokens = new ArrayList<>(mIndex.values());
        Collections.sort(tokens);
        return tokens;
    }

    public void printTop(final int topX) {
        List<Token> sortedTokenList = getSortedTokens();
        int sortedListSize = sortedTokenList.size();
        PrintStream print = System.out;
        for (int i = 1; i <= topX; ++i) {
            Token currentToken = sortedTokenList.get(sortedListSize - i);
            print.println(currentToken);
        }
    }
}
