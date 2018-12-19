package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.cs15.game.world.GameWorld;

public class Main {

	public static void main(String[] args) {
		//GameEngine.start("hhh", new GameWorld(785,800));
		JMenuBar  menuBar = new JMenuBar();;
		JMenu menu = new JMenu("File");
		JMenu mode = new JMenu("Mode");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem easyModeMenuItem = new JMenuItem("Easy");
		JMenuItem moderateModeMenuItem = new JMenuItem("Moderate");
		JMenuItem hardModeMenuItem = new JMenuItem("Hard");
		menu.add(newMenuItem);
		menu.addSeparator();
		mode.add(easyModeMenuItem);
		mode.addSeparator();
		mode.add(moderateModeMenuItem);
		mode.addSeparator();
		mode.add(hardModeMenuItem);
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menuBar.add(menu);
		menuBar.add(mode);
		Score scoreC = new Score();
		final GameController gameController = GameEngine.start("The Egyption King", new GameWorld(700,800,scoreC), menuBar, Color.BLACK);
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new GameWorld(785,800,scoreC));
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		easyModeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		moderateModeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		hardModeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
	}
}