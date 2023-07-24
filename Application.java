//package pixelPic;
//
//import java.io.File;
//
///**
// * This class is the entry point of the project.
// * 
// * In this project, you can score 10 points.
// * Keep the current style guidelines in mind. 
// * If violated, there will be a reduction of max 2 points.
// * 
// * @author fuchs
// *
// */
//public class Application
//{
//
//	public static void main(String[] args)
//	{
//		//Overview:
//		/*
//		 * Task1: Image.java      (1 point)
//		 * The Image.java class is the internal representation of the image.
//		 * Your task is to add appropriate methods to this class.
//		 * 
//		 * Task2: Pixel.java      (1 point)
//		 * The Pixel.java class represents one individual pixel. Each pixel
//		 * consists of RGBA (red, green, blue, alpha) values.
//		 * Your task is to add appropriate methods to this class.
//		 * 
//		 * Task3: Filters.java    (5 points)
//		 * The Filters.java class contains all available filters.
//		 * Your task is to implement those filters.
//		 * 
//		 * Task4: ReadImage.java  (2 points)
//		 * The ReadImage.java class is responsible for loading the image.
//		 * Your task is to manage this data loading to finally retrieve an
//		 * instance of Image.java class.
//		 * 
//		 * Task5: Lens.java 	  (1 point)
//		 * The Lens.java class is a special filter. The lens can be resized and
//		 * moved around on the image. The purpose of the lens is to show the
//		 * original pixels of the image without any filters applied.
//		 * 
//		 */
//		
//		File file = ReadImage.loadFile("url");
//		
//		//TODO:
//		/* ReadImage.java
//		 * As input you can decide to read an image (e.g., *.png),
//		 * or a csv file. If you are working with the image, you
//		 * can score 2 points (ReadImage.java), if you decide to 
//		 * work with the csv file, you can only score 1 point (ReadImage.java).
//		 * If you are just loading the dummy data, you can only score
//		 * 0.5 points.
//		 * 
//		 * Only one option will be graded!
//		 */
//		Image image = null;
//		//Implement this method (2/2 points) to work with an image
//			//Image image = ReadImage.readFileImage(file);
//		
//		//Implement this method (1/2 points) to work with a csv file
//			//Image image = ReadImage.readFileData(file);
//		
//		//Implement this method (0.5/2 points) to work with dummy data
//			//Image image = ReadImage.createImageFromDummyData();
//		
//		
//		//start building the GUI.
//		new Screen(image);
//	}
//}
package pixelPic;

import java.io.File;

public class Application 
{

    public static void main(String[] args) 
    {
       String url = "src" + File.separator + "pixelPic" + File.separator + "illusion.png";
       File file = ReadImage.loadFile(url);
       Image image = ReadImage.readFileImage(file);
       if(image != null)
    	   {
    	   		new Screen(image);
    	   }
    }
}