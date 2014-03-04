using System;
using System.IO;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    internal class EGTReader : IDisposable
    {
        internal string FileHeader { get; private set; }
        internal bool IsAtEOF { get { return binaryReader.BaseStream.Position == binaryReader.BaseStream.Length; } }

        private ushort recordEntriesCount;
        private ushort recordEntriesRead;
        private BinaryReader binaryReader;
        private GrammarTables grammarTables;
        
        internal EGTReader(BinaryReader reader)
        {
            recordEntriesCount = 0;
            recordEntriesRead = 0;

            binaryReader = reader;

            FileHeader = ReadRawCString();
        }

        private string ReadRawCString()
        {
            char unicodeChar = Char.MinValue;
            string text = String.Empty;

            while ((unicodeChar = (char)ReadRawUInt16()) != 0)
            {
                text += unicodeChar.ToString();
            }

            return text;
        }

        private ushort ReadRawUInt16()
        {
            //Read a uint in little endian. This is the format already used
            //by the .NET BinaryReader. However, it is good to specificially
            //define this given byte order can change depending on platform.

            byte b0 = binaryReader.ReadByte();
            //Least significant byte first
            byte b1 = binaryReader.ReadByte();

            return (ushort)((b1 << 8) + b0);
        }

        internal Tuple<EGTEntryType, object> ReadEntry()
        {
            if(!IsRecordComplete())
            {
                recordEntriesRead++;

                EGTEntryType type = ReadEntryType();
                object value = null;

                switch(type)
                {
                    case EGTEntryType.Empty:
                        value = String.Empty;
                        break;

                    case EGTEntryType.Boolean:
                        value = (binaryReader.ReadByte() == 1);
                        break;

                    case EGTEntryType.UInt16:
                        value = ReadRawUInt16();
                        break;

                    case EGTEntryType.String:
                        value = ReadRawCString();
                        break;

                    case EGTEntryType.Byte:
                        value = binaryReader.ReadByte();
                        break;

                    default:
                        type = EGTEntryType.Error;
                        value = String.Empty;
                        break;
                }

                return new Tuple<EGTEntryType, object>(type, value);
            }

            return new Tuple<EGTEntryType, object>(EGTEntryType.Empty, null);
        }

        internal string ReadString()
        {
            Tuple<EGTEntryType, object> e = ReadEntry();
            if (e.Item1 == EGTEntryType.String)
            {
                return (string)e.Item2;
            }

            throw new IOException(String.Format("Type mismatch in file. Read '{0}' but expected '{1}' at ",
                e.Item1, EGTEntryType.String, binaryReader.BaseStream.Position));
        }

        internal ushort ReadUInt16()
        {
            Tuple<EGTEntryType, object> e = ReadEntry();
            if (e.Item1 == EGTEntryType.UInt16)
            {
                return (ushort)e.Item2;
            }

            throw new IOException(String.Format("Type mismatch in file. Read '{0}' but expected '{1}' at ",
                e.Item1, EGTEntryType.UInt16, binaryReader.BaseStream.Position));
        }

        internal bool ReadBoolean()
        {
            Tuple<EGTEntryType, object> e = ReadEntry();
            if (e.Item1 == EGTEntryType.Boolean)
            {
                return (bool)e.Item2;
            }

            throw new IOException(String.Format("Type mismatch in file. Read '{0}' but expected '{1}' at ",
                e.Item1, EGTEntryType.Boolean, binaryReader.BaseStream.Position));
        }

        internal byte ReadByte()
        {
            Tuple<EGTEntryType, object> e = ReadEntry();
            if (e.Item1 == EGTEntryType.Byte)
            {
                return (byte)e.Item2;
            }

            throw new IOException(String.Format("Type mismatch in file. Read '{0}' but expected '{1}' at ",
                e.Item1, EGTEntryType.Byte, binaryReader.BaseStream.Position));
        }

        internal bool GetNextRecord()
        {
            //Finish current record
            while (!IsRecordComplete())
            {
                ReadEntry();
            }

            if (IsAtEOF)
            {
                return false;
            }

            //Start next record
            if (ReadEntryType() == EGTEntryType.Record)
            {
                recordEntriesCount = ReadRawUInt16();
                recordEntriesRead = 0;

                return true;
            }

            return false;
        }

        private EGTEntryType ReadEntryType()
        {
            return (EGTEntryType)binaryReader.ReadByte();
        }

        internal EGTRecord ReadRecordType()
        {
            return (EGTRecord)ReadByte();
        }

        internal SymbolType ReadSymbolType()
        {
            return (SymbolType)ReadUInt16();
        }

        internal GroupAdvanceMode ReadAdvanceMode()
        {
            return (GroupAdvanceMode)ReadUInt16();
        }

        internal GroupEndingMode ReadEndingMode()
        {
            return (GroupEndingMode)ReadUInt16();
        }

        internal LRActionType ReadActionType()
        {
            return (LRActionType)ReadUInt16();
        }

        internal GrammarProperty ReadGrammarProperty()
        {
            ushort index = ReadUInt16();
            string name = ReadString();
            string value = ReadString();

            return new GrammarProperty(index, name, value);
        }

        internal GrammarTables ReadGrammarTables()
        {
            ushort symbolsSize = ReadUInt16();
            ushort charSetsSize = ReadUInt16();
            ushort productionsSize = ReadUInt16();
            ushort faStatesSize = ReadUInt16();
            ushort lrActionsListsSize = ReadUInt16();
            ushort groupsSize = ReadUInt16();

            //Keep it for later use in addition to reading it
            grammarTables = new GrammarTables(symbolsSize, charSetsSize, productionsSize,
                faStatesSize, lrActionsListsSize, groupsSize);

            return grammarTables;
        }

        internal Group ReadGroup()
        {
            ushort index = ReadUInt16();
            string name = ReadString();
            Symbol container = grammarTables.Symbols[ReadUInt16()];
            Symbol start =  grammarTables.Symbols[ReadUInt16()];
            Symbol end = grammarTables.Symbols[ReadUInt16()];
            GroupAdvanceMode advance = ReadAdvanceMode();
            GroupEndingMode ending = ReadEndingMode();
            //Reserved; skip
            ReadEntry();

            Group group = new Group(index, name, container, start, end, advance, ending);

            ushort nestingsCount = ReadUInt16();
            for(int i = 0; i < nestingsCount; i++)
            {
                group.Nesting.Add(ReadUInt16());
            }

            group.Container.Group = group.Start.Group = group.End.Group = group;

            return group;
        }

        internal CharacterRange ReadCharacterRange()
        {
            return new CharacterRange(ReadUInt16(), ReadUInt16());
        }

        internal CharacterSet ReadCharacterSet()
        {
            ushort index = ReadUInt16();
            //'Unicode Plane'?; skip
            ReadUInt16();
            ushort rangeCount = ReadUInt16();
            //Reserved; skip
            ReadEntry();

            CharacterSet charSet = new CharacterSet(index, rangeCount);
            while(!IsRecordComplete())
            {
                charSet.Add(ReadCharacterRange());
            }
            return charSet;
        }

        internal Production ReadProduction()
        {
            ushort index = ReadUInt16();
            ushort headIndex = ReadUInt16();
            //Reserved; skip
            ReadEntry();

            Production prod = new Production(grammarTables.Symbols[headIndex], index);
            while (!IsRecordComplete())
            {
                prod.Handle.Add(grammarTables.Symbols[ReadUInt16()]);
            }
            return prod;
        }

        internal FAEdge ReadFAEdge()
        {
            ushort index = ReadUInt16();
            ushort target = ReadUInt16();
            //Reserved; skip
            ReadEntry();

            return new FAEdge(grammarTables.CharacterSets[index], target);
        }

        internal FAState ReadFAState()
        {
            ushort index = ReadUInt16();
            bool accept = ReadBoolean();
            ushort acceptIndex = ReadUInt16();
            //Reserved; skip
            ReadEntry();

            FAState faState = accept ? new FAState(index, grammarTables.Symbols[acceptIndex]) : new FAState(index);

            while(!IsRecordComplete())
            {
                faState.Edges.Add(ReadFAEdge());
            }

            return faState;
        }

        internal LRAction ReadLRAction()
        {
            ushort index = ReadUInt16();
            LRActionType actionType = ReadActionType();
            ushort target = ReadUInt16();
            //Reserved; skip
            ReadEntry();

            return new LRAction(grammarTables.Symbols[index], actionType, target);
        }

        internal LRActionList ReadLRActionList()
        {
            ushort index = ReadUInt16();
            //Reserved; skip
            ReadEntry();

            LRActionList actionList = new LRActionList(index);

            while (!IsRecordComplete())
            {
                actionList.Add(ReadLRAction());
            }

            return actionList;
        }

        internal Symbol ReadSymbol()
        {
            ushort index = ReadUInt16();
            string name = ReadString();
            SymbolType type = ReadSymbolType();

            return new Symbol(name, type, index);
        }

        internal bool IsRecordComplete()
        {
            return recordEntriesRead >= recordEntriesCount;
        }

        public void Dispose()
        {
            if (binaryReader != null)
            {
                binaryReader.Dispose();
                binaryReader = null;
            }
        }
    }
}
