import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMin {
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar) {
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            //Check if currentRow’s temperature > largestSoFar’s
            if (currentTemp < smallestTemp) {
                //If so update largestSoFar to currentRow
                smallestSoFar = currentRow;
            } else if (currentTemp == smallestTemp) {
                smallestSoFar = currentRow;
            } 
        }
        return smallestSoFar;
    }

    public CSVRecord coldestHourInFile (CSVParser parser) {
        CSVRecord smallestSoFar = null;
        
        for (CSVRecord currentRow : parser) {
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        }
        //The largestSoFar is the answer
        
        return smallestSoFar;
    }

    
     public void testColdestInDay() {
        FileResource fr = new FileResource("data/2014/weather-2014-01-08.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + coldest.get("TemperatureF") +
                " at " + coldest.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature () {
        String currentFile = "";
        CSVRecord smallestSoFar = null;
        String coldestFileName = "";
        String fileName = "";
        DirectoryResource dirResource = new DirectoryResource();
        for (File file : dirResource.selectedFiles()) {
            currentFile = file.getName();
            FileResource fileResource = new FileResource(file);
            CSVRecord current = coldestHourInFile(fileResource.getCSVParser());
            if (Double.parseDouble(current.get("TemperatureF")) == -9999){
                continue;
            }
            smallestSoFar = getSmallestOfTwo(current, smallestSoFar);
            
            if (smallestSoFar.get("DateUTC") ==
            current.get("DateUTC") ) {
                coldestFileName = file.getName();
            }
            
            // fileName+=current.get("TemperatureF")+" "+current.get("DateUTC")+" "+file.getName()+
            // ": Coldest Temp so Far: "+smallestSoFar.get("TemperatureF")+" "+smallestSoFar.get("DateUTC")+   " on "+coldestFileName +"\r\n";
            
                        
            // fileName+=current.get("TemperatureF")+" "+file.getName()+
            // ": Coldest Temp so Far: "+smallestSoFar.get("TemperatureF")+" on "+coldestFileName +"\r\n";
            
            
        }
        return coldestFileName;
    }

    public void testFileWithColdestTemperature() {
        // System.out.println(fileWithColdestTemperature());
        String coldestFile = fileWithColdestTemperature();
        String year = coldestFile.substring(8, 12);
        System.out.println("Coldest day of the "+year+" was in file "+ coldestFile);
        FileResource fr = new FileResource("data/"+year+"/"+coldestFile);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was  " + coldest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were :");
        for (CSVRecord currentRow : fr.getCSVParser()){
            System.out.println(currentRow.get("DateUTC") +
                " : " + currentRow.get("TemperatureF")) ;
        }
        
    }
}
