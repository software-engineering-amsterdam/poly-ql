package nl.uva.polyql.model.expressions.modifiers;

import nl.uva.polyql.utils.SyntaxMap;

public class ModifierHelper {

    private static final SyntaxMap<Modifier<?>> sSyntaxMap = new SyntaxMap<>();

    static {
        sSyntaxMap.put(new DefaultModifier());
        sSyntaxMap.put(new InverseModifier());
        sSyntaxMap.put(new NegativeModifier());
    }

    public static Modifier<?> getBySyntax(String syntax) {
        if (syntax == null) {
            syntax = "";
        }
        return sSyntaxMap.get(syntax);
    }

    private ModifierHelper() {}
}
