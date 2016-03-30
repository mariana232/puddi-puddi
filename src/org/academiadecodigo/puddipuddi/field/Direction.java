package org.academiadecodigo.puddipuddi.field;

/**
 * Created by Mariana on 03/02/16.
 */
public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UPRIGHT(1, -1),
    UPLEFT(-1, -1),
    DOWNRIGHT(1, 1),
    DOWNLEFT(-1, 1);

    private int dirX;
    private int dirY;

    Direction(int dirX, int dirY) {
        this.dirX = dirX;
        this.dirY = dirY;
    }

    public static Direction getRandomDir() {
        int index = (int) (Math.random() * Direction.values().length);
        return Direction.values()[index];
    }

    private static Direction getByCoordinates(int x, int y) {

      for (Direction d : Direction.values()) {
         if (d.getDirX() == x && d.getDirY() == y) {
             return d;
         }
      }

        return null;

    }

    public int getDirX() {
        return dirX;
    }

    public int getDirY() {
        return dirY;
    }

    public Direction getOppositeDir() {

        return getByCoordinates(dirX * -1, dirY * -1);

    }
}
