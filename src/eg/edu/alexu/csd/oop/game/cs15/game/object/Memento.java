package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Memento {
	private LinkedList<GameObject> stateLeft;
	private LinkedList<GameObject> stateRight;
	private int changedX;

	public Memento(LinkedList<GameObject> stateLeft, LinkedList<GameObject> stateRight,int changedX) {
		this.stateLeft = stateLeft;
		this.stateRight = stateRight;
		this.changedX=changedX;
	}

	public LinkedList<GameObject> getStateLeft() {
		return stateLeft;

	}

	public LinkedList<GameObject> getStateRight() {
		return stateRight;

	}
	public int getChangedX()
	{
		return changedX;

	}

}
