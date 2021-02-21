package calendar;

import java.util.ArrayList;

public class Agenda implements IScheduler {
  ArrayList<Thing> loThings;
  
  public Agenda() {
    this.loThings = new ArrayList<>();
  }
  
  private static Thing makeSpecificThing(Thing thing,
      int mm, int dd, int yyyy,
      String name) {
    
    if (thing instanceof Appointment) {
      return new Appointment(mm, dd, yyyy, name);
    }
    
    else if (thing instanceof Task) {
      return new Task(mm, dd, yyyy, name);
    }
    
    else if (thing instanceof Reminder) {
      return new Reminder(mm, dd, yyyy, name);
    }
    
  }
  
  @Override
  public void addItem(Thing thing, int mm, int dd, int yyyy, String name) {
  
  }
  
  @Override
  public void changeItem(Thing thing, int mm, int dd, int yyyy, String name) {
  
  }
  
  @Override
  public void delItem(Thing thing, int mm, int dd, int yyyy, String name) {
  
  }
  
  @Override
  public void makeDone(Thing thing, int mm, int dd, int yyyy, String name) {
  
  }
  
  @Override
  public void printAgenda() {
  }
    

  public ArrayList<Thing> getThings() {
    return loThings;
  }
}
