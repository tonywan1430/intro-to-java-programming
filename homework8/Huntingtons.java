public class Huntingtons {
    public static int maxRepeats(String dna) {
        int n = dna.length();
        int i = 0;
        // max number of repeats
        int repeats = 0;
        // count the number of repeats in one substring
        int counts = 0;
        while (i < n - 2) {
            String tmp = dna.substring(i, i + 3);
            if (tmp.equals("CAG")) {
                i += 3;
                counts += 1;
                if (counts > repeats) repeats = counts;
            } else {
                i++;
                counts = 0;
            }
        }
        return repeats;
    }

    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\t", "");
        s = s.replace("\n", "");
        return s;
    }

    public static String diagnose(int maxRepeats) {
        if ((maxRepeats >= 0 && maxRepeats <= 9) || (maxRepeats >= 181)) return "not human";
        if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
        if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
        else return "Huntington's";
        // if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington's";
    }

    public static void main(String[] args) {
        // use In class
        In readIn = new In(args[0]);
        // read string of gene
        String s = readIn.readAll();
        // remove white space
        String dna = removeWhitespace(s);
        // count the number of repeats
        int repeats = maxRepeats(dna);
        // output diagnose
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats));
    }
}
