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
		if (index<3) {
		if(((Shape)R.get(index)).getName().contains("BLACK") && ((Shape)R.get(index-1)).getName().contains("BLACK") && ((Shape)R.get(index-2)).getName().contains("BLACK"))
				scoreR++;
		if(((Shape)R.get(index)).getName().contains("BLUE") && ((Shape)R.get(index-1)).getName().contains("BLUE") && ((Shape)R.get(index-2)).getName().contains("BLUE"))
			scoreR++;
		if(((Shape)R.get(index)).getName().contains("PURPLE") && ((Shape)R.get(index-1)).getName().contains("PURPLE") && ((Shape)R.get(index-2)).getName().contains("PURPLE"))
			scoreR++;
		}
		if(scoreR == 1) {
			this.scoreR = scoreR;
			score++;
			notifyAllObserversR();
		}
	}
	public void setScoreL() {
		int scoreL;
		int index = L.size()-1;
		scoreL = 0;
		if (index<3) {
			if(((Shape)L.get(index)).getName().contains("BLACK") && ((Shape)L.get(index-1)).getName().contains("BLACK") && ((Shape)L.get(index-2)).getName().contains("BLACK"))
					scoreL++;
			if(((Shape)L.get(index)).getName().contains("BLUE") && ((Shape)L.get(index-1)).getName().contains("BLUE") && ((Shape)L.get(index-2)).getName().contains("BLUE"))
				scoreL++;
			if(((Shape)L.get(index)).getName().contains("PURPLE") && ((Shape)L.get(index-1)).getName().contains("PURPLE") && ((Shape)L.get(index-2)).getName().contains("PURPLE"))
				scoreL++;
			}
		if(scoreL == 1) {
			this.scoreL = scoreL;
			score++;
			notifyAllObserversL();
		}
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObserversR(){
	      for (Observer observer : observers) {
	         observer.updateR();
	      }
	}
	private void notifyAllObserversL() {
		 for (Observer observer : observers) {
	         observer.updateL();
	      }
		
	}

}
