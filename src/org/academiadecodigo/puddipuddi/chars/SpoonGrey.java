package org.academiadecodigo.puddipuddi.chars;

import org.academiadecodigo.puddipuddi.field.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by Mariana on 11/02/16.
 */
public class SpoonGrey extends Spoon{

    private Keyboard k = new Keyboard(this);

    public SpoonGrey(String file, int velocity) {
        super(file, velocity);
        keyConfig();
    }

    public void keyConfig(){

        KeyboardEvent eventY = new KeyboardEvent();
        eventY.setKey(KeyboardEvent.KEY_Y);
        eventY.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventY);

        KeyboardEvent eventU = new KeyboardEvent();
        eventU.setKey(KeyboardEvent.KEY_U);
        eventU.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventU);

        KeyboardEvent eventI = new KeyboardEvent();
        eventI.setKey(KeyboardEvent.KEY_I);
        eventI.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventI);

        KeyboardEvent eventH = new KeyboardEvent();
        eventH.setKey(KeyboardEvent.KEY_H);
        eventH.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventH);

        KeyboardEvent eventJ = new KeyboardEvent();
        eventJ.setKey(KeyboardEvent.KEY_J);
        eventJ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventJ);

        KeyboardEvent eventK = new KeyboardEvent();
        eventK.setKey(KeyboardEvent.KEY_K);
        eventK.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventK);

        KeyboardEvent eventN = new KeyboardEvent();
        eventN.setKey(KeyboardEvent.KEY_N);
        eventN.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventN);

        KeyboardEvent eventM = new KeyboardEvent();
        eventM.setKey(KeyboardEvent.KEY_M);
        eventM.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventM);
    }

    @Override
    public void keyPressed(KeyboardEvent key) {
        Direction dir;

        switch (key.getKey()){
            case KeyboardEvent.KEY_Y:
                dir = Direction.UPLEFT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_U:
                dir = Direction.UP;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_I:
                dir = Direction.UPRIGHT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_H:
                dir = Direction.LEFT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_J:
                dir = Direction.DOWN;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_K:
                dir = Direction.RIGHT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_N:
                dir = Direction.DOWNLEFT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_M:
                dir = Direction.DOWNRIGHT;
                setDir(dir);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent key) {

    }

    @Override
    public void move() throws InterruptedException {

        for (int i = 1; i < velocity() + 1; i++) {

            Direction dir2 = this.getDir();
            Representation rep2 = this.getRepresentation();
            rep2.move(dir2);

            if (collision != null) {
                collision.checkCollision(this);
            }
        }
    }
}
