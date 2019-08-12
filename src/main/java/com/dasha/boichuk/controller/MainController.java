package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.helper.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    private Button btn;

    @FXML
    private Label label;

    private ObservableList<Employee> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<Employee> tableEmployees;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> lastNameColumn;

    @FXML
    private TableColumn<Employee, String> firstNameColumn;

    @FXML
    private TableColumn<Employee, String> patronymicColumn;

    @FXML
    private TableColumn<Employee, String> dateOfBirthColumn;

    @FXML
    private TableColumn<Employee, Integer> positionColumn;

    @FXML
    private TableColumn<Employee, String> departmentColumn;

    @FXML
    private TableColumn<Employee, Integer> roomNumberColumn;

    @FXML
    private TableColumn<Employee, String> officePhoneColumn;

    @FXML
    private TableColumn<Employee, String> businessEmailColumn;

    @FXML
    private TableColumn<Employee, Integer> monthlySalaryColumn;

    @FXML
    private TableColumn<Employee, String> dateOfHiringColumn;

    @FXML
    private TableColumn<Employee, String> fieldForNotesColumn;



    @FXML
    private void initialize() {

        initData();

        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("Patronymic"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("DateOfBirth"));
        //position
        //department
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("RoomNumber"));
        officePhoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("OfficePhone"));
        businessEmailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("BusinessEmail"));
        monthlySalaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("MonthlySalary"));
        dateOfHiringColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("DateOfHiring"));
        fieldForNotesColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("FieldForNotes"));
        tableEmployees.setItems(usersData);


    }

    private void initData() {
     /*   usersData.add(new Employee(1, "Dasha", "Boichuk"));
        usersData.add(new Employee(2, "Anzhela", "Ilchuk"));*/
     DatabaseHandler databaseHandler = new DatabaseHandler();
     usersData = databaseHandler.getData();

    }
    @FXML
    private void click(ActionEvent event)  {
        btn.setText("You've clicked!");
//DELETE
       /* DatabaseHandler databaseHandler = new DatabaseHandler();
        String string = databaseHandler.getData();
        btn.setText(string);
*/
    }



}
