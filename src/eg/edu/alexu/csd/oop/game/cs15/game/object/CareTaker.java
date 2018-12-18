package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List<Memento> mList = new ArrayList<>();

	public void add(Memento memento) {
		mList.add(memento);
	}

	public Memento get(int index) {
		return mList.get(index);

	}

}
