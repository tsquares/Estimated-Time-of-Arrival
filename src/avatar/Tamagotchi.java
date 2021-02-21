package avatar;

public abstract class Tamagotchi implements IGotchiface {
  private int health;
  private int happiness;
  private int xp;
  private int currentLevel;
  private String name;

  public Tamagotchi() {
    this.health = 100;
    this.happiness = 100;
    this.xp = 0;
    this.currentLevel = 1;
    this.name = "Francis";
  }
  
  public Tamagotchi(String name) {
    this.health = 100;
    this.happiness = 100;
    this.xp = 0;
    this.currentLevel = 1;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name + ": \n" + "\tHealth: " + health + "\tHappiness: " + happiness + "\tXP: " + xp + "\tCurrent Level: " + currentLevel + "\n";
  }

  public abstract void changeAppearance();
  
  @Override
  public void healthUp(int amount) {
    int newHealth = this.health + amount;
    
    if (newHealth >= 100) {
      // this is max health
      this.health = 100;
      return;
    }
    
    this.health = newHealth;
  }
  
  @Override
  public void healthDown(int amount) {
    int newHealth = this.health - amount;
  
    if (newHealth <= 0) {
      // this is min health
      this.health = 0;
      return;
    }
  
    this.health = newHealth;
  }
  
  @Override
  public void happinessUp(int amount) {
    int newHappiness = this.happiness + amount;
    
    if (newHappiness >= 100) {
      this.happiness = 100;
      return;
    }
    
    this.happiness = newHappiness;
  }
  
  @Override
  public void happinessDown(int amount) {
    int newHappiness = this.happiness - amount;
  
    if (newHappiness <= 0) {
      this.happiness = 0;
      return;
    }
  
    this.happiness = newHappiness;
  }
  
  @Override
  public void xpUp(int amount) {
    int levelGoal = (this.currentLevel + 1) * 10;
    int newXP = this.xp + amount;
    
    if (newXP >= levelGoal) {
      this.xp = newXP - levelGoal;
      this.currentLevel += 1;
    } else {
      this.xp = newXP;
    }
    
  }
  
}
