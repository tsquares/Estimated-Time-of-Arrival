package avatar.utils;

public enum LeafShape {
  spear("spear"), needle("needle"), round("round");
  
  private final String rep;
  
  LeafShape(String rep) {
    this.rep = rep;
  }
  
  public String toString() {
    return this.rep;
  }
}
