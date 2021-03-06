import java.lang.*;

public class WordPlay {

    public boolean isVowel(char ch) {
        boolean isVowel = false;
        String vowels = "aioue";
        if(vowels.indexOf(Character.toLowerCase(ch)) != -1){isVowel=true;}
        
        return isVowel;
    }
    
    public String replaceVowels (String phrase , char ch) {
        
        StringBuffer sb = new StringBuffer(phrase);
        
         for(int i = 0; i < sb.length(); i ++){
                if(isVowel(phrase.charAt(i))) {
                    sb.setCharAt(i, ch);
                }
         }
        
        return sb.toString();
    }
    
    public String emphasize (String phrase , char ch) {
        
        StringBuffer sb = new StringBuffer(phrase);
        
         for(int i = 0; i < phrase.length(); i ++){
             if(Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(ch)){
                // if the index is even the position is odd and vice versa
                if(i % 2 == 0) {
                    sb.setCharAt(i, '*');
                }
                
                else {
                    sb.setCharAt(i, '+');
                }
            }
         }
        
        return sb.toString();
    }
    
    public void testisVowel() {
        System.out.println(isVowel('a'));
        System.out.println(isVowel('A'));
        System.out.println(isVowel('b'));
        System.out.println(isVowel('B'));
    }
    
    public void testreplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*') );
        System.out.println(replaceVowels("Opinions are like nettles", '*') );

    }
    
    public void testemphasize() {
       // System.out.println(replaceVowels("dna ctgaaactga", '*') );
        System.out.println(emphasize("Mary Bella Abracadabra", 'a') );
        System.out.println(emphasize("dna ctgaaactga", 'a') );

    }
 
    

}
