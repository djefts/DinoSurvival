public class Spinosaurus extends Dinosaur {
    
    public Spinosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Spinosaurus");
        this.setSpecies("Spinosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Spinosaurus(getxLoc(),getyLoc());
        }
        return null;
    }
}
