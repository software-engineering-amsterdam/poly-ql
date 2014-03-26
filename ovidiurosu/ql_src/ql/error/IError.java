package ql.error;


/**
 * @author orosu
 */
public interface IError
{
    public Integer getLevel();
    public String getMessage();

    public boolean equals(IError error);
}
