
public class Part3 {

    public boolean twoOccurrences (String stringa,String stringb) {
        
        boolean occursTwice = false;
        int count = 0;
        
        if(stringb.contains(stringa)){
            count++;
            if(stringb.substring(stringb.indexOf(stringa)+stringa.length()).contains(stringa)){
                count++;
            }
        }
        
        if (count > 1) {
        occursTwice = true;
        }
        return occursTwice;
    }
    
    public String lastPart(String stringa,String stringb) {
        
        
        if(stringb.contains(stringa)){
           return stringb.substring(stringb.indexOf(stringa)+stringa.length());
        }
        
        else 
        return stringb;
    }
    
    public void testing() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("by", "byby"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("b", "banana"));
        System.out.println(twoOccurrences("ATG", "ctgtatgta"));
        
        System.out.println(lastPart("by", "A story by Abby Long"));
        System.out.println(lastPart("by", "byby"));
        System.out.println(lastPart("a", "banana"));
        System.out.println(lastPart("b", "banana"));
        System.out.println(lastPart("ATG", "ctgtatgta"));

    }
}


