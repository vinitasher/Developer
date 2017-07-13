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
public abstract class Appointment {
    String clientName;
    TimeSlot appointmentStartTime;
    AppointmentType appointmentType;
    
    enum AppointmentType {
        HAIRCUT_APPOINTMENT,
        SHAMPOO_AND_HAIRCUT_APPOINTMENT;
    }
}
