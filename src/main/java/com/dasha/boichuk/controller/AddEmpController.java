package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.helper.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class AddEmpController {

    TableView<Employee> tableEmployeesPrime;
    public MainController mainController;

    private Consumer<Employee> employeeSelectCallback ;

    public void setEmployeeSelectCallback(Consumer<Employee> callback) {
        this.employeeSelectCallback = callback ;
    }

    @FXML
    private void initialize() throws IOException {


        DatabaseHandler databaseHandler = new DatabaseHandler();
        ObservableList<String> positionsList = databaseHandler.getPositions();
        //positionChoiseBox.show();
        //positionChoiseBox = new ChoiceBox<String>(positionsList);
        positionChoiseBox.setItems(positionsList);



        addEmpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                Employee employee = new Employee();
                employee.setFirstName(nameTF.getText());
                employee.setLastName(surnameTF.getText());
                employee.setPatronymic(patronymicTF.getText());
                employee.setDateOfBirth(dateOfBirthTF.getText());
                employee.setPosition(positionChoiseBox.getValue());
                employee.setDepartment(departmentTF.getText());
                employee.setRoomNumber(Integer.parseInt(roomNumberTF.getText()));
                employee.setOfficePhone(officePhoneTF.getText());
                employee.setBusinessEmail(businessEmailTF.getText());
                employee.setMonthlySalary(Integer.parseInt(monthlySalaryTF.getText()));
                employee.setDateOfHiring(dateOfHiringTF.getText());
                employee.setFieldForNotes(fieldForNotesTF.getText());

                if (employeeSelectCallback != null) {
                    employeeSelectCallback.accept(employee);
                }


                Stage stage = (Stage) addEmpButton.getScene().getWindow();
                stage.close();
            }
        });
    }




    @FXML
    private Button addEmpButton;


    @FXML
    private TextField surnameTF;

    @FXML
    private ChoiceBox<String> positionChoiseBox;

    @FXML
    private TextField departmentTF;

    @FXML
    private TextField patronymicTF;

    @FXML
    private TextField dateOfBirthTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField roomNumberTF;

    @FXML
    private TextField officePhoneTF;

    @FXML
    private TextField businessEmailTF;

    @FXML
    private TextField monthlySalaryTF;

    @FXML
    private TextField dateOfHiringTF;

    @FXML
    private TextField fieldForNotesTF;

}
