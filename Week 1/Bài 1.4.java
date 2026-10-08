public class Solution {
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("gcd(12, 18) = " + sol.gcd(12, 18));
        System.out.println("gcd(-24, 36) = " + sol.gcd(-24, 36));
        System.out.println("gcd(0, 5) = " + sol.gcd(0, 5));
        System.out.println("gcd(7, 13) = " + sol.gcd(7, 13));
    }
}