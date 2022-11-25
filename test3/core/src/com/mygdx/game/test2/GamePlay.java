package com.mygdx.game.test2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GamePlay extends ApplicationAdapter implements Screen {

    SpriteBatch batch;
    Texture img;
    private final Game game;
    private Viewport gameport;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private TiledMap map;
    private  OrthogonalTiledMapRenderer renderer;

    OrthographicCamera camera;

    public GamePlay(Game game1) {
        this.game = game1;
        camera = new OrthographicCamera();
        gameport = new FitViewport(MyGdxGame.V_WIDTH,MyGdxGame.V_HEIGHT,camera);

        TmxMapLoader mapLoader = new TmxMapLoader();
        map = mapLoader.load("skin/TankBackgroun.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.position.set(gameport.getScreenWidth() / 2, gameport.getScreenHeight()/2, 0);
    }

    @Override
    public void create () {

    }

    @Override
    public void show() {

    }

    public void handleInput(float delta) {
        if(Gdx.input.isTouched()){
            camera.position.x += 100*delta;
        }
    }

    public void update(float delta){
        handleInput(delta);
        camera.update();
        renderer.setView(camera);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
