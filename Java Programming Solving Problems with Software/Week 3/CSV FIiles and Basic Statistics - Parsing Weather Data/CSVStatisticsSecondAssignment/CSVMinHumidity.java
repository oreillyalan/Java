import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMinHumidity {
    
        public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar) {
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentHumid = Double.parseDouble(currentRow.get("Humidity"));
            double smallestHumid = Double.parseDouble(smallestSoFar.get("Humidity"));
            //Check if currentRow’s temperature > largestSoFar’s
            if (currentHumid < smallestHumid) {
                //If so update largestSoFar to currentRow
                smallestSoFar = currentRow;
            } else if (currentHumid == currentHumid) {
                smallestSoFar = smallestSoFar;
            } 
        }
        return smallestSoFar;
    }

    public CSVRecord lowestHumidityInFile (CSVParser parser) {
       CSVRecord smallestSoFar = null;
        
        for (CSVRecord currentRow : parser) {
            if(currentRow.get("Humidity").contains("N/A")){
                continue;
            }
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        }
       
        
        return smallestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles () {
        CSVRecord smallestSoFar = null;
        DirectoryResource dirResource = new DirectoryResource();
        for (File file : dirResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            CSVRecord current = lowestHumidityInFile(fileResource.getCSVParser());
            smallestSoFar = getSmallestOfTwo(current, smallestSoFar);
        }
        return smallestSoFar;
    }
    
    public void testLowestHumidityInManyFiles() {
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowest.get("Humidity") +
                " at " + lowest.get("DateUTC"));
    }
    
     public void testLowestHumidityInDay() {
        FileResource fr = new FileResource();
        CSVRecord coldest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest Humidity was " + coldest.get("Humidity") +
                " at " + coldest.get("DateUTC"));
    }
}
