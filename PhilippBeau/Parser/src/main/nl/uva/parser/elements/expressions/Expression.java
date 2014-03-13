package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.ASTNode;
import main.nl.uva.parser.elements.type.Value;

public abstract class Expression extends ASTNode {

    public Expression() {}

    public abstract Value getValue();
}