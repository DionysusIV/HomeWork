package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class Asteroid implements Poolable {
    private GameController gameController;
    private TextureRegion textureAsteroid;
    private float angleAsteroid;
    private boolean active;
    private float scale;
    private Vector2 position;
    private float rotationSpeed;
    private Circle hitArea;
    private Vector2 velocity;
    private int hpMax;
    private int hp;

    private final float BASE_SIZE = 256.0f;
    private final float BASE_RADIUS = BASE_SIZE / 2;

    public Vector2 getVelocity() {
        return velocity;
    }

    public float getScale() {
        return scale;
    }

    public Circle getHitArea() {
        return hitArea;
    }

    public int getHpMax() {
        return hpMax;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Asteroid(GameController gameController) {
        this.gameController = gameController;
        this.textureAsteroid = Assets.getInstance().getAtlas().findRegion("asteroid");;
        this.velocity = new Vector2(1024, 360);
        this.position = new Vector2(0,0);
      //  this.angleAsteroid = 0.0f;
        this.active = false;
        this.hitArea = new Circle(0,0,0);
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureAsteroid, position.x - 128, position.y - 128, 128, 128,  256, 256, scale,scale, angleAsteroid);
    }

    public void deactivate() {
        active = false;
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);
        angleAsteroid += rotationSpeed * dt;

        if (position.x < -200) {
            position.x = ScreenManager.SCREEN_WIDTH + 200;
        }
        if (position.x > ScreenManager.SCREEN_WIDTH + 200) {
            position.x = -200;
        }
        if (position.y < -200) {
            position.y = ScreenManager.SCREEN_HEIGHT + 200;
        }
        if (position.y > ScreenManager.SCREEN_HEIGHT + 200) {
            position.y = -200;
        }
        hitArea.setPosition(position);
    }

    public void activate(float x, float y, float vx, float vy, float scale) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
        hpMax = (int) (10 * scale);
        hp = hpMax;
        angleAsteroid = MathUtils.random(0.0f, 360.0f);
        rotationSpeed = MathUtils.random(-180.0f, 180.0f);
        hitArea.setPosition(x, y);
        this.scale = scale;
        hitArea.setRadius(BASE_RADIUS * scale * 0.9f);
    }

    public boolean takeDamage(int amount){
        hp -= amount;
        if ( hp <= 0) {
            deactivate();
            if (scale > 0.4f) {
                for (int i = 0; i < 5; i++) {
                    if (MathUtils.random() < 0.5) {
                        gameController.getAsteroidController().setup(position.x, position.y,
                                MathUtils.random(-150, 150), MathUtils.random(-150, 150), scale - 0.3f);
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
