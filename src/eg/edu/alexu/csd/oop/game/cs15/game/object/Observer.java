package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Observer {
	private static LinkedList<GameObject>R;
	private static LinkedList<GameObject>L;
	
	
	protected Score scoreC;
	public abstract void update();
	

}
