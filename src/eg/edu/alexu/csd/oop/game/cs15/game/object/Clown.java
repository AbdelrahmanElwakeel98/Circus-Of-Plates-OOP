package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {

	private int x, y;
	private boolean visible;
	private String path;
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	
	public Clown(int x, int y, String path){
		this.x = x;
		this.y = y;
		this.visible = true;
		
		// create a bunch of buffered images and place into an array, to be displayed sequentially
				try {
					spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
		
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public void setX(int x) {
		this.x = x;

	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getWidth() {
		return this.spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return this.spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return this.spriteImages;
	}

}
