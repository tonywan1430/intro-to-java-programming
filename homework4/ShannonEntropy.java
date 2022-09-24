public class ShannonEntropy {
    public static void main(String[] args) {
        // read parameter from command line;
        int m = Integer.parseInt(args[0]);
        // declare table counting the number of times appearing in the sequence;
        int[] table = new int[m];
        // read a sequence of integers between 1 and m from standard input
        int count = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            table[x - 1] += 1;
            count++;
        }
//        StdOut.printf("count is %d\n", count);

        double res = 0;
        double p;
        for (int i = 0; i < m; i++) {
            if (table[i] > 0) {
                p = (double) table[i] / count;
//                 StdOut.printf("i = %d ", i);
//                 StdOut.printf("p is %.4f\n", p);
                res -= p * Math.log(p) / Math.log(2);
            }

        }
        StdOut.printf("%.4f\n", res);
    }
}
