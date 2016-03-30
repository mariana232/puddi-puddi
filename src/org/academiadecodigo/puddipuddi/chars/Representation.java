package org.academiadecodigo.puddipuddi.chars;

import org.academiadecodigo.puddipuddi.field.Direction;
import org.academiadecodigo.puddipuddi.field.FieldGfx;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Representation {

    Picture pic;

    public Representation(String filename) {

        pic = new Picture(0, 0, filename);

        int x = FieldGfx.OFFSET + (int) (Math.random() * (FieldGfx.getWidth() - pic.getWidth()));
        int y = FieldGfx.OFFSET + (int) (Math.random() * (FieldGfx.getHeight() - pic.getHeight()));

        pic.translate(x, y);
        pic.draw();
    }

    public Picture getPic() {
        return pic;
    }

    public int getX() {
        return pic.getX();
    }

    public int getY() {
        return pic.getY();
    }

    public boolean isOutsideBorder(int x, int y) {
        return x <= (FieldGfx.OFFSET) || y <= (FieldGfx.OFFSET) || x >= (FieldGfx.getWidth() + FieldGfx.OFFSET - pic.getWidth()) || y >= (FieldGfx.getHeight() + FieldGfx.OFFSET - pic.getHeight());
    }

    public boolean isOutsideBorder(Direction direction) {

        int newX = pic.getX() + direction.getDirX();
        int newY = pic.getY() + direction.getDirY();

        return isOutsideBorder(newX, newY);

    }

    public void move(Direction direction) {

        Direction newDirection = direction;
        if (isOutsideBorder(direction)) {

            newDirection = direction.getOppositeDir();

            while (isOutsideBorder(newDirection)) {

                move(Direction.getRandomDir());

            }

        }

        pic.translate(newDirection.getDirX(), newDirection.getDirY());

    }

    public boolean equals(Representation rep) {

        if (pic.getX() < rep.getPic().getX()) {
            if (pic.getY() < rep.getPic().getY()) {
                return Math.abs(pic.getX() - rep.getX()) <= pic.getWidth() && Math.abs(pic.getY() - rep.getY()) <= pic.getHeight();
            } else {
                return Math.abs(pic.getX() - rep.getX()) <= pic.getWidth() && Math.abs(pic.getY() - rep.getY()) <= rep.getPic().getHeight();
            }
        } else {
            if (pic.getY() < rep.getPic().getY()) {
                return Math.abs(pic.getX() - rep.getX()) <= rep.getPic().getWidth() && Math.abs(pic.getY() - rep.getY()) <= pic.getHeight();
            } else {
                return Math.abs(pic.getX() - rep.getX()) <= rep.getPic().getWidth() && Math.abs(pic.getY() - rep.getY()) <= rep.getPic().getHeight();
            }
        }
    }

    public void changePic(String filename) {
        pic.load(filename);
        pic.draw();
    }

    @Override
    public String toString() {
        return "Representation{" +
                "pic={" +
                ", X=" + pic.getX() +
                ", Y=" + pic.getY() +
                ", W=" + pic.getWidth() +
                ", H=" + pic.getHeight() +
                '}';
    }
}
