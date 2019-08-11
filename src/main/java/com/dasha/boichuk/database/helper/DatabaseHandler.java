package com.dasha.boichuk.database.helper;

import java.sql.*;

public class DatabaseHandler extends Config{
    private Connection connection;


    public Connection DbConnection() {

        String connectionUrl = "jdbc:sqlserver://" + dbHost + ":" + dbPort+ "; databaseName=" + dbName + "; integratedSecurity=true";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    /*    finally {
            if (connection != null) try {
                connection.close();
            } catch(Exception e) {}
        }*/

        return connection;

    }

    public String GetData() {
        String resultString = null;
        try {
            Statement statement = DbConnection().createStatement();
            String SQL = "SELECT TOP 2 * FROM " + Consts.EMPLOYEE_TABLE;

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                resultString = resultSet.getString(Consts.FIRST_NAME) + " " + resultSet.getString(Consts.LAST_NAME);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultString;
    }
}
