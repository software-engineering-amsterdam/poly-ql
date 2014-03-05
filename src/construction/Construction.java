package construction;

import construction.ErrorTypes.TypeError;
import construction.Types.IType;
import construction.QuestionElements.GeneralQuestion;
import construction.QuestionElements.QuestionForm;
import construction.QuestionElements.QuestionVisitor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.*;

public class Construction {

    Construction() {

    }

    private void TypeChecker(ArrayList<GeneralQuestion> questionList) {
        QuestionVisitor v = new QuestionVisitor();
        for (GeneralQuestion gq : questionList) {
            gq.accept(v);
        }

        System.out.println("Mem dump: " + v.getMemory().toString());
        for (TypeError t : v.getTypeErrors()) {
            System.out.println("-------------------------------");
            t.print();
        }
    }

    public void parseIT(String inputFile) {
        try {
            System.out.println("Parsing file, " + inputFile);
            FileInputStream fis = new FileInputStream(inputFile);
            ANTLRInputStream input = new ANTLRInputStream(fis);
            testLexer lexer = new testLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            testParser parser = new testParser(tokens);
            QuestionForm q = parser.questionaire().form;

            TypeChecker(q.getQuestions());

            //        q.render();
        } catch (RecognitionException ex) {
            Logger.getLogger(Construction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Construction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Construction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Construction c = new Construction();
        if (args.length == 1) {
            c.parseIT(args[0]);
        } else {
            c.parseIT("input.txt");
        }
    }

}
