package calendar;

public interface IScheduler {
  public void addItem(Thing thing, int mm, int dd, int yyyy, String name);
  public void changeItem(Thing thing, int mm, int dd, int yyyy, String name);
  public void delItem(Thing thing, int mm, int dd, int yyyy, String name);
  public void makeDone(Thing thing, int mm, int dd, int yyyy, String name);
}
