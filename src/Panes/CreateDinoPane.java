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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider ;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Color;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CreateDinoPane {
	
	Stage theStage;
	private int h,w;
	
	public int Height = 1000;
	public int Width = 500 ;
	
	public int speed ; 
	public int attack ; 
	public int defense ; 
	public int foodStorage ; 
	public int waterStorage ; 
	public int kids ; 
	public int foodToReproduce ;
	public int turnsWithoutFood ;
	public int maxAge ;
	
	public int dietType ;
	public boolean mentalityType ;
	public boolean settlementType ; 
	
	public CreateDinoPane(Stage stage, int height, int width) {
		theStage = stage;
		h=height;
		w=width;
	}
	
	public VBox dinoCreator() {

		//Create VBox
		VBox dinoCreator = new VBox() ;

	//VBox design
		
		//Labels
		Label create, name, statPoints, speedLabel, attackLabel, defenseLabel, foodLabel, waterLabel, kidsLabel, ftrLabel, twofLabel, maLabel, dietLabel, mentalityLabel, settleLabel ;

		create = new Label("Create A Dinosaur!") ;
		create.setStyle("-fx-font: 20 pt");
		
		name = new Label("Dinosaur name: ") ;
		statPoints = new Label("Stat Points:") ;
		
		speedLabel = new Label("Speed: ") ;
		attackLabel = new Label("Attack: ");
		defenseLabel = new Label("Defense: ") ;
		foodLabel = new Label("Food: ");
		waterLabel = new Label("Water: ") ;
		kidsLabel = new Label("Kids: ");
		ftrLabel = new Label("Reproduction: ") ;
		twofLabel = new Label("Turns w/o food: ");
		maLabel = new Label("Max Age: ") ;
		dietLabel = new Label("Diet type: ");
		mentalityLabel = new Label("Interactive mentality: ") ;
		settleLabel = new Label("Settlement style: ");

		
		/*********************** Sliders **************************/
		//Stat sliders
		Slider speedSlide, attackSlide, defenseSlide, foodSlide, waterSlide, kidsSlide, ftrSlide, twofSlide, maSlide, totalVal ; 

		speedSlide = new Slider(0,10,1) ; 
		speedSlide.setMin(0);
		speedSlide.setMax(10);
		speedSlide.setMaxSize(500, 100);
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
		
		foodSlide = new Slider(0,10,1) ; 
		foodSlide.setMin(0);
		foodSlide.setMax(10);
		foodSlide.setShowTickLabels(true);
		foodSlide.setShowTickMarks(true);
		foodSlide.setSnapToTicks(true);
		foodSlide.setMajorTickUnit(5);
		foodSlide.setMinorTickCount(4);
		foodSlide.setBlockIncrement(1f);
		
		waterSlide = new Slider(0,10,1) ; 
		waterSlide.setMin(0);
		waterSlide.setMax(10);
		waterSlide.setShowTickLabels(true);
		waterSlide.setShowTickMarks(true);
		waterSlide.setSnapToTicks(true);
		waterSlide.setMajorTickUnit(5);
		waterSlide.setMinorTickCount(4);
		waterSlide.setBlockIncrement(1f);
		
		kidsSlide = new Slider(0,10,1) ; 
		kidsSlide.setMin(0);
		kidsSlide.setMax(10);
		kidsSlide.setShowTickLabels(true);
		kidsSlide.setShowTickMarks(true);
		kidsSlide.setSnapToTicks(true);
		kidsSlide.setMajorTickUnit(5);
		kidsSlide.setMinorTickCount(4);
		kidsSlide.setBlockIncrement(1f);
		
		ftrSlide = new Slider(0,10,1) ; 
		ftrSlide.setMin(0);
		ftrSlide.setMax(10);
		ftrSlide.setShowTickLabels(true);
		ftrSlide.setShowTickMarks(true);
		ftrSlide.setSnapToTicks(true);
		ftrSlide.setMajorTickUnit(5);
		ftrSlide.setMinorTickCount(4);
		ftrSlide.setBlockIncrement(1f);
		
		twofSlide = new Slider(0,10,1) ; 
		twofSlide.setMin(0);
		twofSlide.setMax(10);
		twofSlide.setShowTickLabels(true);
		twofSlide.setShowTickMarks(true);
		twofSlide.setSnapToTicks(true);
		twofSlide.setMajorTickUnit(5);
		twofSlide.setMinorTickCount(4);
		twofSlide.setBlockIncrement(1f);
		
		maSlide = new Slider(0,10,1) ; 
		maSlide.setMin(0);
		maSlide.setMax(10);
		maSlide.setShowTickLabels(true);
		maSlide.setShowTickMarks(true);
		maSlide.setSnapToTicks(true);
		maSlide.setMajorTickUnit(5);
		maSlide.setMinorTickCount(4);
		maSlide.setBlockIncrement(1f);
		
		totalVal = new Slider() ; //NOT VISIBLE; FOR THE PURPOSE OF SETTING TOTAL VALUE
		totalVal.valueProperty().bind(speedSlide.valueProperty().add(attackSlide.valueProperty())
				.add(defenseSlide.valueProperty()).add(foodSlide.valueProperty()).add(waterSlide.valueProperty())
				.add(kidsSlide.valueProperty()).add(ftrSlide.valueProperty()).add(twofSlide.valueProperty()).add(maSlide.valueProperty()));
		
		//Set slider starting value
		speedSlide.setValue(0); 
		attackSlide.setValue(0);
		defenseSlide.setValue(0);
		foodSlide.setValue(0); 
		waterSlide.setValue(0);
		kidsSlide.setValue(0);
		ftrSlide.setValue(0); 
		twofSlide.setValue(0);
		maSlide.setValue(0);
		
		//Update slider value (nsv = name slider value)
		Label ssv, asv, dsv, fsv, wsv, ksv, ftrsv, twofsv, masv, total; 
		ssv = new Label();
		ssv.textProperty().bind(speedSlide.valueProperty().asString("%.0f"));

		asv = new Label();
		asv.textProperty().bind(attackSlide.valueProperty().asString("%.0f"));

		dsv = new Label();
		dsv.textProperty().bind(defenseSlide.valueProperty().asString("%.0f"));

		fsv = new Label();
		fsv.textProperty().bind(foodSlide.valueProperty().asString("%.0f"));
		
		wsv = new Label();
		wsv.textProperty().bind(waterSlide.valueProperty().asString("%.0f"));

		ksv = new Label();
		ksv.textProperty().bind(kidsSlide.valueProperty().asString("%.0f"));

		ftrsv = new Label();
		ftrsv.textProperty().bind(ftrSlide.valueProperty().asString("%.0f"));

		twofsv = new Label();
		twofsv.textProperty().bind(twofSlide.valueProperty().asString("%.0f"));
		
		masv = new Label();
		masv.textProperty().bind(maSlide.valueProperty().asString("%.0f"));
		
		total = new Label();
		total.textProperty().bind(totalVal.valueProperty().asString("%.0f"));
		

		/**********************************************************/

		//Textbox
		TextField dinoName = new TextField("Laserpattyfighterosaurs");
		dinoName.setPromptText("Enter name");
		dinoName.setAlignment(Pos.CENTER);
		dinoName.setMaxWidth(250);
			
		//GridPane #1 (Stat, Slider, Value)
		GridPane statOrganizer = new GridPane() ;
		//statOrganizer.setGridLinesVisible(true); //FOR ORGANIZATIONAL USE
		statOrganizer.getColumnConstraints().addAll(new ColumnConstraints(90) , new ColumnConstraints(275)); // To extend column 1 width = 275
		statOrganizer.setHgap(25);
		statOrganizer.setVgap(20);
		statOrganizer.setPadding(new Insets(15,10,10,10));
		
		//Add notes to GridPane
		statOrganizer.add(name, 0, 0);
		statOrganizer.add(dinoName, 1, 0);
		statOrganizer.setHalignment(dinoName, HPos.CENTER);
		
		statOrganizer.add(total, 3, 10);
		statOrganizer.add(statPoints, 0, 10);
		
		statOrganizer.add(speedLabel, 0, 1);
		statOrganizer.add(attackLabel, 0, 2);
		statOrganizer.add(defenseLabel, 0, 3);
		statOrganizer.add(foodLabel, 0, 4);
		statOrganizer.add(waterLabel, 0, 5);
		statOrganizer.add(kidsLabel, 0, 6);
		statOrganizer.add(ftrLabel, 0, 7);
		statOrganizer.add(twofLabel, 0, 8);
		statOrganizer.add(maLabel, 0, 9);
		
		statOrganizer.add(speedSlide, 1, 1);
		statOrganizer.add(attackSlide, 1, 2);
		statOrganizer.add(defenseSlide, 1, 3);
		statOrganizer.add(foodSlide, 1, 4);
		statOrganizer.add(waterSlide, 1, 5);
		statOrganizer.add(kidsSlide, 1, 6);
		statOrganizer.add(ftrSlide, 1, 7);
		statOrganizer.add(twofSlide, 1, 8);
		statOrganizer.add(maSlide, 1, 9);
		
		statOrganizer.add(ssv, 3, 1);
		statOrganizer.add(asv, 3, 2);
		statOrganizer.add(dsv, 3, 3);
		statOrganizer.add(fsv, 3, 4);
		statOrganizer.add(wsv, 3, 5);
		statOrganizer.add(ksv, 3, 6);
		statOrganizer.add(ftrsv, 3, 7);
		statOrganizer.add(twofsv, 3, 8);
		statOrganizer.add(masv, 3, 9);
		

		//ToggleGroup and RadioButtons
		RadioButton herbivore, carnivore, herd, solitary, territorial, wander ; 
		herbivore = new RadioButton("Herbivore") ;
		carnivore = new RadioButton("Carnivore") ;
		herd = new RadioButton("Herd") ;
		solitary = new RadioButton ("Lonewolf") ;
		territorial = new RadioButton("Territorial") ; 
		wander = new RadioButton("Wanderer") ;
		
		ToggleGroup diet, mentality, settlement ; 
		diet = new ToggleGroup() ;
		mentality = new ToggleGroup() ; 
		settlement = new ToggleGroup() ; 
				
		herbivore.setToggleGroup(diet);
		carnivore.setToggleGroup(diet);
		
		herd.setToggleGroup(mentality);
		solitary.setToggleGroup(mentality);
		
		territorial.setToggleGroup(settlement);
		wander.setToggleGroup(settlement);
		
		//GridPane #2 
		GridPane behaviorOrganizer = new GridPane() ; 
		//behaviorOrganizer.setGridLinesVisible(true); //FOR ORGANIZATIONAL USE
		behaviorOrganizer.setAlignment(Pos.CENTER_LEFT);
		behaviorOrganizer.setHgap(45);
		behaviorOrganizer.setVgap(15);
		behaviorOrganizer.setPadding(new Insets(10,15,10,15));
		
		behaviorOrganizer.add(dietLabel, 0, 0);
		behaviorOrganizer.add(herbivore, 0, 1);
		behaviorOrganizer.add(carnivore, 0, 2);
		
		behaviorOrganizer.add(mentalityLabel, 2, 0);
		behaviorOrganizer.add(herd, 2, 1);
		behaviorOrganizer.add(solitary, 2, 2);
		
		behaviorOrganizer.add(settleLabel, 4, 0);
		behaviorOrganizer.add(territorial, 4, 1);
		behaviorOrganizer.add(wander, 4, 2);
		
		//Button 
		Button createButt = new Button("Create") ;
		createButt.setMinSize(100,50);
		createButt.setStyle("-fx-font: 14 pt");
		
		HBox forButt = new HBox() ; 
		forButt.setAlignment(Pos.BOTTOM_RIGHT) ;
		forButt.setPadding(new Insets(10,15,10,25)) ;
		forButt.getChildren().add(createButt) ;
		
		
		//Add to VBox 
		dinoCreator.setAlignment(Pos.TOP_CENTER);
		dinoCreator.setSpacing(10);
		dinoCreator.getChildren().addAll(create, statOrganizer, behaviorOrganizer, forButt) ;

		
		/***********************Event Handler**************************/
		//Collect slider variables
		speedSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    speed = new_val.intValue();
            }
        });
		
		attackSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    attack = new_val.intValue();
            }
        });
		
		defenseSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    defense = new_val.intValue();
            }
        });
		
		foodSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    foodStorage = new_val.intValue();
            }
        });
		
		waterSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    waterStorage = new_val.intValue();
            }
        });
		
		kidsSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    kids = new_val.intValue();
            }
        });
		
		ftrSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    foodToReproduce = new_val.intValue();
            }
        });
		
		twofSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    turnsWithoutFood = new_val.intValue();
            }
        });
		
		maSlide.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    maxAge = new_val.intValue();
            }
        });
		
		//Button event
		EventHandler<ActionEvent> pressCreate = e -> {
			System.out.println("'Create' button was pressed!"); //TEST: Is variable collected?
			
			//Collect diet type
			if ((diet.getSelectedToggle() != null) && (diet.getSelectedToggle() == herbivore)) {
				dietType = 0 ;

			} else if ((diet.getSelectedToggle() != null) && (diet.getSelectedToggle() == carnivore)) {
				dietType = 1 ;

			}  System.out.println("Diet: " + dietType); //TEST: Is variable collected?
		
			//Collect mentality type
			if ((mentality.getSelectedToggle() != null) && (mentality.getSelectedToggle() == herd)) {
				mentalityType = true ;

			} else if ((mentality.getSelectedToggle() != null) && (mentality.getSelectedToggle() == solitary)) {
				mentalityType = false ;

			}  System.out.println("Mentality: " + mentalityType); //TEST: Is variable collected?
			
			//Collect settlement type
			if ((settlement.getSelectedToggle() != null) && (settlement.getSelectedToggle() == territorial)) {
				settlementType = true ;

			} else if ((diet.getSelectedToggle() != null) && (diet.getSelectedToggle() == wander)) {
				settlementType = false ;

			}  System.out.println("Settlement: " + settlementType); //TEST: Is variable collected?
		
			//TEST: Is variable collected?
			System.out.println("Speed:" + speed);
			System.out.println("Attack:" + attack);
			System.out.println("Defense:" + defense);
			System.out.println("Food:" + foodStorage);
			System.out.println("Water:" + waterStorage);
			System.out.println("SpawnRate:" + kids);
			System.out.println("Reproduction:" + foodToReproduce);
			System.out.println("HungerRate:" + turnsWithoutFood);
			System.out.println("Age:" + maxAge);
			

			YesNoPane ynp = new YesNoPane() ; 

			//Create scene with all objects in it
			theStage.setScene(new Scene(ynp.showSim(), h, w));
			theStage.setHeight(h); theStage.setWidth(w);
		
		}; //end of event
		
		EventHandler<ActionEvent> changeScene = e -> {
		}; //end of event


		createButt.setOnAction(pressCreate);
		//createButt.setOnAction(changeScene) ;
		/**************************************************************/
		
		return dinoCreator;	
	}

	//genderError = new Label("ERROR: GENDER NOT SELECTED") ;
	//genderError.setVisible(false);
	//genderError.setStyle("-fx-font: 12 pt; -fx-font-weight: BOLD;");
	//genderError.setTextFill(Color.RED);


}