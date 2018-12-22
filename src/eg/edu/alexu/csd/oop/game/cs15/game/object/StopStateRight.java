package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class StopStateRight implements State {

	private int y;

	public StopStateRight (int y ) {
		this.y = y;
	}

	@Override
	public void move(Shape MyShape, int k) {
		// TODO Auto-generated method stub
		MyShape.setX(k);
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
}
