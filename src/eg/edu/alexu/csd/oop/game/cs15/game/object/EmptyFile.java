package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmptyFile {
	
	public void write() {
		String path = "Leaderboard.json";
		File x = new File(path);

		if (x.exists()) {
			x.delete();
			try {
				x.createNewFile();
			} catch (IOException e) {

			}
		} else {
			try {
				x.createNewFile();
			} catch (IOException e) {

			}
		}

		JSONObject obj = new JSONObject();
		JSONArray namesEasy = new JSONArray();
		JSONArray scoreEasy = new JSONArray();
		JSONArray namesMod = new JSONArray();
		JSONArray scoreMod = new JSONArray();
		JSONArray namesHard = new JSONArray();
		JSONArray scoreHard = new JSONArray();

		obj.put("namesEasy", namesEasy);
		obj.put("scoreEasy", scoreEasy);
		obj.put("namesMod", namesMod);
		obj.put("scoreMod", scoreMod);
		obj.put("namesHard", namesHard);
		obj.put("scoreHard", scoreHard);


		try (FileWriter file = new FileWriter(path)) {

			file.write(obj.toString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
