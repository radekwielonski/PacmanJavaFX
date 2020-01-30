package org.pz;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Ghost extends Character {
    private int dir = 0;

    public Ghost(Pane layer, double x, double y, int color) {
        super(layer, x, y);
        this.type = "Ghost";
        this.color = color;
        this.movement = "UP";
        freeze(2000);
    }

    protected void move() {
        switch (dir) {
            case 0:
                dy = -1;
                dx = 0;
                movement = "UP";
                break;
            case 1:
                dy = 1;
                dx = 0;
                movement = "DOWN";
                break;
            case 2:
                dx = 1;
                dy = 0;
                movement = "RIGHT";
                break;
            case 3:
                dx = -1;
                dy = 0;
                movement = "LEFT";
                break;
        }
        super.move();
    }

    @Override
    public void respawn() {
        super.respawn();
        freeze(1000);

    }

    protected void run(Obstacles obstacles) {
        move();
        checkCollision(obstacles);
        updateUI();
    }

    private void checkCollision(Obstacles obstacles) {
        for (Rectangle block : obstacles.walls) {
            if (collidesWith(block)) {
                freeze();
                dir = (int) (Math.random() * 4);
            }
        }
    }
}
