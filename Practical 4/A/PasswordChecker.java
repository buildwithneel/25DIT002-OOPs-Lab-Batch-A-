public class PasswordChecker {
    public static boolean lengthCheck(String pw) {
        return pw.length() >= 8;
    }
    public static boolean uppercaseCheck(String pw) {
        return pw.matches(".*[A-Z].*");
    }
    public static boolean digitCheck(String pw) {
        return pw.matches(".*\\d.*");
    }

    public static boolean specialCheck(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

    public static String strength(String pw) {
        int count = 0;
        if (lengthCheck(pw)) count++;
        if (uppercaseCheck(pw)) count++;
        if (digitCheck(pw)) count++;
        if (specialCheck(pw)) count++;

        if (count <= 1) {
            return "Weak";
        } else if (count <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }

    }
}