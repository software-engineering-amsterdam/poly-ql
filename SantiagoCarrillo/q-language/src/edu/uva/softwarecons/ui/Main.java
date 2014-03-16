package edu.uva.softwarecons.ui;


import edu.uva.softwarecons.checker.TypeChecker;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.evaluator.ExpressionEvaluator;
import edu.uva.softwarecons.evaluator.QuestionEvalVisitor;
import edu.uva.softwarecons.grammar.QuestionnaireBuilderVisitor;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.value.BooleanValue;
import edu.uva.softwarecons.model.value.DateValue;
import edu.uva.softwarecons.model.value.IntegerValue;
import edu.uva.softwarecons.util.ParserBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
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
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class Main extends Application implements EventHandler<ActionEvent> {

    private HashMap<String, QuestionHBox> questions = new HashMap<String, QuestionHBox>();

    private final VBox questionsVBox = new VBox();

    private final VBox mainVBox = new VBox();

    private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    private Form form;


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
                        form = (Form) questionnaireBuilderVisitor.visit(tree);
                        TypeChecker typeChecker = new TypeChecker();
                        typeChecker.checkForm(form);
                        if(!typeChecker.getErrors().isEmpty())
                            generateErrorDialog(typeChecker.getErrors());
                        else{
                            mainVBox.getChildren().add(new TitleHBox(form.getId(), "#336699", Color.WHITE));
                            ScrollPane scrollPane = new ScrollPane();
                            VBox.setVgrow(scrollPane, Priority.ALWAYS);
                            scrollPane.setContent(questionsVBox);
                            mainVBox.getChildren().add(scrollPane);
                            addQuestions(form.getQuestions());
                            updateModel();
                        }
                    }
                } catch (FileNotFoundException e1) {
                    showErrorPopup("File not found", "The specified file: "+selectedFile.getName()+"was not found");
                } catch (IOException e1) {
                    showErrorPopup("System Error", "Error loading file: "+selectedFile.getName());
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
        mainVBox.getChildren().add(menuBar);
        Scene scene = new Scene(mainVBox, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addQuestions(List<Question> questions) {
        for(Question question: questions){
            if(new IfQuestion(null, null, null, null).equals(question)){
                IfQuestion ifQuestion = (IfQuestion) question;
                addQuestions(ifQuestion.getQuestions());
                if(null != ifQuestion.getElseQuestion())
                    addQuestions(ifQuestion.getElseQuestion().getQuestions());
            }else{
                createQuestionLayout(question);
            }
        }
    }



    private void updateIfQuestion(IfQuestion  ifQuestion){
        boolean display = Boolean.valueOf(ifQuestion.getExpression().accept(expressionEvaluator).getValue());
        ifQuestion.accept(new QuestionEvalVisitor(display, questions, expressionEvaluator));
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

    private static void showErrorPopup(String title, String message){
        Stage dialogStage = new Stage();
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox =  new VBox(25);
        vBox.setAlignment(Pos.CENTER);
        Label messageText = new Label(message);
        messageText.setWrapText(true);
        vBox.getChildren().add(messageText);
        final Scene scene = new Scene(vBox, 290, 100);
        Button button = new Button("OK");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) scene.getWindow();
                stage.close();
            }
        });
        vBox.getChildren().add(button);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    private void createQuestionLayout(Question question){
        if(new ComputedQuestion(null, null, null, null).equals(question)){
            ComputedQuestion computedQuestion =  (ComputedQuestion) question;
            QuestionHBox questionHBox = new ComputedQuestionHBox(computedQuestion.getId());
            questions.put(computedQuestion.getId(), questionHBox);
        }
        else if(new BasicQuestion(null, null, null).equals(question)){
            BasicQuestion basicQuestion =  (BasicQuestion) question;
            QuestionHBox questionHBox = null;
            if(basicQuestion.getType().equals(new BooleanType())){
                questionHBox =  new BooleanQuestionHBox(basicQuestion.getId(), this);
                expressionEvaluator.addContextValue(basicQuestion.getId(), new BooleanValue(false));
            }else if(basicQuestion.getType().equals(new IntegerType())){
                questionHBox = new NumericQuestionHBox(basicQuestion.getId(), false, this);
                expressionEvaluator.addContextValue(basicQuestion.getId(), new IntegerValue(0));
            }else if(basicQuestion.getType().equals(new DateType())){
                questionHBox = new DateQuestionHBox(basicQuestion.getId(), this);
                expressionEvaluator.addContextValue(basicQuestion.getId(), new DateValue(new Date()));
            }
            questions.put(basicQuestion.getId(), questionHBox);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        expressionEvaluator.addContextValue(node.getId(), questions.get(node.getId()).getValue());
        updateModel();
    }

    private void updateModel(){
        for(Question question: form.getQuestions()){
            if(new IfQuestion(null, null, null, null).equals(question))
                updateIfQuestion((IfQuestion) question);
        }
        for(QuestionHBox questionHBox: questions.values()){
            if(questionHBox.isVisible() && !questionsVBox.getChildren().contains(questionHBox))
                questionsVBox.getChildren().add(questionHBox);
            else if(!questionHBox.isVisible() && questionsVBox.getChildren().contains(questionHBox))
                questionsVBox.getChildren().remove(questionHBox);
        }
    }


}

