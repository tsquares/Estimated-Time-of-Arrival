package calendar;

import java.util.ArrayList;

public class Agenda implements IScheduler {
  ArrayList<Thing> loThings;
  
  public Agenda() {
    this.loThings = new ArrayList<>();
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
}
