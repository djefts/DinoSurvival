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
        simulationManager.setGrasses();
        simulationManager.setWaters();
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
                dinosaur.move(dinosaurs, grasses, waters);
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
        for (int i = 0; i < numGrasses; i++) {
            grasses.add(createAGrass());
        }
    }
    public Grass createAGrass() {
        //grass position: (int)(Math.random()*simulationSize)
        
        int xLoc = (int)(Math.random()*simulationSize);
        int yLoc = (int)(Math.random()*simulationSize);
        for (Grass grass : grasses) {
            if(grass.getxLoc()==xLoc && grass.getyLoc()==yLoc) {
                return createAGrass();
            }
        }
        return new Grass(xLoc, yLoc);
    }
    
    public void setWaters() {
        for (int i = 0; i < numWaters; i++) {
            waters.add(createAWater());
        }
    }
    public Water createAWater() {
        //water position: (int)(Math.random()*simulationSize)
        int xLoc = (int)(Math.random()*simulationSize);
        int yLoc = (int)(Math.random()*simulationSize);
        for (Water water : waters) {
            if(water.getxLoc()==xLoc && water.getyLoc()==yLoc) {
                return createAWater();
            }
        }
        return new Water(xLoc, yLoc);
    }
}
