package com.gidantic.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.gidantic.game.FlappyDemo;
import com.gidantic.game.sprite.Animation;
import com.gidantic.game.sprite.Bird;
import com.gidantic.game.sprite.Tube;

/**
 * Created by IVAN on 10.1.2016 г..
 */
public class PlayState extends State {

    private Texture background;
    private Bird bird;
    private Array<Tube> tubes;
    Tube tube;
    private static final int tubeCount=4;
    private static final int tubeSpacing=125;
    private Texture ground;
    private Vector2 groundPos1,groundPos2;
    private static final int GROUND_OFFSET=-30;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background= new Texture("bg.png");
        ground= new Texture("ground.png");
        groundPos1= new Vector2(cam.position.x-(cam.viewportWidth/2),GROUND_OFFSET);
        groundPos2= new Vector2(cam.position.x-(cam.viewportWidth/2)+ground.getWidth(),GROUND_OFFSET);

        bird= new Bird(50,300);
        tubes= new Array<Tube>();
        for(int i=1;i<=tubeCount;i++){
            tubes.add(new Tube(i*(tubeSpacing+Tube.TUBE_WIDTH)));
        }

    }

    @Override
    protected void update(float dt) {
        cam.position.x= bird.getPosition().x+80;

        bird.update(dt);
        if(Gdx.input.justTouched()){
            bird.jump();
        }
        for(int t=0;t<tubeCount;t++){
            Tube tube=tubes.get(t);
                if (cam.position.x - (cam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                    tube.reposition(tube.getPosTopTube().x+((tubeSpacing+tube.TUBE_WIDTH)*tubeCount));
                }
                if (cam.position.x - (cam.viewportWidth / 2) > tube.getPosBottomTube().x + tube.getBottomTube().getWidth()) {
                    tube.reposition(tube.getPosBottomTube().x + ((tubeSpacing + Tube.TUBE_WIDTH) * tubeCount));
                }
            if(tube.collusion(bird.getBirdCollusion())){
                gsm.set(new PlayState(gsm));
            }

        }
        if(bird.getPosition().y<ground.getHeight()+GROUND_OFFSET){
            gsm.set(new PlayState(gsm));
        }
        if(bird.getPosition().y<ground.getHeight()+GROUND_OFFSET){
            gsm.set(new PlayState(gsm));
        }
        if(cam.position.x-(cam.viewportWidth/2)>groundPos1.x+ground.getWidth()){
            groundPos1.set(cam.position.x-(cam.viewportWidth/2)+ground.getWidth(),GROUND_OFFSET);
        }
        if(cam.position.x-(cam.viewportWidth/2)>groundPos2.x+ground.getWidth()){
            groundPos2.set(cam.position.x-(cam.viewportWidth/2)+ground.getWidth(),GROUND_OFFSET);
        }

        cam.update();
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,cam.position.x-(cam.viewportWidth/2),cam.position.y-(cam.viewportHeight/2));
        sb.draw(bird.getTextureBird(),bird.getPosition().x,bird.getPosition().y);

        for(int a=0;a<tubeCount;a++){
            Tube tube = tubes.get(a);
            sb.draw(tube.getTopTube(),tube.getPosTopTube().x,tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(),tube.getPosBottomTube().x,tube.getPosBottomTube().y);
        }
        sb.draw(ground,groundPos1.x,groundPos1.y);
        sb.draw(ground,groundPos2.x,groundPos2.y);

        sb.end();


    }

    @Override
    protected void dispose() {

    }
}
