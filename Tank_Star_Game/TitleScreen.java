package com.mygdx.game.test2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TitleScreen extends ApplicationAdapter implements Screen {

    private Stage stage = null;
    private final Game game;
    private Texture img;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    Music gameMusic;
    private Viewport gameport;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    public TitleScreen(Game aGame) {
        this.game = aGame;
        stage = new Stage(new ScreenViewport());
        backgroundImage = new Texture(Gdx.files.local("tank-stars-pc-full-version.jpg"));
        Image img1 = new Image(backgroundImage);
        img1.setWidth(1000);
        stage.addActor(img1);
        backgroundTexture = new TextureRegion(backgroundImage,0,0,1400,600);

        camera = new OrthographicCamera();
//        gameport = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, camera);
        camera.setToOrtho(false,1200,700);
        Gdx.input.setInputProcessor(stage);

        // Adding Music
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("Audios\\Music\\tank-battle-13719.mp3"));
        gameMusic.setVolume(0.2f);
        gameMusic.setLooping(true);
        gameMusic.play();

        // Start Game Button
        TextButton playButton = new TextButton("Start Game!",MyGdxGame.gameSkin);
//        playButton.setWidth(Gdx.graphics.getWidth()/11);
//        playButton.setHeight(50);
        playButton.setPosition(1010,420);
//        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2, Gdx.graphics.getHeight()*(4)/7-playButton.getHeight()*(4)/7);
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
        optionsButton.setPosition(1010,240);

//        optionsButton.setWidth(Gdx.graphics.getWidth()/3);
//        optionsButton.setHeight(100);
//        optionsButton.setPosition(Gdx.graphics.getWidth()/2-optionsButton.getWidth()/2, (float) (Gdx.graphics.getHeight()*(2.3)/7-optionsButton.getHeight()*(2.3)/7));
        optionsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new LoadGame(game));}
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });stage.addActor(optionsButton);


        // Exit Game Button
        TextButton exitButton = new TextButton("Exit Game",MyGdxGame.gameSkin);
        exitButton.setPosition(1010,70);

//        exitButton.setWidth(Gdx.graphics.getWidth()/3);
//        exitButton.setHeight(100);
//        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2, (float) (Gdx.graphics.getHeight()*(0.6)/7-exitButton.getHeight()*(0.6)/7));
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });stage.addActor(exitButton);}


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }


    public void create(){
        backgroundImage = new Texture(("C:\\Users\\arjun\\Downloads\\test3\\assets\\tank-stars-pc-full-version.jpg"));
    }
    @Override
    public void render(float delta) {
//        ScreenUtils.clear(173, 48, 2227, 1);
        Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.camera.update();
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
}
