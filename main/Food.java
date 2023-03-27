package main;

import java.awt.Rectangle;

public class Food {
	private int xPos;
	private int yPos;
	
	public Food(Snake player) {
		this.randomFoodSpawn(player);
	}
	
	public void randomFoodSpawn(Snake player) {
		
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			this.xPos = (int) (Math.random() * Game.WIDTH - 1);
			this.yPos = (int) (Math.random() * Game.HEIGHT - 1);
			
			for(Rectangle r: player.getBody()) {
				if(r.x == xPos && r.y == yPos)
					onSnake = true;
				
			}
			
		}
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
