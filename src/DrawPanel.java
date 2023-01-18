import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel {
    public XYSeriesCollection getDataset_ax_m(int change_size, double a, double b){
        XYSeries series_1 = new XYSeries("(a * x) + b");
        for (double x = 0.0 - change_size; x < change_size; x = x + 0.01) {
            double y = a * x + b;
            series_1.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);

        return dataset;
    }


    public XYSeriesCollection getDataset_ax_d(int change_size, double a, double b){
        XYSeries series_1 = new XYSeries("(a / x) + b");
        XYSeries series_2 = new XYSeries("(a / x) + b");
        for (double x = 0.1; x < change_size; x = x + 0.01) {
            if (x == 0){
                continue;
            }
            double y = a / x + b;
            series_1.add(x, y);
        }

        for (double x = -0.1; x > - change_size; x = x - 0.01) {
            if (x == 0){
                continue;
            }
            double y = a / x + b;
            series_2.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);
        dataset.addSeries(series_2);

        return dataset;
    }

    public XYSeriesCollection getDataset_sin_m(int change_size, double a, double b, double c){
        XYSeries series_1 = new XYSeries("a * sin(b * x) + c");
        for (double x = 0.0 - change_size; x < change_size; x = x + 0.01) {
            if (x == 0){
                continue;
            }
            double y = a * Math.sin(b * x) + c;
            series_1.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);

        return dataset;
    }

    public XYSeriesCollection getDataset_cos_m(int change_size, double a, double b, double c){
        XYSeries series_1 = new XYSeries("a * cos(b * x) + c");
        for (double x = 0.0 - change_size; x < change_size; x = x + 0.01) {
            if (x == 0){
                continue;
            }
            double y = a * Math.cos(b * x) + c;
            series_1.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);

        return dataset;
    }

    public XYSeriesCollection getDataset_tan_m(int change_size, double a, double b, double c){
        XYSeries series_1 = new XYSeries("a * tan(b * x) + c");
        for (double x = 0.0 - change_size; x < change_size; x = x + 0.01) {
            if (x == 0){
                continue;
            }
            double y = a * Math.tan(b * x) + c;
            if(y > 10 || y < -10){
                continue;
            }
            series_1.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);

        return dataset;
    }

    public XYSeriesCollection getDataset_x_2(int change_size, double a, double b, double c){
        XYSeries series_1 = new XYSeries("a * x^2 + b * x + c");
        for (double x = 0.0 - change_size; x < change_size; x = x + 0.01) {
            if (x == 0){
                continue;
            }
            double y = a * x * x + b * x + c;
            series_1.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);

        return dataset;
    }

    public XYSeriesCollection getDataset_x_3(int change_size, double a, double b, double c, double d){
        XYSeries series_1 = new XYSeries("a * x^3 + b * x^2 + c * x + d");
        for (double x = 0.0 - change_size; x < change_size; x = x + 0.01) {
            if (x == 0){
                continue;
            }
            double y = a * x * x * x + b * x * x + c * x + d;
            series_1.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series_1);

        return dataset;
    }





    public JFreeChart draw(int input){

        XYSeriesCollection dataset = getDataset_ax_m(input, 1 ,0);

        JFreeChart chart = ChartFactory.createXYLineChart(
                " ", // chart title
                "x", // x axis label
                "y", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );

        return chart;
    }

}


