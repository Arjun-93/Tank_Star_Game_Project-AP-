package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Tank extends Game {

    public static final int V_WIDTH = 1200;
    public static final int V_HEIGHT = 700;
    public SpriteBatch batch;
    public BitmapFont font;
    static public Skin gameSkin;
    @Override
    public void create() {
        batch  = new SpriteBatch();
        font  = new BitmapFont();
        gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        this.setScreen(new MenuScreen(this));
    }

    public void render(){
        super.render();
    }
    public void dispose(){
        batch.dispose();
        font.dispose();
    }

    public void setScreen(GamePlayScreen gamePlayScreen) {
    }

    public void setScreen(GameOverScreen gameOverScreen) {
    }
}
