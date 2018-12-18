package eg.edu.alexu.csd.oop.game.cs15.game.world;

import java.util.LinkedList;

import java.util.List;
import java.util.Random;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Shape;
import eg.edu.alexu.csd.oop.game.cs15.game.object.StopStateLeft;
import eg.edu.alexu.csd.oop.game.cs15.game.object.StopStateRight;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Clown;
import eg.edu.alexu.csd.oop.game.cs15.game.object.ConstantBackground;
import eg.edu.alexu.csd.oop.game.cs15.game.object.FlyWeightFactory;

public class GameWorld implements World {

	private static int MAX_TIME = 1 * 60 * 1000; // 1 minute
	private int score = 0;
	private long startTime = System.currentTimeMillis();
	private int width;
	private int height;
	private int right;
	private int left;
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
	private String paths[] = { "/basketballBlack.png", "/basketballBlue.png", "/basketballPurple.png",
			"/footballBlack.png", "/footballBlue.png", "/footballPurple.png" };

	public String getRandom(String[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	public GameWorld(int screenWidth, int screenHeight) {
		width = screenWidth;
		height = screenHeight;
		right = 0;
		left = 0;
		control.add(new Clown(screenWidth / 2, (int) (screenHeight * 0.75), "/moSalah.png"));
		for (int i = 0; i < 10; i++)
			moving.add(new Shape((int) (Math.random() * screenWidth), -1 * (int) (Math.random() * screenHeight),
					new FlyWeightFactory().getShape(getRandom(paths))));
		constant.add(new ConstantBackground(0, 0, "/st.jpg"));
	}

	@Override
	public List<GameObject> getConstantObjects() {
		return this.constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		return this.moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return this.control;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean refresh() {
		boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
		GameObject c = control.get(0);
		for (int i = 1; i < moving.size(); i++) {
			GameObject m = moving.get(i);
			Shape l = (Shape) m;
			l.move(1);
			if (m.getY() == getHeight()) {
				// reuse the star in another position
				m.setY(-1 * (int) (Math.random() * getHeight()));
				m.setX((int) (Math.random() * getWidth()));
			}
			c.getHeight();
			if ((Math.abs((m.getX() + m.getWidth() / 2) - (c.getX() + c.getWidth() / 2)) <= c.getWidth() / 2) && (Math
					.abs((m.getY() + m.getHeight() / 2) - (c.getY() + c.getHeight() / 2)) <= c.getHeight() / 2)) {
				if ((c.getX() + c.getWidth() / 2) < (m.getX() + m.getWidth() / 2)) {
					l.setX(c.getX() + c.getWidth() - m.getWidth());
					l.setY(c.getY() - right);
					l.setSate(new StopStateLeft());
					control.add(m);
					moving.remove(m);
					new FlyWeightFactory();
					moving.add(new Shape((int) (Math.random() * width), -1 * (int) (Math.random() * height),
							FlyWeightFactory.getShape(getRandom(paths))));
					right += 20;

				} else {
					l.setX(c.getX());
					l.setY(c.getY() - left);
					l.setSate(new StopStateRight());
					control.add(m);
					moving.remove(m);
					new FlyWeightFactory();
					moving.add(new Shape((int) (Math.random() * width), -1 * (int) (Math.random() * height),
							FlyWeightFactory.getShape(getRandom(paths))));
					left += 20;
				}
			}

		}
		// System.out.println(width - (c.getX() + c.getWidth()));
		for (int i = 1; i < control.size(); i++) {
			Shape l = (Shape) control.get(i);

			if (c.getX() == 0) {
				if (l.getX() != 0) {
					l.move(c.getX() + c.getWidth());
				}
			} else if (c.getX() + c.getWidth() - 12 == width) {
				if (l.getX() - c.getX() < l.getWidth()) {
					l.move(c.getX());
					
				}

			}
		}

		return !timeout;
	}

	@Override
	public String getStatus() {
		return "Score=" + score + "   |   Time="
				+ Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 10;
	}

}
