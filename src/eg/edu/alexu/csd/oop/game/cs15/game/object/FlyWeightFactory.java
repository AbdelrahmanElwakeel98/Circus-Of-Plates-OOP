package eg.edu.alexu.csd.oop.game.cs15.game.object;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.game.GameObject;

public class FlyWeightFactory {
	
	private static final HashMap<ShapeType,GameObject> shapes = new HashMap<ShapeType,GameObject>();
	
	
	public static GameObject getShape(ShapeType type) {
		GameObject shapeImpl = shapes.get(type);

		if (shapeImpl == null) {
			if (type.equals(ShapeType.BALL)) {
				shapeImpl = new BallType("/football.png");
			}
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}
	
	
	public static enum ShapeType{
		BALL;
	}

}
