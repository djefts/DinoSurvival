import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;

public class SimulationManager {
    
    private final int minSimLength = 250;
    private int maxSimLength = 5000;
    private int simulationLength;
    int simulationTime = 0;
    
    private final int simulationSize = 50;        //length of each side of the simulation screen
    
    private final int numGrasses = 4;
    private final int numWaters = 4;
    
    private ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
    private ArrayList<Grass> grasses = new ArrayList<>();
    private ArrayList<Water> waters = new ArrayList<>();
    
    public SimulationManager() {
    
    }
    
    public SimulationManager(int maxSimLength) {
        this.maxSimLength = maxSimLength;
        simulationLength = this.maxSimLength;
    }
    
    public static void main(String[] args) {
        SimulationManager simulationManager = new SimulationManager();
        simulationManager.loop();
    }
    
    public void loop() {
        setSimulationLength();
        System.out.println(getSimulationLength());
        setResources();
    
        Usersaurus usersaurus = new Usersaurus(0, 0);
        String[] args = new String[]{""};
        usersaurus.main(args);
        dinosaurs.add(usersaurus);
        
        System.out.println("\n\n\n");
        
        for(Grass grass:grasses) {
            System.out.println(grass);
        }
        
        //simulation loop
        do {
            for (Grass grass : grasses) {
                grass.timeToGrow();
            }
            for (Water water : waters) {
            
            }
            for (int i=0; i<dinosaurs.size(); i++) {
                Dinosaur dinosaur = dinosaurs.get(i);
                if(simulationLength%3==0) { //dinosaurs lose 1 health and food every 3 turns
                    dinosaur.addFood(-1);
                    dinosaur.addWater(-1);
                }
                dinosaur.loseHealth();
                dinosaur.move(dinosaurs, grasses, waters);
            }
            System.out.println("There are " + dinosaurs.size() + " dinosaurs left.");
            simulationLength -= 1;
            simulationTime += 1;
            //update GUI
        } while (simulationLength > 0);
        
        System.out.println("¡THE SIMULATION IS DONE!");
    }
    
    public void setSimulationLength() {
        simulationLength = (int) (minSimLength + (Math.random() * maxSimLength - minSimLength));
    }
    
    public int getSimulationLength() {
        return simulationLength;
    }
    
    public void setResources() {
        setGrasses();
        setWaters();
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
        for (Grass grass : grasses) {
            if(grass.getxLoc()==xLoc && grass.getyLoc()==yLoc) {
                return createAWater();
            }
        }
        return new Water(xLoc, yLoc);
    }
    
    public void testDinos() {
        Tyrannosaurus mover1 = new Tyrannosaurus((int)(Math.random()*simulationSize), (int)(Math.random()*simulationSize));
        dinosaurs.add(mover1);
    }
}
