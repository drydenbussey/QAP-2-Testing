package com.keyin.domain.appointment;

public class AppointmentSlot {
    private int idl;
    private String location;

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    private String testResults;

    public int getIdl() {
        return idl;
    }

    public void setId(int idl) {
        this.idl = idl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
