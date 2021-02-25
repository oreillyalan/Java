import edu.duke.URLResource;


public class Part4 {
    
    public void fundUrls(String stringb) {
        
      URLResource ur = new URLResource(stringb);
         for (String s : ur.words()) {
             if (s.toLowerCase().contains("youtube.com")){
                System.out.println(
                s.substring(
                s.indexOf("\"")+1, 
                s.indexOf(("\""),(s.indexOf("\"")+1))
                ));
                }
         }
    }
    
    public void testing() {
        fundUrls("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        // System.out.println(lastPart("by", "A story by Abby Long"));
        // System.out.println(lastPart("by", "byby"));
        // System.out.println(lastPart("a", "banana"));
        // System.out.println(lastPart("b", "banana"));
        // System.out.println(lastPart("ATG", "ctgtatgta"));
        

    }
}
