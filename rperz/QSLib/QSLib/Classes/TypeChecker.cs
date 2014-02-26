using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib
{
    public static class TypeChecker
    {
        private static List<String> errorList = new List<String>();

        public static bool CheckTypes(Form f)
        {
            // we need to clear the errorlist from a previous parsing job
            errorList.Clear();
            return f.CheckType();
        }

        internal static void ReportDuplicate(String name, int line)
        {
            errorList.Add("Duplicate declaration of " + name + "; line number: " + line);
        }

        internal static void ReportUndeclared(String name, int line)
        {
            errorList.Add("Variable " + name + " is used before being declared; line number: " + line);
        }

        internal static void ReportTypeMismatch(Type t1, Type t2, int line)
        {
            errorList.Add(t1.ToString() + " is not compatible with " + t2.ToString() +
                            "; line number: " + line);
        }

        internal static void ReportTypeMismatch(Type t1, Type t2, String op, int line)
        {
            errorList.Add("Operator " + op + " cannot be used with types " + t1.ToString() + " and " + 
                            t2.ToString() + "; line number: " + line);
        }

        internal static void ReportTypeMismatch(Type t1, String op, int line)
        {
            errorList.Add("Operator " + op + " cannot be used with type " + t1.ToString() + 
                            "; line number: " + line);
        }

        internal static void ReportEmptyBlockWarning(string blocktype, int line)
        {
            errorList.Add("Warning: empty code block in " + blocktype + " block" +
                            "; line number: " + line);
        }

        public static String GetCheckerOutput()
        {
            String retVal = "";
            foreach (String s in errorList)
            {
                retVal += s + "\r\n";
            }

            return retVal;
        }


    }
}
