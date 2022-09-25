public class RightTriangle {
    public static void main(String[] args) {
        // read 3 arguments: a, b, c for 3 edges of triangle
        double a = Integer.parseInt(args[0]);
        double b = Integer.parseInt(args[1]);
        double c = Integer.parseInt(args[2]);
        // check if all arguments are positive;
        boolean isPositive = (a > 0) && (b > 0) && (c > 0);
        // check for pythagorean equations;
        boolean RightTriangle = isPositive && ((a * a + b * b == c * c) ||
                (a * a + c * c == b * b) || (c * c + b * b == a * a));
        System.out.println(RightTriangle);
    }
}
