package calendar;

public class Appointment extends Thing {
  
  public Appointment(int mm, int dd, int yyyy, String name) {
    super(mm, dd, yyyy, name);
  }
  
  @Override
  public String getThing() {
    String appt = "";
    
    appt = this.getDate().toString()
        + String.format(", Appointment: %s", this.getName());
    
    return appt;
  }
}
