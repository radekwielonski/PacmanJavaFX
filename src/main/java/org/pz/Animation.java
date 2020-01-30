package org.pz;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Animation extends Transition {

    Duration duration = Duration.millis(10000);
    int counter = 0;
    ImageView imageView;
    Character character;
    int interval = 1;

    public Animation(ImageView imageView, Character character) {

        this.imageView = imageView;
        this.character = character;

        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double arg0) {

        if (character.fight) {
            if (character.hit) {
                interval = 1;
            } else {
                interval = 2;
            }
            imageView.setImage(new Image("Images/" + character.type + character.color + "/fight/" + character.movement + interval + ".png"));

        } else {
            if (counter < 50) {
                interval = 1;
            } else if (100 > counter) {
                interval = 2;
            } else {
                counter = 0;
            }
            imageView.setImage(new Image("Images/" + character.type + character.color + "/" + character.movement + interval + ".png")); // np"Images/PacMan1/RIGHT1.png"

            counter++;
        }

    }
}
