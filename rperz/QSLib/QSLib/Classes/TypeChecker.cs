using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib
{
    public static class TypeChecker
    {
        private static List<String> errorList = new List<String>();
        public static void ReportDuplicate(String name, int line)
        {
            errorList.Add("Duplicate declaration of " + name + "; line number: " + line);
        }

        public static void ReportUndeclared(String name, int line)
        {
            errorList.Add("Variable " + name + " is used before being declared; line number: " + line);
        }

        public static void ReportTypeMismatch(Type t1, Type t2, int line)
        {
            errorList.Add(t1.ToString() + " is not compatible with " + t2.ToString() +
                            "; line number: " + line);
        }

        public static void ReportTypeMismatch(Type t1, Type t2, String op, int line)
        {
            errorList.Add("Operator " + op + " cannot be used with types " + t1.ToString() + " and " + 
                            t2.ToString() + "; line number: " + line);
        }

        public static void ReportTypeMismatch(Type t1, String op, int line)
        {
            errorList.Add("Operator " + op + " cannot be used with type " + t1.ToString() + 
                            "; line number: " + line);
        }
    }
}
