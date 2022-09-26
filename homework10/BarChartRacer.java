import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // read inputs: filename and number of record in chart
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(filename);
        // read title, xAxisLabel and dataSource
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();
        // read one blank line;
        in.readLine();
        // create new BarChart: chart
        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        // initial caption
        String caption = "";

        // enable double buffering
        StdDraw.enableDoubleBuffering();
        // set canvas size
        StdDraw.setCanvasSize(800, 500);

        // read line of records
        while (in.hasNextLine()) {
            // groupNum: number of records in each group;
            int groupNum = Integer.parseInt(in.readLine());
            // create Array of Bars
            Bar[] bars = new Bar[groupNum];
            for (int i = 0; i < groupNum; i++) {
                String recordLine = in.readLine();
                // StdOut.println(recordLine);
                String[] record = recordLine.split(",");
                // record (year, name, country, value, category)
                // update: year as caption
                caption = record[0];
                String name = record[1];
                // String country = record[2];
                int value = Integer.parseInt(record[3]);
                String category = record[4];
                // create new Bar
                bars[i] = new Bar(name, value, category);
            }
            // read one blank line;
            in.readLine();
            chart.setCaption(caption);
            // sort Arrays of bars
            Arrays.sort(bars);
            // add Top k Bars to BarChart (in descending order)
            for (int i = groupNum - 1; i >= groupNum - k; i--) {
                // add bar[i]
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            // clean the screen;
            StdDraw.clear();
            // draw the bar chart;
            chart.draw();
            // display the bar chart on the screen
            StdDraw.show();
            // leave the bar chart on the screen for 50 Millisecond
            StdDraw.pause(50);
            // reset chart;
            chart.reset();
        }
    }
}
