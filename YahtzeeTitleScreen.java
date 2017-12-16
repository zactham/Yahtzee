import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;

public class YahtzeeTitleScreen extends JApplet
{
	private ImageIcon titleScreenImage;//image

	public JButton titleScButton;//image button
	
	public void init ()
	{		

		titleScreenImage = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Yahtzee Title Screen.jpg"));//image		
		titleScButton = new JButton (titleScreenImage);//image button		
		//titleScButton.addActionListener (new ButtonPushTitleScreen(this));//when button is pressed
		Container cp = getContentPane();

		//sets the screen size
		setSize (600,400);

		//adds the image
		cp.add (titleScButton);

	}

	
}




