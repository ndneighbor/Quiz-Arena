package com.dtf.educraft;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dtf.educraft.screens.Arena;
import com.dtf.educraft.screens.MainMenu;
import com.dtf.educraft.screens.Screens;
import com.dtf.educraft.utils.Input;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture img;
	MainMenu mm;
	Arena a;
	static ArrayList<Screens> screens;
	
	public static Input input;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		screens = new ArrayList<Screens>();
		mm = new MainMenu();
		a = new Arena();
		screens.add(mm);
		screens.add(a);
		//img = new Texture("badlogic.jpg");
		
		input = new Input();
		//Gdx.input.setInputProcessor(input);
		
		mm.show();
	}
	
	public static void changeScreen(int currScr) {
		screens.get(Screens.CURRENT_SCREEN).hide();
		screens.get(currScr).show();
		Screens.CURRENT_SCREEN = currScr;
	}
	
	/*String in = " \"term\" ";
		String out = "";
		for(int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			if(c == '"' && in.charAt(i+1) == 't') {
				while(c != ' ') {
					i++;
					c = in.charAt(i);
				}
				
				i++;
				c = in.charAt(i);
				while(c != '"') {
					out += c;
				}
			}
		}*/

	
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0.25f, 0.23f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0);
		screens.get(Screens.CURRENT_SCREEN).render(Gdx.graphics.getDeltaTime());
		batch.end();
	}
}
