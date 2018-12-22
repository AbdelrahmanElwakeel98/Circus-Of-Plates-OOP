package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class MovingState implements State {

	private int y;

	public MovingState(int y) {
		this.y = y;
	}

	@Override
	public void move(Shape MyShape, int k) {
		// TODO Auto-generated method stub
		MyShape.setY(MyShape.getY() + k);
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

}
