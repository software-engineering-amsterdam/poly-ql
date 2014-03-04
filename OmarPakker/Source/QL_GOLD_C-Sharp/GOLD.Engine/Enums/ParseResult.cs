
namespace GOLD.Engine.Enums
{
    internal enum ParseResult
    {
        Accept,
        Shift,
        ReduceNormal,
        //Trim
        ReduceEliminated,
        SyntaxError,
        InternalError
    }
}
