package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class CareTaker extends Observer {
	private List<Memento> mList = new ArrayList<>();


	public CareTaker(Score scoreC) {
		// TODO Auto-generated constructor stub
		this.scoreC = scoreC;
		scoreC.attach(this);
	}

	public void add(Memento memento) {
		mList.add(memento);
	}

	public Memento get(int index) {
        System.out.println(mList.get(index));
		return mList.get(index);

	}

	@Override
	public void updateR() {
		// TODO Auto-generated method stub
		Originator originator = new Originator();
		LinkedList<GameObject> l=(LinkedList<GameObject>) scoreC.getL().clone();
		originator.setStateLeft(l);
		LinkedList<GameObject> r =(LinkedList<GameObject>) scoreC.getR().clone();
		originator.setStateRight(r);
		//UpdatedX=ordinaryX;
		add(originator.saveToMemento());

	}

	@Override
	public void updateL() {
		// TODO Auto-generated method stub
		Originator originator = new Originator();
		LinkedList<GameObject> l=(LinkedList<GameObject>) scoreC.getL().clone();
		originator.setStateLeft(l);
		LinkedList<GameObject> r =(LinkedList<GameObject>) scoreC.getR().clone();
		originator.setStateRight(r);
		//UpdatedX=ordinaryX;
		add(originator.saveToMemento());

	}
	/*public int getUpdatedX()
	{
		return UpdatedX;

	}
	public void setOrdinaryX(int ordinaryX)
	{
		this.ordinaryX=ordinaryX;
		//kml b2a set we get
	}*/

}
