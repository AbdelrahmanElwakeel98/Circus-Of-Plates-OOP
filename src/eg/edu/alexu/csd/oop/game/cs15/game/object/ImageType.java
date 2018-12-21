package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ImageType implements GameObject {
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private boolean visible;
	private String path;
	private Logger log = JLogger.getLogInstance();

	public ImageType(String path) {
		this.path = path;
		this.visible = true;
		
		DynamicJarReader jar = new DynamicJarReader("C:\\Users\\abdel\\Desktop\\test4.jar");
		// create a bunch of buffered images and place into an array, to be displayed
		// sequentially
			spriteImages[0] = jar.getImage(path);

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return this.spriteImages;
	}

	public String getNameImage() {
		return this.path;
	}

}
