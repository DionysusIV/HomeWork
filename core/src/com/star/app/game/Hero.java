package com.star.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class Hero extends Ship {
    public enum Skill {
        HP_MAX(20), HP(20), WEAPON(100), MAGNET(50);

        int cost;

        Skill(int cost) {
            this.cost = cost;
        }
    }

    private int score;
    private int scoreView;
    private StringBuilder sb;
    private int money;
    private Shop shop;
    private Circle magnetic;

    public Circle getMagneticField() {
        return magnetic;
    }

    public Shop getShop() {
        return shop;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }

    public boolean isMoneyEnough(int amount) {
        return money >= amount;
    }

    public void decreaseMoney(int amount) {
        money -= amount;
    }

    public void setPause(boolean pause) {
        gameController.setPause(pause);
    }

    public Hero(GameController gameController) {
        super(gameController,700, 100);
        this.texture = Assets.getInstance().getAtlas().findRegion("ship");
        this.position = new Vector2(640, 360);
        this.hitArea = new Circle(position, 28);

        this.magnetic = new Circle(position, 50);
        this.money = 1000;
        this.shop = new Shop(this);
        this.sb = new StringBuilder();
        this.ownerType = OwnerType.PLAYER;
    }

    public void addScore(int amount) {
        score += amount;
    }

    public void consume(PowerUp p) {
        sb.setLength(0);
        switch (p.getType()) {
            case MEDKIT:
                int oldHP = hp;
                hp += p.getPower();
                if (hp > hpMax) {
                    hp = hpMax;
                }
                sb.append("HP +").append(hp - oldHP);
                gameController.getInfoController().setup(p.getPosition().x, p.getPosition().y, sb,Color.GREEN );
                break;
            case AMMOS:
                int count = currentWeapon.addAmmos(p.getPower());
                sb.append("AMMOS +").append(count);
                gameController.getInfoController().setup(p.getPosition().x, p.getPosition().y, sb,Color.RED );
                break;
            case MONEY:
                money += p.getPower();
                sb.append("MONEY +").append(p.getPower());
                gameController.getInfoController().setup(p.getPosition().x, p.getPosition().y, sb,Color.YELLOW );
                break;
        }
    }

    public boolean upgrade(Skill skill) {
        switch (skill) {
            case HP_MAX:
                hpMax += 10;
                return true;
            case HP:
                if (hp < hpMax) {
                    hp += 10;
                    if (hp > hpMax) {
                        hp = hpMax;
                    }
                    return true;
                }
                return false;
            case WEAPON:
                if (weaponNum < weapons.length - 1) {
                    weaponNum++;
                    currentWeapon = weapons[weaponNum];
                    return true;
                }
                return false;
            case MAGNET:
                if (magnetic.radius < 500) {
                    magnetic.radius += 10;
                    return true;
                }
                return false;
        }
        return false;
    }

    public void renderHHP(SpriteBatch batch, BitmapFont font) {
        sb.setLength(0);
        sb.append("SCORE: ").append(scoreView).append("\n");
        sb.append("HP: ").append(hp).append("/").append(hpMax).append("\n");
        sb.append("BULLETS: ").append(currentWeapon.getCurBullets()).append("/").append(currentWeapon.getMaxBullets()).append("\n");
        sb.append("MONEY: ").append(money).append("\n");
        sb.append("MAGNETIC: ").append((int) magnetic.radius).append("\n");
        sb.append("TIMER: ").append((int) gameController.getTimer()).append("\n");
        font.draw(batch, sb, 20, 700);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32,
                64, 64, 1, 1, angle);
    }

    public void update(float dt) {
        super.update(dt);
        updateScore(dt);

        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            shop.setVisible(true);
            gameController.setPause(true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            tryToFire();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 180 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 180 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.x += MathUtils.cosDeg(angle) * enginePower * dt;
            velocity.y += MathUtils.sinDeg(angle) * enginePower * dt;

            float bx = position.x + MathUtils.cosDeg(angle + 180) * 25;
            float by = position.y + MathUtils.sinDeg(angle + 180) * 25;

            for (int i = 0; i < 3; i++) {
               gameController.getParticleController().setup(bx + MathUtils.random(-4, 4), by + MathUtils.random(-4, 4),
                        velocity.x * -0.1f + MathUtils.random(-20, 20), velocity.y * -0.1f + MathUtils.random(-20, 20),
                        0.4f,
                        1.2f, 0.2f,
                        1.0f, 0.5f, 0.0f, 1.0f,
                        1.0f, 1.0f, 1.0f, 0.0f);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            brake(dt);

            float bx = position.x + MathUtils.cosDeg(angle - 90) * 25;
            float by = position.y + MathUtils.sinDeg(angle - 90) * 25;

            for (int i = 0; i < 3; i++) {
                gameController.getParticleController().setup(bx + MathUtils.random(-4, 4), by + MathUtils.random(-4, 4),
                        velocity.x * 0.1f + MathUtils.random(-20, 20), velocity.y * 0.1f + MathUtils.random(-20, 20),
                        0.2f,
                        1.2f, 0.2f,
                        1.0f, 0.5f, 0.0f, 1.0f,
                        1.0f, 1.0f, 1.0f, 0.0f);
            }

            bx = position.x + MathUtils.cosDeg(angle + 90) * 25;
            by = position.y + MathUtils.sinDeg(angle + 90) * 25;

            for (int i = 0; i < 3; i++) {
                gameController.getParticleController().setup(bx + MathUtils.random(-4, 4), by + MathUtils.random(-4, 4),
                        velocity.x * 0.1f + MathUtils.random(-20, 20), velocity.y * 0.1f + MathUtils.random(-20, 20),
                        0.2f,
                        1.2f, 0.2f,
                        1.0f, 0.5f, 0.0f, 1.0f,
                        1.0f, 1.0f, 1.0f, 0.0f);
            }
        }
        magnetic.setPosition(position);
    }

    private void updateScore(float dt) {
        if (scoreView < score) {
            scoreView += 1500 * dt;
            if (scoreView > score) {
                scoreView = score;
            }
        }
    }
}