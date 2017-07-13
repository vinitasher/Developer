/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.List;

/**
 *
 * @author vasher
 */
public interface Scheduler {
    
    public List<Appointment> listAllAppointments();
    
    public boolean scheduleAppointment();
    
    public List<TimeSlot> checkForAvailableAppointments();
}
