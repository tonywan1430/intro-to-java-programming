public class Minesweeper {
    public static void main(String[] args) {
        // load parameters:
        // m-by-n grid of mines;
        // k: number of mine in the grid;
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        // inital k mines in the grid;
        boolean[][] mines;
        mines = new boolean[m][n];
        int[][] minesCount;
        minesCount = new int[m][n];
        // randomly set k mines in grid;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count < k) {
                    mines[i][j] = true;
                    count++;
                }
            }
        }
        // Then shuffle the grid;
        // shuffle 10 times;
        for (int s = 1; s <= 10; s++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int p = i + (int) (Math.random() * (m - i));
                    int q = j + (int) (Math.random() * (n - j));
                    boolean t = mines[i][j];
                    mines[i][j] = mines[p][q];
                    mines[p][q] = t;
                }
            }

        }

        // update mines count;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!mines[i][j]) {
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            if ((i + di >= 0) && (i + di < m) && (j + dj >= 0) && (j + dj < n)) {
                                if (mines[i + di][j + dj]) {
                                    // if there is a mine in neighbor, add one to count;
                                    minesCount[i][j] += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        // output;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    System.out.print("*  ");
                } else {
                    System.out.print(minesCount[i][j] + "  ");
                }
            }
            System.out.println();
        }

    }
}
