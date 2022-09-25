public class ThueMorse {
    public static void main(String[] args) {
        // read parameter n from command line
        // assume n is positive, but not need to be the power of 2;
        int n = Integer.parseInt(args[0]);
        int[] a;
        a = new int[n];

        // generate Thue–Morse sequence;
        for (int k = 0; k < (n / 2); k++) {
            // System.out.print(k);
            a[(2 * k)] = a[k];
            a[(2 * k + 1)] = 1 - a[k];
        }
        // add case for last one for odds length array;
        if (n % 2 == 1) {
            a[(n - 1)] = a[(n - 1) / 2];
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i]);
//        }
//        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
