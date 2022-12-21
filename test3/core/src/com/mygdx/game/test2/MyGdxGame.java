package com.mygdx.game.test2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;

public class MyGdxGame extends Game {

    public static Skin gameSkin;
    public static final int V_WIDTH = 1500;
    public static final int V_HEIGHT = 600;

    public static final float PPM = 1;
    public static SpriteBatch batch;
    public BitmapFont font;

    static ArrayList<MyGdxGame> savedGame = new ArrayList<>();

    public void create () {
        batch = new SpriteBatch();
        gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        this.setScreen(new TitleScreen(this));
        savedGame.add(this);
    }

    public void render () {
        super.render();
    }

    public void dispose () {
    }
}
