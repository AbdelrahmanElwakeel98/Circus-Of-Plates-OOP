package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {

	private int x, y;
	private boolean visible;
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private Logger log = JLogger.getLogInstance();

	public Clown(int width, int height, String path) {
		this.visible = true;
		// create a bunch of buffered images and place into an array, to be displayed
		// sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
			this.x = width / 2;
			this.y = height - spriteImages[0].getHeight() - 5;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getX() {
		log.info("getX Clown");
		return this.x;
	}

	@Override
	public void setX(int x) {
		log.info("setX Clown");
		this.x = x;

	}

	@Override
	public int getY() {
		log.info("getY Clown");
		return this.y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		log.info("setY Clown");
	}

	@Override
	public int getWidth() {
		// System.out.println( "W "+this.spriteImages[0].getHeight());
		log.info("getWidth Clown");
		return this.spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		log.info("getHeight Clown");
		return this.spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		log.info("BufferdImage Clown");
		return this.spriteImages;
	}

}
