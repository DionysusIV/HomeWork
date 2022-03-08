package com.star.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class Hero {
    private TextureRegion texture;
    private Vector2 position;
    private Vector2 velocity;
    private float angle;
    private float enginePower;
    private GameController gameController;
    private float fireTimer;
    private int score;
    private int scoreView;
    private int hpMax;
    private int hp;
    private StringBuilder sb;
    private Circle hitArea;

    public Circle getHitArea() {
        return hitArea;
    }

    public int getScore() {
        return score;
    }

    public int getScoreView() {
        return scoreView;
    }

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
        this.gameController = gameController;
        this.texture = Assets.getInstance().getAtlas().findRegion("ship");
        this.position = new Vector2(640, 360);
        this.velocity = new Vector2(0,0);
        this.angle = 0.0f;
        this.enginePower = 700.0f;
        this.hpMax = 100;
        this.hp = hpMax;
        this.sb = new StringBuilder();
        this.hitArea = new Circle(position, 28);


    }

    public void addScore(int amount){
        score += amount;
    }

    public void takeDamage(int amount) {
        hp -= amount;
    }

    public void renderHHP(SpriteBatch batch, BitmapFont font) {
        sb.setLength(0);
        sb.append("Score: ").append(scoreView).append("\n");
        sb.append("HP: ").append(hp).append("/").append(hpMax).append("\n");
        font.draw(batch, sb,20,700);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64,
                1, 1, angle);
    }

    public void update(float dt) {
        fireTimer += dt;
        if (scoreView < score){
            scoreView += 1000 *dt;
            if(scoreView > score){
                scoreView = score;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if(fireTimer > 0.2){
                fireTimer = 0.0f;

                float wx = position.x + MathUtils.cosDeg(angle + 90) * 20;
                float wy = position.y + MathUtils.sinDeg(angle + 90) * 20;

                gameController.getBulletController().setup(position.x, position.y,
                        MathUtils.cosDeg(angle) * 300 + velocity.x,
                        MathUtils.sinDeg(angle) * 300 + velocity.x);

               wx = position.x + MathUtils.cosDeg(angle ) * 20;
               wy = position.y + MathUtils.sinDeg(angle ) * 20;

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
        hitArea.setPosition(position);
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