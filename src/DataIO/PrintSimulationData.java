package DataIO;

import java.util.Scanner;
//import DataIO.SimulationCount;

public class PrintSimulationData {
	//variable declaration
	
	public static void printing(DataCollection dataCollect) {
		/*prompt user to choice between viewing ALL data
		 * viewing all dinosaurs at a specified time userTime
		 * viewing one dinosaurs over time */

		//Prompt for a choice then Check to make sure they entered either a 1 2 3 or 4
		Scanner in = new Scanner(System.in);

		int value = 5;
		int choice = checkChoice(value);


		if( choice == 1)
		{
			//print ALL data method
			printAllDinos(dataCollect);
		}
		if(choice == 2)
		{
			//Prompt user for time and call printAtUserTime
			int userTime  = 0;
			userTime = checkUserTime(userTime);

			printAtUserTime(dataCollect, userTime);
		}
		if(choice == 3)
		{
			//Prompt user for dinosaur name then call printDinoOverTime
			System.out.print("Please enter a Dinosaur: ");
			String userName = in.nextLine();

			printDinoOverTime(dataCollect, userName);	
		}
		if(choice == 4)
		{
			System.out.print("Goodbye");
		}


		in.close();

	}

	//need a method to print ALL the dinosaurs and times.
	public static void printAllDinos(DataCollection dataCollect)
	{
		for(SimulationCount c : dataCollect.getSimulationCount())
		{
			System.out.println("Population count of Dinosaurs at time: " + c.simTime);
			System.out.println("Usersaurus: " + c.countUser);
			System.out.println("Triceratop: " + c.countTri);
			System.out.println("Tyrannosaurus: " + c.countTrex);
			System.out.println("Stegosaurus: " + c.countSteg);
			System.out.println("Velociraptor: " + c.countVel);
			System.out.println("Dilophosaurus: " + c.countDil);
			System.out.println("Brachiosaurus: " + c.countBrach);
			System.out.println("Pterodactyl: " + c.countPtero);
			System.out.println("Pachycephalosaurus: " + c.countPach);
			System.out.println("Spinosaurus: " + c.countSpino);
			System.out.println("Parasaurolophus: " + c.countPara);
			System.out.println("Ankylosaurus: " + c.countAnkyl);
			System.out.println("Apatosaurus: " + c.countApa);	
		}

	}

	//need a method to print all the dinosaurs pop at a specified time userTime
	public static void printAtUserTime(DataCollection dataCollect, int userTime)
	{
		for(SimulationCount c : dataCollect.getSimulationCount())
		{
			//TODO: If the times aren't matched, find closest simTime then roll with that data
			if (c.simTime == userTime)
			{
				System.out.println("Population count of Dinosaurs at time: " + c.simTime);
				System.out.println("Usersaurus: " + c.countUser);
				System.out.println("Triceratop: " + c.countTri);
				System.out.println("Tyrannosaurus: " + c.countTrex);
				System.out.println("Stegosaurus: " + c.countSteg);
				System.out.println("Velociraptor: " + c.countVel);
				System.out.println("Dilophosaurus: " + c.countDil);
				System.out.println("Brachiosaurus: " + c.countBrach);
				System.out.println("Pterodactyl: " + c.countPtero);
				System.out.println("Pachycephalosaurus: " + c.countPach);
				System.out.println("Spinosaurus: " + c.countSpino);
				System.out.println("Parasaurolophus: " + c.countPara);
				System.out.println("Ankylosaurus: " + c.countAnkyl);
				System.out.println("Apatosaurus: " + c.countApa);
			}
		}

	}

	//need a method to print a single dinosaur at simTime till the end.
	public static void printDinoOverTime(DataCollection dataCollect, String name)
	{
		for(SimulationCount c : dataCollect.getSimulationCount())
		{
			if(name  == "Usersaurus")
				System.out.println("At time: " + c.simTime + " The Usersaurs Population is: " + c.countUser);
			if(name == "Triceratop")
				System.out.println("At time: " + c.simTime + " The Triceratop Population is: " + c.countTri);
			if(name == "Tyrannosaurus")
				System.out.println("At time: " + c.simTime + " The Tyrannosaurus Population is: " + c.countTrex);
			if(name == "Stegosaurus")
				System.out.println("At time: " + c.simTime + " The Stegosaurus Population is: " + c.countSteg);
			if(name == "Velociraptor")
				System.out.println("At time: " + c.simTime + " The Velociraptor Population is: " + c.countVel);
			if(name == "Dilophosaurus")
				System.out.println("At time: " + c.simTime + " The Dilophosaurus Population is: " + c.countDil);
			if(name == "Brachiosaurus")
				System.out.println("At time: " + c.simTime + " The Brachiosaurus Population is: " + c.countBrach);
			if(name == "Pterodactyl")
				System.out.println("At time: " + c.simTime + " The Pterodactyl Population is: " + c.countPtero);
			if(name == "Pachycephalosaurus")
				System.out.println("At time: " + c.simTime + " The Pachycephalosaurus Population is: " + c.countPach);
			if(name == "Spinosaurus")
				System.out.println("At time: " + c.simTime + " The Spinosaurus Population is: " + c.countSpino);
			if(name == "Parasaurolophus")
				System.out.println("At time: " + c.simTime + " The Parasaurolophus Population is: " + c.countPara);
			if(name == "Ankylosaurus")
				System.out.println("At time: " + c.simTime + " The Ankylosaurus Population is: " + c.countAnkyl);
			if(name == "Apatosaurus")
				System.out.println("At time: " + c.simTime + " The Spinosaurus Population is: " + c.countApa);
		}
	}

	public static int checkChoice(int value)
	{
		Scanner in = new Scanner(System.in);

		while(value != 1 && value != 2 && value != 3 && value != 4)
		{
			System.out.println("If you would like to view ALL data, enter 1 "
					+ "If you would like to view all dinosuar populations at a specific time, enter 2 "
					+ "If you would like to view a single dinosaur population over time, enter 3 "
					+ "If you would like to not view any data and end the simulation, enter 4: ");
			value = in.nextInt();		
			value = checkChoice(value);
		}
		in.close();

		return value;
	}
	//Make sure the simulation time entered is between 250 and 5000
	public static int checkUserTime(int userTime)
	{
		Scanner in = new Scanner(System.in);
		
		while(userTime < 250 || userTime > 5000)
		{
			System.out.println("Enter a simulation time between 250 and 5000");
			userTime = in.nextInt();
			userTime = checkUserTime(userTime);
		}
		in.close();
		
		return userTime;
	}

}