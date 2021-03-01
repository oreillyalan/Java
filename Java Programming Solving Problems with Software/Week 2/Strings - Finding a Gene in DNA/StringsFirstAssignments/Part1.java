
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna) {
        String gene = "Not a Gene";
        String tempGene = "";
        String startCodon = "ATG";
        String stopCodon = "TAA";
      
        
        if (dna.indexOf(startCodon) != -1 
        && dna.indexOf(stopCodon,(dna.indexOf(startCodon)+3)) !=-1 ) {
            tempGene = dna.substring(dna.indexOf(startCodon), 
            dna.indexOf(stopCodon,(dna.indexOf(startCodon)+3))+3 );
         if ((tempGene.length() % 3)==0){
             gene = tempGene;
            }
        
        }
        
        return gene;
        
    }

    public void testSimpleGene() {
        System.out.println(findSimpleGene("ATGAGTTATTAGTAA"));
        System.out.println(findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC"));
        System.out.println(findSimpleGene("AAATGCCCTAAA"));
        System.out.println(findSimpleGene("TGAAGTGATTAGTAA"));
        System.out.println(findSimpleGene("ATGAGTGATTAGAAT"));
        System.out.println(findSimpleGene("TGAAGTGATTAGAAT"));
        System.out.println(findSimpleGene("ATGAGTGATTAGGTAA"));
    }

}
