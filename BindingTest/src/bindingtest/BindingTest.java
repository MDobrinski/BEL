/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bindingtest;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author michael.sbg
 */

public class BindingTest extends Application {
    public TextField tfNum1 = new TextField();
    public TextArea taResults = new TextArea();
    public TextField tfGetNum = new TextField();
    public Label lab1 = new Label();
    public Label lab2 = new Label();
    public Label lab3 = new Label();
    
    ArrayList<NumGenA> list = new ArrayList<NumGenA>();
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Gen Numbers");
        
        Button btn2 = new Button();
        btn2.setText("Get Num.");
        
        
        
        
        
        // ********************* Handle Events ****************
        btn1.setOnAction(e -> btn1Event());
        btn2.setOnAction(e -> btn2Event());
        // ********** END ActionEvent Handlers ************
        
        // ++++++++++++++++++ Setup Panes ++++++++++++++++++++++
        BorderPane root = new BorderPane();
            // ********************* Top Cell ****************
            HBox topHBox = new HBox(10);
            topHBox.setPadding(new Insets(10, 10, 10, 10));
            tfNum1.setPrefColumnCount(5);
            tfNum1.setText("1");
            Label spacer = new Label("     ");
            Label spacer2 = new Label(" ");
            tfGetNum.setPrefColumnCount(4);
            tfGetNum.setText("0");
            topHBox.getChildren().addAll(btn1, tfNum1, spacer, btn2, tfGetNum, 
                    spacer2, lab3);
            root.setTop(topHBox);
            
            // ********************* Center Cell ****************
            taResults.setEditable(false);
            taResults.setPrefSize(240, 300);
            ScrollPane centerSP = new ScrollPane(taResults);
            root.setCenter(centerSP);
            
            // ******************* Bottom Cell *******************
            HBox btmHBox = new HBox(10);
            btmHBox.setPadding(new Insets(10, 10, 10, 10));
            lab1.setText("Count: ");
            lab2.setText(String.valueOf(NumGenA.getCount()));
            btmHBox.getChildren().addAll(lab1, lab2);
            root.setBottom(btmHBox);
            
            
            
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Binding Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    } //****************** END Primary Stage ***************
    // ================== Methods Go Down Here ======================
    
    private void btn1Event(){
       int cnt = Integer.parseInt(tfNum1.getText());
       int i = 0;
       for (i=0; i<cnt; i++){
           list.add(new NumGenA());
           taResults.appendText(String.valueOf(i) + 
                   " = " + String.valueOf(list.get(i).getValue() + "\n"));
           
           lab2.setText(String.valueOf(NumGenA.getCount()));
       }
    } // END of btn1Event
    
    private void btn2Event(){
       int index = Integer.parseInt(tfGetNum.getText());
       lab3.setText(String.valueOf(list.get(index).getValue()));
        
    }// END of btn2Event
    
    
    
    
    
    // ================= Methods Go Above Here ======================
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}// ************************* END BindingTest Class ******************
