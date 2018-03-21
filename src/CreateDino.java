import java.util.InputMismatchException;
import java.util.Scanner;


public class CreateDino { 
	//TODO: Put in for loop once excel file is read
	//TODO: Figure out how to fix Scanner
	public static void main(String[] args) { 

		// Create a scanner for command line input 
		Scanner in = new Scanner(System.in);
		CreateDino  createDino = new CreateDino();

		//prompt for stat speed
		System.out.println("Please enter Speed: stat between 1 and 10");
		int speed;
		speed = createDino.checkInt(in);
		speed = createDino.betweenValueCheck(speed, in);

		//prompt for stat Attack
		System.out.println("Please enter Attack: stat between 1 and 10"); 
		int attack;
		attack = createDino.checkInt(in);
		attack = createDino.betweenValueCheck(attack, in);

		//prompt for stat Defense
		System.out.println("Please enter Defense: stat between 1 and 10"); 
		int defense;
		defense = createDino.checkInt(in);
		defense = createDino.betweenValueCheck(defense, in);


		//prompt for stat Food before full
		System.out.println("Please enter amount of Food before full: stat between 1 and 10"); 
		int foodStorage;
		foodStorage = createDino.checkInt(in);
		foodStorage = createDino.betweenValueCheck(foodStorage, in);

		//prompt for stat Water before full
		System.out.println("Please enter amount of Water before full: stat between 1 and 10"); 
		int waterStorage;
		waterStorage = createDino.checkInt(in);
		waterStorage = createDino.betweenValueCheck(waterStorage, in);

		//prompt for stat Number of kids when reproducing
		System.out.println("Please enter number of Kids when reproducing: stat between 1 and 10"); 
		int kids;
		kids = createDino.checkInt(in);
		kids= createDino.betweenValueCheck(kids, in);

		//prompt for stat amount of food to reproduces 
		System.out.println("Please enter the amount of food to reproduce: stat between 1 and 10"); 
		int foodToReproduce;
		foodToReproduce = createDino.checkInt(in);
		foodToReproduce = createDino.betweenValueCheck(foodToReproduce, in);

		//prompt for stat Turns without food
		System.out.println("Please enter turns without food: stat between 1 and 10"); 
		int turnsWithoutFood;
		turnsWithoutFood = createDino.checkInt(in);
		turnsWithoutFood = createDino.betweenValueCheck(turnsWithoutFood, in);

		//prompt for stat for Max Age
		System.out.println("Please enter Max Age: stat between 1 and 10"); 
		int maxAge;
		maxAge = createDino.checkInt(in);
		maxAge = createDino.betweenValueCheck(maxAge, in);

		//prompt for stat for Diet Type
		System.out.println("Please enter Diet Type: Carnivore = 0 | Herbivore = 1"); 
		int type;
		type = createDino.checkInt(in);
		type = createDino.betweenValueCheck2(type, in);

		//prompt for stat for Herd
		System.out.println("Please enter Herd type: No Herd = 0 | Herd = 1"); 
		int herd;
		herd = createDino.checkInt(in);
		herd = createDino.betweenValueCheck2(herd, in);

		//prompt for stat for Territorial
		System.out.println("Please enter whether it is territorial: Not Territorial = 0 | Territorial= 1"); 
		int territorial;
		territorial = createDino.checkInt(in);
		territorial = createDino.betweenValueCheck2(territorial, in);

		// Print Stats
		System.out.println("Speed is: " + speed);
		System.out.println("Attack is: " + attack);
		System.out.println("Defense is: " + defense);
		System.out.println("Food before full is: " + foodStorage);
		System.out.println("Water before full is: " + waterStorage);
		System.out.println("Number of Kids when reproducing is: " + kids);
		System.out.println("Amount to Food required to reproduce is: " + foodToReproduce);
		System.out.println("Turns without food is: " + turnsWithoutFood);
		System.out.println("Max Age is: " + (maxAge*10));
		if (type == 1)
		{
			System.out.println("Diet Type is: Herbivore");
		}
		else
		{
			System.out.println("Diet Type is: Carnivore");
		}
		if (herd == 0)
		{
			System.out.println("Herd Type is: NO");
		}
		else
		{
			System.out.println("Herd Type is: YES");

		}
		if (territorial == 0)
		{
			System.out.println("Territorial is: NO");
		}
		else
		{
			System.out.println("Territorial is: YES");
		}

		// Close the scanner 
		in.close(); 

	} 

	private int betweenValueCheck(int var, Scanner in)
	{

		//if variable it NOT between 1 and 10
		while ( var < 1 || var > 10)
		{
			System.out.println("Please enter a value between 1 and 10");
			//converts string to integer
			var = in.nextInt();
		} 

		return  var;
	}

	//Takes integer input
	private int betweenValueCheck2(int var, Scanner in)
	{

		//if variable it NOT between 1 and 10
		while (var != 0 && var != 1)
		{
			System.out.println("Please enter a value between 0 and 1");
			//converts input from string to integer
			var = in.nextInt();
		}

		return  var;
	}
	//Checks if input is not a number
	private int checkInt(Scanner in)
	{
		int varOut;
		
		try{
		    varOut = in.nextInt();
		}catch (Exception ex) {

			System.out.println("Whole Numbers Only.");
			//junk is getting rid of the bad input. It's JUNK
			String junk = in.next();
			varOut = checkInt(in);
		}
		
		return varOut;	
	}

}