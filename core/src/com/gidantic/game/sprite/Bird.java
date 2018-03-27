package com.gidantic.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by IVAN on 10.1.2016 г..
 */
public class Bird  {

    private static final int GRAVITY=-15;
    private static final int MOVEMENT=100;
    private Vector3 velocity,position;
    private Texture textureBird;
    private Animation birdAnimation;
    private Rectangle birdCollusion;


    public Bird(int x,int y){
        textureBird= new Texture("birdanimation.png");
        birdAnimation= new Animation(new TextureRegion(textureBird),0.3f,3);

        velocity= new Vector3(0,0,0);
        position= new Vector3(x,y,0);
        birdCollusion= new Rectangle(x,y,textureBird.getWidth()/3,textureBird.getHeight());

    }
    public void update(float dt){
        birdAnimation.update(dt);
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(MOVEMENT*dt,velocity.y,0);
        velocity.scl(1/dt);
        birdCollusion.setPosition(position.x,position.y);
    }

    public TextureRegion getTextureBird() {
        return birdAnimation.getFrame();
    }

    public Vector3 getPosition() {
        return position;
    }

    public void jump(){
        velocity.y=300;
    }
    public Rectangle getBirdCollusion(){
        return birdCollusion;
    }

}
