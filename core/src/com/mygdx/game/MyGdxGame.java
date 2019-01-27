package com.mygdx.game;

import com.badlogic.gdx.Preferences;
import com.mygdx.game.com.mygdx.game.screens.GameScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.com.mygdx.game.screens.MannetjieScreen;
import com.mygdx.game.com.mygdx.game.screens.MenuScreen;

import javax.xml.soap.Text;

public class MyGdxGame extends Game {
	public SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));

	}




	@Override
	public void render () {
		super.render();
	}
}
