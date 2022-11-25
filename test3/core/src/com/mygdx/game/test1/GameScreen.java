//package com.mygdx.game.test1;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.utils.viewport.ExtendViewport;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//import com.kotcrab.vis.ui.widget.VisLabel;
//
//public class GameScreen implements Screen {
//    private final Viewport gameViewport;
//    private final ShapeRenderer gameRenderer;
//
//    private Stage uiStage;
//
//    public GameScreen() {
//        gameViewport = new ExtendViewport(480, 320);
//        gameRenderer = new ShapeRenderer();
//
//        setupUi();
//    }
//
//    private void setupUi() {
//        uiStage = new Stage(new ScreenViewport());
//
//        Table table = new Table();
//        table.setFillParent(true);
//        table.add(new VisLabel("Owls are cool!")).top().left().expand();
//
//        uiStage.addActor(table);
//    }
//
//    @Override
//    public void show() {
//        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//    }
//
//    @Override
//    public void render(float delta) {
//        gameViewport.apply();
//        gameRenderer.setProjectionMatrix(gameViewport.getCamera().combined);
//
//        gameRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        gameRenderer.setColor(Color.RED);
//        gameRenderer.rect(-50, -50, 100, 100);
//        gameRenderer.end();
//
//        uiStage.getViewport().apply();
//        uiStage.act();
//        uiStage.draw();
//
//        checkInput();
//    }
//
//    private void checkInput() {
//        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
//            LibgdxTests2.instance.setScreen(new MainMenuScreen());
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        gameViewport.update(width, height);
//        uiStage.getViewport().update(width, height, true);
//    }
//
//    @Override
//    public void pause() {}
//
//    @Override
//    public void resume() {}
//
//    @Override
//    public void hide() {}
//
//    @Override
//    public void dispose() {
//        gameRenderer.dispose();
//    }
//}