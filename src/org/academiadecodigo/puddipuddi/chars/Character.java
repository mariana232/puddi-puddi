package org.academiadecodigo.puddipuddi.chars;

import org.academiadecodigo.puddipuddi.CollisionDetector;
import org.academiadecodigo.puddipuddi.field.Direction;

public class Character {

    public static final int CHANGE_DIRECTION_PROBABILITY = 5;

    private boolean crashed = false;
    private Representation representation;
    private int velocity;
    private Direction dir = Direction.getRandomDir();
    CollisionDetector collision;

    public Character(String filename, int velocity) {
        representation = new Representation(filename);
        this.velocity = velocity;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public void setCollision(CollisionDetector collision) {
        this.collision = collision;
    }

    public int velocity() {
        return velocity;
    }


    public void move() throws InterruptedException {

        if ((int) (Math.random() * 101) < CHANGE_DIRECTION_PROBABILITY) {
            dir = dir.getRandomDir();
        }

        for (int i = 1; i < velocity() + 1; i++) {

            representation.move(dir);

            if (collision != null) {
                collision.checkCollision(this);
            }
        }
    }

    public boolean compare(Character character) {
        return representation.equals(character.getRepresentation());
    }

    public void changeRepPic(String picPath) {
        representation.changePic(picPath);
    }

    @Override
    public String toString() {
        return "Character{" +
                "crashed=" + crashed +
                ", representation=" + representation +
                ", dir=" + dir +
                '}';
    }
}
