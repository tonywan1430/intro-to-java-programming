public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int n = a.length;
        int[][] size = new int[n][n];
        // set initial conditionals;
        for (int i = 0; i < n; i++) {
            size[i][n - 1] = a[i][n - 1];
        }
        for (int j = 0; j < n; j++) {
            size[n - 1][j] = a[n - 1][j];
        }
        // dynamic programing;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    size[n - i][n - j] = a[n - i][n - j];
                } else {
                    if (a[n - i][n - j] == 0) size[n - i][n - j] = 0;
                    else {
                        size[n - i][n - j] = 1 + Math.min(Math.min(size[n - i + 1][n - j], size[n - i][n - j + 1]), size[n - i + 1][n - j + 1]);
                    }
                }
            }
        }
        // find the max value in matrix;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (size[i][j] > maxSize) maxSize = size[i][j];
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));

    }
}
