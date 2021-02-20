package avatar.utils;

public enum Clothing {
  teeAndJeans("casual"), dress("dress");
  
  private final String rep;
  
  Clothing(String rep) {
    this.rep = rep;
  }
  
  public String toString() {
    return this.rep;
  }
}
