package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.screen.utils.Assets;

public class WorldRenderer {
    private GameController gameController;
    private SpriteBatch batch;
    private StringBuilder sb;
    private BitmapFont font32;

    public WorldRenderer(GameController gameController,SpriteBatch batch){
        this.gameController = gameController;
        this.batch = batch;
        this.sb = new StringBuilder();
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf", BitmapFont.class);
    }

    public void render () {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        gameController.getBackground().render(batch);
        gameController.getHero().render(batch);
        gameController.getAsteroidController().render(batch);
        gameController.getBulletController().render(batch);
        gameController.getHero().renderHHP(batch,font32);
        batch.end();
    }
}
