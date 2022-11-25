package com.mygdx.game.test2;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tank extends Actor {
    // Tank properties
    private Vector2 position;
    private Vector2 velocity;
    private float turretRotation;

    public Tank() {
        // Initialize position and velocity
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.turretRotation = 0;
    }
    // Tank methods go here

    // Move the tank in the direction it is facing
    public void moveForward(float speed) {
        velocity.x = (float)(speed);
    }

    // Rotate the turret
    public void rotateTurret(float angle) {
        turretRotation += angle;
    }

    public void update(float deltaTime) {
        position.add(velocity.cpy().scl(deltaTime));
    }

//    @Override
//    public void draw(SpriteBatch batch, float alpha) {
//        // Set the SpriteBatch's transformation matrix to match the tank's position and rotation
//        batch.setTransformMatrix(getTransformMatrix());
//
//        // Draw the tank's body and turret using the SpriteBatch
////        batch.draw(bodyTexture, -bodyTexture.getWidth() / 2, -bodyTexture.getHeight() / 2);
////        batch.draw(turretTexture, -turretTexture.getWidth() / 2, -turretTexture.getHeight() / 2,
////                turretTexture.getWidth() / 2, turretTexture.getHeight() / 2,
////                turretTexture.getWidth(), turretTexture.getHeight(),
////                1, 1, turretRotation);
//
//        // Reset the SpriteBatch's transformation matrix
//        batch.setTransformMatrix(new Matrix4());
//    }
//
//    private Matrix4 getTransformMatrix() {
//        Matrix4 o = null;
//        return o;
//    }
}

