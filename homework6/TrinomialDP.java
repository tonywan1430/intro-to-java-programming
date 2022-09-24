public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if ((k > n) || (k < -n)) return 0;
        long[] prev = new long[2 * n + 1];
        long[] curr = new long[2 * n + 1];
        prev[n] = 1;
        curr[n] = 1;
        for (int i = 1; i <= n; i++) {
            // set boundary value;
            curr[n - i] = 1;
            curr[n + i] = 1;
            // update by T(n,k) = T(n−1,k−1) + T(n−1,k) + T(n−1,k+1)
            for (int p = (-i + 1); p < i; p++) {
                curr[n + p] = prev[n + p - 1] + prev[n + p] + prev[n + p + 1];
            }
            // update prev <- curr;
            for (int j = 0; j <= 2 * n; j++) {
                prev[j] = curr[j];
            }
        }
        return curr[n + k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
