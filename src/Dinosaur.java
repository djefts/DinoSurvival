import java.util.ArrayList;

import static java.lang.Double.MAX_VALUE;

public class Dinosaur implements Positionable {
    private int health;             //current health of the dinosaur
    private int maxHealth = 10;     //max health of the dinosaur
    private int speed;              //how far a dino can move in one "turn"
    private int attack;             //attack of the dino, compared to defense
    private int defense;            //defense of the dino, used when being attacked
    private int curFood;            //amount of food the dino currently has
    private int foodStorage;        //how much food the dino can hold before it is 'full'
    private int curWater;           //how much water the dino currently has
    private int waterStorage;       //how much water the dino can hold before it is 'full'
    private int kids;               //how many kids are created when the dino reproduces
    private int foodToReproduce;    //how much food a dino uses when reproducing
    //TODO: change turnsWithoutFood to health lost per turn without food?
    private int turnsWithoutFood;   //how many turn a dino will last without food
    private int maxAge;             //total turns a dino may be alive for
    private boolean herd;           //does the dino move in a pack
    private boolean territorial;    //does the dino create a territory and stay in it
    private boolean herbivore;      //does dino eat plants or meat? true=plants false = meat
    private double visionLength;    //distance a dino can see
    private int radius;             //radius of the dino when placed on the field
    private int xLoc;               //current x pixel location of the dino
    private int yLoc;               //current y pixel location of the dino
    
    private ArrayList<Dinosaur> badDinos = new ArrayList<>();
    
    public Dinosaur(){}
    
    public Dinosaur(int xLoc, int yLoc) {
        addFood(getFoodStorage() / 2);
        addWater(getWaterStorage() / 2);
        setxLoc(xLoc);
        setyLoc(yLoc);
    }
    
    public void defaultStats() {
        addHealth(10);
        setSpeed(10);
        setAttack(5);
        setDefense(5);
        setFoodStorage(10);
        setWaterStorage(10);
        setCurFood(5);
        setCurWater(5);
        setKids(5);
        setFoodToReproduce(5);
        setTurnsWithoutFood(10);
        setMaxAge(20);
        setHerd(false);
        setTerritorial(false);
        setHerbivore(0);
        setVisionLength(50);
        setRadius(5);
        setxLoc(0);
        setyLoc(0);
        badDinos = new ArrayList<>();
    }
    
    public int getHealth() {
        return health;
    }
    
    public void addHealth(int added) {
        this.health += added;
        if(this.health > maxHealth) {
            this.health = maxHealth;
        }
    }
    
    private int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getAttack() {
        return attack;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public int getDefense() {
        return defense;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public int getFoodStorage() {
        return foodStorage;
    }
    
    public void setFoodStorage(int foodStorage) {
        this.foodStorage = foodStorage;
    }
    
    public int getWaterStorage() {
        return waterStorage;
    }
    
    public void setWaterStorage(int waterStorage) {
        this.waterStorage = waterStorage;
    }
    
    public int getKids() {
        return kids;
    }
    
    private void setKids(int kids) {
        this.kids = kids;
    }
    
    public int getFoodToReproduce() {
        return foodToReproduce;
    }
    
    private void setFoodToReproduce(int foodToReproduce) {
        this.foodToReproduce = foodToReproduce;
    }
    
    public int getTurnsWithoutFood() {
        return turnsWithoutFood;
    }
    
    private void setTurnsWithoutFood(int turnsWithoutFood) {
        this.turnsWithoutFood = turnsWithoutFood;
    }
    
    public int getMaxAge() {
        return maxAge;
    }
    
    private void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
    
    public boolean isHerd() {
        return herd;
    }
    
    private void setHerd(boolean herd) {
        this.herd = herd;
    }
    
    public boolean isTerritorial() {
        return territorial;
    }
    
    public void setTerritorial(boolean territorial) {
        this.territorial = territorial;
    }
    
    public boolean isHerbivore() {
        return herbivore;
    }
    
    public void setHerbivore(int herbivore) {
        switch (herbivore) {
            case 0:
                this.herbivore = true;
                break;
            case 1:
                this.herbivore = false;
                break;
            default:
                this.herbivore = true;
                break;
            
        }
    }
    
    public int getxLoc() {
        return xLoc;
    }
    
    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }
    
    public int getyLoc() {
        return yLoc;
    }
    
    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }
    
    public double getVisionLength() {
        return visionLength;
    }
    
    private void setVisionLength(double visionLength) {
        this.visionLength = visionLength;
    }
    
    public int getRadius() {
        return radius;
    }
    
    private void setRadius(int radius) {
        this.radius = radius;
    }
    
    public int getCurFood() {
        return curFood;
    }
    
    public void setCurFood(int curFood) {
        this.curFood = curFood;
    }
    
    public void addFood(int curFood) {
        this.curFood += curFood;
        if(curFood > foodStorage) {
            this.curFood = foodStorage;
        }
    }
    
    public int getCurWater() {
        return curWater;
    }
    
    public void setCurWater(int curWater) {
        this.curWater = curWater;
    }
    
    public void addWater(int curWater) {
        this.curWater += curWater;
        if(curWater > waterStorage) {
            this.curWater = waterStorage;
        }
    }
    
    public void loseHealth() {
        if(curFood == 0) {
            turnsWithoutFood--;
        }
        if(turnsWithoutFood <= 0) {
            health--;
        }
    }
    
    public Dinosaur closestDinosaur(ArrayList<Dinosaur> dinosaurs) {
        Dinosaur closestDinosaur = null;
        double distance;
        double minDistance = MAX_VALUE;
        
        for (Dinosaur dino : dinosaurs) {
            distance = distanceTo(dino);
            if(distance < minDistance && badDinos.indexOf(dino) == -1) {
                closestDinosaur = dino;
                minDistance = Double.min(minDistance, distance);
            }
        }
        return closestDinosaur;
    }
    
    public Grass closestGrass(ArrayList<Grass> grasses) {
        Grass closestGrass = null;
        double distance;
        double minDistance = MAX_VALUE;
        
        for (Grass grass : grasses) {
            distance = distanceTo(grass);
            if(distance < minDistance && grass.getGrowthStage() == 4) {
                closestGrass = grass;
                minDistance = Double.min(minDistance, distance);
            }
        }
        return closestGrass;
    }
    
    public Water closestWater(ArrayList<Water> waters) {
        Water closestWater = null;
        double distance;
        double minDistance = MAX_VALUE;
        
        for (Water water : waters) {
            distance = distanceTo(water);
            if(distance < minDistance) {
                closestWater = water;
                minDistance = Double.min(minDistance, distance);
            }
        }
        return closestWater;
    }
    
    public Positioned wut2Eat(ArrayList<Dinosaur> dinosaurs, ArrayList<Grass> grasses, ArrayList<Water> waters) { //0=dino 1=grass for food type
        if(curFood <= curWater && curFood != foodStorage) { //i need 2 eets da foodies
            return findFood(dinosaurs, grasses, waters);
        } else if(curWater != waterStorage) {               //i is thirsty
            return closestWater(waters);
        } else {                                            //i gud :)
            return null;
        }
    }
    
    public Positioned findFood(ArrayList<Dinosaur> dinosaurs, ArrayList<Grass> grasses, ArrayList<Water> waters) {
        if(isHerbivore()) {                         //i need 2 eet grassies
            return closestGrass(grasses);
        } else {
            return closestDinosaur(dinosaurs);
        }
    }
    
    public Positioned findWater(ArrayList<Dinosaur> dinosaurs, ArrayList<Grass> grasses, ArrayList<Water> waters) {
        return closestWater(waters);
    }
    
    public boolean inRange(Positioned source) {
        int distance = distanceTo(source);
        return distance <= visionLength;
    }
    
    public void move(ArrayList<Dinosaur> dinosaurs, ArrayList<Grass> grasses, ArrayList<Water> waters) {
        Positioned food = wut2Eat(dinosaurs, grasses, waters);
        try { //to find food
            if(distanceTo(food) <= getSpeed()) {    //can move to food in one turn
                moveInRange(dinosaurs, grasses, waters);
            } else {
                moveOutRange(dinosaurs, grasses, waters);
            }
        } catch (NullPointerException e) { //didn't find any food :(
            //TODO make the dino search for alternate food source
            //TODO make the dino wander if truly no food
            //not yet moving
            setxLoc(getxLoc());
            setyLoc(getyLoc());
        }
    }
    
    private void moveInRange(ArrayList<Dinosaur> dinosaurs, ArrayList<Grass> grasses, ArrayList<Water> waters) {
        Positioned food = wut2Eat(dinosaurs, grasses, waters);      //searching out target...
        
        int xLocFood = food.getxLoc();
        int yLocFood = food.getyLoc();
        
        this.setxLoc(xLocFood);
        this.setyLoc(yLocFood);
        
        switch (food.getName()) {
            case "grass":
                //grass just got eaten. it now has to regrow
                System.out.println(this + " just ate " + food + "!");
                grasses.get(grasses.indexOf(food)).setGrowthStage(1);
                this.addHealth(4);
                this.addFood(4);
                break;
            case "water":
                //you gots to do nothing. water doesn't go away
                System.out.println(this + " just drank " + food + "!");
                this.addHealth(2);
                this.addWater(4);
                break;
            case "dinosaur":
                //remove the dinosaur you just ate
                System.out.println(this + " just tried to eat " + food + "!");
                battle(dinosaurs.get(dinosaurs.indexOf(food)));
                dinosaurs.remove(food);
                break;
        }
    }
    
    private void moveOutRange(ArrayList<Dinosaur> dinosaurs, ArrayList<Grass> grasses, ArrayList<Water> waters) {
        Positioned food = wut2Eat(dinosaurs, grasses, waters);      //searching out target...
        
        //if there is not a valid food source found then the next 2 lines will throw a NullPointerException
        int xLocFood = food.getxLoc();
        int yLocFood = food.getyLoc();
        
        int newXLoc;
        int newYLoc;
        double dx = xLocFood - getxLoc();   //total x distance to food
        double dy = yLocFood - getyLoc();   //total y distance to food
        double theta = Math.atan(dy / dx);      //θ = arctan(dy/dx)
        
        //rounding for accuracy
        newXLoc = (int) Math.round(getSpeed() * Math.cos(theta));   //x=speed*cos(θ)
        newYLoc = (int) Math.round(getSpeed() * Math.sin(theta));   //y=speed*sin(θ)
        
        setxLoc(getxLoc() + newXLoc);                           //newX = x+moveX
        setyLoc(getyLoc() + newYLoc);                           //newY = y+moveY
    }
    
    private void battle(Dinosaur dino) {
        //attack vs defense
        int dH = this.getAttack() - dino.getDefense();
        if(dH > 0) {        //dinosaur's attack is greater than the other guy's defense
            System.out.println("\t" + dino + " just lost " + dH + " health!");
            dino.addHealth(dH);
        } else if(dH < 0) {   //defender has the big defense
            System.out.println("\t" + this + " just lost " + dH + " health!");
            this.addHealth(dH);
            badDinos.add(dino);
        }
    }
    
    public void timeToReproduce() {
    
    }
    
    public String getName() {
        return "dinosaur";
    }
    
    public String toString() {
        String output = "DINOSAUR "+health;
        /*if(herbivore) {
            output += "Herbivore\t";
        } else {
            output += "Carnivore\t";
        }*/
        output += " (" + getxLoc() + ", " + getyLoc() + ")";
        return output;
    }
}