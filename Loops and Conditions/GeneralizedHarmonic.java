public class GeneralizedHarmonic{
    public static void main(String[] args){
        // read parameters: int n and double r;
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        // declare res as result;
        double res = 0;
        for(int i=1; i<=n; i++){
            res += 1.0 / (Math.pow(i,r));
        }
        System.out.println(res);
    }
}
