public class Parasaurolophus extends Dinosaur {
    
    public Parasaurolophus (int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Parasaurolophus");
        this.setSpecies("Parasaurolophus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Parasaurolophus(getxLoc(),getyLoc());
        }
        return null;
    }
}
