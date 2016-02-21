package com.dtf.educraft.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dtf.educraft.MyGame;

public class MainMenu extends Screens {
	
	TextButton play;
	
	public MainMenu() {
		TextButtonStyle btnSty = new TextButtonStyle();
		btnSty.font = new BitmapFont();
		play = new TextButton("Play", btnSty);
		play.setPosition(Screens.WIDTH/2 - play.getWidth()/2, Screens.HEIGHT/2 - play.getHeight()/2);
		play.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent e, float x, float y) {
				MyGame.changeScreen(Screens.ARENA);
			}
		});
	}
	
	@Override
	public void show() {
		stage = new Stage();
		stage.addActor(play);
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render(float delta) {
		stage.act(delta);
		stage.draw();
	}

}
