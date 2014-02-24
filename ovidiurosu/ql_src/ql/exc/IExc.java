package ql.exc;

import java.io.PrintStream;

/**
 * Exception Interface
 * @author orosu
 */
public interface IExc
{
    public Integer getLevel();
    public String getMessage();
    public void printStackTrace(PrintStream printStream);
}
