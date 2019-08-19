package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.handler.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {

    private ObservableList<Employee> usersData = FXCollections.observableArrayList();

    public ObservableList<Employee> getUsersData() {
        return usersData;
    }

    public void setUsersData(ObservableList<Employee> usersData) {
        this.usersData = usersData;
    }

    @FXML
    private TableView<Employee> tableEmployees;

    public TableView<Employee> getTableEmployees() {
        return tableEmployees;
    }

    public void setTableEmployees(TableView<Employee> tableEmployees) {
        this.tableEmployees = tableEmployees;
    }



    public void setItemstoTable (ObservableList<Employee> usersData) {
        tableEmployees.setItems(usersData);
    }



    @FXML
    private void initialize() {

        //get data from db
        DatabaseHandler databaseHandler = new DatabaseHandler();
        usersData = databaseHandler.getData();

        //set filter choice boxes
        ObservableList<String> positionsList = databaseHandler.getPositions();
        positionFilter.setItems(positionsList);
        String allPositions = "Всі посади";
        positionFilter.getItems().add(allPositions);
        positionFilter.setValue(allPositions);

        ObservableList<String> departmentList = databaseHandler.getDepartments();
        departmentFilter.setItems(departmentList);
        String allDepartments = "Всі підрозділи";
        departmentFilter.getItems().add(allDepartments);
        departmentFilter.setValue(allDepartments);

        //set data to table
        setDatatoTable();
        setItemstoTable (usersData);

        //listener for filters
        positionFilter.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observableValue, String oldString, String newString) -> {
            if (departmentFilter.getValue().equals(allDepartments)) {
                if (newString.equals(allPositions))
                    usersData = databaseHandler.getData();
                else
                    usersData = databaseHandler.getEmployeesFromSelectedPosition(newString);

            } else {
                if (newString.equals(allPositions))  usersData = databaseHandler.getEmployeesFromSelectedDepartment(departmentFilter.getValue());
                else
                usersData = databaseHandler.getEmployeesFromSelectedDepartmentAndPosition(departmentFilter.getValue(), newString);
            }
            tableEmployees.setItems(usersData);

        });

        departmentFilter.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observableValue, String oldString, String newString) -> {
            if (positionFilter.getValue().equals(allPositions)) {
                if (newString.equals(allDepartments))
                    usersData = databaseHandler.getData();
                else
                    usersData = databaseHandler.getEmployeesFromSelectedDepartment(newString);
            } else {
                if (newString.equals(allDepartments)) usersData = databaseHandler.getEmployeesFromSelectedPosition(positionFilter.getValue());
                else
                usersData = databaseHandler.getEmployeesFromSelectedDepartmentAndPosition(newString, positionFilter.getValue());
            }
            tableEmployees.setItems(usersData);
        });

        //add button
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                String fxmlFile = "/fxml/addEmp.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                Stage primaryStage = new Stage();
                try {
                    root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                AddEmpController addEmpController = loader.getController();
                addEmpController.setEmployeeSelectCallback(employee -> {
                    usersData = databaseHandler.addEmployeeToDB(employee);
                    tableEmployees.setItems(usersData);
                    departmentFilter.setValue(allDepartments);
                    positionFilter.setValue(allPositions);
                });

                Scene scene = new Scene(root);
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.initOwner(root.getScene().getWindow());
                primaryStage.setScene(scene);
                primaryStage.resizableProperty().setValue(false);
                primaryStage.setTitle("Додавання нового працівника");
                primaryStage.showAndWait();
            }
        });

        //edit button
        editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tableEmployees.getSelectionModel().getSelectedItem() != null) {

                    String fxmlFile = "/fxml/editEmp.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    Stage primaryStage = new Stage();
                    try {
                        root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    EditEmpController editEmpController = loader.getController();
                    editEmpController.setData(tableEmployees.getSelectionModel().getSelectedItem());


                    editEmpController.setEmployeeSelectCallback(employee -> {
                        usersData = databaseHandler.updateEmployee(employee, tableEmployees.getSelectionModel().getSelectedItem().getId());
                        tableEmployees.setItems(usersData);
                        departmentFilter.setValue(allDepartments);
                        positionFilter.setValue(allPositions);
                    });


                    Scene scene = new Scene(root);
                    primaryStage.initModality(Modality.APPLICATION_MODAL);
                    primaryStage.initOwner(root.getScene().getWindow());
                    primaryStage.setScene(scene);
                    primaryStage.resizableProperty().setValue(false);
                    primaryStage.setTitle("Редагування даних");
                    primaryStage.showAndWait();
                }
            }
        });

        //delete button
        deleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (tableEmployees.getSelectionModel().getSelectedItem() != null) {
                    usersData = databaseHandler.deleteEmployee(tableEmployees.getSelectionModel().getSelectedItem().getId());
                    tableEmployees.setItems(usersData);
                }
            }
        });
    }

    private void setDatatoTable () {
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("Patronymic"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("DateOfBirth"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("RoomNumber"));
        officePhoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("OfficePhone"));
        businessEmailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("BusinessEmail"));
        monthlySalaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("MonthlySalary"));
        dateOfHiringColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("DateOfHiring"));
        fieldForNotesColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("FieldForNotes"));
    }

    @FXML
    private ChoiceBox<String> departmentFilter;

    @FXML
    private ChoiceBox<String> positionFilter;

    @FXML
    private Button deleteButton;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

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
    private TableColumn<Employee, String> positionColumn;

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


}
