package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.helper.DatabaseHandler;
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

import java.io.IOException;

public class MainController {
    @FXML
    private Button btn;

    @FXML
    private Button addButton;

    @FXML
    private Label label;

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

    public void setItemstoTable (ObservableList<Employee> usersData) {
        tableEmployees.setItems(usersData);
    }



    @FXML
    private void initialize() {
        final DatabaseHandler databaseHandler = new DatabaseHandler();
        usersData = databaseHandler.getData();
     //   initData();
        setDatatoTable();

        setItemstoTable (usersData);


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
                   databaseHandler.addEmployeeToDB(employee);
                   usersData = databaseHandler.getData();
                   tableEmployees.setItems(usersData);
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


    }

    private void setDatatoTable () {
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
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

    private void initData() {
     /*   usersData.add(new Employee(1, "Dasha", "Boichuk"));
        usersData.add(new Employee(2, "Anzhela", "Ilchuk"));*/
     final DatabaseHandler databaseHandler = new DatabaseHandler();
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
