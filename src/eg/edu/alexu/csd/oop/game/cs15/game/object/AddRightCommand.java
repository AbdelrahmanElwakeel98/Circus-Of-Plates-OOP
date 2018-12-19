package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public class AddRightCommand implements Command {

	private LinkedList right, control;
	private GameObject gameObject;

	public AddRightCommand (LinkedList right, GameObject gameObject, LinkedList control) {
		this.gameObject = gameObject;
		this.right = right;
		this.control = control;
	}

	@Override
	public void execute() {
		this.right.add(this.gameObject);
		this.control.add(this.gameObject);
	}

	@Override
	public void undo() {
		this.control.remove(this.right.get(this.right.size() - 1));
		this.right.remove(this.right.size() - 1);
	}

}
