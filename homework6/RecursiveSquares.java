public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        // (x, y) is the center of the square,
        // draw lines with black pen
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length * 0.5);
        // fill with light gray;
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length * 0.5);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        double x0 = x - length * 0.5;
        double x1 = x + length * 0.5;
        double y0 = y - length * 0.5;
        double y1 = y + length * 0.5;
        // note the middle square will cover the upper small squares;
        // and and lower small squares will cover the middle square;
        draw(n - 1, x0, y1, length * 0.5);
        draw(n - 1, x1, y1, length * 0.5);
        drawSquare(x, y, length);
        draw(n - 1, x0, y0, length * 0.5);
        draw(n - 1, x1, y0, length * 0.5);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }

}
