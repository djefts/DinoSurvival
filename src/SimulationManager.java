import java.util.ArrayList;

public class SimulationManager {
    
    private final int minSimLength = 500;
    private final int maxSimLength = 5000;
    private int simulationLength;
    
    private final int simulationSize = 50;        //length of each side of the simulation screen
    
    private final int numGrasses = 5;
    private final int numWaters = 10;
    
    private ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
    private ArrayList<Grass> grasses = new ArrayList<>();
    private ArrayList<Water> waters = new ArrayList<>();
    
    public static void main(String[] args) {
        SimulationManager simulationManager = new SimulationManager();
        simulationManager.loop();
    }
    
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
        simulationLength = (int) (minSimLength + (Math.random() * maxSimLength - minSimLength));
    }
    
    public int getSimulationLength() {
        return simulationLength;
    }
    
    public void setGrasses() {
        //grass position: (int)(Math.random()*simulationSize)
        int numGrasses = 5;
        
        for (int i = 0; i < numGrasses; i++) {
            grasses.add(new Grass((int)(Math.random()*4), (int)(Math.random()*simulationSize)));
        }
    }
}
