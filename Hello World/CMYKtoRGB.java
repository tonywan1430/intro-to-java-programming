public class CMYKtoRGB {
    public static void main(String[] args) {
        // Read 4 arguments: cyan, magenta, yellow and black (CMYK)
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        // calculate white, red, green, blue based on following equations;
        double white = 1 - black;
        double red = 255 * white * (1 - cyan);
        double green = 255 * white * (1 - magenta);
        double blue = 255 * white * (1 - yellow);
        // round to nearest integer and convert to int type;
        int R = (int) Math.round(red);
        int G = (int) Math.round(green);
        int B = (int) Math.round(blue);
        // output RGB results;
        System.out.println("red   = " + R);
        System.out.println("green = " + G);
        System.out.println("blue  = " + B);

    }
}
