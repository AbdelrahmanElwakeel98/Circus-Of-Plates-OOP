package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImagePanel extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private int height;
	private int width;
	BufferedImage imageB;
	JFrame frame;

	public ImagePanel() {
		try {
			imageB = ImageIO.read(getClass().getResourceAsStream("/splash.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = imageB.getWidth();
		height = imageB.getHeight();
		try {
			URL url = getClass().getResource("/splash.gif");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    InputStream is = null;
		    try {
		      is = url.openStream ();
		      byte[] byteChunk = new byte[4096];
		      int n;
		      while ( (n = is.read(byteChunk)) > 0 ) {
		        baos.write(byteChunk, 0, n);
		      }
		    } catch (IOException e) {
		      e.printStackTrace ();
		    } finally {
		      if (is != null) { is.close(); }
		    }
		    byte[] imageByteArray = baos.toByteArray();
		    image = Toolkit.getDefaultToolkit().createImage(imageByteArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getHeight() {
		return height;

	}

	@Override
	public int getWidth() {
		return width;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		}
	}

	public void play() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new JFrame();
				ImagePanel i = new ImagePanel();
				frame.add(i);
				System.currentTimeMillis();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(i.getWidth(), i.getHeight());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				System.currentTimeMillis();
			}
		});
	}

	public void close() {
		frame.setVisible(false);
	}

}
