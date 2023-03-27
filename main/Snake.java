package main;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private ArrayList<Rectangle> body;
	private String move;
	
	public Snake() {
		this.body = new ArrayList<>();
		
		Rectangle rectangle = new Rectangle(Game.DIMENSION, Game.DIMENSION);
		rectangle.setLocation(Game.WIDTH / 2 * Game.DIMENSION, Game.HEIGHT / 2 * Game.DIMENSION);
		this.body.add(rectangle);
		
		rectangle = new Rectangle(Game.DIMENSION, Game.DIMENSION);
		rectangle.setLocation((Game.WIDTH / 2 - 1) * Game.DIMENSION, (Game.HEIGHT / 2) * Game.DIMENSION);
		this.body.add(rectangle);
		
		rectangle = new Rectangle(Game.DIMENSION, Game.DIMENSION);
		rectangle.setLocation((Game.WIDTH / 2 - 2) * Game.DIMENSION, (Game.HEIGHT / 2) * Game.DIMENSION);
		this.body.add(rectangle);
		
		this.move = "NOTHING";
	}
	
	public void move() {
		if(this.move != "NOTHING") {
			Rectangle first = this.body.get(0);
			Rectangle temp = new Rectangle(Game.DIMENSION, Game.DIMENSION);
			
			if(this.move == "UP") {
				temp.setLocation(first.x, first.y - Game.DIMENSION);
				
			} else if(this.move == "DOWN") {
				temp.setLocation(first.x, first.y + Game.DIMENSION);
			} else if(this.move == "LEFT") {
				temp.setLocation(first.x - Game.DIMENSION, first.y);
			} else {
				temp.setLocation(first.x + Game.DIMENSION, first.y);
			}
			
			body.add(0,temp);
			body.remove(body.size() - 1);
		}
	}
	
	public void grow( ) {
		Rectangle first = this.body.get(0);
		Rectangle temp = new Rectangle(Game.DIMENSION, Game.DIMENSION);
		
		if(this.move == "UP") {
			temp.setLocation(first.x, first.y - Game.DIMENSION);
			
		} else if(this.move == "DOWN") {
			temp.setLocation(first.x, first.y + Game.DIMENSION);
		} else if(this.move == "LEFT") {
			temp.setLocation(first.x - Game.DIMENSION, first.y);
		} else {
			temp.setLocation(first.x + Game.DIMENSION, first.y);
		}
		
		body.add(0, temp);
	}
	
	public ArrayList<Rectangle> getBody() {
		return this.body;
	}
	
	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public int getX() {
		return this.body.get(0).x;
	}
	
	public int getY() {
		return this.body.get(0).y;
	}
	
	public void up() {
		if(this.move != "DOWN")
			this.move = "UP";
	}
	
	public void down() {
		if(this.move != "UP")
			this.move = "DOWN";
	}
	
	public void left() {
		if(this.move != "RIGHT")
			this.move = "LEFT";
	}
	
	public void right() {
		if(this.move != "LEFT")
			this.move = "RIGHT";
	}
}
