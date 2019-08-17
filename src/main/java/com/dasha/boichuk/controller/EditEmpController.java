package com.dasha.boichuk.controller;

import com.dasha.boichuk.database.handler.DatabaseHandler;
import com.dasha.boichuk.model.Employee;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class EditEmpController {

    private Consumer<Employee> employeeSelectCallback ;

    public void setEmployeeSelectCallback(Consumer<Employee> callback) {
        this.employeeSelectCallback = callback ;
    }

    @FXML
    private void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        ObservableList<String> positionsList = databaseHandler.getPositions();
        positionChoiseBox.setItems(positionsList);

        ObservableList<String> departmentList = databaseHandler.getDepartments();
        departmentChoiseBox.setItems(departmentList);






        saveEditsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Employee employee = new Employee();
                employee.setFirstName(nameTF.getText());
                employee.setLastName(surnameTF.getText());
                employee.setPatronymic(patronymicTF.getText());
                employee.setDateOfBirth(dateOfBirthTF.getText());
                employee.setPosition(positionChoiseBox.getValue());
                employee.setDepartment(departmentChoiseBox.getValue());
                employee.setRoomNumber(Integer.parseInt(roomNumberTF.getText()));
                employee.setOfficePhone(officePhoneTF.getText());
                employee.setBusinessEmail(businessEmailTF.getText());
                employee.setMonthlySalary(Integer.parseInt(monthlySalaryTF.getText()));
                employee.setDateOfHiring(dateOfHiringTF.getText());
                employee.setFieldForNotes(fieldForNotesTF.getText());

                if (employeeSelectCallback != null) {
                    employeeSelectCallback.accept(employee);
                }


                Stage stage = (Stage) saveEditsButton.getScene().getWindow();
                stage.close();
            }
        });
    }

    public void setData (Employee employee) {
        nameTF.setText(employee.getFirstName());
        surnameTF.setText(employee.getLastName());
        patronymicTF.setText(employee.getPatronymic());
        dateOfBirthTF.setText(employee.getDateOfBirth());
        roomNumberTF.setText(Integer.toString(employee.getRoomNumber()));
        officePhoneTF.setText(employee.getOfficePhone());
        businessEmailTF.setText(employee.getBusinessEmail());
        monthlySalaryTF.setText(Integer.toString(employee.getMonthlySalary()));
        dateOfHiringTF.setText(employee.getDateOfHiring());
        fieldForNotesTF.setText(employee.getFieldForNotes());

        positionChoiseBox.setValue(employee.getPosition());
        departmentChoiseBox.setValue(employee.getDepartment());
    }


    @FXML
    private Button saveEditsButton;

    @FXML
    private TextField surnameTF;

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

    @FXML
    private ChoiceBox<String> positionChoiseBox;

    @FXML
    private ChoiceBox<String> departmentChoiseBox;

}

