/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bel;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  TextField tfST = new TextField("00");
  TextField tfEN = new TextField("00");
  TextField tfAG = new TextField("00");
  TextField tfWH = new TextField("00");
  TextField tfSA = new TextField("00");
  TextField tfWT = new TextField("00");
  TextField tfAS = new TextField("00");
  TextField tfSN = new TextField("0");
  TextField tfBG = new TextField("-");
  
  @Override
  public void start(Stage primaryStage) {
    Button gsBtn = new Button();
    gsBtn.setText("Generate Solder/s");
    Button btnGetSolder = new Button();
    btnGetSolder.setText("Get Solder");
    Label spc1 = new Label("  ");
    tfSN.setPrefColumnCount(3);
    textF1.setPrefColumnCount(4);
    
    BorderPane root = new BorderPane();
    
    HBox topHBox = new HBox(10);
      topHBox.setPadding(new Insets(15, 12, 15, 12));
      topHBox.setSpacing(10);   // Gap between nodes
      topHBox.setStyle("-fx-background-color: #6b8e23;");
      topHBox.getChildren().addAll(gsBtn, textF1, spc1, btnGetSolder, tfSN);
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
      Label labBG = new Label("Background: ");
      GridPane.setHalignment(labBG, HPos.RIGHT);
      leftGrid.add(labBG, 0, 7);
      
      
      // Setup the text boxes for the stats
      tfST.setPrefWidth(35);
      tfST.setEditable(false);
      leftGrid.add(tfST, 1, 0);
      tfEN.setPrefWidth(35);
      tfEN.setEditable(false);
      leftGrid.add(tfEN, 1, 1);
      tfAG.setPrefWidth(35);
      tfAG.setEditable(false);
      leftGrid.add(tfAG, 1, 2);
      tfWH.setPrefWidth(35);
      tfWH.setEditable(false);
      leftGrid.add(tfWH, 1, 3);
      tfSA.setPrefWidth(35);
      tfSA.setEditable(false);
      leftGrid.add(tfSA, 1, 4);
      tfWT.setPrefWidth(35);
      tfWT.setEditable(false);
      leftGrid.add(tfWT, 1, 5);
      tfAS.setPrefWidth(35);
      tfAS.setEditable(false);
      leftGrid.add(tfAS, 1, 6);
      tfBG.setPrefWidth(45);
      tfBG.setEditable(false);
      leftGrid.add(tfBG, 1, 7);
    root.setLeft(leftGrid);
    
    
    taResults.setEditable(false);
    taResults.setPrefSize(240, 800);
    ScrollPane centerSP = new ScrollPane(taResults);
    root.setCenter(centerSP);
    
    Scene scene = new Scene(root, 300, 250);
    
    primaryStage.setTitle("Character Generator");
    primaryStage.setScene(scene);
    primaryStage.show();
          
    gsBtn.setOnAction( e -> {
      try {
        btn1Event();
      } catch (FileNotFoundException ex) {
        Logger.getLogger(BEL.class.getName()).log(Level.SEVERE, null, ex);
      }
    });
    btnGetSolder.setOnAction(e -> btnGSEvent());
    
  
  }// ******************* END of PrimaryStage ***********
  
  public void btn1Event() throws FileNotFoundException{
      String text = textF1.getText();
      int count = Integer.parseInt(text);
      int i = 0;
      
      try{
        PrintWriter out = new PrintWriter("C:\\Michael\\BEL_Data\\SolderList.txt");
        
      for (i=0; i<count; i++){ 
      solderList.add(new BEL_Char());
      taResults.appendText("************* " + i + " ************************\n");
      taResults.appendText(solderList.get(i).toString()+ "\n");
      taResults.appendText("****************************************\n");
      
      out.print("************* " + i + " ************************\r\n");
      out.print(solderList.get(i).toString()+ "\r\n");
      out.print("****************************************\r\n");
      out.print("\r\n");
      }
      out.close();
      } catch (Exception FileNotFoundException){
        System.out.println("PrintWriter Exception");}
      
    }// END btn1Event()
  
  public void btnGSEvent(){
      String text = tfSN.getText();
      int i = Integer.parseInt(text);
      tfST.setText(String.valueOf(solderList.get(i).getStrength()));
      tfEN.setText(String.valueOf(solderList.get(i).getEndurance()));
      tfAG.setText(String.valueOf(solderList.get(i).getAgility()));
      tfWH.setText(String.valueOf(solderList.get(i).getWep_handling()));
      tfSA.setText(String.valueOf(solderList.get(i).getStamina()));
      tfWT.setText(String.valueOf(solderList.get(i).getWeight()));
      tfAS.setText(String.valueOf(solderList.get(i).getAvgStat()));
      tfBG.setText(solderList.get(i).getBg_type());
      
        
    }// END btnGSEvent()
  
  
  


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}//++++++++++++++++++++++++ END BEL class ++++++++++++++++++++++++++++++++++++

