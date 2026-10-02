public class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }

        int original = n;
        long reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }

        return reversed == original;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("121: " + sol.isPalindrome(121));
        System.out.println("-121: " + sol.isPalindrome(-121));
        System.out.println("10: " + sol.isPalindrome(10));
        System.out.println("12321: " + sol.isPalindrome(12321));
    }
}