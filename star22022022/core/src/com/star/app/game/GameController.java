package com.star.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.screen.ScreenManager;

public class GameController {
    private Background background;
    private Hero hero;
    private AsteroidController asteroidController;
    private BulletController bulletController;
    private Vector2 tempVector;



    public BulletController getBulletController() {
        return bulletController;
    }

    public Background getBackground(){
        return background;
    }

    public Hero getHero(){
        return hero;
    }

    public AsteroidController getAsteroidController() {
        return asteroidController;
    }

    public GameController() {
        this.background = new Background(this);
        this.hero = new Hero(this);
        this.asteroidController = new AsteroidController(this);
        this.bulletController = new BulletController();
        this.tempVector = new Vector2();

        for (int i = 0; i < 3; i++){
            asteroidController.setup(MathUtils.random(0, ScreenManager.SCREEN_WIDTH),
                    MathUtils.random(0, ScreenManager.SCREEN_HEIGHT)
                    , MathUtils.random(-150,150), MathUtils.random(-150,150), 1.0f);
        }
    }

    public void update (float dt){
        background.update(dt);
        hero.update(dt);
        asteroidController.update(dt);
        bulletController.update(dt);
        checkCollisions();
    }

    public  void checkCollisions() {
        for (int i = 0; i < asteroidController.getActiveList().size(); i++) {
            Asteroid a = asteroidController.getActiveList().get(i);
            if(hero.getHitArea().overlaps(a.getHitArea())){
                float dst = a.getPosition().dst(hero.getPosition());
                float halfOverLen = (a.getHitArea().radius + hero.getHitArea().radius - dst)/ 2.0f;
                tempVector.set(hero.getPosition()).sub(a.getPosition().nor());
                hero.getPosition().mulAdd(tempVector, halfOverLen);
                a.getPosition().mulAdd(tempVector, - halfOverLen);

               float sumScl = hero.getHitArea().radius + a.getHitArea().radius;
               hero.getVelocity().mulAdd(tempVector, 200f * a.getHitArea().radius / sumScl);
               a.getVelocity().mulAdd(tempVector, -200.0f * hero.getHitArea().radius / sumScl);

               if (a.takeDamage(2)){
                   hero.addScore(a.getHpMax() * 50);
               }
               hero.takeDamage(2);
            }
        }

        for (int i = 0; i < bulletController.getActiveList().size(); i++) {
            Bullet b = bulletController.getActiveList().get(i);
            for (int j = 0; i < asteroidController.getActiveList().size(); j++){
                Asteroid a = asteroidController.getActiveList().get(j);
                if (a.getHitArea().contains(b.getPosition())){
                    b.deactivate();
                    if (a.takeDamage(1)){
                        hero.addScore(a.getHpMax() * 100);
                    }
                    break;
                }
            }
            if (hero.getPosition().dst(b.getPosition()) < 32.0f) {
            }
        }
    }

}
