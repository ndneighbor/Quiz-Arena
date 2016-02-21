package com.dtf.educraft.gameobjects;

import java.util.Random;

import com.dtf.educraft.screens.Arena;

public class Enemy extends GameObject {
	
	float speed = 2;
	float dir;
	Random r;
	public boolean isBattle;
	public int health;

	public Enemy(String file, float x, float y) {
		super(file, x, y);
		r = new Random();
		dir = (float) (r.nextFloat()*Math.PI - Math.PI/2);
		health = 10;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		if(cBox.overlaps(Arena.aggroBox)) {
			
		} else if(!isBattle){
			setX((float)(getX()+ speed*Math.cos(dir)));
			setY((float)(getY()+ speed*Math.sin(dir)));
		}
		if(getX() > 1280) {
			setX(0);
		}
		
		if(getX()+getWidth() < 0) {
			setX(1280);
		}
		
		if(getY() > 720) {
			setY(0);
		}
		
		if(getY()+getHeight() < 0) {
			setY(720);
		}
	}
	
	public int getDamage() {
		return r.nextInt(5) + 1;
	}
	
	public int getHealth() {
		return health;
	}
	

}
