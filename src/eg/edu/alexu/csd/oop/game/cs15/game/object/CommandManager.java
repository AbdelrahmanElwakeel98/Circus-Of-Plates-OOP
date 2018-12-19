package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.Stack;


public class CommandManager {


	private Stack<Command> undoRight = new Stack<Command>();
	private Stack<Command> undoLeft = new Stack<Command>();

	 public CommandManager() {}

	 public void executeRightCommand(Command c) {
		 c.execute();
		 undoRight.push(c);
	 }

	 public void executeLeftCommand(Command c) {
		 c.execute();
		 undoLeft.push(c);
	 }

	 public void undoRightCommand() {
		 Command c = undoRight.pop();
		 c.undo();
	 }

	 public void undoLeftCommand() {
		 Command c = undoLeft.pop();
		 c.undo();
	 }
}
