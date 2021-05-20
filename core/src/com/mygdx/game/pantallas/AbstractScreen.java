package com.mygdx.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

// Esta será la clase padre de cada una de nuestras escenas.
// Cada pantalla de nuestro videojuego implementará la interfaz Screen y Stage.
// Para combinar estos dos elementos utilizo una clase abstracta.
public abstract class AbstractScreen extends Stage implements Screen {

    protected AbstractScreen() {
        super( new StretchViewport(320.0f, 240.0f, new OrthographicCamera()) );
    }

    // Definimos un método abstracto, buildStage(), que deberá ser implementado por cada pantalla de nuestro juego.
    // Este método se utiliza para añadir los actores a cada escena
    public abstract void buildStage();

    @Override
    public void render(float delta) {
        // Limpiamos la pantalla
        //Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Llamamos a los metodos estáticos.
        super.act(delta);
        super.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
    }

    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}

}
