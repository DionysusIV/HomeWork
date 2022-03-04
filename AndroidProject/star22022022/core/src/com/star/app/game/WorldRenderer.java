package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class WorldRenderer {
    private GameController gameController;
    private SpriteBatch batch;

    public WorldRenderer(GameController gameController,SpriteBatch batch){
        this.gameController = gameController;
        this.batch = batch;
    }

    public void render () {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        gameController.getBackground().render(batch);
        gameController.getHero().render(batch);
        gameController.getAsteroidController().render(batch);
        gameController.getBulletController().render(batch);
        batch.end();
    }
}
