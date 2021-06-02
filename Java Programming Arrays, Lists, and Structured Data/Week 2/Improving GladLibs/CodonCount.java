
import java.util.*;
import edu.duke.*;

public class CodonCount {
    
    private HashMap <String, Integer> codonCount;
    
    public CodonCount(){
      codonCount = new HashMap <String, Integer>();
    }
    
    private void buildCodonMap(int start, String dna){
      codonCount.clear();
      for(int k = start; k < dna.length();k=(k+3)){

         if(k+3 <= dna.length()){

             if (!codonCount.containsKey(dna.substring(k,(k+3)))){ 
                 
                  codonCount.put(dna.substring(k,(k+3)),1);
                }else {
               
               codonCount.put(dna.substring(k,(k+3)),codonCount.get(dna.substring(k,(k+3))) + 1);
             }
 
        }

        }
    }
    
    private String getMostCommonCodon(){
     
        StringBuilder sb = new StringBuilder();
        int maxCount = 0;
        for (String name: codonCount.keySet()){
            String key = name.toString();
            int value = codonCount.get(name);
            if (value >maxCount){
            maxCount = value;
            sb = new StringBuilder(key);  
        }
        
      } 
      return sb.toString();
    }
    
    private void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are : ");
        for (String name: codonCount.keySet()){
            String key = name.toString();
            int value = codonCount.get(name);
            if (value >= start && value <= end){
            System.out.println(key + " " + value);  
        }
      } 
    
    } 
    
    public void test(){
        FileResource fr = new FileResource();
        String gene = fr.asString().trim();
        buildCodonMap(0, gene);
        System.out.println("Reading frame starting with 0 results in "+codonCount.size()+" unique codons." );
        System.out.println(" and most common codon is "+getMostCommonCodon()+" with count "+codonCount.get(getMostCommonCodon()));
        printCodonCounts(6,7);
        System.out.println();
        
        buildCodonMap(1, gene);
        System.out.println("Reading frame starting with 1 results in "+codonCount.size()+" unique codons." );
        System.out.println(" and most common codon is "+getMostCommonCodon()+" with count "+codonCount.get(getMostCommonCodon()));
        printCodonCounts(1,5);
        System.out.println();
        
        buildCodonMap(2, gene);
        System.out.println("Reading frame starting with 2 results in "+codonCount.size()+" unique codons." );
        System.out.println(" and most common codon is "+getMostCommonCodon()+" with count "+codonCount.get(getMostCommonCodon()));
        printCodonCounts(1,5);
        System.out.println();

    }
}
