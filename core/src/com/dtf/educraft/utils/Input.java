package com.dtf.educraft.utils;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor {
	
	public static boolean W,A,S,D,UP,DOWN,LEFT,RIGHT;
	public static boolean SPACE,ENTER;

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Keys.W: W = true;break;
		case Keys.A: A = true;break;
		case Keys.S: S = true;break;
		case Keys.D: D = true;break;
		case Keys.UP: UP = true;break;
		case Keys.DOWN: DOWN = true;break;
		case Keys.LEFT: LEFT = true;break;
		case Keys.RIGHT: RIGHT = true;break;
		case Keys.SPACE: SPACE = true;break;
		case Keys.ENTER: ENTER = true;break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Keys.W: W = false;break;
		case Keys.A: A = false;break;
		case Keys.S: S = false;break;
		case Keys.D: D = false;break;
		case Keys.UP: UP = false;break;
		case Keys.DOWN: DOWN = false;break;
		case Keys.LEFT: LEFT = false;break;
		case Keys.RIGHT: RIGHT = false;break;
		case Keys.SPACE: SPACE = false;break;
		case Keys.ENTER: ENTER = false;break;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
