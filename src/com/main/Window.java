package com.main;

import javax.swing.JFrame;

public class Window {
	
	public 	Window(String title, Game game) {
		//Creates frame for game
		JFrame frame = new JFrame(title);
		//sets up game
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
