/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class MainPage extends JFrame implements ActionListener{
    JPanel middle=new JPanel();
    JButton addBook=new JButton("Add Book");
    JButton search=new JButton("Search");
    JButton addAuthor=new JButton("Add Author");
    JButton addPublisher=new JButton("Add Publisher");
    
    public MainPage(String bgPath){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("LMS Project");
        
        JLabel background=new JLabel(new ImageIcon(bgPath));
        background.setLayout(new GridBagLayout());
        add(background);
        
        middle.setLayout(new GridLayout(2,2,5,5));
        addBook.addActionListener(this);
        search.addActionListener(this);
        addPublisher.addActionListener(this);
        addAuthor.addActionListener(this);
        middle.add(addBook);
        middle.add(search);
        middle.add(addAuthor);
        middle.add(addPublisher);
        middle.setPreferredSize(new Dimension(300,300));
        
        background.add(middle);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBook) {
            new AddInfoPage(this,"book").setVisible(true);
            setEnabled(false);
        }
        else if(e.getSource() == search ) {
            new SearchPage().setVisible(true);
        }
        else if(e.getSource()==addAuthor){
            new AddInfoPage(this,"author").setVisible(true);
            setEnabled(false);
        }
        else{
            System.out.println("ok");
        }
    }
}
