package scheduler;

/**
 *
 * @author vasher
 */
public class AppointmentFactory {
    
    public static Appointment generateNewHairCutAppointment(){
        TimeSlot ts = new TimeSlot(IOUtil.readString("Enter time slot you wish to book:"));
        Appointment app = new HaircutAppointment(IOUtil.readString("Enter client name:"), ts);
        return app;
    }
    
    public static Appointment generateNewHairCutAndShampooAppointment(){
        TimeSlot ts = new TimeSlot(IOUtil.readString("Enter time slot you wish to book:"));
        Appointment app = new HaircutAndShampooAppointment(IOUtil.readString("Enter client name:"), ts);
        return app;
    }
    
}
