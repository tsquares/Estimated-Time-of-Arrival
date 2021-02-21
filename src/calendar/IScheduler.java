package calendar;

public interface IScheduler {
  public void addItem(
      Thing thing,
      int mm, int dd, int yyyy,
      String name
  );
  
  public void changeItem(
      Thing thingO, Thing thingN,
      int mmO, int mmN,
      int ddO, int ddN,
      int yyyyO, int yyyyN,
      String nameO, String nameN
  );
  
  public void delItem(
      Thing thing,
      int mm, int dd, int yyyy,
      String name
  );
  
  public void makeDone(
      Thing thing,
      int mm, int dd, int yyyy,
      String name
  );
  
  public String getAgenda();
}