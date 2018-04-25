public class Stegosaurus extends Dinosaur {
    
    public Stegosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Stegosaurus");
        this.setSpecies("Stegosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Stegosaurus(getxLoc(),getyLoc());
        }
        return null;
    }
}
