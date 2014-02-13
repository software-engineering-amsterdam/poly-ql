package nl.uva.sc.parser.subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.sc.datatypes.Word;
import nl.uva.sc.parser.Token;

public class TermFrequency implements BookParserSubscriber {

    private final static String[] STOPWORDS = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your"
            .split(",");

    private final static Set<Word> mStopWords = generateWordSet(STOPWORDS);

    HashMap<Word, Token> mIndex = new HashMap<>();

    private static Set<Word> generateWordSet(final String[] stopWordStrings) {
        Set<Word> stopWords = new HashSet<>();
        for (String stopWordString : stopWordStrings) {
            stopWords.add(new Word(stopWordString));
        }

        return stopWords;
    }

    @Override
    public void nextWord(final Word word) {
        if (mStopWords.contains(word)) {
            return;
        }

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
