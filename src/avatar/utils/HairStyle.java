package avatar.utils;

public enum HairStyle {
  longHair("long"), shortHair("short");
  
  private final String rep;
  
  HairStyle(String rep) {
    this.rep = rep;
  }
  
  public String toString() {
    return this.rep;
  }
}
