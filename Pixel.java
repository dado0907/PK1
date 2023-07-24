//package pixelPic;
//
//import java.awt.Color;
//
///**
// * This class represents a single pixel in an image.
// * A pixel is instantiated with an integer value.
// * This integer value must be transferred to the 
// * respective RGBA values.
// * R = red
// * G = green
// * B = blue
// * A = alpha
// * 
// * 
// * @author fuchs
// *
// */
//public class Pixel
//{
//
//	public Pixel(int value)
//	{
//		//TODO: (0.5 points)
//		//Transform the integer value in its respective RGBA representation.
//		//Please, use the following algorithm:
//		/*
//		 * Each color space (including alpha) takes up 8 bit of the integer 
//		 * in the following order:
//		 * 0–7 — First 8 bits represent blue color space.
//		 * 8–15 — The following 8 bits represent the green color space.
//		 * 16–23 — Red color space is represented by bit 16 to 23.
//		 * 24–31 — The last 8 bits represent the alpha color space which indicates 
//		 * the transparency of the pixel.
//		 * 
//		 * Bitwise operators:
//		 * The easiest method is to mask the integer and retain only the first 8 bit. 
//		 * You can do so with the & sign.
//		 * The bitwise operator >>  will shift the data bitwise to the right.
//		 * 
//		 * 
//		 * e.g., the integer value -5718215 corresponds to the following RGBA value
//		 * red:   168
//		 * green: 191
//		 * blue:   57
//		 * alpha: 255
//		 * 
//		 */
//		
//		//TODO: (0.5 points)
//		//Implement further methods as you see fit.
//	}
//	
//	/**
//	 * Get the color of this pixel.
//	 * 
//	 * @return
//	 */
//	public Color getColor()
//	{
//		//return new Color(this.red, this.green, this.blue, this.alpha);
//		return null;
//	}
//}
package pixelPic;

import java.awt.Color;

public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public Pixel(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public Color getColor() {
        return new Color(red, green, blue, alpha);
    }
}


