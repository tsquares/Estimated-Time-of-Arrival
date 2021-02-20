package calendar;

public abstract class Thing {
  private final int mm;
  private final int dd;
  private final int yyyy;
  private final String name;
  private final boolean isDone;
  
  public Thing(int mm, int dd, int yyyy, String name) {
    this.mm = mm;
    this.dd = dd;
    this.yyyy = yyyy;
    this.name = name;
    this.isDone = false;
  }
  
  public int getMm() {
    return this.mm;
  }
  
  public int getDd() {
    return this.dd;
  }
  
  public int getYyyy() {
    return this.yyyy;
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
