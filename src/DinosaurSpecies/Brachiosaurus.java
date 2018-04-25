public class Brachiosaurus extends Dinosaur {
    
    public Brachiosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Brachiosaurus");
        this.setSpecies("Brachiosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Brachiosaurus(getxLoc(),getyLoc());
        }
        return null;
    }
}
