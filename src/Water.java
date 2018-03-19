import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Water implements Positioned{
    private BufferedImage waterImage = null;
    private int xLoc;
    private int yLoc;
    private int radius = 100;
    
    public Water(int xLoc, int yLoc) {
        setWaterImage();
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    
    public BufferedImage getWaterImage() {
        return waterImage;
    }
    
    public void setWaterImage() {
        try {
            waterImage = ImageIO.read(new File("water.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getxLoc() {
        return xLoc;
    }
    
    public int getyLoc() {
        return yLoc;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
