package nl.uva.sc.parser.subscriber;

public interface BookParserSubscriber {

    /**
     * Handles the next parsed word
     * 
     * @param word
     */
    public void nextWord(String word);

    /**
     * Will in the future notify about newline events
     */
    public void newLine();
}
