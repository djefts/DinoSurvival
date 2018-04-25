import java.util.ArrayList;
import DataIO.SimulationCount;

public class DataCollection {
	
	public static ArrayList<DataIO.SimulationCount> dinoPopData = new ArrayList<SimulationCount>();
	
	public static void collect(SimulationManager simMan) {	
		
		/*when simTime = simulationTime -> count dinosaurs through array and store it in the ArrayList
		 * dinoPopData-> dinosaur population data.
		 * Running loop while simulationLength > 0 */
		
			if(simMan.getSimulationTime() % 10 == 0)
			{
				SimulationCount simC = new SimulationCount();
				simC.countTr = dinoSimCount(simMan, "Triceratop");
				dinoPopData.add(simC);
			}
	}
	
	//method to count dinosaurs alive at certain increments in time

	public static int dinoSimCount(SimulationManager simMan, String name)
	{ 
		int count = 0;
		for(Dinosaur d : simMan.getDinosaurs())
		{
			if (d.getSpecies() == name)
				count++;
		}
		return count;
	}
 
}
