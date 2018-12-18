package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class MovingState implements State {

	@Override
	public void move(Shape MyShape ) {
		// TODO Auto-generated method stub
		MyShape.setY(MyShape.getY() + 1);
	}

	@Override
	public boolean Statename() {
		// TODO Auto-generated method stub
		return true;
	}





}
