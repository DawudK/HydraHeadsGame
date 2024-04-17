package com.example.hydragame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HydraGameController implements Initializable {


    private int counter;
    private int size;
    private Random ran = new Random();


    @FXML
    private Button playBtn;
    @FXML
    private Button resetBtn;
    @FXML
    private Slider sliderNum;
    @FXML
    private Label message;
    @FXML
    private GridPane grid;

    private List<HydraHead> hydraHeads = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sliderNum.setValue(4);
        size = 4;

    }

    @FXML
    public void reset(ActionEvent event) {
            playBtn.setDisable(false);
            sliderNum.setDisable(false);
            sliderNum.setValue(4);
            size = 4;
            grid.getChildren().clear();
            hydraHeads.clear();
            counter = 0;
            message.setText("");
    }

    private boolean isGridOccupied(int gridX, int gridY) {
        for (HydraHead hydraHead : hydraHeads) {
            if (hydraHead.getGridX() == gridX && hydraHead.getGridY() == gridY) {
                return true;
            }
        }
        return false;
    }

    private void placeHydraHead(int gridX, int gridY, int size) {
        HydraHead hydra = HydraHeadsFactory.getHead(size);
        hydra.putIn(gridX, gridY, grid);
        hydra.setFitWidth(40);
        hydra.setFitHeight(40);
        hydra.setOnMouseClicked(this::split);
        hydraHeads.add(hydra);
    }

    @FXML
    public void play(ActionEvent event) {
        int gridX = ran.nextInt(15);
        int gridY = ran.nextInt(15);

        while (isGridOccupied(gridX, gridY)) {
            gridX = ran.nextInt(15);
            gridY = ran.nextInt(15);
        }

            placeHydraHead(gridX, gridY, size);
            sliderNum.setDisable(true);
            playBtn.setDisable(true);
    }

    public void split(MouseEvent event) {
        HydraHead clickedHead = (HydraHead) event.getSource();

        //Removes the clicked heads
        hydraHeads.remove(clickedHead);
        grid.getChildren().remove(clickedHead);
        counter++;


        // placing new heads on the grid
        int newSize = clickedHead.getHeadSize() - 1;
        if (newSize > 0) {
            for (int i = 0; i < ran.nextInt(2, 4); i++) {
                int newGridX = ran.nextInt(15);
                int newGridY = ran.nextInt(15);

                while (isGridOccupied(newGridX, newGridY)) {
                    newGridX = ran.nextInt(15);
                    newGridY = ran.nextInt(15);
                }

                placeHydraHead(newGridX, newGridY, newSize);
            }
        }
        if (hydraHeads.isEmpty()) {
            endGameMessage();
        }
    }

    private void endGameMessage() { message.setText("Good Job! - you have cut "+ counter +" Hydra heads"); }
    @FXML
    public void setHeadSize(MouseEvent event) {
        this.size = (int) sliderNum.getValue();
    }
}
