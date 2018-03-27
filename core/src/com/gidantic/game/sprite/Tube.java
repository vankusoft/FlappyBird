package com.gidantic.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by IVAN on 12.1.2016 г..
 */
public class Tube {


   public static final int TUBE_WIDTH=52;
   private static final int TUBE_GAP=140;
   private static final int FLUCTUATION=120;
   private static final int LOWEST_OPENING=110;
   private Vector2 posTopTube,posBottomTube;
   private Texture topTube,bottomTube;
    private Random rand;
    private Rectangle collTop,collBot;

    public Tube(int x){

        rand= new Random();
        topTube= new Texture("toptube.png");
        bottomTube= new Texture("bottomtube.png");
        posTopTube= new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBottomTube= new Vector2(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        collTop= new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
        collBot= new Rectangle(posBottomTube.x,posBottomTube.y,bottomTube.getWidth(),bottomTube.getHeight());

    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }
    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBottomTube.set(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        collTop.setPosition(getPosTopTube().x,getPosTopTube().y);
        collBot.setPosition(getPosBottomTube().x,getPosBottomTube().y);
    }
    public boolean collusion(Rectangle player){
        return player.overlaps(collTop)|| player.overlaps(collBot);
    }

}
