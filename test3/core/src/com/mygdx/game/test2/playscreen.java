package com.mygdx.game.test2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class playscreen implements Screen {
    public static class Bullet
    {
        public Vector2 position = new Vector2();
        public Vector2 direction = new Vector2();

        public Bullet(Vector2 position,  Vector2 direction)
        {
            this.position.set(position);
            this.direction.set(direction);
        }

        public void update(float delta) {
            float speed = 16.0f;
            position.add(direction.x * delta * speed, direction.y * delta * speed);
        }
    }
    // Variables of Map.
    private Game game;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;
    private TmxMapLoader mapLoader;
    private OrthographicCamera gamecam;
    private float Map_Width = 25600;
    private float Map_Height = 3600;
    private Viewport gameport;

    private World world;
    private Box2DDebugRenderer b2dr;
    private Tanks Abrams;
    private  SpriteBatch batch;

    OrthographicCamera camera;
    SpriteBatch spriteBatch;
    ShapeRenderer shapeRenderer;
    Texture texture;

    Vector2 position;
    Vector2 barrelOffset;
    float angle;

    Array<Bullet> bullets;



    public playscreen(Game game, String  str){
        this.game = game;
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(MyGdxGame.V_WIDTH/MyGdxGame.PPM, MyGdxGame.V_HEIGHT/MyGdxGame.PPM,gamecam);
        // Map loading
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Map/Map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);

        world = new World(new Vector2(0,-10),true);
        b2dr = new Box2DDebugRenderer();
        makeRigid(b2dr,world);

        Abrams = new Tanks(this, str);


    }

    public World getWorld(){
        return this.world;
    }

    @Override
    public void show() {
    }

    public void handleInput(float delta) {

        // Tank movement
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            Abrams.tankLower.setPosition(Abrams.tankLower.getX()+27*delta, Abrams.tankLower.getY());
            Abrams.tankNosal.setPosition(Abrams.tankNosal.getX()+27*delta, Abrams.tankNosal.getY());
            Abrams.b2body.setLinearVelocity(new Vector2(50,0));

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            Abrams.tankLower.setPosition(Abrams.tankLower.getX()-27*delta, Abrams.tankLower.getY());
            Abrams.tankNosal.setPosition(Abrams.tankNosal.getX()-27*delta, Abrams.tankNosal.getY());
            Abrams.b2body.setLinearVelocity(new Vector2(-50,0));
        }
        if ((!Gdx.input.isKeyPressed(Input.Keys.D) &&
                !Gdx.input.isKeyPressed(Input.Keys.A) &&
                !Gdx.input.isKeyPressed(Input.Keys.SPACE))
                ||
                (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.A))){
            Abrams.b2body.setLinearVelocity(new Vector2(0, 0));
        }

        // Tank Nosal Rotation
        if(Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S)) {
            if(Abrams.tankNosal.getRotation() < 180) {
                Abrams.tankNosal.setOrigin(25, 0);
                Abrams.tankNosal.setRotation(Abrams.tankNosal.getRotation() + 2);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(Abrams.tankNosal.getRotation() > 0) {
                Abrams.tankNosal.setRotation(Abrams.tankNosal.getRotation() - 2);
                Abrams.tankNosal.setOrigin(25, 0);
            }
        }
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            float angle = Abrams.tankNosal.getRotation();
//            Vector2 impulse = new Vector2((float)Math.cos(angle), (float)Math.sin(angle));
//            impulse.scl(10.0f);
//            // Fire the bullet
//            Abrams.bulletBody.applyLinearImpulse(impulse,Abrams.bulletBody.getWorldCenter(), true);
//        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            // Create a new bullet fixture
            FixtureDef bulletDef = new FixtureDef();
            bulletDef.density = 2.0f;
            bulletDef.friction = 0.0f;
            bulletDef.restitution = 0.0f;
            CircleShape bulletShape = new CircleShape();
            bulletShape.setRadius(5f);
            bulletDef.shape = bulletShape;
            BodyDef bulletBodyDef = new BodyDef();
            bulletBodyDef.type = BodyDef.BodyType.KinematicBody;
            bulletBodyDef.position.set(Abrams.tankNosal.getX(),Abrams.tankNosal.getY());
            Body bulletBody = world.createBody(bulletBodyDef);
            bulletBody.createFixture(bulletDef);
            // Calculate the impulse to apply to the bullet based on the angle of the fixture body
            float angle = Abrams.tankNosal.getRotation();
            Vector2 impulse = new Vector2((float)Math.cos(angle), (float)Math.sin(angle));
            impulse.scl(10.0f);
            // Fire the bullet
            bulletBody.applyLinearImpulse(impulse, bulletBody.getWorldCenter(), true);
        }

    }
    public void update(float delta){
        handleInput(delta);
        world.step(1/60f, 6,6);
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Abrams.renderHealth(delta);
        Gdx.gl.glClearColor(1/255f, 41/255f, 55/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        renderer.setView(gamecam);
        gamecam.setToOrtho(false, this.Map_Width/2-10000, this.Map_Height/2+500);
        gamecam.update();

        MyGdxGame.batch.begin();
        Abrams.tankLower.draw(MyGdxGame.batch);
        Abrams.tankNosal.draw(MyGdxGame.batch);
        MyGdxGame.batch.end();

        b2dr.render(world, gamecam.combined);


        // Bullet Variables
//        Vector2 direction = (new Vector2(1.0f, 0.0f)).rotateDeg(angle); // unit vector of the direction of the player
//        Vector2 origin = new Vector2(0.5f, 0.5f); // rotation origin, rotate around the center of the image. ( 0,0 would have been upper left corner)
//        Vector2 offset = (new Vector2(barrelOffset)).rotateDeg(angle).add(origin); // Rotated barrel offset
//        Vector2 barrelPosition = (new Vector2(position)).add(offset);
//
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
//            bullets.add(new Bullet(barrelPosition, direction));
//
//        for(Bullet bullet : bullets)
//            bullet.update(delta);
//
//        spriteBatch.draw(Abrams.tankNosal,
//                position.x, position.y,
//                0.5f, 0.5f,
//                1, 1,
//                1, 1,
//                angle,
//                0, 0,
//                texture.getWidth(), texture.getHeight(),
//                false, false);
//
//        spriteBatch.end();
//
//        shapeRenderer.setProjectionMatrix(camera.combined);
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//
//        shapeRenderer.setColor(Color.RED);
//
//        for(Bullet bullet : bullets)
//            shapeRenderer.circle(bullet.position.x, bullet.position.y, 2f, 32);
//        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void makeRigid(Box2DDebugRenderer b2dr, World world){
        b2dr = new Box2DDebugRenderer();
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for ( RectangleMapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = object.getRectangle();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth()/2)/MyGdxGame.PPM, (rect.getY() + rect.getHeight()/2)/MyGdxGame.PPM);
            body = world.createBody(bodyDef);
            shape.setAsBox(rect.getWidth()/2/MyGdxGame.PPM , rect.getHeight()/2/MyGdxGame.PPM);
            fdef.shape = shape;
            fdef.friction = 0.1f;
            body.createFixture(fdef);
        }
    }

}
