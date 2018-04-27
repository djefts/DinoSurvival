import java.util.Scanner;

public class Usersaurus extends Dinosaur {
    
    public Usersaurus(int x, int y) {
        super(x, y);
        addHealth(5);
    }
    
    public Usersaurus() {
    }
    
    //TODO: Put in for loop once excel file is read
    //TODO: Figure out how to fix Scanner
    public static void main(String[] args) {
        
        // Create a scanner for command line input
        Scanner in = new Scanner(System.in);
        Usersaurus usersaurus = new Usersaurus();
        int statArray[] = new int[12];
        do {
            
            //Name Dinosaur
            System.out.println("Name your Dinosaur: ");
            String name = in.next();
            
            //prompt for stat speed
            System.out.print("Please enter Speed: ");
            int speed;
            speed = usersaurus.checkInt(in);
            speed = usersaurus.betweenValueCheck(speed, in, 1, 10);
            statArray[0] = speed;
            if(!usersaurus.rangeCheck(statArray, 0))
                break;
            
            
            //prompt for stat Attack
            System.out.println("Please enter Attack: ");
            int attack;
            attack = usersaurus.checkInt(in);
            attack = usersaurus.betweenValueCheck(attack, in, 1, 10);
            statArray[1] = attack;
            if(!usersaurus.rangeCheck(statArray, 1))
                break;
            
            //prompt for stat Defense
            System.out.println("Please enter Defense: ");
            int defense;
            defense = usersaurus.checkInt(in);
            defense = usersaurus.betweenValueCheck(defense, in, 1, 10);
            statArray[2] = defense;
            if(!usersaurus.rangeCheck(statArray, 2))
                break;
            
            //prompt for stat Food before full
            System.out.println("Please enter amount of Food before full: ");
            int foodStorage;
            foodStorage = usersaurus.checkInt(in);
            foodStorage = usersaurus.betweenValueCheck(foodStorage, in, 1, 10);
            statArray[3] = foodStorage;
            if(!usersaurus.rangeCheck(statArray, 3))
                break;
            
            //prompt for stat Water before full
            System.out.println("Please enter amount of Water before full: ");
            int waterStorage;
            waterStorage = usersaurus.checkInt(in);
            waterStorage = usersaurus.betweenValueCheck(waterStorage, in, 1, 10);
            statArray[4] = waterStorage;
            if(!usersaurus.rangeCheck(statArray, 4))
                break;
            
            //prompt for stat Number of kids when reproducing
            System.out.println("Please enter number of Kids when reproducing: ");
            int kids;
            kids = usersaurus.checkInt(in);
            kids = usersaurus.betweenValueCheck(kids, in, 1, 10);
            statArray[5] = kids;
            if(!usersaurus.rangeCheck(statArray, 5))
                break;
            
            //prompt for stat amount of food to reproduces
            System.out.println("Please enter the amount of food to reproduce: ");
            int foodToReproduce;
            foodToReproduce = usersaurus.checkInt(in);
            foodToReproduce = usersaurus.betweenValueCheck(foodToReproduce, in, 1, 10);
            statArray[6] = foodToReproduce;
            if(!usersaurus.rangeCheck(statArray, 6))
                break;
            
            //prompt for stat Turns without food
            System.out.println("Please enter turns without food: ");
            int turnsWithoutFood;
            turnsWithoutFood = usersaurus.checkInt(in);
            turnsWithoutFood = usersaurus.betweenValueCheck(turnsWithoutFood, in, 1, 10);
            statArray[7] = turnsWithoutFood;
            if(!usersaurus.rangeCheck(statArray, 7))
                break;
            
            //prompt for stat for Max Age
            System.out.println("Please enter Max Age: ");
            int maxAge;
            maxAge = usersaurus.checkInt(in);
            maxAge = usersaurus.betweenValueCheck(maxAge, in, 1, 10);
            statArray[8] = maxAge;
            if(!usersaurus.rangeCheck(statArray, 8))
                break;
            
            //prompt for stat for Diet Type
            System.out.println("Please enter Diet Type: Carnivore = 0 | Herbivore = 1");
            int type;
            type = usersaurus.checkInt(in);
            type = usersaurus.betweenValueCheck(type, in, 0, 1);
            statArray[9] = type;
            if(!usersaurus.rangeCheck(statArray, 9))
                break;
            
            //prompt for stat for Herd
            System.out.println("Please enter Herd type: No Herd = 0 | Herd = 1");
            int herd;
            herd = usersaurus.checkInt(in);
            herd = usersaurus.betweenValueCheck(herd, in, 0, 1);
            statArray[10] = herd;
            if(!usersaurus.rangeCheck(statArray, 10))
                break;
            
            //prompt for stat for Territorial
            System.out.println("Please enter whether it is territorial: Not Territorial = 0 | Territorial= 1");
            int territorial;
            territorial = usersaurus.checkInt(in);
            territorial = usersaurus.betweenValueCheck(territorial, in, 0, 1);
            statArray[11] = territorial;
            if(!usersaurus.rangeCheck(statArray, 11))
                break;
            
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
            
        } while (!usersaurus.rangeCheck(statArray, 11));
    }
    
    private int betweenValueCheck(int var, Scanner in, int minValue, int maxValue) {
        
        //if variable it NOT between 1 and 10
        while (var < minValue || var > maxValue) {
            System.out.println("Please enter a value between " + minValue + " and " + maxValue);
            
            var = checkInt(in);
            
            if(var >= 1 && var <= 10)
                return var;
            
            var = betweenValueCheck(var, in, minValue, maxValue);
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
    
    //check if sum of stats is less than 55
    private boolean rangeCheck(int statArray[], int count) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i <= count; i++) {
            sum += statArray[i];
            if(sum > 55) {
                System.out.println("The sum of all stats must not exceed 55");
                test = false;
            }
        }
        
        return test;
    }
}
