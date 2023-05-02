module com.example.buttoncollision {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttoncollision to javafx.fxml;
    exports com.example.buttoncollision;
}