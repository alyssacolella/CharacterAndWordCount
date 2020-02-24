import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class WordCount 
{

    //---assign 10--------
    //define the data field named counts
    // the map for storing the words and their counts
    private HashMap<String, Integer> counts = new HashMap<String, Integer>(); 


    /**
     * Method to read each word in a data file and compute the number of times
     * it occurs
     *
     * @post count contains each word in lowercase form and the number of times
     * it occurs.
     * @param scan A Scanner object that references the file
     */
    public void buildWordCounts(Scanner scan) 
    {   
        while(scan.hasNext())
        {
            String w = scan.next();
            if(!(counts.containsKey(w)))
            {
                counts.put(w, 1);
            }
            else
            {
                int frequency = counts.get(w);
                counts.put(w, (frequency+1));
            }
        }
    }
    
    //---assign 10-------- end ------//
    
    public static void main(String[] args) 
    {
        try 
        {
            Scanner scan = new Scanner(new FileReader("test_4_word_count.txt"));
            WordCount wCounter = new WordCount();
            wCounter.buildWordCounts(scan);
            //uncomment the lines below after completing the coding of data field and 
            //   method buildWordCounts(...)
            //for (Map.Entry<String, Integer> e : wCounter.counts.entrySet()) {
            //    System.out.printf("%-15s%5d%n", e.getKey(), e.getValue());
            //}
        } 
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found");
        }
    }    
}