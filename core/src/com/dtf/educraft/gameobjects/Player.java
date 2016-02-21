package com.dtf.educraft.gameobjects;

import com.dtf.educraft.utils.Input;

public class Player extends GameObject {
	
	private float speed = 5;
	public static float maxHealth = 50;
	private float health;
	
	int[] frameList = new int[3];
	int indx;
	float aTime;
	
	public Player(String file, float x, float y) {
		super(file, x, y);
		health = maxHealth;
	}
	
	public Player(String file, float x, float y, int num) {
		super(file, x, y, num);
		health = maxHealth;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		if(Input.W){
			setY(getY() + speed);
			frameList[0] = 0;
			frameList[1] = 1;
			frameList[2] = 2;
		}
		if(Input.A) {
			setX(getX() - speed);
			frameList[0] = 9;
			frameList[1] = 10;
			frameList[2] = 11;
		}
		if(Input.S) {
			setY(getY() - speed);
			frameList[0] = 6;
			frameList[1] = 7;
			frameList[2] = 8;
		}
		if(Input.D) {
			setX(getX() + speed);
			frameList[0] = 3;
			frameList[1] = 4;
			frameList[2] = 5;
		}
		currentFrame = frameList[indx];
        if(aTime < 0.1f) {	
        	aTime+= delta; 
        } else {
        	if(Input.W || Input.A || Input.S || Input.D) {
        		if(indx < 2)
        			indx++;
        		else
        			indx = 0;
        	}
        	aTime = 0;
        }
			
	}
	
	public void takeDmg(int dmg) {
		health -= dmg;
	}
	
	public float getHealth() {
		return health;
	}

}
