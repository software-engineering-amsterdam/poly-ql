package nl.uva.sc.parser.subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import nl.uva.sc.test.Token;
import nl.uva.sc.test.Word;

public class TermFrequency implements BookParserSubscriber {

    HashMap<Word, Token> mIndex = new HashMap<>();

    @Override
    public void nextWord(final Word word) {
        Token token = mIndex.get(word);

        if (token == null) {
            token = new Token(word);
            mIndex.put(word, token);
        }

        token.addFrequency();
    }

    /**
     * Get the tokens sorted by occurrence
     * 
     * @param amount
     * @return The list of tokens sorted by occurrence
     */
    public List<Token> getSortedTokens() {
        List<Token> tokens = new ArrayList<>(mIndex.values());
        Collections.sort(tokens);

        return tokens;
    }
}
