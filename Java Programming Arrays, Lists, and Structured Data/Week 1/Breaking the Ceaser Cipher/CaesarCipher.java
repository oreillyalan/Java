import edu.duke.*;

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
    public void testCaesar() {
        // int key = 17;
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        // String encrypted = encrypt(message, key);
        // System.out.println(encrypted);
        // String decrypted = encrypt(encrypted, 26-key);
        // System.out.println(decrypted);
        System.out.println(encryptTwoKeys("Eren and Emily have evil eerie green ears", 22, 19)); 
    }
}

