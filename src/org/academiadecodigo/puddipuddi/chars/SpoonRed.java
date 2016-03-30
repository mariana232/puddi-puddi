package org.academiadecodigo.puddipuddi.chars;

import org.academiadecodigo.puddipuddi.field.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by Mariana on 11/02/16.
 */
public class SpoonRed extends Spoon{

    private Keyboard k = new Keyboard(this);

    public SpoonRed(String file, int velocity) {
        super(file, velocity);
        keyConfig();
    }

    public void keyConfig(){

        KeyboardEvent eventQ = new KeyboardEvent();
        eventQ.setKey(KeyboardEvent.KEY_Q);
        eventQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventQ);

        KeyboardEvent eventW = new KeyboardEvent();
        eventW.setKey(KeyboardEvent.KEY_W);
        eventW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventW);

        KeyboardEvent eventE = new KeyboardEvent();
        eventE.setKey(KeyboardEvent.KEY_E);
        eventE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventE);

        KeyboardEvent eventA = new KeyboardEvent();
        eventA.setKey(KeyboardEvent.KEY_A);
        eventA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventA);

        KeyboardEvent eventS = new KeyboardEvent();
        eventS.setKey(KeyboardEvent.KEY_S);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventS);

        KeyboardEvent eventD = new KeyboardEvent();
        eventD.setKey(KeyboardEvent.KEY_D);
        eventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventD);

        KeyboardEvent eventZ = new KeyboardEvent();
        eventZ.setKey(KeyboardEvent.KEY_Z);
        eventZ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventZ);

        KeyboardEvent eventX = new KeyboardEvent();
        eventX.setKey(KeyboardEvent.KEY_X);
        eventX.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventX);
    }

    @Override
    public void keyPressed(KeyboardEvent key) {
        Direction dir;

        switch (key.getKey()){
            case KeyboardEvent.KEY_Q:
                dir = Direction.UPLEFT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_W:
                dir = Direction.UP;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_E:
                dir = Direction.UPRIGHT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_A:
                dir = Direction.LEFT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_S:
                dir = Direction.DOWN;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_D:
                dir = Direction.RIGHT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_Z:
                dir = Direction.DOWNLEFT;
                setDir(dir);
                break;
            case KeyboardEvent.KEY_X:
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

            Direction dir1 = this.getDir();
            Representation rep1 = this.getRepresentation();
            rep1.move(dir1);

            if (collision != null) {
                collision.checkCollision(this);
            }
        }
    }
}
