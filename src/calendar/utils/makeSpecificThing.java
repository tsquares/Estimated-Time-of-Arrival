package calendar.utils;

import calendar.Thing;
import calendar.Appointment;
import calendar.Task;
import calendar.Reminder;

public class makeSpecificThing {
  private final Thing thing;
  private final int mm;
  private final int dd;
  private final int yyyy;
  private final String name;
  
  public makeSpecificThing(Thing thing,
      int mm, int dd, int yyyy,
      String name) {
    this.mm = mm;
    this.dd = dd;
    this.yyyy = yyyy;
    this.name = name;
    
    switch (thing) {
      case Appointment:
        this.thing = new Appointment();
        break;
      case Task:
        this.thing = new Task();
        break;
      case Reminder:
        this.thing = new Reminder();
        break;
      default:
        break;
    }
  }
  
}
