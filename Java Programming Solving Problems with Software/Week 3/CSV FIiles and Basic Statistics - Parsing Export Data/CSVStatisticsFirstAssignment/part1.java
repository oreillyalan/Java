import org.apache.commons.csv.*;
import edu.duke.*;

public class part1 {

    public void tester() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       System.out.println(countryInfo(parser,"Nauru"));
       parser = fr.getCSVParser();
       // System.out.println(countryInfo(parser,"China"));
       // parser = fr.getCSVParser();
       // System.out.println(countryInfo(parser,"Peru"));
       // parser = fr.getCSVParser();
       // listExportersTwoProducts(parser, "gold","diamonds");
       // parser = fr.getCSVParser();
       // listExportersTwoProducts(parser, "zinc","tin");
       // parser = fr.getCSVParser();
       // System.out.println(numberOfExporters(parser, "gold"));
       // parser = fr.getCSVParser();
       // System.out.println(numberOfExporters(parser, "zinc"));
       // parser = fr.getCSVParser();
       // System.out.println(numberOfExporters(parser, "sugar"));
       // parser = fr.getCSVParser();
       bigExporters(parser, "$999,999,999,999”");
       parser = fr.getCSVParser();
    }
    
    
    public String countryInfo (CSVParser parser,String country) {
        
        for (CSVRecord record : parser){
            if (record.get("Country").contains(country)){
                return record.get("Country")+" : "+record.get("Exports")+" : "+record.get("Value (dollars)");
            }
        }
        
        
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts  (CSVParser parser,String exportItem1,String exportItem2) {
        
        for (CSVRecord record : parser){
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
        
        
    }
    
    public int numberOfExporters (CSVParser parser,String exportItem) {
        int countOfExporters = 0;
        for (CSVRecord record : parser){
            if (record.get("Exports").contains(exportItem)){
                countOfExporters++;
            }
        }
        
        
        return countOfExporters;
    }

    public void bigExporters(CSVParser parser,String amount ) {
        
        for (CSVRecord record : parser){
            if (record.get("Value (dollars)").length() > amount.length()){
                System.out.println(record.get("Country") + " : "+record.get("Value (dollars)"));
            }
        }
        
        
    }
}
