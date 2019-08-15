package com.dasha.boichuk.database.helper;

import com.dasha.boichuk.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHandler extends Config {
    private Connection connection;




    private Connection DbConnection() {

        String connectionUrl = "jdbc:sqlserver://" + dbHost + ":" + dbPort + "; databaseName=" + dbName + "; integratedSecurity=true";

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

    private ObservableList<Employee> data;

    public ObservableList<Employee> getData() {
       // String resultString = null;
        data = FXCollections.observableArrayList();
        try {
            Statement statement = DbConnection().createStatement();
           // String SQL = "SELECT * FROM " + Consts.EMPLOYEE_TABLE;
            String SQL = "SELECT Employee.ID, Employee.FirstName, Employee.LastName, Employee.Patronymic,Employee.DateOfBirth, Position.PositionName, " +
                    "Department.DepartmentName, Employee.RoomNumber, Employee.OfficePhone, Employee.BusinessEmail, Employee.MonthlySalary, Employee.DateOfHiring, " +
                    "Employee.FieldForNotes " +
                    "FROM Employee, Position, Department " +
                    "WHERE Employee.PositionID = Position.ID AND Employee.DepartmentID = Department.ID";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Employee em = new Employee();
             //   resultString = resultSet.getString(Consts.FIRST_NAME) + " " + resultSet.getString(Consts.LAST_NAME);
                em.setId(resultSet.getInt("ID"));
                em.setFirstName(resultSet.getString("FirstName"));
                em.setLastName(resultSet.getString("LastName"));
                em.setPatronymic(resultSet.getString("Patronymic"));
                em.setDateOfBirth(resultSet.getString("DateOfBirth"));
                em.setPosition(resultSet.getString("PositionName"));
                em.setDepartment(resultSet.getString("DepartmentName"));
                em.setRoomNumber(resultSet.getInt("RoomNumber"));
                em.setOfficePhone(resultSet.getString("OfficePhone"));
                em.setBusinessEmail(resultSet.getString("BusinessEmail"));
                em.setMonthlySalary(resultSet.getInt("MonthlySalary"));
                em.setDateOfHiring(resultSet.getString("DateOfHiring"));
                em.setFieldForNotes(resultSet.getString("FieldForNotes"));

                data.add(em);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return data;
    }

    public ObservableList<Employee> addEmployeeToDB(Employee employee) {
        try {
            Statement statement = DbConnection().createStatement();
            String SQL = "insert into Employee " +
                    "values ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', '" + employee.getPatronymic() + "', '"+ employee.getDateOfBirth() + "', 1, 1, " + employee.getRoomNumber() + ", '" + employee.getOfficePhone() + "', '"+ employee.getBusinessEmail() + "', " + employee.getMonthlySalary() + ", '" + employee.getDateOfHiring() + "','" + employee.getFieldForNotes() + "');";
            ResultSet resultSet = statement.executeQuery(SQL);


        } catch (SQLException e) {

        }
        return getData();
    }



    public void deleteEmployee(int id) {
        Statement statement = null;
        try {
            statement = DbConnection().createStatement();
            String SQL = "delete from Employee " +
                    "Employee.ID == " + id;
            ResultSet resultSet = statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
