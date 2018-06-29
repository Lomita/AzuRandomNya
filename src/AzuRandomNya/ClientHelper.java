package AzuRandomNya;

import java.awt.*;
import javax.swing.*;

/**
 * Client Helper class
 * @author Miruku
 * contains functions for guis
 */
public class ClientHelper
{
	/**
	 * Get image from path
	 * @param path
	 * @return image
	 */
	public ImageIcon loadImg(String path)
	{	
		ImageIcon img = new ImageIcon(getClass().getResource(path));;
		return img;
	} 
	
	/**
	 * Get the screen resolution
	 * @return screen size
	 */
	public Dimension getScreenResolution()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize; 
	}
}