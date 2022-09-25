public class GreatCircle {
    public static void main(String[] args) {
        // read 4 arguments x1, y1, x2, y2;
        // transfer to radians from degrees;
        double x_1 = Math.toRadians(Double.parseDouble(args[0]));
        double y_1 = Math.toRadians(Double.parseDouble(args[1]));
        double x_2 = Math.toRadians(Double.parseDouble(args[2]));
        double y_2 = Math.toRadians(Double.parseDouble(args[3]));
        // calculate distance based on Haversine formula;
        double dx = Math.sin((x_2 - x_1) / 2);
        double dx2 = dx * dx;
        double dy = Math.sin((y_2 - y_1) / 2);
        double dy2 = dy * dy;
        double q = Math.cos(x_1) * Math.cos(x_2) * dy2;
        // r = 6371.0 is the average radius of the Earth;
        double r = 6371.0;
        double distance = 2 * r * Math.asin(Math.sqrt(dx2 + q));
        // output distance;
        System.out.println(distance + " kilometers");
    }
}
