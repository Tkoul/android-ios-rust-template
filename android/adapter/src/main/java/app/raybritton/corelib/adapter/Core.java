package app.raybritton.corelib.adapter;

public class Core {

    static {
        System.loadLibrary("jvm_adapter_rust");
    }

    private static native int add_int(int lhs, int rhs);
    private static native String reverse_string(String text);

    public static int add(int lhs, int rhs) {
        return add_int(lhs, rhs);
    }

    public static String reverse(String text) {
        return reverse_string(text);
    }
}

