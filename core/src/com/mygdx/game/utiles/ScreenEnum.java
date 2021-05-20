package com.mygdx.game.utiles;


import com.mygdx.game.pantallas.AbstractScreen;
import com.mygdx.game.pantallas.GameScreen;
import com.mygdx.game.pantallas.LevelSelectScreen;
import com.mygdx.game.pantallas.MainMenuScreen;

public enum ScreenEnum {

    MAIN_MENU {
        public AbstractScreen getScreen(Object... params) {
            return new MainMenuScreen();
        }
    },

    LEVEL_SELECT {
        public AbstractScreen getScreen(Object... params) {
            return new LevelSelectScreen();
        }
    },

    GAME {
        public AbstractScreen getScreen(Object... params) {
            return new GameScreen((Integer) params[0]);
        }
    };

    public abstract AbstractScreen getScreen(Object... params);
}
