package com.mygdx.game.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ParentScreen extends ApplicationAdapter {
    SpriteBatch batch;
    Stage stage;

    OrthographicCamera camera;

    @Override
    public void create(){
        batch = new SpriteBatch();
        stage = new Stage();
        camera = (OrthographicCamera)stage.getCamera();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(){
        camera.update();
        batch.begin();
        stage.draw();
        stage.act();
        batch.end();
    }
}
