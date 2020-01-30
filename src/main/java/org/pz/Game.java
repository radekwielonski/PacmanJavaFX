package org.pz;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game extends Application {

    private Pane playfieldLayer;
    private Stage stage, window;
    private ArrayList<Pacman> players;
    private ArrayList<Ghost> ghosts;
    private Group root;
    private Obstacles obstacles;
    private Scene scene;
    private Label endLabel;
    private boolean multiplayer;
    private boolean gameOver = false;
    private AnimationTimer gameLoop;
    private Sounds sounds = new Sounds();
    private ArrayList<Input> inputsList = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        runMenu();
    }

    private void startGame() {
        createStage();
        drawAllObjects();
        loadGame();
        animateCharacters();
    }

    private void animateCharacters() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (Pacman player : players) {
                    player.run(obstacles);
                }
                for (Ghost ghost : ghosts) {
                    ghost.run(obstacles);
                }
                checkPlayersHealth();
                endGame();
            }
        };
        gameLoop.start();
    }

    private void runMenu() {
        Menu menu = new Menu();
        window = new Stage();
        Menu.display("Menu");

        if (Menu.answer == true) {
            window.close();
            System.exit(0);
        } else {
            multiplayer = Menu.multiplayer;
            startGame();
        }
    }

    private void createStage() {
        playfieldLayer = new Pane();
        playfieldLayer.setStyle("-fx-background-color: black;");
        endLabel = DrawObjects.setLabel(new Label(), 190, 150);
        root = new Group();
        root.getChildren().add(playfieldLayer);
        scene = new Scene(root, 465, 650, Color.BLACK);

        stage = new Stage();
        stage.setScene(scene);
        stage.setWidth(468);
        stage.setHeight(650);
        stage.setOnHidden(e -> {
            closeWindow();
        });
        stage.setOnCloseRequest(e -> {
            closeWindow();
            System.exit(0);
        });
        drawBackToMenu();
        stage.show();
    }

    private void closeWindow() {
        cleanFood();
        removeGhosts();
        removePlayers();
        removeInputs();
        gameLoop.stop();
        stage.close();
    }

    private void loadGame() {
        addPlayers();
        addGhosts();

        obstacles.pacmans = players;
        obstacles.ghosts = ghosts;

        sounds.playClip(1);
    }

    private void drawAllObjects() {
        DrawObjects drawObjects = new DrawObjects();
        obstacles = new Obstacles();

        obstacles.walls = drawObjects.drawWalls();
        obstacles.food = drawObjects.drawFood();
        obstacles.bigFood = drawObjects.drawBigFood();

        playfieldLayer.getChildren().addAll(obstacles.walls);
        playfieldLayer.getChildren().addAll(obstacles.food);
        playfieldLayer.getChildren().addAll(obstacles.bigFood);
    }

    private void drawBackToMenu() {
        Button backToMenu = new Button("Powrót do menu");
        backToMenu.setLayoutX(155);
        backToMenu.setLayoutY(550);
        backToMenu.setOnAction(e -> {
            closeWindow();
            runMenu();
        });
        playfieldLayer.getChildren().addAll(backToMenu);
    }

    private void addPlayers() {
        players = new ArrayList<>();

        Input input = createInput(scene, 1);

        if (multiplayer) {
            Input input2 = createInput(scene, 0);
            players.add(new Pacman(playfieldLayer, 140, 320, 1, input2, 2));

            players.add(new Pacman(playfieldLayer, 285, 320, 1, input, 1));
        } else {
            players.add(new Pacman(playfieldLayer, 210, 412, 1, input, 1));
        }
    }

    private void checkPlayersHealth() {
        if (!players.isEmpty()) {
            removePlayers();
        } else {
            cleanFood();
            removeGhosts();
        }
    }

    private void removePlayers() {
        for (int i = 0; i < players.size(); i++) {
            Pacman player = players.get(i);
            if (player.lives <= 0) {
                deletePlayer(player);
            }
        }
    }

    private Input createInput(Scene scene, int mode) {
        Input input = new Input(scene, mode);
        input.addListeners();

        inputsList.add(input);

        return input;
    }

    private void removeInputs() {
        for (Input input : inputsList) {
            input.removeListeners();
        }
    }

    private void cleanFood() {
        obstacles.food.removeAll(obstacles.food);
        obstacles.bigFood.removeAll(obstacles.bigFood);
    }

    private void deletePlayer(Pacman player) {
        player.removeFromLayer();
        players.remove(player);
    }

    private void endGame() {
        if (obstacles.food.isEmpty() && obstacles.bigFood.isEmpty() && !gameOver) {
            endLabel.setText("Game won");
            root.getChildren().add(endLabel);
            gameOver = true;
            removeGhosts();
        }

        if (players.isEmpty() && !gameOver) {
            endLabel.setText("Game over");
            root.getChildren().add(endLabel);
            gameOver = true;
            removeGhosts();
        }
    }

    private void removeGhosts() {
        for (Ghost ghost : ghosts) {
            ghost.removeFromLayer();
        }
        ghosts.removeAll(ghosts);

    }

    private void addGhosts() {
        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(playfieldLayer, 190, 260, 1));
        ghosts.add(new Ghost(playfieldLayer, 215, 260, 2));
        ghosts.add(new Ghost(playfieldLayer, 240, 260, 3));
        ghosts.add(new Ghost(playfieldLayer, 190, 280, 4));
        ghosts.add(new Ghost(playfieldLayer, 215, 280, 1));
        ghosts.add(new Ghost(playfieldLayer, 240, 280, 2));
    }

}
