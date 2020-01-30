package org.pz;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class DrawObjects {
    protected ArrayList<Rectangle> walls;
    protected ArrayList<Circle> food, bigFood;
    private Color wallsFill = Color.BLACK;
    private Color wallsStroke = Color.BLUE;
    private Color foodColor = Color.YELLOW;
    private Color bigFoodColor = Color.YELLOW;

    public static Label setLabel(Label label, int x, int y) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setScaleX(2);
        label.setScaleY(2);
        label.setTextFill(Color.WHITE);

        return label;
    }

    public ArrayList<Rectangle> drawWalls() {
        walls = new ArrayList<>();

        walls.add(new Rectangle(40, 88, 48, 32)); //1
        walls.add(new Rectangle(120, 88, 64, 32)); //2
        walls.add(new Rectangle(264, 88, 64, 32)); //3
        walls.add(new Rectangle(360, 88, 48, 32)); //4
        walls.add(new Rectangle(40, 152, 48, 16)); //5
        walls.add(new Rectangle(360, 152, 48, 16)); //6
        walls.add(new Rectangle(120, 152, 16, 112)); //7
        walls.add(new Rectangle(168, 152, 112, 16)); //8
        walls.add(new Rectangle(312, 152, 16, 112)); //9
        walls.add(new Rectangle(264, 200, 50, 16)); //10
        walls.add(new Rectangle(134, 200, 50, 16)); //11
        walls.add(new Rectangle(216, 166, 16, 50)); //12

        //walls.add(new Rectangle(168, 248, 40, 8)); //13
        //walls.add(new Rectangle(240, 248, 40, 8)); //14
        walls.add(new Rectangle(168, 256, 8, 48)); //15
        walls.add(new Rectangle(272, 256, 8, 48)); //16
        walls.add(new Rectangle(168, 304, 112, 8)); //17

        walls.add(new Rectangle(120, 296, 16, 64)); //18
        walls.add(new Rectangle(312, 296, 16, 64)); //19
        walls.add(new Rectangle(168, 344, 112, 16)); //20
        walls.add(new Rectangle(216, 360, 16, 48)); //21
        walls.add(new Rectangle(120, 392, 64, 16)); //22
        walls.add(new Rectangle(264, 392, 64, 16)); //23
        walls.add(new Rectangle(40, 392, 48, 16)); //24
        walls.add(new Rectangle(72, 408, 16, 48)); //25
        walls.add(new Rectangle(360, 392, 48, 16)); //26
        walls.add(new Rectangle(360, 408, 16, 48)); //27
        walls.add(new Rectangle(168, 440, 112, 16)); //28
        walls.add(new Rectangle(216, 456, 16, 48)); //29
        walls.add(new Rectangle(120, 440, 16, 48)); //30
        walls.add(new Rectangle(40, 488, 144, 16)); //31
        walls.add(new Rectangle(312, 440, 16, 48)); //32
        walls.add(new Rectangle(264, 488, 144, 16)); //33

        walls.add(new Rectangle(0, 48, 448, 8)); //34
        walls.add(new Rectangle(216, 56, 16, 64)); //35
        walls.add(new Rectangle(0, 56, 8, 144)); //36
        walls.add(new Rectangle(440, 56, 8, 144)); //37

        walls.add(new Rectangle(0, 200, 88, 64)); //38
        walls.add(new Rectangle(360, 200, 88, 64)); //39
        walls.add(new Rectangle(0, 296, 88, 64)); //40
        walls.add(new Rectangle(360, 296, 88, 64)); //41

        walls.add(new Rectangle(0, 360, 8, 176)); //42
        walls.add(new Rectangle(8, 440, 32, 16)); //43
        walls.add(new Rectangle(408, 440, 32, 16)); //44
        walls.add(new Rectangle(440, 360, 8, 176)); //45
        walls.add(new Rectangle(0, 536, 448, 8)); //46
        for (Rectangle block : walls) {
            block.setStrokeWidth(2);
            block.setFill(wallsFill);
            block.setStroke(wallsStroke);

        }

        return walls;
    }

    public ArrayList<Circle> drawFood() {
        food = new ArrayList<>();
        Color foodColor = this.foodColor;

        food.add(new Circle(20, 95, 4, foodColor));
        food.add(new Circle(20, 115, 4, foodColor));
        food.add(new Circle(20, 135, 4, foodColor));
        food.add(new Circle(20, 155, 4, foodColor));
        food.add(new Circle(20, 180, 4, foodColor));
        food.add(new Circle(20, 375, 4, foodColor));
        food.add(new Circle(20, 395, 4, foodColor));
        food.add(new Circle(20, 415, 4, foodColor));
        food.add(new Circle(20, 470, 4, foodColor));
        food.add(new Circle(20, 490, 4, foodColor));
        food.add(new Circle(20, 507, 4, foodColor));

        food.add(new Circle(40, 75, 4, foodColor));
        food.add(new Circle(60, 75, 4, foodColor));
        food.add(new Circle(80, 75, 4, foodColor));
        food.add(new Circle(100, 75, 4, foodColor));
        food.add(new Circle(120, 75, 4, foodColor));
        food.add(new Circle(140, 75, 4, foodColor));
        food.add(new Circle(160, 75, 4, foodColor));
        food.add(new Circle(180, 75, 4, foodColor));
        food.add(new Circle(200, 75, 4, foodColor));
        food.add(new Circle(200, 95, 4, foodColor));
        food.add(new Circle(200, 115, 4, foodColor));
        food.add(new Circle(250, 95, 4, foodColor));
        food.add(new Circle(250, 115, 4, foodColor));
        food.add(new Circle(250, 75, 4, foodColor));
        food.add(new Circle(270, 75, 4, foodColor));
        food.add(new Circle(290, 75, 4, foodColor));
        food.add(new Circle(310, 75, 4, foodColor));
        food.add(new Circle(330, 75, 4, foodColor));
        food.add(new Circle(350, 75, 4, foodColor));
        food.add(new Circle(370, 75, 4, foodColor));
        food.add(new Circle(390, 75, 4, foodColor));
        food.add(new Circle(410, 75, 4, foodColor));
        food.add(new Circle(40, 75, 4, foodColor));


        food.add(new Circle(425, 95, 4, foodColor));
        food.add(new Circle(425, 95, 4, foodColor));
        food.add(new Circle(425, 115, 4, foodColor));
        food.add(new Circle(425, 135, 4, foodColor));
        food.add(new Circle(425, 155, 4, foodColor));
        food.add(new Circle(425, 175, 4, foodColor));
        food.add(new Circle(425, 375, 4, foodColor));
        food.add(new Circle(425, 395, 4, foodColor));
        food.add(new Circle(425, 470, 4, foodColor));
        food.add(new Circle(425, 490, 4, foodColor));
        food.add(new Circle(425, 507, 4, foodColor));

        food.add(new Circle(40, 135, 4, foodColor));
        food.add(new Circle(60, 135, 4, foodColor));
        food.add(new Circle(80, 135, 4, foodColor));
        food.add(new Circle(100, 135, 4, foodColor));
        food.add(new Circle(120, 135, 4, foodColor));
        food.add(new Circle(140, 135, 4, foodColor));
        food.add(new Circle(160, 135, 4, foodColor));
        food.add(new Circle(180, 135, 4, foodColor));
        food.add(new Circle(200, 135, 4, foodColor));
        food.add(new Circle(220, 135, 4, foodColor));
        food.add(new Circle(240, 135, 4, foodColor));
        food.add(new Circle(260, 135, 4, foodColor));
        food.add(new Circle(280, 135, 4, foodColor));
        food.add(new Circle(300, 135, 4, foodColor));
        food.add(new Circle(320, 135, 4, foodColor));
        food.add(new Circle(340, 135, 4, foodColor));
        food.add(new Circle(360, 135, 4, foodColor));
        food.add(new Circle(380, 135, 4, foodColor));
        food.add(new Circle(400, 135, 4, foodColor));

        food.add(new Circle(40, 180, 4, foodColor));
        food.add(new Circle(60, 180, 4, foodColor));
        food.add(new Circle(80, 180, 4, foodColor));
        food.add(new Circle(100, 180, 4, foodColor));
        food.add(new Circle(100, 160, 4, foodColor));
        food.add(new Circle(155, 185, 4, foodColor));
        food.add(new Circle(175, 185, 4, foodColor));
        food.add(new Circle(195, 185, 4, foodColor));
        food.add(new Circle(155, 160, 4, foodColor));
        food.add(new Circle(295, 160, 4, foodColor));
        food.add(new Circle(255, 185, 4, foodColor));
        food.add(new Circle(275, 185, 4, foodColor));
        food.add(new Circle(295, 185, 4, foodColor));
        food.add(new Circle(340, 160, 4, foodColor));

        food.add(new Circle(100, 95, 4, foodColor));
        food.add(new Circle(100, 115, 4, foodColor));
        food.add(new Circle(100, 200, 4, foodColor));
        food.add(new Circle(100, 220, 4, foodColor));
        food.add(new Circle(100, 240, 4, foodColor));
        food.add(new Circle(100, 260, 4, foodColor));
        food.add(new Circle(100, 280, 4, foodColor));
        food.add(new Circle(100, 300, 4, foodColor));
        food.add(new Circle(100, 320, 4, foodColor));
        food.add(new Circle(100, 340, 4, foodColor));
        food.add(new Circle(100, 360, 4, foodColor));
        food.add(new Circle(100, 380, 4, foodColor));
        food.add(new Circle(100, 400, 4, foodColor));
        food.add(new Circle(100, 420, 4, foodColor));
        food.add(new Circle(100, 440, 4, foodColor));
        food.add(new Circle(100, 460, 4, foodColor));

        food.add(new Circle(80, 470, 4, foodColor));
        food.add(new Circle(60, 470, 4, foodColor));
        food.add(new Circle(40, 470, 4, foodColor));
        food.add(new Circle(150, 450, 4, foodColor));
        food.add(new Circle(150, 470, 4, foodColor));
        food.add(new Circle(170, 470, 4, foodColor));
        food.add(new Circle(190, 470, 4, foodColor));
        food.add(new Circle(300, 450, 4, foodColor));
        food.add(new Circle(300, 470, 4, foodColor));
        food.add(new Circle(280, 470, 4, foodColor));
        food.add(new Circle(260, 470, 4, foodColor));
        food.add(new Circle(250, 490, 4, foodColor));
        food.add(new Circle(200, 490, 4, foodColor));

        food.add(new Circle(40, 525, 4, foodColor));
        food.add(new Circle(60, 525, 4, foodColor));
        food.add(new Circle(80, 525, 4, foodColor));
        food.add(new Circle(100, 525, 4, foodColor));
        food.add(new Circle(120, 525, 4, foodColor));
        food.add(new Circle(140, 525, 4, foodColor));
        food.add(new Circle(160, 525, 4, foodColor));
        food.add(new Circle(180, 525, 4, foodColor));
        food.add(new Circle(200, 525, 4, foodColor));
        food.add(new Circle(220, 525, 4, foodColor));
        food.add(new Circle(240, 525, 4, foodColor));
        food.add(new Circle(260, 525, 4, foodColor));
        food.add(new Circle(280, 525, 4, foodColor));
        food.add(new Circle(300, 525, 4, foodColor));
        food.add(new Circle(320, 525, 4, foodColor));
        food.add(new Circle(340, 525, 4, foodColor));
        food.add(new Circle(360, 525, 4, foodColor));
        food.add(new Circle(380, 525, 4, foodColor));
        food.add(new Circle(400, 525, 4, foodColor));

        food.add(new Circle(120, 425, 4, foodColor));
        food.add(new Circle(140, 425, 4, foodColor));
        food.add(new Circle(160, 425, 4, foodColor));
        food.add(new Circle(180, 425, 4, foodColor));
        food.add(new Circle(200, 425, 4, foodColor));
        food.add(new Circle(240, 425, 4, foodColor));
        food.add(new Circle(260, 425, 4, foodColor));
        food.add(new Circle(280, 425, 4, foodColor));
        food.add(new Circle(300, 425, 4, foodColor));
        food.add(new Circle(320, 425, 4, foodColor));
        food.add(new Circle(340, 425, 4, foodColor));

        food.add(new Circle(390, 425, 4, foodColor));
        food.add(new Circle(410, 425, 4, foodColor));
        food.add(new Circle(425, 415, 4, foodColor));
        food.add(new Circle(390, 445, 4, foodColor));

        food.add(new Circle(340, 95, 4, foodColor));
        food.add(new Circle(340, 115, 4, foodColor));
        food.add(new Circle(340, 185, 4, foodColor));
        food.add(new Circle(340, 205, 4, foodColor));
        food.add(new Circle(340, 225, 4, foodColor));
        food.add(new Circle(340, 245, 4, foodColor));
        food.add(new Circle(340, 265, 4, foodColor));
        food.add(new Circle(340, 285, 4, foodColor));
        food.add(new Circle(340, 305, 4, foodColor));
        food.add(new Circle(340, 325, 4, foodColor));
        food.add(new Circle(340, 345, 4, foodColor));
        food.add(new Circle(340, 365, 4, foodColor));
        food.add(new Circle(340, 385, 4, foodColor));
        food.add(new Circle(340, 405, 4, foodColor));
        food.add(new Circle(340, 425, 4, foodColor));
        food.add(new Circle(340, 445, 4, foodColor));
        food.add(new Circle(340, 465, 4, foodColor));

        food.add(new Circle(360, 470, 4, foodColor));
        food.add(new Circle(380, 470, 4, foodColor));
        food.add(new Circle(400, 470, 4, foodColor));

        food.add(new Circle(40, 375, 4, foodColor));
        food.add(new Circle(60, 375, 4, foodColor));
        food.add(new Circle(80, 375, 4, foodColor));

        food.add(new Circle(40, 425, 4, foodColor));
        food.add(new Circle(60, 425, 4, foodColor));
        food.add(new Circle(60, 445, 4, foodColor));

        food.add(new Circle(405, 375, 4, foodColor));
        food.add(new Circle(385, 375, 4, foodColor));
        food.add(new Circle(365, 375, 4, foodColor));
        food.add(new Circle(310, 375, 4, foodColor));
        food.add(new Circle(290, 375, 4, foodColor));
        food.add(new Circle(270, 375, 4, foodColor));
        food.add(new Circle(250, 375, 4, foodColor));
        food.add(new Circle(250, 395, 4, foodColor));
        food.add(new Circle(200, 375, 4, foodColor));
        food.add(new Circle(200, 395, 4, foodColor));
        food.add(new Circle(180, 375, 4, foodColor));
        food.add(new Circle(160, 375, 4, foodColor));
        food.add(new Circle(140, 375, 4, foodColor));
        food.add(new Circle(120, 375, 4, foodColor));

        food.add(new Circle(405, 185, 4, foodColor));
        food.add(new Circle(385, 185, 4, foodColor));
        food.add(new Circle(365, 185, 4, foodColor));

        return food;
    }

    public ArrayList<Circle> drawBigFood() {
        bigFood = new ArrayList<>();
        Color color = this.bigFoodColor;

        bigFood.add(new Circle(20, 75, 7, color));
        bigFood.add(new Circle(426, 75, 7, color));
        bigFood.add(new Circle(20, 525, 7, color));
        bigFood.add(new Circle(425, 525, 7, color));

        return bigFood;
    }
}
