package com.sierox.dositaire.screens.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.sierox.dositaire.Dositaire;
import com.sierox.dositaire.util.managers.BackgroundManager;
import com.sierox.dositaire.screens.menu.MenuScreen;

public class OptionsScreen implements Screen {

    protected Dositaire game;
    private OptionsScreenUI ui;

    public OptionsScreen(Dositaire game) {
        this.game = game;
        initializeUi();
    }

    private void initializeUi() {
        Gdx.input.setCatchBackKey(true);
        ui = new OptionsScreenUI(this);
        Gdx.input.setInputProcessor(ui);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        drawMenu();
        ui.act(delta);
        ui.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }
    }

    private void drawMenu() {
        game.batch.begin();
        game.batch.draw(BackgroundManager.getChosenMenu(), 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
