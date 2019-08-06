package com.dasha.boichuk.controller;

import com.dasha.boichuk.MainApp;
import com.dasha.boichuk.database.helper.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.*;

public class MainController {
    @FXML
    private Button btn;

    @FXML
    private Label label;

    @FXML
    private void click(ActionEvent event) throws SQLException, ClassNotFoundException {
        btn.setText("You've clicked!");

        DatabaseHandler databaseHandler = new DatabaseHandler();
        String string = databaseHandler.GetData();
        btn.setText(string);

    }



}
