package edu.uva.softwarecons.ui;


import edu.uva.softwarecons.checker.TypeChecker;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.grammar.QuestionnaireBuilderVisitor;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.util.ParserBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class Main extends Application {

    private HashMap<String, QuestionHBox> questions = new HashMap<String, QuestionHBox>();

    private final VBox vBox = new VBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Questionnaire Language");
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItemOpen = new MenuItem("Open");
        MenuItem menuItemExit = new MenuItem("Exit");
        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Questionnaire");
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                try {
                    ParserBuilder parserBuilder = new ParserBuilder();
                    if(null != selectedFile){
                        ParseTree tree = parserBuilder.buildParseTree(new FileInputStream(selectedFile));
                        QuestionnaireBuilderVisitor questionnaireBuilderVisitor = new QuestionnaireBuilderVisitor();
                        Form form = (Form) questionnaireBuilderVisitor.visit(tree);
                        TypeChecker typeChecker = new TypeChecker();
                        typeChecker.checkForm(form);
                        if(!typeChecker.getErrors().isEmpty())
                            generateErrorDialog(typeChecker.getErrors());
                        else{
                            vBox.getChildren().add(new TitleHBox(form.getId(), "#336699", Color.WHITE));
                            for(Question question: form.getQuestions()){
                                if(!new IfQuestion(null, null, null).equals(question))
                                    createQuestionLayout(question);
                            }
                            for(QuestionHBox questionHBox: questions.values()){
                                vBox.getChildren().add(questionHBox);
                            }
                        }
                    }
                } catch (FileNotFoundException e1) {
                    //TODO Handle Exceptions !!
                    e1.printStackTrace();
                }
            }
        });
        menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        menuFile.getItems().add(menuItemOpen);
        menuFile.getItems().add(menuItemExit);
        menuBar.getMenus().add(menuFile);
        vBox.getChildren().add(menuBar);
        Scene scene = new Scene(vBox, 700, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static void generateErrorDialog(List<QuestionnaireError> errors){
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Error loading file");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox =  new VBox();
        vBox.getChildren().add(new TitleHBox("Errors Found:","#ffffb2", Color.RED));
        Scene scene = new Scene(vBox, 600, 400);
        dialogStage.setScene(scene);
        dialogStage.show();

        for(QuestionnaireError error: errors){
            Text text = new Text(error.toString());
            text.setFill(Color.RED);
            vBox.getChildren().add(text);
        }
    }

    private void createQuestionLayout(Question question){
        if(new ComputedQuestion(null, null, null, null).equals(question)){
            ComputedQuestion computedQuestion =  (ComputedQuestion) question;
            QuestionHBox questionHBox = new ComputedQuestionHBox(computedQuestion);
            questions.put(computedQuestion.getId(), questionHBox);
        }
        else if(new BasicQuestion(null, null, null).equals(question)){
            BasicQuestion basicQuestion =  (BasicQuestion) question;
            if(basicQuestion.getType().equals(new BooleanType()))
                questions.put(basicQuestion.getId(), new BooleanQuestionHBox(basicQuestion));
            else
                questions.put(basicQuestion.getId(), new InputQuestionHBox(basicQuestion, false));
        }
    }


}
