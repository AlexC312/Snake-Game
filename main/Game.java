package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game implements KeyListener{
	private Snake player;
	private Food food;
	private Graphics graphics;
	
	private JFrame window;
	
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int DIMENSION = 20;
	
	public Game() {
		this.window = new JFrame();
		this.player = new Snake();
		this.food = new Food(this.player);
		this.graphics = new Graphics(this);
		
		this.window.add(graphics);
		
		this.window.setTitle("Snake");
		this.window.setSize(WIDTH * DIMENSION + 2, HEIGHT * DIMENSION + 4);
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setResizable(false);
		
		
	}
	
	public boolean checkWallHit() {
		if(this.player.getX() < 0 || this.player.getX() >= WIDTH * DIMENSION || this.player.getY() < 0 || this.player.getY() >= HEIGHT * DIMENSION) {
			return true;
		}
		return false;
			
	}
	
	public boolean checkFoodHit() {
		if(this.player.getX() == this.food.getxPos() * DIMENSION && this.player.getY() == this.food.getyPos() * DIMENSION) {
			return true;
		}
		return false;
	}
	
	
	public boolean checkSelfHit() {
		for(int i = 1; i < this.player.getBody().size(); i ++) {
			if(this.player.getBody().get(i).x == this.player.getX() && this.player.getBody().get(i).y == this.player.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public void start() {
		this.graphics.state = "RUNNING";
	}
	
	public void update() {
		if(this.graphics.state == "RUNNING") {
			if(checkFoodHit()) {
				this.player.grow();
				this.food.randomFoodSpawn(this.player);
			} else if(checkWallHit() || checkSelfHit()) {
				this.graphics.state = "END";
			} else {
				this.player.move();
			}
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getExtendedKeyCode();
		
		if(this.graphics.state == "RUNNING") {
		
			if(keyCode == KeyEvent.VK_W) {
				this.player.up();
			}
			
			else if(keyCode == KeyEvent.VK_S) {
				this.player.down();
			}
			
			else if(keyCode == KeyEvent.VK_A) {
				this.player.left();
			}
			
			else {
				this.player.right();
			}
		} else {
			this.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public Snake getPlayer() {
		return player;
	}

	public void setPlayer(Snake player) {
		this.player = player;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}
}
