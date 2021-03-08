

import edu.duke.*;

public class CrackingCipher {
    
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
    
    
    public String halfOfString (String message, int start){
        
        StringBuilder halfString = new StringBuilder();
        
        for (int i = start; i < message.length(); i+=2){
            halfString.append(message.charAt(i));
        }
        
        return halfString.toString();
    }
    
    
    public String decryptTwoKeys(String encrypted){
        String encrypted1 =  halfOfString(encrypted, 0);
        String encrypted2 = halfOfString(encrypted, 1);
        int firstKey = getKey(encrypted1);
        int secondKey =  getKey(encrypted2);
        System.out.println("Odd =  : "+encrypted1+" Key 1 : "+firstKey);
        System.out.println("Even : "+encrypted2 +" Key 2 : "+secondKey);
        CaesarCipher cc = new CaesarCipher();

                            
        return cc.encryptTwoKeys(encrypted,26 - firstKey,26 - secondKey);
    }
    
    public void testhalfOfString(){

       // System.out.println(decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
       // System.out.println();
       // System.out.println(decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx"));
       //
        int count = 0;
        FileResource resource = new FileResource("data/mysteryTwoKeysPractice.txt");
        // for(String s : resource.){
            // System.out.println(decryptTwoKeys(s));
            // count++;
            // if (count == 5){ break;}
        // }
         System.out.println(decryptTwoKeys(resource.asString()));
    }
    
};
