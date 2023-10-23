package mainapp;

public class PrintUtils {
    private PrintUtils() {
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public static void printSegment(String segmentTitle) {
        System.out.println(ANSI_CYAN + "--------------------------------");
        System.out.printf("> %s%s%n", segmentTitle, ANSI_RESET);
    }

    public static void printSubSegment(String message) {
        System.out.printf("%s>> %s%s%n", ANSI_BLUE, message, ANSI_RESET);
    }

    public static void printMessage(String message) {
        System.out.printf("%s>>> %s%s%n", ANSI_PURPLE, message, ANSI_RESET);
    }
}
