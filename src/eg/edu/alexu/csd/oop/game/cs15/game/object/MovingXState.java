package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class MovingXState implements State {

	@Override
	public void move(Shape MyShape ) {
		// TODO Auto-generated method stub
		MyShape.setY(MyShape.getY() + 1);
	}

}
