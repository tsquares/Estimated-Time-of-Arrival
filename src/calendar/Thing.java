package calendar;

import java.time.*;

public abstract class Thing {
  private LocalDate date;
  private String name;
  //private boolean isDone;
  
  public Thing(int mm, int dd, int yyyy, String name) {
    this.date = LocalDate.of(yyyy, mm, dd);
    this.name = name;
    //this.isDone = false;
  }

  public LocalDate getDate() {
    return this.date;
  }
  
  public String getName() {
    return this.name;
  }
  
  // public boolean getIsDone() {
  //   return this.isDone;
  // }
  
  // public void markDone() {
  //   this.isDone = true;
  // }
  
  public abstract String getThing();

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Thing)) {
      return false;
    }
    Thing t = (Thing)obj;
    // return t.equals(obj) && obj.equals(t);
    return t.name.equalsIgnoreCase(this.name) && t.date.isEqual(this.date);
  }
}
