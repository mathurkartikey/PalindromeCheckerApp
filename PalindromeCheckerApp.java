import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

/* Strategy Interface */
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}


/* Stack Based Strategy */
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


/* Deque Based Strategy */
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < normalized.length(); i++) {
            deque.addLast(normalized.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}


/* Main Application Class */
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Choose Strategy at Runtime
        PalindromeStrategy strategy;

        // Change this line to switch algorithms:
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        boolean result = strategy.checkPalindrome(input);

        System.out.println("======================================");
        System.out.println("Palindrome Checker App - UC12");
        System.out.println("Strategy Pattern Implementation");
        System.out.println("======================================");
        System.out.println("Given String: " + input);
        System.out.println("Using Strategy: " + strategy.getClass().getSimpleName());

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}