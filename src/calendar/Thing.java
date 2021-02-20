package calendar;

import java.time.*;

public abstract class Thing {
  private int mm;
  private int dd;
  private int year;
  private String name;
  private LocalDate date;
  public LocalDate getDate() {
    return date;
  }
}
