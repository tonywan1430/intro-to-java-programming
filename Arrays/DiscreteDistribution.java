public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        // S for cumulative sum S[i] = a[1] + a[2] + ... + a[i];
        int[] S;
        int n = args.length;
        S = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                // cumulative sum
                S[j] += Integer.parseInt(args[i]);
            }
            // System.out.println("S[" + i + "] = " + S[i]);
        }

        for (int k = 0; k < m; k++) {
            int r = (int) (Math.random() * S[n - 1]);
            // System.out.print("r = " + r + " ");
            for (int j = 1; j <= n; j++) {
                if ((r >= S[j - 1]) && (r < S[j])) {
                    System.out.print(j + " ");
                    // System.out.println();
                }
            }
        }
    }
}
