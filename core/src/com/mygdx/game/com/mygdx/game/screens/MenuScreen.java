package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;



public class MenuScreen implements Screen {

    MyGdxGame game;
    Texture menuback;
    Texture playbut;
    Texture settingsbut;
    Texture custombut;
    int SizeW = Gdx.graphics.getWidth();
    int SizeH = Gdx.graphics.getHeight();

    public MenuScreen(MyGdxGame game){
        this.game = game;

    }


    @Override
    public void show() {
        menuback = new Texture("bluebg.png");
        playbut = new Texture("blueplaybut.png");
        custombut = new Texture("bluecustom.png");
        settingsbut = new Texture("bluesettings.png");

    }

    @Override
    public void render(float delta) {
        Gdx.app.log("awewidt",Integer.toString(SizeH));
        game.batch.begin();
        game.batch.draw(menuback,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch.draw(playbut,Gdx.graphics.getWidth()/2-(playbut.getWidth()*(SizeW/360))/2,Gdx.graphics.getHeight()/2-(playbut.getHeight()*(SizeH/598))/2,playbut.getWidth()*(SizeW/360),playbut.getHeight()*(SizeH/598));
        game.batch.draw(custombut,SizeW-(SizeW/36)-custombut.getWidth()*(SizeW/360),SizeH/100,custombut.getWidth()*(SizeW/360),custombut.getHeight()*(SizeH/598));
        game.batch.draw(settingsbut,SizeW-(SizeW/36)-custombut.getWidth()*(SizeW/360)-SizeW/2,SizeH/100,custombut.getWidth()*(SizeW/360),custombut.getHeight()*(SizeH/598));

        if(Gdx.input.justTouched()){
            if (Gdx.input.getX() > (Gdx.graphics.getWidth()/2-(playbut.getWidth()*(SizeW/360))/2)-10 && Gdx.input.getX() < ((Gdx.graphics.getWidth()/2-(playbut.getWidth()*(SizeW/360))/2)+playbut.getWidth()*(SizeW/360))+10&& Gdx.input.getY()>(Gdx.graphics.getHeight()/2-playbut.getHeight()/2)&& Gdx.input.getY()<(Gdx.graphics.getHeight()/2-playbut.getHeight()/2+(playbut.getHeight()*(SizeH/598)))){
//               animation van click of sound dat click gebeer het
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

    }
}
