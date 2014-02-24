package ql.exc;

/**
 * Notice Exception
 * @author orosu
 */
public class NoticeExc extends Exception implements IExc
{
    /**
     * Serial Version Unique ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public NoticeExc(String message)
    {
        super("NOTICE! " + message);
    }

    @Override
    public Integer getLevel()
    {
        return 10;
    }

}
