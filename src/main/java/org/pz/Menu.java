package org.pz;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Menu {

    static boolean answer;
    static boolean multiplayer;

    public static boolean display(String title) {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(468);
        window.setMinHeight(650);


        RadioButton single = new RadioButton("Singleplayer mode");
        RadioButton multi = new RadioButton("Multiplayer mode");
        single.setTextFill(Color.WHITE);
        multi.setTextFill(Color.WHITE);
        single.setSelected(true);
        multiplayer = false;

        ToggleGroup toggleGroup = new ToggleGroup();
        single.setToggleGroup(toggleGroup);
        multi.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (toggleGroup.getSelectedToggle() != null) {
                    if (toggleGroup.getSelectedToggle() == multi) {
                        multiplayer = true;
                    } else if (toggleGroup.getSelectedToggle() == single) {
                        multiplayer = false;
                    }
                }
            }
        });


        Button playButton = new Button("Graj");
        Button closeButton = new Button("Zakoncz");

        window.setOnCloseRequest(e -> {
            window.close();
            answer = true;
        });

        playButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        closeButton.setOnAction(e -> {
            answer = true;
            window.close();
        });


        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-image: url('Images/menu_background.png')");
        layout.getChildren().addAll(playButton, closeButton, single, multi);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
