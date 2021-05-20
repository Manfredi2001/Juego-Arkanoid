package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bola extends Actor {

    //Atributos
    //Posicion de la bola
    float x, y;
    //Tamaño radio
    float radio;
    //Velocidad movimiento.
    float xSpeed, ySpeed;
    //Color.
    Color color = Color.WHITE;

    //Constructor
    public Bola(float x, float y, float radio, float xSpeed, float ySpeed) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    //Metodo para actualizar la posición de la bola y respetar los margenes de la pantalla.
    public void update() {
        x += xSpeed;
        y += ySpeed;
        //Tenemos en cuenta el radio, ya que la x,y de la pelota es su centro.
        //Controlamos las esquinas de la pantalla y los margenes de la X e Y
        if (x < radio || x > Gdx.graphics.getWidth() - radio) {
            xSpeed = -xSpeed;
        }
        if (y < radio || y > Gdx.graphics.getHeight() - radio) {
            ySpeed = -ySpeed;
        }
    }
    
    //Metodo que comprueba la colisión de la bola con la paleta y cambia de color.
    public void checkCollision(Paleta paleta) {
        //Comrpobamos si la paleta ha colisionado con la bola.
        if(collidesWith(paleta)){
            //Invertimos el movimiento del eje Y.
            ySpeed = -ySpeed;
            y += ySpeed;
        }
    }

    //Metodo que comprueba la colisión de la bola con un bloque.
    public void checkCollision(Bloque bloque) {
        if(collidesWith(bloque)){
            ySpeed = - ySpeed;
            bloque.destruido = true;
        }
    }

    //Metodo que devuleve true si la bola y la paleta se superponen.
    private boolean collidesWith(Paleta paleta) {
        //Variables locales
        boolean colision = false;
        //Crearemos dos rectangulos con las medidas de la bola y la paleta.
        Rectangle bolaR = new Rectangle(this.x-this.radio,this.y-this.radio,this.radio*2,this.radio*2);
        Rectangle paletaR = new Rectangle(paleta.x, paleta.y, paleta.width, paleta.height);
        //Usaremos el metodo que tiene la clase REctangle para saber si se superponen los dos cuadrados.
        if(bolaR.overlaps(paletaR)) colision = true;
        return colision;
    }

    //Metodo que devuleve true si la bola y un bloque se superponen.
    private boolean collidesWith(Bloque bloque) {
        //Variables locales
        boolean colision = false;
        //Crearemos dos rectangulos con las medidas de la bola y la paleta.
        Rectangle bolaR = new Rectangle(this.x-this.radio,this.y-this.radio,this.radio*2,this.radio*2);
        Rectangle bloqueR = new Rectangle(bloque.x, bloque.y, bloque.width, bloque.height);
        //Usaremos el metodo que tiene la clase REctangle para saber si se superponen los dos cuadrados.
        if(bolaR.overlaps(bloqueR)) colision = true;
        return colision;
    }

    //Metodo que dibuja la bola
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, radio);
    }

    //Getters y setters
    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
