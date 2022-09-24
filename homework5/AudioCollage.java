public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        int n = a.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = alpha * a[i];
        }
        return res;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[a.length - i - 1];
        }
        return res;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int n = a.length + b.length;
        double[] res = new double[n];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            res[i + a.length] = b[i];
        }

        return res;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int n = Math.max(a.length, b.length);
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            if (i >= a.length) {
                res[i] = b[i];
            } else {
                if (i >= b.length) {
                    res[i] = a[i];
                } else {
                    res[i] = a[i] + b[i];
                }
            }
        }
        return res;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        int n = a.length;
        int samples = (int) (n / alpha);
        double[] res = new double[samples];
        for (int i = 0; i < samples; i++) {
            res[i] = a[(int) (i * alpha)];
        }
        return res;
    }

    public static void main(String[] args) {
        double[] samples1 = StdAudio.read("piano.wav");
        double[] samples2 = StdAudio.read("singer.wav");
        double[] samples3 = StdAudio.read("buzzer.wav");
        double[] samples4 = StdAudio.read("beatbox.wav");
        double[] samples5 = StdAudio.read("harp.wav");


        double[] res1 = amplify(samples3, 0.5);
        double[] res2 = amplify(res1, 0.2);
        double[] res3 = mix(res1, res2);
        double[] res4 = merge(res3, samples1);
        double[] res5 = merge(res4, samples2);
        double[] res6 = reverse(samples4);
        double[] res7 = changeSpeed(samples4, 1.5);
        double[] res8 = merge(res7, res6);
        double[] res9 = merge(res5, res8);
        double[] res10 = merge(res9, samples5);
        StdAudio.play(res10);
    }
}
