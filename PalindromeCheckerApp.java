// Palindrome Service Class (Encapsulated Logic)
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        // Normalize (case-insensitive & ignore non-alphanumeric)
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}


// Main Application Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Madam In Eden Im Adam";

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        System.out.println("======================================");
        System.out.println("Palindrome Checker App - UC11 (OOPS)");
        System.out.println("======================================");
        System.out.println("Given String: " + input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}