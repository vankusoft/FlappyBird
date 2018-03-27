package com.gidantic.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gidantic.game.FlappyDemo;

/**
 * Created by IVAN on 10.1.2016 г..
 */
public class MenuState extends State {

    private Texture background,playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background= new Texture("bg.png");
        playBtn= new Texture("playbtn.png");
    }

    @Override
    protected void update(float dt) {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0,FlappyDemo.WIDTH,FlappyDemo.HEIGHT);
        sb.draw(playBtn,FlappyDemo.WIDTH/2-(playBtn.getWidth()/2),FlappyDemo.HEIGHT/2);
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
