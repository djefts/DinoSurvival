import java.util.ArrayList;

public class Tyrannosaurus extends Dinosaur {
    
    public Tyrannosaurus(int xLoc, int yLoc) {
        ReadDino readDino = new ReadDino();
        ArrayList<String> data = readDino.individualDino("Tyrannosaurus");
        addHealth(data.get(0));
        setSpeed(data.get(1));
        setAttack(data.get(2));
        setDefense(data.get(3));
        setFoodStorage(data.get(4));
        setWaterStorage(data.get(5));
        setKids(data.get(6));
        setFoodToReproduce(data.get(7));
        setTurnsWithoutFood(data.get(8));
        setMaxAge(data.get(9));
        setHerbivore(data.get(10));
        setHerd(data.get(11));
        setTerritorial(data.get(12));
        setDinosaur(xLoc, yLoc);
    }
}