public class Clock {
    private int hours;
    private int minutes;

    public Clock(int h, int m) {
        hours = h;
        minutes = m;
        if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) {
            // check if argument is in the prescribed bounds
            // raise Exception
            throw new IllegalArgumentException("argument is outside its prescribed bounds");
        }
    }

    public Clock(String s) {
        // check if argument is of this format;
        // check if ":" contains in
        if (s.length() != 5) {
            throw new IllegalArgumentException("wrong format");
        }
        String hourString = s.substring(0, 2);
        String sepString = s.substring(2, 3);
        String minString = s.substring(3, 5);
        if (!sepString.equals(":")) {
            throw new IllegalArgumentException("wrong format");
        }
        this.hours = Integer.parseInt(hourString);
        this.minutes = Integer.parseInt(minString);
        // check if
        if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) {
            // raise Exception
            throw new IllegalArgumentException("argument is outside its prescribed bounds");
        }
    }

    public String toString() {
        String hourString = Integer.toString(hours);
        String minString = Integer.toString(minutes);
        // note: i.e. change "3" to "03" in both hours and minutes;
        if (hourString.length() < 2) {
            hourString = "0" + hourString;
        }
        if (minString.length() < 2) {
            minString = "0" + minString;
        }
        return hourString + ":" + minString;
    }

    public boolean isEarlierThan(Clock that) {
        return (this.hours < that.hours) || (that.hours == this.hours && this.minutes < that.minutes);
    }

    // add one minute to the time on this clock
    public void tic() {
        minutes += 1;
        if (minutes == 60) {
            minutes = 0;
            hours += 1;
            if (hours == 24) {
                hours = 0;
            }
        }
    }

    // Adds delta minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("delta should be non-negative");
        } else {
            // we calculate hours first;
            hours = (hours + (minutes + delta) / 60) % 24;
            minutes = (minutes + delta) % 60;
        }
    }

    // test client in main function
    public static void main(String[] args) {
        // declare new Clock
        Clock myTime = new Clock("07:57");
        StdOut.println(myTime);
        // check valid bounds;
        Clock myTime2 = new Clock("23:57");
        StdOut.println(myTime2);
        // test isEarlierThan
        StdOut.println(myTime.isEarlierThan(myTime2));
        StdOut.println(myTime2.isEarlierThan(myTime));

        // test tic
        myTime.tic();
        StdOut.println(myTime);
        // test toc
        myTime.toc(100);
        StdOut.println(myTime);
    }


}
