module com.example.hydragame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hydragame to javafx.fxml;
    exports com.example.hydragame;
}