import DataIO.SimulationCount;

import java.util.ArrayList;

public class DataCollection {
    
    public static ArrayList<SimulationCount> dinoPopData = new ArrayList<>();
    
    public static void collect(SimulationManager simMan) {
        
        /*when simTime = simulationTime -> count dinosaurs through array and store it in the ArrayList
         * dinoPopData-> dinosaur population data.
         * Running loop while simulationLength > 0 */
        
        if(simMan.getSimulationTime() % 10 == 0) {
            SimulationCount simC = new SimulationCount();
            simC.countUser = dinoSimCount(simMan, "Usersaurus");
            simC.countTri = dinoSimCount(simMan, "Triceratop");
            simC.countTrex = dinoSimCount(simMan, "Tyrannosaurus");
            simC.countSteg = dinoSimCount(simMan, "Stegosaurus");
            simC.countVel = dinoSimCount(simMan, "Velociraptor");
            simC.countDil = dinoSimCount(simMan, "Dilophosaurus");
            simC.countBrach = dinoSimCount(simMan, "Brachiosaurus");
            simC.countPtero = dinoSimCount(simMan, "Pterodactyl");
            simC.countPach = dinoSimCount(simMan, "Pachycephalosaurus");
            simC.countSpino = dinoSimCount(simMan, "Spinosaurus");
            simC.countPara = dinoSimCount(simMan, "Parasaurolophus");
            simC.countAnkyl = dinoSimCount(simMan, "Ankylosaurus");
            simC.countApa = dinoSimCount(simMan, "Apatosaurus");
            simC.simTime = simMan.getSimulationTime();
            
            dinoPopData.add(simC);
        }
    }
    
    //method to count dinosaurs alive at certain increments in time
    
    public static int dinoSimCount(SimulationManager simMan, String name) {
        int count = 0;
        for (Dinosaur d : simMan.getDinosaurs()) {
            if(d.getSpecies() == name)
                count++;
        }
        return count;
    }
    
    public static ArrayList<SimulationCount> getSimulationCount() {
        return dinoPopData;
    }
    
}
