public class Pterodactyl extends Dinosaur {
    
    public Pterodactyl(int xLoc, int yLoc) {
        setDinosaur(xLoc, yLoc, "Pterodactyl");
        this.setSpecies("Pterodactyl");
    }
    
    @Override
    public Dinosaur timeToReproduce() {
        if(this.getCurFood() - this.getFoodToReproduce() > 0) {
            return new Pterodactyl(getxLoc(),getyLoc());
        }
        return null;
    }
}
