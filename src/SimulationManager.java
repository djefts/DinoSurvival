public class SimulationManager {
    
    private final int minSimLength = 500;
    private final int maxSimLength = 5000;
    private int simulationLength;
    private Object[][] thePlayingField;
    
    public void loop() {
        setSimulationLength();
        System.out.println("Simulation will run for " + getSimulationLength() + "loops.");
        
        do {
            
            
            
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
