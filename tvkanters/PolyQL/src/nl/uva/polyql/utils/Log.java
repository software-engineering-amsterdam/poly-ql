package nl.uva.polyql.utils;

public class Log {

    private static boolean sInfoEnabled = true;
    private static boolean sErrorEnabled = true;

    public static void setLogging(final boolean logging) {
        sInfoEnabled = logging;
        sErrorEnabled = logging;
    }

    public static void setInfoLogging(final boolean logging) {
        sInfoEnabled = logging;
    }

    public static void setErrorLogging(final boolean logging) {
        sErrorEnabled = logging;
    }

    /**
     * Logs messages on an info (regular) level. Will not print with logging disabled.
     * 
     * @param msg
     *            The message to print
     */
    public static void i(final String msg) {
        if (sInfoEnabled) {
            System.out.println(msg);
        }
    }

    /**
     * Logs messages on an error level. Will not print with logging disabled.
     * 
     * @param msg
     *            The message to print
     */
    public static void e(final String msg) {
        if (sErrorEnabled) {
            System.err.println(msg);
        }
    }
}
