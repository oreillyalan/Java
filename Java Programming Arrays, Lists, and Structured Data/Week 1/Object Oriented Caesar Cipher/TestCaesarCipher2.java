import edu.duke.*;

public class TestCaesarCipher2 {
    public int[] countLetters(String encrypted){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[alpha.length()];
        for(int i=0; i<encrypted.length(); i++){
            
            int index=alpha.indexOf(Character.toLowerCase(encrypted.charAt(i)));
            
            if(index!=-1){
                count[index]++;
            }
        }

        
        
        return count;
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k = 0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public String halfOfString (String message, int start){
        
        StringBuilder halfString = new StringBuilder();
        
        for (int i = start; i < message.length(); i+=2){
            halfString.append(message.charAt(i));
        }
        
        return halfString.toString();
    }
    
     public int getKey(String s){
        int[] freqs = countLetters(s);
        //System.out.println(""+freqs);
        int maxDex = maxIndex(freqs);
        //System.out.println(""+maxDex);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    
    public String breakCaesarCipher(String s){
        String encrypted1 =  halfOfString(s, 0);
        String encrypted2 = halfOfString(s, 1);
        int firstKey = getKey(encrypted1);
        int secondKey =  getKey(encrypted2);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(firstKey, secondKey);
        return cc.decryptTwoKeys(s);
    }
    
    public void simpleTest(){
        

        //CaesarCipherTwo cc = new CaesarCipherTwo(12, 2);
        // FileResource resource = new FileResource();
        // System.out.println(resource.asString());
        //System.out.println(cc.encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy."));
        // System.out.println(cc.decryptTwoKeys(cc.encryptTwoKeys(resource.asString())));
        System.out.println(breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
    }
    
    
}
