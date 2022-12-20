package com.mygdx.game.test2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

    }

//    public World getWorld(){
//        return world;
//    }
    public void update(float delta){

        world.step(1/60f,6,2);
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
}

