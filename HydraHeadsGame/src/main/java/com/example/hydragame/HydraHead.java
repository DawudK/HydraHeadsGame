package com.example.hydragame;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HydraHead extends ImageView {
    private int headSize;
    @FXML
    private int currentGridX, currentGridY;

    public HydraHead(Image image, int size){
        super(image);
        this.headSize = size;

    }
    public int getHeadSize() {
        return headSize;
    }

    public int getGridX(){
        return currentGridX;
    }
    public int getGridY(){
        return currentGridY;
    }


    public void putIn(int gridX, int gridY, GridPane board) {
        currentGridX = gridX;
        currentGridY = gridY;
        board.add(this, gridX, gridY);
    }
}
