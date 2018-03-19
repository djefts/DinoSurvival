import java.awt.image.BufferedImage;

public class Water extends Edible {
    private BufferedImage waterImage = null;
    private int xLoc;
    private int yLoc;
    private int radius = 100;
    
    public BufferedImage getWaterImage() {
        return waterImage;
    }
    
    public void setWaterImage(BufferedImage waterImage) {
        this.waterImage = waterImage;
    }
    
    public int getxLoc() {
        return xLoc;
    }
    
    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }
    
    public int getyLoc() {
        return yLoc;
    }
    
    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
