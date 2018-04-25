public class Ankylosaurus extends Dinosaur {
    
    public Ankylosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Ankylosaurus");
        this.setSpecies("Ankylosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Ankylosaurus(getxLoc(),getyLoc());
        }
        return null;
    }
}
