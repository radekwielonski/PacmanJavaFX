package org.pz;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Character {

    public Pane layer;
    public Sounds sounds = new Sounds();
    protected Image image;
    protected ImageView imageView;
    protected double x;
    protected double y;
    protected double startX;
    protected double startY;
    protected double dx = 0;
    protected double dy = 0;
    protected double imageWidth;
    protected double imageHeight;
    protected double characterWidth = 20;
    protected double characterHeight = 20;
    protected int color = 1;
    protected String movement = "UP";
    protected String type = "PacMan";
    boolean fight = false;
    boolean hit = false;
    boolean freeze = false;

    public Character(Pane layer, double startX, double startY) {

        this.layer = layer;
        this.image = new Image("Images/" + type + color + "/" + movement + "" + 1 + ".png");
        this.x = startX;
        this.y = startY;

        this.startX = startX;
        this.startY = startY;

        this.imageView = new ImageView(image);
        this.imageView.relocate(x, y);

        this.imageWidth = image.getWidth();
        this.imageHeight = image.getHeight();

        addToLayer();
        animatePlayer();
    }

    protected void move() {
        if (!freeze) {
            x += dx;
            y += dy;
            changeSpot();
        }
    }

    public void changeSpot() {
        if (x >= 424 && (y >= 260 && y <= 297)) {
            x = 24;
            y = 270;
        } else if (x <= 24 && (y >= 260 && y <= 297)) {
            x = 424;
            y = 272;
        }
    }

    public void respawn() {
        x = startX;
        y = startY;
    }

    public boolean collidesWith(Rectangle block) {
        return (block.intersects(x, y, characterWidth, characterHeight));

    }

    public boolean collidesWith(Circle dot) {
        return (dot.intersects(x, y, characterWidth, characterHeight));

    }

    public void freeze() {
        x -= dx;
        y -= dy;
    }

    public void freeze(int time) {
        freeze = true;
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        freeze = false;
                    }
                },
                time
        );
    }

    public void updateUI() {
        imageView.relocate(x, y);
    }

    public void animatePlayer() {
        Animation animateCharacter = new Animation(imageView, this);
        animateCharacter.setCycleCount(Animation.INDEFINITE);
        animateCharacter.play();
    }

    public boolean collidesWith(Character otherCharacter) {
        return (otherCharacter.x + otherCharacter.imageWidth >= x
                && otherCharacter.y + otherCharacter.imageHeight >= y
                && otherCharacter.x <= x + imageWidth
                && otherCharacter.y <= y + imageHeight
        );
    }

    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    public void removeFromLayer() {
        this.layer.getChildren().remove(this.imageView);
    }


}
