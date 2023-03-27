package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener{

	private Timer t = new Timer(100, this);
	public String state;
	
	private Snake s;
	private Food f;
	private Game game;
	
	public Graphics(Game g) {
		this.t.start();
		this.state = "START";
		this.game = g;
		this.s = g.getPlayer();
		this.f = g.getFood();
		
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		 
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(new Color(0, 255, 231));
		g2D.fillRect(0, 0, Game.WIDTH * Game.DIMENSION + 5, Game.HEIGHT * Game.DIMENSION + 5);
		
		if(state == "START") {
			g2D.setColor(Color.black);
			g2D.drawString("Press any key to start the game!", Game.WIDTH / 2 * Game.DIMENSION - 40, Game.HEIGHT / 2 * Game.DIMENSION - 20);
		} else if(state == "RUNNING"){
		
		
		
		g2D.setColor(Color.red);
		g2D.fillRect(this.f.getxPos() * Game.DIMENSION, this.f.getyPos() * Game.DIMENSION, Game.DIMENSION, Game.DIMENSION);
		
		g2D.setColor(new Color(255, 136, 17));
		for(Rectangle r: this.s.getBody()) {
				g2D.fill(r);
			}
		} else {
			g2D.setColor(Color.black);
			g2D.drawString("Score: " + (this.s.getBody().size() - 3), Game.WIDTH / 2 * Game.DIMENSION - 40, Game.HEIGHT / 2 * Game.DIMENSION - 20);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		game.update();
	}

}
