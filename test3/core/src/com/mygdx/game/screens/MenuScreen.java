package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Tank_Star_Game.MyTankGame;

public class MenuScreen implements Screen {
    private Tank game;
//    final Game game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private OrthographicCamera camera;
    private Viewport gamePort;
    public MenuScreen(Tank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("tank-stars-pc-full-version.jpg"));
//        backgroundTexture = new TextureRegion(backgroundImage,0,0,1400,600);
        camera = new OrthographicCamera();
        gamePort = new FitViewport(Tank.V_WIDTH,Tank.V_HEIGHT,camera) ;
        camera.setToOrtho(false,1200,700);
    }

    public MenuScreen(MyTankGame myTankGame) {
    }
//    final tank game;

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundImage,0,0);
        game.batch.end();

//        game.camera.update();
//        this.game.batch.setProjectionMatrix(camera.combined);
//
//        this.game.batch.begin();
//        this.game.batch.draw(backgroundTexture, 0,0, 1200, 700);
//        this.game.font.draw(this.game.batch, "Welcome to Tank Star Game!", 500, 50);
//        this.game.font.draw(this.game.batch, "Click anywhere to begin!", 500, 20);
//        this.game.batch.end();
//
//        if (Gdx.input.isTouched()) {
//            this.game.setScreen(new GamePlayScreen(this.game));
//            this.dispose();
//        }
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
    }
}
