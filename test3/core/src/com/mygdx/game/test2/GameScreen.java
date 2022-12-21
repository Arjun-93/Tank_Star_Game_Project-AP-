//package com.mygdx.game.test2;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.InputListener;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
////import com.mygdx.game.MyGdxGame;
//
//public class GameScreen extends ApplicationAdapter implements Screen {
//
//    private Stage stage;
//    private Game game;
//
//    public GameScreen(Game aGame) {
//        this.game = aGame;
//        stage = new Stage(new ScreenViewport());
//        Label Abrams = new Label("Abrams", MyGdxGame.gameSkin,"big-black");
//        Abrams.setPosition(180,200);
//        Abrams.setColor(247,241,45,1);
//        stage.addActor(Abrams);
//
//        Texture Tankimage1 = new Texture(Gdx.files.local("Abrams.png"));
//        Image img1 = new Image(Tankimage1);
//        img1.setPosition(180,300);
//        img1.setHeight(100);
//        img1.setWidth(200);
//
//        Texture selcect1 = new Texture(Gdx.files.local("select4.jpg"));
//        Image img5 = new Image(selcect1);
//        img5.setPosition(430,200);
//        img5.setHeight(300);
//        img5.setWidth(550);
//        stage.addActor(img5);
//        stage.addActor(img1);
//
////        Label Buratino = new Label("Buratino", MyGdxGame.gameSkin,"big-black");
////        Buratino.setPosition(630,200);
////        Buratino.setColor(247,241,45,1);
//        Texture Tankimage2 = new Texture(Gdx.files.local("Buratino.png"));
//        Image img2 = new Image(Tankimage2);
//        img2.setPosition(610,300);
//        img2.setHeight(100);
//        img2.setWidth(200);
////        stage.addActor(Buratino);
//        stage.addActor(img2);
//
//        Label Frost = new Label("Frost", MyGdxGame.gameSkin,"big-black");
//        Frost.setPosition(1080,300);
//        Frost.setColor(247,241,45,1);
//        Texture Tankimage3 = new Texture(Gdx.files.local("frost.png"));
//        Image img3 = new Image(Tankimage3);
//        img3.setPosition(1000,300);
//        img3.setHeight(100);
//        img3.setWidth(200);
//        stage.addActor(Frost);
//        stage.addActor(img3);
//
//        // Arrow Positioning
//        Texture arrowLeft = new Texture(Gdx.files.local("arrowHeadLeft.jpg"));
//        Image arrowl = new Image(arrowLeft);
//        arrowl.setPosition(50,320);
//        arrowl.setHeight(50);
//        arrowl.setWidth(50);
//        stage.addActor(arrowl);
//
//        Texture arrowRight = new Texture(Gdx.files.local("arrowHeadRight.jpg"));
//        Image arrowR = new Image(arrowRight);
//        arrowR.setPosition(1290,320);
//        arrowR.setHeight(50);
//        arrowR.setWidth(50);
//        stage.addActor(arrowR);
//
//        // Tank Name Images
//        Texture AbhramsName = new Texture(Gdx.files.local("AbramsName.png"));
//        Image abhramsnam = new Image(AbhramsName);
//        abhramsnam.setPosition(130,220);
//        abhramsnam.setHeight(50);
//        abhramsnam.setWidth(300);
//        stage.addActor(abhramsnam);
//
//        Texture buratinoName = new Texture(Gdx.files.local("BuratinoName.png"));
//        Image buratinonam = new Image(buratinoName);
//        buratinonam.setPosition(560,170);
//        buratinonam.setHeight(50);
//        buratinonam.setWidth(300);
//        stage.addActor(buratinonam);
//
//        Texture Frostname = new Texture(Gdx.files.local("FrostName.png"));
//        Image frostnam = new Image(Frostname);
//        frostnam.setPosition(950,220);
//        frostnam.setHeight(50);
//        frostnam.setWidth(300);
//        stage.addActor(frostnam);
//
//        // Setting button
//        Texture setname = new Texture(Gdx.files.local("Settings.png"));
//        Image settings = new Image(setname);
//        settings.setPosition(0,540);
//        settings.setHeight(60);
//        settings.setWidth(100);
//        stage.addActor(settings);
//
//        // Coin Button
//        Texture coinname = new Texture(Gdx.files.local("CoinsDiamonds.png"));
//        Image coin = new Image(coinname);
//        coin.setPosition(1150,550);
//        coin.setHeight(50);
//        coin.setWidth(250);
//        stage.addActor(coin);
//
//        // Gift
//        Texture giftimage = new Texture(Gdx.files.local("Gift.png"));
//        Image gift = new Image(giftimage);
//        gift.setPosition(20,20);
//        gift.setHeight(70);
//        gift.setWidth(100);
//        stage.addActor(gift);
//
//        // Calendar
//        Texture calendarimage = new Texture(Gdx.files.local("Calendar.png"));
//        Image calendar = new Image(calendarimage);
//        calendar.setPosition(20,430);
//        calendar.setHeight(60);
//        calendar.setWidth(60);
//        stage.addActor(calendar);
//
////        loadingAnimation = skin.get("loading-animation", TenPatchDrawable.class);
//        Label title = new Label("Choose Tank", MyGdxGame.gameSkin);
//        title.setColor(Color.YELLOW);
////        title.setAlignment(Align.center);
////        title.setY(Gdx.graphics.getHeight() *6/7);
////        title.setSize(100,100);
//        title.setWidth(100); title.setWidth(100);
//        title.setPosition(650,550);
//        stage.addActor(title);
//
//        TextButton upgradeButton = new TextButton("Upgrade",MyGdxGame.gameSkin);
//        upgradeButton.setWidth(Gdx.graphics.getWidth()/7);
//        upgradeButton.setHeight(Gdx.graphics.getHeight()/9);
//        upgradeButton.setPosition(130,50);
//        upgradeButton.setSize(300,100);
//        stage.addActor(upgradeButton);
//
//        TextButton backButton = new TextButton("Play",MyGdxGame.gameSkin);
//        backButton.setWidth(Gdx.graphics.getWidth()/7);
//        backButton.setHeight(Gdx.graphics.getHeight()/9);
//        backButton.setPosition(950,50);
//        backButton.setSize(300,100);
////        backButton.setSize(Gdx.graphics.getHeight()/9,Gdx.graphics.getWidth()/12);
////        backButton.setPosition(Gdx.graphics.getWidth()/2-backButton.getWidth()/2,Gdx.graphics.getHeight()/7-backButton.getHeight()/2);
//        backButton.addListener(new InputListener(){
//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new OptionScreen(game));
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
//        Gdx.app.log("MainScreen","show");
//        Gdx.input.setInputProcessor(stage);
//
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0/255f, 0/255f, 0/255f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        stage.act();
//        stage.draw();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        stage.dispose();
//    }
//}
package com.mygdx.game.test2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.LinkedList;
import java.util.Queue;
//import com.mygdx.game.MyGdxGame;

class QueueCloner {

    public static Queue<String> cloneQueue(Queue<String> queue) {
        Queue<String> clone = new LinkedList<>();
        for (String element : queue) {
            // We don't need to create a deep copy of each element in the queue, because Strings are immutable
            clone.add(element);
        }
        return clone;
    }
}
public class GameScreen extends ApplicationAdapter implements Screen {

    private Stage stage;
    private Game game;

    public GameScreen(Game aGame) {
        this.game = aGame;
        stage = new Stage(new ScreenViewport());

        Texture selcect1 = new Texture(Gdx.files.local("select4.jpg"));
        Image img5 = new Image(selcect1);
        img5.setPosition(430,200);
        img5.setHeight(300);
        img5.setWidth(550);
        stage.addActor(img5);

        final Texture AbhramsName = new Texture(Gdx.files.local("AbramsName.png"));
        final Image abhramsnam = new Image(AbhramsName);
        abhramsnam.setHeight(50);
        abhramsnam.setWidth(300);
        stage.addActor(abhramsnam);


        Texture buratinoName = new Texture(Gdx.files.local("BuratinoName.png"));
        final Image buratinonam = new Image(buratinoName);
        buratinonam.setHeight(50);
        buratinonam.setWidth(300);
        stage.addActor(buratinonam);

        Texture Frostname = new Texture(Gdx.files.local("FrostName.png"));
        final Image frostnam = new Image(Frostname);
        frostnam.setHeight(50);
        frostnam.setWidth(300);
        stage.addActor(frostnam);

        // images
        Texture Tankimage1 = new Texture(Gdx.files.local("Abrams.png"));
        final Image img1 = new Image(Tankimage1);
        img1.setHeight(100);
        img1.setWidth(200);
        stage.addActor(img1);

        Texture Tankimage2 = new Texture(Gdx.files.local("Buratino.png"));
        final Image img2 = new Image(Tankimage2);
        img2.setHeight(100);
        img2.setWidth(200);
        stage.addActor(img2);

        Texture Tankimage3 = new Texture(Gdx.files.local("frost.png"));
        final Image img3 = new Image(Tankimage3);
        img3.setHeight(100);
        img3.setWidth(200);
        stage.addActor(img3);

        abhramsnam.setPosition(130,220);
        img1.setPosition(180,300);

        buratinonam.setPosition(560,170);
        img2.setPosition(610,300);

        frostnam.setPosition(950,220);
        img3.setPosition(1000,300);

        // Queue initialization
        final Queue<String> q = new LinkedList<>();
        final QueueCloner qc = new QueueCloner();
        q.add("Abrams");
        q.add("Buratino");
        q.add("Frost");
        // Arrow Positioning


        //
        Texture arrowRight = new Texture(Gdx.files.local("arrowHeadRight.jpg"));
        Image arrowR = new Image(arrowRight);
        arrowR.setPosition(1290,320);
        arrowR.setHeight(50);
        arrowR.setWidth(50);
        stage.addActor(arrowR);
        //

        ImageButton optionButton = new ImageButton(new TextureRegionDrawable(arrowRight));
//        backButton.setWidth(Gdx.graphics.getWidth()/2);
        optionButton.setSize(50,50);
        optionButton.setPosition(1290,320);
        optionButton.addListener(new InputListener(){
            public void clickLeft(Queue<String> q){
                String s = q.remove();
                q.add(s);
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {


                if(q.peek().equals("Abrams")){
                    abhramsnam.setPosition(560,170);
                    img1.setPosition(610,300);
                }
                else if(q.peek().equals("Buratino")){
                    buratinonam.setPosition(560,170);
                    img2.setPosition(610,300);
                } else if (q.peek().equals("Frost")) {
                    frostnam.setPosition(560,170);
                    img3.setPosition(610,300);
                }

                clickLeft(q);

                if(q.peek().equals("Abrams")){
                    abhramsnam.setPosition(950,220);
                    img1.setPosition(1000,300);
                }
                else if(q.peek().equals("Buratino")){
                    buratinonam.setPosition(950,220);
                    img2.setPosition(1000,300);
                } else if (q.peek().equals("Frost")) {
                    frostnam.setPosition(950,220);
                    img3.setPosition(1000,300);
                }

                clickLeft(q);

                if(q.peek().equals("Abrams")){
                    abhramsnam.setPosition(130,220);
                    img1.setPosition(180,300);
                }
                else if(q.peek().equals("Buratino")){
                    buratinonam.setPosition(130,220);
                    img2.setPosition(180,300);
                } else if (q.peek().equals("Frost")) {
                    frostnam.setPosition(130,220);
                    img3.setPosition(180,300);
                }


            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(optionButton);

        //
        // Tank Name Images

        // Setting button
        Texture setname = new Texture(Gdx.files.local("Settings.png"));
        Image settings = new Image(setname);
        settings.setPosition(0,540);
        settings.setHeight(60);
        settings.setWidth(100);
        stage.addActor(settings);

        // Coin Button
        Texture coinname = new Texture(Gdx.files.local("CoinsDiamonds.png"));
        Image coin = new Image(coinname);
        coin.setPosition(1150,550);
        coin.setHeight(50);
        coin.setWidth(250);
        stage.addActor(coin);

        // Gift
        Texture giftimage = new Texture(Gdx.files.local("Gift.png"));
        Image gift = new Image(giftimage);
        gift.setPosition(20,20);
        gift.setHeight(70);
        gift.setWidth(100);
        stage.addActor(gift);

        // Calendar
        Texture calendarimage = new Texture(Gdx.files.local("Calendar.png"));
        final Image calendar = new Image(calendarimage);
        calendar.setPosition(20,430);
        calendar.setHeight(60);
        calendar.setWidth(60);
        stage.addActor(calendar);

//        loadingAnimation = skin.get("loading-animation", TenPatchDrawable.class);
        Label title = new Label("Choose Tank", MyGdxGame.gameSkin);
        title.setColor(Color.YELLOW);
//        title.setAlignment(Align.center);
//        title.setY(Gdx.graphics.getHeight() *6/7);
//        title.setSize(100,100);
        title.setWidth(100); title.setWidth(100);
        title.setPosition(650,550);
        stage.addActor(title);

        TextButton upgradeButton = new TextButton("Upgrade",MyGdxGame.gameSkin);
        upgradeButton.setWidth(Gdx.graphics.getWidth()/7);
        upgradeButton.setHeight(Gdx.graphics.getHeight()/9);
        upgradeButton.setPosition(130,50);
        upgradeButton.setSize(300,100);
        stage.addActor(upgradeButton);

        TextButton backButton = new TextButton("Play",MyGdxGame.gameSkin);
        backButton.setWidth(Gdx.graphics.getWidth()/7);
        backButton.setHeight(Gdx.graphics.getHeight()/9);
        backButton.setPosition(950,50);
        backButton.setSize(300,100);
//        backButton.setSize(Gdx.graphics.getHeight()/9,Gdx.graphics.getWidth()/12);
//        backButton.setPosition(Gdx.graphics.getWidth()/2-backButton.getWidth()/2,Gdx.graphics.getHeight()/7-backButton.getHeight()/2);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println(q);
                String str = "Buratino.png";
                Queue<String> tempq = new LinkedList<>();
                tempq = qc.cloneQueue(q);
                tempq.poll();
                System.out.println(tempq);
                if(tempq.peek().equals("Frost")){
                    str = "frost.png";
                }
                else if(tempq.peek().equals("Abrams")){
                    str = "AbramsLower.png";
                }
                //  Tank Body Fixtures
//                Sprite tankbody = new Sprite(new Texture(str));
//                tankbody.setPosition(50,1140);
//                tankbody.setSize(tankbody.getWidth() - 200, tankbody.getHeight());
//                BodyDef body_tank = new BodyDef();
//                body_tank.type = BodyDef.BodyType.DynamicBody;
//                body_tank.position.set(tankbody.getX(), tankbody.getY());
//                Body tbody = playscreen.getWorld().createBody(body_tank);
//                PolygonShape tankshape = new PolygonShape();
//                tankshape.setAsBox(tankbody.getWidth() / 2, tankbody.getHeight() / 2);
//                FixtureDef fixturetank = new FixtureDef();
//                fixturetank.shape = tankshape;
//                fixturetank.density = 1.0f;
//                Fixture fixture = tbody.createFixture(fixturetank);
//                tbody.setUserData(tankbody);
////        tankbody.setUserData(tbody);
//
//                // Tank Nosal Fixtures
//                Sprite tanknosal = new Sprite(new Texture("nosal.png"));
//                tanknosal.setPosition(50,1140);
//                tankbody.setPosition(50,1140);
//                tankbody.setSize(tankbody.getWidth() - 200, tankbody.getHeight());
//                BodyDef body_tank_nosal = new BodyDef();
//                body_tank_nosal.type = BodyDef.BodyType.DynamicBody;
//                body_tank_nosal.position.set(tankbody.getX(), tankbody.getY());
//                Body nosalBody = playscreen.getWorld().createBody(body_tank);
//                PolygonShape nosalshape = new PolygonShape();
//                tankshape.setAsBox(tanknosal.getWidth() / 2, tanknosal.getHeight() / 2);
//                FixtureDef fixturenosal = new FixtureDef();
//                fixturenosal.shape = tankshape;
//                fixturenosal.density = 1.0f;
//                Fixture fixturen = tbody.createFixture(fixturetank);
//                nosalBody.setUserData(tanknosal);
                game.setScreen(new playscreen(game,str));
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
        Gdx.app.log("MainScreen","show");
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0/255f, 0/255f, 0/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
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
    }
}
