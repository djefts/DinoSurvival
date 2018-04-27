/********************************************************
 *GUI.java
 *Final Project: Dinosaur Survival Simulation 
 *Author: Christian A. Carrizales
 *Date:
 *
 *Variable List: 
 *
 *Methods List: 
 **********************************************************/

//Java import statements

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GUI extends Application {
    
    //Define window properties
    public int Height = 300;    //yesno pane
    public int Width = 450;
    public int HeightA = 875;    //createdino pane
    public int WidthA = 500;
    //private boolean Resizeable = false ; //To prevent user from resizing window
    
    //Start program (for Eclipse use only)
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    //Stage
    @Override
    public void start(Stage primaryStage) {
        
        /***********************Scene One**************************/
        CreateDinoPane cdp = new CreateDinoPane(primaryStage, Height, Width);
        
        // Create scene with all objects in it
        Scene sceneOne = new Scene(cdp.dinoCreator(), HeightA, WidthA, Color.GRAY);
        
        
        /***********************Scene Two**************************/
        YesNoPane ynp = new YesNoPane();
        
        //Create scene with all objects in it
        Scene sceneTwo = new Scene(ynp.showSim(), Height, Width, Color.GRAY);
        
        /***********************Scene Three**************************/
        //Pane playGround = new Pane();
        
        //Scene sceneTwo = new Scene(playGround, Color.GRAY);
        /**************************************************************/
        
        //Set stage properties
        primaryStage.setTitle("Dinosaur Survival Simulator");
        //primaryStage.setResizable(Resizeable);
        primaryStage.setScene(sceneOne);
        primaryStage.setHeight(HeightA);
        primaryStage.setWidth(WidthA);
        primaryStage.show();
        
    }
    
    
}


    
