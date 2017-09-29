/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bel;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mdobrinski
 */
public class BEL extends Application {

  public static TextField textF1 = new TextField("1");
  public static TextArea taResults = new TextArea();
  ArrayList<BEL_Char> solderList = new ArrayList<BEL_Char>();
  
  @Override
  public void start(Stage primaryStage) {
    Button gsBtn = new Button();
    gsBtn.setText("Generate Solder/s");
         
    BorderPane root = new BorderPane();
    
    HBox topHBox = new HBox(10);
      topHBox.setPadding(new Insets(15, 12, 15, 12));
      topHBox.setSpacing(10);   // Gap between nodes
      topHBox.setStyle("-fx-background-color: #6b8e23;");
    
      
      topHBox.getChildren().addAll(gsBtn, textF1);
    root.setTop(topHBox);
    
    GridPane leftGrid = new GridPane();
      leftGrid.setHgap(10);
      leftGrid.setHgap(10);
      leftGrid.setPadding(new Insets (5, 5, 5, 5));
      // Setup the Labels
      Label labST = new Label("Strength: ");
      GridPane.setHalignment(labST, HPos.RIGHT);
      leftGrid.add(labST, 0, 0);
      Label labEN = new Label("Endurance: ");
      GridPane.setHalignment(labEN, HPos.RIGHT);
      leftGrid.add(labEN, 0, 1);
      Label labAG = new Label("Agility: ");
      GridPane.setHalignment(labAG, HPos.RIGHT);
      leftGrid.add(labAG, 0, 2);
      Label labWH = new Label("Weapons Handling: ");
      GridPane.setHalignment(labWH, HPos.RIGHT);
      leftGrid.add(labWH, 0, 3);
      Label labSA = new Label("Stamina: ");
      GridPane.setHalignment(labSA, HPos.RIGHT);
      leftGrid.add(labSA, 0, 4);
      Label labWT = new Label("Weight: ");
      GridPane.setHalignment(labWT, HPos.RIGHT);
      leftGrid.add(labWT, 0, 5);
      Label labAS = new Label("Average Stat: ");
      GridPane.setHalignment(labAS, HPos.RIGHT);
      leftGrid.add(labAS, 0, 6);
      // Setup the text boxes for the stats
      TextField tfST = new TextField("00");
      tfST.setPrefWidth(35);
      tfST.setEditable(false);
      leftGrid.add(tfST, 1, 0);
      TextField tfEN = new TextField("00");
      tfEN.setPrefWidth(35);
      tfEN.setEditable(false);
      leftGrid.add(tfEN, 1, 1);
      TextField tfAG = new TextField("00");
      tfAG.setPrefWidth(35);
      tfAG.setEditable(false);
      leftGrid.add(tfAG, 1, 2);
      TextField tfWH = new TextField("00");
      tfWH.setPrefWidth(35);
      tfWH.setEditable(false);
      leftGrid.add(tfWH, 1, 3);
      TextField tfSA = new TextField("00");
      tfSA.setPrefWidth(35);
      tfSA.setEditable(false);
      leftGrid.add(tfSA, 1, 4);
      TextField tfWT = new TextField("00");
      tfWT.setPrefWidth(35);
      tfWT.setEditable(false);
      leftGrid.add(tfWT, 1, 5);
      TextField tfAS = new TextField("00");
      tfAS.setPrefWidth(35);
      tfAS.setEditable(false);
      leftGrid.add(tfAS, 1, 6);
     
    root.setLeft(leftGrid);
    
    
    taResults.setEditable(false);
    taResults.setPrefSize(240, 800);
    ScrollPane centerSP = new ScrollPane(taResults);
    root.setCenter(centerSP);
    
    Scene scene = new Scene(root, 300, 250);
    
    primaryStage.setTitle("Character Generator");
    primaryStage.setScene(scene);
    primaryStage.show();
          
    gsBtn.setOnAction( e -> btn1Event());
  
  }// ******************* END of PrimaryStage ***********
  
  public void btn1Event(){
      String text = textF1.getText();
      int count = Integer.parseInt(text);
      int i = 0;
      for (i=0; i<count; i++){ 
      BEL_Char solder = new BEL_Char();
      taResults.appendText("************* " + i + " ************************\n");
      taResults.appendText(solder.toString()+ "\n");
      taResults.appendText("****************************************\n");
      }  
    }


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}//++++++++++++++++++++++++ END BEL class ++++++++++++++++++++++++++++++++++++

