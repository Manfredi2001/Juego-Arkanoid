package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paleta {

    //Atributos
    //Posición de la paleta.
    int x, y;
    //Tamaño rectangulo
    int width, height;

    //Constructor.
    public Paleta(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //Metodo para actualizar la posición de la paleta, respetando los margenes de la pantalla.
    public void update(){
        //Establecemos la posicion de la X.
        x = Gdx.input.getX()-width/2; //Posicionamos el cursor en la mitad del rectangulo.
        //Establecemos la posición de la Y.  //Si posicionamos el cursor en la esquina superior derecha la posición es (500,0).
        //y = Gdx.graphics.getHeight() - Gdx.input.getY(); //La posición Y del cursor comienza desde la parte superior.
        //Tenemos en cuenta el tamaño, ya que la x,y del rectangulo es la esquina inferior izquierda.
        //Margen izquierdo y derecho.
        if(x < 0) x=0;
        if(x > Gdx.graphics.getWidth() - width) x=Gdx.graphics.getWidth()-width;
        //Margen superior e inferior.
        if(y < 0) y=0;
        if(y > Gdx.graphics.getHeight() - height) y=Gdx.graphics.getHeight()-height;
    }

    //Metodo que dibuja la bola
    public void draw(ShapeRenderer shape) {
        shape.rect(x,y,width,height);
    }


}
