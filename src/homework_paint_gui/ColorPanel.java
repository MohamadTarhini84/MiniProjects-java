/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework_paint_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class ColorPanel extends JPanel{
    public class ColorButton extends JPanel{
        Color color;
 
        public ColorButton(Color color){
            this.color=color;
            setBorder(BorderFactory.createLineBorder(Color.black));
            setOpaque(true);
            setPreferredSize(new Dimension(30,30));
            setBackground(color);
        }
    }
    
    public ColorPanel(){
        Color[] colors={
                Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
                Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE,
                Color.PINK, Color.RED, Color.WHITE, Color.YELLOW,
                Color.lightGray, new Color(255,50,50), new Color(50,255,50),
                new Color(50,50,255) 
            };
        setLayout(new GridBagLayout());
        for(Color item:colors){
            add(new ColorButton(item));
        }
        JButton RGB=new JButton("RGB Color");
        
        RGB.addActionListener((ActionEvent e) -> {
            RGBColorMaker test=new RGBColorMaker();
            test.setVisible(true);
        });
        
        add(RGB);
    }
    
}
