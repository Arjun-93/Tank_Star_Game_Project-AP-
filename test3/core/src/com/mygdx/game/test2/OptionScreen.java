//package com.mygdx.game.test2;
//
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.maps.tiled.TmxMapLoader;
//import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.InputListener;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//import com.badlogic.gdx.utils.Align;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//
//public class OptionScreen implements Screen {
//
//    private final Stage stage;
////    private Texture img;
////    private Texture backgroundImage;
////    private TextureRegion backgroundTexture;
//    OrthographicCamera camera;
////    Music gameMusic;
//
//    private Viewport gameport;
//    private final Game game;
//    private  OrthogonalTiledMapRenderer renderer;
//    private TmxMapLoader mapLoader;
//    private GamePlay tiledmap;
//    public OptionScreen(Game aGame) {
//
//
//        this.game = aGame;
//        stage = new Stage(new ScreenViewport());
//        Texture Tankimage1 = new Texture(Gdx.files.local("Map.png"));
//        Image img1 = new Image(Tankimage1);
////        img1.setPosition(300,300);
//
//        stage.addActor(img1);
//
//        Texture Tankimage2 = new Texture(Gdx.files.local("AbramsAngle.png"));
//        Image img2 = new Image(Tankimage2);
//        img2.setPosition(120  ,330);
//        img2.setHeight(60);
//        img2.setWidth(120);
//        stage.addActor(img2);
//
//        // Angle and Power
//        Texture angleImage = new Texture(Gdx.files.local("angle.png"));
//        Image angle = new Image(angleImage);
//        angle.setPosition(100  ,430);
//        angle.setHeight(50);
//        angle.setWidth(150);
//        stage.addActor(angle);
//
//
//        // Bubble
//        Texture BubbleImage1 = new Texture(Gdx.files.local("bubble.png"));
//        Image bubble1 = new Image(BubbleImage1);
//        bubble1.setPosition(260  ,400);
//        bubble1.setHeight(10);
//        bubble1.setWidth(10);
//        stage.addActor(bubble1);
//
//        Texture BubbleImage2 = new Texture(Gdx.files.local("bubble.png"));
//        Image bubble2 = new Image(BubbleImage2);
//        bubble2.setPosition(274  ,410);
//        bubble2.setHeight(10);
//        bubble2.setWidth(10);
//        stage.addActor(bubble2);
//
//        Texture BubbleImage3 = new Texture(Gdx.files.local("bubble.png"));
//        Image bubble3 = new Image(BubbleImage3);
//        bubble3.setPosition(296  ,420);
//        bubble3.setHeight(10);
//        bubble3.setWidth(10);
//        stage.addActor(bubble3);
//
//        Texture BubbleImage4 = new Texture(Gdx.files.local("bubble.png"));
//        Image bubble4 = new Image(BubbleImage4);
//        bubble4.setPosition(312  ,430);
//        bubble4.setHeight(10);
//        bubble4.setWidth(10);
//        stage.addActor(bubble4);
//
//        Texture Tankimage3 = new Texture(Gdx.files.local("Buratino2.png"));
//        Image img3 = new Image(Tankimage3);
//        img3.setPosition(970  ,320);
//        img3.setHeight(50);
//        img3.setWidth(100);
//        stage.addActor(img3);
//
//        Texture option = new Texture(Gdx.files.internal("options.png"));
//        ImageButton optionButton = new ImageButton(new TextureRegionDrawable(option));
////        backButton.setWidth(Gdx.graphics.getWidth()/2);
//        optionButton.setSize(40,40);
//        optionButton.setPosition(15,555);
//        optionButton.addListener(new InputListener(){
//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new PauseMenu(game));
//            }
//            @Override
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                return true;
//            }
//        });
//        stage.addActor(optionButton);
//
//
//
//        // Fuel
//        Texture fuelImage = new Texture(Gdx.files.local("Fuel.png"));
//        Image fuel = new Image(fuelImage);
//        fuel.setPosition(170  ,150);
//        fuel.setHeight(35);
//        fuel.setWidth(150);
//        stage.addActor(fuel);
//
//        // HealthBar
//        Texture healthImage = new Texture(Gdx.files.local("Health.png"));
//        Image health = new Image(healthImage);
//        health.setPosition(370  ,540);
//        health.setHeight(40);
//        health.setWidth(700);
//        stage.addActor(health);
//
//        // Fire
//        Texture fireImahge = new Texture(Gdx.files.local("Fire.png"));
//        Image fire = new Image(fireImahge);
//        fire.setPosition(1030  ,150);
//        fire.setHeight(60);
//        fire.setWidth(100);
//        stage.addActor(fire);
//
//
//        // Choose Weapon
//        Texture weaponimage = new Texture(Gdx.files.local("chooseWeapon.png"));
//        Image weapon = new Image(weaponimage);
//        weapon.setPosition(680  ,150);
//        weapon.setHeight(60);
//        weapon.setWidth(100);
//        stage.addActor(weapon);
//
//
//
////        img1.setHeight(200);
////        img1.setWidth(400);
//////        tiledmap = new GamePlay(this.game);
////        stage = new Stage(new ScreenViewport());
////        // Loading Map
//        camera = new OrthographicCamera();
//        gameport = new FitViewport(MyGdxGame.V_WIDTH,MyGdxGame.V_HEIGHT,camera);
////        TmxMapLoader mapLoader = new TmxMapLoader();
////        map = mapLoader.load("skin/TankBackgroun.tmx");
////        renderer = new OrthogonalTiledMapRenderer(map);
//////        stage.addActor();
////        camera.position.set(gameport.getScreenWidth() / 2, gameport.getScreenHeight()/2, 0);
//
//        Label title = new Label("Play Screen", MyGdxGame.gameSkin,"big-black");
//        title.setAlignment(Align.center);
//        title.setY(Gdx.graphics.getHeight()*1/12);
//        title.setWidth(Gdx.graphics.getWidth());
//        stage.addActor(title);
//
//        // Back Button
//        Texture back = new Texture(Gdx.files.internal("arrowHeadLeft.jpg"));
//        ImageButton backButton = new ImageButton(new TextureRegionDrawable(back));
////        backButton.setWidth(Gdx.graphics.getWidth()/2);
//        backButton.setSize(20,20);
//        backButton.setPosition(20,20);
//        backButton.addListener(new InputListener(){
//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new TitleScreen(game));
//            }
//            @Override
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                return true;
//            }
//        });
//        stage.addActor(backButton);
//    }
//
//    @Override
//    public void show() {
//        Gdx.input.setInputProcessor(stage);
//    }
//    public void handleInput(float delta) {
//        if(Gdx.input.isTouched()){
//            camera.position.x += 100*delta;
//        }
//    }
//
//    public void update(float delta){
//        handleInput(delta);
//        camera.update();
////        renderer.setView(camera);
//    }
//
//    @Override
//    public void render(float delta) {
//        update(delta);
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
////        renderer.render();
////        game.batch.setProjectionMatrix();
//        stage.act();
//        stage.draw();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void dispose() {
//        stage.dispose();
//    }
//}
