package com.mygdx.game.test2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class MyTank extends Sprite {

    public World world;
    public Body b2body;

    public MyTank(playscreen screen, String str){
        this.world = playscreen.getWorld();
        defineTank();
        Sprite tankbody = new Sprite(new Texture(str));
        tankbody.setPosition(50, 1140);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().x - getHeight());
    }

    public void defineTank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(500,1140);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);
//        shape.setPosition(new Vector2(0, -14 / 100));
    }
//    public void updateTank(float delta){
//        setPosition(b2body.getPosition().x-getWidth()/2, b2body.getPosition().y -getHeight() /2);
//    }

    public void fire(){
//        fireballs.add(new FireBall(screen, b2body.getPosition().x, b2body.getPosition().y, runningRight ? true : false));
    }

    public void draw(Batch batch){
        super.draw(batch);
    }
}
