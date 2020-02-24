//CharacterCountTest.java
//* The client of class CharacterCount.
//* Create an object of CharacterCount,
//* call its buildCharacterCount(...) to compute the character counts,
//* Get the counts and print them.

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * 
 */
public class CharacterCountTest 
{

    public static void main(String[] args) 
    {
        //create an object of CharacterCount
        CharacterCount chCount = new CharacterCount();

        try 
        {
            //create a character input stream to read the specifid file character by character
            BufferedReader chInput
                    = new BufferedReader(new FileReader("test_4_char_count.txt"));
            //call its buildCharacterCount(...) to compute the character counts
            chCount.buildCharacterCount(chInput);

            //get the character counts
            HashMap<Character, Integer> frequencies = chCount.getFrequencies();
            
            //----Assign 10 -------//   
            System.out.println("Frequencies:\n");
            print(frequencies);
            
            System.out.println(chCount.getInfrequentChars(frequencies));
            
            //add code to do these:
            //	Declare and create an empty Set of Characters, add some characters into the set. The set must contain both characters in the document and characters not in the document. The Set can be TreeSet or HashSet.
            Set<Character> chars = new HashSet<>();
            chars.add('a');
            chars.add('b');
            chars.add('x');
            chars.add('z');
            //	Use this Set of Characters to test getCounts(…)
            System.out.println(chCount.getCounts(chars));
            //----------//
            
            //use for each loop to get each entry in th map
            //for (Map.Entry<Character, Integer> e : frequencies.entrySet()) {
            //    //print the character and its count in the current entry in a nice foemat
            //    System.out.printf("%-10s%5d%n", e.getKey(), e.getValue());
            //}
        } 
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found");
        }
    }

    //assign 10
    public static void print(Map<Character, Integer> frequencies) 
    {
        for(HashMap.Entry<Character, Integer> c : frequencies.entrySet())
        {
            System.out.printf("%-8s%4d%n", c.getKey(), c.getValue());
        }
        
    }
      
}