import edu.duke.*;

public class TestCaesarCipher {
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
    
    public String breakCaesarCipher(String s){
        int[] freqs = countLetters(s);
        //System.out.println(""+freqs);
        int maxDex = maxIndex(freqs);
        System.out.println(""+maxDex);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(s);
    }
    
    public void simpleTest(){
        

        CaesarCipher cc = new CaesarCipher(15);
        FileResource resource = new FileResource();
        System.out.println(cc.encrypt(resource.asString()));
        System.out.println(cc.decrypt(cc.encrypt(resource.asString())));
        System.out.println(breakCaesarCipher(cc.encrypt(resource.asString())));
    }
    
    
}
