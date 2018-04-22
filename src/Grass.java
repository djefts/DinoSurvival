import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Sources:
 * https://stackoverflow.com/questions/18309868/imageio-iioexception-cant-read-input-file
 */
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
    
    private void startGrowthStage() {
        growthStage = (int) (Math.random() * 4);
    }
    
    public void timeToGrow() {
        grow -= 1;
        if(grow <= 0 && growthStage != 4) {
            growthStage += 1;
            grow = growthStage;
        }
    }
    
    private BufferedImage getImage() {
        
        switch (getGrowthStage()) {
            case 4:
                return grassStage4;
            case 3:
                return grassStage3;
            case 2:
                return grassStage2;
            case 1:
                return grassStage1;
            default:
                return null;
        }
    }
    
    private void setStagePic() {
        setStageImages();
        currentStage = getImage();
    }
    
    private void setStageImages() {
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
        String output = "GRASS "+growthStage;
        output += "(" + getxLoc() + ", " + getyLoc() + ")";
        /*output += "Growth stage: " + getGrowthStage();
        output += "\t\tTurns till growth: " + grow;*/
        return output;
    }
}