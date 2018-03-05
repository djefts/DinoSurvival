import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class NaturalResource {
    private int growthStage; //0-4
    
    private BufferedImage grassStage1 = null;
    private BufferedImage grassStage2 = null;
    private BufferedImage grassStage3 = null;
    private BufferedImage grassStage4 = null;
    
    public NaturalResource(int growthStage) {
        setGrowthStage(growthStage);
    }
    
    public int getGrowthStage() {
        return growthStage;
    }
    
    public void setGrowthStage(int growthStage) {
        this.growthStage = growthStage;
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