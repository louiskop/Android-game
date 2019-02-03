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
    Texture Zuma;
    Texture defa;
    Texture Jan;
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
        Zuma = new Texture("Zuma/dak.png");
        defa = new Texture("default/dak.png");
        Jan = new Texture("Jan/dak.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Back,0,0,SizeW,SizeH);
        game.batch.draw(mannetjieopskrif,SizeW/2-(mannetjieopskrif.getWidth()*(SizeW/360))/2,SizeH-SizeH/8,mannetjieopskrif.getWidth()*(SizeW/360),mannetjieopskrif.getHeight()*(SizeW/360));
        game.batch.draw(mannetjieblok,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2,SizeH/2-(mannetjieblok.getHeight()*(SizeW/360))/2,mannetjieblok.getWidth()*(SizeW/360),mannetjieblok.getHeight()*(SizeW/360));
        game.batch.draw(gowbek,SizeW/12,SizeH/12,gowbek.getWidth()*(SizeW/360),gowbek.getHeight()*(SizeW/360));


        if (Gdx.input.getX()>SizeW/12&&Gdx.input.getX()<SizeW/12+gowbek.getWidth()*(SizeW/360)&&Gdx.input.getY()<SizeH-(SizeH/12) && Gdx.input.getY()>SizeH-(SizeH/12+gowbek.getHeight()*(SizeW/360))){
            game.setScreen(new MenuScreen(game));
        }

        if(true){
            game.batch.draw(defa,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6),SizeW / 4,SizeH / 7);
            if (Gdx.input.getX()>SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12&&Gdx.input.getX()<(SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12)+SizeW / 4&&Gdx.input.getY()>=(SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/2)&&Gdx.input.getY()<=((SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6))+SizeH / 7)-SizeH/2){
                game.speler = "default";
                game.unprefs.putString("speler","default");
                game.unprefs.flush();
                game.setScreen(new GameScreen(game));
            }

        }

        if (game.unMC == true){
            game.batch.draw(MC,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6),SizeW / 4,SizeH / 7);

            if (Gdx.input.getX()>SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3&&Gdx.input.getX()<(SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3)+SizeW / 4&&Gdx.input.getY()>=(SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/2)&&Gdx.input.getY()<=((SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6))+SizeH / 7)-SizeH/2){
                game.speler = "MC";
                game.unprefs.putString("speler","MC");
                game.unprefs.flush();
                game.setScreen(new GameScreen(game));
            }

        }
        if (game.unDeon == true){
            game.batch.draw(Deon,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3+SizeW/3,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6),SizeW / 4,SizeH / 7);

            if (Gdx.input.getX()>SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3+SizeW/3&&Gdx.input.getX()<(SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3+SizeW/3)+SizeW / 4&&Gdx.input.getY()>=(SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/2)&&Gdx.input.getY()<=((SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6))+SizeH / 7)-SizeH/2){
                game.speler = "Deon";
                game.unprefs.putString("speler","Deon");
                game.unprefs.flush();
                game.setScreen(new GameScreen(game));
            }
        }

        if(game.unZuma == true){
            game.batch.draw(Zuma,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/6,SizeW / 4,SizeH / 7);
            if (Gdx.input.getX()>SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12&&Gdx.input.getX()<(SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/12)+SizeW / 4&&Gdx.input.getY()>=(SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/2)+SizeH/6&&Gdx.input.getY()<=((SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6))+SizeH / 7)-SizeH/2+SizeH/6){
                game.speler = "Zuma";
                game.unprefs.putString("speler","Zuma");
                game.unprefs.flush();
                game.setScreen(new GameScreen(game));
            }

        }
        if(game.unJan == true){
            game.batch.draw(Jan,SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3,SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/6,SizeW / 4,SizeH / 7);
            if (Gdx.input.getX()>SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3&&Gdx.input.getX()<(SizeW/2-(mannetjieblok.getWidth()*(SizeW/360))/2+SizeW/3)+SizeW / 4&&Gdx.input.getY()>=(SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6)-SizeH/2)+SizeH/6&&Gdx.input.getY()<=((SizeH/2+(mannetjieblok.getHeight()*(SizeW/360))/2-(SizeH / 6))+SizeH / 7)-SizeH/2+SizeH/6){
                game.speler = "Jan";
                game.unprefs.putString("speler","Jan");
                game.unprefs.flush();
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
