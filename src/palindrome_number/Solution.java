package palindrome_number;

public class Solution {

    public static boolean isPalindrome(int x) {
        var num = String.valueOf(x);
        int n = num.length();
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) != num.charAt(n - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

}
