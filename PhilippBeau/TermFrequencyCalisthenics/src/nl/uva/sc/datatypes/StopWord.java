package nl.uva.sc.datatypes;

import java.util.HashSet;
import java.util.Set;

public class StopWord {

    private final static String[] STOPWORDS = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your"
            .split(",");

    private final static Set<Word> mStopWords = generateWordSet(STOPWORDS);

    private static Set<Word> generateWordSet(final String[] stopWordStrings) {
        Set<Word> stopWords = new HashSet<>();
        for (String stopWordString : stopWordStrings) {
            stopWords.add(new Word(stopWordString));
        }

        return stopWords;
    }

    public static boolean isStopWord(final Word word) {
        return mStopWords.contains(word);
    }
}
