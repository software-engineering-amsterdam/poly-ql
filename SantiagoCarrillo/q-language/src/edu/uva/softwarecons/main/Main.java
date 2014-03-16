package edu.uva.softwarecons.main;

import edu.uva.softwarecons.checker.TypeChecker;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.checker.warning.QuestionnaireWarning;
import edu.uva.softwarecons.grammar.QuestionnaireBuilderVisitor;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.util.FileReader;
import edu.uva.softwarecons.util.ParserBuilder;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main
{
    public static void main( String[] args )
        throws Exception
    {
        ParserBuilder parserBuilder = new ParserBuilder();
        ParseTree tree = parserBuilder.buildParseTree( FileReader.getFileContent( "input.txt", "res" ) );
        QuestionnaireBuilderVisitor questionnaireBuilderVisitor = new QuestionnaireBuilderVisitor();
        Form form = (Form) questionnaireBuilderVisitor.visit( tree );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        for ( QuestionnaireWarning questionnaireWarning : typeChecker.getWarnings() )
        {
            System.out.println( questionnaireWarning );
        }
        for ( QuestionnaireError questionnaireError : typeChecker.getErrors() )
        {
            System.err.println( questionnaireError );
        }
    }
}
