package com.dasha.boichuk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.*;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);


     /*   Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String connectionUrl = "jdbc:sqlserver://localhost:49672; databaseName=JCProject; integratedSecurity=true";
        String resultString = null;*/


/*
        try {

            connection = DriverManager.getConnection(connectionUrl);
            statement = connection.createStatement();
            String SQL = "SELECT TOP 2 * FROM Employee";

            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                resultString = resultSet.getString("FirstName") + " " + resultSet.getString("SecondName");

                   }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) try { connection.close();
            } catch(Exception e) {}
        }*/

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("Java Core Project");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
