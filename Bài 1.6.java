public class Solution {
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("-5 la SNT: " + sol.isPrime(-5));
        System.out.println("0 la SNT: " + sol.isPrime(0));
        System.out.println("1 la SNT: " + sol.isPrime(1));
        System.out.println("2 la SNT: " + sol.isPrime(2));
        System.out.println("97 la SNT: " + sol.isPrime(97));
        System.out.println("100 la SNT: " + sol.isPrime(100));
    }
}