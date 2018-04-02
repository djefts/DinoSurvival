import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationManagerTest {
    
    @Test
    void loop() {
        SimulationManager simulationManager = new SimulationManager(250);
        assertEquals(250, simulationManager.getSimulationLength());
        
    }
}