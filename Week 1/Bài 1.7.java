public class Solution {
    public int reverse(int n) {
        long reversed = 0;
        int temp = Math.abs(n);

        while (temp > 0) {
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
        }

        if (n < 0) {
            reversed = -reversed;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversed;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("reverse(123) = " + sol.reverse(123));
        System.out.println("reverse(-456) = " + sol.reverse(-456));
        System.out.println("reverse(1200) = " + sol.reverse(1200));
        System.out.println("reverse(1000000009) = " + sol.reverse(1000000009));
    }
}