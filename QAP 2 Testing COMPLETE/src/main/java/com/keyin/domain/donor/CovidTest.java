package com.keyin.domain.donor;

import java.time.LocalDate;

public class CovidTest {


    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String testResults;
    private LocalDate nextAppointmentDate;
    private LocalDate lastDonationDate;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public LocalDate getNextAppointmentDate() {
        return nextAppointmentDate;
    }

    public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
        this.nextAppointmentDate = nextAppointmentDate;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
}
