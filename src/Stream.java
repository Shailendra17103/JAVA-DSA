public class Stream {
    public static void main(String[] args) {
        System.out.println(skipAppNotApple("bappcapplecdah")); // Calls the single-parameter skip method
    }

    // Skip method that takes a processed and an unprocessed string
    static void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        if (ch == 'a') {
            skip(p, up.substring(1)); // Skip 'a'
        } else {
            skip(p + ch, up.substring(1)); // Add character to processed string
        }
    }

    // Skip method that processes the string and returns the result
    static String skip(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip(up.substring(1)); // Skip 'a'
        } else {
            return ch + skip(up.substring(1)); // Include character and process remaining
        }
    }

    static String skipApple(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if (up.startsWith("apple")) {
            return skipApple(up.substring(5)); // Skip 'a'
        } else {
            return up.charAt(0)+ skipApple(up.substring(1)); // Include character and process remaining
        }
    }
    static String skipAppNotApple(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3)); // Skip 'a'
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1)); // Include character and process remaining
        }
    }
}
