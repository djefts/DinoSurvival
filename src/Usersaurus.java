import java.util.Scanner;


public class Usersaurus {
    //TODO: Put in for loop once excel file is read
    //TODO: Figure out how to fix Scanner
    public static void main(String[] args) {
        
        Dinosaur dino = new Dinosaur();
        // Create a scanner for command line input
        Scanner in = new Scanner(System.in);
        Usersaurus usersaurus = new Usersaurus();
        
        //prompt for stat speed
        System.out.print("Please enter Speed: ");
        int speed;
        speed = usersaurus.checkInt(in);
        speed = usersaurus.betweenValueCheck(speed, in);
        
        //prompt for stat Attack
        System.out.println("Please enter Attack: stat between 1 and 10");
        int attack;
        attack = usersaurus.checkInt(in);
        attack = usersaurus.betweenValueCheck(attack, in);
        
        //prompt for stat Defense
        System.out.println("Please enter Defense: stat between 1 and 10");
        int defense;
        defense = usersaurus.checkInt(in);
        defense = usersaurus.betweenValueCheck(defense, in);
        
        
        //prompt for stat Food before full
        System.out.println("Please enter amount of Food before full: stat between 1 and 10");
        int foodStorage;
        foodStorage = usersaurus.checkInt(in);
        foodStorage = usersaurus.betweenValueCheck(foodStorage, in);
        
        //prompt for stat Water before full
        System.out.println("Please enter amount of Water before full: stat between 1 and 10");
        int waterStorage;
        waterStorage = usersaurus.checkInt(in);
        waterStorage = usersaurus.betweenValueCheck(waterStorage, in);
        
        //prompt for stat Number of kids when reproducing
        System.out.println("Please enter number of Kids when reproducing: stat between 1 and 10");
        int kids;
        kids = usersaurus.checkInt(in);
        kids = usersaurus.betweenValueCheck(kids, in);
        
        //prompt for stat amount of food to reproduces
        System.out.println("Please enter the amount of food to reproduce: stat between 1 and 10");
        int foodToReproduce;
        foodToReproduce = usersaurus.checkInt(in);
        foodToReproduce = usersaurus.betweenValueCheck(foodToReproduce, in);
        
        //prompt for stat Turns without food
        System.out.println("Please enter turns without food: stat between 1 and 10");
        int turnsWithoutFood;
        turnsWithoutFood = usersaurus.checkInt(in);
        turnsWithoutFood = usersaurus.betweenValueCheck(turnsWithoutFood, in);
        
        //prompt for stat for Max Age
        System.out.println("Please enter Max Age: stat between 1 and 10");
        int maxAge;
        maxAge = usersaurus.checkInt(in);
        maxAge = usersaurus.betweenValueCheck(maxAge, in);
        
        //prompt for stat for Diet Type
        System.out.println("Please enter Diet Type: Carnivore = 0 | Herbivore = 1");
        int type;
        type = usersaurus.checkInt(in);
        type = usersaurus.betweenValueCheck2(type, in);
        
        //prompt for stat for Herd
        System.out.println("Please enter Herd type: No Herd = 0 | Herd = 1");
        int herd;
        herd = usersaurus.checkInt(in);
        herd = usersaurus.betweenValueCheck2(herd, in);
        
        //prompt for stat for Territorial
        System.out.println("Please enter whether it is territorial: Not Territorial = 0 | Territorial= 1");
        int territorial;
        territorial = usersaurus.checkInt(in);
        territorial = usersaurus.betweenValueCheck2(territorial, in);
        
        // Print Stats
        System.out.println("Speed is: " + speed);
        System.out.println("Attack is: " + attack);
        System.out.println("Defense is: " + defense);
        System.out.println("Food before full is: " + foodStorage);
        System.out.println("Water before full is: " + waterStorage);
        System.out.println("Number of Kids when reproducing is: " + kids);
        System.out.println("Amount to Food required to reproduce is: " + foodToReproduce);
        System.out.println("Turns without food is: " + turnsWithoutFood);
        System.out.println("Max Age is: " + (maxAge * 10));
        if(type == 1) {
            System.out.println("Diet Type is: Herbivore");
        } else {
            System.out.println("Diet Type is: Carnivore");
        }
        if(herd == 0) {
            System.out.println("Herd Type is: NO");
        } else {
            System.out.println("Herd Type is: YES");
            
        }
        if(territorial == 0) {
            System.out.println("Territorial is: NO");
        } else {
            System.out.println("Territorial is: YES");
        }
        
        // Close the scanner
        in.close();
        
    }
    
    private int betweenValueCheck(int var, Scanner in) {
        
        //if variable it NOT between 1 and 10
        while (var < 1 || var > 10) {
            System.out.println("Please enter a value between 1 and 10");
            //converts string to integer
            var = in.nextInt();
        }
        
        return var;
    }
    
    //Takes integer input
    private int betweenValueCheck2(int var, Scanner in) {
        
        //if variable it NOT between 1 and 10
        while (var != 0 && var != 1) {
            System.out.println("Please enter a value between 0 and 1");
            //converts input from string to integer
            var = in.nextInt();
        }
        
        return var;
    }
    
    //Checks if input is not a number
    private int checkInt(Scanner in) {
        int varOut;
        
        try {
            varOut = in.nextInt();
        } catch (Exception ex) {
            
            System.out.println("Whole Numbers Only.");
            //junk is getting rid of the bad input. It's JUNK
            String junk = in.next();
            varOut = checkInt(in);
        }
        
        return varOut;
    }
    
    /**
     * Alternative method to checkInt, betweenValueCheck and betweenValueCheck2
     * Combines the 3 methods into 1
     * Slightly more efficient, a little easier to read, and keeps Scanner local to method
     *      and making sure it is only open when necessary
     **/
    /*public int checkInput(int minValue, int maxValue) {
public class CreateDino {
	//TODO: Put in for loop once excel file is read
	//TODO: Figure out how to fix Scanner
	public static void main(String[] args) {

		// Create a scanner for command line input
		Scanner in = new Scanner(System.in);
		CreateDino createDino = new CreateDino();

		//Name Dinosaur
		System.out.println("Name your Dinosaur: ");
		String name = in.next();        

		//prompt for stat speed
		System.out.print("Please enter Speed: ");
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
		kids = createDino.betweenValueCheck(kids, in);

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
		System.out.println("Dinosaur Name: " + name);
		System.out.println("Speed is: " + speed);
		System.out.println("Attack is: " + attack);
		System.out.println("Defense is: " + defense);
		System.out.println("Food before full is: " + foodStorage);
		System.out.println("Water before full is: " + waterStorage);
		System.out.println("Number of Kids when reproducing is: " + kids);
		System.out.println("Amount to Food required to reproduce is: " + foodToReproduce);
		System.out.println("Turns without food is: " + turnsWithoutFood);
		System.out.println("Max Age is: " + (maxAge * 10));
		if(type == 1) {
			System.out.println("Diet Type is: Herbivore");
		} else {
			System.out.println("Diet Type is: Carnivore");
		}
		if(herd == 0) {
			System.out.println("Herd Type is: NO");
		} else {
			System.out.println("Herd Type is: YES");

		}
		if(territorial == 0) {
			System.out.println("Territorial is: NO");
		} else {
			System.out.println("Territorial is: YES");
		}

		// Close the scanner
		in.close();

	}

	private int betweenValueCheck(int var, Scanner in) {

		//if variable it NOT between 1 and 10
		while (var < 1 || var > 10) {
			System.out.println("Please enter a value between 1 and 10");
			
			var = checkInt(in);
			
			if (var >= 1 && var <= 10)
				return var;
			
			var = betweenValueCheck(var, in);
		}
		

		return var;
	}

	//Takes integer input
	private int betweenValueCheck2(int var, Scanner in) {

		//if variable it NOT between 1 and 10
		if (var != 0 && var != 1) {
			System.out.println("Please enter a value between 0 and 1");
			
			var = checkInt(in);
			
			if (var == 0 || var == 1)
				return var;
			
			var = betweenValueCheck2(var, in);
		
		}

		return var;
	}

	//Checks if input is not a number
	private int checkInt(Scanner in) {
		int varOut;

		try {
			varOut = in.nextInt();
		} catch (Exception ex) {

			System.out.println("Whole Numbers Only.");
			//junk is getting rid of the bad input. It's JUNK
			String junk = in.next();
			varOut = checkInt(in);
		}

		return varOut;
	}

	/**
	 * Alternative method to checkInt, betweenValueCheck and betweenValueCheck2
	 * Combines the 3 methods into 1
	 * Slightly more efficient, a little easier to read, and keeps Scanner local to method
	 *      while making sure it is only open when necessary
	 */
	/*public int checkInput(int minValue, int maxValue) {
>>>>>>> master:src/CreateDino.java
        int varOut;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number between " + minValue + " and " + maxValue);

        //make sure input value is an integer
        try {
            varOut = in.nextInt();
        } catch (InputMismatchException e) {
            //value is not an integer
            System.out.println("Whole Numbers Only!");
            String userSucks = in.next();
            in.close();
            varOut = checkInput(minValue, maxValue);
        }

        //make sure input is within bounds
        if(varOut < minValue || varOut > maxValue) {
            //input OutOfBoundsException
            in.close();
            varOut = checkInput(minValue, maxValue);
        }

        in.close();
        return varOut;
    }*/
}