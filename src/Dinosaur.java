import java.util.ArrayList;

import static java.lang.Double.MAX_VALUE;

public class Dinosaur implements Positionable {
    private int health;             //health of the dinosaur
    private int speed;              //how far a dino can move in one "turn"
    private int attack;             //attack of the dino, compared to defense
    private int defense;            //defense of the dino, used when being attacked
    private int foodStorage;        //how much food the dino can hold before it is 'full'
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
    
    public Dinosaur() {
    
    }
    public Dinosaur(int xLoc, int yLoc) {
        setxLoc(xLoc);
        setyLoc(yLoc);
    }
    
    public void defaultStats() {
        setHealth(10);
        setSpeed(10);
        setAttack(5);
        setDefense(5);
        setFoodStorage(7);
        setWaterStorage(7);
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
    }
    
    public int getHealth() {
        return health;
    }
    
    void setHealth(int health) {
        this.health = health;
    }
    
    private int getSpeed() {
        return speed;
    }
    
    void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getAttack() {
        return attack;
    }
    
    void setAttack(int attack) {
        this.attack = attack;
    }
    
    public int getDefense() {
        return defense;
    }
    
    void setDefense(int defense) {
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
                this.herbivore=true;
                break;
            case 1:
                this.herbivore=false;
                break;
            default:
                this.herbivore=true;
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
    
    public Dinosaur closestDinosaur(ArrayList<Dinosaur> dinosaurs) {
        Dinosaur closestDinosaur = null;
        double distance;
        double minDistance = MAX_VALUE;
        
        for (Dinosaur dinosaur : dinosaurs) {
            distance = distanceTo(dinosaur);
            if(distance < minDistance) {
                closestDinosaur = dinosaur;
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
        if(foodStorage >= waterStorage && foodStorage != 0) {   //i need 2 eets da foodies
            if(isHerbivore()) {                 //i eet grassies
                return closestGrass(grasses);
            } else {                            //i eet dinoes
                return closestDinosaur(dinosaurs);
            }
        } else {                            //i'm thirsty
            return closestWater(waters);
        }
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
        
        setxLoc(xLocFood);
        setyLoc(yLocFood);
    
        switch (food.getName()) {
            case "grass":
                //grass just got eaten. it now has to regrow
                grasses.get(grasses.indexOf(food)).setGrowthStage(0);
                break;
            case "water":
                //you gots to do nothing. water doesn't go away
                break;
            case "dinosaur":
                //remove the dinosaur you just ate
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
    
    public String getName() {
        return "dinosaur";
    }
    
    public String toString() {
        String output = "DINOSAUR- ";
        if(herbivore) {
            output += "Herbivore\t";
        } else {
            output += "Carnivore\t";
        }
        output += "(" + getxLoc() + ", " + getyLoc() + ")";
        return output;
    }
}