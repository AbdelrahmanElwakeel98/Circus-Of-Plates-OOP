package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MouseInputAdapter;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.cs15.game.world.GameWorld;
import eg.edu.alexu.csd.oop.game.cs15.game.world.ModeFactory;

public class Main {
	static String Difficulty;

	public static void main(String[] args) {
		ThreadingPool pool =new ThreadingPool(1);
		SplashThread splash =new SplashThread();
		SoundThread sound = new SoundThread();
		pool.execute(splash);
		try {
			Thread.currentThread().sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		splash.stop();
		pool.execute(sound);
		JFrame modeChooser = new JFrame("Choose the Level!");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - 700) / 2;
		int y = (screen.height - 450) / 2;
		modeChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modeChooser.setSize(800, 600);
		modeChooser.setLocationRelativeTo(null);
		modeChooser.setLayout(new GridLayout(3, 1));
		modeChooser.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JLabel easyLabel = new JLabel("Easy Mode", JLabel.CENTER);
		modeChooser.add(easyLabel);
		easyLabel.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Difficulty = "EASY";
				modeChooser.setVisible(false);
				start();
			}
		});
		JLabel mediumLabel = new JLabel("Medium Mode", JLabel.CENTER);
		modeChooser.add(mediumLabel);
		mediumLabel.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Difficulty = "MODERATE";
				modeChooser.setVisible(false);
				start();
			}
		});
		JLabel hardLabel = new JLabel("Hard Mode", JLabel.CENTER);
		modeChooser.add(hardLabel);
		hardLabel.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Difficulty = "HARD";
				modeChooser.setVisible(false);
				start();
			}
		});
		modeChooser.setVisible(true);
	}

	public static void start() {
		JMenuBar menuBar = new JMenuBar();
		;
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
		ModeFactory modeFactory = ModeFactory.getInstance();
		final GameController gameController = GameEngine.start("The Egyption King",
				new GameWorld(700, 800, new Score(), modeFactory.getMode(Difficulty)), menuBar, Color.BLACK);
		newMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new GameWorld(785, 800, new Score(), modeFactory.getMode(Difficulty)));
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		easyModeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new GameWorld(785, 800, new Score(), modeFactory.getMode("EASY")));
			}
		});
		moderateModeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new GameWorld(785, 800, new Score(), modeFactory.getMode("MODERATE")));
			}
		});
		hardModeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new GameWorld(785, 800, new Score(), modeFactory.getMode("HARD")));
			}
		});
	}
}