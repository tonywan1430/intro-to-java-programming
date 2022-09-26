public class ColorHSB {
    private int hue;
    private int saturation;
    private int brightness;

    public ColorHSB(int h, int s, int b) {
        hue = h;
        saturation = s;
        brightness = b;
        if ((h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        String stringHSB = "(" + Integer.toString(hue) + ", " + Integer.toString(saturation) + ", " + Integer.toString(brightness) + ")";
        return stringHSB;
    }

    public boolean isGrayscale() {
        return (saturation == 0) || (brightness == 0);
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("invalid input colorHSB");
        int h1 = (hue - that.hue) * (hue - that.hue);
        int h2 = (360 - Math.abs(hue - that.hue)) * (360 - Math.abs(hue - that.hue));
        int s1 = (saturation - that.saturation) * (saturation - that.saturation);
        int b1 = (brightness - that.brightness) * (brightness - that.brightness);
        int distance = Math.min(h1, h2) + s1 + b1;
        return distance;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB myColor = new ColorHSB(h, s, b);
        ColorHSB nearestColor = myColor;
        String nearestName = "";
        int maxDis = 360 * 360 + 100 * 100 * 2;
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB color2 = new ColorHSB(h2, s2, b2);
            if (maxDis > myColor.distanceSquaredTo(color2)) {
                nearestColor = color2;
                nearestName = name;
                maxDis = myColor.distanceSquaredTo(color2);
            }
        }
        StdOut.println(nearestName + " " + nearestColor.toString());

    }
}
