import java.util.ArrayList;

public class Tyrannosaurus extends Dinosaur {
    
    public Tyrannosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Tyrannosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Triceratops(getxLoc(),getyLoc());
        }
        return null;
    }
}