package com.gidantic.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by IVAN on 14.1.2016 г..
 */
public class Animation {


    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private int frameCount;
    private int frame;
    private float currentFrameTime;

    public Animation(TextureRegion region,float frameTime,int frameCount){
       int frameWidth= region.getRegionWidth()/frameCount;
        frames= new Array<TextureRegion>();
        for(int i=0;i<frameCount;i++){
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));

        }
        maxFrameTime=frameTime/frameCount;
        this.frameCount=frameCount;
        frame=0;

    }
    public void update(float dt){
        currentFrameTime+=dt;
        if(currentFrameTime>maxFrameTime){
            frame++;
            currentFrameTime=0;
        }
        if(frame>=frameCount){
            frame=0;
        }

    }
    public TextureRegion getFrame(){
        return frames.get(frame);
    }

}
