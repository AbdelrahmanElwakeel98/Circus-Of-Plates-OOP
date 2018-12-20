package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CareTaker extends Observer {
	private List<Memento> mList = new ArrayList<>();
	private Logger log;

	public CareTaker(Score scoreC) {
		// TODO Auto-generated constructor stub
		this.scoreC = scoreC;
		scoreC.attach(this);
		this.log = JLogger.getLogInstance();
	}

	public void add(Memento memento) {
		log.info("add CareTaker");
		mList.add(memento);
	}

	public Memento get(int index) {
		log.info("get CareTaker");
		return mList.get(index);

	}

	@Override
	public void updateR() {
		// TODO Auto-generated method stub
		log.info("ubdateR in careTaker CareTaker");
		mList.clear();
		Originator originator = new Originator();
		originator.setStateLeft(scoreC.getL().size());
		originator.setStateRight(scoreC.getR().size());
		// UpdatedX=ordinaryX;
		add(originator.saveToMemento());

	}

	@Override
	public void updateL() {
		// TODO Auto-generated method stub
		log.info("ubdateL in careTaker CareTaker");
		mList.clear();
		mList.clear();
		Originator originator = new Originator();
		originator.setStateLeft(scoreC.getL().size());
		originator.setStateRight(scoreC.getR().size());
		// UpdatedX=ordinaryX;
		add(originator.saveToMemento());

	}
	
}
