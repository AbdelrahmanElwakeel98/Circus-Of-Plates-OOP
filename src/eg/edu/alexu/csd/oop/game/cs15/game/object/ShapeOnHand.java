package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ShapeOnHand implements GameObject {
	private int x, y;
	private boolean visible;
	private GameObject ballType;
	private State s;

	public ShapeOnHand(int x, int y, GameObject ballType) {
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
		//this.y = y;
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

	public State getSate() {
		return s;
	}

	public void setSate(State s) {
		this.s = s;
	}

}
