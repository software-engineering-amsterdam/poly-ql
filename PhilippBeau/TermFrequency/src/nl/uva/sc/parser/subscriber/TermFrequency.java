package nl.uva.sc.parser.subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import nl.uva.sc.parser.Token;

public class TermFrequency implements BookParserSubscriber {

    HashMap<String, Token> mIndex = new HashMap<>();

    @Override
    public void nextWord(final String word) {
        Token token = mIndex.get(word);

        if (token == null) {
            mIndex.put(word, new Token(word));
        } else {
            token.addOccurrence();
        }
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

    @Override
    public void newLine() {}

}
