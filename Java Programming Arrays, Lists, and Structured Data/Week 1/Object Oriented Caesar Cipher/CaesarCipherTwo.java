

public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int firstKey;
    private int secondKey;
    
    public CaesarCipherTwo(int key1, int key2){
        
      String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      alphabet  = alph+alph.toLowerCase();
      shiftedAlphabet1 = ""+alph.substring(key1)+alph.substring(0,  key1)
      +alph.substring(key1).toLowerCase()+alph.substring(0,  key1).toLowerCase();
      shiftedAlphabet2 = ""+alph.substring(key2)+alph.substring(0,  key2)
      +alph.substring(key2).toLowerCase()+alph.substring(0,  key2).toLowerCase();
      firstKey = key1;
      secondKey = key2;
    }
    
    public String getInstanceVariables(){
        return "Alph : "+alphabet+" Key :";//+mainKey+" Shifted :"+shiftedAlphabet;
     } 
     
    public String encryptTwoKeys (String input) {
         StringBuilder sb = new StringBuilder(input);
            
          for(int i = 0; i < input.length(); i++ ){
                //sb.setCharAt(alph.indexOf(alph.charAt(i)), cipher.charAt(i));
            if (alphabet.indexOf(sb.charAt(i)) != -1){
                if (i % 2 == 0){
                sb.setCharAt(i, shiftedAlphabet1.charAt(alphabet.indexOf(sb.charAt(i))));
            }
            else {sb.setCharAt(i, shiftedAlphabet2.charAt(alphabet.indexOf(sb.charAt(i))));}
          }    
                
        }
    
          return sb.toString();
    }
    
    public String decryptTwoKeys(String encrypted){
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - firstKey,26 - secondKey);
        return cc.encryptTwoKeys(encrypted);
    }
}
