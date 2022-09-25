public class RandomWalker {
    public static void main(String[] args){
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        System.out.println("r = " + r);
        // print the initial location;
        System.out.println("(" + x + ", " + y + ")");
        // define d as Manhattan distance;
        int d = Math.abs(x) + Math.abs(y);
        // define steps as the number of steps of Random Walk;
        int steps = 0;
        while(d < r){
            // generate random number;
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
            // update distance;
            d = Math.abs(x) + Math.abs(y);
            // update steps;
            steps++;
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
