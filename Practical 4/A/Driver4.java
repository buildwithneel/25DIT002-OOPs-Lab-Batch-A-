public class Driver4 {
    public static void main(String[] args) {
        String[] passwords = {
            "abc",
            "abcdefgh",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };
        for (String pw : passwords) {
            System.out.println("Password: " + pw);
            System.out.println("Length >= 8: " + PasswordChecker.lengthCheck(pw));
            System.out.println("Uppercase: " + PasswordChecker.uppercaseCheck(pw));
            System.out.println("Digit: " + PasswordChecker.digitCheck(pw));
            System.out.println("Special character: " + PasswordChecker.specialCheck(pw));
            System.out.println("Strength: " + PasswordChecker.strength(pw));
            System.out.println();
        }
    }
}
