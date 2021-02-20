package avatar.utils;

public enum SoilType {
  dirt("dirt"), pebble("pebble"), sand("sand");
  
  private final String rep;
  
  SoilType(String rep) {
    this.rep = rep;
  }
  
  public String toString() {
    return this.rep;
  }
}
