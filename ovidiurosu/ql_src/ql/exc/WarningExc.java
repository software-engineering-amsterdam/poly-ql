package ql.exc;

/**
 * Warning Exception
 * @author orosu
 */
public class WarningExc extends Exception implements IExc
{
    /**
     * Serial Version Unique ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public WarningExc(String message)
    {
        super("WARNING! " + message);
    }

    @Override
    public Integer getLevel()
    {
        return 5;
    }

}
