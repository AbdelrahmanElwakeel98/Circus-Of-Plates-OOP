package eg.edu.alexu.csd.oop.game.cs15.game.world;

import eg.edu.alexu.csd.oop.game.cs15.Strategy;

public class EasyMode implements Strategy{

	@Override
	public int getSpeed() {
		return 5;
	}

	@Override
	public int getControlSpeed() {
		return 30;
	}

}
