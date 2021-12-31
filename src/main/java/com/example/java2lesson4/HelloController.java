package com.example.java2lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {


    public TextField text;
    @FXML
    TextArea mainTextArea;

    @FXML
    TextField winOneClickAction;


    public void btnOneClickAction(ActionEvent actionEvent) {

        mainTextArea.appendText(text.getText()+ "\n");

    }

    public void winOneClickAction(ActionEvent actionEvent) {
        mainTextArea.appendText(text.getText() + "\n");
    }

}