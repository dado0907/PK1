//package pixelPic;
//
///**
// * This class contains some filters, which can be applied
// * on an image.
// * 
// * 
// * @author fuchs
// *
// */
//public class Filters
//{
//	private static Lens lens = new Lens(0, 0, 0, 0);
//
//	private Filters()
//	{
//
//	}
//
//	/**
//	 * There is just one lens active (at most). Get this lens to have a look at the
//	 * original image.
//	 * 
//	 * @return
//	 */
//	public static Lens getLens()
//	{
//		return Filters.lens;
//	}
//
//	/**
//	 * Combine neighboring pixels with the average value. As a result, the number of
//	 * pixels shrinks (lower resolution). 
//	 * e.g., combine = 2; Take the average color
//	 * values of P and X pixels. Only keep P as a result.
//	 * 
//	 * P X    calculate the average (A)      A
//	 * X X    remove all pixels except P
//	 * 
//	 * e.g., combine = 3; Take the average color
//	 * values of P and X pixels. Only keep P as a result.
//	 * 
//	 * P X X   calculate the average (A)      A
//	 * X X X   remove all pixels except P
//	 * X X X
//	 * 
//	 * 
//	 * @param image   - the image to be shrunk
//	 * @param combine - how many pixels should be combined
//	 * @return the transformed image
//	 */
//	public static Image pixelMe(Image image, int combine)
//	{
//		//TODO:
//		//Implement this method (1.5 points)
//		return null;
//	}
//
//	/**
//	 * Invert the RGB values.
//	 * Use this simple algorithm to retrieve the inverted color:
//	 * R: 255 - red
//	 * G: 255 - green
//	 * B: 255 - blue
//	 * 
//	 * The alpha value is not inverted.
//	 * 
//	 * @param image - the image to be transformed.
//	 * @return the color inverted image.
//	 */
//	public static Image invertRGB(Image image)
//	{
//		//TODO:
//		//Implement this method (1 point)
//		return null;
//	}
//
//	/**
//	 * Blurr the entire image taking the box blurr algorithm. Instead of 9 pixels,
//	 * 25 pixels are used to calculate the average value of a single pixel. In case
//	 * the index is not available, the border pixels are used to come up with color
//	 * values.
//	 * e.g., for the pixel P, take the average
//	 * color values of P and all X pixels.  
//	 * X X X X X                                  A A A A A
//	 * X X X X X                                  A A A A A 
//	 * X X P X X      calculate the average (A)   A A A A A
//	 * X X X X X      and replace the pixels      A A A A A
//	 * X X X X X                                  A A A A A
//	 * 
//	 * @param image - the current image, which should be modified.
//	 * @return modified image.
//	 */
//	public static Image boxBlurr(Image image)
//	{
//		//TODO:
//		//Implement this method (2.5 points)
//		return null;
//	}
//}
package pixelPic;

import java.awt.Color;

public class Filters {
    private static Lens lens = new Lens(0, 0, 0, 0);

    private Filters() {

    }

    public static Lens getLens() {
        return Filters.lens;
    }

    public static Image pixelMe(Image image, int combine) {
        final int MIN_COMBINE = 2;
        combine = Math.max(combine, MIN_COMBINE);
        int width = image.getWidth();
        int height = image.getHeight();
        if (width == 0 || height == 0) {
            return null; // or return an empty image
        }

        int newWidth = (width + combine - 1) / combine;
        int newHeight = (height + combine - 1) / combine;

        Image newImage = new Image(newWidth, newHeight);

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                int alpha = 0;

                for (int y = 0; y < combine; y++) {
                    int posY = i * combine + y;
                    if (posY >= height) {
                        break; // Skip if posY exceeds height
                    }

                    for (int x = 0; x < combine; x++) {
                        int posX = j * combine + x;
                        if (posX >= width) {
                            break; // Skip if posX exceeds width
                        }

                        Pixel pixel = image.getPixel(posX, posY);
                        red += pixel.getRed();
                        green += pixel.getGreen();
                        blue += pixel.getBlue();
                        alpha += pixel.getAlpha();
                    }
                }

                int totalPixels = Math.min(combine * combine, (height - i * combine) * (width - j * combine));
                red /= totalPixels;
                green /= totalPixels;
                blue /= totalPixels;
                alpha /= totalPixels;
                newImage.setPixel(j, i, new Pixel(red, green, blue, alpha));
            }
        }

        return newImage;
    }

    public static Image invertRGB(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Image invertedImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel originalPixel = image.getPixel(x, y);
                int invertedRed = 255 - originalPixel.getRed();
                int invertedGreen = 255 - originalPixel.getGreen();
                int invertedBlue = 255 - originalPixel.getBlue();
                int alpha = originalPixel.getAlpha();
                invertedImage.setPixel(x, y, new Pixel(invertedRed, invertedGreen, invertedBlue, alpha));
            }
        }

        return invertedImage;
    }

    public static Image boxBlurr(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Image blurredImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int redSum = 0, greenSum = 0, blueSum = 0, alphaSum = 0;
                int boxSize = 5;

                for (int j = -boxSize / 2; j <= boxSize / 2; j++) {
                    for (int i = -boxSize / 2; i <= boxSize / 2; i++) {
                        int offsetX = x + i;
                        int offsetY = y + j;

                        if (offsetX >= 0 && offsetX < width && offsetY >= 0 && offsetY < height) {
                            Pixel originalPixel = image.getPixel(offsetX, offsetY);
                            redSum += originalPixel.getRed();
                            greenSum += originalPixel.getGreen();
                            blueSum += originalPixel.getBlue();
                            alphaSum += originalPixel.getAlpha();
                        }
                    }
                }

                int averageRed = redSum / (boxSize * boxSize);
                int averageGreen = greenSum / (boxSize * boxSize);
                int averageBlue = blueSum / (boxSize * boxSize);
                int averageAlpha = alphaSum / (boxSize * boxSize);
                blurredImage.setPixel(x, y, new Pixel(averageRed, averageGreen, averageBlue, averageAlpha));
            }
        }

        return blurredImage;
    }
}
