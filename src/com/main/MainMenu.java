package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends MouseAdapter {

	public boolean active;

	// button play
	private Rectangle playBtn;
	private String playTxt = "Play";
	private boolean pHighlight = false;

	// button play
	private Rectangle quitBtn;
	private String quitTxt = "Quit";
	private boolean qHighlight = false;

	private Font font;

	public MainMenu(Game game) {
		active = true;
		game.start();

		int w, h, x, y;

		w = 300;
		h = 150;

		y = Game.HEIGHT / 2 - h / 2;

		x = Game.WIDTH / 4 - w / 2;
		playBtn = new Rectangle(x, y, w, h);

		x = Game.WIDTH * 3 / 4 - w / 2;
		quitBtn = new Rectangle(x, y, w, h);

		font = new Font("Roboto", Font.PLAIN, 100);

	}
	//Draws buttons
	public void draw(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		g.setFont(font);

		g.setColor(Color.black);
		if (pHighlight) {
			g.setColor(Color.white);
		}
		((Graphics2D) g2d).fill(playBtn);

		g.setColor(Color.black);
		if (qHighlight) {
			g.setColor(Color.white);
		}
		((Graphics2D) g2d).fill(quitBtn);

		g.setColor(Color.white);
		((Graphics2D) g2d).draw(playBtn);
		((Graphics2D) g2d).draw(quitBtn);
		
		int strWidth;
		int strHeight;
		//Play text
		strWidth = g.getFontMetrics(font).stringWidth(playTxt);
		strHeight = g.getFontMetrics(font).getHeight();
		
		g.setColor(Color.green);
		g.drawString(playTxt, (int) (playBtn.getX() + playBtn.getWidth() / 2 - strWidth / 2),
				(int) (playBtn.getY() + playBtn.getHeight() / 2 + strHeight / 4));
		//Quit text
		strWidth = g.getFontMetrics(font).stringWidth(playTxt);
		strHeight = g.getFontMetrics(font).getHeight();
		
		g.setColor(Color.red);
		g.drawString(quitTxt, (int) (quitBtn.getX() + quitBtn.getWidth() / 2 - strWidth / 2),
				(int) (quitBtn.getY() + quitBtn.getHeight() / 2 + strHeight / 4));
	}
	//Activates play/quit button
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		
		if(playBtn.contains(p)) {
			active = false;
		}
		else if(quitBtn.contains(p)) {
			System.exit(0);
		}
	}
	//Highlights play/quit button
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();

		pHighlight = playBtn.contains(p);
		qHighlight = quitBtn.contains(p);
	}

}
