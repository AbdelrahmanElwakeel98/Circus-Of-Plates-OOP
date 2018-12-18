package eg.edu.alexu.csd.oop.game.cs15.game.object;

public class StopStateLeft implements State{

	@Override
	public void move(Shape Myshape, int k) {
		// TODO Auto-generated method stub
		System.out.println(Myshape.getWidth());
		Myshape.setX( k - Myshape.getWidth() );
		Myshape.setSate(this);
	}

	@Override
	public boolean Statename() {
		// TODO Auto-generated method stub
		return false;
	}

}
