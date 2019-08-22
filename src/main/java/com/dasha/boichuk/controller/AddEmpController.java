package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.handler.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class AddEmpController {

    private Consumer<Employee> employeeSelectCallback ;

    public void setEmployeeSelectCallback(Consumer<Employee> callback) {
        this.employeeSelectCallback = callback ;
    }

    @FXML
    private void initialize() {

        Pattern p = Pattern.compile("\\d+");
        roomNumberTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((p.matcher(oldValue).matches()) || (oldValue.equals("")))
                if (!p.matcher(newValue).matches())
                    roomNumberTF.setText(oldValue);

        });

        monthlySalaryTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((p.matcher(oldValue).matches()) || (oldValue.equals("")))
                if (!p.matcher(newValue).matches())
                    monthlySalaryTF.setText(oldValue);
        });



        DatabaseHandler databaseHandler = new DatabaseHandler();

        ObservableList<String> positionsList = databaseHandler.getPositions();
        positionChoiseBox.setItems(positionsList);

        ObservableList<String> departmentList = databaseHandler.getDepartments();
        departmentChoiseBox.setItems(departmentList);



        addEmpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                Employee employee = new Employee();
                employee.setFirstName(nameTF.getText());
                employee.setLastName(surnameTF.getText());
                employee.setPatronymic(patronymicTF.getText());
                employee.setDateOfBirth(dateOfBirthTF.getText());
                employee.setPosition(positionChoiseBox.getValue());
                employee.setDepartment(departmentChoiseBox.getValue());
                if (!roomNumberTF.getText().equals(""))
                    employee.setRoomNumber(Integer.parseInt(roomNumberTF.getText()));
                employee.setOfficePhone(officePhoneTF.getText());
                employee.setBusinessEmail(businessEmailTF.getText());
                if (!monthlySalaryTF.getText().equals(""))
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
    private ChoiceBox<String> departmentChoiseBox;

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
