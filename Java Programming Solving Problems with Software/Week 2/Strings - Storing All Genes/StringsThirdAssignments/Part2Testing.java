
/**
 * Write a description of Part2Testing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2Testing {
    
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
   
    

        public void printAllGenes (String dna){
        dna = dna.toUpperCase();
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
    
    public void testprintAllGenes  (){      
        

        printAllGenes("oneAtGMyGeneOneAATGGGGTAATGATAGAACCCGGYGGGGTAGGGCTGCCCATGendOneTAAnonCodingDnaTAGTGAZZZtaaTwoATGMyGeneTwoCATGGGGTAATGATAGCCatgCCCFalseStartTAATGATGendTwoTAGnonCodingDNATAACCCThreeATGMyGeneThreeATGGGGTAATGATAGATGccendThreeTAAnonCodingDNAccTAAfalsecccFourATGMyGeneFourATGGGGTAATGATAGCendFourTAGnonCodingdnaFiveAtgMyGeneFiveATGGGGTAATGATAGCendFiveTGAnonCodingdnaSixATGmyGeneSixATATGGGGTAATGATAGAendSixTAAnoncodingdnaSevenATGMyGeneSevenCcATGGGGTAATGATAGendSeventaAnoncodingdnaEightATGmyGeneEightATGGGGTAATGATAGGGendEighttaAnoncodingdnaCcccWrongtgaCtaaCtagCCcgNineATgmyGeneNineATGGGGTAATGATAGTaaAendNineTAAnonCodingDnaCcccTenATGmyGeneTenGATGGGGTAATGATAGCCHasFakeATGFAKEatgcendTentaanonCodingDnaCtagCtganonCodingDnaxxxElevenATGmyGeneElevenCATGGGGTAATGATAGTAAxxGeneATGTAACATGTAAATGCendElevenTAAnonCodingDnaxTAGxtgaTwelveATGmyGeneTwelveCATGGGGTAATGATAGCTheLastGeneIsATGTAGendTwelvetgaATGTAG");


    }
    
    

}
