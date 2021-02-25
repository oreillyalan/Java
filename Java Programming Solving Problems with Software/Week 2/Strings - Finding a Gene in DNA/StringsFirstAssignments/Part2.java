

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String gene = "Not a Gene";
        String tempGene = "";


        if (dna.equals(dna.toLowerCase())){
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        else if (dna.equals(dna.toUpperCase())) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        
        
        if (dna.indexOf(startCodon) != -1 
        && dna.indexOf(stopCodon,(dna.indexOf(startCodon)+3)) !=-1 ) {
            tempGene = dna.substring(dna.indexOf(startCodon), 
            (dna.indexOf(stopCodon,(dna.indexOf(startCodon)+3))+3) );
         if ((tempGene.length() % 3)==0){
             gene = tempGene;
            }
        
        }
        
        return gene;
    }

    public void testSimpleGene() {
        System.out.println(findSimpleGene("ATGAGTTATTAGTAA", "ATG", "TAA"));
        System.out.println(findSimpleGene("ATGAGTAAATTAGTAA", "ATG", "TAA"));
        System.out.println(findSimpleGene("TGAAGTGATTAGTAA", "ATG", "TAA"));
        System.out.println(findSimpleGene("ATGAGTGATTAGAAT", "ATG", "TAAA"));
        System.out.println(findSimpleGene("TGAAGTGATTAGAAT", "ATG", "TAA"));
        System.out.println(findSimpleGene("ATGAGTGATTAGGTAA", "ATG", "TAA"));
        System.out.println(findSimpleGene("ATGGGTTAAGTC", "ATG", "TAA"));
        System.out.println(findSimpleGene("gatgctataat", "ATG", "TAA"));
    }
}
