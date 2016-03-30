package org.academiadecodigo.puddipuddi;

import org.academiadecodigo.puddipuddi.chars.Character;
import org.academiadecodigo.puddipuddi.chars.PuddiFactory;
import org.academiadecodigo.puddipuddi.chars.SpoonGrey;
import org.academiadecodigo.puddipuddi.chars.SpoonRed;
import org.academiadecodigo.puddipuddi.field.FieldGfx;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    Character[] chars;
    SpoonRed spoonRed;
    SpoonGrey spoonGrey;
    /**
     * Animation delay
     */
    int delay;

    public Game(int fieldWidth, int fieldHeight, int delay) {
        FieldGfx.init(fieldWidth,fieldHeight);
        this.delay = delay;
    }

    /**
     * Creates a bunch of chars and randomly puts them in the field
     */
    public void init() {

        chars = new Character[MANUFACTURED_CARS];
        CollisionDetector collision = new CollisionDetector(chars);

        for (int i = 0; i < chars.length; i++) {
            chars[i] = PuddiFactory.getNewChar();
            chars[i].setCollision(collision);
        }

        spoonRed = new SpoonRed("resources/spoonRed.png", 3);
        spoonGrey = new SpoonGrey("resources/spoonGrey.png", 3);
        spoonRed.setCollision(collision);
        spoonGrey.setCollision(collision);
        Sound.chamarAMusica();
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all chars
            moveAllChars();
            spoonRed.move();
            spoonGrey.move();

        }
    }

    private void moveAllChars() throws InterruptedException {

        for (int i = 0; i < chars.length; i++) {
            if (!chars[i].isCrashed()) {
                chars[i].move();
            }
        }
    }
}
