package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class DynamicJarReader {
	private static String pathToJar;
	private Class<? extends GameObject> ShapeClass;
	private HashMap<String, BufferedImage> classResources;
	private Logger log = JLogger.getLogInstance();
	private static DynamicJarReader jarReader;
	
	public static DynamicJarReader getInstance(String path) {
		if(jarReader==null) {
			jarReader = new DynamicJarReader(path);
		}
		return jarReader;
	}

	private DynamicJarReader(String path) {
		pathToJar = path;
		ShapeClass = null;
		classResources = new HashMap<>();
		readClass();
	}

	@SuppressWarnings("unchecked")
	private void readClass() {
		try {
			log.info("ReadClass");
			JarFile jar = new JarFile(pathToJar);
			Enumeration<JarEntry> e = jar.entries();
			URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);
			while (e.hasMoreElements()) {
				JarEntry je = e.nextElement();
				if (je.getName().contains(".class")) {
					String className = je.getName().substring(0, je.getName().length() - 6);
					className = className.replace('/', '.');
					ShapeClass = (Class<? extends GameObject>) cl.loadClass(className);
				} else if (je.getName().contains(".png") || je.getName().contains(".jpg")) {
					InputStream in = ShapeClass.getResourceAsStream("/" + je.getName());
					if ( in == null )
						try {
							throw new Exception("resource not found: " + "/" + je.getName());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				//	System.out.println(je.getName());
					classResources.put(je.getName(), ImageIO.read(ShapeClass.getResource("/" + je.getName())));
				}
			}
			Enumeration<JarEntry> e2 = jar.entries();
			while (e2.hasMoreElements()) {
				JarEntry je = e2.nextElement();
				if (je.getName().contains(".png") || je.getName().contains(".jpg")) {
					classResources.put(je.getName(), ImageIO.read(ShapeClass.getResource("/" + je.getName())));
				}
			}
			jar.close();
		} catch (IOException e) {
			log.error("Jar not Found");
		} catch (ClassNotFoundException e1) {
			log.error("There is no such class");
		}
	}

	public BufferedImage getImage(String name) {
		try {
			return classResources.get(name);
		} catch (NullPointerException e) {
			log.error("no image found");
			throw new NullPointerException();
		}
	}

	public String[] getImagesName() {
		Set<String> keys = classResources.keySet();
		Object[] s = keys.toArray();
		String[] imagesName = new String[s.length];
		for (int i = 0; i < s.length; i++) {
			imagesName[i] = (String) s[i];
		}
		return imagesName;

	}

	public Class<? extends GameObject> getShapeClass() {
		return ShapeClass;
	}
}
