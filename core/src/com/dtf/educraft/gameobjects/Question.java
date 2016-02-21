package com.dtf.educraft.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.dtf.educraft.screens.Arena;
import com.dtf.educraft.screens.Screens;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator; 

public class Question extends GameObject {

	private Label question;
	private Label a;
	private Label b;
	private Label c;
	private Label d;
	private ArrayList<Label> labels;
	private String answer;
	
	public Question(String[] s, int ans) { 
		labels = new ArrayList<Label>();
		LabelStyle style = new LabelStyle();
		style.font = new BitmapFont();
		Pixmap pix = new Pixmap(50, 50, Format.RGB888);
		pix.setColor(Color.WHITE);
		pix.fillRectangle(0, 0, 50, 50);
		answer = s[ans];
		//style.background = new TextureRegionDrawable(new TextureRegion(new Texture(pix)));

		ClickListener cl = new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				for(Label label : labels) {
					label.remove();
					System.out.println(((Label)e.getTarget()).getText());
					System.out.println(answer);
					System.out.println(answer.equals(((Label)e.getTarget()).getText().toString()));
					if(((Label)e.getTarget()).getText().toString().equals(answer)) {
						System.out.println(((Label)e.getTarget()).getText());
						Arena.attack();
					}
				}
			}
		};
		
		LabelStyle style2 = new LabelStyle();
		style2.font = new BitmapFont(Gdx.files.internal("GUI/fipps1.fnt"));
		style2.background = new TextureRegionDrawable(new TextureRegion(new Texture(pix)));
		question = new Label(s[0], style2);
	    question.getStyle().font = new BitmapFont();
	    
		a = new Label(s[1], style);
		a.setUserObject("A");
		b = new Label(s[2], style);
		b.setUserObject("B");
		c = new Label(s[3], style);
		c.setUserObject("C");
		d = new Label(s[4], style);
		d.setUserObject("D");
		
		a.addListener(cl);
		b.addListener(cl);
		c.addListener(cl);
		d.addListener(cl);
		
		labels.add(question);
		labels.add(a);
		labels.add(b);
		labels.add(c);
		labels.add(d);
		
		question.setPosition(Screens.WIDTH/2 - question.getWidth()/2, Screens.HEIGHT*0.40f);
		a.setPosition(Screens.WIDTH/2 - a.getWidth()/2, Screens.HEIGHT*0.30f);
		b.setPosition(Screens.WIDTH/2 - b.getWidth()/2, Screens.HEIGHT*0.25f);
		c.setPosition(Screens.WIDTH/2 - c.getWidth()/2, Screens.HEIGHT*0.20f);
		d.setPosition(Screens.WIDTH/2 - d.getWidth()/2, Screens.HEIGHT*0.15f);
	}
	
	@Override
	public void act(float delta) {
		
	}
	
	@Override 
	public void draw(Batch batch, float parentAlpha) {
		/*question.draw(batch, parentAlpha);
		a.draw(batch, parentAlpha);
		b.draw(batch, parentAlpha);
		c.draw(batch, parentAlpha);
		d.draw(batch, parentAlpha);*/
	}
	
	public ArrayList<Label> getLabels() {
		return labels;
	}
	
}
