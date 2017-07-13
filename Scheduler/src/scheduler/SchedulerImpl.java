/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author vasher
 */
public class SchedulerImpl implements Scheduler {
    
    Map<TimeSlot, Appointment> appointmentMap;
    List<Appointment> allApointments;
    
    public void init(){
        appointmentMap = new TreeMap<>();
        allApointments = new ArrayList<>();
        for(int i=0; i<24; i++){
            for (int j=0; j<4; j++){
                TimeSlot t = new TimeSlot(i,j);
                appointmentMap.put(t, null);
            }
        }
    }

    @Override
    public List<Appointment> listAllAppointments() {
        return getAllApointments();
    }

    @Override
    public boolean scheduleAppointment() {
        int type = IOUtil.readInteger("\nEnter 0 for Haircut and 1 for Shampoo with Haircut");
        boolean result = false;
        switch (type) {
            case 0:
                {
                    Appointment apt1 = AppointmentFactory.generateNewHairCutAppointment();
                    boolean timeSlotfree = true;
                    for(int i=0; i<2; i++){
                        if(getAppointmentMap().get(apt1.appointmentStartTime) != null){
                            timeSlotfree = false;
                            break;
                        }
                    }       
                    if(timeSlotfree){
                        TimeSlot ts = apt1.appointmentStartTime;
                        result = true;
                        getAllApointments().add(apt1);
                        for(int i=0; i<2; i++){
                            getAppointmentMap().put(ts, apt1);
                            ts = ts.nextTimeSlot();
                        }
                    }       
                    break;
                }
            case 1:
                {
                    Appointment apt2 = AppointmentFactory.generateNewHairCutAndShampooAppointment();
                    boolean timeSlotfree = true;
                    for(int i=0; i<4; i++){
                        if(getAppointmentMap().get(apt2.appointmentStartTime) != null){
                            timeSlotfree = false;
                            break;
                        }
                    }       
                    if(timeSlotfree){
                        TimeSlot ts = apt2.appointmentStartTime;
                        result = true;
                        getAllApointments().add(apt2);
                        for(int i=0; i<4; i++){
                            getAppointmentMap().put(ts, apt2);
                            ts = ts.nextTimeSlot();
                        }
                    }       
                    break;
                }
            default:
                System.out.println("Invalid Input");
                break;
        }
        return result;
    }

    @Override
    public List<TimeSlot> checkForAvailableAppointments() {
        List<TimeSlot> result = new ArrayList<>();
        for(Map.Entry<TimeSlot, Appointment> entry: getAppointmentMap().entrySet()){
            if(entry.getValue() == null){
                result.add(entry.getKey());
            }
        }
        return result;
    }
    
    public Map<TimeSlot, Appointment> getAppointmentMap() {
        if(appointmentMap == null){
            init();
        }
        return appointmentMap;
    }

    public List<Appointment> getAllApointments() {
        if(allApointments == null){
            init();
        }
        return allApointments;
    }
    
}
