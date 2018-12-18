package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class StopStateRight implements State {

	@Override
	public void move(Shape MyShape , int k) {
		// TODO Auto-generated method stub
		MyShape.setX(k);
	}

	@Override
	public boolean Statename() {
		// TODO Auto-generated method stub
		return false;
	}
}
