package calendar;

import java.time.*;

public abstract class Thing {
  private LocalDate date;
  private final String name;
  private final boolean isDone;
  
  public Thing(int mm, int dd, int yyyy, String name) {
    this.date = LocalDate.of(yyyy, mm, dd);
    this.name = name;
    this.isDone = false;
  }

  public LocalDate getDate() {
    return this.date;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean getIsDone() {
    return this.isDone;
  }
  
  public void printThing() {
    // TODO -- print contents of this Thing
  }
}
