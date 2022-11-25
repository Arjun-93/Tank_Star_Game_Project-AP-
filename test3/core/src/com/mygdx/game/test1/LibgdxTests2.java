//package com.mygdx.game.test1;
//
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.kotcrab.vis.ui.VisUI;
//public class LibgdxTests2 extends Game {
//    public static LibgdxTests2 instance;
//
//    public LibgdxTests2() {
//        instance = this;
//    }
//
//    @Override
//    public void create() {
//        VisUI.load();
//
//        setScreen(new MainMenuScreen());
//    }
//
//    @Override
//    public void render() {
//        Gdx.gl.glClearColor(0.3f, 0.3f, 0.1f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        super.render();
//    }
//}