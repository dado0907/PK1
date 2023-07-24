//package pixelPic;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//
///**
// * This class handles the interactions of the user with the software.
// * 
// * For the project, there is no need to change anything.
// * 
// * However, you are allowed to modify the code if it helps you solving
// * the tasks.
// * 
// * @author fuchs
// *
// */
//public class ButtonClick implements ActionListener
//{
//
//	private JButton button;
//	private MyPanel content;
//	Screen screen;
//	
//	public ButtonClick(JButton button, Screen screen)
//	{
//		this.button = button;
//		this.content = screen.content;
//		this.screen = screen;
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e)
//	{
//		/*
//		 * Distinguish between the different buttons.
//		 * Apply the same procedure:
//		 * Remove content.
//		 * Modify content.
//		 * Repaint.
//		 */
//		
//		//click the button to show the original image
//		if(button.getText().equals("Original"))
//		{
//			System.out.println("Original");
//			content.removeAll();
//			content.setImage(Screen.getImage());
//		}
//		//click the button to invert the color
//		else if(button.getText().equals("Inverted"))
//		{
//			System.out.println("Inverted");
//			content.removeAll();
//			Image image = Filters.invertRGB(content.getImage());
//			content.setImage(image);
//		}
//		//click the button to blurr the image
//		else if(button.getText().equals("Blurred"))
//		{
//			System.out.println("Blurred");
//			content.removeAll();
//			Image image = Filters.boxBlurr(content.getImage());
//			content.setImage(image);
//		}
//		//click the button to lower the resolution
//		else if(button.getText().equals("Pixel Me"))
//		{
//			System.out.println("Pixel Me");
//			content.removeAll();
//			Image image = Filters.pixelMe(content.getImage(), 2);
//			content.setImage(image);		
//		}
//		//click the button to activate the lens
//		else if(button.getText().equals("Lens ON") || button.getText().equals("Lens OFF"))
//		{
//			//What happens when the lens is inactive and you press the button.
//			if(!Filters.getLens().isActive())
//			{
//				System.out.println("Lens active");
//				Filters.getLens().setCX(200);
//				Filters.getLens().setCY(150);
//				Filters.getLens().setRadiusX(70);
//				Filters.getLens().setRadiusY(70);
//				Filters.getLens().activate();
//				
//				button.setText("Lens OFF");
//			}
//			//What happens when the lens is active and you press the button.
//			else
//			{
//				System.out.println("Lens inactive");
//				Filters.getLens().setCX(0);
//				Filters.getLens().setCY(0);
//				Filters.getLens().setRadiusX(0);
//				Filters.getLens().setRadiusY(0);
//				Filters.getLens().deactivate();
//				
//				button.setText("Lens ON");
//			}
//		}
//		content.repaint();
//	}
//
//}
package pixelPic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonClick implements ActionListener {
    private JButton button;
    private MyPanel content;
    private Screen screen;

    public ButtonClick(JButton button, Screen screen) {
        this.button = button;
        this.content = screen.content;
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementation for button click actions
        // Get the current image from the MyPanel
        Image currentImage = content.getImage();

        // Determine which button was clicked and apply the corresponding filter
        if (button.getText().equals("Original")) {
            System.out.println("Original");
            // Show the original image
            content.setImage(Screen.getImage());
        } else if (button.getText().equals("Inverted")) {
            System.out.println("Inverted");
            // Invert the colors and set the modified image
            Image invertedImage = Filters.invertRGB(currentImage);
            content.setImage(invertedImage);
        } else if (button.getText().equals("Blurred")) {
            System.out.println("Blurred");
            // Apply the box blur and set the modified image
            Image blurredImage = Filters.boxBlurr(currentImage);
            content.setImage(blurredImage);
        } else if (button.getText().equals("Pixel Me")) {
            System.out.println("Pixel Me");
            // Shrink the image and set the modified image
            Image pixelMeImage = Filters.pixelMe(currentImage, 2);
            content.setImage(pixelMeImage);
        } else if (button.getText().equals("Lens ON") || button.getText().equals("Lens OFF")) {
            // Toggle the lens ON/OFF and set the modified image with the lens effect
            if (!Filters.getLens().isActive()) {
                System.out.println("Lens active");
                Filters.getLens().setCX(200); // Set lens center X coordinate
                Filters.getLens().setCY(150); // Set lens center Y coordinate
                Filters.getLens().setRadiusX(70); // Set lens X radius
                Filters.getLens().setRadiusY(70); // Set lens Y radius
                Filters.getLens().activate();

                button.setText("Lens OFF");
            } else {
                System.out.println("Lens inactive");
                Filters.getLens().deactivate();

                button.setText("Lens ON");
            }
        }

        // Repaint the MyPanel to show the modified image
        content.repaint();
    }
}

