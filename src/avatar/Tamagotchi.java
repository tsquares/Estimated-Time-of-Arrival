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
  
  public abstract void changeAppearance();
  
  public void healthUp(int amount) {
    
    if (this.health == 100) {
      // do nothing this is max health
      return;
    }
    
    this.health += amount;
  }
  
  public void healthDown() {
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
