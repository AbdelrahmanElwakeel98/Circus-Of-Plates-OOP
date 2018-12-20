package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Originator {
	private LinkedList<GameObject> stateLeft;
	private LinkedList<GameObject> stateRight;
	private int changedX;

	public LinkedList<GameObject> getStateLeft() {
		return stateLeft;
	}

	public void setStateLeft(LinkedList<GameObject> stateLeft) {
		this.stateLeft = stateLeft;
	}

	public LinkedList<GameObject> getStateRight() {
		return stateRight;
	}

	public void setStateRight(LinkedList<GameObject> stateRight) {
		this.stateRight = stateRight;
	}

	public Memento saveToMemento() {
		return new Memento(stateLeft, stateRight,changedX);
	}

	public void getStateFromMemento(Memento memento) {
		stateLeft = memento.getStateLeft();
		stateRight = memento.getStateRight();
		changedX = memento.getChangedX();
	}

	public int getChangedX() {
		return changedX;
	}

	public void setChangedX(int changedX) {
		this.changedX = changedX;
	}

}
