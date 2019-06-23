package ch15pc05;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;

/**
 * Draw a checkerboard based on user input for the number of columns and rows
 * @author frank.olson
 */
public class Ch15pc05 extends Application {
    
    @Override
    /**
     * Method to create the stage for the javafx application
     */
    public void start(Stage primaryStage) {
        // Set title for the stage
        primaryStage.setTitle("Create a Checkerboard");
        
        // Instantiate the grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Add components
        Text textSceneTitle = new Text("Create a Checkerboard");
        textSceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(textSceneTitle, 0, 0, 2, 1);
        
        Label labelGetRows = new Label("Input the number of Rows:");
        grid.add(labelGetRows, 0, 1);
        
        TextField textfieldRows = new TextField();
        grid.add(textfieldRows, 1, 1);
        
        Label labelGetColumns = new Label("Input the number of Columns:");
        grid.add(labelGetColumns, 0, 2);
        
        TextField textfieldColumns = new TextField();
        grid.add(textfieldColumns, 1, 2);
        
        Button buttonCreateCheckerboard = new Button("Create Checkerboard");
        HBox hboxButton = new HBox(10);
        hboxButton.setAlignment(Pos.BOTTOM_RIGHT);
        hboxButton.getChildren().add(buttonCreateCheckerboard);
        grid.add(hboxButton, 1, 4);
        
        // Set the action event for when the button is clicked
        buttonCreateCheckerboard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Create Checkerboard
                // Variables
                int rows = getInt(textfieldRows.getText());
                int columns = getInt(textfieldColumns.getText());
                
                GridPane box = new GridPane();
                box.setAlignment(Pos.CENTER);
                
                for (int i = 0; i < rows; i++) {
                    for(int j = 0; j < columns; j++){
                        // Instantiate the square
                        Rectangle rec = new Rectangle(20*j, 20*i, 20, 20);
                        
                        // Set the color
                        if ((i+j)%2 == 1)
                            rec.setFill(Color.BLACK);
                        else
                            rec.setFill(Color.BLANCHEDALMOND);
                        
                        // Add square to the box
                        box.add(rec, j, i);
                    }
                }
                
                grid.add(box, 0, 6);
            }
        });
        
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    /**
     * Main method to launch the program
     * @param args String[] The command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Get an integer from a string of text
     * @param string
     * @return 
     */
    private int getInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (Exception e) {
            return 0;
        }
    }
}
