public class SimulationManager {
    
    private int simulationLength;
    
    public void loop() {
        setSimulationLength();
        System.out.println(getSimulationLength());
        
        do {
            
            
            
            simulationLength -= 1;
        } while (simulationLength > 0);
    }
    
    public void setSimulationLength() {
        simulationLength = (int)Math.random() * 1000;
        if(simulationLength<250) {
            simulationLength=250;
        }
    }
    
    public int getSimulationLength() {
        return simulationLength;
    }
}
