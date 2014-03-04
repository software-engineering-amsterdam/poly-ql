
namespace GOLD.Engine.Enums
{
    //NOTE: MUST MATCH FILE DEFINITION!!!
    internal enum EGTRecord
    {
        //I
        InitialStates = 73,
        //S
        Symbol = 83,
        //R  (R for Rule; related productions)
        Production = 82,
        //D
        DFAState = 68,
        //L
        LRState = 76,
        //p
        Property = 112,
        //c
        CharRanges = 99,
        //g 
        Group = 103,
        //t (Table Counts)
        TableCounts = 116
    }
}
