package com.mygdx.game.test2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class MyTank extends Sprite {

    public World world;
    public Body b2body;
    private playscreen screen;

    public MyTank(playscreen screen, String str){
        this.screen = screen;
        this.world = screen.getWorld();
        defineTank();
        Texture Tankbody = new Texture(str);
        setBounds(0,0,16,16);
        setRegion(Tankbody);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().x - getHeight());
    }

    public void defineTank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(19320,11250);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6);

        fdef.shape = shape;
        shape.setPosition(new Vector2(0, -14 / 100));
        b2body.createFixture(fdef).setUserData(this);
    }

    public void fire(){
//        fireballs.add(new FireBall(screen, b2body.getPosition().x, b2body.getPosition().y, runningRight ? true : false));
    }

    public void draw(Batch batch){
        super.draw(batch);
    }
}
