package calendar;

import calendar.utils.*;

public interface IScheduler {
  public void addItem(
      ThingType thing,
      int mm, int dd, int yyyy,
      String name
  );
  
  public void changeItem(
      ThingType thingO, ThingType thingN,
      int mmO, int mmN,
      int ddO, int ddN,
      int yyyyO, int yyyyN,
      String nameO, String nameN
  );
  
  public boolean delItem(
      ThingType thing,
      int mm, int dd, int yyyy,
      String name
  );
  
/*  public void makeDone(
      ThingType thing,
      int mm, int dd, int yyyy,
      String name
  );*/
  
  public String toString();
}