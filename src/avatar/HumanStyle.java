package avatar;

import avatar.utils.Clothing;
import avatar.utils.HairStyle;
import java.awt.Color;

public class HumanStyle {
  private Color skin;
  private Color hair;
  private HairStyle hairStyle;
  private Color eye;
  private Clothing clothing;
  
  public HumanStyle() {
    this.skin = Color.WHITE;
    this.hair = Color.WHITE;
    this.hairStyle = HairStyle.longHair;
    this.eye = Color.WHITE;
    this.clothing = Clothing.teeAndJeans;
  }
  
  public HumanStyle(Color skin, Color hair,
      HairStyle hairStyle, Color eye, Clothing clothing) {
    this.skin = skin;
    this.hair = hair;
    this.hairStyle = hairStyle;
    this.eye = eye;
    this.clothing = clothing;
  }
  
  
}
