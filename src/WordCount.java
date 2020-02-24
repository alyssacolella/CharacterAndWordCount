import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class WordCount 
{
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
    
    public static void main(String[] args) 
    {
        try 
        {
            Scanner scan = new Scanner(new FileReader("test_4_word_count.txt"));
            WordCount wCounter = new WordCount();
            wCounter.buildWordCounts(scan);
        } 
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found");
        }
    }    
}