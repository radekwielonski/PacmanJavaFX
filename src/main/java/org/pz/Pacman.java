package org.pz;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Timer;
import java.util.TimerTask;

public class Pacman extends Character {
    protected int lives = 3;
    boolean hollow = false;
    private Input input;
    private double speed;
    private int score = 0;
    private Label scoreLabel, livesLabel;

    public Pacman(Pane layer, double x, double y, double speed, Input input, int color) {

        super(layer, x, y);

        this.color = color;
        this.speed = speed;
        this.input = input;
        this.type = "PacMan";
        this.movement = "RIGHT";
        initLabels();
    }

    private void initLabels() {
        this.scoreLabel = new Label();
        this.livesLabel = new Label();
        if (color == 2) {
            this.scoreLabel = DrawObjects.setLabel(scoreLabel, 300, 20);
            this.livesLabel = DrawObjects.setLabel(livesLabel, 340, 550);
        } else {
            this.scoreLabel = DrawObjects.setLabel(scoreLabel, 60, 20);
            this.livesLabel = DrawObjects.setLabel(livesLabel, 40, 550);
        }
        layer.getChildren().add(scoreLabel);
        layer.getChildren().add(livesLabel);
    }

    private void drawScore() {
        scoreLabel.setText("P" + color + " score: " + score);
        livesLabel.setText("P" + color + " lives: " + lives);
    }


    private void processInput() {

        if (input.isMoveUp()) {
            movement = "UP";
            dx = 0;
            dy = -speed;

        } else if (input.isMoveDown()) {
            movement = "DOWN";
            dy = speed;
            dx = 0;
        }

        if (input.isMoveLeft()) {
            movement = "LEFT";
            dx = -speed;
            dy = 0;

        } else if (input.isMoveRight()) {
            movement = "RIGHT";
            dx = speed;
            dy = 0;
        } else if (input.isFightKey()) {
            hit = true;
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            hit = false;
                        }
                    }, 70);
        }
    }

    public void run(Obstacles obstacles) {
        processInput();
        move();
        checkCollision(obstacles);
        updateUI();
        drawScore();
    }

    private void checkCollision(Obstacles obstacles) {

        //Chceck collision with walls
        for (Rectangle block : obstacles.walls) {
            if (collidesWith(block)) {
                freeze();
            }
        }

        //Chceck collision with food
        for (Circle food : obstacles.food) {
            if (collidesWith(food)) {
                layer.getChildren().remove(food);
                obstacles.food.remove(food);
                score += 100;
                sounds.playClip(2);
                break;
            }
        }

        //Chceck collision with bigFood
        for (Circle bigFood : obstacles.bigFood) {
            if (collidesWith(bigFood)) {
                layer.getChildren().remove(bigFood);
                obstacles.bigFood.remove(bigFood);
                score += 500;
                speed = 2;
                hollow = true;
                new Timer().schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                speed = 1;
                                hollow = false;
                            }
                        }, 5000);
                sounds.playClip(3);
                break;
            }
        }

        //Chceck collision with ghosts
        for (Ghost ghost : obstacles.ghosts) {
            if (collidesWith(ghost)) {
                if (hollow) {
                    ghost.respawn();
                    sounds.playClip(4);
                    score += 500;
                } else {
                    for (Ghost ghost2 : obstacles.ghosts) {
                        ghost2.respawn();
                    }
                    sounds.playClip(5);
                    respawn();
                    lives--;
                }
            }
        }

        //Chceck collision with other Pacmans
        for (Pacman pacman : obstacles.pacmans) {
            if (collidesWith(pacman)) {
                if (!pacman.equals(this)) {
                    sounds.playClip(6);
                    fight(pacman);
                    freeze();
                }
            } else {
                new Timer().schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                fight = false;
                            }
                        }, 200);
            }
        }
    }

    //Change mode to fight with other pacman
    public void fight(Pacman pacman) {
        this.fight = true;
        if (hit) {
            if (this.hollow) {
                pacman.score -= 30;
                this.score += 30;
            } else {
                pacman.score -= 10;
                this.score += 10;
            }
        }
    }

    @Override
    public void respawn() {
        super.respawn();
        freeze(100);
        dx = 0;
        dy = 0;
    }

    @Override
    public String toString() {
        return "P" + color + " Score: " + score + " speed: " + speed;
    }
}
