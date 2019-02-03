package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.google.android.gms.ads.MobileAds;
import com.mygdx.game.com.mygdx.game.screens.MenuScreen;


public class MyGdxGame extends Game {

	public Preferences unprefs;
	public boolean unMC;
	public boolean unDeon;
	public boolean unJan;
	public boolean unZuma;
	public SpriteBatch batch;
	public String speler;



	@Override
	public void create () {
		unprefs = Gdx.app.getPreferences("Unlocked Preferences");
		unMC = unprefs.getBoolean("unMC",false);
		unDeon = unprefs.getBoolean("unDeon",false);
		unJan = unprefs.getBoolean("unJan",false);
		unZuma = unprefs.getBoolean("unZuma",false);
		speler = unprefs.getString("speler","default");
//		MobileAds.initialize(this, "ca-app-pub-3698674486064132~5480172561");
		batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));
	}




	@Override
	public void render () {
		super.render();
	}
}
