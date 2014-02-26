package nl.uva.polyql;

public class Log {

    private static boolean sInfoEnabled = true;
    private static boolean sErrorEnabled = true;

    public static void disable() {
        sInfoEnabled = false;
        sErrorEnabled = false;
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
