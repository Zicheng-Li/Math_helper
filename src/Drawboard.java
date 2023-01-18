import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Drawboard {

    ChartFrame frame;
    JFreeChart chart;

    XYPlot plot;

    DrawPanel drawPanel;

    JComboBox<String> Menu_f1;

    int state = 0;

    int set_Windows_size = 10;

    int difficulty = 0;
    
    String [] result_set = {"1", "1", "1", "0"};
    public Drawboard() {
        drawPanel = new DrawPanel();
        chart = drawPanel.draw(set_Windows_size);
        plot = chart.getXYPlot();
        frame = new ChartFrame("Math function generator", chart);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(200, 200);
        Image icon = Toolkit.getDefaultToolkit().getImage("./pic2.png");
        frame.setIconImage(icon);


        JButton quiz = new JButton("Quiz");
        frame.add(quiz);
        quiz.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateQuiz(e);
        	}
        });
        
        JButton enter_Mathfunc = new JButton("Change variable");
        frame.add(enter_Mathfunc);
        enter_Mathfunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 1){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    plot.setDataset(drawPanel.getDataset_ax_m(set_Windows_size, a, b));
                }
                if (state == 2){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    plot.setDataset(drawPanel.getDataset_ax_d(set_Windows_size, a, b));
                }
                if (state == 3){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    double c = Double.parseDouble(result_set[2]);
                    plot.setDataset(drawPanel.getDataset_sin_m(set_Windows_size, a, b, c));
                }
                if (state == 4){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    double c = Double.parseDouble(result_set[2]);
                    plot.setDataset(drawPanel.getDataset_cos_m(set_Windows_size, a, b, c));
                }
                if (state == 5){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    double c = Double.parseDouble(result_set[2]);
                    plot.setDataset(drawPanel.getDataset_tan_m(set_Windows_size, a, b, c));
                }
                if (state == 6){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    double c = Double.parseDouble(result_set[2]);
                    plot.setDataset(drawPanel.getDataset_x_2(set_Windows_size, a, b, c));
                }
                if (state == 7){
                    result_set = updateMathfunc(e);
                    for(int i = 0; i < result_set.length; i++){
                        if(result_set[i] == null){
                            result_set[i] = "1";
                        }
                        if (i == 3){
                            result_set[i] = "0";
                        }
                    }
                    double a = Double.parseDouble(result_set[0]);
                    double b = Double.parseDouble(result_set[1]);
                    double c = Double.parseDouble(result_set[2]);
                    double d = Double.parseDouble(result_set[3]);
                    plot.setDataset(drawPanel.getDataset_x_3(set_Windows_size, a, b, c, d));
                }



            }
        });



        JButton button_Panel_enlarge = new JButton("+");
        frame.add(button_Panel_enlarge);
        button_Panel_enlarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart_enlarge(e);
            }
        });

        JButton button_Panel_reduce = new JButton("-");
        frame.add(button_Panel_reduce);
        button_Panel_reduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart_reduce(e);
            }
        });

        JButton button_Panel_reset = new JButton("Reset");
        frame.add(button_Panel_reset);
        button_Panel_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart_reset(e);
            }
        });


        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                if (ItemEvent.SELECTED == arg0.getStateChange()) {
                    String selectedItem = arg0.getItem().toString();
                    result_set = new String[]{"1", "1", "1", "0"};

                    if(selectedItem.equals("(a * x) + b")){
                    	difficulty = 1;
                        state = 1;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_ax_m(set_Windows_size, 1 ,0));
                    }
                    if(selectedItem.equals("(a / x) + b")){
                    	difficulty = 1;
                        state = 2;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_ax_d(set_Windows_size, 1, 0));
                    }
                    if(selectedItem.equals("a * sin(b * x) + c")){
                    	difficulty = 2;
                        state = 3;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_sin_m(set_Windows_size, 1, 1, 0));
                    }
                    if(selectedItem.equals("a * cos(b * x) + c")){
                    	difficulty = 2;
                        state = 4;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_cos_m(set_Windows_size, 1, 1, 0));
                    }
                    if(selectedItem.equals("a * tan(b * x) + c")){
                    	difficulty = 2;
                        state = 5;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_tan_m(set_Windows_size, 1, 1, 0));
                    }
                    if(selectedItem.equals("a * x^2 + b * x + c")){
                    	difficulty = 3;
                        state = 6;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_x_2(set_Windows_size, 1, 1, 0));
                    }
                    if(selectedItem.equals("a * x^3 + b * x^2 + c * x + d")){
                    	difficulty = 3;
                        state = 7;
                        set_Windows_size = 10;
                        plot.setDataset(drawPanel.getDataset_x_3(set_Windows_size, 1, 1, 1, 0));
                    }
                }
            }
        };


        Menu_f1 = new JComboBox<String>();
        Menu_f1.addItemListener(itemListener);
        Menu_f1.addItem("(a * x) + b");
        Menu_f1.addItem("(a / x) + b");
        Menu_f1.addItem("a * sin(b * x) + c");
        Menu_f1.addItem("a * cos(b * x) + c");
        Menu_f1.addItem("a * tan(b * x) + c");
        Menu_f1.addItem("a * x^2 + b * x + c");
        Menu_f1.addItem("a * x^3 + b * x^2 + c * x + d");
        Menu_f1.addItem("Coming Soon!");
        frame.add(Menu_f1);


        JButton button_Panel_tips = new JButton("Tips");
        frame.add(button_Panel_tips);
        button_Panel_tips.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart_tips(e);
            }
        });


        frame.pack();
        frame.setVisible(true);

    }

    private void updateChart_enlarge(ActionEvent e) {
        set_Windows_size --;
        if (state == 1){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            plot.setDataset(drawPanel.getDataset_ax_m(set_Windows_size, a, b));
        }
        if (state == 2){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            plot.setDataset(drawPanel.getDataset_ax_d(set_Windows_size, a, b));
        }
        if (state == 3){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_sin_m(set_Windows_size, a, b, c));
        }
        if (state == 4){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_cos_m(set_Windows_size, a, b, c));
        }
        if (state == 5){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_tan_m(set_Windows_size, a, b, c));
        }
        if (state == 6){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_x_2(set_Windows_size, a, b, c));
        }
        if (state == 7){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            double d = Double.parseDouble(result_set[3]);
            plot.setDataset(drawPanel.getDataset_x_3(set_Windows_size, a, b, c, d));
        }
    }

    private void updateChart_reduce(ActionEvent e) {
        set_Windows_size ++;
        if (state == 1){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            plot.setDataset(drawPanel.getDataset_ax_m(set_Windows_size, a, b));
        }
        if (state == 2){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            plot.setDataset(drawPanel.getDataset_ax_d(set_Windows_size, a, b));
        }
        if (state == 3){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_sin_m(set_Windows_size, a, b, c));
        }
        if (state == 4){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_cos_m(set_Windows_size, a, b, c));
        }
        if (state == 5){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_tan_m(set_Windows_size, a, b, c));
        }
        if (state == 6){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            plot.setDataset(drawPanel.getDataset_x_2(set_Windows_size, a, b, c));
        }
        if (state == 7){
            double a = Double.parseDouble(result_set[0]);
            double b = Double.parseDouble(result_set[1]);
            double c = Double.parseDouble(result_set[2]);
            double d = Double.parseDouble(result_set[3]);
            plot.setDataset(drawPanel.getDataset_x_3(set_Windows_size, a, b, c, d));
        }

    }

    private void updateChart_reset(ActionEvent e) {
        set_Windows_size = 10;
        for(int i = 0; i < result_set.length; i++){
            if(i == 3){
                result_set[i] = "0";
            }
            result_set[i] = "1";

        }

        if (state == 1){
            plot.setDataset(drawPanel.getDataset_ax_m(set_Windows_size, 1, 1));
        }
        if (state == 2){
            plot.setDataset(drawPanel.getDataset_ax_d(set_Windows_size, 1, 1));
        }
        if (state == 3){
            plot.setDataset(drawPanel.getDataset_sin_m(set_Windows_size, 1, 1, 1));
        }
        if (state == 4){
            plot.setDataset(drawPanel.getDataset_cos_m(set_Windows_size, 1, 1, 1));
        }
        if (state == 5){
            plot.setDataset(drawPanel.getDataset_tan_m(set_Windows_size, 1, 1, 1));
        }
        if (state == 6){
            plot.setDataset(drawPanel.getDataset_x_2(set_Windows_size, 1, 1, 1));
        }
        if (state == 7){
            plot.setDataset(drawPanel.getDataset_x_3(set_Windows_size, 1, 1, 1, 0));
        }

    }

    private void updateChart_tips(ActionEvent e) {
        new Msgtip();
    }
    
    private void updateQuiz(ActionEvent e) {
    	quiz quiz = new quiz();
    	ArrayList<questions> qList = quiz.generateQuiz(1);
    	 String answer;
         for (int i = 0;i < qList.size();i++){
             questions question = qList.get(i);
             String option = "";
             
             for(int n = 0; n < question.getOptions().length; n++) {
            	 option = option + question.getOptions()[n]+ "    ";
             }
             
             answer = (String)JOptionPane.showInputDialog(
                     frame,
                     option,
                     question.getQuestion(),
                     JOptionPane.PLAIN_MESSAGE,
                     null,
                     null,
                     "0"
             );
             if(!answer.equals(question.getAnswer())) {
            	 JOptionPane.showInputDialog(
                     frame,
                     "Sorry, the correct answer is:" + question.getAnswer(),
                     question.getQuestion(),
                     JOptionPane.PLAIN_MESSAGE,
                     null,
                     null,
                     "0"
            );
             }else {
            	 JOptionPane.showInputDialog(
                         frame,
                         "You are correct!",
                         question.getQuestion(),
                         JOptionPane.PLAIN_MESSAGE,
                         null,
                         null,
                         "0"
                );
             }
         }
    }
    
    private String [] updateMathfunc(ActionEvent e) {
        if (state == 1 || state == 2){
            String result_a = (String)JOptionPane.showInputDialog(
                    frame,
                    "a",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String result_b = (String)JOptionPane.showInputDialog(
                    frame,
                    "b",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String [] result_set = {result_a, result_b};
            return result_set;
        }

        if (state == 3 || state == 4 || state == 5 || state == 6){
            String result_a = (String)JOptionPane.showInputDialog(
                    frame,
                    "a",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String result_b = (String)JOptionPane.showInputDialog(
                    frame,
                    "b",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String result_c = (String)JOptionPane.showInputDialog(
                    frame,
                    "c",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String [] result_set = {result_a, result_b, result_c};
            return result_set;
        }

        if(state == 7){
            String result_a = (String)JOptionPane.showInputDialog(
                    frame,
                    "a",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String result_b = (String)JOptionPane.showInputDialog(
                    frame,
                    "b",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String result_c = (String)JOptionPane.showInputDialog(
                    frame,
                    "c",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String result_d = (String)JOptionPane.showInputDialog(
                    frame,
                    "d",
                    "Please enter a mathematical function：",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "0"
            );
            String [] result_set = {result_a, result_b, result_c, result_d};
            return result_set;
        }
        return result_set;
    }

}

class Msgtip extends JDialog{
    public Msgtip(){
        this.setVisible(true);
        this.setBounds(100,100,400,300);
        JLabel label = new JLabel("<html><h3>1. Hold down the left mouse button and drag it to the lower right corner to enlarge the image of the specified area.<br/>" +
                "2. Hold down the left mouse button and drag it to the upper to cancel the zooming of the image.<br/>" +
                "3. Use the Reset button to reset the image to its initial state.<br/>" +
                "4. Use the '+' or '-' buttons to decrease or increase  the X-axis coordinates<br/>" +
                "</h3></html>");
        this.add(label);
        label.setHorizontalAlignment(SwingConstants.LEFT);

    }
}
//class Msgquiz extends JDialog{
//	
//	public Msgquiz(int difficulty) {
//
//		quiz quiz = new quiz();
//		ArrayList<questions> qList = quiz.generateQuiz(difficulty);
//		quiz.printQuiz(qList);
//
//	}
//
//}
