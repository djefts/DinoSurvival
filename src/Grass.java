import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Grass extends Edible {
    private int growthStage; //0-4
    
    private BufferedImage grassStage1 = null;
    private BufferedImage grassStage2 = null;
    private BufferedImage grassStage3 = null;
    private BufferedImage grassStage4 = null;
    
    private int xLoc;
    private int yLoc;
    private final int growthRate = 4;           //turns before grass will increase in stage
    private int grow = growthRate;
    private final int radius = 50;              //radius of grass in pixels
    
    
    public Grass(int growthStage) {
        setGrowthStage(growthStage);
    }
    
    public int getGrowthStage() {
        return growthStage;
    }
    
    public void setGrowthStage(int growthStage) {
        this.growthStage = growthStage;
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
    
    public void timeToGrow() {
        grow = -1;
        if(grow <= 0 && growthStage != 4) {
            growthStage += 1;
        }
    }
    
    public BufferedImage getStagePic() {
        try {
            readImages();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(getGrowthStage() == 4) {
            return grassStage4;
        } else if(getGrowthStage() == 3) {
            return grassStage3;
        } else if(getGrowthStage() == 2) {
            return grassStage2;
        } else if(getGrowthStage() == 1) {
            return grassStage1;
        } else {
            return null;
        }
    }
    
    public void readImages() throws Exception {
        try {
            grassStage1 = ImageIO.read(new File("grassStage1.png"));
            grassStage2 = ImageIO.read(new File("grassStage2.png"));
            grassStage3 = ImageIO.read(new File("grassStage3.png"));
            grassStage4 = ImageIO.read(new File("grassStage4.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}