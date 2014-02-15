package nl.uva.sc.parser.subscriber;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.datatypes.Word;

public class ParserSubscribers {

    private final List<BookParserSubscriber> mSubscriber = new ArrayList<>();

    /**
     * Notify all listeners about the last parsed word
     * 
     * @param word
     */
    public void notifyListener(final Word word) {
        for (BookParserSubscriber subscriber : mSubscriber) {
            subscriber.nextWord(word);
        }
    }

    /**
     * Subscribe to the word listener list
     * 
     * @param subscriber
     * @return True if successful subscribed
     */
    public boolean subscribe(final BookParserSubscriber subscriber) {
        return mSubscriber.add(subscriber);
    }

    /**
     * Unsubscribe the given subscriber from the listener list
     * 
     * @param subscriber
     * @return True if successful unsubscribed
     */
    public boolean unsubscribe(final BookParserSubscriber subscriber) {
        return mSubscriber.remove(subscriber);
    }
}
