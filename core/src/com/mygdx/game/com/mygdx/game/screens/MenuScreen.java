package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.MyGdxGame;



public class MenuScreen implements Screen {

    MyGdxGame game;
    Texture menuback;
    Texture playbut;
    Texture settingsbut;
    Texture custombut;
    Texture headinghigh;
    int SizeW = Gdx.graphics.getWidth();
    int SizeH = Gdx.graphics.getHeight();

    Sound select = Gdx.audio.newSound(Gdx.files.internal("sfx/select.wav"));
    static Music tune;
    BitmapFont font;
    public MenuScreen(MyGdxGame game){
        this.game = game;

    }

    @Override
    public void show() {
        menuback = new Texture("bluebg.png");
        playbut = new Texture("blueplaybut.png");
        custombut = new Texture("bluecustom.png");
        settingsbut = new Texture("bluesettings.png");
        headinghigh = new Texture("jy.png");
        tune = Gdx.audio.newMusic(Gdx.files.internal("backtrack.mp3"));
        tune.setLooping(true);
        tune.setVolume(0.5f);
        tune.play();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(SizeH/239);

    }

    @Override
    public void render(float delta) {
        Gdx.app.log("current volume",Float.toString(tune.getVolume()));
        Gdx.app.log("awewidt",Integer.toString(SizeH));
        game.batch.begin();
        game.batch.draw(menuback,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch.draw(playbut,Gdx.graphics.getWidth()/2-(playbut.getWidth()*(SizeW/360))/2,Gdx.graphics.getHeight()/2-(playbut.getHeight()*(SizeH/598))/2,playbut.getWidth()*(SizeW/360),playbut.getHeight()*(SizeH/598));
        game.batch.draw(custombut,SizeW-(SizeW/36)-custombut.getWidth()*(SizeW/360),SizeH/100,custombut.getWidth()*(SizeW/360),custombut.getHeight()*(SizeH/598));
        game.batch.draw(settingsbut,SizeW-(SizeW/36)-custombut.getWidth()*(SizeW/360)-SizeW/2,SizeH/100,custombut.getWidth()*(SizeW/360),custombut.getHeight()*(SizeH/598));
        game.batch.draw(headinghigh,SizeW/2-(headinghigh.getWidth()*(SizeW/360))/2+10,SizeH - SizeH/10,headinghigh.getWidth()*(SizeW/360),headinghigh.getHeight()*(SizeH/598));
        if(Gdx.input.justTouched()){
            if (Gdx.input.getX() > (Gdx.graphics.getWidth()/2-(playbut.getWidth()*(SizeW/360))/2)-10 && Gdx.input.getX() < ((Gdx.graphics.getWidth()/2-(playbut.getWidth()*(SizeW/360))/2)+playbut.getWidth()*(SizeW/360))+10&& Gdx.input.getY()>(Gdx.graphics.getHeight()/2-playbut.getHeight()/2)&& Gdx.input.getY()<(Gdx.graphics.getHeight()/2-playbut.getHeight()/2+(playbut.getHeight()*(SizeH/598)))){
                select.play(1.0f);
                game.setScreen(new GameScreen(game));

            }

        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        select.dispose();
    }
}
