import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class DinosaurTest {
    
    ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
    ArrayList<Grass> grasses = new ArrayList<>();
    ArrayList<Water> waters = new ArrayList<>();
    
    Dinosaur dinosaur = new Dinosaur(25, 25);               //dinosaur that is used as the "current" dinosaur deciding stuff
    
    Dinosaur dinoTest1 = new Dinosaur(25, 0);               //closest test dinosaur
    Dinosaur dinoTest2 = new Dinosaur(100, 80);
    Dinosaur dinoTest3 = new Dinosaur(100, 0);
    
    Grass grassTest1 = new Grass(0, 25);                    //closest test grass
    Grass grassTest2 = new Grass(50, 50);
    Grass grassTest3 = new Grass(200, 200);
    
    Water waterTest1 = new Water(50, 25);                   //closet test water
    Water waterTest2 = new Water(100, 50);
    Water waterTest3 = new Water(200, 200);
    
    @Test
    void closestDinosaur() {
        initializeTheJunk();
        assertSame(dinosaur.closestDinosaur(dinosaurs), dinoTest1);
        assertNotSame(dinosaur.closestDinosaur(dinosaurs), dinoTest2);
        assertNotSame(dinosaur.closestDinosaur(dinosaurs), dinoTest3);
    }
    
    @Test
    void closestGrass() {
        initializeTheJunk();
        assertSame(dinosaur.closestGrass(grasses), grassTest1);/*
        assertNotSame(dinosaur.closestGrass(grasses), grassTest2);
        assertNotSame(dinosaur.closestGrass(grasses), grassTest3);*/
    }
    
    @Test
    void closestWater() {
        initializeTheJunk();
        assertSame(dinosaur.closestWater(waters), waterTest1);
        assertNotSame(dinosaur.closestWater(waters), waterTest2);
        assertNotSame(dinosaur.closestWater(waters), waterTest3);
    }
    
    @Test
    /**
     * determine what the dino should try to attack
     */
    void wut2Eat() {
        initializeTheJunk();
        dinosaur.setHerbivore(true);
        //TODO flip numbers for foodStorage and waterStorage so that high number = full and low = hungry
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(4);
        assertSame(dinosaur.wut2Eat(dinosaurs, grasses, waters), grassTest1);
        dinosaur.setHerbivore(false);
        assertSame(dinosaur.wut2Eat(dinosaurs, grasses, waters), dinoTest1);
        dinosaur.setWaterStorage(10);
        assertSame(dinosaur.wut2Eat(dinosaurs, grasses, waters), waterTest1);
    }
    
    @Test
    void move() {
        initializeTheJunk();
        
        dinosaur.setHerbivore(true);
        dinosaur.setSpeed(10);
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        dinosaur.move(dinosaurs, grasses, waters);
        assertSame(dinosaur.getxLoc(), 15);
        assertSame(dinosaur.getyLoc(), 25);
    }
    
    public void initializeTheJunk() {
        dinosaurs.add(dinoTest1);
        dinosaurs.add(dinoTest2);
        dinosaurs.add(dinoTest3);
    
        grasses.add(grassTest1);
        grasses.add(grassTest2);
        grasses.add(grassTest3);
    
        waters.add(waterTest1);
        waters.add(waterTest2);
        waters.add(waterTest3);
    }
}