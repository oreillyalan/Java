import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numberOfPoints = 0;
        
        for (Point currPt : s.getPoints()) {
            numberOfPoints =  numberOfPoints + 1;
        }
        return numberOfPoints;
    }
    
    public double getAverageLength(Shape s) {
        double perim =  getPerimeter(s);
        int numberOfPoints =  getNumPoints(s);
        double average = perim / numberOfPoints;
        return average;
    }
    
    public double getLargestSide(Shape s) {
        double largestSide = 0;
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
           
            double currDist = prevPt.distance(currPt);
            
            if(currDist > largestSide){
                largestSide = currDist;
            }
            
            
        }
        // totalPerim is the answer
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        
        
        for (Point currPt : s.getPoints()) {
           
            if(largestX < currPt.getX()){
                largestX = currPt.getX();
            }
            
            
        }
        
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double length = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > length){
            length = getPerimeter(s);
          }
            
        }
        return length;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double perimeter = 0;
        File temp = null; 
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > perimeter){
            perimeter = getPerimeter(s);
            temp = f;
          }
            
        }
           // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberOfPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double longestSide = getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numberOfPoints);
        System.out.println("average length of the sides = " + averageLength);
        System.out.println("longest side = " + longestSide);
        System.out.println("largest x = " + getLargestX(s));
        
        
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        // pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
        // pr.testPerimeter();
        
    }
}
