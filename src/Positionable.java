/**
 * interface for objects whose position can change, namely, dinosaurs
 */
public interface Positionable extends Positioned {
    
    void setxLoc(int xLoc);
    void setyLoc(int yLoc);
}
