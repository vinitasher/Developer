/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author vasher
 */
public class HaircutAndShampooAppointment extends Appointment {
    public HaircutAndShampooAppointment(String clientName, TimeSlot appointmentStartTime) {
        this.clientName = clientName;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentType = Appointment.AppointmentType.SHAMPOO_AND_HAIRCUT_APPOINTMENT;
    }
}
