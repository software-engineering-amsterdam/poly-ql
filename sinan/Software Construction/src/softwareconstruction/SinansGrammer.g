grammar SinansGrammer;

@header {
    package softwareconstruction;
    import java.util.ArrayList;
}

form returns [Form fo] @init {$fo = new Form();}: 'form' IDENTIFIER {$fo.setFormName($IDENTIFIER.text);} '{' (item { $fo.addQuestion($item.object);})+ '}';

item returns [Object object] @init {$object = new Object();}: conditional {$object = $conditional.cqe;} | question {$object = $question.qe;};

question returns [Question qe] @init {$qe = new Question();} : IDENTIFIER { $qe.setQuestionName($IDENTIFIER.text); } ':' STRING { $qe.setQuestionContent($STRING.text); } TYPE { $qe.setQuestionType($TYPE.text);};

conditional returns [ConditionalQuestion cqe] @init {$cqe = new ConditionalQuestion();} : 'if' '(' IDENTIFIER ')' '{' (item { $cqe.add($item.object); })+ '}';

TYPE : 'boolean' | 'money';

IDENTIFIER : (LETTER | DIGIT)+;
STRING : '"' (LETTER | DIGIT | ' ')+ '"';
LETTER : ('a'..'z'|'A'..'Z'|'?');
DIGIT : ('0'..'9');
WS  :   (' '|'\n'|'\t')+ {skip();} ;

//form Box1HouseOwning {
// hasSoldHouse: “Did you sell a house in 2010?” boolean
// hasBoughtHouse: “Did you by a house in 2010?” boolean
// hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?” boolean
// if (hasSoldHouse) {
// sellingPrice: “Price the house was sold for:” money
// privateDebt: “Private debts for the sold house:” money
// valueResidue: “Value residue:” money(sellingPrice - privateDebt)
// }
//}