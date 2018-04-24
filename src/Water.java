import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Sources:
 * https://stackoverflow.com/questions/18309868/imageio-iioexception-cant-read-input-file
 */
public class Water implements Positioned {
    private BufferedImage waterImage = null;
    private int xLoc;
    private int yLoc;
    private int radius = 100;
    
    public Water(int xLoc, int yLoc) {
        setWaterImage();
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    
    public BufferedImage getImage() {
        return waterImage;
    }
    
    private void setWaterImage() {
        try {
            waterImage = ImageIO.read(getClass().getResource("/resources/images/Water.png"));
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
    
    public String getName() {
        return "water";
    }
    
    public String toString() {
        String output = "WATER ";
        output += "(" + getxLoc() + ", " + getyLoc() + ")";
        return output;
    }
}
