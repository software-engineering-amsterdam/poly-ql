package nl.uva.sc.parser.subscriber;

public interface BookParserSubscriber {

    public void nextWord(String word);

    public void newLine();
}