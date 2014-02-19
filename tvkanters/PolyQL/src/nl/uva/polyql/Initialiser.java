package nl.uva.polyql;

import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class Initialiser {

    public static void main(final String... params) {
        try {
            final ANTLRFileStream input = new ANTLRFileStream("res/exampleform.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
