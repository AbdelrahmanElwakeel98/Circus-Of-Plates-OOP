package eg.edu.alexu.csd.oop.game.cs15.game.world;

import eg.edu.alexu.csd.oop.game.cs15.Strategy;

public class HardMode implements Strategy{

	@Override
	public int getSpeed() {
		return 15;
	}

	@Override
	public int getControlSpeed() {
		return 15;
	}

}
