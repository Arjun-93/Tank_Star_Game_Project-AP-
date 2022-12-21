package com.mygdx.game.test2;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;

public class B2WorldCreator extends ApplicationAdapter {

    public static class Bullet
    {
        public Vector2 position = new Vector2();
        public Vector2 direction = new Vector2();

        public Bullet(Vector2 position,  Vector2 direction)
        {
            this.position.set(position);
            this.direction.set(direction);
        }

        public void update(float delta) {
            float speed = 16.0f;
            position.add(direction.x * delta * speed, direction.y * delta * speed);
        }
    }

    OrthographicCamera camera;
    SpriteBatch spriteBatch;
    ShapeRenderer shapeRenderer;
    Texture texture;

    Vector2 position;
    Vector2 barrelOffset;
    float angle;

    Array<Bullet> bullets;

    @Override
    public void create() {
        float aspectRatio = (float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
        camera = new OrthographicCamera(10, 10 / aspectRatio);
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        texture = new Texture("tank.png"); // From https://opengameart.org/content/topdown-shooter (Kenney)

        position = new Vector2();
        barrelOffset = new Vector2(1.0f, -0.5f).scl(0.5f); // Relative coordinates to where the barrel is in the sprite

        bullets = new Array<>();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        Vector2 direction = (new Vector2(1.0f, 0.0f)).rotateDeg(angle); // unit vector of the direction of the player
        Vector2 origin = new Vector2(0.5f, 0.5f); // rotation origin, rotate around the center of the image. ( 0,0 would have been upper left corner)
        Vector2 offset = (new Vector2(barrelOffset)).rotateDeg(angle).add(origin); // Rotated barrel offset
        Vector2 barrelPosition = (new Vector2(position)).add(offset);

        float delta = Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            angle += delta * 90.0f;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            angle -= delta * 90.0f;
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            position.add(direction.x * delta * 2.0f, direction.y * delta * 2.0f);
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            position.sub(direction.x * delta * 2.0f, direction.y * delta * 2.0f);
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            bullets.add(new Bullet(barrelPosition, direction));

        for(Bullet bullet : bullets)
            bullet.update(delta);

        spriteBatch.draw(texture,
                position.x, position.y,
                0.5f, 0.5f,
                1, 1,
                1, 1,
                angle,
                0, 0,
                texture.getWidth(), texture.getHeight(),
                false, false);

        spriteBatch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.RED);

        for(Bullet bullet : bullets)
            shapeRenderer.circle(bullet.position.x, bullet.position.y, 0.1f, 32);
        shapeRenderer.end();
    }
}