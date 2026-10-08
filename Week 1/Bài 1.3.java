public class Solution {
    public long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        long f0 = 0;
        long f1 = 1;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - f1 < f0) {
                return Long.MAX_VALUE;
            }
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("n = -2: " + sol.fibonacci(-2));
        System.out.println("n = 0: " + sol.fibonacci(0));
        System.out.println("n = 10: " + sol.fibonacci(10));
        System.out.println("n = 92: " + sol.fibonacci(92));
        System.out.println("n = 95: " + sol.fibonacci(95));
    }
}