package com.dtf.educraft.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameObject extends Actor {
	
	Texture texture;
	ArrayList<TextureRegion> frames;
	boolean isAnime = false;
	protected int numFrames;
	public int currentFrame;
	boolean rotation;
	float rot;
	
	boolean isDead;
	
	Rectangle cBox;
	
	TextureRegion r;
	
	public GameObject() {
		
	}
	
	public GameObject(Pixmap pix, Color c) {
		pix.setColor(c);
		pix.fillRectangle(0, 0, pix.getWidth(), pix.getHeight());
		texture = new Texture(pix); 
		setWidth(pix.getWidth());
		setHeight(pix.getHeight());
		cBox = new Rectangle();
	}
	
	public GameObject(String file) {
		texture = new Texture(file);
		setWidth(texture.getWidth());
		setHeight(texture.getHeight());
		
		cBox = new Rectangle();
	}
	
	public GameObject(String file, float x, float y) {
		this(file);
		setPosition(x, y);
	}
	
	public GameObject(String file, float width, float height, int numFrames){
		this.numFrames = numFrames;
		texture = new Texture(file);
		frames = new ArrayList<TextureRegion>();
		setWidth(width);
		setHeight(height);
		for(int i = 0; i < numFrames; i++) {
			frames.add(new TextureRegion(texture,(int)(i*width),0,(int)width,(int)height));
		}
		isAnime = true;
		currentFrame = 0;
		cBox = new Rectangle();
		
	}
	
	@Override
	public void act(float delta) {
			cBox.set(getX(), getX(), getWidth(), getHeight());
	}
	
	public Rectangle getBox() {
		return cBox;
	}
	
	public void setRot(float rot) {
		setRotation(rot);
		rotation = true;
		r = new TextureRegion(texture);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(isAnime)
			batch.draw(frames.get(currentFrame), getX(), getY(), getWidth(), getHeight());
		else if(!rotation)
			batch.draw(texture, getX(), getY(), getWidth(), getHeight());
		else
			batch.draw(r, getX(), getY(), getX(), getY(), getWidth(), getHeight(), 1f, 1f, getRotation());
		
	}

}
