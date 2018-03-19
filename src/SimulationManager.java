import java.util.ArrayList;

public class SimulationManager {
    
    private final int minSimLength = 500;
    private final int maxSimLength = 5000;
    private int simulationLength;
    private ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
    private ArrayList<Grass> grasses = new ArrayList<>();
    private ArrayList<Water> waters = new ArrayList<>();
    
    public void loop() {
        setSimulationLength();
        System.out.println(getSimulationLength());
        
        do {
            for (Grass grass : grasses) {
                grass.timeToGrow();
            }
            for (Water water : waters) {
            
            }
            for (Dinosaur dinosaur : dinosaurs) {
            
            }
            
            simulationLength -= 1;
        } while (simulationLength > 0);
    }
    
    public void setSimulationLength() {
        simulationLength = (int)Math.random() * maxSimLength;
        checkSimLength();
    }
    
    public void checkSimLength() {
        if(simulationLength<minSimLength) {
            simulationLength=minSimLength;
        }
    }
    
    public int getSimulationLength() {
        return simulationLength;
    }
}
