package ql.error;

/**
 * @author orosu
 */
public class Notice extends Exception implements IError
{
    private static final long serialVersionUID = 1L;

    public Notice(String message)
    {
        super("NOTICE! " + message);
    }

    @Override
    public Integer getLevel()
    {
        return 10;
    }

    @Override
    public boolean equals(IError error)
    {
        return error instanceof Notice && this.getMessage().equals(error.getMessage());
    }
}
