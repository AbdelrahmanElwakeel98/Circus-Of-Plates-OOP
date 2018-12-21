package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class AddRightCommand implements Command {

	private LinkedList<GameObject> right, control;
	private GameObject gameObject;
	private Logger log;

	public AddRightCommand(LinkedList<GameObject> right, GameObject gameObject, LinkedList<GameObject> control) {
		this.gameObject = gameObject;
		this.right = right;
		this.control = control;
		log = JLogger.getLogInstance();
	}

	@Override
	public void execute() {
		log.info("execute RightCommand");
		this.right.add(this.gameObject);
		this.control.add(this.gameObject);
	}

	@Override
	public void undo() {
		log.info("undo RightCommand");
		this.control.remove(this.right.get(this.right.size() - 1));
		this.right.remove(this.right.size() - 1);
	}

}
