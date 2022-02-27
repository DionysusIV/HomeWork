package com.star.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Texture textureAsteroid;
    private Vector2 positionAsteroid;
    private Vector2 lastDisplacement;
    private float angleAsteroid;


    public Asteroid() {
        this.textureAsteroid = new Texture("asteroid.png");
        this.positionAsteroid = new Vector2(1024, 360);
        this.lastDisplacement = new Vector2(0,0);
        this.angleAsteroid = 0.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureAsteroid, positionAsteroid.x - 128, positionAsteroid.y - 128, 128, 128, 256, 256,
                1, 1, angleAsteroid, 0, 0, 256, 256, false, false);
    }

    public void update(float dt) {

    }
}
