public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    // StdOut.printf("when i is %d and j is %d, color is blue \n", i, j);
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    // StdOut.printf("when i is %d and j is %d, color is light gray \n", i, j);
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
