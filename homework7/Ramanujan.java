public class Ramanujan {
    public static boolean isRamanujan(long n) {
        long count = 0;
        long a = 1;
        long b = (long) Math.cbrt(n - a * a * a);
        while (a <= b) {
            if (a * a * a + b * b * b == n) {
                // StdOut.println(a + "^3 + " + b + "^3 = " + n);
                count++;
            }
            a++;
            b = (long) Math.cbrt(n - a * a * a);
        }
        return count > 1;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
