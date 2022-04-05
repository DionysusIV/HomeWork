package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class WorldRenderer {
    private GameController gameController;
    private SpriteBatch batch;
    private BitmapFont font32;
    private BitmapFont font72;
    private StringBuilder sb;


    public WorldRenderer(GameController gameController,SpriteBatch batch){
        this.gameController = gameController;
        this.batch = batch;
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf", BitmapFont.class);
        this.font72 = Assets.getInstance().getAssetManager().get("fonts/font72.ttf", BitmapFont.class);
        this.sb = new StringBuilder();
    }

    public void render () {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        gameController.getBackground().render(batch);
        gameController.getHero().render(batch);
        gameController.getAsteroidController().render(batch);
        gameController.getBulletController().render(batch);
        gameController.getHero().renderHHP(batch,font32);
        gameController.getParticleController().render(batch);
        gameController.getPowerUpsController().render(batch);
        gameController.getBotController().render(batch);
        gameController.getInfoController().render(batch, font32);
        if (gameController.getTimer() < 3) {
            sb.setLength(0);
            sb.append("Level ").append(gameController.getLevel());
            font72.draw(batch, sb, 0, ScreenManager.HALF_SCREEN_HEIGHT,
                    ScreenManager.SCREEN_WIDTH, Align.center, false);
        }
        batch.end();

        gameController.getStage().draw();
    }
}
