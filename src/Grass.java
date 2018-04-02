import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Grass implements Positioned {
    private final int growthRate = 4;           //turns before grass will increase in stage
    private final int radius = 50;              //radius of grass in pixels
    private int growthStage; //0-4
    private BufferedImage currentStage;
    private BufferedImage grassStage1 = null;
    private BufferedImage grassStage2 = null;
    private BufferedImage grassStage3 = null;
    private BufferedImage grassStage4 = null;
    private int grow = growthRate;
    private int xLoc, yLoc;
    
    
    public Grass(int xLoc, int yLoc) {
        startGrowthStage();
        setStagePic();
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    public Grass(int xLoc, int yLoc, int growthStage) {
        this.growthStage = growthStage;
        setStagePic();
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    
    @Override
    public int getxLoc() {
        return xLoc;
    }
    
    @Override
    public int getyLoc() {
        return yLoc;
    }
    
    public int getGrowthStage() {
        return growthStage;
    }
    
    public void setGrowthStage(int growthStage) {
        this.growthStage = growthStage;
    }
    
    public void startGrowthStage() {
        growthStage = (int) (Math.random() * 4);
    }
    
    public void timeToGrow() {
        grow -= 1;
        if(grow <= 0 && growthStage != 4) {
            growthStage += 1;
            grow = growthStage;
        }
    }
    
    public BufferedImage getImage() {
        
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
    
    public void setStagePic() {
        setStageImages();
        currentStage = getImage();
    }
    
    public void setStageImages() {
        try {
            grassStage1 = ImageIO.read(getClass().getResource("/resources/images/GrassStage1.png"));
            grassStage2 = ImageIO.read(getClass().getResource("/resources/images/grassStage2.png"));
            grassStage3 = ImageIO.read(getClass().getResource("/resources/images/grassStage3.png"));
            grassStage4 = ImageIO.read(getClass().getResource("/resources/images/grassStage4.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getName() {
        return "grass";
    }
    
    public String toString() {
        String output = "GRASS\tGrowth stage: " + getGrowthStage();
        output += "\t\tTurns till growth: " + grow;
        output += "\t(" + getxLoc() + ", " + getyLoc() + ")";
        return output;
    }
}