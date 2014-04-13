package org.uva.sea.ql.parser.antlr.QL4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The (highest level of) graphical user interface of the QL4 questionair
 */
public class GUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Automatically called (sort of main function)
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("This is an form");
		
		GridPane grid = createGrid();
		
		// creating text, labels and fields
		Text welcomeText = new Text("Please fill this form in");
		welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Label userNameLabel = new Label("What is your name?");
		Label pwLabel = new Label("What is your password?");
		
		TextField userNameTextField = new TextField();
		PasswordField pwField = new PasswordField();
		
		final Text msg = new Text();
		
		// add text, labels and fields to grid
		grid.add(welcomeText, 0, 0, 2, 1);
		grid.add(userNameLabel, 0, 1);
		grid.add(pwLabel, 0, 2);
		grid.add(userNameTextField, 1, 1);
		grid.add(pwField, 1, 2);
		grid.add(msg, 1, 6);
		
		// create button
		Button btn = new Button("Send");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		
		// add to grid
		grid.add(hbBtn,1,3);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				msg.setText("Thank you for your information");
			}
		});
		
		// add grid to stage
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	/**
	 * returns a javaFX grid 
	 */
	public GridPane createGrid() {
		GridPane grid = new GridPane();
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.setGridLinesVisible(true);
		 
		return grid;
	}

}

