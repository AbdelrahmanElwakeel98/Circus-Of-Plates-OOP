package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class StopStateLeft implements State{

	@Override
	public void move(Shape Myshape, int k) {
		// TODO Auto-generated method stub
		Myshape.setX( k - Myshape.getWidth() );
	}

	@Override
	public boolean Statename() {
		// TODO Auto-generated method stub
		return false;
	}

}
