using System.Diagnostics;
using System.IO;
using System.Linq;
using GOLD.Engine.Enums;

namespace GOLD.Engine.EGT
{
    internal class EGTDataManager
    {
        internal GrammarProperties GrammarProperties { get; private set; }
        private GrammarTables GrammarTables;

        internal EGTDataManager(BinaryReader reader)
        {
            LoadEGT(reader);
        }

        private void LoadEGT(BinaryReader reader)
        {
            using (EGTReader egtReader = new EGTReader(reader))
            {
                while (egtReader.GetNextRecord())
                {
                    switch (egtReader.ReadRecordType())
                    {
                        case EGTRecord.Property:
                            GrammarProperties = new GrammarProperties();
                            GrammarProperties.SetProperty(egtReader.ReadGrammarProperty());
                            break;

                        case EGTRecord.TableCounts:
                            GrammarTables = egtReader.ReadGrammarTables();
                            break;

                        case EGTRecord.InitialStates:
                            //DFA, LALR
                            ushort dfaState = egtReader.ReadUInt16();
                            ushort lalrState = egtReader.ReadUInt16();

                            Debug.Assert(dfaState == 0, "The initial DFA State is not 0!");
                            Debug.Assert(lalrState == 0, "The initial LALR State is not 0!");
                            break;

                        case EGTRecord.Symbol:
                            Symbol sym = egtReader.ReadSymbol();
                            GrammarTables.Symbols[sym.TableIndex] = sym;
                            break;

                        case EGTRecord.Group:
                            Group group = egtReader.ReadGroup();
                            GrammarTables.Groups[group.TableIndex] = group;
                            break;

                        case EGTRecord.CharRanges:
                            CharacterSet charSet = egtReader.ReadCharacterSet();
                            GrammarTables.CharacterSets[charSet.Index] = charSet;
                            break;

                        case EGTRecord.Production:
                            Production prod = egtReader.ReadProduction();
                            GrammarTables.Productions[prod.TableIndex] = prod;
                            break;

                        case EGTRecord.DFAState:
                            FAState faState = egtReader.ReadFAState();
                            GrammarTables.FAStates[faState.TableIndex] = faState;
                            break;

                        case EGTRecord.LRState:
                            LRActionList actionList = egtReader.ReadLRActionList();
                            GrammarTables.LRActionLists[actionList.Index] = actionList;
                            break;
                    }
                }
            }
        }

        internal Symbol GetFirstSymbolOfType(SymbolType type)
        {
            return GrammarTables.Symbols.FirstOrDefault(s => s.Type == type);
        }

        internal Production GetProduction(ushort tableIndex)
        {
            return GrammarTables.Productions[tableIndex];
        }

        internal FAState GetFAState(int tableIndex)
        {
            return GrammarTables.FAStates[tableIndex];
        }

        internal LRActionList GetLRActionList(ushort tableIndex)
        {
            return GrammarTables.LRActionLists[tableIndex];
        }
    }
}
