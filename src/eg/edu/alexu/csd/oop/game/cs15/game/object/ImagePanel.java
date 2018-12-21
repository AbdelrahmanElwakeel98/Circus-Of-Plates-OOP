package eg.edu.alexu.csd.oop.game.cs15.game.object;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImagePanel extends JPanel {

  private Image image;
  private int height ;
  private int width;
  BufferedImage imageB;
  JFrame frame;
  public ImagePanel() {
    try {
		imageB=ImageIO.read(new File("res/splash.gif"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    width=imageB.getWidth();
    height=imageB.getHeight();
    image = Toolkit.getDefaultToolkit().createImage("res/splash.gif");
  }
  @Override
public int getHeight()
  {
	return height;

  }
  @Override
public int getWidth()
  {
	return width;

  }
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
      g.drawImage(image, 0, 0, this);
    }
  }
  public  void play() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        frame = new JFrame();
	        ImagePanel i =new ImagePanel();
	        frame.add(i);
	        long startTime = System.currentTimeMillis();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(i.getWidth(), i.getHeight());
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        long currentTime=System.currentTimeMillis();
	      }
	    });
	  }
  public void close()
  {
	  frame.setVisible(false);
  }

	}

