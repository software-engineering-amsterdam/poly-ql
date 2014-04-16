package org.uva.sea.ql.parser.antlr.QL4.GUI;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Form;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;


/**
 * Abstract parent class for GUIs in Questionair language. Implements runnable to be able to run as object
 * @author Sammie Katt
 */
public abstract class GUI extends Application implements Runnable {

	/*
	 * Static because running GUI creates a new instance (after which setting is impossible)
	 * Thus an instance is created where the variables are set. Then running the app creates a
	 * new instance of the GUI, but retains these variables
	 */
	protected static Form ast;
	protected static List<QLErrorMsg> errors;
	
	/**
	 * Initiates the stage
	 */
	public void initStage(Stage stage, String title) {
		stage.setTitle(title);
		createLayout();
	}
	
	/**
	 * Shows stage given parent layout
	 */
	public void showStage(Stage stage, Parent layout) {
		Scene scene = new Scene(layout, 600, 450);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	/**
	 * Creating highest level layout (vbox)
	 */
	protected VBox createLayout() {
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    return vbox;
	}
	
	/**
	 * Setters and getters
	 */
	public void setForm(Form ast) {
		GUI.ast = ast;
	}
	
	public void setErrors(List<QLErrorMsg> errors) {
		GUI.errors = errors;
	}
	
}
