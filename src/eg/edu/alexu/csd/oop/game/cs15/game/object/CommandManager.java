package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.Stack;

import org.apache.log4j.Logger;

public class CommandManager extends Observer {

	private Stack<Command> undoRight = new Stack<Command>();
	private Stack<Command> undoLeft = new Stack<Command>();
	private Logger log = JLogger.getLogInstance();

	public CommandManager(Score scoreC) {
		this.scoreC = scoreC;
		scoreC.attach(this);
	}

	public void executeRightCommand(Command c) {
		log.info("executeRightCommand");
		c.execute();
		undoRight.push(c);
	}

	public void executeLeftCommand(Command c) {
		log.info("executeLeftCommand");
		c.execute();
		undoLeft.push(c);
	}

	public void undoRightCommand() {
		log.info("undoRightCommand");
		Command c = undoRight.pop();
		c.undo();
	}

	public void undoLeftCommand() {
		log.info("undoLeftCommand");
		Command c = undoLeft.pop();
		c.undo();
	}

	@Override
	public void updateR() {
		log.info("updateR");
		undoRightCommand();
		undoRightCommand();
		undoRightCommand();
	}

	@Override
	public void updateL() {
		log.info("updateL");
		undoLeftCommand();
		undoLeftCommand();
		undoLeftCommand();
	}
}
