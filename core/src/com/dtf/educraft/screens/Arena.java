package com.dtf.educraft.screens;

import java.util.ArrayList;
import java.util.Random;

import javax.script.ScriptEngineManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dtf.educraft.MyGame;
import com.dtf.educraft.gameobjects.Enemy;
import com.dtf.educraft.gameobjects.GameObject;
import com.dtf.educraft.gameobjects.Player;
import com.dtf.educraft.gameobjects.Question;
import com.dtf.educraft.utils.Input;
import com.dtf.educraft.utils.Rest;


public class Arena extends Screens {
	
	ArrayList<Label> menu;
	Image select;
	int idx;
	float inputDelay;
	Player player = new Player("boy.png", 20, 30, 12);
	
	ScriptEngineManager sm;//LOAD QUIZ DATA!!!
	
	GameObject healthBar;
	GameObject EhealthBar;
	
	public static float px, py;
	public static Rectangle aggroBox;
	
	InputMultiplexer im;
	
	ArrayList<Enemy> enemies;
	
	Random r;
	
	public static int turn;
	
	Enemy battle;
	
	GameObject battlePlayer;
	
	String[] terms;
	String[] def;
	
	float aTime;
	static boolean pAttack;
	static boolean eAttack;
	
	static GameObject glow;
	
	GameObject beam;
	Rest rest;
	
	float eAtt;
	
	public Arena() {
		player.setPosition(500, 500);
		player.setWidth(20*2);
		player.setHeight(30*2);
		turn = 0;
		r =  new Random();
		menu = new ArrayList<Label>();
		LabelStyle lSty = new LabelStyle();
		lSty.font = new BitmapFont();
		String[] str = {"Attack","Defend","Potions","Retreat"};
		for(int i = 0; i < 4; i++) {
			menu.add(new Label(str[i], lSty));
		}
		menu.get(0).setPosition(100, 100);
		menu.get(1).setPosition(200, 100);
		menu.get(2).setPosition(100, 10);
		menu.get(3).setPosition(200, 10);
		menu.get(0).addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				if(turn == 0) {
					loadQuestion(0);
					turn++;
				}
			}
		});
		idx = 0;
		select = new Image(new Texture("GUI/Select.png"));
		
		healthBar = new GameObject(new Pixmap(100, 15, Format.RGB888), Color.RED);
		healthBar.setPosition(Screens.WIDTH - 250, 250);
		
		EhealthBar = new GameObject(new Pixmap(100, 15, Format.RGB888), Color.RED);
		EhealthBar.setPosition(100, 400);
		
		beam = new GameObject(new Pixmap(1520, 60, Format.RGB888), Color.RED);
		
		aggroBox = new Rectangle();
		
		enemies = new ArrayList<Enemy>();
		
		for(int i = 0; i < 6; i++) {
			enemies.add(new Enemy("flyingthing.png", r.nextFloat()*1280, r.nextFloat()*720));
		}
		
		battlePlayer = new GameObject("bigboy.png", 1000, 0);
		
		glow = new GameObject("glow.png", 1,1);
	}
	
	@Override
	public void show() {
		stage = new Stage();
		/*for(Label label : menu)
			stage.addActor(label);*/
		//stage.addActor(select);
		stage.addActor(player);
		//stage.addActor(healthBar);
		for(Enemy enemy : enemies) {
			stage.addActor(enemy);
		}
		im = new InputMultiplexer(stage, MyGame.input);
		Gdx.input.setInputProcessor(im);
	}
	
	@Override
	public void render(float delta) {
		stage.act(delta);
		update();
		handleInput(delta);
		select.setPosition(menu.get(idx).getX() - 15, menu.get(idx).getY());
		float width = 0;
		float height = 0;
		if(pAttack) {
			if(aTime < 2.3f) {
				aTime += delta;
				width = glow.getWidth();
				height = glow.getHeight();
				glow.setWidth(glow.getWidth()+15);
				glow.setHeight(glow.getHeight()+15);
				glow.setX(glow.getX() - 7.5f);
				glow.setY(glow.getY() - 7.5f);
			} else {
				pAttack = false;
				stage.addActor(beam);
				battle.health -= 3;
			}
		} else {
			glow.remove();
			glow.setWidth(width);
			glow.setHeight(height);
			beam.remove();
			aTime = 0;
		}
		
		if(eAttack) {
			if(eAtt < 10) {
				eAtt += delta;
			} else {
				eAtt = 0;
				player.takeDmg(battle.getDamage());
			}
		}
		stage.draw();
	}
	
	private void update() {
		px = player.getX(); py = player.getY();
		aggroBox.set(player.getX() - 50, player.getY() - 50, player.getWidth() + 100, player.getHeight() + 100);
		healthBar.setWidth(player.getHealth()*150/Player.maxHealth);
		
		if(battle != null)
			EhealthBar.setWidth(battle.getHealth()*100/10);
		
		for(Enemy enemy : enemies ) {
			if((Input.ENTER || Input.SPACE) && enemy.getBox().overlaps(player.getBox())) {
				loadBattle(enemy);
				break;
			}
		}
		
		if(turn == 1) {
			player.takeDmg(battle.getDamage());
			turn--;
		}
	}
	
	private void loadBattle(Enemy enemy) {
		GameObject bg = new GameObject("GUI/inside.png");
		bg.setWidth(1280);
		bg.setHeight(720);
		stage.addActor(bg);
		player.setPosition(1000, 0);
		for(Label label : menu)
			stage.addActor(label);
		battle = enemy;
		battle.setWidth(battle.getWidth()*2.5f);
		battle.setHeight(battle.getHeight()*2.5f);
		stage.addActor(enemy);
		stage.addActor(healthBar);
		stage.addActor(battlePlayer);
		stage.addActor(EhealthBar);
		
		glow.setPosition(battlePlayer.getX() - 65, battlePlayer.getY()+55);
		beam.setPosition(-100, 680);
		beam.setRot(-22);
		//stage.addActor(beam);
		stage.addActor(glow);//sdfgsdgf
		
		
		enemy.setPosition(100, Screens.HEIGHT - enemy.getHeight() - 150);
		enemy.isBattle = true;
		
		eAttack = true;
	}
	
	private void loadQuestion(int command) {
		rest = new Rest();
		Random r = new Random();
		String[] s= new String[5];
		int i = r.nextInt(30) + 1;
		int a = r.nextInt(4)+1;
		s[0] = Rest.TERMS[i+3];
		s[a] = Rest.DEFS[i];
		System.out.println(s[a]);
		for(int x = 1; x < 5; x++) {
			if(x != a) {
				s[x] = Rest.DEFS[r.nextInt(30) + 1];
				//System.out.println(s[x]);
			}
		}
		
		for(int j = 0; j < 5; j++) {
			//System.out.println(s[j]);
		}
		
		Question q = new Question(s, a);
		for(Label label : q.getLabels())
			stage.addActor(label);
	}
	
	public static void attack() {
		stage.addActor(glow);
		pAttack = true;
	}
	
	private void handleInput(float delta) {
		/*inputDelay += delta;
		if(inputDelay < 0.2f)
			return;
		else
			inputDelay = 0;
		if(Input.D) {
			if(idx < 3)
				idx++;
			else 
				idx = 0;		
		} else if(Input.A) {
			if(idx > 0)
				idx--;
			else 
				idx = 3 ;		
		} else if(Input.W) {
			if(idx+2 < 4)
				idx+=2;
			else 
				idx -= 2;		
		} else if(Input.S) {
			if(idx-2 > -1)
				idx-=2;
			else 
				idx += 2;		
		}*/
	}

}
