import java.util.ArrayList;

public class Tyrannosaurus extends Dinosaur {
    
    public Tyrannosaurus(int xLoc, int yLoc) {
        ReadDino readDino = new ReadDino();
        ArrayList<String> data = readDino.individualDino("Tyrannosaurus");
        addHealth(4);
        setSpeed(3);
        setAttack(7);
        setDefense(2);
        setFoodStorage(8);
        setWaterStorage(4);
        setKids(1);
        setFoodToReproduce(6);
        setTurnsWithoutFood(4);
        setMaxAge(4);
        setHerbivore(0);
        setHerd(0);
        setTerritorial(1);
        setDinosaur(xLoc, yLoc);
    }
}