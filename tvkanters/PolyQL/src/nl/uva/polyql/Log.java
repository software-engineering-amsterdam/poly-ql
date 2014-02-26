package nl.uva.polyql;

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

    public static void i(final String msg) {
        if (sInfoEnabled) {
            System.out.println(msg);
        }
    }

    public static void e(final String msg) {
        if (sErrorEnabled) {
            System.err.println(msg);
        }
    }
}
