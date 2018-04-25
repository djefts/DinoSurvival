public class Dilophosaurus extends Dinosaur {
    
    public Dilophosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Triceratops");
        this.setSpecies("Triceratops");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Dilophosaurus(getxLoc(),getyLoc());
        }
        return null;
    }
}
