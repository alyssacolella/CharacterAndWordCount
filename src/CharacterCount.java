//CharacerCount.java
//* Read and compute the frequency of characters in a text document
//* Store them in a HashMap or TreeMap
//* This program is the starting point for building the Huffman tree

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * @author alyssacolella
 */
public class CharacterCount 
{
    
    private static HashMap<Character, Integer> infrequentChars = new HashMap<Character, Integer>();
   
    //It takes in a HashMap of characters and their counts, 
    //   search this HashMap for characters whose count is 1, 
    //   store these infrequent characters and their counts in another HashMap, 
    // and returns this HashMap.
    public static HashMap<Character, Integer> getInfrequentChars(HashMap<Character, Integer> allCharsCounts) 
    {
        for(HashMap.Entry<Character, Integer> c : allCharsCounts.entrySet())
        {
            if(c.getValue() == 1)
            {
                infrequentChars.put(c.getKey(), 1);
            }
        }
        
        return infrequentChars;
    }
    
    //It takes in a set of characters, search the HashMap in this CharacterCount object for these characters, and return the values of these characters as a Set.
    //If a character is not in the HashMap, then write its count as -1.
    public Set<Integer> getCounts(Set<Character> myChars) 
    {
        Set<Integer> count = new HashSet<>();
        
        for(Character c : myChars)
        {
            if(frequencies.containsKey(c))
            {
                count.add(frequencies.get(c));
            }
            else
            {
                count.add(-1);
            }
        }
        return count;
    }
    
    public void buildCharacterCount(BufferedReader chInput) 
    {
        try 
        {
            int nextChar;   // For storing the next character as an int
            //read() returns the code of the next character that is read from the file
            while ((nextChar = chInput.read()) != -1) {  // Test for more data
                Character next = new Character((char) nextChar);
                
                // Get the current count and increment it.
                Integer count = frequencies.get(next);
                if(count == null) 
                {
                    count = 1;   // First occurrence.
                } 
                else 
                {
                    count++;
                }

                // Store updated count.
                frequencies.put(next, count);
            }
            chInput.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }    
    
    //the HashMap for the character counts, initially empty
    private HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();  // HashMap of character frequencies.
    //new TreeMap<Character, Integer>(); //uncomment this line if using TreeMap


    //accessor for the data field frequencies
    public HashMap<Character, Integer> getFrequencies() {
        return frequencies;
    }
}