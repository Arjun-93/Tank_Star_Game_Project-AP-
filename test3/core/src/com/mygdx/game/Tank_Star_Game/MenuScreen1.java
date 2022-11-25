package com.mygdx.game.Tank_Star_Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.test2.GameScreen;
import com.mygdx.game.test2.MyGdxGame;
import com.mygdx.game.test2.OptionScreen;

public class MenuScreen1 implements Screen {
    private MyTankGame game;
    private Texture texture;
    private final Stage stage;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    Music gameMusic;
    SpriteBatch batch;

    public MenuScreen1(MyTankGame myGame) {
        this.game = myGame;

        // Setting up background and stage
        stage = new Stage();
        texture = new Texture("tank-stars-pc-full-version.jpg");
        camera = new OrthographicCamera();
        camera.setToOrtho(false,1200,700);

        // Setting Game Title
//        Label title = new Label("Tank Star Game", MyGdxGame.gameSkin,"big-black");
//        title.setAlignment(Align.center);
//        title.setY(Gdx.graphics.getHeight()*6/7);
//        title.setWidth(Gdx.graphics.getWidth());
//        stage.act(Gdx.graphics.getDeltaTime());
//        stage.addActor(title);

        // Start Game Button
        TextButton playButton = new TextButton("Start Game!", MyGdxGame.gameSkin);
        playButton.setWidth(Gdx.graphics.getWidth()/3);
        playButton.setHeight(100);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2, Gdx.graphics.getHeight()*(4)/7-playButton.getHeight()*(4)/7);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));}
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });stage.addActor(playButton);


        // Load Game Button
        TextButton optionsButton = new TextButton("Load Game",MyGdxGame.gameSkin);
        optionsButton.setWidth(Gdx.graphics.getWidth()/3);
        optionsButton.setHeight(100);
        optionsButton.setPosition(Gdx.graphics.getWidth()/2-optionsButton.getWidth()/2, (float) (Gdx.graphics.getHeight()*(2.3)/7-optionsButton.getHeight()*(2.3)/7));
        optionsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new OptionScreen(game));}
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });stage.addActor(optionsButton);


        // Exit Game Button
        TextButton exitButton = new TextButton("Exit Game",MyGdxGame.gameSkin);
        exitButton.setWidth(Gdx.graphics.getWidth()/3);
        exitButton.setHeight(100);
        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2, (float) (Gdx.graphics.getHeight()*(0.6)/7-exitButton.getHeight()*(0.6)/7));
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new OptionScreen(game));}
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });stage.addActor(exitButton);}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(texture,0,0);
        game.batch.end();
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
