package eg.edu.alexu.csd.oop.game.cs15.game.object;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.game.GameObject;

public class FlyWeightFactory {
	
	private static final HashMap<String,ImageType> shapes = new HashMap<String,ImageType>();
	
	
	public static ImageType getShape(String path) {
		ImageType shapeImpl = shapes.get(path);

		if (shapeImpl == null) {
			shapeImpl = new ImageType(path);
			shapes.put(path, shapeImpl);
		}
		return shapeImpl;
	}
	
	
	

}
