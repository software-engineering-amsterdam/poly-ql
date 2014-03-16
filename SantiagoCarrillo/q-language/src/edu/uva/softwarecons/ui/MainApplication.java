package edu.uva.softwarecons.ui;


import edu.uva.softwarecons.checker.TypeChecker;
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
import edu.uva.softwarecons.ui.dialog.DialogFactory;
import edu.uva.softwarecons.ui.question.*;
import edu.uva.softwarecons.ui.widget.TitleHBox;
import edu.uva.softwarecons.util.ParserBuilder;
import edu.uva.softwarecons.util.StringUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
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
public class MainApplication extends Application implements EventHandler<ActionEvent> {

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
        mainVBox.getChildren().add(getTopMenuBar(primaryStage));
        Scene scene = new Scene(mainVBox, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar getTopMenuBar(final Stage stage) {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItemOpen = new MenuItem("Open");
        MenuItem menuItemExit = new MenuItem("Exit");
        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Questionnaire");
                File selectedFile = fileChooser.showOpenDialog(stage);
                try {
                    if(null != selectedFile){
                        loadForm(selectedFile);
                    }
                } catch (FileNotFoundException e1) {
                    DialogFactory.showErrorDialog("File Not Found", "The specified file: " + selectedFile.getName() + "was not found");
                } catch (IOException e1) {
                    DialogFactory.showErrorDialog("System Error", "Error loading file: " + selectedFile.getName());
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
        return  menuBar;
    }

    private void loadForm(File selectedFile) throws IOException {
        ParserBuilder parserBuilder = new ParserBuilder();
        ParseTree tree = parserBuilder.buildParseTree(new FileInputStream(selectedFile));
        QuestionnaireBuilderVisitor questionnaireBuilderVisitor = new QuestionnaireBuilderVisitor();
        form = (Form) questionnaireBuilderVisitor.visit(tree);
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm(form);
        if(!typeChecker.getErrors().isEmpty())
            DialogFactory.showQuestionnaireErrorDialog(typeChecker.getErrors());
        else{
            mainVBox.getChildren().add(new TitleHBox(form.getId(), "#336699", Color.WHITE));
            ScrollPane scrollPane = new ScrollPane();
            VBox.setVgrow(scrollPane, Priority.ALWAYS);
            scrollPane.setContent(questionsVBox);
            HBox hBox = new HBox(10);
            hBox.setPadding(new Insets(12, 12, 12, 12));
            hBox.setAlignment(Pos.CENTER);
            Button button = new Button("Submit");
            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println(StringUtil.formToJson(form, questions));
                }
            });
            hBox.getChildren().add(button);
            mainVBox.getChildren().addAll(scrollPane, hBox);
            addQuestions(form.getQuestions());
            updateModel();
        }
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

    private void addRemoveQuestions() {
        for(QuestionHBox questionHBox: questions.values()){
            if(questionHBox.isVisible() && !questionsVBox.getChildren().contains(questionHBox))
                questionsVBox.getChildren().add(questionHBox);
            else if(!questionHBox.isVisible() && questionsVBox.getChildren().contains(questionHBox))
                questionsVBox.getChildren().remove(questionHBox);
        }
    }

    private void updateModel(){
        for(Question question: form.getQuestions()){
            if(new ComputedQuestion(null, null, null, null).equals(question)){
                ComputedQuestion computedQuestion = (ComputedQuestion) question;
                questions.get(computedQuestion.getId()).
                        updateValue(computedQuestion.getExpression().accept(expressionEvaluator));
            }
            else if(new IfQuestion(null, null, null, null).equals(question))
                updateIfQuestion((IfQuestion) question);
        }
        addRemoveQuestions();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        expressionEvaluator.addContextValue(node.getId(), questions.get(node.getId()).getValue());
        updateModel();
    }







}

