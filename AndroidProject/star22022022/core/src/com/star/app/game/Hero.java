package com.star.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.screen.ScreenManager;

public class Hero {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private float angle;
    private float enginePower;
    private GameController gameController;
    private float fireTimer;

    public Vector2 getVelocity() {
        return velocity;
    }


    public Vector2 getPosition() {
        return position;
    }



    public float getAngle() {
        return angle;
    }

    public Hero(GameController gameController) {
        this.texture = new Texture("ship.png");
        this.position = new Vector2(640, 360);
        this.velocity = new Vector2(0,0);
        this.angle = 0.0f;
        this.enginePower = 700.0f;
        this.gameController = gameController;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64,
                1, 1, angle, 0, 0, 64, 64, false, false);
    }

    public void update(float dt) {
        fireTimer += dt;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if(fireTimer > 0.2){
                fireTimer = 0.0f;
                gameController.getBulletController().setup(position.x, position.y,
                        MathUtils.cosDeg(angle) * 300 + velocity.x,
                        MathUtils.sinDeg(angle) * 300 + velocity.x);
            }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 180 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle += 180 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.x += MathUtils.cosDeg(angle) * enginePower * dt;
            position.y += MathUtils.sinDeg(angle) * enginePower * dt;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            position.x -= MathUtils.cosDeg(angle) * 300f * dt;
            position.y -= MathUtils.sinDeg(angle) * 300f * dt;
        }

        position.mulAdd(velocity,dt);
        float stopKoef = 1.0f - 1.0f * dt;
        if(stopKoef < 0.0f){
            stopKoef = 0.0f;
        }
        velocity.scl(stopKoef);

        checkBorders();
    }

    public void checkBorders(){
        if (position.x < 32){
            position.x = 32f;
            velocity.x *= -0.5f;
        }
        if (position.x > ScreenManager.SCREEN_WIDTH - 32){
            position.x = ScreenManager.SCREEN_WIDTH - 32f;
            velocity.x *= -0.5f;
        }
        if (position.y < 32){
            position.y = 32f;
            velocity.y *= -0.5f;
        }
        if (position.y > ScreenManager.SCREEN_HEIGHT - 32){
            position.y = ScreenManager.SCREEN_HEIGHT - 32f;
            velocity.y *= -0.5f;
        }
    }
}