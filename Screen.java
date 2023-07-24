//package pixelPic;
//
//import java.awt.BorderLayout;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///**
// * This class is representing the GUI.
// * For the project, there is no need to change anything
// * in this class except for your name (check the TODO).
// * 
// * However, you are allowed to modify the code if it helps you solving
// * the tasks.
// * @author fuchs
// *
// */
//public class Screen extends JFrame 
//{
//	private static final long serialVersionUID = 1L;
//	private static Image image;
//	
//	public MyPanel content;
//	
//	/**
//	 * Taking the image to be represented as an ArrayList of ArrayLists (x and y coordinates).
//	 * Each entry contains a pixel, which encodes the RGB values and alpha value separately. 
//	 * Each pixel should then be represented as a colored rectangle.
//	 * 
//	 * @param image
//	 * @param scale - the size of each rectangle
//	 */
//	public Screen(Image image) 
//	{
//		//TODO:
//		//Please, enter your name here:
//		super("PK1 Project - Johannes Fuchs");
//		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(500, 500);
//		Screen.image = image;
//		
//		//Create the root panel of the GUI.
//		JPanel root = new JPanel();
//		root.setLayout(new BorderLayout());
//		
//		//position the image
//		this.content = new MyPanel(image);
//		root.add(content, BorderLayout.CENTER);
//		
//		//position the controls
//		JPanel controls = new JPanel();
//		controls.setLayout(new BoxLayout(controls, BoxLayout.LINE_AXIS));
//		root.add(controls, BorderLayout.PAGE_START);
//		
//		//position Buttons in the controls
//		JButton original = new JButton("Original");
//		JButton inverted = new JButton("Inverted");
//		JButton blurred = new JButton("Blurred");
//		JButton pixel = new JButton("Pixel Me");
//		JButton lens = new JButton("Lens ON");
//		
//		controls.add(original);
//		controls.add(inverted);
//		controls.add(blurred);
//		controls.add(pixel);
//		controls.add(lens);
//		
//		//ActionListeners are added to the buttons to allow for interactivity.
//		original.addActionListener(new ButtonClick(original, this));
//		inverted.addActionListener(new ButtonClick(inverted, this));
//		blurred.addActionListener(new ButtonClick(blurred, this));
//		pixel.addActionListener(new ButtonClick(pixel, this));
//		lens.addActionListener(new ButtonClick(lens, this));
//		
//		this.add(root);
//		this.pack();
//		this.setVisible(true);
//	}
//	
//	/**
//	 * This method returns the current image.
//	 * 
//	 * @return
//	 */
//	public static Image getImage()
//	{
//		return Screen.image;
//	}
//}
package pixelPic;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame {
    private static final long serialVersionUID = 1L;
    private static Image image;
    public MyPanel content;

    public Screen(Image image) {
        super("PK1 Project - David Durasin");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        Screen.image = image;
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        this.content = new MyPanel(image);
        root.add(content, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        controls.setLayout(new BoxLayout(controls, BoxLayout.LINE_AXIS));
        root.add(controls, BorderLayout.PAGE_START);
        JButton original = new JButton("Original");
        JButton inverted = new JButton("Inverted");
        JButton blurred = new JButton("Blurred");
        JButton pixel = new JButton("Pixel Me");
        JButton lens = new JButton("Lens ON");
        controls.add(original);
        controls.add(inverted);
        controls.add(blurred);
        controls.add(pixel);
        controls.add(lens);
        original.addActionListener(new ButtonClick(original, this));
        inverted.addActionListener(new ButtonClick(inverted, this));
        blurred.addActionListener(new ButtonClick(blurred, this));
        pixel.addActionListener(new ButtonClick(pixel, this));
        lens.addActionListener(new ButtonClick(lens, this));
        this.add(root);
        this.pack();
        this.setVisible(true);
    }

    public static Image getImage() {
        return Screen.image;
    }
}
