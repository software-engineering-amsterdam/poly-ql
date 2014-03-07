﻿namespace QSLib.Types
{
    public abstract class QSType 
    {
        public abstract string Name { get; }

        public virtual bool IsCompatible(QSType other)
        {
            return false;
        }

        public virtual bool IsBoolean()
        {
            return false;
        }

        public virtual bool IsString()
        {
            return false;
        }

        public virtual bool IsNumber()
        {
            return false;
        }
    }
}