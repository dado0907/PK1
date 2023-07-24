//package pixelPic;
//
//import java.util.ArrayList;
//
///**
// * An Image is our internal numeric representation of the
// * image loaded into our software.
// * It consists of an ArrayList of ArrayLists to represent
// * a two-dimensional structure (x- and y-coordinates).
// * The individual entries are pixels (Pixel.java).
// * 
// * @author fuchs
// *
// */
//public class Image
//{
//	private ArrayList<ArrayList<Pixel>> content = new ArrayList<>();
//
//	//TODO: (1 point)
//	//Add methods as you see fit

//}
package pixelPic;

import java.awt.Color;
import java.util.ArrayList;

public class Image {
    private ArrayList<ArrayList<Pixel>> content = new ArrayList<>();

    public Image(int width, int height) {
        for (int y = 0; y < height; y++) {
            ArrayList<Pixel> row = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                row.add(new Pixel(255, 255, 255, 255)); // Initialize with transparent white color
            }
            content.add(row);
        }
    }

    public int getWidth() {
        return content.get(0).size();
    }

    public int getHeight() {
        return content.size();
    }

    public Pixel getPixel(int x, int y) {
        return content.get(y).get(x);
    }

    public void setPixel(int x, int y, Pixel pixel) {
        content.get(y).set(x, pixel);
    }

    public Image clone() {
        Image clonedImage = new Image(getWidth(), getHeight());
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                clonedImage.setPixel(x, y, getPixel(x, y));
            }
        }
        return clonedImage;
    }
}
