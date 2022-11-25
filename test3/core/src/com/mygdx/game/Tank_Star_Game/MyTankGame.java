package com.mygdx.game.Tank_Star_Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyTankGame extends Game {
    static public Skin gameSkin;
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 700;
    public SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MenuScreen1(this));
    }

    @Override
    public void render(){
        super.render();
    }

    @Override
    public void dispose(){
        super.dispose();
        batch.dispose();
    }
}
