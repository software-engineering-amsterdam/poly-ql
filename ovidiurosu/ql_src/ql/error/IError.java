package ql.error;

import java.io.PrintStream;

/**
 * @author orosu
 */
public interface IError
{
    public Integer getLevel();
    public String getMessage();
    public void printStackTrace(PrintStream printStream);
}
