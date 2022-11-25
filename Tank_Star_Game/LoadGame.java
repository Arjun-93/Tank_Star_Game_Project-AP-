package com.mygdx.game.test2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoadGame implements Screen {

    private final Game game;
    private final Stage stage;
    private ShapeRenderer shapeRenderer;
    static private boolean projectionMatrixSet;

    public LoadGame(Game aGame) {
        this.game = aGame;
        stage = new Stage(new ScreenViewport());
        shapeRenderer = new ShapeRenderer();
        projectionMatrixSet = false;

        // Label Screen
        Label title = new Label("Load Screen", MyGdxGame.gameSkin,"big-black");
        title.setPosition(100,Gdx.graphics.getHeight() - 100);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        // Date and Time text
        Label dt1 = new Label(" 1] Played at: 22 November 2022 , 04:58 PM", MyGdxGame.gameSkin,"big-black");
        dt1.setPosition(75,Gdx.graphics.getHeight() - 200);
//        dt1.setWidth(Gdx.graphics.getWidth());
//        dt1.setSize(200,200);
        stage.addActor(dt1);

        Label dt2 = new Label("2] Played at: 25 November 2022 , 06:58 PM", MyGdxGame.gameSkin,"big-black");
        dt2.setPosition(75,Gdx.graphics.getHeight() - 300);
        dt2.setWidth(Gdx.graphics.getWidth());
//        dt2.setSize(200,200);
        stage.addActor(dt2);

        // Play Button
        Texture playLoadGame = new Texture(Gdx.files.internal("play.png"));
        ImageButton playLG = new ImageButton(new TextureRegionDrawable(playLoadGame));
//        backButton.setWidth(Gdx.graphics.getWidth()/2);
        playLG.setSize(40,40);
        playLG.setPosition(1270,Gdx.graphics.getHeight() - 185);
        playLG.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new OptionScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playLG);

        Texture playLoadGame1 = new Texture(Gdx.files.internal("play.png"));
        ImageButton playLG1 = new ImageButton(new TextureRegionDrawable(playLoadGame1));
//        backButton.setWidth(Gdx.graphics.getWidth()/2);
        playLG1.setSize(40,40);
        playLG1.setPosition(1270,Gdx.graphics.getHeight() - 285);
        playLG1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new OptionScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playLG1);


        Texture back = new Texture(Gdx.files.internal("arrowHeadLeft.jpg"));
        ImageButton backButton = new ImageButton(new TextureRegionDrawable(back));
//        backButton.setWidth(Gdx.graphics.getWidth()/2);
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
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(95/255f, 182/255f, 222/255f, 1);
        shapeRenderer.rect(60, 55, 1300, 420);
        shapeRenderer.end();
        stage.act();
        stage.draw();
    }

    public void create(){
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
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
        shapeRenderer.dispose();

    }
}
