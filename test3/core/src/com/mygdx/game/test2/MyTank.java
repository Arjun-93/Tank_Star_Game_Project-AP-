package com.mygdx.game.test2;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class MyTank extends Sprite {

    public World world;
    public Body b2body;
    private playscreen screen;

    public MyTank(playscreen screen){
//        this.world = screen.getWorld();
        defineTank();
    }

    public void defineTank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(19320,11250);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);

        fdef.shape = shape;
        b2body.createFixture(fdef);

    }
    public void fire(){
//        fireballs.add(new FireBall(screen, b2body.getPosition().x, b2body.getPosition().y, runningRight ? true : false));
    }

    public void draw(Batch batch){
        super.draw(batch);
    }
}
