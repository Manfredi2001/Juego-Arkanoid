package com.mygdx.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Bloque;
import com.mygdx.game.Bola;
import com.mygdx.game.Paleta;
import com.mygdx.game.utiles.ScreenEnum;
import com.mygdx.game.utiles.UIFactory;

import java.util.ArrayList;

public class GameScreen extends AbstractScreen {

    private Texture txtrBack;
    // Current level
    private int level;

    //ShapeRender se usa para dibujar formas geometricas.
    ShapeRenderer shape;
    Bola bola;
    Paleta paleta;
    ArrayList<Bloque> bloques = new ArrayList<>();
    //Variable para controlar el numero de errores.
    int fallos;



    public GameScreen(Integer level) {
        super();
        this.level = level.intValue();
        txtrBack = new Texture( Gdx.files.internal("btn_back.png") );

        //Creamos las formas.
        shape = new ShapeRenderer();
        //Creamos la bola
        bola = new Bola(50,50, 10, 5, 5);
        //Creamos la paleta.
        paleta = new Paleta(0, 40, 100,10);
        //Creamos los bloques.
        crearBloques();
    }

    //Creamos los bloques
    private void crearBloques() {
        int blockWidth = 63;
        int blockHeight = 20;
        for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                bloques.add(new Bloque(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void buildStage() {

        ImageButton btnBack = UIFactory.createButton(txtrBack);
        btnBack.setPosition(260.f, 40.f, Align.center);
        addActor(btnBack);

        addActor(bola);

        //Si la bola choca con el la parte inferior de la pantalla.
        if(bola.getY() < bola.getRadio()){
            fallos++;
        }
        //A la tercera vez que toque la parte inferior de la pantalla, paramos la ejecución.
        if (fallos <= 3200){
            shape.begin(ShapeRenderer.ShapeType.Filled);
            bola.update();
            bola.draw(shape);
            bola.checkCollision(paleta);
            paleta.update();
            paleta.draw(shape);
            for (Bloque b: bloques){
                if(!b.isDestruido()){
                    b.draw(shape);
                    bola.checkCollision(b);
                }
            }
        }
        shape.end();

        btnBack.addListener( UIFactory.createListener( ScreenEnum.LEVEL_SELECT ) );
    }

    @Override
    public void dispose() {
        super.dispose();
        txtrBack.dispose();
    }

}
