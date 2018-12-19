package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Score {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private int score = 0;
	private int scoreR = 0;
	private int scoreL = 0;
	private LinkedList<GameObject>R;
	private LinkedList<GameObject>L;
	
	public Score(LinkedList<GameObject> R,LinkedList<GameObject>L) {
		this.R=R;
		this.L=L;
	}
	
	public void setL(LinkedList<GameObject>L) {
		this.L=L;
	}
	public void setR(LinkedList<GameObject>R) {
		this.R=R;
	}
	public LinkedList<GameObject> getR(){
		return R;
	}
	public LinkedList<GameObject> getL(){
		return L;
	}
	
	
	public int getScore() {
		return score;
	}
	public int getScoreR() {
		return scoreR;
	}
	public int getScoreL() {
		return scoreL;
	}
	
	public void setScoreR() {
		int scoreR;
		int index = R.size()-1;
		scoreR = 0;
		if(R.get(index).equals(R.get(index-1)))
			if(R.get(index-1).equals(R.get(index-2)))
				scoreR++;
		
		if(scoreR == 3) {
			this.scoreR = scoreR;
			score++;
			notifyAllObservers();
		}
	}
	public void setScoreL() {
		int scoreL;
		int index = L.size()-1;
		scoreL = 0;
		if(L.get(index).equals(L.get(index-1)))
			if(L.get(index-1).equals(L.get(index-2)))
				scoreL++;
		
		if(scoreL == 3) {
			this.scoreL = scoreL;
			score++;
			notifyAllObservers();
		}
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	}

}
