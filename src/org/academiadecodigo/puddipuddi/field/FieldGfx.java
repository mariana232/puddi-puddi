package org.academiadecodigo.puddipuddi.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Mariana on 10/02/16.
 */
public class FieldGfx {

    private static int width;
    private static int height;
    private static Text textLeft;
    private static Text textRight;

    public static final int OFFSET = 10;
    //private static Rectangle rectangle;


/*    public FieldGfx() {
        pointsText();
    }*/

    public static Text getTextLeft() {
        return textLeft;
    }

    public static Text getTextRight() {
        return textRight;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static void init(int width, int height) {

        FieldGfx.width = width;
        FieldGfx.height = height;

        Picture pic = new Picture(OFFSET, OFFSET, "resources/background.png");
        pic.draw();

        textLeft = new Text(FieldGfx.OFFSET, FieldGfx.OFFSET * 2 + FieldGfx.getHeight(), "Red spoon: 0");
        textLeft.setColor(Color.BLACK);
        textLeft.draw();
        textRight = new Text(FieldGfx.OFFSET + FieldGfx.getWidth() - 100, FieldGfx.OFFSET * 2 + FieldGfx.getHeight(), "Grey spoon: 0");
        textRight.setColor(Color.BLACK);
        textRight.draw();
    }
    /*
    public void pointsText(){

    }*/

}
