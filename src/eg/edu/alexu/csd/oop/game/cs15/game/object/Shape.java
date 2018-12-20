package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Shape implements GameObject {
	private int x, y;
	private boolean visible;
	private ImageType ballType;
	private State s;

	public Shape(int x, int y, ImageType ballType) {
		this.x = x;
		this.y = y;
		this.visible = true;
		this.ballType = ballType;
		this.s = new MovingState();
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
		if (s.Statename())
			this.y = y;
	}

	@Override
	public int getWidth() {
		return this.ballType.getSpriteImages()[0].getWidth();
	}

	@Override
	public int getHeight() {
		return this.ballType.getSpriteImages()[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return this.ballType.getSpriteImages();
	}

	public void move(int k) {
		s.move(this , k );
	}

	public State getSate() {
		return s;
	}

	public void setSate(State s) {
		this.s = s;
	}

	public String getName() {
		return this.ballType.getNameImage();
	}

}
