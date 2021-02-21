package calendar;

public class Task extends Thing {
  
  public Task(int mm, int dd, int yyyy, String name) {
    super(mm, dd, yyyy, name);
  }
  
  @Override
  public String getThing() {
    String task = "";
  
    task = this.getDate().toString()
        + String.format(", Task: %s", this.getName());
  
    return task;
  }
}
