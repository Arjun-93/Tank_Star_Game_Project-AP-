package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GamePlayScreen implements Screen {
    private final TextureRegion backgroundTexture;
    private final Game game;
    //    Sound gameSound;
    Music gameMusic;
    OrthographicCamera camera;
//    private Stage stage;
    public GamePlayScreen(final Game game) {
        this.game = game;

        Stage stage = new Stage(new ScreenViewport());

        Texture backgroundImage = new Texture(Gdx.files.internal("C:\\Users\\arjun\\Downloads\\test3\\assets\\tank-stars-pc-full-version.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage,0,0,1400,600);
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("Audios\\Music\\tank-battle-13719.mp3"));
//        gameSound = Gdx.audio.newSound(Gdx.files.internal(""));
        gameMusic.setLooping(true);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);
        Label title = new Label("Tank Star Game", Tank.gameSkin,"big-black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);
        TextButton playButton = new TextButton("Start Game!",Tank.gameSkin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
        playButton.addListener(new InputListener(){

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Tank Shoot");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playButton);
    }


    @Override
    public void render(float delta){

    }
//        batch = new SpriteBatch();
//        Gdx.gl.glClearColor(1,1,1,1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        stage.act();
//        stage.draw();
//        int buttonOffset = 20;
//        stage = new Stage();
//        Gdx.input.setInputProcessor(stage);
//
//        createBasicSkin();
//
//        // Start Button
//        TextButton newGameButton  = new TextButton("Start Game", skin);
//        newGameButton.setPosition(Gdx.graphics.getWidth() /  2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight()/2 + (newGameButton.getHeight()+buttonOffset));
//        newGameButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                System.out.println("Start Game button clicked");
//            }
//        }); stage.addActor(newGameButton);
//
//        // Load Button
//        TextButton loadButton  = new TextButton("Load Game", skin);
//        loadButton.setPosition(Gdx.graphics.getWidth() /  2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight()/2 );
//        loadButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                System.out.println("Load button clicked");
//            }
//        }); stage.addActor(loadButton);
//
//        // Setting Button
//        TextButton settingsButton  = new TextButton("Settings", skin);
//        settingsButton.setPosition(Gdx.graphics.getWidth() /  2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight()/2 + (newGameButton.getHeight()+buttonOffset));
//        settingsButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                System.out.println("Settings button clicked");
//            }
//        }); stage.addActor(settingsButton);
//
//        // Exit Button
//        TextButton exitGameButton  = new TextButton("Exit Game", skin);
//        exitGameButton.setPosition(Gdx.graphics.getWidth() /  2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight()/2 + (newGameButton.getHeight()+buttonOffset));
//        exitGameButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                System.out.println("Exit Game button clicked");
//            }
//        }); stage.addActor(exitGameButton);
//    }

//    private void createBasicSkin() {
//
//        // Creating font
//        BitmapFont font = new BitmapFont();
//        skin = new Skin();
//        skin.add("default", font);
//
//        // Create a texture
//        Pixmap pixmap = new Pixmap( Gdx.graphics.getWidth() /4, Gdx.graphics.getHeight() /10, Pixmap.Format.RGB888);
//        pixmap.setColor(Color.WHITE);
//        pixmap.fill();
//        skin.add("Background", new Texture(pixmap));
//
//        // Create a Button Style
//        TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
//        tbs.up = skin.getDrawable("background");
//        tbs.down = skin.newDrawable("background", Color.DARK_GRAY);
//        tbs.checked = skin.newDrawable("background", Color.DARK_GRAY);
//        tbs.over = skin.newDrawable("background", Color.LIGHT_GRAY);
//        tbs.font = skin.getFont("default");
//        skin.add("default",tbs);



    @Override
    public void show() {
        gameMusic.play();
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
