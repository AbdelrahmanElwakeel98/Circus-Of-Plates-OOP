package eg.edu.alexu.csd.oop.game.cs15.game.world;

import java.util.LinkedList;

import java.util.List;
import java.util.Random;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Container;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Shape;
import eg.edu.alexu.csd.oop.game.cs15.game.object.StopStateLeft;
import eg.edu.alexu.csd.oop.game.cs15.game.object.StopStateRight;
import eg.edu.alexu.csd.oop.game.cs15.Strategy;
import eg.edu.alexu.csd.oop.game.cs15.game.object.AddLeftCommand;
import eg.edu.alexu.csd.oop.game.cs15.game.object.AddRightCommand;
import eg.edu.alexu.csd.oop.game.cs15.game.object.CareTaker;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Clown;
import eg.edu.alexu.csd.oop.game.cs15.game.object.CommandManager;
import eg.edu.alexu.csd.oop.game.cs15.game.object.ConstantBackground;
import eg.edu.alexu.csd.oop.game.cs15.game.object.FlyWeightFactory;
import eg.edu.alexu.csd.oop.game.cs15.game.object.GameObjectContainer;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Iterator;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Observer;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Originator;
import eg.edu.alexu.csd.oop.game.cs15.game.object.Score;

public class GameWorld extends Observer implements World {

	private static int MAX_TIME = 1 * 20 * 1000; // 1 minute
	private int score = 0;
	private long startTime = System.currentTimeMillis();
	private int width;
	private int height;
	private int right;
	private CommandManager cm;
	private int left;
	private final LinkedList<GameObject> constant = new LinkedList<GameObject>();
	private final LinkedList<GameObject> moving = new LinkedList<GameObject>();
	private LinkedList<GameObject> control = new LinkedList<GameObject>();
	private String paths[] = { "/basketballBlack.png", "/basketballBlue.png", "/basketballPurple.png",
			"/footballBlack.png", "/footballBlue.png", "/footballPurple.png" };
	private LinkedList<GameObject> leftobject;
	private LinkedList<GameObject> rightobject;
	private CareTaker careTaker;
	private Originator originator;
	private int lives;
	private Strategy strategy;

	public String getRandom(String[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	public GameWorld(int screenWidth, int screenHeight, Score scoreC,Strategy strategy) {
		this.strategy = strategy;
		width = screenWidth;
		height = screenHeight;
		lives = 3;
		leftobject = new LinkedList<>();
		rightobject = new LinkedList<>();

		control.add(new Clown(screenWidth / 2, (int) (screenHeight * 0.75), "/moSalah.png"));
		right = left = height - control.get(0).getHeight();
		for (int i = 0; i < 10; i++) {
			moving.add(new Shape((int) (Math.random() * screenWidth), -1 * (int) (Math.random() * screenHeight),
					FlyWeightFactory.getShape(getRandom(paths))));
		}
		constant.add(new ConstantBackground(0, 0, "/st.jpg"));
		this.scoreC = scoreC;
		scoreC.attach(this);
		scoreC.setR(rightobject);
		scoreC.setL(leftobject);
		scoreC.setControl(control);

		cm = new CommandManager(this.scoreC);
		careTaker = new CareTaker(this.scoreC);
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
		right = left = height - control.get(0).getHeight();
		if (rightobject.size() > 0) {
			right -= rightobject.size() * rightobject.get(0).getHeight();
		}
		if (leftobject.size() > 0) {
			left -= leftobject.size() * leftobject.get(0).getHeight();
		}
		Container mContainer = new GameObjectContainer(moving);
		for (Iterator iter = mContainer.getIterator(); iter.hasNext();) {
			GameObject m = (GameObject) iter.next();
			Shape l = (Shape) m;
			l.move(1);
			if (m.getY() == getHeight()) {
				// reuse the star in another position
				m.setY(-1 * (int) (Math.random() * getHeight()));
				m.setX((int) (Math.random() * getWidth()));
			}
			Checkintersection(l, c);
		}
		Container cContainer = new GameObjectContainer(control);
		Iterator iter = cContainer.getIterator();
		for (iter.next(); iter.hasNext();) {
			Shape l = (Shape) iter.next();

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
		if (timeout == true) {
			if (lives > 0) {
				if (score > 0) {
					// trimming left

					int x = leftobject.size();
					int y = rightobject.size();
					System.out.println(careTaker.get(0).getStateLeft());
					System.out.println(careTaker.get(0).getStateRight());
					for (int i = 0; i < x - careTaker.get(0).getStateLeft(); i++) {
						control.remove(leftobject.peekLast());
						leftobject.removeLast();
					}
					for (int i = 0; i < y - careTaker.get(0).getStateRight(); i++) {
						control.remove(rightobject.peekLast());
						rightobject.removeLast();
					}

				}
				else
				{
					leftobject.clear();
					rightobject.clear();
					control.clear();
					control.add(c);
				}
				lives--;
				startTime = System.currentTimeMillis();
				timeout = false;
			}
		}
		return !timeout;
	}

	void Checkintersection(Shape m, GameObject c) {
		if ((Math.abs((m.getX() + m.getWidth() / 2) - (c.getX() + c.getWidth() / 2)) <= c.getWidth() / 2)
				&& (Math.abs((m.getX() + m.getWidth() / 2) - (c.getX() + c.getWidth() / 2)) >= c.getWidth() / 2
						- m.getWidth())) {
			if ((c.getX() + c.getWidth() / 2) < (m.getX() + m.getWidth() / 2)) {
				if (Math.abs((m.getY() + m.getHeight() / 2) - right) <= m.getHeight() / 2) {
					m.setX(c.getX() + c.getWidth() - m.getWidth());
					m.setY(right);
					m.setSate(new StopStateLeft());
					cm.executeRightCommand(new AddRightCommand(rightobject, m, control));
					this.scoreC.setScoreR();

					moving.remove(m);
					new FlyWeightFactory();
					moving.add(new Shape((int) (Math.random() * width), -1 * (int) (Math.random() * height),
							FlyWeightFactory.getShape(getRandom(paths))));
					// careTaker.setOrdinaryX(c.getX());
				}

			} else {
				if (Math.abs((m.getY() + m.getHeight() / 2) - left) <= m.getHeight() / 2) {
					m.setX(c.getX());
					m.setY(left);
					m.setSate(new StopStateRight());
					cm.executeLeftCommand(new AddLeftCommand(leftobject, m, control));
					this.scoreC.setScoreR();
					moving.remove(m);
					new FlyWeightFactory();
					moving.add(new Shape((int) (Math.random() * width), -1 * (int) (Math.random() * height),
							FlyWeightFactory.getShape(getRandom(paths))));
					// careTaker.setOrdinaryX(c.getX());
				}

			}
		}

	}

	@Override
	public String getStatus() {
		return "Score=" + score + "   |   Time="
				+ Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000)+"   |   Lives="+lives;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.strategy.getSpeed();
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return this.strategy.getControlSpeed();
	}

	@Override
	public void updateR() {

		this.score++;
	}

	@Override
	public void updateL() {
		this.score++;
	}

}
