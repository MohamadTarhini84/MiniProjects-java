/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework_paint_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
public class RGBColorMaker extends JFrame implements ChangeListener{
    JLabel red=new JLabel("Red: "),
           green=new JLabel("Green: "),
           blue=new JLabel("Blue: "),
           lred=new JLabel("128"),
           lgreen=new JLabel("128"),
           lblue=new JLabel("128");
    
    JSlider reds=new JSlider(JSlider.HORIZONTAL,0,255,128),
            greens=new JSlider(JSlider.HORIZONTAL,0,255,128),
            blues=new JSlider(JSlider.HORIZONTAL,0,255,128);
    
    JPanel preview=new JPanel();
    
    public RGBColorMaker(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 160);
        setTitle("RGB Color Maker");
        setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        
            gbc.anchor=GridBagConstraints.LINE_START;
            gbc.insets=new Insets(4, 4, 4, 4);
            gbc.fill=GridBagConstraints.HORIZONTAL;
            
            gbc.gridy=1;
            add(red,gbc);
        
            gbc.gridy=2;
            add(green,gbc);
        
            gbc.gridy=3;
            add(blue,gbc);
        
            reds.setPreferredSize(new Dimension(200,20));
            reds.addChangeListener(this);
            gbc.gridx=1;
            gbc.gridy=1;
            add(reds,gbc);
            
            greens.setPreferredSize(new Dimension(200,20));
            greens.addChangeListener(this);
            gbc.gridy=2;
            add(greens,gbc);
        
            blues.setPreferredSize(new Dimension(200,20));
            blues.addChangeListener(this);
            gbc.gridy=3;
            add(blues,gbc);
        
            gbc.gridx=2;
            gbc.gridy=1;
            add(lred,gbc);
            gbc.gridy=2;
            add(lgreen,gbc);
            gbc.gridy=3;
            add(lblue,gbc);
            
            preview.setPreferredSize(new Dimension(70,80));
            preview.setBackground(Color.red);
            preview.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            gbc.gridx=3;
            gbc.gridy=0;
            gbc.gridheight=5;
            gbc.anchor=GridBagConstraints.CENTER;
            add(preview,gbc);
    }
    
    @Override
    public void stateChanged(ChangeEvent e){
        if(e.getSource()==reds){
            lred.setText(""+reds.getValue());
        } else if(e.getSource()==greens){
            lgreen.setText(""+greens.getValue());
        } else if(e.getSource()==blues){
            lblue.setText(""+blues.getValue());
        } 
        preview.setBackground(new Color(reds.getValue(),greens.getValue(),blues.getValue()));
    }
}
