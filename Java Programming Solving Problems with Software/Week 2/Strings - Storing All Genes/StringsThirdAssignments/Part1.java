import edu.duke.*;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currentIndex = dna.indexOf(stopCodon, startIndex+3);
        
        while (currentIndex !=-1){
            if ((currentIndex - startIndex) % 3 == 0){
                return currentIndex;
            }
            else {
            
                currentIndex = dna.indexOf(stopCodon, currentIndex+1);
            
            }

        }   
        return dna.length();
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
    
    public StorageResource getAllGenes (String dna){
        int startIndex = dna.indexOf("ATG");
        int stopIndex = 0;
        StorageResource fr = new StorageResource();
        
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
                fr.add(dna.substring(startIndex, stopIndex+3));
                startIndex = dna.indexOf("ATG", stopIndex+3);
            }        
       }
    }
      return fr;
    }
    
    public double cgRatio(String dna) {
        int startCIndex = dna.indexOf("C");
        int startGindex = dna.indexOf("G");
        double cgCount = 0;
       while (true) {
           
           while (true) {
           if(startCIndex == -1){
            break;
           }
           else {
           cgCount++;
           startCIndex = dna.indexOf("C", startCIndex+1);
            }
        }
        if(startGindex == -1){
            break;
           }
        else {
           cgCount++;
           startGindex = dna.indexOf("G", startGindex+1);
            }        
       }
    
        return cgCount/(double)dna.length();
    }
    
    public int countCTG (String dna) {
        int startIndex = dna.indexOf("CTG");
        int ctgCount = 0;
        
        
        while (true) {
           if(startIndex == -1){
            break;
           }
           else {
           ctgCount++;
           startIndex = dna.indexOf("CTG", startIndex+3);
            }
        }
        return ctgCount;
   }
   
   public void processGenes(StorageResource sr){
    int countOver60 = 0;
    int  cgRatioCount = 0; 
    int largestGene = 0;
    String longestGene = "";
    System.out.println("These are the geneses longer than 60 characthers : ");
    for (String item : sr.data()) {
            if (item.length() > 0 )
            {
                System.out.println(""+item);
                countOver60++;
            }
        }
    System.out.println("That makes "+countOver60+" total.");
    
    System.out.println("These are the genes that have a CG Ration > .35 : ");
    for (String item : sr.data()) {
            if (cgRatio(item) > 0.35 )
            {
                System.out.println(""+item);
                cgRatioCount++;
            }
        }
    System.out.println("That makes "+cgRatioCount+" total.");
    for (String item : sr.data()) {
        largestGene= Math.max(largestGene, item.length());
        longestGene= item;
        
    }
    System.out.println("The  longest gene is "+longestGene);
    System.out.println();
    
    } 
   
   public void testprocessGenes (){ 
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        processGenes(getAllGenes(dna.toUpperCase()));
        // processGenes(getAllGenes("AATGATAATATGAAAATGATAATAGGGTGAAAATTATAATAGGGTGA"));
        // processGenes(getAllGenes("AATGATAATAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGACTGCTTGCTTGCTTGCTTG"));
        // processGenes(getAllGenes("AATGATAATAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGACTGCTTGCTTGCTTGCTTGATGATAATCCGGGCAGGGTGA"));
        // processGenes(getAllGenes("AATGATAATAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGACTGCTTGCTTGCTTGCTTGATGATAATCCGGGCAGGGTGA"));
    } 

   public void testCountCTG (){ 
        System.out.println(""+countCTG("CTGCTTGCTTGCTTGCTTG"));
    }
    
   public void testcgRatio (){ 
        System.out.println(""+cgRatio("ATGCCATAG"));
    }
    
    public void testgetAllGenes (){      
        // System.out.println("The DNA strand was AATGATAATAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGA and it contained the gene : ");
        System.out.println("The DNA strand was AATTATAATAGGGTGAAATTATAATAGGGTGAAATTATAATAGGGTGA and it contained the gene : "+" "+ 
        getAllGenes("AATTATAATAGGGTGAAATTATAATAGGGTGAAATTATAATAGGGTGA"));
        System.out.println("The DNA strand was AATGATATTATGGTGAAATGATATTATGGTGAAATGATATAATGGTGA and it contained the gene : "+" "+  
        getAllGenes("AATGATATTATGGTGAAATGATATTATGGTGAAATGATATAATGGTGA"));
        System.out.println("The DNA strand was AATGATATTATGGTGGAATGATATTATGGTGGAATGATATTATGGTGG and it contained the gene : "+" "+ 
        getAllGenes("AATGATATTATGGTGGAATGATATTATGGTGGAATGATATTATGGTGG"));
        System.out.println("The DNA strand was AATGATATAAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGAAATGATATTATGGTGAAATGATATTATGGTGG and it contained the gene : "+" "+ 
        getAllGenes("AATGATATAAGGGTGAAAATGATAATAGGGTGAAAATTATAATAGGGTGAAATGATATTATGGTGAAATGATATTATGGTGG"));

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
