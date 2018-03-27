package com.gidantic.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


/**
 * Created by IVAN on 10.1.2016 г..
 */
public abstract class State {

    protected Vector3 pointer;
    protected GameStateManager gsm;
    protected OrthographicCamera cam;

    public State(GameStateManager gsm){
        this.gsm=gsm;
        pointer= new Vector3();
        cam= new OrthographicCamera();
    }

    protected abstract void update(float dt);
    protected abstract void render(SpriteBatch sb);
    protected abstract void dispose();
}
