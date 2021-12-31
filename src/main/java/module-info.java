module com.example.java2lesson4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java2lesson4 to javafx.fxml;
    exports com.example.java2lesson4;
}