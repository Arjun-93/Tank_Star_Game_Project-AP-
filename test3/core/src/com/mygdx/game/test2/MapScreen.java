package com.mygdx.game.test2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MapScreen implements Screen {

    private final MyGdxGame game;
    private  Box2DDebugRenderer b2dr;
    private  OrthogonalTiledMapRenderer renderer;
    private  TmxMapLoader mapLoader;
    private  FitViewport gameport;
    private  OrthographicCamera camera;

    private World world;

    public MapScreen(MyGdxGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        gameport = new FitViewport(MyGdxGame.V_WIDTH,MyGdxGame.V_HEIGHT,camera);
        mapLoader = new TmxMapLoader();
        TiledMap map = mapLoader.load(Gdx.files.internal("TerrainBackgroungd.tmx").file().getAbsolutePath());
//        TiledMap map = new TmxMapLoader();
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.position.set(gameport.getScreenWidth()/2, gameport.getScreenHeight()/2, 0);

        world = new World(new Vector2(0,0),true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();

    }

    @Override
    public void show() {

    }
    public void handelInput(float delta){
        if(Gdx.input.isTouched()){
            camera.position.x += 100*delta;
        }

    }
    public void update(float delta){
        handelInput(delta);
        camera.update();
        renderer.setView(camera);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        renderer.render();
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
}
