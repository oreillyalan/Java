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
        CSVRecord smallestSoFar = null;
        String fileName = "";
        DirectoryResource dirResource = new DirectoryResource();
        for (File file : dirResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            CSVRecord current = coldestHourInFile(fileResource.getCSVParser());
            smallestSoFar = getSmallestOfTwo(current, smallestSoFar);
            fileName=file.getName();
        }
        return fileName;
    }

    public void testFileWithColdestTemperature() {
        
        String coldestFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file "+coldestFile);
        FileResource fr = new FileResource("data/2014/"+coldestFile);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was  " + coldest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were :");
        for (CSVRecord currentRow : fr.getCSVParser()){
            System.out.println(currentRow.get("DateUTC") +
                " : " + currentRow.get("TemperatureF")) ;
        }
        
    }
}
