
import edu.duke.*;
import org.apache.commons.csv.*;


public class CaesarCipher {
    //public int encrypt(String input, int key) {
    public String encrypt(String input, int key) {
      
      StringBuffer sb = new StringBuffer(input);
      String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String fullAlph  = alph+alph.toLowerCase();
      String cipher = ""+alph.substring(key)+alph.substring(0,  key)
      +alph.substring(key).toLowerCase()+alph.substring(0,  key).toLowerCase();
      
      for(int i = 0; i < input.length(); i++ ){
            //sb.setCharAt(alph.indexOf(alph.charAt(i)), cipher.charAt(i));
        if (fullAlph.indexOf(sb.charAt(i)) != -1){
            sb.setCharAt(i, cipher.charAt(fullAlph.indexOf(sb.charAt(i))));
        } 
            
    }

      return sb.toString();
    }
    
    public String encryptTwoKeys (String input, int key1, int key2) {
      
          StringBuffer sb = new StringBuffer(input);
          String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          String fullAlph  = alph+alph.toLowerCase();
          String cipher1 = ""+alph.substring(key1)+alph.substring(0,  key1)
          +alph.substring(key1).toLowerCase()+alph.substring(0,  key1).toLowerCase();
          String cipher2 = ""+alph.substring(key2)+alph.substring(0,  key2)
          +alph.substring(key2).toLowerCase()+alph.substring(0,  key2).toLowerCase();
          
          for(int i = 0; i < input.length(); i++ ){
                //sb.setCharAt(alph.indexOf(alph.charAt(i)), cipher.charAt(i));
            if (fullAlph.indexOf(sb.charAt(i)) != -1){
                if (i % 2 == 0){
                sb.setCharAt(i, cipher1.charAt(fullAlph.indexOf(sb.charAt(i))));
            }
            else {sb.setCharAt(i, cipher2.charAt(fullAlph.indexOf(sb.charAt(i))));}
          }    
                
        }
    
          return sb.toString();
    }
    
    
    public void testCaesar () {
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        // String encrypted =  encrypt("FIRST LEGION ATTACK EAST FLANK!", 23);
        // System.out.println(encrypted);
        // String encrypted =  encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        // System.out.println(encrypted);
        // String encrypted =  encryptTwoKeys("First Legion", 23,17);
        // System.out.println(encrypted);
        String encryptedd =  encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees", 23, 2);
        System.out.println(encryptedd);
      
    }
}
