import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by santiagocarrillo on 17/02/14.
 */
public class Main {


    public static void main(String[] args)
    {

        int n = 20;

        File file = new File("pride-and-prejudice.txt");
        HashMap<String, Integer> wordsCount = loadWordsList(file);
        TreeMap<String, Integer> wordsCountSorted =
                new TreeMap<String, Integer>(new ValueComparator(wordsCount));
        wordsCountSorted.putAll(wordsCount);
        int i = 0;
        for(String word: wordsCountSorted.keySet()){
            System.out.println(word+" - "+wordsCount.get(word));
            i++;
            if(i == n) break;

        }


    }

    private static HashMap<String, Integer>
    loadWordsList(File file) {
        StopWords stopWords = new StopWords();
        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] words = line.split("\\W+");
                for (int i = 0; i < words.length; i++)
                {
                    String word = words[i].toLowerCase();
                    if(!"".equals(word) && !stopWords.isStopWord(word))
                    {
                        wordsCount.put(word,
                                wordsCount.containsKey(word) ? wordsCount.get(word) + 1 : 1);
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return wordsCount;
    }

}
