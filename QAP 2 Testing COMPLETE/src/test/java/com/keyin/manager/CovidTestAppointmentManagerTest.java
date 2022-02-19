package com.keyin.manager;

import com.keyin.domain.Database;
import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.appointment.CovidTestAppointment;
import com.keyin.domain.donor.CovidTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class CovidTestAppointmentManagerTest {
    @Mock
    private Database mockDatabase;

    @Test
    public void covidTestTooYoung() {
        CovidTest covidTestTooYoung = new CovidTest();
        covidTestTooYoung.setFirstName("Dryden");
        covidTestTooYoung.setLastName("Bussey");
        covidTestTooYoung.setTestResults("Negative");
        covidTestTooYoung.setDateOfBirth(LocalDate.of( 1997 , Month.MAY , 19 ));
        covidTestTooYoung.setId(1);

        Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                covidTestTooYoung
        );

        CovidTestAppointmentManager covidTestAppointmentManager =
                new CovidTestAppointmentManager(mockDatabase);

        try {
            CovidTestAppointment covidTestAppointment = covidTestAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("Client too young for testing"));
        }


    }

    @Test
    public void covidTestInvalidType() {
        CovidTest covidTestTooYoung = new CovidTest();
        covidTestTooYoung.setFirstName("COVID");
        covidTestTooYoung.setLastName("MAN");
        covidTestTooYoung.setTestResults("Positive");
        covidTestTooYoung.setDateOfBirth(LocalDate.of( 2000 , Month.FEBRUARY , 6 ));
        covidTestTooYoung.setId(1);

        Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                covidTestTooYoung
        );

        ArrayList<AppointmentSlot> appointmentSlots = new ArrayList<AppointmentSlot>();

        AppointmentSlot appointmentSlotTypeA = new AppointmentSlot();
        appointmentSlotTypeA.setId(1);
        appointmentSlotTypeA.setLocation("123 Coders lane metaverse");
        appointmentSlotTypeA.setTestResults("Negative");
        appointmentSlots.add(appointmentSlotTypeA);

        AppointmentSlot appointmentSlot = new AppointmentSlot();
        appointmentSlot.setId(1);
        appointmentSlot.setLocation("123 Coders lane metaverse");
        appointmentSlot.setTestResults("Positive");
        appointmentSlots.add(appointmentSlot);


        Mockito.when(mockDatabase.getAppointmentSlots()).thenReturn(appointmentSlots);

        CovidTestAppointmentManager covidTestAppointmentManager =
                new CovidTestAppointmentManager(mockDatabase);

        try {
            CovidTestAppointment covidTestAppointment = covidTestAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("invalid blood type"));
        }

        //Assertions.fail("Did not hit expected Exception!");
    }

}
