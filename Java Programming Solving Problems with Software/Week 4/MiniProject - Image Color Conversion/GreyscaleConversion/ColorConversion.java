/**
 * Convert any number of images to a gray scale version by setting all color components of each pixel to the same value.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.*;

public class ColorConversion {
    //I started with the image I wanted (inImage)
    public ImageResource inverseColor(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());


            //set pixel's red to inverse of the  selected image 
            pixel.setRed(255 - inPixel.getRed());
            //set pixel's red to inverse of the  selected image 
            pixel.setGreen(255- inPixel.getBlue());
            //set pixel's red to inverse of the  selected image 
            pixel.setBlue(255 - inPixel.getGreen());
        }
        //outImage is your answer
        return outImage;
    }

    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = inverseColor(inImage);
            String fname = inImage.getFileName();
            String newName = "inverse-" + fname;
            gray.setFileName(newName);
            //gray.draw();
            gray.save();
        }
    }
    
    
    public void testInversion() {
        selectAndConvert();
    }
}


