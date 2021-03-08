
import java.util.*;
import edu.duke.*;

public class WordFrequencies {

    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;
    
    public WordFrequencies (){
        myWords = new ArrayList <String>();
        myFreqs = new ArrayList <Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        
        for(String s: fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        
        }
        
        
        
        
    }
    
    public int findIndexOfMax(){
        int lastIndex = 0;
        
        for(int k = 0;  k < myFreqs.size(); k++){
            if(lastIndex == myFreqs.get(k)){
                lastIndex = lastIndex;
            }
            else {
            lastIndex = Math.max(lastIndex, myFreqs.get(k));
            }
        }
        return myFreqs.indexOf(lastIndex);
    }
    
    public void tester(){
        
       findUnique();       
       System.out.println("Number of unique words: "+myWords.size());
       for(int k = 0; k < myWords.size(); k++ ){
        System.out.println("The word '"+myWords.get(k)+"' appears "+myFreqs.get(k)+" times." );
       }        
       System.out.println("The most common word is '"+myWords.get(findIndexOfMax())+"'");
    }
    

    
    
}
