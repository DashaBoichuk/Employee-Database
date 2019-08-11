package com.dasha.boichuk.model;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;
    private String position;
    private String department;
    private int roomNumber;
    private String OfficePhone;
    private String businessEmail;
    private int monthlySalary;
    private String dateOfHiring;
    private String fieldForNotes;

    public Employee () {}

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(int id, String firstName, String lastName, String patronymic, String dateOfBirth, String position, String department, int roomNumber, String officePhone, String businessEmail, int monthlySalary, String dateOfHiring, String fieldForNotes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.department = department;
        this.roomNumber = roomNumber;
        OfficePhone = officePhone;
        this.businessEmail = businessEmail;
        this.monthlySalary = monthlySalary;
        this.dateOfHiring = dateOfHiring;
        this.fieldForNotes = fieldForNotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getOfficePhone() {
        return OfficePhone;
    }

    public void setOfficePhone(String officePhone) {
        OfficePhone = officePhone;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(String dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public String getFieldForNotes() {
        return fieldForNotes;
    }

    public void setFieldForNotes(String fieldForNotes) {
        this.fieldForNotes = fieldForNotes;
    }
}
