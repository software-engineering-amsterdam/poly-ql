
namespace GOLD.Engine.Enums
{
    //NOTE: MUST MATCH FILE DEFINITION!!!
    internal enum LRActionType
    {
        //Shift a symbol and goto a state
        Shift = 1,
        //Reduce by a specified rule
        Reduce = 2,
        //Goto to a state on reduction
        Goto = 3,
        //Input successfully parsed
        Accept = 4,
        //Programmars see this often!
        Error = 5
    }
}
