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
import javafx.scene.control.Slider ;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class CreateDinoPane extends VBox {

	public VBox dinoCreator() {

		//Create VBox
		VBox dinoCreator = new VBox() ;

	//VBox design
		
		//Labels
		Label create, speedText, attackText, defenseText, foodText, waterText, kidsText, ftrText, twofText, maxAgeText, typeText, herdText, territorialText ;

		create = new Label("Create A Dinosaur!") ;
		create.setStyle("-fx-font: 20 pt");

		speedText = new Label("Speed: ") ;
		attackText = new Label("Attack: ");
		defenseText = new Label("Defense: ") ;
		foodText = new Label("Food: ");
		waterText = new Label("Water: ") ;
		kidsText = new Label("Kids: ");
		ftrText = new Label("Reproduction: ") ;
		twofText = new Label("Turns without Food: ");
		maxAgeText = new Label("Max Age: ") ;
		typeText = new Label("Type: Herbivore/Carnivore ");
		herdText = new Label("Mentality: Herd/Solo ") ;
		territorialText = new Label("Territorial: Yay/Nay ");

		//Stat sliders
		Slider speedSlide, attackSlide, defenseSlide ; 

		speedSlide = new Slider(0,10,1) ; 
		speedSlide.setMin(0);
		speedSlide.setMax(10);
		speedSlide.setShowTickLabels(true);
		speedSlide.setShowTickMarks(true);
		speedSlide.setSnapToTicks(true);
		speedSlide.setMajorTickUnit(5);
		speedSlide.setMinorTickCount(4);
		speedSlide.setBlockIncrement(1f);

		attackSlide = new Slider(0,10,1) ; 
		attackSlide.setMin(0);
		attackSlide.setMax(10);
		attackSlide.setShowTickLabels(true);
		attackSlide.setShowTickMarks(true);
		attackSlide.setSnapToTicks(true);
		attackSlide.setMajorTickUnit(5);
		attackSlide.setMinorTickCount(4);
		attackSlide.setBlockIncrement(1f);

		defenseSlide = new Slider(0,10,1) ; 
		defenseSlide.setMin(0);
		defenseSlide.setMax(10);
		defenseSlide.setShowTickLabels(true);
		defenseSlide.setShowTickMarks(true);
		defenseSlide.setSnapToTicks(true);
		defenseSlide.setMajorTickUnit(5);
		defenseSlide.setMinorTickCount(4);
		defenseSlide.setBlockIncrement(1f);


		//Set slider starting value
		speedSlide.setValue(0); 
		attackSlide.setValue(0);
		defenseSlide.setValue(0);


		//GridPane 
		


		//Add to VBox 
		dinoCreator.setAlignment(Pos.TOP_CENTER);
		dinoCreator.setSpacing(10);
		dinoCreator.getChildren().addAll(create, speedSlide) ;

		return dinoCreator ;	
	}














}