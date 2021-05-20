package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.utiles.ScreenEnum;
import com.mygdx.game.utiles.ScreenManager;

import java.util.ArrayList;
import java.util.Random;

public class Arkanoid extends Game {

	//ShapeRender se usa para dibujar formas geometricas.
	ShapeRenderer shape;
	Bola bola;
	Paleta paleta;
	ArrayList<Bloque> bloques = new ArrayList<>();
	//Variable para controlar el numero de errores.
	int fallos;
	
	@Override
	public void create () { //Metodo que solo se ejecuta una vez

			ScreenManager.getInstance().initialize(this);
			ScreenManager.getInstance().showScreen( ScreenEnum.MAIN_MENU );

		/*
		//Creamos las formas.
		shape = new ShapeRenderer();
		//Creamos la bola
		bola = new Bola(50,50, 10, 5, 5);
		//Creamos la paleta.
		paleta = new Paleta(0, 40, 100,10);
		//Creamos los bloques.
		crearBloques();
		*/
	}
/*
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
	public void render () { //Metodo que se ejecuta una vez por cada fotograma, 60 veces por segundo.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
			//Si la bola choca con el la parte inferior de la pantalla.
			if(bola.y < bola.radio){
				fallos++;
			}
			//A la tercera vez que toque la parte inferior de la pantalla, paramos la ejecución.
			if (fallos <= 3200){
				bola.update();
				bola.draw(shape);
				bola.checkCollision(paleta);
				paleta.update();
				paleta.draw(shape);
				for (Bloque b: bloques){
					if(!b.destruido){
						b.draw(shape);
						bola.checkCollision(b);
					}
				}
			}
		shape.end();
	}
	
	@Override
	public void dispose () {
		shape.dispose();
	}
	*/

}
