package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class AddLeftCommand implements Command {

	private LinkedList left, control;
	private GameObject gameObject;
    private Logger log;
	public AddLeftCommand (LinkedList left, GameObject gameObject, LinkedList control) {
		
		this.gameObject = gameObject;
		this.left = left;
		this.control = control;
		this.log = JLogger.getLogInstance();
	}

	@Override
	public void execute() {
		log.info("excute Leftcommand");
		this.left.add(this.gameObject);
		this.control.add(this.gameObject);
	}

	@Override
	public void undo() {
		log.info("undo Leftcommand");
		this.control.remove(this.left.get(this.left.size() - 1));
		this.left.remove(this.left.size() - 1);
	}

}
