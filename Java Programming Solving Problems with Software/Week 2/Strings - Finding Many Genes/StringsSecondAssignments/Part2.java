

public class Part2 {
        public int howMany (String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        int count = 0;
        
       while (true) {
       if(startIndex == -1){
           break;
        }
       
       else {
           count++;
           startIndex = stringb.indexOf(stringa, 
           startIndex+stringa.length());
        }
    
        }
       
       return count;
    }
    
    public void testHowMany (){      
     System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
     System.out.println(howMany("A", "ATGAACGAATTGAATC"));
     System.out.println(howMany("P", "ATGAACGAATTGAATC"));
     System.out.println(howMany("C", "ATGAACGAATTGAATC"));
     System.out.println(howMany("GA", "ATGAACGAATTGAATC"));
     System.out.println(howMany("G", "ATGAACGAATTGAATC"));
    }
}
