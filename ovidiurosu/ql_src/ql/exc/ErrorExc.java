package ql.exc;

/**
 * Error Exception
 * @author orosu
 */
public class ErrorExc extends Exception implements IExc
{
    /**
     * Serial Version Unique ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public ErrorExc(String message)
    {
        super("ERROR! " + message);
    }

    @Override
    public Integer getLevel()
    {
        return 1;
    }

}
