package calendar;

import java.util.ArrayList;
import calendar.utils.*;

public class Agenda implements IScheduler {
  ArrayList<Thing> loThings;
  
  public Agenda() {
    this.loThings = new ArrayList<>();
  }
  
  private static Thing makeSpecificThing(ThingType thing,
      int mm, int dd, int yyyy,
      String name) {
    
    if (thing.toChar() == 'a') {
      return new Appointment(mm, dd, yyyy, name);
    }
    
    else if (thing.toChar() == 't') {
      return new Task(mm, dd, yyyy, name);
    }
    
    else { // instanceof Reminder
      return new Reminder(mm, dd, yyyy, name);
    }
  }
  
  @Override
  public void addItem(ThingType thing,
      int mm, int dd, int yyyy, String name) {
    Thing item = makeSpecificThing(thing, mm, dd, yyyy, name);
    this.loThings.add(item);
  }
  
  @Override
  public void changeItem(ThingType thingO, ThingType thingN,
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
  public void delItem(ThingType thing,
      int mm, int dd, int yyyy, String name) {
    Thing item = makeSpecificThing(thing, mm, dd, yyyy, name);
    this.loThings.remove(item);
  }
  
  @Override
  public void makeDone(ThingType thing,
      int mm, int dd, int yyyy, String name) {
    Thing item = makeSpecificThing(thing, mm, dd, yyyy, name);
    this.loThings.remove(item);
    
    Thing completedItem = item;
    completedItem.markDone();
    this.loThings.add(completedItem);
  }
  
  @Override
  public String toString() {
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
