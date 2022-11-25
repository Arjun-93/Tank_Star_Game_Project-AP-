//package com.mygdx.game.test1;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.kotcrab.vis.ui.widget.VisTextButton;
//
//public class MainMenuScreen implements Screen {
//    private final Stage stage;
//
//    public MainMenuScreen() {
//        stage = new Stage(new ScreenViewport());
//
//        Table rightTable = new Table();
//        rightTable.setFillParent(true);
//
//        VisTextButton start_game = new VisTextButton("Start game");
//        start_game.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                LibgdxTests2.instance.setScreen(new GameScreen());
//            }
//        });
//        rightTable.add(start_game).row();
//
//        VisTextButton exit = new VisTextButton("Exit");
//        exit.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                Gdx.app.exit();
//            }
//        });
//        rightTable.add(exit).row();
//
//        stage.addActor(rightTable);
//    }
//
//    @Override
//    public void show() {
//        Gdx.input.setInputProcessor(stage);
//    }
//
//    @Override
//    public void render(float delta) {
//        stage.act();
//        stage.draw();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        stage.getViewport().update(width, height, true);
//    }
//
//    @Override
//    public void pause() { }
//
//    @Override
//    public void resume() { }
//
//    @Override
//    public void hide() { }
//
//    @Override
//    public void dispose() {
//        stage.dispose();
//    }
//}