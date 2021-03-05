import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyBirths {
    
    public void BabyBirths(){
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
                if (numBorn <= 100){
                    System.out.println("Name "+ rec.get(0) +
                                       " Gender "+ rec.get(1) +
                                       " Num Born "+ rec.get(2));
                }
            }
        
        }
    
    public void totalBirths(FileResource fr){
        int totalBoysNames = 0;
        int totalGirlsNames = 0;
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")){
                totalBoysNames++;
                totalBoys += numBorn;
            }
            else {
                totalGirlsNames++;
                totalGirls += numBorn;
            }
        
        }
        
        System.out.println("total girls names = " + totalGirlsNames);
        System.out.println("total boys names = " + totalBoysNames);
        System.out.println("total births = " + totalBirths);
        System.out.println("total girls births = " + totalGirls);
        System.out.println("total boys births = " + totalBoys);
    }
    
    public int compareRank(int numBorn, String filePath, String gender){
       int nameRank = 0;
       
       FileResource fr = new FileResource(filePath);
       for (CSVRecord rec : fr.getCSVParser(false)){
           
           if (rec.get(1).toUpperCase().equals(gender.toUpperCase()) &&
           numBorn == Integer.parseInt(rec.get(2))){
               nameRank++;
               

            
            }
        }
        if (nameRank == 0){
           nameRank = 1;
        }
       else {
           nameRank = nameRank + 1;
        }
       return nameRank;
    }
    
    public int getRank (int year, String name, String gender) {
        int nameRank = -1; 
        Boolean found = false;
        int count = 0;
        String filePath = "us_babynames/us_babynames_by_year/yob"+year+
        ".csv";
        // String filePath = "us_babynames/us_babynames_test/yob"+year+
         // "short.csv";
         
        FileResource fr = new FileResource(filePath);
        while (found != true) {
            for (CSVRecord rec : fr.getCSVParser(false)){
                if (rec.get(1).toUpperCase().equals(gender.toUpperCase())){ count++;}
                if (rec.get(0).toUpperCase().equals(name.toUpperCase()) 
                && rec.get(1).toUpperCase().equals(gender.toUpperCase())){
                    int numBorn = Integer.parseInt(rec.get(2));
                    nameRank = count;
                    found = true;
                }
            }
            
            found = true;
        }
        
        return nameRank;
            
    }
    
    
    public String getName (int year, int rank, String gender) {
        String name = ""; 
        Boolean found = false;
        int count = 0;
        String filePath = "us_babynames/us_babynames_by_year/yob"+year+
        ".csv";
        // String filePath = "us_babynames/us_babynames_test/yob"+year+
         // "short.csv";
         
        FileResource fr = new FileResource(filePath);
        while (found != true) {
            for (CSVRecord rec : fr.getCSVParser(false)){
                //if (rec.get(1).toUpperCase().equals(gender.toUpperCase())){ count++;}
                if (rec.get(1).toUpperCase().equals(gender.toUpperCase())){
                    count++;
                    int numBorn = Integer.parseInt(rec.get(2));
                    if (rank == count){
                        name = rec.get(0);
                    }
                    
                }
            }
            
            found = true;
        }
        
        
        if (name.isEmpty()){
        return "No Name";
        }
        
        else
            return name;
            
    }
    
    //whatIsNameInYear("Jacob ", 2014, 2012, "m");
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rankToGet = getRank(year, name, gender);
        
        if (getName(newYear, rankToGet, gender).equals("No Name")){
            System.out.println("Sorry there was a problem finding that name!");
        }else {
            System.out.println(name+" born in "+year+" would be " +
            getName(newYear, rankToGet, gender) +" if they was born in "+newYear);
        }
    }
    
    public int whatIsYear(int rank, String name, String gender){
        int year = 999999;
        DirectoryResource dirResource = new DirectoryResource();
        for (File file : dirResource.selectedFiles()) {
            
            
        
        }
        
        if (year == 9999){year = -1;}
        return year;
    }
    //String name, String gender
    //getRank(1960, "Emily", "f")
    public int yearOfHighestRank(String name, String gender){
        int rank = 999999;
        int year = -1;
        DirectoryResource dirResource = new DirectoryResource();
        for (File file : dirResource.selectedFiles()) {
            
            if (getRank(Integer.parseInt(file.getName().substring(3,7)),
            name,gender) < rank && getRank(Integer.parseInt(file.getName().substring(3,7)),
            name,gender) != -1){
                
                rank = getRank(Integer.parseInt(file.getName().substring(3,7)),
                name,gender);
                
                year = Integer.parseInt(file.getName().substring(3,7));
                
                //System.out.println("Rank: "+rank+" Year: "+ year);
            
            }

        }
        
        return year;
    }
    
   
    public double getAverageRank (String name, String gender){
        int rank = 999999;
        double rollingRank = 0.0;
        int count = 0;
        
        DirectoryResource dirResource = new DirectoryResource();
        for (File file : dirResource.selectedFiles()) {
            
            if (getRank(Integer.parseInt(file.getName().substring(3,7)),
            name,gender) != -1){
                
                rank = getRank(Integer.parseInt(file.getName().substring(3,7)),
                name,gender);
                rollingRank = rollingRank + rank;
                count++;
              
                
                //System.out.println("Rank: "+rank+" rollingRank: "+ rollingRank);
            
            }

        }
        
        if (rank == 999999){ rollingRank = -1;}
        return rollingRank/(double)count;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        //int nameRank = getRank(year,
        //        name,gender); 
        Boolean found = false;
        int count = 0;
        String filePath = "us_babynames/us_babynames_by_year/yob"+year+
         ".csv";
        //String filePath = "us_babynames/us_babynames_test/yob"+year+
         //"short.csv";
         
        FileResource fr = new FileResource(filePath);
        while (found != true) {
            for (CSVRecord rec : fr.getCSVParser(false)){
                //if (rec.get(2).toUpperCase().equals(gender.toUpperCase())){ count++;}
                
                if (rec.get(1).toUpperCase().equals(gender.toUpperCase())){
                    if (rec.get(0).toUpperCase().equals(name.toUpperCase())){break;}
                    System.out.println(""+rec.get(0).toUpperCase()
                    +" "+Integer.parseInt(rec.get(2)));
                    count = count + Integer.parseInt(rec.get(2));
                }
            }
            
            found = true;
        }
        
        return count;
            
    }
    
    public void testTotalBirths(){
        
        FileResource fr = new FileResource();
        totalBirths(fr);
        
        }
    
    public void testgetRank(){
        
        System.out.println(getRank(1960, "Emily", "f"));
        System.out.println(getRank(1971, "Frank", "m"));
    
        }
        
    public void testgetName(){
        
        System.out.println(getName(1980, 350, "f"));
        System.out.println(getName(1980, 450, "m"));
        }
        
    public void testwhatIsNameInYear(){
        
         //(String name, int year, int newYear, String gender)
        whatIsNameInYear("Susan", 1972, 2014, "f");
        whatIsNameInYear("Owen", 1974, 2014, "m");

    }
    
     public void testyearOfHighestRank(){
        
         System.out.println(yearOfHighestRank("Genevieve","f"));
         System.out.println(yearOfHighestRank("Mich","m"));

    }
    
    
    public void testgetAverageRank(){
        
         System.out.println(getAverageRank("Susan","f"));
         System.out.println(getAverageRank("Robert","m"));

    }
    
    public void testgetTotalBirthsRankedHigher(){
        //System.out.println(getTotalBirthsRankedHigher(2012, "Ethan","m"));
        //System.out.println(getTotalBirthsRankedHigher(1990, "Emily","f"));
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew","m"));
    }
}
