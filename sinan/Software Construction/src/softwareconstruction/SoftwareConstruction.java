/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareconstruction;

import softwareconstruction.form.Form;
import softwareconstruction.questions.Question;
import softwareconstruction.questions.ConditionalQuestion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import softwareconstruction.literals.Expression;
import softwareconstruction.questions.QuestionInterface;
import softwareconstruction.questions.TypeCheckVisitor;
import softwareconstruction.types.SuperType;

/**
 *
 * @author Sinan
 */
public class SoftwareConstruction {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream textfile = new FileInputStream("src/softwareconstruction/textfile.txt");
            ANTLRInputStream input = new ANTLRInputStream(textfile);
            SinansGrammerLexer lexer = new SinansGrammerLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SinansGrammerParser parser = new SinansGrammerParser(tokens);
//            ParseTree tree = parser.form();
            Form form = parser.form().fo;
            TypeCheckVisitor v = new TypeCheckVisitor();
            
            for(QuestionInterface q: form.getItems()){
                q.accept(v);
            }

//            System.out.println(tree.toStringTree(parser));
        } catch (RecognitionException ex) {
            Logger.getLogger(SoftwareConstruction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SoftwareConstruction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoftwareConstruction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
