/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class SearchPage extends JFrame{
    SearchForm test=new SearchForm(this);
    static JPanel results=new JPanel();
    static JFrame parent;
    
    public SearchPage(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setTitle("LMS Project");
        
        parent=this;
        
        results.setLayout(new GridBagLayout());
        
        add(test,BorderLayout.NORTH);
        add(results,BorderLayout.CENTER);
        pack();
        
        setVisible(true);
    }
    
    public static void updateResults(ResultSet res) throws SQLException{
        results.removeAll();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        int i=0;
        while(res.next()){
            JPanel row=new JPanel();
            row.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            gbc.gridy=i;
            row.setOpaque(true);
            row.setBackground(Color.lightGray);
            row.setLayout(new GridLayout(1, 5,5,5));
            row.add(new JLabel(res.getString(1)));
            row.add(new JLabel(res.getString(2)));
            row.add(new JLabel(res.getString(3)));
            row.add(new JLabel(res.getString(4)));
            row.add(new JLabel(res.getString(5)));
            results.add(row,gbc);
            i++;
        }
        parent.pack();
        results.repaint();
    }
}
