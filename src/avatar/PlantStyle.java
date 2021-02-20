package avatar;

import java.awt.Color;
import avatar.utils.LeafShape;
import avatar.utils.SoilType;

public class PlantStyle {
  private Color leaf;
  private LeafShape leafShape;
  private SoilType soilType;
  private Color pot;
  private int leafCount;
  
  public PlantStyle() {
    this.leaf = Color.GREEN;
    this.leafShape = LeafShape.spear;
    this.soilType = SoilType.dirt;
    this.pot = Color.WHITE;
    this.leafCount = 4;
  }
  
  public PlantStyle(Color leaf, LeafShape leafShape, SoilType soilType,
      Color pot, int leafCount) {
    this.leaf = leaf;
    this.leafShape = leafShape;
    this.soilType = soilType;
    this.pot = pot;
    this.leafCount = leafCount;
  }
  

}
