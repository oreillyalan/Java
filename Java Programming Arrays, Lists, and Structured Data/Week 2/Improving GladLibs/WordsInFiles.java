
import java.util.*;
import edu.duke.*;
import java.io.File;

public class WordsInFiles {
    
   private HashMap <String, ArrayList<String>> wordCount;
   
   public WordsInFiles(){
       
       wordCount = new HashMap <String, ArrayList<String>>();
       
    }

   
   private void addWordsFromFile(File f){
      
       FileResource fr = new FileResource(f);
         for (String s : fr.words()) {
             //System.out.println(s);
             //System.out.println(f.getName());
             if (!wordCount.containsKey(s)){ 
                 ArrayList<String> fileNames = new ArrayList<String>();
                  wordCount.put(s,fileNames);
                  wordCount.get(s).add(f.getName());
                }else {
               if (!wordCount.get(s).contains(f.getName())){
                   wordCount.get(s).add(f.getName());
                }

             }
     }
   }
   
   private void buildWordFileMap(){
    wordCount.clear();
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()) {
         addWordsFromFile(f);
        }
    
    } 
    
    private int maxNumber (){
        int size = 0;
        for (String name: wordCount.keySet()){
            String key = name.toString();
            ArrayList <String> value = wordCount.get(key);
            
           if (size < value.size()){
            
              size =  value.size();
            }  
        }
       return size;
    }
    
    private ArrayList<String>  wordsInNumFiles(int num){
        int size = 0;
        ArrayList<String> wordList = new ArrayList<String>();
        for (String name: wordCount.keySet()){
            String key = name.toString();
            ArrayList <String> value = wordCount.get(key);
            
           if (num == value.size()){
              wordList.add(key);
            }  
        }
       return wordList;
    }
    
   private void printFilesIn (String word){
         
    if (wordCount.containsKey(word)){
            
        ArrayList <String> value = wordCount.get(word);
        System.out.println(word+" appears in the followes files: ");
        for (String name: value){
            System.out.print(name+" ");
           
        }
    } System.out.println();
    }
    
    
    public void tester(){
        buildWordFileMap();

        System.out.println("The max number of files a word appears in is "+maxNumber());
        System.out.println("The words that appear "+maxNumber()+" times in those files are "+wordsInNumFiles(maxNumber()));
        System.out.println("Totaling : "+ wordsInNumFiles(maxNumber()).size());
        // for (String name: wordsInNumFiles(maxNumber())){
             // printFilesIn(name);
        // }
        //printFilesIn("cats");
        //printFilesIn("dogs");
    }
    
      public void tester2(){
        buildWordFileMap();

        //System.out.println("The max number of files a word appears in is "+maxNumber());
        //System.out.println("The words that appear "+maxNumber()+" times in those files are "+wordsInNumFiles(maxNumber()));
        System.out.println("Totaling : "+ wordsInNumFiles(4).size());
        // for (String name: wordsInNumFiles(maxNumber())){
             // printFilesIn(name);
        // }
        //printFilesIn("cats");
        //printFilesIn("dogs");
    }
    
    public void tester3(){
        buildWordFileMap();

        //System.out.println("The max number of files a word appears in is "+maxNumber());
        //System.out.println("The words that appear "+maxNumber()+" times in those files are "+wordsInNumFiles(maxNumber()));
        //System.out.println("Totaling : "+ wordsInNumFiles(4).size());
        // for (String name: wordsInNumFiles(maxNumber())){
             // printFilesIn(name);
        // }
        //printFilesIn("sad");
        printFilesIn("tree");
    }
}
