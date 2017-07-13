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
public class ShippoManager {
    private Scheduler sc;
    private AppointmentFactory apFactory;
    
    public void listAllAppointments(){
        List<Appointment> list = getSc().listAllAppointments();
        if(list == null){
            System.out.println("No Appointments available");
            return;
        }
        for(Appointment ap: list){
            System.out.println(ap.appointmentStartTime+" "+ ap.clientName + " "+ ap.appointmentType+"\t");
        }
    }
    
    public void scheduleAppointment(){
        List<TimeSlot> timeSlots = getSc().checkForAvailableAppointments();
        System.out.println("Available time slots:");
        for(TimeSlot slot: timeSlots){
            System.out.print(slot);
        }
        boolean result = sc.scheduleAppointment();
        if(result){
            System.out.println("Appointment scheduled successfully");
        } else {
            System.out.println("Appointment not available");
        }
    }
    
    public void exitProgram(){
        System.exit(0);
    }
    
    public static void main(String[] args){
        ShippoManager instance = new ShippoManager();
        
        while(true){
            StringBuilder buffer = new StringBuilder("*********Task Scheduler************\n\n");
            buffer.append("Enter 1 to list all appointments\n");
            buffer.append("Enter 2 to schedule a new appointment\n");
            buffer.append("Enter 3 to exit the scheduler\n");
            int operation = IOUtil.readInteger(buffer.toString());
            switch (operation) {
                case 1:
                    instance.listAllAppointments();
                    break;
                case 2:
                    instance.scheduleAppointment();
                    break;
                case 3:
                    instance.exitProgram();
                    break;
                default:
                    System.out.println("Error: Invalid Input.");
            }
        }
    }

    public Scheduler getSc() {
        if(sc == null){
            this.sc = new SchedulerImpl();
        }
        return sc;
    }

    public void setSc(Scheduler sc) {
        this.sc = sc;
    }

    public AppointmentFactory getApFactory() {
        if(apFactory == null){
            this.apFactory = new AppointmentFactory();
        }
        return apFactory;
    }

    public void setApFactory(AppointmentFactory apFactory) {
        this.apFactory = apFactory;
    }
}
