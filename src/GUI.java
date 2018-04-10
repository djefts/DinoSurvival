
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.Insets;


public class GUI extends Application {
    SimulationManager simulationManager = new SimulationManager();
	//Define window properties
	public int Height = 300 ;
	public int Width = 450 ;
	public int HeightA = 600 ;
	public int WidthA = 450 ;
	private boolean Resizeable = false ; //To prevent user from resizing window
	
	//Stage
	@Override
	public void start (Stage primaryStage) {
	
	/***********************Scene One**************************/
	CreateDinoPane cdp = new CreateDinoPane() ;
	
	// Create scene with all objects in it
	Scene sceneOne = new Scene(cdp.dinoCreator(), Height, Width, Color.GRAY) ;
	
	
	/***********************Scene Two**************************/
	YesNoPane ynp = new YesNoPane() ;

	//Create scene with all objects in it
	Scene sceneTwo = new Scene(ynp.showSim(), Height, Width, Color.GRAY);
	
	/***********************Scene Three**************************/
	//Pane playGround = new Pane();
	
	//Scene sceneTwo = new Scene(playGround, Color.GRAY);
	/**************************************************************/
		
		//Set stage properties
		primaryStage.setTitle("Dinosaur Survival Simulator");
		primaryStage.setResizable(Resizeable);
		primaryStage.setScene(sceneOne);
		primaryStage.setHeight(HeightA);
		primaryStage.setWidth(WidthA);
		primaryStage.setScene(sceneTwo); 
		primaryStage.setHeight(Height);
		primaryStage.setWidth(Width);		
		primaryStage.show();
	 
	}
	
	//Start program (for Eclipse use only)
	public static void main(String[] args) {
		 Application.launch(args);
	}
}


    
