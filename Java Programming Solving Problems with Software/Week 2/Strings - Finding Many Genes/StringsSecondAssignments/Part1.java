

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currentIndex = 0;
        
        if (startIndex!=-1 &&  dna.indexOf(stopCodon, startIndex+3)!=-1){
            
            if (dna.substring(startIndex, dna.indexOf(stopCodon, startIndex+3)).length() % 3 == 0){
                return dna.indexOf(stopCodon, startIndex+3);
                
            }  else {
                return dna.length();
            }
        
        }  else {
            return dna.length();
        }
    }
    
   
    public String findGene (String dna) {
        int startIndex = dna.indexOf("ATG");
        int stopIndex = 0;
        
        if(startIndex == -1){
            
            return "";
        }
        else {
            stopIndex = Math.min(findStopCodon(dna, dna.indexOf("ATG"), "TAA"),Math.min(
            findStopCodon(dna, dna.indexOf("ATG"), "TAG"), findStopCodon(dna, dna.indexOf("ATG"), "TGA")) );
            if (stopIndex == dna.length()){
                return "";
            }
            else {
                return dna.substring(startIndex, stopIndex+3);
            }        
       }
    }
    
    public void printAllGenes (String dna){
        int startIndex = dna.indexOf("ATG");
        int stopIndex = 0;
        
       while (true) {
        if(startIndex == -1){
            break;
        }
        else {
            stopIndex = Math.min(findStopCodon(dna, startIndex, "TAA"),Math.min(
            findStopCodon(dna, startIndex, "TAG"), findStopCodon(dna, startIndex, "TGA")) );
            if (stopIndex == dna.length()){
                startIndex =-1;
            }
            else {
                System.out.println(dna.substring(startIndex, stopIndex+3));
                startIndex = dna.indexOf("ATG", stopIndex+3);
            }        
       }
    }
    
    }

    public void testFindStopCodon (){      
        String testString = "AATGATATTATGGTGA";
        System.out.println(findStopCodon(testString, testString.indexOf("ATG")
                                   ,"TAG"));
        System.out.println(findStopCodon(testString, testString.indexOf("ATG")
                                   ,"TAA"));
        System.out.println(findStopCodon(testString, testString.indexOf("ATG")
                                   ,"TGA"));
    }

    public void testFindGene  (){      
        System.out.println("The DNA strand was AATGATATAAGGGTGAA and it contained the gene : "
        +findGene("AATGATATAAGGGTGAA"));
        System.out.println("The DNA strand was AATGATAATAGGGTGAA and it contained the gene : "
        +findGene("AATGATAATAGGGTGAA"));
        System.out.println("The DNA strand was AATTATAATAGGGTGA and it contained the gene : "
        +findGene("AATTATAATAGGGTGA"));
        System.out.println("The DNA strand was AATGATATTATGGTGA and it contained the gene : "
        +findGene("AATGATATTATGGTGA"));
        System.out.println("The DNA strand was AATGATATTATGGTGG and it contained the gene : "
        +findGene("AATGATATTATGGTGG"));
        
    }
    
    public void testprintAllGenes  (){      
        
        System.out.println("The DNA strand was AATGATAATAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGA and it contained the gene : ");
        printAllGenes("AATGATAATAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGA");
        System.out.println("The DNA strand was AATTATAATAGGGTGAAATTATAATAGGGTGAAATTATAATAGGGTGA and it contained the gene : ");
        printAllGenes("AATTATAATAGGGTGAAATTATAATAGGGTGAAATTATAATAGGGTGA");
        System.out.println("The DNA strand was AATGATATTATGGTGAAATGATATTATGGTGAAATGATATAATGGTGA and it contained the gene : ");
        printAllGenes("AATGATATTATGGTGAAATGATATTATGGTGAAATGATATAATGGTGA");
        System.out.println("The DNA strand was AATGATATTATGGTGGAATGATATTATGGTGGAATGATATTATGGTGG and it contained the gene : ");
        printAllGenes("AATGATATTATGGTGGAATGATATTATGGTGGAATGATATTATGGTGG");
        System.out.println("The DNA strand was AATGATATAAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGAAATGATATTATGGTGAAATGATATTATGGTGG and it contained the gene : ");
        printAllGenes("AATGATATAAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGAAATGATATTATGGTGAAATGATATTATGGTGG");

    }
}
