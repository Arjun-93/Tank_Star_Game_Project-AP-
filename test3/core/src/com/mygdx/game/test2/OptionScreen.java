package com.mygdx.game.test2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class OptionScreen implements Screen {

    private final Stage stage;
    private float Map_Width = 25600;
    private float Map_Height = 3600;
//    private Texture img;
//    private Texture backgroundImage;
//    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
//    Music gameMusic;

    private Viewport gameport;
    private final Game game;
    private  OrthogonalTiledMapRenderer renderer;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private final World world;
    private Box2DDebugRenderer b2dr;
    private Tanks player1;
    private Tanks player2;

    private SpriteBatch batch;

//    private GamePlay tiledmap;
    public OptionScreen(Game aGame) {

        this.game = aGame;
        stage = new Stage();
        camera = new OrthographicCamera();
        gameport = new FitViewport(MyGdxGame.V_WIDTH/MyGdxGame.PPM, MyGdxGame.V_HEIGHT/MyGdxGame.PPM,camera);
        // Map loading
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Map/Map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);


        world = new World(new Vector2(0,-10),true);
        b2dr = new Box2DDebugRenderer();
        makeRigid(b2dr,world);

        player1 = new Tanks(this);
        player1.defineTanks(50,290,200,100,true);
        player2 = new Tanks(this);
        player2.defineTanks(1200, 290,200,100,false);

//        // Angle and Power
//        Texture angleImage = new Texture(Gdx.files.local("angle.png"));
//        Image angle = new Image(angleImage);
//        angle.setPosition(100  ,430);
//        angle.setHeight(50);
//        angle.setWidth(150);
//        stage.addActor(angle);


        Texture option = new Texture(Gdx.files.internal("options.png"));
        ImageButton optionButton = new ImageButton(new TextureRegionDrawable(option));
//        backButton.setWidth(Gdx.graphics.getWidth()/2);
        optionButton.setSize(40,40);
        optionButton.setPosition(15,555);
        optionButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new PauseMenu(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(optionButton);



        // Fuel
        Texture fuelImage = new Texture(Gdx.files.local("Fuel.png"));
        Image fuel = new Image(fuelImage);
        fuel.setPosition(170  ,150);
        fuel.setHeight(35);
        fuel.setWidth(150);
        stage.addActor(fuel);

        // HealthBar
        Texture healthImage = new Texture(Gdx.files.local("Health.png"));
        Image health = new Image(healthImage);
        health.setPosition(370  ,540);
        health.setHeight(40);
        health.setWidth(700);
        stage.addActor(health);

        // Fire
        Texture fireImahge = new Texture(Gdx.files.local("Fire.png"));
        Image fire = new Image(fireImahge);
        fire.setPosition(1030  ,150);
        fire.setHeight(60);
        fire.setWidth(100);
        stage.addActor(fire);


        // Choose Weapon
        Texture weaponimage = new Texture(Gdx.files.local("chooseWeapon.png"));
        Image weapon = new Image(weaponimage);
        weapon.setPosition(680  ,150);
        weapon.setHeight(60);
        weapon.setWidth(100);
        stage.addActor(weapon);

        camera = new OrthographicCamera();
        gameport = new FitViewport(MyGdxGame.V_WIDTH,MyGdxGame.V_HEIGHT,camera);

        Label title = new Label("Play Screen", MyGdxGame.gameSkin,"big-black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*1/12);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        // Back Button
        Texture back = new Texture(Gdx.files.internal("arrowHeadLeft.jpg"));
        ImageButton backButton = new ImageButton(new TextureRegionDrawable(back));
        backButton.setSize(20,20);
        backButton.setPosition(20,20);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new TitleScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(backButton);
    }

    public void handleInput(float delta) {

        // Tank movement
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            player1.tankLower.setPosition(player1.tankLower.getX()+27*delta, player1.tankLower.getY());
            player1.tankNosal.setPosition(player1.tankNosal.getX()+27*delta, player1.tankNosal.getY());
            player1.b2body.setLinearVelocity(new Vector2(50,0));

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player1.tankLower.setPosition(player1.tankLower.getX()-27*delta, player1.tankLower.getY());
            player1.tankNosal.setPosition(player1.tankNosal.getX()-27*delta, player1.tankNosal.getY());
            player1.b2body.setLinearVelocity(new Vector2(-50,0));
        }
        if ((!Gdx.input.isKeyPressed(Input.Keys.D) &&
                !Gdx.input.isKeyPressed(Input.Keys.A) &&
                !Gdx.input.isKeyPressed(Input.Keys.SPACE))
                ||
                (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.A))){
            player1.b2body.setLinearVelocity(new Vector2(0, 0));
        }

        // Tank Nosal Rotation
        if(Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S)) {
            if(player1.tankNosal.getRotation() < 180) {
                player1.tankNosal.setOrigin(25, 0);
                player1.tankNosal.setRotation(player1.tankNosal.getRotation() + 2);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(player1.tankNosal.getRotation() > 0) {
                player1.tankNosal.setRotation(player1.tankNosal.getRotation() - 2);
                player1.tankNosal.setOrigin(25, 0);
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
            bulletBodyDef.position.set(player1.tankNosal.getX(),player1.tankNosal.getY());
            Body bulletBody = world.createBody(bulletBodyDef);
            bulletBody.createFixture(bulletDef);
            // Calculate the impulse to apply to the bullet based on the angle of the fixture body
            float angle = player1.tankNosal.getRotation();
            Vector2 impulse = new Vector2((float)Math.cos(angle), (float)Math.sin(angle));
            impulse.scl(10.0f);
            // Fire the bullet
            bulletBody.applyLinearImpulse(impulse, bulletBody.getWorldCenter(), true);
        }

    }
    public void update(float delta){
        handleInput(delta);
        world.step(1/60f, 6,6);
        camera.update();
        renderer.setView(camera);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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

    public World getWorld(){
        return  world;
    }
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        renderer.setView(camera);
        camera.setToOrtho(false, this.Map_Width/2-10000, this.Map_Height/2+500);
        camera.update();

        MyGdxGame.batch.begin();
        player1.tankLower.draw(MyGdxGame.batch);
        player1.tankNosal.draw(MyGdxGame.batch);
        player2.tankLower.draw(MyGdxGame.batch);
        player2.tankNosal.draw(MyGdxGame.batch);
        MyGdxGame.batch.end();

        b2dr.render(world, camera.combined);

        stage.act();
        stage.draw();
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
        stage.dispose();
    }

    public Game getGame() {
        return this.game;
    }
}
