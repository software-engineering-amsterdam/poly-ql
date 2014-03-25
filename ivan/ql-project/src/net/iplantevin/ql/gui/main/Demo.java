package net.iplantevin.ql.gui.main;

import java.io.IOException;

/**
 * @author Ivan
 */
public class Demo {
    public static void main(String[] args) {
        String inputFile = "/Users/Ivan/Documents/Master SE/Software " +
                "Construction/poly-ql/ivan/ql-project/src/net/iplantevin/ql/questionnaires/";
        inputFile += "guiForm1.txt";
//        inputFile += "typeForm1.txt";

        try {
            GUIController controller = new GUIController(inputFile);
            controller.runForms(); // Performs type checking.
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
