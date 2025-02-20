package HW2;

public class Palindrome implements PalindromeInterface {

    @Override
    public boolean isPalindrome(String rawInput) {
        if (rawInput == null) {
            return false;
        }

        // stack for characters for palindrome check
        MyStack<Character> palindromeStack = new MyStack<>(); 

        // StringBuilder to hold the cleaned input string -- ref MyArrayList.java lecture 6
        StringBuilder sb = new StringBuilder();

        // clean input to ignore spaces, make case insensitive
        rawInput = rawInput.toLowerCase();
        for (int i = 0; i < rawInput.length(); i++) {
            char c = rawInput.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
                palindromeStack.push(c);
            }
        }

        // see if cleaned input is palindrome
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != palindromeStack.pop()) {
                return false;
            }
        }

        return true;
    }
}
