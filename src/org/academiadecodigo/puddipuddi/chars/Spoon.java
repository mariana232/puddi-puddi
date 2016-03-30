package org.academiadecodigo.puddipuddi.chars;

import org.academiadecodigo.puddipuddi.field.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by Mariana on 19/02/16.
 */
public abstract class Spoon extends Character implements KeyboardHandler{

        //private Keyboard k = new Keyboard(this);

        public Spoon(String file, int velocity) {
            super(file, velocity);
        }
}
