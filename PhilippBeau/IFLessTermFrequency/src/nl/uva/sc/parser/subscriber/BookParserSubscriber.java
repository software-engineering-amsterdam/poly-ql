package nl.uva.sc.parser.subscriber;

import nl.uva.sc.test.Word;

public interface BookParserSubscriber {

    /**
     * Handles the next parsed word
     * 
     * @param word
     */
    public void nextWord(Word word);
}
