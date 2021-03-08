

public class CaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        
      String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      alphabet  = alph+alph.toLowerCase();
      shiftedAlphabet = ""+alph.substring(key)+alph.substring(0,  key)
      +alph.substring(key).toLowerCase()+alph.substring(0,  key).toLowerCase();
      mainKey = key;
      
    }
    
    public String getInstanceVariables(){
        return "Alph : "+alphabet+" Key :"+mainKey+" Shifted :"+shiftedAlphabet;
     } 
    
    public String encrypt(String input) {
      
      StringBuilder sb = new StringBuilder(input);
      
      for(int i = 0; i < input.length(); i++ ){
       
        if (alphabet.indexOf(sb.charAt(i)) != -1){
            sb.setCharAt(i, shiftedAlphabet.charAt(alphabet.indexOf(sb.charAt(i))));
        } 
            
      }

      return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey); 
    
        return cc.encrypt(input);
    }
    
}
