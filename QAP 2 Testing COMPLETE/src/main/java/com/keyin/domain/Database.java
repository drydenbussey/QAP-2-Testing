package com.keyin.domain;

import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.donor.CovidTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public List<AppointmentSlot> getAppointmentSlots() {
        ArrayList<AppointmentSlot> appointmentSlots = new ArrayList<AppointmentSlot>();

        AppointmentSlot appointmentSlot = new AppointmentSlot();
        appointmentSlot.setId(1);
        appointmentSlot.setLocation("123 Coder Lane Metaverse");
        appointmentSlot.setTestResults("Negative");
        appointmentSlots.add(appointmentSlot);

        return appointmentSlots;
    }

    public CovidTest getDonor(int id) {
        CovidTest covidTest = new CovidTest();

        covidTest.setDateOfBirth(LocalDate.of( 1980 , Month.FEBRUARY , 11 ));

        return covidTest;
    }
}
