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
    
    private final int delta = -3;
    private Dinosaur dinoTest1 = new Dinosaur(25, 0);               //closest test dinosaur
    private Dinosaur dinoTest2 = new Dinosaur(15, 20);              //second closest dino
    private Dinosaur dinoTest3 = new Dinosaur(40, 20);
    
    private Grass grassTest1 = new Grass(0, 25);                    //closest test grass
    private Grass grassTest2 = new Grass(30, 30);
    private Grass grassTest3 = new Grass(-25, 25);
    
    private Water waterTest1 = new Water(0, -25);                   //closet test water
    private Water waterTest2 = new Water(-30, -5);
    private Water waterTest3 = new Water(5, -25);
    
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
    void getFoodSource() {
        instantiation();
        
        dinosaur.setHerbivore(0);   //dino should want to eat grass
        dinosaur.addFood(delta);        //hungrier than thirsty
        assertSame(grassTest1, dinosaur.getFoodSource(dinosaurs, grasses, waters));
        dinosaur.setHerbivore(1);   //dino should want to eat meat
        assertSame(dinoTest1, dinosaur.getFoodSource(dinosaurs, grasses, waters));
        dinosaur.addFood(-delta);       //reset hunger
        dinosaur.addWater(delta);       //thirstier than hungrier
        assertSame(waterTest1, dinosaur.getFoodSource(dinosaurs, grasses, waters));
    }
    
    
    @Test
    void move() {
        instantiation();
        
        //dino is hungry herbivore, but there's no food...
        ArrayList<Grass> grasses1 = new ArrayList<Grass>() {{
            add(new Grass(0, 0, 0));    //too low growth stage to eat
            add(new Grass(10, 10, 3));  //too low growth stage to eat
            add(new Grass(25, 0, 1));   //too low growth stage to eat
        }};
        
        dinosaur.setHerbivore(0);
        dinosaur.addFood(delta);
        assertEquals(true, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses1, waters);             //move where?
        assertEquals(0, dinosaur.getxLoc());                         //nowhere
        assertEquals(0, dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //dino is a hungry herbivore
        dinosaur.setHerbivore(0);
        dinosaur.addFood(delta);
        assertEquals(true, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards grassTest1 @ (0, 25)
        assertEquals(0, dinosaur.getxLoc());
        assertEquals(10, dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //dino is a hungry carnivore
        dinosaur.setHerbivore(1);
        dinosaur.addFood(delta);
        assertEquals(false, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards dinoTest1 @ (25, 0)
        assertEquals(10, dinosaur.getxLoc());
        assertEquals(0, dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //not vertical/horizontal movement test case
        //dino is hungry carnivore
        dinosaur.setHerbivore(1);
        dinosaur.addFood(delta);
        assertEquals(false, dinosaur.isHerbivore());
        dinoTest1.setxLoc(40);                                  //move dinoTest1 outta the way to (40, 0)
        dinoTest1.setyLoc(0);                                   //Time for dinoTest2 to die
        dinosaur.move(dinosaurs, grasses, waters);              //move towards dinoTest2 @ (15, 20)
        assertEquals(6, dinosaur.getxLoc());
        assertEquals(8, dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //dino is a thirsty herbivore
        dinosaur.setHerbivore(0);
        dinosaur.setCurWater(3);
        assertEquals(true, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards waterTest1 @ (0, -25)
        assertEquals(0, dinosaur.getxLoc());
        assertEquals(-10, dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //dino is a thirsty carnivore
        dinosaur.setHerbivore(1);
        dinosaur.addWater(delta);
        assertEquals(false, dinosaur.isHerbivore());
        dinosaur.move(dinosaurs, grasses, waters);              //move towards waterTest1 @ (0, -25)
        assertEquals(0, dinosaur.getxLoc());
        assertEquals(-10, dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //dino is going to eat a plant
        Grass testy = new Grass(5, 5);                          //add a grass within reach of dinosaur @ (5, 5)
        testy.setGrowthStage(4);
        grasses.add(testy);
        dinosaur.setHerbivore(0);
        dinosaur.addFood(delta);
        dinosaur.move(dinosaurs, grasses, waters);
        assertEquals(testy.getxLoc(), dinosaur.getxLoc());      //check location
        assertEquals(testy.getyLoc(), dinosaur.getyLoc());
        assertEquals(1, testy.getGrowthStage());                //grass growth stage is now 1
        instantiation();                                //reset testing defaults
        
        //dino is going to drink a water
        Water testyW = new Water(5, 0);                          //add a water within reach of dinosaur @ (5, 0)
        waters.add(testyW);
        dinosaur.setHerbivore(0);
        dinosaur.addWater(delta);
        dinosaur.move(dinosaurs, grasses, waters);
        assertEquals(testyW.getxLoc(), dinosaur.getxLoc());      //check location
        assertEquals(testyW.getyLoc(), dinosaur.getyLoc());
        instantiation();                                //reset testing defaults
        
        //dino is going to eat a dino
        Dinosaur testyDino = new Dinosaur(0, 5);                //add a dino within reach of dinosaur @ (0, 5)
        testyDino.addHealth(5);
        testyDino.setSpecies("test dino");
        dinosaurs.add(testyDino);
        dinosaur.setHerbivore(1);
        dinosaur.addFood(delta);
        dinosaur.move(dinosaurs, grasses, waters);
        assertEquals(testyDino.getxLoc(), dinosaur.getxLoc());  //check location
        assertEquals(testyDino.getyLoc(), dinosaur.getyLoc());
        assertEquals(-1, dinosaurs.indexOf(testyDino));         //dino no longer exists
        instantiation();                                //reset testing defaults
    }
    
    private void instantiation() {
        dinosaur.defaultStats();
        dinosaur.setxLoc(0);
        dinosaur.setyLoc(0);
    
        dinosaurs.clear();
        dinoTest1.addHealth(5);
        dinoTest2.addHealth(5);
        dinoTest3.addHealth(5);
        dinoTest1.setSpecies("test 1");
        dinoTest2.setSpecies("test 2");
        dinoTest3.setSpecies("test 3");
        dinosaurs.add(dinoTest1);
        dinosaurs.add(dinoTest2);
        dinosaurs.add(dinoTest3);
        
        grasses.clear();
        grasses.add(grassTest1);
        grasses.add(grassTest2);
        grasses.add(grassTest3);
        grassTest1.setGrowthStage(4);
        grassTest2.setGrowthStage(4);
        grassTest3.setGrowthStage(4);
        
        waters.clear();
        waters.add(waterTest1);
        waters.add(waterTest2);
        waters.add(waterTest3);
    }
}