public class WorldMap {
    public static void main(String[] args) {
        // read width and height;
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        // StdOut.printf("width = %d, height = %d \n", width, height);

        // set canvas size
        StdDraw.setCanvasSize(width, height);
        // set scale of X and Y axis
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        // to improve performance
        StdDraw.enableDoubleBuffering();
        while (!StdIn.isEmpty()) {
            // read number of vertice;
            String name = StdIn.readString();
            // StdOut.print(name);
            int n = StdIn.readInt();
            double[] x = new double[n];
            double[] y = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
