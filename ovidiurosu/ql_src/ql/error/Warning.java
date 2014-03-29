package ql.error;

/**
 * @author orosu
 */
public class Warning extends Exception implements IError
{
    private static final long serialVersionUID = 1L;

    public Warning(String message)
    {
        super("WARNING! " + message);
    }

    @Override
    public Integer getLevel()
    {
        return 5;
    }

    @Override
    public boolean equals(IError error)
    {
        return error instanceof Warning && this.getMessage().equals(error.getMessage());
    }
}
