import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class DinosaurTest {
    
    ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
    ArrayList<Grass> grasses = new ArrayList<>();
    ArrayList<Water> waters = new ArrayList<>();
    
    Dinosaur dinosaur = new Dinosaur(0, 0);               //dinosaur that is used as the "current" dinosaur deciding stuff
    
    Dinosaur dinoTest1 = new Dinosaur(25, 0);               //closest test dinosaur
    Dinosaur dinoTest2 = new Dinosaur(15, 20);              //second closest dino
    Dinosaur dinoTest3 = new Dinosaur(40, 20);
    
    Grass grassTest1 = new Grass(0, 25);                    //closest test grass
    Grass grassTest2 = new Grass(50, 50);
    Grass grassTest3 = new Grass(-25, 25);
    
    Water waterTest1 = new Water(0, -25);                   //closet test water
    Water waterTest2 = new Water(-30, -5);
    Water waterTest3 = new Water(5, -25);
    
    @Test
    void closestDinosaur() {
        instantiation();
        
        assertSame(dinoTest1, dinosaur.closestDinosaur(dinosaurs));
        assertNotSame(dinoTest2, dinosaur.closestDinosaur(dinosaurs));
        assertNotSame(dinoTest3, dinosaur.closestDinosaur(dinosaurs));
    }
    
    @Test
    void closestGrass() {
        instantiation();
        
        assertSame(grassTest1, dinosaur.closestGrass(grasses));
        assertNotSame(grassTest2, dinosaur.closestGrass(grasses));
        assertNotSame(grassTest3, dinosaur.closestGrass(grasses));
    }
    
    @Test
    void closestWater() {
        instantiation();
        
        assertSame(waterTest1, dinosaur.closestWater(waters));
        assertNotSame(waterTest2, dinosaur.closestWater(waters));
        assertNotSame(waterTest3, dinosaur.closestWater(waters));
    }
    
    @Test
    /**
     * determine what the dino should try to attack
     */
    void wut2Eat() {
        instantiation();
        
        dinosaur.setHerbivore(true);
        //TODO flip numbers for foodStorage and waterStorage so that high number = full and low = hungry
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(4);
        assertSame(grassTest1, dinosaur.wut2Eat(dinosaurs, grasses, waters));
        dinosaur.setHerbivore(false);
        assertSame(dinoTest1, dinosaur.wut2Eat(dinosaurs, grasses, waters));
        dinosaur.setWaterStorage(10);
        assertSame(waterTest1, dinosaur.wut2Eat(dinosaurs, grasses, waters));
    }
    
    @Test
    void move() {
        instantiation();
        
        //System.out.println(dinosaur.wut2Eat(dinosaurs, grasses, waters));
        
        dinosaur.setHerbivore(true);                    //dino is a hungry herbivore
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        dinosaur.move(dinosaurs, grasses, waters);          //move towards grassTest1
        assertSame(0, dinosaur.getxLoc());
        assertSame(10, dinosaur.getyLoc());
        dinosaur.defaultStats();                            //reset dino to default
        
        dinosaur.setHerbivore(false);                   //dino is a hungry carnivore
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        dinosaur.move(dinosaurs, grasses, waters);          //move towards dinoTest1
        assertSame(10, dinosaur.getxLoc());
        assertSame(0, dinosaur.getyLoc());
        dinosaur.defaultStats();                            //reset dino to default
    
        dinosaur.setHerbivore(false);                   //not vertical/horizontal movement test case
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        dinoTest1.setxLoc(40); dinoTest1.setyLoc(0); //move dinoTest1 outta the way. Time for dinoTest2 to die
        dinosaur.move(dinosaurs, grasses, waters);          //move towards dinoTest2
        assertSame(6, dinosaur.getxLoc());
        assertSame(8, dinosaur.getyLoc());
        dinosaur.defaultStats();                            //reset dino to default
        
        dinosaur.setHerbivore(true);                    //dino is a thirsty herbivore
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(8);
        dinosaur.move(dinosaurs, grasses, waters);          //move towards waterTest1
        assertSame(0, dinosaur.getxLoc());
        assertSame(-10, dinosaur.getyLoc());
        dinosaur.defaultStats();                            //reset dino to default
    
        dinosaur.setHerbivore(false);                    //dino is a thirsty carnivore
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(8);
        dinosaur.move(dinosaurs, grasses, waters);          //move towards waterTest1
        assertSame(0, dinosaur.getxLoc());
        assertSame(-10, dinosaur.getyLoc());
        dinosaur.defaultStats();                            //reset dino to default
    }
    
    public void instantiation() {
        dinosaur.defaultStats();
        
        dinosaurs.add(dinoTest1);
        dinosaurs.add(dinoTest2);
        dinosaurs.add(dinoTest3);
        
        grasses.add(grassTest1);
        grasses.add(grassTest2);
        grasses.add(grassTest3);
        grassTest1.setGrowthStage(4);
        grassTest2.setGrowthStage(4);
        grassTest3.setGrowthStage(4);
        
        waters.add(waterTest1);
        waters.add(waterTest2);
        waters.add(waterTest3);
    }
}