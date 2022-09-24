public class Divisors {
    public static int gcd(int a, int b) {
        // by convention if a or b = 0, then gcd(a, b) = 0
        if (a == 0 && b == 0) {
            return 0;
        }
        // replace a, b with |a| and |b|
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        // change the order if a < b:
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        // Euclid’s algorithm
        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        // by convention if a or b = 0, then lcm(a, b) = 0
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        // note a * b might cause overflow
        return a / gcd(a, b)  * b;
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int totient(int a) {
        int res = 0;
        for (int i = 1; i <= a; i++) {
            if (areRelativelyPrime(a, i)) res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }


}
