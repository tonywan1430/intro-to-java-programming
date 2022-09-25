public class RandomWalkers {
    public static void main(String[] args){
        // read parameters from input;
        int r = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        // define average sum all steps in each trial;
        int average = 0;
        // use a for loop to simulate Random Walk;
        for(int k = 1; k <= trails; k++){
            int x = 0;
            int y = 0;
            int steps = 0;
            int d = Math.abs(x) + Math.abs(y);
            while(d < r){
                double q = Math.random();
                if(q < 0.25){
                    x++;
                }
                else{
                    if(q < 0.5){
                        x--;
                    }
                    else{
                        if(q < 0.75){
                            y++;
                        }
                        else{
                            y--;
                        }
                    }
                }
                d = Math.abs(x) + Math.abs(y);
                steps ++;
            }
            // add steps to average;
            average += steps;
        }
        // print average / trails
        System.out.println("average number of steps = " + (float) average / trails);
    }
}
