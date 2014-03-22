package ql.error;

/**
 * @author orosu
 */
public class TypeError extends Exception implements IError
{
    private static final long serialVersionUID = 1L;

    public TypeError(String message)
    {
        super("ERROR! " + message);
    }

    @Override
    public Integer getLevel()
    {
        return 1;
    }

    @Override
    public boolean equals(IError error)
    {
        return error instanceof TypeError && this.getMessage().equals(error.getMessage());
    }
}
