/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author HP
 */
public class AddBook extends JPanel implements ActionListener{
        JTextField titleText=new JTextField();
        JTextField isbnText=new JTextField();
        static JComboBox authorCombo;
        JComboBox publisherCombo;
        JTextArea abstractText=new JTextArea();
        JButton addButton=new JButton("Add");
        JButton cancelButton=new JButton("Cancel");
        JFrame parent;
        
        public AddBook(JFrame frame){
            parent=frame;
            String[] dummyOptions={"Test","Hello","bob"};
            authorCombo=new JComboBox();
            publisherCombo=new JComboBox(dummyOptions);
            
            setBorder(new EmptyBorder(0, 10, 0, 10));
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(600,400));
            GridBagConstraints gbc=new GridBagConstraints();
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.anchor=GridBagConstraints.LINE_START;
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.gridwidth=2;
            
            JPanel buttons=new JPanel();
            addButton.addActionListener(this);
            cancelButton.addActionListener(this);
            buttons.add(addButton);
            buttons.add(cancelButton);
            
            add(new JLabel("Please enter the title: "),gbc);
            gbc.gridy=1;
            add(titleText,gbc);
            gbc.gridy=2;
            add(new JLabel("Please enter the ISBN: "),gbc);
            gbc.gridy=3;
            add(isbnText,gbc);
            gbc.gridy=4;
            gbc.gridwidth=1;
            add(new JLabel("Select Author: "),gbc);
            gbc.gridx=0;
            getAuthors();
            authorCombo.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
            add(authorCombo,gbc);
            gbc.gridy=5;
            add(new JLabel("Select Publisher: "),gbc);
            publisherCombo.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
            add(publisherCombo,gbc);
            gbc.gridwidth=2;
            gbc.gridy=6;
            add(new JLabel("Abstract: "),gbc);
            gbc.gridy=7;
            abstractText.setPreferredSize(new Dimension(10,100));
            abstractText.setBorder(BorderFactory.createLineBorder(Color.black, 5));
            add(abstractText,gbc);
            gbc.gridy=8;
            gbc.gridwidth=4;
            gbc.anchor=GridBagConstraints.CENTER;
            gbc.fill=GridBagConstraints.VERTICAL;
            add(buttons,gbc);
            gbc.anchor=GridBagConstraints.LAST_LINE_START;
            gbc.fill=GridBagConstraints.BOTH;
            gbc.gridy=9;
        }
        
        public static void getAuthors(){
            try {
                Statement st=DBManager.getConnection().createStatement();
                
                ResultSet res=st.executeQuery("SELECT * FROM authors");
                
                while(res.next()){
                    authorCombo.addItem(res.getString(2)+" "+res.getString(3));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
                AddInfoPage.setError("Make sure you've entered all fiels");
            }
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            Object source=e.getSource();
            if(source==cancelButton){
                parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
            } 
            if(source==addButton){
                if(titleText.getText().isEmpty() 
                        || isbnText.getText().isEmpty()){
                    AddInfoPage.setError("Make sure you've entered all fields");
                } else{
                    try{
                        Integer.parseInt(isbnText.getText());
                    }catch(NumberFormatException ex){
                        AddInfoPage.setError("Make sure you've entered an integer for isbn");
                        return;
                    }
                    String abst;
                    if(abstractText.getText().isEmpty()){
                        abst="No abstract provided.";
                    } else{
                        abst=abstractText.getText();
                    }
                    AddInfoPage.insertInfo("INSERT INTO "
                            + "books(title,isbn,author,publisher,abstract) "
                            + "values('"+titleText.getText()+"','"+isbnText.getText()+"',"
                            + "'"+authorCombo.getSelectedItem()+"',"
                            + "'"+publisherCombo.getSelectedItem()+"',"
                            + "'"+abst+"')");
                }
            }
        }
    }
