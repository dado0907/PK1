//package pixelPic;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.JPanel;
//
///**
// * This class visualizes the image in the paintComponent method.
// * 
// * @author fuchs
// *
// */
//public class MyPanel extends JPanel implements MouseListener, MouseMotionListener
//{
//	private static final long serialVersionUID = 1L;
//
//	private Image image;		//the current image to be shown
//	private int scale = 1; 		//default, 1 pixel for each rectangle 
//	private final int height; 	//the height of the original image
//	private final int width;	//the width of the original image
//	
//	public MyPanel(Image image)
//	{
//		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		this.image = image;
//		//TODO:
//		//should be the height of the image
//		this.height = 700;
//		//TODO:
//		//should be the width of the image
//		this.width = 700;
//		this.setPreferredSize(new Dimension(this.width, this.height));
//		
//		//important for positioning and resizing the lens
//		this.addMouseListener(this);
//		this.addMouseMotionListener(this);
//	}
//	
//	/**
//	 * Get the current image (modified or not)
//	 * @return
//	 */
//	public Image getImage()
//	{
//		return this.image;
//	}
//	
//	/**
//	 * Set the new image, which will then be painted on the JPanel
//	 * @param image
//	 */
//	public void setImage(Image image)
//	{
//		this.image = image;
//
//	}
//	
//	public void paintComponent(Graphics g)
//	{
//		super.paintComponent(g);
//		
//		//TODO:
//		//adjust the method to reflect the correct values (height, width, color).
//		
//		/*
//		 * Paint the current image.
//		 * For each pixel a colored rectangle is drawn.
//		 * The scale is important if the number of pixels are reduced (e.g., by calling "Pixel Me").
//		 * 
//		 */
//		for(int i = 0; i < 700; i++)    // 700 should be the height of the image
//		{
//			for(int j = 0; j < 600; j++)// 600 should be the width of the image
//			{
//				g.setColor(Color.red);  // should be the color of the pixel
//				if(i % 10 == 0) g.setColor(Color.white); // should be the color of the pixel
//				if(j % 10 == 0) g.setColor(Color.black); // should be the color of the pixel
//				
//				g.fillRect(j*scale, i*scale, scale, scale);
//			}
//		}
//			
//		/*
//		 * TODO:
//		 * If the lens is activated, take the original image but only show the pixels, 
//		 * which are visible through the lens.
//		 * 
//		 */
//		
//	}
//
//	//TODO:
//	//if you implement the lens, you can use these events
//	//to position and resize the lens.
//	
//	@Override
//	public void mouseClicked(MouseEvent e)
//	{
//		System.out.println("mouse click");
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e)
//	{
//		System.out.println("mouse pressed");
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e)
//	{
//		System.out.println("mouse released");
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e)
//	{
//		System.out.println("mouse enter");
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e)
//	{
//		System.out.println("mouse exit");
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent e)
//	{
//
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent e)
//	{
//		
//	}
//}
package pixelPic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private Image image;
    private int scale = 1;
    private final int height;
    private final int width;

    // Variables to handle lens positioning and resizing
    private int lensX = 0;
    private int lensY = 0;
    private int lensRadiusX = 0;
    private int lensRadiusY = 0;
    private boolean isLensActive = false;

    public MyPanel(Image image) {
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
        this.setPreferredSize(new Dimension(this.width * scale, this.height * scale));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int imageSizeX = scale; // Set default pixel size based on scale
        int imageSizeY = scale;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int posX = x * imageSizeX;
                int posY = y * imageSizeY;

                // Calculate the imageSize based on scale and remaining space
                imageSizeX = Math.min(scale, getWidth() - posX);
                imageSizeY = Math.min(scale, getHeight() - posY);

                // Check if the imageSize is still positive
                if (imageSizeX <= 0 || imageSizeY <= 0) {
                    break; // Skip if imageSize is non-positive
                }

                Pixel pixel = image.getPixel(x, y);
                g.setColor(pixel.getColor());
                g.fillRect(posX, posY, imageSizeX, imageSizeY);
            }
        }

        // If the lens is active, draw it on top of the image
        if (isLensActive) {
            int lensSizeX = lensRadiusX * 2 * scale;
            int lensSizeY = lensRadiusY * 2 * scale;
            int lensPosX = (lensX - lensRadiusX) * scale;
            int lensPosY = (lensY - lensRadiusY) * scale;

            // Calculate the lens size based on scale and remaining space
            lensSizeX = Math.min(lensSizeX, getWidth() - lensPosX);
            lensSizeY = Math.min(lensSizeY, getHeight() - lensPosY);

            // Check if the lens size is still positive
            if (lensSizeX <= 0 || lensSizeY <= 0) {
                return; // Skip drawing the lens if lens size is non-positive
            }

            g.setColor(new Color(255, 255, 255, 150));
            g.fillOval(lensPosX, lensPosY, lensSizeX, lensSizeY);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // Mouse click event handling
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Mouse press event handling
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Mouse release event handling
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Mouse enter event handling
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Mouse exit event handling
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Mouse drag event handling
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Mouse move event handling
    }
}
