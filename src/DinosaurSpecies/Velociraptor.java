public class Velociraptor extends Dinosaur {
    
    public Velociraptor(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Velociraptor");
        this.setSpecies("Velociraptor");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Velociraptor(getxLoc(),getyLoc());
        }
        return null;
    }
}
