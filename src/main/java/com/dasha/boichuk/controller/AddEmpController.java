package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.helper.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AddEmpController {



    @FXML
    private void initialize() throws IOException {


        addEmpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                Employee employee = new Employee();
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

          /*      DatabaseHandler databaseHandler = new DatabaseHandler();

                MainController mainController = new MainController();
                mainController.setUsersData(databaseHandler.addEmployeeToDB(employee));
                mainController.getTableEmployees(mainController.getUsersData());*/

             /*   usersData = databaseHandler.addEmployeeToDB(employee);
                tableEmployees.setItems(usersData);*/
            }
        });
    }


    @FXML
    private Button addEmpButton;


    @FXML
    private TextField surnameTF;

    @FXML
    private TextField departmentTF;

    @FXML
    private TextField patronymicTF;

    @FXML
    private TextField positionTF;

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
