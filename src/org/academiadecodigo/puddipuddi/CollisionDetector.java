package org.academiadecodigo.puddipuddi;

import org.academiadecodigo.puddipuddi.chars.Character;
import org.academiadecodigo.puddipuddi.chars.Spoon;
import org.academiadecodigo.puddipuddi.chars.SpoonGrey;
import org.academiadecodigo.puddipuddi.chars.SpoonRed;
import org.academiadecodigo.puddipuddi.field.Direction;
import org.academiadecodigo.puddipuddi.field.FieldGfx;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by Mariana on 04/02/16.
 */
public class CollisionDetector {

    Character[] chars;
    private Text textEnd;

    private static final int DELAY_END = 1500;
    private int counterRed;
    private int counterGrey;
    String txt;
    //String txtEnd;

    public CollisionDetector(Character[] chars) {
        this.chars = chars;
    }

    public void checkCollision(Character character) throws InterruptedException {

        for (int j = 0; j < chars.length; j++) {

            if (!chars[j].compare(character) || chars[j].isCrashed()) {
                continue;
            }

            if (character instanceof Spoon) {
                chars[j].setCrashed(true);
                chars[j].changeRepPic("resources/GigaPuddi_sad.png");
                if (character instanceof SpoonRed) {
                    counterRed++;
                    txt = "Red spoon: " + counterRed;
                    FieldGfx.getTextLeft().setText(txt);
                } else if (character instanceof SpoonGrey) {
                    counterGrey++;
                    txt = "Grey spoon: " + counterGrey;
                    FieldGfx.getTextRight().setText(txt);
                }
                checkAllcollisions();
            }

/*            if (character instanceof Character) {
                if (character.equals(chars[j])) {
                    continue;
                }
                character.setDir(character.getDir().getOppositeDir());
                chars[j].setDir(chars[j].getDir().getOppositeDir());
            }*/
        }
    }

    public void checkAllcollisions() throws InterruptedException {
        textEnd = new Text(FieldGfx.OFFSET + FieldGfx.getWidth() * 0.5, FieldGfx.OFFSET + FieldGfx.getHeight() * 0.5, "");
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].isCrashed()) {
                counter++;
                if (counter >= chars.length) {
                    if (counterGrey > counterRed) {
                        textEnd.setText("Grey spoon wins!");
                        textEnd.setColor(Color.GRAY);
                        textEnd.grow(400, 100);
                        textEnd.draw();
                    } else if (counterGrey < counterRed) {
                        textEnd.setText("Red spoon wins!");
                        textEnd.setColor(Color.RED);
                        textEnd.grow(400, 100);
                        textEnd.draw();
                    } else {
                        textEnd.setText("It's a tie!");
                        textEnd.setColor(Color.BLACK);
                        textEnd.grow(250, 100);
                        textEnd.draw();
                    }
/*                    textEnd.grow(250, 100);
                    textEnd.draw();*/
                    Thread.sleep(DELAY_END);
                    System.exit(counter);
                }
            }
        }
    }
}
