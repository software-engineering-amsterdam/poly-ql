package edu.uva.softwarecons.ui;

import javafx.scene.control.TextField;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/15/14
 */
public class NumericTextField extends TextField {


    public void replaceText(int start, int end, String text) {
        if (!text.matches("[a-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            super.replaceText(start, end, text);
        }

    }

    public void replaceSelection(String text) {
        if (!text.matches("[a-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            super.replaceSelection(text);
        }
    }

}
