/**
 * Interface for objects that have a position
 */
interface Positioned {
    
    int getxLoc();
    
    int getyLoc();
    
    default int distanceTo(Positioned pos) {
        int dx = pos.getxLoc() - this.getxLoc();
        int dy = pos.getyLoc() - this.getyLoc();
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}