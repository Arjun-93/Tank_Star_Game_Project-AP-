package com.mygdx.game.test2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyGdxGame extends Game {

    public static Skin gameSkin;
    public static final int V_WIDTH = 1200;
    public static final int V_HEIGHT = 700;

    public static final float PPM = 100;
    public SpriteBatch batch;
    public BitmapFont font;

    public void create () {
        gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        this.setScreen(new playscreen(this));
    }

    public void render () {
        super.render();
    }

    public void dispose () {
    }
}
