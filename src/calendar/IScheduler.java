package calendar;

public interface IScheduler {
  public void addItem(Thing thing, int mm, int dd, int yyyy);
  public void delItem(Thing thing);
}
