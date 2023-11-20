package util;

public class ValorUtil {

    public static boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNotEmptyString(String string) {
        return !isEmptyString(string);
    }
}
