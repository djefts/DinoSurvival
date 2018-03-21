import java.util.Scanner;


public class createDino { 
	//TODO: Put in for loop once excel file is read
	public static void main(String[] args) { 

		// Create a scanner for command line input 
		Scanner in = new Scanner(System.in); 

		//prompt for stat speed
		System.out.println("Please enter Speed: stat between 1 and 10"); 
		String speed = in.nextLine(); 
		speed = Integer.toString(betweenValueCheck(Integer.parseInt(speed)));

		//prompt for stat Attack
		System.out.println("Please enter Attack: stat between 1 and 10"); 
		String attack = in.nextLine();
		attack= Integer.toString(betweenValueCheck(Integer.parseInt(attack)));

		//prompt for stat Defense
		System.out.println("Please enter Defense: stat between 1 and 10"); 
		String defense = in.nextLine();
		defense = Integer.toString(betweenValueCheck(Integer.parseInt(defense)));


		//prompt for stat Food before full
		System.out.println("Please enter amount of Food before full: stat between 1 and 10"); 
		String foodStorage = in.nextLine();
		foodStorage = Integer.toString(betweenValueCheck(Integer.parseInt(foodStorage)));

		//prompt for stat Water before full
		System.out.println("Please enter amount of Water before full: stat between 1 and 10"); 
		String waterStorage = in.nextLine();
		waterStorage = Integer.toString(betweenValueCheck(Integer.parseInt(waterStorage)));

		//prompt for stat Number of kids when reproducing
		System.out.println("Please enter number of Kids when reproducing: stat between 1 and 10"); 
		String kids = in.nextLine();
		kids = Integer.toString(betweenValueCheck(Integer.parseInt(kids)));

		//prompt for stat amount of food to reproduces 
		System.out.println("Please enter the amount of food to reproduce: stat between 1 and 10"); 
		String foodToReproduce = in.nextLine();
		foodToReproduce = Integer.toString(betweenValueCheck(Integer.parseInt(foodToReproduce)));

		//prompt for stat Turns without food
		System.out.println("Please enter turns without food: stat between 1 and 10"); 
		String turnsWithoutFood = in.nextLine();
		turnsWithoutFood = Integer.toString(betweenValueCheck(Integer.parseInt(turnsWithoutFood)));

		//prompt for stat for Max Age
		System.out.println("Please enter Max Age: stat between 1 and 10"); 
		String maxAge = in.nextLine();
		maxAge = Integer.toString(betweenValueCheck2(Integer.parseInt(maxAge)));

		//prompt for stat for Diet Type
		System.out.println("Please enter Diet Type: Herbivore = 0 | Carnivore = 1"); 
		String type= in.nextLine();
		type = Integer.toString(betweenValueCheck2(Integer.parseInt(type)));

		//prompt for stat for Herd
		System.out.println("Please enter Herd type: No Herd = 0 | Herd = 1"); 
		String herd= in.nextLine();
		herd = Integer.toString(betweenValueCheck2(Integer.parseInt(herd)));

		//prompt for stat for Territorial
		System.out.println("Please enter whether it is territorial: Not Territorial = 0 | Territorial= 1"); 
		String territorial= in.nextLine();
		territorial = Integer.toString(betweenValueCheck2(Integer.parseInt(territorial)));


		// Print Stats
		System.out.println("Speed is: " + speed);
		System.out.println("Attack is: " + attack);
		System.out.println("Defense is: " + defense);
		System.out.println("Food before full is: " + foodStorage);
		System.out.println("Water before full is: " + waterStorage);
		System.out.println("Number of Kids when reproducing is: " + kids);
		System.out.println("Amount to Food required to reproduce is: " + foodToReproduce);
		System.out.println("Turns without food is: " + turnsWithoutFood);
		System.out.println("Max Age is: " + maxAge);
		System.out.println("Diet Type is: " + type);
		System.out.println("Herd Type is: " + herd);
		System.out.println("Herd Type is: " + territorial);


		// Close the scanner 
		in.close(); 

	} 

	//Takes a integer input
	//TODO: Do I need to input the scanner
	private static int betweenValueCheck(int var)
	{
		// Create a scanner for command line input 
		Scanner in = new Scanner(System.in);
		
		//if variable it NOT between 1 and 10
		if ( var < 1 || var > 10)
		{
			System.out.println("Please enter a value between 1 and 10");
			//converts string to integer
			var = Integer.parseInt(in.nextLine());
		} 
		
		return  var;
	}
	
	//Takes integer input
	private static int betweenValueCheck2(int var)
	{
		// Create a scanner for command line input 
		Scanner in = new Scanner(System.in);
		
		//if variable it NOT between 1 and 10
		if ( var != 0 && var != 1)
		{
			System.out.println("Please enter a value between 0 and 1");
			//converts input from string to integer
			var = Integer.parseInt(in.nextLine());
		}

		return  var;
	}
	
	private int takeNextInt() {
	    Scanner in = new Scanner(System.in);
	    int passedInt = 0;
	    System.out.println("Enter a number 0 through 10:");
	    try {
	        passedInt = in.nextInt();
        } catch (Exception e) {
	        System.out.println("Numbers only please!");
	        takeNextInt();
        }
        in.close();
        return passedInt;
    }
}
