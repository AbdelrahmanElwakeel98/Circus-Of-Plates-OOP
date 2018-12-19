package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public class AddLeftCommand implements Command {

	private LinkedList left;
	private GameObject gameObject;

	public AddLeftCommand (LinkedList left, GameObject gameObject) {
		this.gameObject = gameObject;
		this.left = left;
	}

	@Override
	public void execute() {
		this.left.add(this.gameObject);
	}

	@Override
	public void undo() {
		this.left.remove(this.left.size() - 1);
	}

}
