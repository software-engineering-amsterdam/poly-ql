
namespace GOLD.Engine.Enums
{
    //NOTE: MUST MATCH FILE DEFINITION!!!
    public enum SymbolType
    {
        //Nonterminal
        Nonterminal = 0,
        //Passed to the parser
        Content,
        //Ignored by the parser
        Noise = 2,
        //End character (EOF)
        End = 3,
        //Group start
        GroupStart = 4,
        //Group end
        GroupEnd = 5,
        //Error symbol
        Error = 7
    }
}
