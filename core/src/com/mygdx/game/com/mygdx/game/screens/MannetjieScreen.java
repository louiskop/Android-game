package com.mygdx.game.com.mygdx.game.screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class MannetjieScreen implements Screen{


    MyGdxGame game;
    Texture mannetjieopskrif;
    Texture mannetjieblok;
    Texture Back;
    Texture gowbek;
    Texture MC;
    Texture Deon;
    int SizeW = Gdx.graphics.getWidth();
    int SizeH = Gdx.graphics.getHeight();

    public MannetjieScreen(MyGdxGame game){
        this.game = game;
    }

    @Override
    public void show() {
        mannetjieopskrif = new Texture("mannetjieopskrif.png");
        Back = new Texture("bluebg.png");
        mannetjieblok = new Texture("mannetjieblokkie.png");
        gowbek = new Texture("backbutchar.png");
        MC = new Texture("MC/dak.png");
        Deon = new Texture("Deon/dak.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Back,0,0,SizeW,SizeH);
        game.batch.draw(mannetjieopskrif,SizeW/2-(mannetjieopskrif.getWidth()*(SizeW/360))/2,SizeH-SizeH/8,mannetjieopskrif.getWidth()*(SizeW/360),mannetjieopskrif.getHeight()*(SizeW/360));
        game.batch.draw(mannetjieblok,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2,SizeH/2-(mannetjieblok.getHeight()*(SizeW/360))/2,mannetjieblok.getWidth()*(SizeW/360),mannetjieblok.getHeight()*(SizeW/360));
        game.batch.draw(gowbek,SizeW/12,SizeH/12,gowbek.getWidth()*(SizeW/360),gowbek.getHeight()*(SizeW/360));

        Gdx.app.log("x",Integer.toString(Gdx.input.getX()));
        Gdx.app.log("y",Integer.toString(Gdx.input.getY()));

        if (game.unMC == true){
            game.batch.draw(MC,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6),SizeW / 4,SizeH / 7);

            if (Gdx.input.getX()>SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12&&Gdx.input.getX()<(SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12)+SizeW / 4&&Gdx.input.getY()>=(SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/2)&&Gdx.input.getY()<=((SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6))+SizeH / 7)-SizeH/2){
                game.speler = "MC";
                game.unprefs.putString("speler","MC");
                game.unprefs.flush();
                game.setScreen(new GameScreen(game));
            }

        }
        if (game.unDeon == true){
            game.batch.draw(Deon,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/4,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6),SizeW / 4,SizeH / 7);

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
