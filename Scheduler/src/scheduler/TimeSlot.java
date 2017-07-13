package scheduler;

/**
 *
 * @author vasher
 */
public class TimeSlot implements Comparable<TimeSlot> {

    int hour;
    int slot;
    boolean isPM;
    
    public TimeSlot(int hour, int slot){
        this.hour = hour;
        this.slot = slot;
        if(hour > 11){
            this.isPM = true;
            if(hour > 12){
                this.hour = hour - 12;
            }
        } else if(hour == 0){
            this.hour = 12;
            this.isPM = false;
        }
    }
    
    public TimeSlot(String time){
        String[] arr = time.split(":");
        this.hour = Integer.parseInt(arr[0]);
        this.slot = Integer.parseInt(arr[1])/15;
        if(hour > 11){
            this.isPM = true;
            if(hour > 12){
                this.hour = hour - 12;
            }
        } else if(hour == 0){
            this.hour = 12;
            this.isPM = false;
        }
    }
    
    public TimeSlot nextTimeSlot(){
        if(slot == 3){
            if(hour == 12 && !isPM){
                return new TimeSlot(1, 0);
            }
            return new TimeSlot(hour+1, 0);
        } else {
            return new TimeSlot(hour, slot+1);
        }
    }
    
    @Override
    public int compareTo(TimeSlot t) {
        if(hour == t.hour){
            return slot-t.slot;
        }
        return hour-t.hour;
    }
    
    @Override
    public String toString(){
        String suffix = " AM";
        if(hour >= 12){
            suffix = " PM";
        }
        if(slot == 3){
            suffix += "\n";
        } else {
            suffix += "\t";
        }
        return hour + ":" + slot*15 + suffix;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.hour;
        hash = 37 * hash + this.slot;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeSlot other = (TimeSlot) obj;
        if (this.hour != other.hour) {
            return false;
        }
        if (this.slot != other.slot) {
            return false;
        }
        if (this.isPM != other.isPM) {
            return false;
        }
        return true;
    }
    
    
}
