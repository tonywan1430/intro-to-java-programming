public class RevesPuzzle {
    public static void hanoi4(String start, String temp1, String temp2, String end, int n) {
        if (n == 0) StdOut.print("n should be positive");
        else {
            if (n == 1) StdOut.println("Move disc " + n + " from " + start + " to " + end);
            else {
                int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
                // transfer k smallest discs to temp2
                hanoi4(start, end, temp1, temp2, k);
                // transfer the remaining n - k discs to end without using temp2
                hanoi3(start, temp1, end, (k + 1), n);
                // transfer k smallest discs from temp2 to end
                hanoi4(temp2, start, temp1, end, k);
            }
        }
    }

    private static void hanoi3(String start, String temp, String end, int m, int n) {
        // transfer disc m, m + 1, ..., n from start to end using temp location
        if (m == n) StdOut.println("Move disc " + m + " from " + start + " to " + end);
        else {
            // transfer disc m, m + 1, ..., n - 1 from start to temp using end
            hanoi3(start, end, temp, m, n - 1);
            // transfer disc n from start to end directly
            StdOut.println("Move disc " + n + " from " + start + " to " + end);
            // transfer disc m, m + 1, ..., n - 1 from temp to end using start
            hanoi3(temp, start, end, m, n - 1);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n <= 0) StdOut.print("n should be positive");
        // run hanoi4 method
        hanoi4("A", "B", "C", "D", n);
    }
}
