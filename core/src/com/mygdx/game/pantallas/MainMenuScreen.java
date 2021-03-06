package com.mygdx.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.utiles.ScreenEnum;
import com.mygdx.game.utiles.UIFactory;

public class MainMenuScreen extends AbstractScreen{

    //Atributos para mostrar imagenes.
    private Texture txtrBg;
    private Texture txtrPlay;
    private Texture txtrExit;

    public MainMenuScreen() {
        super();
        txtrBg   = new Texture( Gdx.files.internal("main_menu_bg.png") );
        txtrPlay = new Texture( Gdx.files.internal("btn_play.png") );
        txtrExit = new Texture( Gdx.files.internal("btn_exit.png") );
    }

    @Override
    public void buildStage() {

        // Adding actors
        Image bg = new Image(txtrBg);
        addActor(bg);

        ImageButton btnPlay = UIFactory.createButton(txtrPlay);
        btnPlay.setPosition(getWidth() / 2, 120.f, Align.center);
        addActor(btnPlay);

        ImageButton btnExit = UIFactory.createButton(txtrExit);
        btnExit.setPosition(getWidth() / 2, 60.f, Align.center);
        addActor(btnExit);

        // Setting listeners
        btnPlay.addListener( UIFactory.createListener(ScreenEnum.LEVEL_SELECT) );

        btnExit.addListener(
                new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        Gdx.app.exit();
                        return false;
                    }
                });
    }

    @Override
    public void dispose() {
        super.dispose();
        txtrBg.dispose();
        txtrPlay.dispose();
        txtrExit.dispose();
    }

}
