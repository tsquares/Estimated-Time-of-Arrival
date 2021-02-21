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
    
    else { // instanceof Reminder
      return new Reminder(mm, dd, yyyy, name);
    }
  }
  
  @Override
  public void addItem(Thing thing,
      int mm, int dd, int yyyy, String name) {
    Thing item = makeSpecificThing(thing, mm, dd, yyyy, name);
    this.loThings.add(item);
  }
  
  @Override
  public void changeItem(Thing thingO, Thing thingN,
      int mmO, int mmN,
      int ddO, int ddN,
      int yyyyO, int yyyyN,
      String nameO, String nameN) {
    
    Thing oldItem = makeSpecificThing(
        thingO,
        mmO, ddO, yyyyO,
        nameO
    );
    Thing newItem = makeSpecificThing(
        thingN,
        mmN, ddN, yyyyN,
        nameN
    );
    
    this.loThings.remove(oldItem);
    this.loThings.add(newItem);
  }
  
  @Override
  public void delItem(Thing thing,
      int mm, int dd, int yyyy, String name) {
    Thing item = makeSpecificThing(thing, mm, dd, yyyy, name);
    this.loThings.remove(item);
  }
  
  @Override
  public void makeDone(Thing thing,
      int mm, int dd, int yyyy, String name) {
    Thing item = makeSpecificThing(thing, mm, dd, yyyy, name);
    this.loThings.remove(item);
    
    Thing completedItem = item;
    completedItem.markDone();
    this.loThings.add(completedItem);
  }
  
  @Override
  public String getAgenda() {
    String agenda = "";
    
    for (Thing thing : this.loThings) {
      String currentThing = thing.getThing();
      agenda = agenda + currentThing + "\n";
    }
    
    return agenda.substring(0, agenda.length() - 1);
  }

  public ArrayList<Thing> getThings() {
    return this.loThings;
  }
}
