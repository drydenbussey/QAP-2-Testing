package com.keyin.manager;

import com.keyin.domain.Database;
import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.appointment.CovidTestAppointment;
import com.keyin.domain.donor.CovidTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CovidTestAppointmentManager {
    private Database database;

    public CovidTestAppointmentManager(Database database) {
        this.database = database;
    }

    public CovidTestAppointment bookAppointment(int bloodDonorId) throws InvalidDonationSchedulingException {
        CovidTestAppointment covidTestAppointment = null;

        CovidTest covidTest = database.getDonor(bloodDonorId);

        LocalDate today = LocalDate.now();
        LocalDate tooYougDate = today.minus(18, ChronoUnit.YEARS);

        if (covidTest.getDateOfBirth().isAfter(tooYougDate)) {
            throw new InvalidDonationSchedulingException("donor too young");
        }

        List<AppointmentSlot> appointmentSlotList = database.getAppointmentSlots();

        for (AppointmentSlot appointmentSlot: appointmentSlotList) {
            if (appointmentSlot.getTestResults().equalsIgnoreCase(covidTest.getTestResults())) {

            } else {
                throw new InvalidDonationSchedulingException("invalid blood type");
            }
        }

        return covidTestAppointment;
    }

}
