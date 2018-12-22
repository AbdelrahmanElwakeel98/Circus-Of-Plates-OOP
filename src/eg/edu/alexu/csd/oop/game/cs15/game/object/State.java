package eg.edu.alexu.csd.oop.game.cs15.game.object;

public interface State {

	public void move(Shape Myshape, int k);

	public void setY(int y);
	
	public int getY();

}
