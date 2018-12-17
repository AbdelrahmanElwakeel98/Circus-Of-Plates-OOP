package eg.edu.alexu.csd.oop.game.cs15.game.world;

import java.util.LinkedList;

import java.util.List;
import java.util.Random;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Shape;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Clown;
import eg.edu.alexu.csd.oop.game.cs15.game.object.ConstantBackground;
import eg.edu.alexu.csd.oop.game.cs15.game.object.FlyWeightFactory;

public class GameWorld implements World {

	private static int MAX_TIME = 1 * 60 * 1000; // 1 minute
	private int score = 0;
	private long startTime = System.currentTimeMillis();
	private int width;
	private int height;
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
		// moving objects (enemy)
		// for(int i=0; i<10; i++)
		control.add(new Clown(screenWidth / 3, (int) (screenHeight * 0.75), "/moSalah.png"));
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
		for (GameObject m : moving) {
			m.setY((m.getY() + 1));
			if (m.getY() == getHeight()) {
				// reuse the star in another position
				m.setY(-1 * (int) (Math.random() * getHeight()));
				m.setX((int) (Math.random() * getWidth()));
			}
			if ((Math.abs((m.getX() + m.getWidth() / 2) - (c.getX() + c.getWidth() / 2)) <= m.getWidth())
					&& (Math.abs((m.getY() + m.getHeight() / 2) - (c.getY() + c.getHeight() / 2)) <= m.getHeight())) {
				m.setY(m.getY()+ 50 );
				
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
		return 20;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 10;
	}

}
