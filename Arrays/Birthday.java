public class Birthday {
    public static void main(String[] args) {
        // read parameters; n: number of birthday days;
        // trails: number of simulation experiment trials;
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        // declare birthday boolean array;
        boolean[] birthday;
        // declare count array recording the number of persons until we have match birthday
        int[] countArray;
        // inital value zeros;
        countArray = new int[n + 2];

        for (int i = 1; i <= trails; i++) {
            // inital birthday;
            int q = 0;
            int count = 1;
            birthday = new boolean[n];
            while (!birthday[q]) {
                // add 1 to count;
                count++;
                // change birthday[q] to true;
                birthday[q] = true;
                // sample next person;
                q = (int) (Math.random() * n);
            }
            countArray[count] += 1;
        }
        // print countArray
//        for (int i = 0; i <= n + 1; i++) {
//            System.out.print(countArray[i] + " ");
//        }

        double cumProb = 0;
        int j = 1;
        // output
        while (cumProb < 0.5) {
            System.out.print(j + "  " + countArray[j] + "   " + cumProb);
            System.out.println();
            j++;
            cumProb += (double) countArray[j] / trails;
        }
        // print the one exact greater than 0.5;
        System.out.print(j + "  " + countArray[j] + "   " + cumProb);

    }
}
