package calendar;

public class Reminder extends Thing {
  
  public Reminder(int mm, int dd, int yyyy, String name) {
    super(mm,dd, yyyy, name);
  }
  
  @Override
  public String getThing() {
    String rem = "";
  
    rem = this.getDate().toString()
        + String.format(", Reminder: %s", this.getDate());
  
    return rem;
  }
  
  public String printReminder() {
    String rem = "";
    
    rem = String.format("!REMINDER : %s\n", this.getName())
        + "Complete today!";
    
    return rem;
  }
}
