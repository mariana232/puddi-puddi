package org.academiadecodigo.puddipuddi.chars;

import org.academiadecodigo.puddipuddi.field.Direction;

public class PuddiFactory {

    private static final String IMAGE1 = "resources/GigaPuddi.png";
    private static final String IMAGE2 = "resources/GigaPuddi.png";
    private static final int velocity1 = 1;
    private static final int velocity2 = 2;


    public static Character getNewChar() {

        int max = PuddiType.values().length;
        int carNumber = (int) (Math.random() * max);

        Character character = null;
        PuddiType carChoice = PuddiType.values()[carNumber];

        switch (carChoice) {
            case PUDDI1:
                character = new Character(IMAGE1, velocity1);
                break;
            case PUDDI2:
                character = new Character(IMAGE2, velocity2);
                break;
        }
        return character;
    }
}
