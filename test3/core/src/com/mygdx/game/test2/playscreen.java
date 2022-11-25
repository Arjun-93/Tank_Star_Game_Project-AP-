package com.mygdx.game.test2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class playscreen implements Screen{

    private Stage stage;
    private MyGdxGame game;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;
    TmxMapLoader mapLoader;

    private OrthographicCamera camera;
//    private Texture texture;
    private SpriteBatch sb;
    private Sprite sprite;
    private Viewport gamePort;

    // Box2D Variables
    private World world;
    private Box2DDebugRenderer b2dr;
    float x, y;

    private MyTank Abhrams;
    private float w = 19200/2;
    private float h = 11200/2;

    float px,py,velocityX, velocityY;
    private PolygonShape shape;
    private Sprite nosal;

    public playscreen(MyGdxGame game){
        this.game = game;
        camera = new OrthographicCamera();


        // Map Loading
        gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, camera);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("MAAP/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        sprite = new Sprite(new Texture("Abrams.png"));
        nosal = new Sprite(new Texture("nosal.png"));
        nosal.setPosition(50,1180);
        sprite.setPosition(50,1140);
        sb =  new SpriteBatch();


        // Box2d Variables
        world  = new World(new Vector2(0,0), true);
        b2dr = new Box2DDebugRenderer();
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for ( RectangleMapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)
        ){
            Rectangle rect = object.getRectangle();
            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set(rect.getX() + rect.getWidth()/2, rect.getY() + rect.getHeight()/2);
//            bodyDef.position.set(w/2+rect.getWidth()/2,rect.getHeight()+h/2);
            body = world.createBody(bodyDef);
            shape.setAsBox(rect.getWidth()/2 , rect.getHeight()/2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }


//        Texture texture = new Texture("tank.png");
//        PolygonShape shape1 = new PolygonShape();
//        shape.setAsBox(texture.getHeight(),texture.getWidth());
//
//// Create a BodyDef and set its type to DynamicBody
//        BodyDef bodyDef1 = new BodyDef();
//        bodyDef1.type = BodyDef.BodyType.DynamicBody;
//
//// Create a FixtureDef and attach the PolygonShape to it
//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = shape;
//
//// Create a Body using the BodyDef and attach the FixtureDef to it
//        body = world.createBody(bodyDef1);
//        body.createFixture(fixtureDef);
//// Set the position of the Body
//        body.setTransform(1000, 1100, 0);

//        for (int x = 0; x < layer.getOffsetX(); x++) {
//            for (int y = 0; y < layer.getOffsetY(); y++) {
//                TiledMapTileLayer.Cell cell = ((TiledMapTileLayer)layer).getCell(x, y);
//                if (cell != null) {
//                    bodyDef.type = BodyDef.BodyType.StaticBody;
//                    bodyDef.position.set(x + 0.5f, y + 0.5f);
//
//                    PolygonShape shape = new PolygonShape();
//                    shape.setAsBox(0.5f, 0.5f);
//
//                    FixtureDef fixtureDef = new FixtureDef();
//                    fixtureDef.shape = shape;
//                    fixtureDef.density = 1f;
//                    fixtureDef.friction = 0.5f;
//
//                    Body body = world.createBody(bodyDef);
//                    body.createFixture(fixtureDef);
//                    shape.dispose();
//                }
//            }
//
//        }
//        // Create the first body
//        BodyDef bodyDef1 = new BodyDef();
//        bodyDef1.type = BodyDef.BodyType.DynamicBody;
//        bodyDef1.position.set(0, 0);
//        Body body1 = world.createBody(bodyDef1);
//
//// Create the shape for the first body
//        PolygonShape shape1 = new PolygonShape();
//        shape1.setAsBox(50/2, 100/2);
//
//// Create the fixture for the first body
//        FixtureDef fixtureDef1 = new FixtureDef();
//        fixtureDef1.shape = shape1;
//        fixtureDef1.density = 1.0f;
//        fixtureDef1.friction = 0.3f;
//        fixtureDef1.restitution = 0.1f;
//        body1.createFixture(fixtureDef1);
//
//// Create the second body
//        BodyDef bodyDef2 = new BodyDef();
//        bodyDef2.type = BodyDef.BodyType.DynamicBody;
//        bodyDef2.position.set(0, 0);
//        Body body2 = world.createBody(bodyDef2);
//
//// Create the shape for the second body
//        PolygonShape shape2 = new PolygonShape();
//        shape2.setAsBox(50/2, 100/2);
//
//// Create the fixture for the second body
//        FixtureDef fixtureDef2 = new FixtureDef();
//        fixtureDef2.shape = shape2;
//        fixtureDef2.density = 1.0f;
//        fixtureDef2.friction = 0.3f;
//        fixtureDef2.restitution = 0.1f;
//        body2.createFixture(fixtureDef2);
//
//// Create a revolute joint to attach the two bodies
//        RevoluteJointDef jointDef = new RevoluteJointDef();
//        jointDef.initialize(body1, body2, body1.getWorldCenter());
//        jointDef.enableLimit = true;
//        jointDef.lowerAngle = (float) Math.toRadians(-30);
//        jointDef.upperAngle = (float) Math.toRadians(30);
//        world.createJoint(jointDef);
//
//
//        float timeStep = 1 / 60f;
//        int velocityIterations = 6;
//        int positionIterations = 2;
//
//        world.step(timeStep, velocityIterations, positionIterations);

//        MapProperties properties = layer.getProperties();
//        properties.put("rigid", true);

    }

    public ChainShape createShapeFromImage(Texture image) {
        // Get the pixel data from the image
        int width = image.getWidth();
        int height = image.getHeight();
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        image.getTextureData().prepare();
        pixmap.drawPixmap(image.getTextureData().consumePixmap(), 0, 0);

        // Create a list to store the vertices of the shape
        Array<Vector2> vertices = new Array<Vector2>();

        // Find the transparent pixels of the image and add them to the vertices list
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixmap.getPixel(x, y);
                if (pixel >>> 24 == 0) {
                    vertices.add(new Vector2(x, y));
                }
            }
        }

        // Create a chain shape from the vertices
        ChainShape shape = new ChainShape();
        shape.createChain(vertices.toArray(Vector2.class));

        // Dispose of the pixmap when finished
        pixmap.dispose();

        return shape;
    }




//    public World getWorld(){
//        return world;
//    }
    public void update(float delta){

        world.step(1/60f,6,2);
//        camera.position.x = Abhrams.b2body.getPosition().x;
//        camera.position.y = Abhrams.b2body.getPosition().y;
        handleInput(delta);
        camera.update();
        renderer.setView(camera);
    }
    public void handleInput(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            sprite.setPosition(sprite.getX() - 25*delta, sprite.getY());
            nosal.setPosition(sprite.getX() - 25*delta, sprite.getY());

        if(Gdx.input.isKeyPressed(Input.Keys.D))
            sprite.setPosition(sprite.getX() + 25*delta, sprite.getY());
            nosal.setPosition(sprite.getX() + 25*delta, sprite.getY());

//        if(Gdx.input.isKeyPressed(Input.Keys.UP) && Abhrams.b2body.getLinearVelocity().y <=2)
//            Abhrams.b2body.applyLinearImpulse(new Vector2(0,0.1f), Abhrams.b2body.getWorldCenter(),true);
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && Abhrams.b2body.getLinearVelocity().y >= -2)
//            Abhrams.b2body.applyLinearImpulse(new Vector2(0,-0.1f), Abhrams.b2body.getWorldCenter(),true);
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Abhrams.b2body.getLinearVelocity().x <=2);
//            Abhrams.b2body.applyLinearImpulse(new Vector2(0.1f,0), Abhrams.b2body.getWorldCenter(),true);
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && Abhrams.b2body.getLinearVelocity().x >= -2)
//            Abhrams.b2body.applyLinearImpulse(new Vector2(-0.1f,0), Abhrams.b2body.getWorldCenter(),true);
//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
//            Abhrams.fire();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)

    {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
        b2dr.render(world,camera.combined);
        renderer.setView(camera);
        camera.setToOrtho(false,w/2-3000,h/2);
        camera.update();

        sb.begin();
        sb.setProjectionMatrix(camera.combined);
        sprite.draw(sb);
        nosal.draw(sb);
        sb.end();


    }
    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
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
        shape.dispose();
    }

//    public playscreen(){
//        map = new TmxMapLoader().load("MAAP/map.tmx");
//        renderer = new OrthogonalTiledMapRenderer(map);
//        camera = new OrthographicCamera();
//        float w = Gdx.graphics.getWidth();
//        float h = Gdx.graphics.getHeight();
//        camera.setToOrtho(false,w,h);
//        camera.update();
//
//        sb = new SpriteBatch();
//        texture = new Texture(Gdx.files.internal("tank.png"));
//        sprite = new Sprite(texture);
//    }
//
//    public void handleInput(float delta){
//        if(Gdx.input.isTouched())
//            camera.position.x += 100*delta;
//
//    }
//    public void update(float delta){
//        handleInput(delta);
//        camera.update();
//        renderer.setView(camera);
//
//    }
//
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//        update(delta);
//
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        camera.update();
//        renderer.setView(camera);
//        renderer.render();
//        sb.begin();
//        sprite.draw(sb);
//        sb.end();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//
//    }
}

