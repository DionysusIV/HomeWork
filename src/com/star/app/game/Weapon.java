package com.star.app.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class Weapon {
    private GameController gameController;

    private float firePeriod;
    private int damage;
    private float bulletSpeed;
    private int maxBullets;
    private int curBullets;
    private Ship ship;

    private Vector3[] slots;

    public float getFirePeriod() {
        return firePeriod;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public int getCurBullets() {
        return curBullets;
    }

    public Weapon(GameController gameController,Ship ship, float firePeriod, int damage,
                  float bulletSpeed, int maxBullets, Vector3[] slots) {

        this.gameController = gameController;
        this.ship = ship;
        this.firePeriod = firePeriod;
        this.damage = damage;
        this.bulletSpeed = bulletSpeed;
        this.maxBullets = maxBullets;
        this.curBullets = maxBullets;
        this.slots = slots;
    }

    public void fire() {
        if (curBullets > 0) {
            curBullets--;

            for (int i = 0; i < slots.length; i++) {
                float x, y, vx, vy;
                x = ship.getPosition().x + slots[i].x * MathUtils.cosDeg(ship.getAngle() + slots[i].y) ;
                y = ship.getPosition().y + slots[i].x * MathUtils.sinDeg(ship.getAngle() + slots[i].y) ;
                vx = ship.getVelocity().x + bulletSpeed * MathUtils.cosDeg(ship.getAngle() + slots[i].z);
                vy = ship.getVelocity().y + bulletSpeed * MathUtils.sinDeg(ship.getAngle() + slots[i].z);

                gameController.getBulletController().setup(x, y, vx, vy);
            }
        }
    }

    public int addAmmos(int amount) {
        int oldCurBullets = curBullets;
        curBullets += amount;
        if (curBullets > maxBullets) {
            curBullets = maxBullets;
        }
        return curBullets - oldCurBullets;
    }
}
