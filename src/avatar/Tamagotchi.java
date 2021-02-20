package avatar;

public abstract class Tamagotchi implements IGotchiface {
  private int health;
  private int happiness;
  private int xp;
  private int currentLevel;
  
  Tamagotchi() {
    this.health = 100;
    this.happiness = 100;
    this.xp = 0;
    this.currentLevel = 1;
  }
  
  public void changeAppearance() {
    // TODO
  }
  public void healthUp() {
    // TODO
  }
  public void healthDown() {
    // TODO
  }
  public void happinessUp() {
    // TODO
  }
  public void happinessDown() {
    // TODO
  }
  public void xpUp() {
    // TODO
  }
  
}
