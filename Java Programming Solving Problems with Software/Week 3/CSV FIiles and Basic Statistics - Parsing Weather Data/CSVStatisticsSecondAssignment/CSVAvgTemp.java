import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVAvgTemp {
    
    public double averageTemperatureInFile(CSVParser parser) {
        //CSVRecord smallestSoFar = null;
        double totalTemp = 0.0;
        int count = 0;
        
        for (CSVRecord currentRow : parser) {
            totalTemp += Double.parseDouble(currentRow.get("TemperatureF"));
            count++;
           
        }
       
        
        return totalTemp/count;
    }
    

    public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value) {

        double totalTemp = 0.0;
        int count = 0;
        
        for (CSVRecord currentRow : parser) {
          if(currentRow.get("Humidity").contains("N/A")){
                continue;
            }
            if (Double.parseDouble(currentRow.get("Humidity")) >= value){
            totalTemp += Double.parseDouble(currentRow.get("TemperatureF"));
            count++;
          }
        }
       
        if (count == 0){
            return count;
        }
        else {
            return totalTemp/count;
        }
    }
    
    

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "
        +averageTemperatureInFile(fr.getCSVParser()));
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        double result = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if (result != 0){
            System.out.println("Average Temp over the selected Humidity is "
            +result);
        }
        else {
        System.out.println("No temperatures with that humidity");
    }
    }

}
