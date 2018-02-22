public class Dinosaur {
    private int health;
    private int speed;
    private int attack;
    private int defense;
    private int foodStorage;
    private int waterStorage;
    private int kids;
    private int foodToReproduce;
    private int turnsWithoutFood;
    private int maxAge;
    private boolean herd;
    private boolean territorial;
    private boolean herbivore;
    private int xLoc;
    private int yLoc;
    
    public Dinosaur() {
        System.out.println("hello_world");
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getSpeed() {
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
    
    public void setKids(int kids) {
        this.kids = kids;
    }
    
    public int getFoodToReproduce() {
        return foodToReproduce;
    }
    
    public void setFoodToReproduce(int foodToReproduce) {
        this.foodToReproduce = foodToReproduce;
    }
    
    public int getTurnsWithoutFood() {
        return turnsWithoutFood;
    }
    
    public void setTurnsWithoutFood(int turnsWithoutFood) {
        this.turnsWithoutFood = turnsWithoutFood;
    }
    
    public int getMaxAge() {
        return maxAge;
    }
    
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
    
    public boolean isHerd() {
        return herd;
    }
    
    public void setHerd(boolean herd) {
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
    
    public void setHerbivore(boolean herbivore) {
        this.herbivore = herbivore;
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
}