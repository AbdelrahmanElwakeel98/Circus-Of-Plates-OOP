package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowingLeaderBoard {
	public ShowingLeaderBoard(boolean endGame) {
		if (!endGame) {
			JFrame leaderBoard = new JFrame("LeaderBoard");
			leaderBoard.setLocationRelativeTo(null);
			Box vb = Box.createVerticalBox();
			JPanel jp = new JPanel(new GridLayout(1, 2));
			leaderBoard.setSize(280, 396);
			JLabel score = new JLabel("Score", JLabel.LEFT);
			JLabel player = new JLabel("Player", JLabel.RIGHT);
			score.setFont(new Font("Courier New", Font.ITALIC, 20));
			score.setForeground(Color.black);
			player.setFont(new Font("Courier New", Font.ITALIC, 20));
			player.setForeground(Color.black);
			jp.add(score);
			jp.add(player);
			/* put the current player score here */
			int scoree=5;
			JLabel currentScore = new JLabel(String.format("%05d", scoree), JLabel.LEFT);
			currentScore.setFont(new Font("Courier New", Font.ITALIC, 20));
			currentScore.setForeground(Color.red);
			JLabel currentPlayer = new JLabel(String.format("%.5s", Main.getPlayerName()), JLabel.RIGHT);
			currentPlayer.setFont(new Font("Courier New", Font.ITALIC, 20));
			currentPlayer.setForeground(Color.red);
			JPanel jpCurrent = new JPanel(new GridLayout(1, 2));
			jpCurrent.add(currentScore);
			jpCurrent.add(currentPlayer);
			vb.add(jpCurrent);
			vb.add(jp);
			JTextArea leader = new JTextArea();
			leader.setFont(new Font("Courier New", Font.ITALIC, 20));
			leader.setForeground(Color.blue);
			leader.setEditable(false);
			vb.add(leader);
			leaderBoard.add(vb);
			/*
			 * first uncomment line155 then put the text area object and the 2 linked list
			 */
			// writeLeaderBoard(scores, players, leader);
			leaderBoard.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent windowEvent) {
					leaderBoard.setVisible(false);
				}
			});
			leaderBoard.setVisible(true);
			leaderBoard.setResizable(false);
		}
		
	}
	private void writeLeaderBoard(LinkedList<String> score, LinkedList<String> players, JTextArea leader) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < score.size(); i++) {
			sb.append(String.format("%05d", Integer.valueOf(score.get(i)))
					+ String.format("%" + String.valueOf(leader.getWidth() - 12) + "s", "")
					+ String.format("%.5s", players.get(i)) + "\n");
		}
		leader.setText(sb.toString());
	}
}
