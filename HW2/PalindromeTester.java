package HW2;

public class PalindromeTester {
    public static void main(String[] args) {

        Palindrome x = new Palindrome();

        System.out.println(x.isPalindrome("asdf"));
        System.out.println(x.isPalindrome("R o T a tor"));
        System.out.println(x.isPalindrome("abcdcba"));
        System.out.println(x.isPalindrome("race cars"));
        System.out.println(x.isPalindrome("race car"));

    }

}
