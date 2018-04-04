/********************************************************
 *YesNoPane.java
 *Final Project: Dinosaur Survival Simulation 
 *Author: Christian A. Carrizales
 *Date:
 *
 *Variable List: 
 * 
 *Methods List: 
 **********************************************************/
//Java import statements
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;



public class YesNoPane extends BorderPane {
	
	//Define window properties
	//public int Height = 300 ;
	//public int Width = 450 ;
	
	
	public BorderPane showSim() {
		
	//Create border pane
	BorderPane showSim = new BorderPane() ;
	
	//BorderPane design
	Label showYN ;
	showYN = new Label("Would you like to see a dinosaur simulation?") ;
	showYN.setStyle("-fx-font: 20 pt");

	Button yesButt, noButt ; 
	yesButt = new Button("Fuck yeah!") ;
	yesButt.setStyle("-fx-font: 10 pt");
	yesButt.setMinSize(200,200) ;

	noButt = new Button ("Hell no!") ;
	noButt.setStyle("-fx-font: 10 pt");
	noButt.setMinSize(200,200);

	HBox centerButts = new HBox();	
	centerButts.setAlignment(Pos.CENTER);
	centerButts.setSpacing(15) ;
	centerButts.getChildren().addAll(yesButt, noButt);

	//Add to BorderPane
	showSim.setTop(showYN); //Top 
	showSim.setAlignment(showYN, Pos.CENTER) ;

	showSim.setCenter(centerButts); //Center
	showSim.setAlignment(centerButts, Pos.TOP_RIGHT) ;
	
	
	/***********************Event Handler**************************/
	EventHandler<ActionEvent> pressYesButt = e -> {
		System.out.println("'Yes' button was pressed!"); //TEST: Is variable collected?
	};


	EventHandler<ActionEvent> pressNoButt = e -> {
		System.out.println("'No' button was pressed!"); //TEST: Is variable collected?
	};

	yesButt.setOnAction(pressYesButt);
	noButt.setOnAction(pressNoButt);

	
	return showSim ;
}

	

}