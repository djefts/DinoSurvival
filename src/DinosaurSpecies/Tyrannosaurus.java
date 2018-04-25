import java.util.ArrayList;

public class Tyrannosaurus extends Dinosaur {
    
    public Tyrannosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Tyrannosaurus");
        this.setSpecies("Tyrannosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new  Tyrannosaurus (getxLoc(),getyLoc());
        }
        return null;
    }
}
