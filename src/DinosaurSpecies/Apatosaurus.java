public class Apatosaurus extends Dinosaur {
    
    public Apatosaurus(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Apatosaurus");
        this.setSpecies("Apatosaurus");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Apatosaurus(getxLoc(),getyLoc());
        }
        return null;
    }
}
