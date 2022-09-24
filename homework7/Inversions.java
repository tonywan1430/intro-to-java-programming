public class Inversions {
    public static long count(int[] a) {
        int n = a.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) count++;
            }
        }
        return count;
    }

    public static int[] generate(int n, long k) {
        if (n == 0) return new int[0];
        int[] a = new int[n];
        // inital array
        long kRemain = k;
        int nStart = n - 1;
        int indexStart = 0;
        while (kRemain > nStart) {
            a[indexStart] = nStart;
            kRemain += -nStart;
            nStart += -1;
            indexStart += 1;
        }
        a[indexStart] = (int) kRemain;
        indexStart += 1;

        int i = 0;
        while (i < kRemain) {
            a[indexStart] = i;
            indexStart++;
            i++;
        }
        int j = (int) kRemain + 1;
        while (j <= nStart) {
            a[indexStart] = j;
            indexStart++;
            j++;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        // System.out.println("n = " + n + ", " + "k = " + k);
        int[] a = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        // System.out.println();
        // System.out.println("count = " + count(a));


    }
}
