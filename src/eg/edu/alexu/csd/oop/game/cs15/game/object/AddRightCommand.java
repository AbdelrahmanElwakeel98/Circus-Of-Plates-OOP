package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public class AddRightCommand implements Command {

	private LinkedList right;
	private GameObject gameObject;

	public AddRightCommand (LinkedList right, GameObject gameObject) {
		this.gameObject = gameObject;
		this.right = right;
	}

	@Override
	public void execute() {
		this.right.add(this.gameObject);
	}

	@Override
	public void undo() {
		this.right.remove(this.right.size() - 1);
	}

}
