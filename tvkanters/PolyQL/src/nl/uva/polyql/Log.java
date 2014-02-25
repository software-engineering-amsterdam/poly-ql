package nl.uva.polyql;

public class Log {

    private static final boolean INFO_ENABLED = false;
    private static final boolean ERROR_ENABLED = false;

    public static void i(final String msg) {
        if (INFO_ENABLED) {
            System.out.println(msg);
        }
    }

    public static void e(final String msg) {
        if (ERROR_ENABLED) {
            System.err.println(msg);
        }
    }
}
