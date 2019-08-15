package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.helper.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
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





    @FXML
    private void initialize() {
        final DatabaseHandler databaseHandler = new DatabaseHandler();
        usersData = databaseHandler.getData();
     //   initData();
        setDatatoTable();

        tableEmployees.setItems(usersData);

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {



                String fxmlFile = "/fxml/addEmp.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    Stage primaryStage = new Stage();
                    root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                    primaryStage.setTitle("Java Core Project");
                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


              /*  Employee employee = new Employee();
                employee.setFirstName(nameTF.getText());
                employee.setLastName(surnameTF.getText());
                employee.setPatronymic(patronymicTF.getText());
                employee.setDateOfBirth(dateOfBirthTF.getText());
                employee.setPosition(positionTF.getText());
                employee.setDepartment(departmentTF.getText());
                employee.setRoomNumber(Integer.parseInt(roomNumberTF.getText()));
                employee.setOfficePhone(officePhoneTF.getText());
                employee.setBusinessEmail(businessEmailTF.getText());
                employee.setMonthlySalary(Integer.parseInt(monthlySalaryTF.getText()));
                employee.setDateOfHiring(dateOfHiringTF.getText());
                employee.setFieldForNotes(fieldForNotesTF.getText());

                usersData = databaseHandler.addEmployeeToDB(employee);
                tableEmployees.setItems(usersData);
*/

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
