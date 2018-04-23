import java.util.ArrayList;

public class Triceratops extends Dinosaur {
    
    public Triceratops(int xLoc, int yLoc) {
        super(xLoc, yLoc);
        ReadDino readDino = new ReadDino();
        ArrayList<String> data = readDino.individualDino("Tyrannosaurus");

    }
}
