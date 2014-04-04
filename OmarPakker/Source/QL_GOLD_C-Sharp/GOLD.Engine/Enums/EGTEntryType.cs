
namespace GOLD.Engine.Enums
{
    //NOTE: MUST MATCH FILE DEFINITION!!!
    internal enum EGTEntryType
    {
        //M
        Record = 77,
        //E
        Empty = 69,
        //I - Unsigned, 2 byte
        UInt16 = 73,
        //S - Unicode format
        String = 83,
        //B - 1 Byte, Value is 0 or 1
        Boolean = 66,
        //b
        Byte = 98,
        Error = 0
    }
}
