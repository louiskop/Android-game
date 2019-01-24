package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame;

import java.util.Random;

public class GameScreen implements Screen{



    Texture player;
    Texture targetplayer;
    Texture backie;
    Texture[] bullet = new Texture[20];
    Texture[] bars = new Texture[3];
    Texture gameover;
    int currentbullet=0;
    int theifstatementfix = 0;
    int visibullet = 0;
    int count0bullet = 0;
    int Gamestate = 0;

    int sizeW;
    int sizeH;
    float playerY;
    float[] bulletY = new float[20];
    int velocity=0;

    int[] barY = new int[3];
    int barvelocity = 0;
    boolean randombarinit = false;
    Random randomNum = new Random();
    int barWidth;
    Preferences prefs = Gdx.app.getPreferences("My Preferences");

//	collision shit

    Rectangle enemycollision = new Rectangle();
    Rectangle[] bulletcollision = new Rectangle[20];
    Rectangle[] barscollision = new Rectangle[3];
    int[] alreadycollided=new int[20];
    int score = -18;
    int highscore = prefs.getInteger("highscore", 0);

    BitmapFont font;

    MyGdxGame game;

    public GameScreen(MyGdxGame game){
        this.game = game;
    }


    @Override
    public void show() {
        player = new Texture("ferninnn.png");
        targetplayer = new Texture("enemy.png");
        backie = new Texture("bluebg.png");
        gameover = new Texture("gameover.png");

        for(int i=0; i<3;i=i+1){
            bars[i] = new Texture("obstacle-bar.png");
        }
        for(int i=0;i<20;i = i+1){
            bullet[i]=new Texture("bullet.png");
            bulletY[i]= sizeH+500;
            alreadycollided[i] = 0;
        }
        sizeW = Gdx.graphics.getWidth();
        sizeH = Gdx.graphics.getHeight();
        Gdx.app.log("width",Integer.toString(sizeW));
        Gdx.app.log("height",Integer.toString(sizeH));
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(sizeH/239);
        playerY = sizeH/10;
        Gdx.app.log("sze",Integer.toString(sizeH));
        barY[0] = 0;
        barY[1] = 2*(sizeW/3);
        barY[2] = barY[1] +2*(sizeW/3);
        barWidth = sizeW / 3;
    }

    public void shootbullets() {
        Gdx.app.log("player","shoot");
        if (currentbullet == 19) {
            currentbullet = 0;
        }
        bulletY[currentbullet] = playerY+sizeH/12;
        velocity = sizeH/80;
        visibullet = 1;
    }



    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(backie, 0, 0, sizeW, sizeH);
        game.batch.draw(player, (sizeW / 2) - (sizeW / 6) / 2, playerY, sizeW / 6, sizeH / 12);
        game.batch.draw(targetplayer, (sizeW / 2) - (sizeW / 2) / 2, playerY * 8, sizeW / 2, sizeH / 6);
        enemycollision.set((sizeW / 2) - (sizeW / 2) / 2, playerY * 8, sizeW / 2, sizeH / 6);

        if (Gamestate == 1){
            game.batch.draw(gameover,sizeW/2 - (sizeW/2)/2,sizeH/2-(sizeH/3)/2,sizeW/2,sizeH/3);
            font.draw(game.batch, String.valueOf(highscore), sizeW/2 - ((sizeW/2)/2)+sizeW/3,(sizeH/2+sizeH/6+sizeH/20)-(sizeH/3)/2);

            if(Gdx.input.justTouched()){
                currentbullet=0;
                theifstatementfix = 0;
                visibullet = 0;
                count0bullet = 0;
                Gamestate = 0;
                barY[0] = 0;
                barY[1] = 2*(sizeW/3);
                barY[2] = barY[1] +2*(sizeW/3);
                score = 0;
                barvelocity = 0;
                barWidth = sizeW / 3;
                randombarinit = false;

                for(int i=0;i<20;i = i+1){
                    bulletY[i]= sizeH+500;
                    alreadycollided[i] = 0;
                }
            }
        }



        if (Gamestate == 0) {
            for (int i = 0; i < 3; i = i + 1) {
                if (barY[i] < -sizeW / 3) {
                    barY[i] = sizeW;
                    if(score>10 && i == 2) {
                        Gdx.app.log("ok","initialized random init");
                        randombarinit = true;
                    }
                }
                if (randombarinit == true){
                    barWidth =  sizeW/9+ randomNum.nextInt(sizeW / 3);
                    randombarinit = false;
                }
                game.batch.draw(bars[i], barY[i], sizeH / 2 - sizeH / 24, barWidth, sizeH / 12);
                barscollision[i] = new Rectangle(barY[i], sizeH / 2 - sizeH / 24, barWidth, sizeH / 12);
                barY[i] = barY[i] - barvelocity;
                Gdx.app.log("bar", "maid");


            }


            if (Gdx.input.justTouched()) {
                Gdx.app.log("executed", "ifstatestatus:" + Integer.toString(theifstatementfix));
                if (theifstatementfix == 0) {
                    if (currentbullet == 0) {
                        bulletY[currentbullet] = playerY + sizeH / 12;
                    }
                    shootbullets();
                    theifstatementfix = 1;
                } else if (theifstatementfix != 0) {
                    currentbullet++;
                    bulletY[currentbullet] = playerY + sizeH / 12;
                    shootbullets();

                }

            }


            if (visibullet == 1) {

                if (currentbullet == 0 && count0bullet == 0) {
                    count0bullet = 1;
                }

                if (count0bullet == 1) {
                    for (int i = 0; i < currentbullet + 1; i = i + 1) {
                        game.batch.draw(bullet[i], sizeW / 2 - bullet[i].getWidth(), bulletY[i], sizeW / 12, sizeH / 28);
                        bulletcollision[i] = new Rectangle(sizeW / 2 - bullet[i].getWidth(), bulletY[i], sizeW / 12, sizeH / 28);
                        bulletY[i] += velocity;
                        theifstatementfix = 1;
                        count0bullet = 2;
                    }
                }

                if (count0bullet != 1) {
                    for (int i = 0; i < 19; i = i + 1) {
                        game.batch.draw(bullet[i], sizeW / 2 - bullet[i].getWidth(), bulletY[i], sizeW / 12, sizeH / 28);
                        bulletcollision[i] = new Rectangle(sizeW / 2 - bullet[i].getWidth(), bulletY[i], sizeW / 12, sizeH / 28);

                        bulletY[i] += velocity;

                    }
                }


            }

            if (count0bullet == 1) {
                for (int i = 0; i < currentbullet + 1; i = i + 1) {
                    if (bulletcollision[i] != null) {
                        if (Intersector.overlaps(enemycollision, bulletcollision[i])) {
                            Gdx.app.log("enemy", "-20 health");
                            bulletY[i] = sizeH + 500;

                        }
                    }

                }
            }
            if (count0bullet != 1) {
                for (int i = 0; i < 19; i = i + 1) {
                    if (bulletcollision[i] != null) {
                        for (int bar = 0; bar < 3; bar = bar + 1) {
                            Gdx.app.log("col","ek loop daremm");
                            if (Intersector.overlaps( bulletcollision[i],barscollision[bar])) {
                                Gdx.app.log("col","yessss");
                                if(score>highscore){
                                    highscore = score;
                                    prefs.putInteger("highscore",highscore);
                                    prefs.flush();
                                }
                                Gamestate = 1;
                            }
                        }

                        if (Intersector.overlaps(enemycollision, bulletcollision[i])) {
                            Gdx.app.log("enemy", "-20 health");
                            score = score + 1;
                            bulletY[i] = sizeH + 500;
                        }
                    }

                }
            }

            if (score > 0) {
                font.draw(game.batch, String.valueOf(score), 100, Gdx.graphics.getHeight() - 200);
                if (score<10){
                    barvelocity = sizeH / 120;
                }
                if (score>5&&score<10){
                    barvelocity = sizeH / 100;

                }
                if (score>10){
                    barvelocity = sizeH / 100;

                }



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
