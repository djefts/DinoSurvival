public class Triceratops extends Dinosaur {
    
    public Triceratops(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Triceratops");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Triceratops(getxLoc(),getyLoc());
        }
        return null;
    }
}
