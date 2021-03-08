import edu.duke.*;

public class WordLengths {

    public void countWordLengths (FileResource resource , int [] counts) {
       int count = 0;
       String[] byLength = new String[counts.length];
       StringBuilder sb = new StringBuilder();
        for(String word : resource.words()){
           sb.append(word); 
           if (!Character.isLetter(sb.charAt(0))){
                sb.deleteCharAt(0);
           }   
           if (!Character.isLetter(sb.charAt(sb.length()-1))){
                sb.deleteCharAt(sb.length()-1);
           }
           
           if (sb.length() >= 30){ count = 30;}
           else {count = sb.length();}
           counts[count] +=1;
           byLength[count] += ""+sb.toString()+", ";
           //System.out.println(word+" length: "+ count);
           sb = new StringBuilder();
        }
        for(int k=1; k < counts.length; k++){

            if (counts[k] > 0){
              System.out.println(counts[k]+ " Words that are length " + k +": "
              +byLength[k].substring(4));
            }
        }
    }
    
    public int indexOfMax(int[] vals){
        int maxDex = 0;
        for(int k = 0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        System.out.println("Note this file has words that are:");
        countWordLengths(fr,counts);
        System.out.println("The most common word length in the file: "+ indexOfMax(counts));

    }

}
