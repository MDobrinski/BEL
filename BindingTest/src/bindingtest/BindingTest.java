/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bindingtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Gen Numbers");
        
        
        
        
        // ********************* Handle Events ****************
        btn1.setOnAction(e -> btn1Event());
        // ********** END ActionEvent Handlers ************
        
        // ++++++++++++++++++ Setup Panes ++++++++++++++++++++++
        BorderPane root = new BorderPane();
            // ********************* Top Cell ****************
            HBox topHBox = new HBox(10);
            topHBox.setPadding(new Insets(10, 10, 10, 10));
            tfNum1.setPrefColumnCount(5);
            tfNum1.setText("1");
            topHBox.getChildren().addAll(btn1, tfNum1);
            root.setTop(topHBox);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Binding Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    } //****************** END Primary Stage ***************
    // ================== Methods Go Down Here ======================
    
    private void btn1Event(){
       System.out.println("Hello World!"); 
    }
    
    
    
    
    
    
    
    // ================= Methods Go Above Here ======================
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}// ************************* END BindingTest Class ******************
