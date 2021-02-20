package avatar;

public class Human extends Tamagotchi implements IGotchiface {
  private HumanStyle style;
  
  Human() {
    super();
    this.style = new HumanStyle();
  }

}
