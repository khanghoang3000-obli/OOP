public class Solution {
    public int sumOfDigits(int n) {
        n = Math.abs(n);
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("sumOfDigits(123) = " + sol.sumOfDigits(123));
        System.out.println("sumOfDigits(-456) = " + sol.sumOfDigits(-456));
        System.out.println("sumOfDigits(0) = " + sol.sumOfDigits(0));
    }
}