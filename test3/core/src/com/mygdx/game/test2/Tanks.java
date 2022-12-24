package com.mygdx.game.test2;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Tanks extends Sprite {
    public World world;
    public Body b2body, bulletBody;

    public playscreen screen;
    public Sprite tankLower, tankNosal;
    public Sprite tankNosal2;
    // Bullets Variables
    Vector2 position, barrelOffset;
    float angle;

//    Array<Bullet> bullets = new Array<Bullet>();

    public Tanks(OptionScreen screen){
        this.world = screen.getWorld();
        defineBullets();
//        tankLower = new Sprite(new Texture(GameScreen.str));
//        tankNosal = new Sprite(new Texture("nosal.png"));
//
//        tankLower.setPosition(50,290);
//        tankNosal.setPosition(120,360);
//
//        tankLower.setSize(200, 100);
//        tankNosal.setSize(150,30);
    }
    public void createTank(){

    }

    public void setPosition(float x, float y){
        tankLower.setPosition(x,y);
    }

    public void defineTanks(int x, int y, int tankWidth, int tankHeight, Boolean flip){
        if(flip) {
            BodyDef bdef = new BodyDef();
            bdef.position.set(225 / MyGdxGame.PPM, 1140 / MyGdxGame.PPM);
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body = world.createBody(bdef);

            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(100 / MyGdxGame.PPM);

            fdef.shape = shape;
            b2body.createFixture(fdef);

            tankLower = new Sprite(new Texture(GameScreen.str));
            tankNosal = new Sprite(new Texture("nosal.png"));

            tankLower.setPosition(x, y);
            tankNosal.setPosition(120, 360);
            tankLower.setSize(tankWidth, tankHeight);
            tankNosal.setSize(150, 30);
        }
        if (!flip){
            BodyDef bdef = new BodyDef();
            bdef.position.set(x / MyGdxGame.PPM, y / MyGdxGame.PPM);
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body = world.createBody(bdef);

            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(100 / MyGdxGame.PPM);

            fdef.shape = shape;
            b2body.createFixture(fdef);

            tankLower = new Sprite(new Texture("Buratino2.png"));
            tankNosal = new Sprite(new Texture("Inverted-nosal.png"));

            tankLower.setPosition(x, y);
            tankNosal.setPosition(x, 360);
            tankLower.setSize(tankWidth, tankHeight);
            tankNosal.setSize(150, 30);
        }
    }

    public void defineBullets(){
        BodyDef bulletBodyDef = new BodyDef();
        bulletBodyDef.type = BodyDef.BodyType.DynamicBody;
        bulletBody = world.createBody(bulletBodyDef);

        FixtureDef bulletDef = new FixtureDef();
        bulletDef.density = 1.0f;
        bulletDef.friction = 0.0f;
        bulletDef.restitution = 0.0f;
        CircleShape bulletShape = new CircleShape();
        bulletShape.setRadius(10f);

        bulletDef.shape = bulletShape;
        bulletBody.createFixture(bulletDef);
    }

//    public void update(float delta){
//        setPosition(b2body.getPosition().x-getWidth()/2, b2body.getPosition().y-getHeight()/2);
//    }
public static class healthbar{
    private static healthbar playerHealth = null;
    public healthbar getPlayerHealth(){
        if (playerHealth == null){
            playerHealth = new healthbar();
        }
        return  playerHealth;
    }
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    float tankhealth = 1.0f;

    public void renderHealth(float delta) {
        if (tankhealth > 0.5) {
            shapeRenderer.setColor(Color.GREEN);
        } else if (tankhealth > 0.25) {
            shapeRenderer.setColor(Color.YELLOW);
        } else {
            shapeRenderer.setColor(Color.RED);
        }

        float healthBarWidth = tankhealth * 100;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(200, 300, 200, 40);
        shapeRenderer.end();
    }
    public void takeDamage() {
        tankhealth -= 0.1f;
    }

}

}

class FireBullet{
    public Vector2 position = new Vector2();
    public Vector2 direction = new Vector2();

    public FireBullet(Vector2 position,  Vector2 direction)
    {
        this.position.set(position);
        this.direction.set(direction);
    }

    public void update(float delta) {
        float speed = 16.0f;
        position.add(direction.x * delta * speed, direction.y * delta * speed);
    }
}
