package avatar;

public class Human extends Tamagotchi implements IGotchiface {
  private HumanStyle style;
  
  public Human() {
    super();
    this.style = new HumanStyle();
  }
  
  @Override
  public void changeAppearance() {
  
  }
  
}
