package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import javax.xml.soap.Text;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture player;
	Texture targetplayer;
	Texture backie;
	Texture[] bullet = new Texture[20];
	Texture[] bars = new Texture[3];
	int currentbullet=0;
	int theifstatementfix = 0;
	int visibullet = 0;
	int count0bullet = 0;

	int sizeW;
	int sizeH;
	float playerY;
	float[] bulletY = new float[20];
	int velocity=0;

	int[] barY = new int[3];
	int barvelocity = 0;

//	collision shit (obstacles not yet added)

	Rectangle enemycollision = new Rectangle();
	Rectangle[] bulletcollision = new Rectangle[20];
	int[] alreadycollided=new int[20];
	int score = -18;
	int highscore = 0;
	BitmapFont font;


	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Texture("bird.png");
		targetplayer = new Texture("enemy.png");
		backie = new Texture("bg.png");

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
	public void render () {
		batch.begin();
		batch.draw(backie,0,0,sizeW,sizeH);
		batch.draw(player,(sizeW/2)-(sizeW/6)/2,playerY,sizeW/6,sizeH/12);
		batch.draw(targetplayer, (sizeW/2)-(sizeW/2)/2,playerY*8,sizeW/2,sizeH/6);
		enemycollision.set((sizeW/2)-(sizeW/2)/2,playerY*8,sizeW/2,sizeH/6);


		for(int i = 0;i<3;i=i+1){
			batch.draw(bars[i],barY[i],sizeH/2-sizeH/24,sizeW/3,sizeH/12);
			barY[i] = barY[i]-barvelocity;
			Gdx.app.log("bar","maid");
			Gdx.app.log("velocity of bar",Integer.toString(barvelocity));


		}


		if(Gdx.input.justTouched()){
			Gdx.app.log("executed","ifstatestatus:"+Integer.toString(theifstatementfix));
			if(theifstatementfix == 0) {
				if(currentbullet == 0){
					bulletY[currentbullet] = playerY+sizeH/12;
				}
				shootbullets();
				theifstatementfix = 1;
			}
			else if(theifstatementfix != 0){
				currentbullet++;
				bulletY[currentbullet] = playerY+sizeH/12;
				shootbullets();

			}

		}





		if(visibullet == 1){

			if (currentbullet == 0 && count0bullet == 0){
				count0bullet = 1;
			}

			if(count0bullet == 1){
				for (int i=0; i<currentbullet+1;i=i+1){
					batch.draw(bullet[i],sizeW/2-bullet[i].getWidth(),bulletY[i],sizeW/12,sizeH/28);
					bulletcollision[i] = new Rectangle(sizeW/2-bullet[i].getWidth(),bulletY[i],sizeW/12,sizeH/28);
					bulletY[i] += velocity;
					theifstatementfix = 1;
					count0bullet = 2;
				}
			}

			if (count0bullet!=1){
				for(int i=0; i < 19;i = i+1){
					batch.draw(bullet[i],sizeW/2-bullet[i].getWidth(),bulletY[i],sizeW/12,sizeH/28);
					bulletcollision[i] = new Rectangle(sizeW/2-bullet[i].getWidth(),bulletY[i],sizeW/12,sizeH/28);

					bulletY[i] += velocity;

				}
			}


			}

		if(count0bullet == 1) {
			for (int i = 0; i < currentbullet + 1; i = i + 1) {
				if (bulletcollision[i] != null){
					if (Intersector.overlaps(enemycollision, bulletcollision[i])) {
						Gdx.app.log("enemy", "-20 health");
						bulletY[i]=sizeH+500;

					}
				}

			}
		}
		if (count0bullet!=1){
			for(int i=0; i < 19;i = i+1) {
				if(bulletcollision[i] != null){
					if (Intersector.overlaps(enemycollision, bulletcollision[i])) {
						Gdx.app.log("enemy", "-20 health");
						score = score+1;
						bulletY[i]=sizeH+500;
					}
				}

			}
		}

		if(score>0){
			font.draw(batch, String.valueOf(score),100,Gdx.graphics.getHeight()-200);
			barvelocity = sizeH/80;

		}
		batch.end();



	}
}
