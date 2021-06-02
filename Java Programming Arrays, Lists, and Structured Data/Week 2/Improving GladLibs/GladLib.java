import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap <String, ArrayList<String>> wordList;
    private ArrayList<String> duplicateList;
    private ArrayList<String> consideredLables;
    private int numReplaced;

    
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";

    public GladLib(){
        wordList = new HashMap <String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLib(String source){
        wordList = new HashMap <String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {

        String [] labels = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
        for (String s: labels){
          ArrayList<String> list = readIt(source+"/"+s+".txt");
          wordList.put(s,list);
        
        }
        duplicateList = new ArrayList<String>();
        consideredLables  = new ArrayList<String>();
        numReplaced = 0;
    }

    private String randomFrom(ArrayList<String> source){
        //System.out.println(source.toString());
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {

        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        consideredLables.add(label);
        return randomFrom(wordList.get(label));
        
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        StringBuilder check = new StringBuilder(getSubstitute(w.substring(first+1,last)));
        while(duplicateList.contains(check.toString())){
            check = new StringBuilder(getSubstitute(w.substring(first+1,last)));
        }
        duplicateList.add(check.toString());
        String sub = check.toString();
        numReplaced++;
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    
    private int totaWordsInMap(){
    int count = 0;
        for(Map.Entry<String,ArrayList<String>> entry : wordList.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> array = entry.getValue();
            count+= array.size();
            //System.out.println("Total Words in :"+key+" is : "+array.size());
        } 
    return count;        
    }
    
    private int totalWordsConsidered(){
    int count = 0;
        for(Map.Entry<String,ArrayList<String>> entry : wordList.entrySet()) {
            String key = entry.getKey();
                if (consideredLables.contains(key)){
                ArrayList<String> array = entry.getValue();
                count+= array.size();
            }
            
            //System.out.println("Total Words in :"+key+" is : "+array.size());
        } 
    return count;        
    }
    
    public void makeStory(){
        duplicateList.clear();
        consideredLables.clear();
        System.out.println("\n");
        String story = fromTemplate(dataSourceDirectory+"/madtemplate2.txt");
        printOut(story, 60);
        System.out.println();
        System.out.println("Total number of words that were replaced :"+numReplaced);
        numReplaced = 0;
        System.out.println("Total number of words that it was possible to pick from :"+totaWordsInMap());
        System.out.println("Total number of words considered :"+totalWordsConsidered());
    }


}
