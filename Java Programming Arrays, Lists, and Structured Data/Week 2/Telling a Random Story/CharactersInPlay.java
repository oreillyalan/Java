
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    
    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;
    
   public CharactersInPlay (){
        myWords = new ArrayList <String>();
        myFreqs = new ArrayList <Integer>();
    }
    
    
   public void update (String person){
             person = person.toLowerCase();
             int index = myWords.indexOf(person);
             if (index == -1){
                myWords.add(person);
                myFreqs.add(1);
            }
            
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
       
    }
    
   public void findAllCharacters(){
       
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        
        for(String s: fr.lines()){
            if (s.indexOf(".") != -1){
             //System.out.println(s.substring(0,s.indexOf(".")));
             update(s.substring(0,s.indexOf(".")).trim());
            }
            
            //System.out.println(s.substring(0,s.indexOf(".")));
        }
       
    } 
    
   public void charactersWithNumParts (int num1, int num2){
       System.out.println("The characthers that appear between "+num1+" and "+num2+" are:");
       for(int k = 0; k < myWords.size(); k++ ){
        if (myFreqs.get(k) >= num1 && myFreqs.get(k) <= num2){
          System.out.println("The word '"+myWords.get(k)+"' appears "+myFreqs.get(k)+" times." );
        }
       }    
        
       
    }  
    
   public void tester(){
       findAllCharacters();
       //System.out.println("Number of unique words: "+myWords.size());
       for(int k = 0; k < myWords.size(); k++ ){
        if (myFreqs.get(k) > 1){
          System.out.println("The word '"+myWords.get(k)+"' appears "+myFreqs.get(k)+" times." );
        }
       }        
       //System.out.println("The most common word is '"+myWords.get(findIndexOfMax())+"'");
       charactersWithNumParts(10, 15);
       
    } 
}
