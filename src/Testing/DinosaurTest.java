import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Sources:
 * https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
 * https://stackoverflow.com/questions/924285/efficiency-of-java-double-brace-initialization
 * https://stackoverflow.com/questions/16526860/jetbrains-intellij-keyboard-shortcut-to-collapse-all-methods
 */

class DinosaurTest {
    
    private final Dinosaur dinosaur = new Dinosaur(0, 0);               //dinosaur that is used as the "current" dinosaur deciding stuff
    private final Dinosaur dinoTest1 = new Dinosaur(25, 0);               //closest test dinosaur
    private final Dinosaur dinoTest2 = new Dinosaur(15, 20);              //second closest dino
    private final Dinosaur dinoTest3 = new Dinosaur(40, 20);
    private final Grass grassTest1 = new Grass(0, 25);                    //closest test grass
    private final Grass grassTest2 = new Grass(50, 50);
    private final Grass grassTest3 = new Grass(-25, 25);
    private final Water waterTest1 = new Water(0, -25);                   //closet test water
    private final Water waterTest2 = new Water(-30, -5);
    private final Water waterTest3 = new Water(5, -25);
    private ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
    private ArrayList<Grass> grasses = new ArrayList<>();
    private ArrayList<Water> waters = new ArrayList<>();
    
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
    void BATTLE() {
    
    }
    
    @Test
    /**
     * determine what the dino should try to attack
     */
    void wut2Eat() {
        instantiation();
        
        dinosaur.setHerbivore(0);
        //TODO flip numbers for foodStorage and waterStorage so that high number = full and low = hungry
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(4);
        assertSame(grassTest1, dinosaur.wut2Eat(dinosaurs, grasses, waters));
        dinosaur.setHerbivore(1);
        assertSame(dinoTest1, dinosaur.wut2Eat(dinosaurs, grasses, waters));
        dinosaur.setWaterStorage(10);
        assertSame(waterTest1, dinosaur.wut2Eat(dinosaurs, grasses, waters));
    }
    
    
    
    @Test
    void move() {
        instantiation();
        
        //dino is hungry herbivore, but there's no food...
        ArrayList<Grass> grasses1 = new ArrayList<Grass>() {{
            add(new Grass(0, 0, 0));
            add(new Grass(10, 10, 3));
            add(new Grass(25, 0, 1));
        }};
        dinosaur.setHerbivore(0);
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        assertEquals(true, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses1, waters);             //move where?
        dinosaur.defaultStats();                                //reset dino to default
        
        //dino is a hungry herbivore
        dinosaur.setHerbivore(0);
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        assertEquals(true, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards grassTest1
        assertEquals(0, dinosaur.getxLoc());
        assertEquals(10, dinosaur.getyLoc());
        dinosaur.defaultStats();                                //reset dino to default
        
        //dino is a hungry carnivore
        dinosaur.setHerbivore(1);
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        assertEquals(false, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards dinoTest1
        assertEquals(10, dinosaur.getxLoc());
        assertEquals(0, dinosaur.getyLoc());
        dinosaur.defaultStats();                                //reset dino to default
        
        //not vertical/horizontal movement test case
        //dino is hungry carnivore
        dinosaur.setHerbivore(1);
        dinosaur.setFoodStorage(8);
        dinosaur.setWaterStorage(7);
        assertEquals(false, dinosaur.isHerbivore());
        dinoTest1.setxLoc(40);                                  //move dinoTest1 outta the way. Time for dinoTest2 to die
        dinoTest1.setyLoc(0);
        dinosaur.move(dinosaurs, grasses, waters);              //move towards dinoTest2
        assertEquals(6, dinosaur.getxLoc());
        assertEquals(8, dinosaur.getyLoc());
        dinosaur.defaultStats();                                //reset dino to default
        
        //dino is a thirsty herbivore
        dinosaur.setHerbivore(0);
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(8);
        assertEquals(true, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards waterTest1
        assertEquals(0, dinosaur.getxLoc());
        assertEquals(-10, dinosaur.getyLoc());
        dinosaur.defaultStats();                                //reset dino to default
        
        //dino is a thirsty carnivore
        dinosaur.setHerbivore(1);
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(8);
        assertEquals(false, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards waterTest1
        assertEquals(0, dinosaur.getxLoc());
        assertEquals(-10, dinosaur.getyLoc());
        dinosaur.defaultStats();                                //reset dino to default
        
        //dino is going to eat a plant
        Grass testy = new Grass(5, 5);                          //add a grass within reach of dinosaur
        testy.setGrowthStage(4);
        grasses.add(testy);
        dinosaur.setHerbivore(0);
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(6);
        dinosaur.move(dinosaurs, grasses, waters);
        assertEquals(testy.getxLoc(), dinosaur.getxLoc());      //check location
        assertEquals(testy.getyLoc(), dinosaur.getyLoc());
        assertEquals(1, testy.getGrowthStage());                //grass growth stage is now 1
        dinosaur.defaultStats();
    
        //dino is going to drink a water
        Water testyW = new Water(5, 0);                          //add a water within reach of dinosaur
        waters.add(testyW);
        dinosaur.setHerbivore(0);
        dinosaur.setFoodStorage(5);
        dinosaur.setWaterStorage(6);
        dinosaur.move(dinosaurs, grasses, waters);
        assertEquals(testyW.getxLoc(), dinosaur.getxLoc());      //check location
        assertEquals(testyW.getyLoc(), dinosaur.getyLoc());
        dinosaur.defaultStats();
        
        //dino is going to eat a dino
        Dinosaur testyDino = new Dinosaur(0, 5);                //add a dino within reach of dinosaur
        dinosaurs.add(testyDino);
        dinosaur.setHerbivore(1);
        dinosaur.setFoodStorage(7);
        dinosaur.setWaterStorage(6);
        dinosaur.move(dinosaurs, grasses, waters);
        assertEquals(testyDino.getxLoc(), dinosaur.getxLoc());  //check location
        assertEquals(testyDino.getyLoc(), dinosaur.getyLoc());
        assertEquals(-1, dinosaurs.indexOf(testyDino));         //dino no longer exists
        dinosaur.defaultStats();
    }
    
    private void instantiation() {
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