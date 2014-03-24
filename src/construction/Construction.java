/* 
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction;

import construction.ErrorTypes.TypeError;
import construction.QuestionElements.GeneralQuestion;
import construction.QuestionElements.QuestionForm;
import construction.QuestionElements.QuestionTypeCheckVisitor;
import construction.RenderElements.QuestionGUI;
import construction.RenderElements.QuestionRenderVisitor;
import construction.RenderElements.qst;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class Construction {

    Construction() {

    }

    private int TypeChecker(List<GeneralQuestion> questionList) {
        QuestionTypeCheckVisitor v = new QuestionTypeCheckVisitor();
        for (GeneralQuestion gq : questionList) {
            gq.accept(v);
        }

        System.out.println("Mem dump: " + v.getMemory().toString());
        for (TypeError t : v.getTypeErrors()) {
            System.out.println("-------------------------------");
            t.print();
        }
        return v.getTypeErrors().size();
    }

    private void renderer(QuestionForm qf) {
        /*
        QuestionRenderVisitor v = new QuestionRenderVisitor();
        for (GeneralQuestion gq : qf.getQuestions()) {
            gq.accept(v);
        }
        List<qst> rq = v.getRender2();
        */
        QuestionGUI g = new QuestionGUI(qf.getName(),qf.getQuestions());
        g.render();
/*
        JFrame frame = new JFrame(qf.getName());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(rq.size(),1));
        for (qst trq : rq) {
            JComponent jcp = trq.render();
            frame.add(jcp, BorderLayout.CENTER);

        }
        frame.pack();
        frame.setSize(400, 200);
        frame.setVisible(true);
*/
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

            int typeErrors = TypeChecker(q.getQuestions());
            if (typeErrors == 0) {
                renderer(q);
            } else {
                System.out.println("Type Errors were found, fix these before proceeding");
            }

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
