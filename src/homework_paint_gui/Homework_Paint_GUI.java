/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homework_paint_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author HP
 */
public class Homework_Paint_GUI {
    static JLabel label=new JLabel("Pen Size: 5");
    static JSlider slider=new JSlider(JSlider.HORIZONTAL,1,9,5);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 450);
        frame.setTitle("GUI Test");
        frame.setLayout(new BorderLayout());
        
        ToolBox box=new ToolBox();
        JPanel north=new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.LEADING));
        north.add(box);
        
        ColorPanel panel=new ColorPanel();
        panel.setPreferredSize(new Dimension(100,100));
        panel.setLayout(new FlowLayout(1));
        
        JPanel test=new JPanel();
        test.setBackground(Color.white);
        test.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        
        JPanel south=new JPanel();
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(1);
        slider.setPreferredSize(new Dimension(200,20));
        slider.addChangeListener(stateChanged(new ChangeEvent(slider)));
        south.add(slider);
        south.add(label);
        
        frame.add(north,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.WEST);
        frame.add(test,BorderLayout.CENTER);
        frame.add(south,BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }

    private static ChangeListener stateChanged(ChangeEvent changeEvent) {
       return new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent e) {
               label.setText("Pen Size: "+slider.getValue());
           }
       };
    }
}
